package classesVsobjects;

import javax.swing.SpinnerDateModel;

public class ExampleProgram {

    int programdata = 3;

    public static void main(String[] args) {
        ExampleClass instance1 = new ExampleClass();
        ExampleClass instance2 = new ExampleClass(5);
        System.out.println(instance1.calculateArea()); // Example: call an instance method
        System.out.println(instance2.calculateArea());
        System.out.println(instance1.size); // OK when protected but NOT OK when private
        System.out.println(ExampleClass.DEFAULTSIZE); // Example: access a class attribute/field/variable
        System.out.println(ExampleClass.getDefaultSize()); // Example: call a class method
    
        ExampleProgram p = new ExampleProgram();
        System.out.println(p.programdata);
    }

}
