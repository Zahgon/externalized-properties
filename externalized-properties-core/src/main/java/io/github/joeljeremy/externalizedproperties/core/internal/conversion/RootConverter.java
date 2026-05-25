package io.github.joeljeremy.externalizedproperties.core.internal.conversion;

import static io.github.joeljeremy.externalizedproperties.core.internal.Arguments.requireNonNull;
import io.github.joeljeremy.externalizedproperties.core.ConversionResult;
import io.github.joeljeremy.externalizedproperties.core.Converter;
import io.github.joeljeremy.externalizedproperties.core.ExternalizedProperties;
import io.github.joeljeremy.externalizedproperties.core.InvocationContext;
import io.github.joeljeremy.externalizedproperties.core.TypeUtilities;
import io.github.joeljeremy.externalizedproperties.core.conversion.ConversionException;
import io.github.joeljeremy.externalizedproperties.core.conversion.converters.OptionalConverter;
import io.github.joeljeremy.externalizedproperties.core.internal.Internal;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * The root {@link Converter}. All requests to convert properties are routed through this converter
 * and delegated to the registered {@link Converter}s.
 */
@Internal
public class RootConverter implements Converter<Object> {

    private final ConvertersByTargetType convertersByTargetType;

    /**
     * Constructor.
     *
     * @param converters The collection of {@link Converter}s to handle the actual conversion.
     */
    public RootConverter(Converter<?>... converters) {
        this(Arrays.asList(requireNonNull(converters, "converters")));
    }

    /**
     * Constructor.
     *
     * @param converters The collection of {@link Converter}s to handle the actual conversion.
     */
    public RootConverter(Collection<Converter<?>> converters) {
        this.convertersByTargetType = new ConvertersByTargetType(requireNonNull(converters, "converters"));
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

    // Skip conversion result is a singleton, cache it here to avoid internal casting.
    private static final ConversionResult<?> SKIP_RESULT = ConversionResult.skip();

    private static boolean skipped(ConversionResult<?> result) {
        return result.equals(SKIP_RESULT);
    }

    /**
     * Maps a list of {@link Converter} instances to target types.
     */
    private static class ConvertersByTargetType extends ClassValue<List<Converter<Object>>> {

        private final List<Converter<?>> registeredConverters;

        /**
         * Constructor.
         *
         * @param registeredConverters The registered {@link ConverterProvider} instances.
         */
        ConvertersByTargetType(Collection<Converter<?>> registeredConverters) {
            this.registeredConverters = setupOutOfTheBoxConverters(registeredConverters);
        }

        /**
         * This method will return a list of {@link Converter} instances based on the specified target
         * type.
         *
         * @param targetType The target type to convert to.
         * @return The list of {@link Converter} instances which support conversion to the target type.
         */
        @Override
        protected List<Converter<Object>> computeValue(Class<?> targetType) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private static List<Converter<?>> setupOutOfTheBoxConverters(Collection<Converter<?>> original) {
            List<Converter<?>> converters = new ArrayList<>(original);
            registerOptionalConverterIfNecessary(converters);
            return converters;
        }

        private static void registerOptionalConverterIfNecessary(List<Converter<?>> converters) {
            // Add if no OptionalConverter was explicitly added.
            if (converters.stream().noneMatch(c -> c.canConvertTo(Optional.class))) {
                // Optional conversion is natively supported out of the box.
                converters.add(new OptionalConverter());
            }
        }
    }
}
