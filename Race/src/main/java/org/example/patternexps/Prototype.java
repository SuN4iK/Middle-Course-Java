package org.example.patternexps;

interface Copyable {
    Copyable copy();
}
class ComplicatedObject implements Copyable {
    private Type type;

    public enum Type {
        ONE, TWO
    }

    public ComplicatedObject copy() {
        var complicatedObject = new ComplicatedObject();
        return complicatedObject;
    }


    public void setType(Type type) {
        this.type = type;
    }


//тест

    public static void main(String[] args) {
        ComplicatedObject prototype = new ComplicatedObject();
        ComplicatedObject clone = prototype.copy();
        clone.setType(ComplicatedObject.Type.ONE);
    }
}
