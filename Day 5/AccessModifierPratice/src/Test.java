public class Test {
    public static void main(String[] args) {
        Student student1 = new Student();
        Student student2 = new Student();

        System.out.println(student1);
        System.out.println(student2);

        student1.setName("Chinh");
        student1.setClasses("BaBeo");
        student2.setName("Bong");
        student2.setClasses("MeBeo");

        System.out.println(student1);
        System.out.println(student2);

    }
}
