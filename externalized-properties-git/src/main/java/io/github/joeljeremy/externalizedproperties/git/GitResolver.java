package io.github.joeljeremy.externalizedproperties.git;

import static io.github.joeljeremy.externalizedproperties.git.internal.Arguments.requireNonNull;
import static io.github.joeljeremy.externalizedproperties.git.internal.Arguments.requireNonNullOrBlank;
import io.github.joeljeremy.externalizedproperties.core.InvocationContext;
import io.github.joeljeremy.externalizedproperties.core.Resolver;
import io.github.joeljeremy.externalizedproperties.core.resolvers.ResourceResolver;
import io.github.joeljeremy.externalizedproperties.core.resolvers.ResourceResolver.PropertiesReader;
import io.github.joeljeremy.externalizedproperties.core.resolvers.ResourceResolver.ResourceReader;
import java.nio.file.Path;
import java.util.Optional;

/**
 * A {@link Resolver} implementation which reads properties from a resource file that is stored in a
 * Git repository.
 */
public class GitResolver implements Resolver {

    private final ResourceResolver resourceResolver;

    /**
     * Constructor.
     *
     * @param resourceResolver The underlying resource resolver.
     */
    private GitResolver(ResourceResolver resourceResolver) {
        this.resourceResolver = requireNonNull(resourceResolver, "resourceResolver");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<String> resolve(InvocationContext context, String propertyName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Create a new {@link Builder} to facilitate building of an {@link GitResolver} instance.
     *
     * @return The builder for {@link GitResolver}.
     */
    public static Builder builder() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * The builder for {@link GitResolver}.
     */
    public static class Builder {

        private GitRepository gitRepository;

        private String resourceFilePath;

        private ResourceReader resourceReader = new PropertiesReader();

        @SuppressWarnings("NullAway.Init")
        private Builder() {
        }

        /**
         * The Git repository.
         *
         * @param gitRepository The Git repository.
         * @return This builder.
         */
        public Builder gitRepository(GitRepository gitRepository) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * The path of the resource file to checkout from the Git repository and resolve properties
         * from. The path will be resolved relative to the root directory of the Git working tree
         *
         * @param resourceFilePath The path of the resource file to checkout from the Git repository and
         *     to resolve properties from. The path will be resolved relative to the root directory of
         *     the Git working tree.
         * @return This builder.
         */
        public Builder resourceFilePath(String resourceFilePath) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * The resource reader to use in reading the resource file. By default, the resource file is
         * expected to be in {@code .properties} file format.
         *
         * @param resourceReader The resource reader to use in reading the resource file.
         * @return This builder.
         */
        public Builder resourceReader(ResourceReader resourceReader) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Build a {@link GitResolver} which resolves properties from the target resource file.
         *
         * @return The built {@link GitResolver}.
         */
        public GitResolver build() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private void validate() {
            if (gitRepository == null) {
                throw new IllegalStateException("Git repository URI is required.");
            }
            if (resourceFilePath == null) {
                throw new IllegalStateException("Resource file path is required.");
            }
        }
    }
}
