package org.example;

public enum Status {
    TODO("Todo"),
    IN_PROGRESS("In progress"),
    DONE("Done");

    private final String value;

    Status(String value) {
        this.value = value;
    }

    String getValue() {
        return value;
    }

    @Override
    public String toString(){
        return value;
    }

}
