package com.parisesoftware.logging

import com.parisesoftware.logging.internal.AspectTiming
import com.parisesoftware.logging.internal.LogStatement
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.*

/**
 * {@inheritDoc}
 *
 * <p>
 * Factory Logger
 *
 * @version 1.0
 * @since 1.0
 */
@Aspect
class FactoryLoggingAspect extends LoggingAspect {

    @Pointcut('execution(* com.parisesoftware..*Factory.*(..))')
    void theFactories() {}

    @Before('theFactories() && noMetaClassMethods()')
    void beforeMethodInvocation(final JoinPoint aJoinPoint) {
        final LogStatement logStatement =
                this.logStatementFactory.createLogStatement(aJoinPoint, AspectTiming.BEFORE_EXECUTION)
        writeToLogs(logStatement)
    }

    @After('theFactories() && noMetaClassMethods()')
    void afterMethodInvocation(final JoinPoint aJoinPoint) {
        final LogStatement logStatement =
                this.logStatementFactory.createLogStatement(aJoinPoint, AspectTiming.AFTER_EXECUTION)
        writeToLogs(logStatement)
    }

    @AfterReturning(pointcut = 'theFactories() && noMetaClassMethods()', returning = 'theReturnValue')
    void afterReturningMethodInvocation(final JoinPoint aJoinPoint, final Object theReturnValue) {
        final LogStatement logStatement =
                this.logStatementFactory.createLogStatement(aJoinPoint, AspectTiming.AFTER_RETURNING, theReturnValue)
        writeToLogs(logStatement)
    }

    @AfterThrowing(pointcut = 'theFactories() && noMetaClassMethods()', throwing = 'theThrownError')
    void afterThrowingMethodInvocation(final JoinPoint aJoinPoint, final Throwable theThrownError) {
        final LogStatement logStatement =
                this.logStatementFactory.createLogStatement(aJoinPoint, AspectTiming.AFTER_THROWING, theThrownError)
        writeToLogs(logStatement)
    }

}
