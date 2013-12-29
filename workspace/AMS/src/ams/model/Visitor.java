package ams.model;

public interface Visitor {
    public void visit(ElectiveCourse elective);
    public void visit(CoreCourse core);
}