package io.github.joeljeremy.externalizedproperties.core;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;

/**
 * This class is used to reference a type (possibly a generic type).
 *
 * @param <T> The referenced type.
 * @apiNote This needs to be instantiated as an anonymous class in order for the type parameter to
 *     be detected e.g. <code>
 *     new TypeReference{@literal<}List{@literal<}Integer{@literal>}{@literal>}(){}</code>.
 */
public abstract class TypeReference<T> {

    private final Type type;

    /**
     * Constructor.
     */
    protected TypeReference() {
        Type selfType = getClass().getGenericSuperclass();
        // Should not fail because TypeReference is a parameterized type.
        ParameterizedType parameterizedType = (ParameterizedType) selfType;
        type = parameterizedType.getActualTypeArguments()[0];
    }

    /**
     * The referenced type.
     *
     * @return The referenced type.
     */
    public Type type() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * The raw referenced type.
     *
     * @return The raw referenced type.
     */
    public Class<?> rawType() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * The generic type parameters of the referenced type.
     *
     * @return The generic type parameters of the referenced type.
     */
    public Type[] genericTypeParameters() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Two {@link TypeReference}s with the same {@link Type} value are considered equal.
     *
     * @param obj The other object to compare with.
     * @return {@code true} if both {@link TypeReference}s have the same {@link Type} value.
     *     Otherwise, {@code false}.
     */
    @Override
    public boolean equals(Object obj) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
