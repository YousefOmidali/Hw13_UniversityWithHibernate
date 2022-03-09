package Main;

import Entity.Employee;
import Entity.Master;
import Entity.MasterLevel;
import Entity.Student;
import Repository.SessionFactoryConnection;
import Service.*;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        CourseService courseService = new CourseService();
        ScoreService scoreService = new ScoreService();
        StudentService studentService = new StudentService();
        MasterService masterService = new MasterService();
        EmployeeService employeeService = new EmployeeService();
        Scanner scanner = new Scanner(System.in);
        Integer loginMenu = 0;
        Integer whatAreYou = 0;
        Employee employee;
        Master master;
        Student student;
        String username;
        String password;
        String fullName;
        Long nationalCode;
        Long salary;
        Long studentNumber;
        Boolean isExcellent = false;

        System.out.println("1.SignUp \n2.Login");
        loginMenu = scanner.nextInt();
        if (loginMenu == 1) {
            System.out.println("What are you? \n1.Employee \n2.Student \n3.Master ");
            whatAreYou = scanner.nextInt();
            if (whatAreYou == 1) {
                scanner.nextLine();
                System.out.println("enter your username:");
                username = scanner.nextLine();
                System.out.println("enter your password:");
                password = scanner.nextLine();
                System.out.println("enter your fullName:");
                fullName = scanner.nextLine();
                System.out.println("enter your nationalCode:");
                nationalCode = scanner.nextLong();
                employee = new Employee(username, password, fullName, nationalCode, null);
                employeeService.save(employee);
                System.out.println("done! ");

            } else if (whatAreYou == 2) {
                scanner.nextLine();
                System.out.println("enter your username:");
                username = scanner.nextLine();
                System.out.println("enter your password:");
                password = scanner.nextLine();
                System.out.println("enter your fullName:");
                fullName = scanner.nextLine();
                System.out.println("enter your studentNumber:");
                studentNumber = scanner.nextLong();
                student = new Student(username, password, fullName, studentNumber, isExcellent);
                studentService.save(student);
                System.out.println("done! ");

            } else if (whatAreYou == 3) {
                scanner.nextLine();
                System.out.println("enter your username:");
                username = scanner.nextLine();
                System.out.println("enter your password:");
                password = scanner.nextLine();
                System.out.println("enter your fullName:");
                fullName = scanner.nextLine();
                System.out.println("enter your studentNumber:");
                master = new Master(username, password, fullName, MasterLevel.HEIATELMI, 0, null);
                masterService.save(master);
                System.out.println("done!");
            } else
                System.out.println("wrong Number ! ");
        }
        if (loginMenu == 2) {
            System.out.println("What are you? \n1.Employee \n2.Student \n3.Master ");
            whatAreYou = scanner.nextInt();
            if (whatAreYou == 1) {           //Employee
                scanner.nextLine();
                System.out.println("enter your username:");
                username = scanner.nextLine();
                System.out.println("enter your password:");
                password = scanner.nextLine();
                employee = employeeService.login(username, password);
                if (employee != null) {

                }
            } else if (whatAreYou == 2) {
                scanner.nextLine();         //Student
                System.out.println("enter your username:");
                username = scanner.nextLine();
                System.out.println("enter your password:");
                password = scanner.nextLine();
                student = studentService.login(username, password);
                if (student != null) {

                }
            } else if (whatAreYou == 3) {
                scanner.nextLine();         //Master
                System.out.println("enter your username:");
                username = scanner.nextLine();
                System.out.println("enter your password:");
                password = scanner.nextLine();
                master = masterService.login(username, password);
                if (master != null) {
                    System.out.println("\t****EmployeeMenu**** \n1.\n2.\n3.\n4.\n5.\n6.\n7.\n8.\n9.\n");
                }
            } else
                System.out.println("wrong Number ! ");
        }
    }


}
