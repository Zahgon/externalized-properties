package io.github.joeljeremy.externalizedproperties.git.internal;

import org.jspecify.annotations.Nullable;

/**
 * Arguments-related utility methods.
 */
public class Arguments {

    private static final String MUST_NOT_BE_NULL = " must not be null.";

    private static final String MUST_NOT_BE_NULL_OR_BLANK = " must not be null or blank.";

    private Arguments() {
    }

    /**
     * Require argument to not be {@code null}.
     *
     * @param <T> The type of the argument.
     * @param arg The argument.
     * @param argName The name of the argument to be used in building the {@link
     *     IllegalArgumentException} message if the argument failed validation.
     * @return The argument.
     */
    public static <T> T requireNonNull(@Nullable T arg, String argName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Require argument to not be {@code null} or a blank {@link String}.
     *
     * @param arg The {@link String} argument.
     * @param argName The name of the {@link String} argument to be used in building the {@link
     *     IllegalArgumentException} message if the argument failed validation.
     * @return The {@link String} argument.
     */
    public static String requireNonNullOrBlank(@Nullable String arg, String argName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
