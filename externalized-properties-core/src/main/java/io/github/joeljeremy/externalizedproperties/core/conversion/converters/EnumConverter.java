package io.github.joeljeremy.externalizedproperties.core.conversion.converters;

import io.github.joeljeremy.externalizedproperties.core.ConversionResult;
import io.github.joeljeremy.externalizedproperties.core.Converter;
import io.github.joeljeremy.externalizedproperties.core.InvocationContext;
import io.github.joeljeremy.externalizedproperties.core.TypeUtilities;
import io.github.joeljeremy.externalizedproperties.core.conversion.ConversionException;
import java.lang.reflect.Type;
import java.util.Arrays;

/**
 * Supports conversion of values to enums.
 */
public class EnumConverter implements Converter<Enum<?>> {

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
    public ConversionResult<Enum<?>> convert(InvocationContext context, String valueToConvert, Type targetType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
