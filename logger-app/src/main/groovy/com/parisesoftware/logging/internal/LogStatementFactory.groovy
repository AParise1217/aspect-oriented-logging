package com.parisesoftware.logging.internal

import groovy.transform.PackageScope
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.Signature

/**
 * Log Statement Factory
 * <p>
 * a Factory to encapsulate creation logic of {@link LogStatement} POJOs
 *
 * @version 1.0
 * @since 1.0
 */
class LogStatementFactory {

    LogStatement createLogStatement(final JoinPoint aJoinPoint,
                                    final AspectTiming theTiming, final Throwable theError) {

        return new LogStatement(timing: theTiming, error: theError,
                className: getClassName(aJoinPoint), methodName: getMethodName(aJoinPoint),
                methodArguments: getMethodArguments(aJoinPoint))
    }

    LogStatement createLogStatement(final JoinPoint aJoinPoint,
                                    final AspectTiming theTiming) {

        return new LogStatement(timing: theTiming,
                className: getClassName(aJoinPoint), methodName: getMethodName(aJoinPoint),
                methodArguments: getMethodArguments(aJoinPoint))
    }

    LogStatement createLogStatement(final JoinPoint aJoinPoint,
                                    final AspectTiming theTiming, final Object theReturnValue) {

        return new LogStatement(timing: theTiming, returnValue: theReturnValue,
                className: getClassName(aJoinPoint), methodName: getMethodName(aJoinPoint),
                methodArguments: getMethodArguments(aJoinPoint))
    }

    /**
     * Fetch the Method Name that was invoked on the JoinPoint
     * @param aJoinPoint to get the Method Name from
     * @return {@code String}
     */
    @PackageScope
    String getMethodName(final JoinPoint aJoinPoint) {
        final Signature signature = aJoinPoint.signature
        return signature.name
    }

    /**
     * Fetch the Class Name that was invoked on the JoinPoint
     * @param aJoinPoint to get the Method Name from
     * @return {@code String}
     */
    @PackageScope
    String getClassName(final JoinPoint aJoinPoint) {
        final Signature signature = aJoinPoint.signature
        return signature.declaringTypeName
    }

    /**
     * Fetch the Method Arguments that was invoked on the JoinPoint
     * @param aJoinPoint to get the Method Args from
     * @return {@code String}
     */
    @PackageScope
    String getMethodArguments(final JoinPoint aJoinPoint) {
        return Arrays.toString(aJoinPoint.args)
    }

}
