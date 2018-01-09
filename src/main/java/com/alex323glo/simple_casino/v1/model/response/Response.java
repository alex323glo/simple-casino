package com.alex323glo.simple_casino.v1.model.response;

/**
 * Service simple abstract response model.
 * Serves response status property.
 *
 * @author alex323glo
 * @version 0.1.0
 */
public abstract class Response {

    protected ResponseStatus status;

    /**
     * Getter (status field).
     *
     * @return field value
     *
     * @see ResponseStatus
     */
    public ResponseStatus getStatus() {
        return status;
    }

    /**
     * Setter (status field).
     *
     * @param status new field value.
     *
     * @see ResponseStatus
     */
    public void setStatus(ResponseStatus status) {
        this.status = status;
    }
}
