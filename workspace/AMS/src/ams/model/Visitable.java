package ams.model;

public interface Visitable {
    public void accept(Visitor visitor);
}