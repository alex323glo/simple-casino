package com.alex323glo.simple_casino.v1.model;

/**
 * Game model.
 *
 * @author alex323glo
 * @version 0.1.0
 */
public class Game {

    private String id;

    /**
     * Empty constructor.
     */
    public Game() {
    }

    /**
     * Simple constructor (assigns id field).
     *
     * @param id initial field value.
     */
    public Game(String id) {
        this.id = id;
    }

    /**
     * Getter (id field).
     *
     * @return field value.
     */
    public String getId() {
        return id;
    }

    /**
     * Setter (id field).
     *
     * @param id new field value.
     */
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Game game = (Game) o;

        return id != null ? id.equals(game.id) : game.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id='" + id + '\'' +
                '}';
    }
}
