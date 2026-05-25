package io.github.joeljeremy.externalizedproperties.database;

/**
 * The database property.
 */
public class DatabaseProperty {

    private final String name;

    private final String value;

    private DatabaseProperty(String name, String value) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("name must not be null or empty.");
        }
        if (value == null) {
            throw new IllegalArgumentException("value must not be null.");
        }
        this.name = name;
        this.value = value;
    }

    /**
     * Name of the database property.
     *
     * @return The name of the database property. This will never be null or empty.
     */
    public String name() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Value of the database property.
     *
     * @return The value of the database property. This will never be null.
     */
    public String value() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns a new {@link DatabaseProperty} instance with the given name and value. {@code null}
     * will not be accepted for both name and value. An empty string is allowed for value but not for
     * name.
     *
     * @param name The property name.
     * @param value The property value.
     * @return The {@link DatabaseProperty} instance with the given name and value.
     */
    public static DatabaseProperty with(String name, String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
