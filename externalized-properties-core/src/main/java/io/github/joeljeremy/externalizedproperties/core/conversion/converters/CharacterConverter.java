package io.github.joeljeremy.externalizedproperties.core.conversion.converters;

import io.github.joeljeremy.externalizedproperties.core.ConversionResult;
import io.github.joeljeremy.externalizedproperties.core.Converter;
import io.github.joeljeremy.externalizedproperties.core.InvocationContext;
import io.github.joeljeremy.externalizedproperties.core.conversion.ConversionException;
import java.lang.reflect.Type;

/**
 * Supports conversion of values to a char/Character.
 */
public class CharacterConverter implements Converter<Character> {

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
    public ConversionResult<Character> convert(InvocationContext context, String valueToConvert, Type targetType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
