package classesVsobjects;

public class ExampleClass {
    
    public static final int DEFAULTSIZE = 1;
    
    protected int size;
    

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public ExampleClass() {
        size = DEFAULTSIZE;
    }

    public ExampleClass(int size) {
        this.size = size;
    }

    public double calculateArea() {
        return Math.PI * size * size;
    }

    public static int getDefaultSize() {
        return DEFAULTSIZE;
    }

}
