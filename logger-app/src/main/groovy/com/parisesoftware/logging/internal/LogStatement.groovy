package com.parisesoftware.logging.internal

import org.apache.commons.lang3.StringUtils
import org.apache.commons.lang3.builder.ToStringBuilder

/**
 * Log Statement
 * <p>
 * a POJO for the attributes of a statement written to the Logs
 *  by {@link com.parisesoftware.logging.LoggingAspect}
 *
 * @version 1.0
 * @since 1.0
 */
class LogStatement {

    AspectTiming timing

    String className

    String methodName

    String methodArguments

    Object returnValue

    Throwable error

    @Override
    String toString() {
        ToStringBuilder toStringBuilder = new ToStringBuilder(this)

        appendIfNotNull(toStringBuilder, 'Timing', timing)
        appendIfNotNull(toStringBuilder, 'Class', className)
        appendIfNotNull(toStringBuilder, 'Method', methodName)
        appendIfNotNull(toStringBuilder, 'Args', methodArguments)
        appendIfNotNull(toStringBuilder, 'Returned', returnValue)
        appendIfNotNull(toStringBuilder, 'Error', error)

        return toStringBuilder.toString()
    }

    /**
     * Appends the given Object ofInterest to theToStringBuilder, if it is not null
     * @param theToStringBuilder
     * @param fieldName
     * @param fieldValue
     */
    private void appendIfNotNull(ToStringBuilder theToStringBuilder,
                                 final String fieldName,
                                 final Object fieldValue) {
        if(fieldValue != null) {
            theToStringBuilder.append(fieldName, fieldValue)
        }
    }

    /**
     * Appends the given String ofInterest to theToStringBuilder, if it is not null or blank
     * @param theToStringBuilder
     * @param fieldName
     * @param fieldValue
     */
    private void appendIfNotNull(ToStringBuilder theToStringBuilder,
                                 final String fieldName,
                                 final String fieldValue) {
        if(StringUtils.isNotEmpty(fieldValue)) {
            theToStringBuilder.append(fieldName, fieldValue)
        }
    }

}
