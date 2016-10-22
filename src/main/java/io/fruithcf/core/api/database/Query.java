package io.fruithcf.core.api.database;

/**
 * Copyright © 2016 Matthew E Development - All Rights Reserved
 * You may NOT use, distribute and modify this code.
 * <p>
 * Created by Matthew E on 10/22/2016 at 11:10 AM.
 */
public class Query {

    private String query;

    public Query Select() {
        query += "SELECT ";
        return this;
    }

    public Query All() {
        query += "* ";
        return this;
    }

    public Query From() {
        query += "FROM ";
        return this;
    }

    public Query Table(String table) {
        query += table + " ";
        return this;
    }

    public Query Where() {
        query += "WHERE ";
        return this;
    }

    public Query Field(String field) {
        query += field;
        return this;
    }

    public Query Equals() {
        query += "=";
        return this;
    }

    public Query End() {
        query += ";";
        return this;
    }

    public String getQuery() {
        return query;
    }

    public Query Update() {
        query += "UPDATE ";
        return this;
    }

    public Query Delete() {
        query += "DELETE ";
        return this;
    }

    public Query Insert() {
        query += "INSERT ";
        return this;
    }

    public Query Fields(String... fields) {
        String fieldString = "";
        for (String field : fields) {
            fieldString += field + ", ";
        }
        fieldString = fieldString.substring(fieldString.length() - 3);
        query += fieldString;
        return this;
    }

    public Query Values(String... values) {
        String valueString = "";
        for (String value : values) {
            valueString += value + ", ";
        }
        valueString = valueString.substring(valueString.length() - 3);
        query += "VALUES (" + valueString + ")";
        return this;
    }

    public Query Into() {
        query += "INTO ";
        return this;
    }
}
