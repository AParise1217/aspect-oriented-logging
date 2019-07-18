package com.parisesoftware.logging.internal

/**
 * The Timing for when a Pointcut was Triggered
 *
 * @version 1.0
 * @since 1.0
 */
enum AspectTiming {

    /**
     * Before the Join Point starts executing
     */
    BEFORE_EXECUTION,

    /**
     * After the Join Point finishes executing, whether by an Exception or Normally
     */
    AFTER_EXECUTION,

    /**
     * After the Join Point finishes executing Normally
     */
    AFTER_RETURNING,

    /**
     * After the Join Point finishes executing by an Exception
     */
    AFTER_THROWING

}
