package org.hibernate.tool.orm.jbt.type;

import org.hibernate.type.Type;

public class TypeFactory {
	
	public static final TypeFactory INSTANCE = new TypeFactory();
	
	private TypeFactory() {}

	public Type getBooleanType() {
		return BooleanType.INSTANCE;
	}

	public Type getByteType() {
		return ByteType.INSTANCE;
	}

	public Type getBigIntegerType() {
		return BigIntegerType.INSTANCE;
	}

	public Type getShortType() {
		return ShortType.INSTANCE;
	}

	public Type getCalendarType() {
		return CalendarType.INSTANCE;
	}

	public Type getCalendarDateType() {
		return CalendarDateType.INSTANCE;
	}

	public Type getIntegerType() {
		return IntegerType.INSTANCE;
	}

	public Type getBigDecimalType() {
		return BigDecimalType.INSTANCE;
	}

	public Type getCharacterType() {
		return CharacterType.INSTANCE;
	}

	public Type getClassType() {
		return ClassType.INSTANCE;
	}

	public Type getCurrencyType() {
		return CurrencyType.INSTANCE;
	}

	public Type getDateType() {
		return DateType.INSTANCE;
	}

	public Type getDoubleType() {
		return DoubleType.INSTANCE;
	}

	public Type getFloatType() {
		return FloatType.INSTANCE;
	}

	public Type getLocaleType() {
		return LocaleType.INSTANCE;
	}

	public Type getLongType() {
		return LongType.INSTANCE;
	}

	public Type getStringType() {
		return StringType.INSTANCE;
	}

	public Type getTextType() {
		return TextType.INSTANCE;
	}

	public Type getTimeType() {
		return TimeType.INSTANCE;
	}

	public Type getTimestampType() {
		return TimestampType.INSTANCE;
	}

	public Type getTimezoneType() {
		return TimeZoneType.INSTANCE;
	}

	public Type getTrueFalseType() {
		return TrueFalseType.INSTANCE;
	}
	
}
