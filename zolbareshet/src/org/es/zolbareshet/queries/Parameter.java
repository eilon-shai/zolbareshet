package org.es.zolbareshet.queries;

import javafx.util.Pair;


public class Parameter {
    public enum TYPE {STRING,INT,FLOAT,LONG,BOOLEAN,BLOB,DATE};
    private Object object;
    private int index;
    private TYPE type;

    public Parameter(Object object, int index, TYPE type) {
        this.object = object;
        this.index = index;
        this.type = type;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public TYPE getType() {
        return type;
    }

    public void setType(TYPE type) {
        this.type = type;
    }
}
