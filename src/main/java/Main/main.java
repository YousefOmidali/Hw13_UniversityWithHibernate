package Main;

import Entity.*;
import Repository.SessionFactoryConnection;
import Service.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        CourseService courseService = new CourseService();
        ScoreService scoreService = new ScoreService();
        StudentService studentService = new StudentService();
        MasterService masterService = new MasterService();
        EmployeeService employeeService = new EmployeeService();
        Scanner scanner = new Scanner(System.in);
        Course course;
        Score score;
        Integer loginMenu = 0;
        Integer whatAreYou = 0;
        Integer employeeMenu = 0;
        List<Course> courseList;
        Integer numberOfLessonTeach = 0;
        Integer masterMenu = 0;
        Long id = 0L;
        Integer status = 0;
        Integer integerId = 0;
        Integer studentMenu = 0;
        Employee employee;
        Master master;
        Student student;
        String username;
        String password;
        String fullName;
        String courseName;
        Long nationalCode = 0L;
        Long salary = 1L;
        Long studentNumber;
        Integer unit;
        Boolean isExcellent = false;
        Boolean loop = true;

        employeeService.findAll();

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
                employee = new Employee(username, password, fullName, nationalCode, 6000000L);
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
                student = new Student(username, password, fullName, studentNumber, isExcellent, new ArrayList<>());
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
                master = new Master(username, password, fullName, MasterLevel.HAGHOTADRIS,
                        0, 7000000L, new ArrayList<>());
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

                    System.out.println("\t****EmployeeMenu**** \n1.delete student\n2.edit student \n3.delete master" +
                            "\n4.update master\n5.delete employee\n6.edit master\n7.add an course\n8.edit course \n9.delete course \n10.Exit");
                    employeeMenu = scanner.nextInt();
                    while (loop) {
                        switch (employeeMenu) {     //EmployeeMenu
                            case 1:
                                System.out.println("enter student id");
                                studentService.deleteById(scanner.nextLong());
                                break;
                            case 2:
                                scanner.nextLine();
                                System.out.println("enter student id:");
                                id = scanner.nextLong();
                                System.out.println("enter your username:");
                                username = scanner.nextLine();
                                System.out.println("enter your password:");
                                password = scanner.nextLine();
                                System.out.println("enter your fullName:");
                                fullName = scanner.nextLine();
                                System.out.println("enter your studentNumber:");
                                studentNumber = scanner.nextLong();
                                System.out.println("status? 1.YES   2.No");
                                status = scanner.nextInt();
                                if (status == 1) {
                                    student = new Student(id, username, password, fullName, studentNumber, true);
                                } else
                                    student = new Student(id, username, password, fullName, studentNumber, false);
                                studentService.update(student);
                                break;
                            case 3:
                                scanner.nextLine();
                                System.out.println("enter master id");
                                masterService.deleteById(scanner.nextLong());
                                break;
                            case 4:
                                scanner.nextLine();
                                System.out.println("enter master id");
                                id = scanner.nextLong();
                                master = masterService.findById(id);
                                System.out.println("enter your username:");
                                username = scanner.nextLine();
                                System.out.println("enter your password:");
                                password = scanner.nextLine();
                                System.out.println("enter your fullName:");
                                fullName = scanner.nextLine();
                                System.out.println("enter number of lesson teach:");
                                numberOfLessonTeach = scanner.nextInt();
                                System.out.println("salary:");
                                salary = scanner.nextLong();
                                System.out.println("Master level! 1.HeiatElmi 2.Haghotadris");
                                status = scanner.nextInt();
                                if (status == 1) {
                                    master = new Master(id, username, password, fullName,
                                            MasterLevel.HEIATELMI, numberOfLessonTeach, salary);
                                } else
                                    master = new Master(id, username, password, fullName,
                                            MasterLevel.HAGHOTADRIS, numberOfLessonTeach, salary);
                                masterService.update(master);
                                break;
                            case 5:
                                scanner.nextLine();
                                System.out.println("enter employee id");
                                employeeService.deleteById(scanner.nextLong());
                                break;
                            case 6:
                                scanner.nextLine();
                                System.out.println("enter master id");
                                id = scanner.nextLong();
                                master = masterService.findById(id);
                                System.out.println("enter your username:");
                                username = scanner.nextLine();
                                System.out.println("enter your password:");
                                password = scanner.nextLine();
                                System.out.println("enter your fullName:");
                                fullName = scanner.nextLine();
                                System.out.println("enter your nationalCode:");
                                nationalCode = scanner.nextLong();
                                System.out.println("enter your salary:");
                                salary = scanner.nextLong();
                                employee = new Employee(id, username, password, fullName, nationalCode, salary);
                                employeeService.update(employee);
                                break;
                            case 7:
                                scanner.nextLine();
                                System.out.println("Enter course name:");
                                courseName = scanner.nextLine();
                                System.out.println("enter unit");
                                unit = scanner.nextInt();
                                System.out.println("enter master id:");
                                id = scanner.nextLong();
                                master = masterService.findById(id);
                                course = new Course(null, courseName, unit, master, new ArrayList<>(),null);
                                courseService.save(course);
                                break;
                            case 8:
                                scanner.nextLine();
                                System.out.println("enter course id: ");
                                id = scanner.nextLong();
                                System.out.println("Enter course name:");
                                courseName = scanner.nextLine();
                                System.out.println("enter unit");
                                unit = scanner.nextInt();
                                System.out.println("enter master id:");
                                id = scanner.nextLong();
                                master = masterService.findById(id);
                                course = new Course(courseName, unit, master);
                                courseService.update(course);
                                break;
                            case 9:
                                scanner.nextLine();
                                System.out.println("enter course id: ");
                                courseService.deleteById(scanner.nextInt());
                                break;
                            case 10:
                                loop = false;
                                break;

                        }
                    }
                }
            } else if (whatAreYou == 2) {
                scanner.nextLine();         //Student
                System.out.println("enter your username:");
                username = scanner.nextLine();
                System.out.println("enter your password:");
                password = scanner.nextLine();
                student = studentService.login(username, password);
                if (student != null) {
                    System.out.println("\t****StudentMenu**** \n1.show Self info\n2.show all courses \n3.pick a course" +
                            "\n4.update \n5.Exit");
                    studentMenu = scanner.nextInt();
                    while (loop) {
                        switch (studentMenu) {     //StudentMenu
                            case 1:
                                System.out.println(student);
                                break;
                            case 2:
                                courseService.findAll();
                                break;
                            case 3:
                                System.out.println("enter course id:");
                                Integer idWithInt = 0;
                                course = courseService.findById(idWithInt);
                                if (!(student.getCourseList().contains(course)))
                                    student.getCourseList().add(course);
                                break;
                            case 4:
                                student.getCourseList().stream().forEach(System.out::println);
                                break;
                            case 5:
                                loop = false;
                                break;
                        }
                    }
                }
            } else if (whatAreYou == 3) {
                scanner.nextLine();         //Master
                System.out.println("enter your username:");
                username = scanner.nextLine();
                System.out.println("enter your password:");
                password = scanner.nextLine();
                master = masterService.login(username, password);
                if (master != null) {
                    System.out.println("\t****MasterMenu**** \n1.show Self info\n2.show all courses \n3.pick a course" +
                            "\n4.update ");
                    masterMenu = scanner.nextInt();
                    while (loop) {
                        switch (masterMenu) {     //MasterMenu
                            case 1:
                                System.out.println(master);
                                break;
                            case 2:
                                System.out.println("enter course id: ");
                                integerId = scanner.nextInt();

                                break;
                            case 3:

                                break;
                            case 4:

                                break;
                            case 5:
                                loop = false;
                                break;
                        }
                    }
                }
            } else
                System.out.println("wrong Number ! ");
        }
    }


}
