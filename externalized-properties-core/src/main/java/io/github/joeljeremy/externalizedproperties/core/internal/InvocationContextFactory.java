package io.github.joeljeremy.externalizedproperties.core.internal;

import static io.github.joeljeremy.externalizedproperties.core.internal.Arguments.requireNonNull;
import io.github.joeljeremy.externalizedproperties.core.ExternalizedProperties;
import io.github.joeljeremy.externalizedproperties.core.InvocationArguments;
import io.github.joeljeremy.externalizedproperties.core.InvocationContext;
import io.github.joeljeremy.externalizedproperties.core.ProxyMethod;
import io.github.joeljeremy.externalizedproperties.core.TypeUtilities;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Optional;

/**
 * The factory for {@link InvocationContext}.
 */
@Internal
public class InvocationContextFactory {

    private final ExternalizedProperties externalizedProperties;

    /**
     * Constructor.
     *
     * @param externalizedProperties The {@link ExternalizedProperties} instance.
     */
    public InvocationContextFactory(ExternalizedProperties externalizedProperties) {
        this.externalizedProperties = requireNonNull(externalizedProperties, "externalizedProperties");
    }

    /**
     * Create a context object for the proxy method invocation.
     *
     * @param proxy The proxy which declares the invoked proxy method.
     * @param method The invoked proxy method.
     * @param args The invocation arguments.
     * @return A context object for the proxy method invocation.
     */
    public InvocationContext create(Object proxy, Method method, Object[] args) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Built-in invocation context.
     */
    private static class SystemInvocationContext implements InvocationContext {

        private final ExternalizedProperties externalizedProperties;

        private final ProxyMethod proxyMethod;

        private final InvocationArguments invocationArgs;

        /**
         * Constructor.
         *
         * @param externalizedProperties The {@link ExternalizedProperties} instance that initialized
         *     the proxy which declares the invoked method.
         * @param method The invoked proxy method.
         * @param args The proxy method invocation arguments.
         */
        private SystemInvocationContext(ExternalizedProperties externalizedProperties, Method method, Object[] args) {
            this.externalizedProperties = externalizedProperties;
            this.proxyMethod = new SystemProxyMethod(method);
            this.invocationArgs = new SystemInvocationArguments(args);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public ExternalizedProperties externalizedProperties() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public ProxyMethod method() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public InvocationArguments arguments() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    /**
     * Built-in proxy method.
     */
    private static class SystemProxyMethod implements ProxyMethod {

        private final Method method;

        /**
         * Constructor.
         *
         * @param method The method.
         */
        private SystemProxyMethod(Method method) {
            this.method = method;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Annotation[] annotations() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public <T extends Annotation> Optional<T> findAnnotation(Class<T> annotationClass) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public <T extends Annotation> boolean hasAnnotation(Class<T> annotationClass) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Class<?> declaringClass() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String name() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Class<?> rawReturnType() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Type returnType() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Class<?>[] rawParameterTypes() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Optional<Class<?>> rawParameterTypeAt(int parameterIndex) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Type[] parameterTypes() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Optional<Type> parameterTypeAt(int parameterIndex) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean hasReturnType(Class<?> type) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean hasReturnType(Type type) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Type[] typeParametersOfReturnType() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Optional<Type> typeParameterOfReturnTypeAt(int typeParameterIndex) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean isDefaultInterfaceMethod() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String methodSignatureString() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    /**
     * Built-in invocation arguments.
     */
    private static class SystemInvocationArguments implements InvocationArguments {

        private final Object[] args;

        /**
         * Constructor.
         *
         * @param args The proxy method invocation arguments.
         */
        private SystemInvocationArguments(Object[] args) {
            this.args = args;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public int count() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Object[] get() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Optional<Object> get(int index) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Object getOrThrow(int index) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
