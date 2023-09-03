// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

// TASK 1,2
public class Lesson_4 {
    public static void main(String[] args) {

        Employee[] array = new Employee[5];
        array[0] = new Employee("Petrov Petr Petrovich", "Driver", "ppp@mail.ru", "(+375)291234567", 1000, 46);
        array[1] = new Employee("Grekov Grek Grekovich", "Translator", "ggg@mail.ru", "(+375)298765432", 2999, 38);
        array[2] = new Employee("Germanov German Germanovich", "Ministr", "3g@mail.ru", "(+375)297777777", 7000, 42);
        array[3] = new Employee("Polyak Polina Polyakovna", "Secretary", "3p@mail.ru", "(+375)292233445", 650, 19);
        array[4] = new Employee("Emairatov Emir Emirovich", "Developer", "eee@mail.ru", "(+375)290101010", 1700, 25);

        for (Employee empl : array) {
            if (empl.getAge() > 40) {
                empl.getInfo();
            }
        }
    }
}

class Employee {
    private String fullName;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;
    public int getAge () {
        return age;
    }

    public Employee(String fullName, String position, String email, String phone, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }
    public void getInfo() {
        System.out.println(fullName + "\n-"
                            + position + "\n-"
                            + email + "\n-"
                            + phone + "\n-"
                            + salary + "\n-"
                            + age);
    }
}

// TASK 3
class Park {
    private String workingHours;
    private String address;

    class Attraction {
        private String workingHours;
        private int cost;
        private int ageLimit;
    }

    public static void main(String[] args) {
        Park.Attraction ferrisWheel = new Park().new Attraction();
        ferrisWheel.ageLimit = 18;
    }
}