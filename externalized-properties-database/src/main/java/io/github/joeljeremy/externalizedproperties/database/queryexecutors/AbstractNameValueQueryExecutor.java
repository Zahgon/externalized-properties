package io.github.joeljeremy.externalizedproperties.database.queryexecutors;

import io.github.joeljeremy.externalizedproperties.database.DatabaseProperty;
import io.github.joeljeremy.externalizedproperties.database.QueryExecutor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Abstract query executor that will build and run a database query based on the specified table
 * name and it's property name and value column mappings.
 */
public abstract class AbstractNameValueQueryExecutor implements QueryExecutor {

    private static final String NO_SCHEMA = "";

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, String> queryProperties(Connection connection, Collection<String> propertyNamesToResolve) throws SQLException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * The target database schema. By default, this will return an empty string (no schema).
     *
     * @return The target database schema.
     */
    protected String schema() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * The target database table.
     *
     * @return The target database table.
     */
    protected abstract String table();

    /**
     * Name of property name column.
     *
     * @return The name of the property name column.
     */
    protected abstract String propertyNameColumn();

    /**
     * Name of the property value column.
     *
     * @return The name of the property value column.
     */
    protected abstract String propertyValueColumn();

    /**
     * Run the query.
     *
     * @param preparedStatement The prepared statement.
     * @return The map of properties resolved from the database.
     * @throws SQLException if a database-related error has occurred.
     */
    protected Map<String, String> runQuery(PreparedStatement preparedStatement) throws SQLException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Map the query result to a {@link DatabaseProperty}.
     *
     * @param resultSet The query result set.
     * @return The mapped {@link DatabaseProperty}.
     * @throws SQLException if a database-related error has occurred.
     */
    protected DatabaseProperty mapResult(ResultSet resultSet) throws SQLException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Prepare statement to query properties from the database.
     *
     * @param connection The JDBC connection.
     * @param propertyNamesToResolve The names of the properties to resolve from database.
     * @return The prepared statement to query properties from the database.
     * @throws SQLException if a database-related error has occurred.
     */
    protected PreparedStatement prepareStatement(Connection connection, Collection<String> propertyNamesToResolve) throws SQLException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Generate SQL query to use in querying the properties from database. The resulting SQL query
     * will be processed via {@link Connection#prepareStatement(String)} so it may contain property
     * name placeholders which will then be set via {@link #configureStatementParameters}.
     *
     * @param propertyNamesToResolve The names of the properties to resolve from database.
     * @return The SQL query to use in querying the properties from database.
     */
    protected String generateSqlQuery(Collection<String> propertyNamesToResolve) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Set prepared statement parameters. By default this will set all property names to resolve as
     * string parameters and will set JDBC fetch size to the number of properties to resolve.
     *
     * @param preparedStatement The prepared statement.
     * @param propertyNamesToResolve The names of the properties to resolve from database.
     * @throws SQLException if a database-related error has occurred.
     */
    protected void configureStatementParameters(PreparedStatement preparedStatement, Collection<String> propertyNamesToResolve) throws SQLException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private String schemaOrThrow() {
        String schema = schema();
        if (schema == null) {
            throw new IllegalStateException("schema() method must not return null.");
        }
        return schema;
    }

    private String tableOrThrow() {
        String table = table();
        if (table == null || table.trim().isEmpty()) {
            throw new IllegalStateException("table() method must not return null or blank.");
        }
        return table;
    }

    private String propertyNameColumnOrThrow() {
        String propertyNameColumn = propertyNameColumn();
        if (propertyNameColumn == null || propertyNameColumn.trim().isEmpty()) {
            throw new IllegalStateException("propertyNameColumn() method must not return null or blank.");
        }
        return propertyNameColumn;
    }

    private String propertyValueColumnOrThrow() {
        String propertyValueColumn = propertyValueColumn();
        if (propertyValueColumn == null || propertyValueColumn.trim().isEmpty()) {
            throw new IllegalStateException("propertyValueColumn() method must not return null or blank.");
        }
        return propertyValueColumn;
    }

    private String buildInClause(Collection<String> propertyNamesToResolve) {
        return propertyNamesToResolve.stream().map(p -> "?").collect(Collectors.joining(","));
    }
}
