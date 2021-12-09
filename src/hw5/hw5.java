package hw5;

public class hw5 {
    public static class Main {
        public static void main(String[] args) {
            Employee[] employee;
            employee = new Employee[5];
            {
             employee [0] = new Employee ("Василий","Менеджер","vasyamail",8920540,30000,19);
             employee [1] = new Employee ("Серго","Инкасатор","incomail",8921541,55000,41);
             employee [2] = new Employee ("Саня","Безработгый","sanyamail",8922542,1500,36);
             employee [3] = new Employee ("Рома","Продавец","romamail",8923543,40000,55);
             employee [4] = new Employee ("Вика","Стилист","vikamail",8925545,60000,48);
            }
            for (int i = 0; i < employee.length; i++) {
                if (employee[i].getAge() > 40) {
                    employee[i].info();
                }
                System.out.println(employee);
            }
        }
    }
}
