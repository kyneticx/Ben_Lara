package ams.model;

// Test Branch 1

public interface Visitor {
    public void visit(ElectiveCourse elective);
    public void visit(CoreCourse core);
}