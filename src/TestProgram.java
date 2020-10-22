import java.util.*;

public class TestProgram {

    private static final Scanner reader = new Scanner(System.in);
    private static final ArrayList<Student> list = new ArrayList<>();
    public static void main(String[] args) {

        //Them truoc 3 dua:
        Student stu = new Student("Vinh", 21, 4.0f);
        list.add(stu);
        list.add(new Student("Huong", 19, 3.95f));
        list.add(new Student("Quang", 21, 3.99f));

        int input;
        while (true) {
            menu();
            System.out.print("Chon chuc nang: ");
            input = reader.nextInt();
            switch (input) {
                case 0:
                    return;
                case 1:
                    addSV();
                    break;
                case 2:
                    searchStudent();
                    break;
                case 3:
                    sortGPA();
                    break;
                case 4:
                    printStudent();
                    break;
                default:
                    break;
            }
            System.out.println("________________________________________");
        }


    }

    private static void sortGPA() {
        //co the sort theo bat cu cach nao
        //o day dung ham co san
        list.sort(new Comparator<>() {
            @Override
            public int compare(Student student, Student t1) {
                if (student.getGPA() > t1.getGPA())
                    return 1;
                return 0;
            }
        });
        printStudent();
    }

    private static void addSV() {
        String name;
        int age;
        float GPA;
        reader.nextLine();  //cai nay de xoa dau cach
        System.out.print("Ten: ");
        name = reader.nextLine();
        System.out.print("Tuoi: ");
        age = reader.nextInt();
        System.out.print("GPA: ");
        GPA = reader.nextFloat();
        list.add(new Student(name, age, GPA));
    }

    private static void menu() {
        System.out.println("1. Them SV.\n" +
                "2. Tim kiem.\n" +
                "3. Sort.\n" +
                "4. In.\n" +
                "0. Exit\n");
    }

    private static void searchStudent() {
        reader.nextLine(); //xoa dau cach
        System.out.print("Nhap ten sinh vien can tim:");
        String name = reader.nextLine();
        for (Student i: list) {
            if (i.getName().equalsIgnoreCase(name)) {
                System.out.println(i.toString());
            }
        }
    }

    private static void printStudent() {
        for (Student i : list) {
            System.out.println(i.toString());
        }
    }

}

class Student {
//    private static int id;
    private String name;
    private int age;
    private float GPA;

    public Student() {

    }

    public Student(String name, int age, float GPA) {
        this.name = name;
        this.age = age;
        this.GPA = GPA;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getGPA() {
        return GPA;
    }

    public void setGPA(float GPA) {
        this.GPA = GPA;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", GPA=" + GPA +
                '}';
    }
}

