package io.github.joeljeremy.externalizedproperties.core.internal.processing;

import static io.github.joeljeremy.externalizedproperties.core.internal.Arguments.requireNonNull;
import io.github.joeljeremy.externalizedproperties.core.ExternalizedProperties;
import io.github.joeljeremy.externalizedproperties.core.InvocationContext;
import io.github.joeljeremy.externalizedproperties.core.Processor;
import io.github.joeljeremy.externalizedproperties.core.internal.Internal;
import io.github.joeljeremy.externalizedproperties.core.processing.ProcessWith;
import io.github.joeljeremy.externalizedproperties.core.processing.ProcessingException;
import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * The root {@link Processor}. All requests to process properties are routed through this processor
 * and delegated to the registered {@link Processor}s
 */
@Internal
public class RootProcessor implements Processor {

    private final ProcessorByAnnotationType processorByAnnotationType;

    /**
     * Constructor.
     *
     * @param processors The collection of {@link Processor}s to handle the actual processing.
     */
    public RootProcessor(Processor... processors) {
        this(Arrays.asList(requireNonNull(processors, "processors")));
    }

    /**
     * Constructor.
     *
     * @param processors The collection of {@link Processor}s to handle the actual processing.
     */
    public RootProcessor(Collection<Processor> processors) {
        this.processorByAnnotationType = new ProcessorByAnnotationType(requireNonNull(processors, "processors"));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String process(InvocationContext context, String valueToProcess) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Maps annotation type with processor instance based on the {@link ProcessWith} meta annotation.
     */
    private static class ProcessorByAnnotationType extends ClassValue<Processor> {

        private final Collection<Processor> registeredProcessors;

        /**
         * Constructor.
         *
         * @param registeredProcessors The registered {@link ProcessorProvider} instances.
         */
        ProcessorByAnnotationType(Collection<Processor> registeredProcessors) {
            this.registeredProcessors = registeredProcessors;
        }

        /**
         * This method will return a processor instance based on the specified proxy method annotation
         * type. If the annotation is not annotated with {@link ProcessWith}, {@code null} will be
         * returned. If the annotation is annotated with {@link ProcessWith}, but no registered {@link
         * Processor} instance of the specified type can be found, an exception will be thrown.
         *
         * @param annotationType The proxy method annotation type.
         * @return The {@link Processor} instance, or {@code null} if the annotation type is not
         *     annotated with {@link ProcessWith} annotation. An exception will be thrown if the
         *     annotation type is annotated with {@link ProcessWith} but no registered {@link Processor}
         *     of the specified type can be found.
         */
        @Override
        @Nullable
        protected Processor computeValue(Class<?> annotationType) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
