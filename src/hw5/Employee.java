package hw5;

public class Employee {
     private String name;
     private String post;
     private String email ;
     private int phone;
     private int wage;
     private int age;

    public  Employee (String name, String post, String email, int phone, int wage, int age) {
        this.name = name;
        this.post = post;
        this.email = email;
        this.phone = phone;
        this.wage = wage;
        this.age = age;
    }

    public void info () {
        System.out.printf ("Сотрудник:Имя=%s, Должность=%s, Email=%s, Телефон=%d, Зарплата=%d , Возраст=%d./n", name, post, email, phone, wage, age);
    }

    public  int  getAge() {
        return age;
    }
}
