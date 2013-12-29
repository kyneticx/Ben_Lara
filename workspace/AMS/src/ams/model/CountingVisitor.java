package ams.model;

public class CountingVisitor implements Visitor {
    private int coreCount =0;
    private int electiveCount =0;
    
    public CountingVisitor () {
    }    
    
    public void visit(CoreCourse course) {
        coreCount++;        
    }
    public void visit(ElectiveCourse course) {        
        electiveCount++;        
    }

    public int getCoreCount() {
        return coreCount;
    }
 
    public int getElectiveCount() {
        return electiveCount;
    }    
}