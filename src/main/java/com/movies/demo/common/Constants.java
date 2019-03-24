package com.movies.demo.common;

public final class Constants {

    private Constants() {
        // restrict instantiation
    }
    // validation messages
    public static final String NAME_NULL_VALIDATION_MESSAGE = "name must have value";
    public static final String NAME_SIZE_VALIDATION_MESSAGE = "Name must be between 1 and 255 characters";
    public static final String GENRE_NULL_VALIDATION_MESSAGE = "genre must have value";
    public static final String GENRE_SIZE_VALIDATION_MESSAGE = "genre must be between 1 and 255 characters";
    public static final String YEAR_NULL_VALIDATION_MESSAGE = "year must have value";
    public static final String YEAR_SIZE_VALIDATION_MESSAGE = "year must be 4 characters";
    public static final String RATING_NULL_VALIDATION_MESSAGE = "rating must have value";
    public static final String RATING_SIZE_VALIDATION_MESSAGE = "rating must be between 1 and 10 characters";


    // Response messages
    public static final String RECORD_DELETED_SUCCESSFULLY = "Record was successfully deleted";
    public static final String RECORD_NOT_FOUND = "Record was not found";
    public static final String TRANSACTION_FAILED = "record transaction failed";
    public static final String CREATE_SUCCEEDED = "record was successfully created";
    public static final String UPDATE_SUCCEEDED = "record was successfully updated";

}
