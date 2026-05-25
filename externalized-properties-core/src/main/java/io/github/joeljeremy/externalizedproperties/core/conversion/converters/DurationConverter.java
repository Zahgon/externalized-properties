package io.github.joeljeremy.externalizedproperties.core.conversion.converters;

import io.github.joeljeremy.externalizedproperties.core.ConversionResult;
import io.github.joeljeremy.externalizedproperties.core.Converter;
import io.github.joeljeremy.externalizedproperties.core.InvocationContext;
import io.github.joeljeremy.externalizedproperties.core.conversion.ConversionException;
import java.lang.reflect.Type;
import java.time.Duration;
import java.time.format.DateTimeParseException;

/**
 * Supports conversion of values to a {@link Duration}. This supports values in ISO-8601 duration
 * format and numeric values (in milliseconds).
 */
public class DurationConverter implements Converter<Duration> {

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean canConvertTo(Class<?> targetType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConversionResult<Duration> convert(InvocationContext context, String valueToConvert, Type targetType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static boolean is8601DurationFormat(String valueToConvert) {
        if (valueToConvert.length() > 0) {
            char firstChar = Character.toUpperCase(valueToConvert.charAt(0));
            if (firstChar == 'P') {
                return true;
            }
            if ((firstChar == '+' || firstChar == '-') && valueToConvert.length() > 1) {
                char secondChar = Character.toUpperCase(valueToConvert.charAt(1));
                if (secondChar == 'P') {
                    // +P or -P
                    return true;
                }
            }
        }
        return false;
    }
}
