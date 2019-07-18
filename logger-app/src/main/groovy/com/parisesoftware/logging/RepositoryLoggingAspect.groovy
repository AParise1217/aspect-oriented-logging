package com.parisesoftware.logging

import com.parisesoftware.logging.internal.AspectTiming
import com.parisesoftware.logging.internal.LogStatement
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.*

/**
 * {@inheritDoc}
 *
 * <p>
 * Repository Logger
 *
 * @version 1.0
 * @since 1.0
 */
@Aspect
class RepositoryLoggingAspect extends LoggingAspect {

    @Pointcut('execution(* com.parisesoftware..*Repository.*(..))')
    void theRepositories() {}

    @Before('theRepositories() && noMetaClassMethods()')
    void beforeMethodInvocation(final JoinPoint aJoinPoint) {
        final LogStatement logStatement =
                this.logStatementFactory.createLogStatement(aJoinPoint, AspectTiming.BEFORE_EXECUTION)
        writeToLogs(logStatement)
    }

    @After('theRepositories() && noMetaClassMethods()')
    void afterMethodInvocation(final JoinPoint aJoinPoint) {
        final LogStatement logStatement =
                this.logStatementFactory.createLogStatement(aJoinPoint, AspectTiming.AFTER_EXECUTION)
        writeToLogs(logStatement)
    }

    @AfterReturning(pointcut = 'theRepositories() && noMetaClassMethods()', returning = 'theReturnValue')
    void afterReturningMethodInvocation(final JoinPoint aJoinPoint, final Object theReturnValue) {
        final LogStatement logStatement =
                this.logStatementFactory.createLogStatement(aJoinPoint, AspectTiming.AFTER_RETURNING, theReturnValue)
        writeToLogs(logStatement)
    }

    @AfterThrowing(pointcut = 'theRepositories() && noMetaClassMethods()', throwing = 'theThrownError')
    void afterThrowingMethodInvocation(final JoinPoint aJoinPoint, final Throwable theThrownError) {
        final LogStatement logStatement =
                this.logStatementFactory.createLogStatement(aJoinPoint, AspectTiming.AFTER_THROWING, theThrownError)
        writeToLogs(logStatement)
    }

}
