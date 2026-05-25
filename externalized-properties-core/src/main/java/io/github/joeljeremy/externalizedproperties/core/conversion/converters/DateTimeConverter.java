package io.github.joeljeremy.externalizedproperties.core.conversion.converters;

import io.github.joeljeremy.externalizedproperties.core.ConversionResult;
import io.github.joeljeremy.externalizedproperties.core.Converter;
import io.github.joeljeremy.externalizedproperties.core.InvocationContext;
import io.github.joeljeremy.externalizedproperties.core.conversion.DateTimeFormat;
import java.lang.reflect.Type;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import org.jspecify.annotations.Nullable;

/**
 * Supports conversion to Java's built in date/time types:
 *
 * <ul>
 *   <li>{@link LocalDateTime}
 *   <li>{@link LocalDate}
 *   <li>{@link LocalTime}
 *   <li>{@link OffsetDateTime}
 *   <li>{@link OffsetTime}
 *   <li>{@link ZonedDateTime}
 *   <li>{@link Instant}
 *   <li>{@link DayOfWeek}
 *   <li>{@link Month}
 *   <li>{@link MonthDay}
 *   <li>{@link Year}
 *   <li>{@link YearMonth}
 * </ul>
 *
 * @apiNote The {@link DateTimeFormat} annotation may be used to specify a date/time format/pattern
 *     to use when converting to date/time types.
 */
public class DateTimeConverter implements Converter<TemporalAccessor> {

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
    public ConversionResult<TemporalAccessor> convert(InvocationContext context, String valueToConvert, Type targetType) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static YearMonth parseYearMonth(InvocationContext context, String valueToConvert) {
        DateTimeFormatter dateTimeFormatter = determineDateTimeFormatterOrNull(context);
        return dateTimeFormatter != null ? YearMonth.parse(valueToConvert, dateTimeFormatter) : YearMonth.parse(valueToConvert);
    }

    private static Year parseYear(InvocationContext context, String valueToConvert) {
        DateTimeFormatter dateTimeFormatter = determineDateTimeFormatterOrNull(context);
        return dateTimeFormatter != null ? Year.parse(valueToConvert, dateTimeFormatter) : Year.parse(valueToConvert);
    }

    private static MonthDay parseMonthDay(InvocationContext context, String valueToConvert) {
        DateTimeFormatter dateTimeFormatter = determineDateTimeFormatterOrNull(context);
        return dateTimeFormatter != null ? MonthDay.parse(valueToConvert, dateTimeFormatter) : MonthDay.parse(valueToConvert);
    }

    private static ZonedDateTime parseZonedDateTime(InvocationContext context, String valueToConvert) {
        DateTimeFormatter dateTimeFormatter = determineDateTimeFormatterOrNull(context);
        return dateTimeFormatter != null ? ZonedDateTime.parse(valueToConvert, dateTimeFormatter) : ZonedDateTime.parse(valueToConvert);
    }

    private static OffsetTime parseOffsetTime(InvocationContext context, String valueToConvert) {
        DateTimeFormatter dateTimeFormatter = determineDateTimeFormatterOrNull(context);
        return dateTimeFormatter != null ? OffsetTime.parse(valueToConvert, dateTimeFormatter) : OffsetTime.parse(valueToConvert);
    }

    private static OffsetDateTime parseOffsetDateTime(InvocationContext context, String valueToConvert) {
        DateTimeFormatter dateTimeFormatter = determineDateTimeFormatterOrNull(context);
        return dateTimeFormatter != null ? OffsetDateTime.parse(valueToConvert, dateTimeFormatter) : OffsetDateTime.parse(valueToConvert);
    }

    private static LocalTime parseLocalTime(InvocationContext context, String valueToConvert) {
        DateTimeFormatter dateTimeFormatter = determineDateTimeFormatterOrNull(context);
        return dateTimeFormatter != null ? LocalTime.parse(valueToConvert, dateTimeFormatter) : LocalTime.parse(valueToConvert);
    }

    private static LocalDate parseLocalDate(InvocationContext context, String valueToConvert) {
        DateTimeFormatter dateTimeFormatter = determineDateTimeFormatterOrNull(context);
        return dateTimeFormatter != null ? LocalDate.parse(valueToConvert, dateTimeFormatter) : LocalDate.parse(valueToConvert);
    }

    private static LocalDateTime parseLocalDateTime(InvocationContext context, String valueToConvert) {
        DateTimeFormatter dateTimeFormatter = determineDateTimeFormatterOrNull(context);
        return dateTimeFormatter != null ? LocalDateTime.parse(valueToConvert, dateTimeFormatter) : LocalDateTime.parse(valueToConvert);
    }

    @Nullable
    private static DateTimeFormatter determineDateTimeFormatterOrNull(InvocationContext context) {
        DateTimeFormat dateTimeFormat = getDateTimeFormatOrNull(context);
        if (dateTimeFormat == null) {
            return null;
        }
        return DateTimeFormatter.ofPattern(dateTimeFormat.value());
    }

    @Nullable
    private static DateTimeFormat getDateTimeFormatOrNull(InvocationContext context) {
        return context.method().findAnnotation(DateTimeFormat.class).orElse(null);
    }
}
