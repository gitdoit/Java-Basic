package top.seefly.javase.old2017.exception;

//自定义异常
public class InvalidRadiusException extends Exception {
    
    private double radius;
    
    public InvalidRadiusException() {
        this(-1);
    }
    
    public InvalidRadiusException(double radius) {
        super("Invalid radius" + radius);
        this.radius = radius;
    }
    
    public double getRadius() {
        return this.radius;
    }
}
