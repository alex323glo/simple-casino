package com.alex323glo.simple_casino.v1.util;

import com.alex323glo.simple_casino.v1.exception.DataValidationException;

/**
 * Container for general validation methods.
 *
 * @author alex323glo
 * @version 0.1.0
 */
public class Validator {

    /**
     * Validates String identifier value.
     *
     * @param id value of identifier.
     * @throws DataValidationException if identifier is Null.
     *
     * @see DataValidationException
     */
    public static void validateId(String id) throws DataValidationException {
        if (id == null) {
            throw new DataValidationException("id is null");
        }
    }

    /**
     * Validates String identifier value. Uses validateId(String) method to check
     * if identifier is null.
     *
     * @param id value of identifier.
     * @param requiredLength matcher for String length property.
     * @throws DataValidationException if identifier is Null or doesn't
     * match required length.
     *
     * @see Validator#validateId(String)
     * @see DataValidationException
     */
    public static void validateId(String id, int requiredLength) throws DataValidationException {
         validateId(id);

         if (requiredLength > 0 && id.length() != requiredLength) {
             throw new DataValidationException("id has wrong size");
         }
    }

    /**
     * Validates Double amount value.
     *
     * @param amount value of amount.
     * @throws DataValidationException if amount is Null or is negative.
     *
     * @see DataValidationException
     */
    public static void validateAmount(Double amount) throws DataValidationException {
         if (amount == null) {
             throw new DataValidationException("amount is null");
         }

         if (amount < 0) {
             throw new DataValidationException("amount is negative");
         }
    }

}
