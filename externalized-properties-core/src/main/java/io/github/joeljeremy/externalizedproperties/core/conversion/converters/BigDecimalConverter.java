package io.github.joeljeremy.externalizedproperties.core.conversion.converters;

import io.github.joeljeremy.externalizedproperties.core.ConversionResult;
import io.github.joeljeremy.externalizedproperties.core.Converter;
import io.github.joeljeremy.externalizedproperties.core.InvocationContext;
import java.lang.reflect.Type;
import java.math.BigDecimal;

/**
 * Supports conversion of values to a {@link BigDecimal}.
 */
public class BigDecimalConverter implements Converter<BigDecimal> {

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
    public ConversionResult<BigDecimal> convert(InvocationContext context, String valueToConvert, Type targetType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
