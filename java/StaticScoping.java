public class StaticScoping {
    public static void main(String[] args) {
        int a = 3;
        double b = 4.5;
        System.out.println(a + b);
        if (args.length>0) {
            int c = 4;
            System.out.println(a+b+c);
        }
//        System.out.println(c); // this won't work b/c c is out of scope
    }
}