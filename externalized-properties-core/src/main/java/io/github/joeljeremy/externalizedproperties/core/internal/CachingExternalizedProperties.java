package io.github.joeljeremy.externalizedproperties.core.internal;

import static io.github.joeljeremy.externalizedproperties.core.internal.Arguments.requireNonNull;
import io.github.joeljeremy.externalizedproperties.core.CacheStrategy;
import io.github.joeljeremy.externalizedproperties.core.ExternalizedProperties;
import io.github.joeljeremy.externalizedproperties.core.internal.caching.WeakConcurrentHashMapCacheStrategy;
import io.github.joeljeremy.externalizedproperties.core.internal.caching.WeakHashMapCacheStrategy;

/**
 * {@link ExternalizedProperties} decorator to enable property resolution caching.
 */
@Internal
public class CachingExternalizedProperties implements ExternalizedProperties {

    private final ExternalizedProperties decorated;

    private final CacheStrategy<ClassLoader, ClassValue<?>> cacheStrategy;

    /**
     * Constructor.
     *
     * @param decorated The decorated {@link ExternalizedProperties} instance.
     * @param cacheStrategy The cache strategy keyed by a {@link ClassLoader} and whose values are the
     *     {@link ClassValue}s associated to that classloader. It is recommended that the {@link
     *     CacheStrategy} implementation only holds weak references to the {@link ClassLoader} key in
     *     order to avoid leaks and class unloading issues.
     * @see WeakConcurrentHashMapCacheStrategy
     * @see WeakHashMapCacheStrategy
     */
    public CachingExternalizedProperties(ExternalizedProperties decorated, CacheStrategy<ClassLoader, ClassValue<?>> cacheStrategy) {
        this.decorated = requireNonNull(decorated, "decorated");
        this.cacheStrategy = requireNonNull(cacheStrategy, "cacheStrategy");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T initialize(Class<T> proxyInterface) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T initialize(Class<T> proxyInterface, ClassLoader classLoader) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private ClassValue<?> proxyInterfaceClassValue(ExternalizedProperties decorated) {
        return new ClassValue<Object>() {

            @Override
            protected Object computeValue(Class<?> proxyInterface) {
                throw new UnsupportedOperationException("STUB: not implemented");
            }
        };
    }

    private ClassValue<?> proxyInterfaceClassValueWithClassLoader(ExternalizedProperties decorated, ClassLoader classLoader) {
        return new ClassValue<Object>() {

            @Override
            protected Object computeValue(Class<?> proxyInterface) {
                throw new UnsupportedOperationException("STUB: not implemented");
            }
        };
    }
}
