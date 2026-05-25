package io.github.joeljeremy.externalizedproperties.core.resolvers;

import static io.github.joeljeremy.externalizedproperties.core.internal.Arguments.requireNonNull;
import io.github.joeljeremy.externalizedproperties.core.InvocationContext;
import io.github.joeljeremy.externalizedproperties.core.Resolver;
import io.github.joeljeremy.externalizedproperties.core.VariableExpanderFacade;
import java.util.Optional;

/**
 * A {@link Resolver} implementation which expand variables in resolved properties.
 */
public class VariableExpandingResolver implements Resolver {

    private final Resolver decorated;

    /**
     * Constructor.
     *
     * @param decorated The decorated {@link Resolver} where properties will actually be resolved
     *     from.
     */
    public VariableExpandingResolver(Resolver decorated) {
        this.decorated = requireNonNull(decorated, "decorated");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<String> resolve(InvocationContext context, String propertyName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static String expandVariables(InvocationContext context, String resolved) {
        VariableExpanderProxy variableExpanderProxy = context.externalizedProperties().initialize(VariableExpanderProxy.class);
        return variableExpanderProxy.expandVariables(resolved);
    }

    private static interface VariableExpanderProxy {

        @VariableExpanderFacade
        String expandVariables(String property);
    }
}
