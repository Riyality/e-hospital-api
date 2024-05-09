package com.riyality.enums;

public enum Gender {
	MALE, FEMALE, OTHER;

	public static Gender fromString( String value ) {
		for ( Gender gender : Gender.values() ) {
			if ( gender.name().equalsIgnoreCase( value ) ) {
				return gender;
			}
		}
		throw new IllegalArgumentException( "No enum constant " + Gender.class + " for value " + value );
	}
}