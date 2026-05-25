package io.github.joeljeremy.externalizedproperties.core.conversion.converters;

import io.github.joeljeremy.externalizedproperties.core.ConversionResult;
import io.github.joeljeremy.externalizedproperties.core.Converter;
import io.github.joeljeremy.externalizedproperties.core.InvocationContext;
import io.github.joeljeremy.externalizedproperties.core.TypeUtilities;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;
import org.jspecify.annotations.Nullable;

/**
 * Default property converter which delegates to the following converters (in order):
 *
 * <ol>
 *   <li>{@link IntegerConverter}
 *   <li>{@link BooleanConverter}
 *   <li>{@link LongConverter}
 *   <li>{@link ShortConverter}
 *   <li>{@link FloatConverter}
 *   <li>{@link DoubleConverter}
 *   <li>{@link CharacterConverter}
 *   <li>{@link ByteConverter}
 *   <li>{@link ListConverter}
 *   <li>{@link ArrayConverter}
 *   <li>{@link SetConverter}
 *   <li>{@link EnumConverter}
 *   <li>{@link DateTimeConverter}
 * </ol>
 */
public class DefaultConverter implements Converter<Object> {

    private final ClassValue<Converter<Object>> convertersByTargetType;

    /**
     * Constructs a {@link DefaultConverter} instance which delegates to the following converters (in
     * order):
     *
     * <ol>
     *   <li>{@link IntegerConverter}
     *   <li>{@link BooleanConverter}
     *   <li>{@link LongConverter}
     *   <li>{@link ShortConverter}
     *   <li>{@link FloatConverter}
     *   <li>{@link DoubleConverter}
     *   <li>{@link CharacterConverter}
     *   <li>{@link ByteConverter}
     *   <li>{@link ListConverter}
     *   <li>{@link ArrayConverter}
     *   <li>{@link SetConverter}
     *   <li>{@link EnumConverter}
     *   <li>{@link DateTimeConverter}
     * </ol>
     */
    public DefaultConverter() {
        convertersByTargetType = new ConvertersByTargetType(// In order.
        Arrays.asList(new IntegerConverter(), new BooleanConverter(), new LongConverter(), new ShortConverter(), new FloatConverter(), new DoubleConverter(), new CharacterConverter(), new ByteConverter(), new ListConverter(), new ArrayConverter(), new SetConverter(), new EnumConverter(), new DateTimeConverter()));
    }

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
    public ConversionResult<Object> convert(InvocationContext context, String valueToConvert, Type targetType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Maps a {@link Converter} instances to target types.
     */
    private static class ConvertersByTargetType extends ClassValue<Converter<Object>> {

        private final Collection<Converter<?>> defaultConverters;

        /**
         * Constructor.
         *
         * @param defaultConverters The default converters.
         */
        ConvertersByTargetType(Collection<Converter<?>> defaultConverters) {
            this.defaultConverters = defaultConverters;
        }

        /**
         * This method will return a {@link Converter} instance based on the specified target type.
         *
         * @param targetType The target type to convert to.
         * @return A {@link Converter} instance which support conversion to the target type.
         */
        @Override
        @Nullable
        protected Converter<Object> computeValue(Class<?> targetType) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
