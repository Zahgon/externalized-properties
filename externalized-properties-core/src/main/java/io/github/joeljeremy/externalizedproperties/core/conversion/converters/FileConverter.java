package io.github.joeljeremy.externalizedproperties.core.conversion.converters;

import io.github.joeljeremy.externalizedproperties.core.ConversionResult;
import io.github.joeljeremy.externalizedproperties.core.Converter;
import io.github.joeljeremy.externalizedproperties.core.InvocationContext;
import java.io.File;
import java.lang.reflect.Type;

/**
 * Supports conversion of values to a {@link File}.
 */
public class FileConverter implements Converter<File> {

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
    public ConversionResult<File> convert(InvocationContext context, String valueToConvert, Type targetType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
