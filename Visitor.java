package ams.model;

// Test

public interface Visitor {
    public void visit(ElectiveCourse elective);
    public void visit(CoreCourse core);
}