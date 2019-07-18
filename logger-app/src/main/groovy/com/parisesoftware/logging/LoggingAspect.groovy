package com.parisesoftware.logging

import com.parisesoftware.logging.internal.LogStatement
import com.parisesoftware.logging.internal.LogStatementFactory
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Pointcut
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * Logging Aspect
 * <p>
 * Handler to Cross-Cut the Management of Writing to the Logs
 *
 * @version 1.0
 * @since 1.0
 */
@Aspect
abstract class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect)

    protected LogStatementFactory logStatementFactory

    protected LoggingAspect() {
        this.logStatementFactory = new LogStatementFactory()
    }

    @Pointcut('!execution(* com.parisesoftware..getMetaClass(..))')
    void noMetaClassMethods() {}

    /**
     * Writes a LogStatement to the logs with the Debug Level
     * @param aLogStatement
     */
    protected void writeToLogs(final LogStatement aLogStatement) {
        LOGGER.debug("===${aLogStatement.timing.toString()}===")
        LOGGER.debug(aLogStatement.toString())
        LOGGER.debug('****************************************')
    }

}
