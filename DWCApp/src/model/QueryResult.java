/**
 * QueryResult.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package model;



public class QueryResult implements java.io.Serializable {

    private boolean done;

    private String queryLocator;

    private SObject[] records;

    private int size;

    public QueryResult() {
    }




    /**
     * Gets the done value for this QueryResult.
     * 
     * @return done
     */
    public boolean isDone() {
        return done;
    }


    /**
     * Sets the done value for this QueryResult.
     * 
     * @param done
     */
    public void setDone(boolean done) {
        this.done = done;
    }


    /**
     * Gets the queryLocator value for this QueryResult.
     * 
     * @return queryLocator
     */
    public String getQueryLocator() {
        return queryLocator;
    }


    /**
     * Sets the queryLocator value for this QueryResult.
     * 
     * @param queryLocator
     */
    public void setQueryLocator(String queryLocator) {
        this.queryLocator = queryLocator;
    }


    /**
     * Gets the records value for this QueryResult.
     * 
     * @return records
     */
    public SObject[] getRecords() {
        return records;
    }


    /**
     * Sets the records value for this QueryResult.
     * 
     * @param records
     */
    public void setRecords(SObject[] records) {
        this.records = records;
    }

    public SObject getRecords(int i) {
        return this.records[i];
    }

    public void setRecords(int i, SObject _value) {
        this.records[i] = _value;
    }


    /**
     * Gets the size value for this QueryResult.
     * 
     * @return size
     */
    public int getSize() {
        return size;
    }


    /**
     * Sets the size value for this QueryResult.
     * 
     * @param size
     */
    public void setSize(int size) {
        this.size = size;
    }

    }