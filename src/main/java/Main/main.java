package Main;

import Entity.*;
import Service.*;

import java.util.*;

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
        Long masterId =0L ;
        Long studentNumber;
        Integer unit;
        Integer masterLevel;
        Boolean isExcellent = false;
        Boolean loop = true;
        Double scoreOfStudent;


        System.out.println("1.SignUp \n2.Login");
        try {
            loginMenu = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Wrong Input");
        }

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
                try {
                    nationalCode = scanner.nextLong();
                } catch (InputMismatchException e) {
                    System.out.println("Wrong Input");
                }
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
                try {
                    studentNumber = scanner.nextLong();
                    student = new Student(username, password, fullName, studentNumber, isExcellent);
                    studentService.save(student);
                    System.out.println("done! ");
                } catch (InputMismatchException e) {
                    System.out.println("Wrong Input");
                }


            } else if (whatAreYou == 3) {
                scanner.nextLine();
                System.out.println("enter your username:");
                username = scanner.nextLine();
                System.out.println("enter your password:");
                password = scanner.nextLine();
                System.out.println("enter your fullName:");
                fullName = scanner.nextLine();
                master = new Master(username, password, fullName, MasterLevel.HAGHOTADRIS,
                        0, 7000000L, new HashSet<Course>());
                masterService.save(master);
                System.out.println("done!");
            } else
                System.out.println("wrong Number ! ");
        }
        if (loginMenu == 2) {
            System.out.println("What are you? \n1.Employee \n2.Student \n3.Master ");
            try {
                whatAreYou = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Wrong Input");
            }
            if (whatAreYou == 1) {           //Employee
                scanner.nextLine();
                System.out.println("enter your username:");
                username = scanner.nextLine();
                System.out.println("enter your password:");
                password = scanner.nextLine();
                employee = employeeService.login(username, password);
                if (employee != null) {
                    while (loop) {
                        System.out.println("\t****EmployeeMenu**** \n1.delete student\n2.edit student " +
                                "\n3.delete master" +
                                "\n4.update master\n5.delete employee\n6.edit master\n7.add an course" +
                                "\n8.edit course " +
                                "\n9.delete course \n10.Exit");
                        try {
                            employeeMenu = scanner.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Wrong Input");
                        }

                        switch (employeeMenu) {     //EmployeeMenu
                            case 1:
                                System.out.println("enter student id");
                                try {
                                    studentService.deleteById(scanner.nextLong());
                                } catch (InputMismatchException e) {
                                    System.out.println("Wrong Input");
                                }
                                break;
                            case 2:
                                scanner.nextLine();
                                try {
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
                                } catch (InputMismatchException e) {
                                    System.out.println("Wrong Input");
                                }
                                break;
                            case 3:
                                scanner.nextLine();
                                System.out.println("enter master id");
                                try {
                                    masterService.deleteById(scanner.nextLong());
                                } catch (InputMismatchException e) {
                                    System.out.println("Wrong Input");
                                }
                                break;
                            case 4:
                                scanner.nextLine();

                                id = scanner.nextLong();
                                try {
                                    System.out.println("enter master id");
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
                                } catch (InputMismatchException e) {
                                    System.out.println("Wrong Input");
                                }
                                break;
                            case 5:
                                scanner.nextLine();
                                System.out.println("enter employee id");
                                try {
                                    employeeService.deleteById(scanner.nextLong());
                                } catch (InputMismatchException e) {
                                    System.out.println("Wrong Input");
                                }
                                break;
                            case 6:
                                scanner.nextLine();
                                try {
                                    System.out.println("enter master id");
                                    id = scanner.nextLong();
                                    System.out.println("enter your username:");
                                    username = scanner.nextLine();
                                    System.out.println("enter your password:");
                                    password = scanner.nextLine();
                                    System.out.println("enter your fullName:");
                                    fullName = scanner.nextLine();
                                    System.out.println("enter your numberOfLessonTeach:");
                                    numberOfLessonTeach = scanner.nextInt();
                                    System.out.println("enter your salary:");
                                    salary = scanner.nextLong();
                                    System.out.println("he is 1.HeiatElmi  2.HaghOtadris");
                                    masterLevel = scanner.nextInt();
                                    if (masterLevel == 1) {
                                        master = new Master(id, username, password, fullName,
                                                MasterLevel.HEIATELMI, numberOfLessonTeach, salary);
                                    } else {
                                        master = new Master(id, username, password, fullName,
                                                MasterLevel.HAGHOTADRIS, numberOfLessonTeach, salary);
                                    }
                                    masterService.update(master);
                                } catch (InputMismatchException e) {
                                    System.out.println("Wrong Input");
                                }
                                break;
                            case 7:
                                try {
                                    scanner.nextLine();
                                    System.out.println("Enter course name:");
                                    courseName = scanner.nextLine();
                                    System.out.println("enter unit");
                                    unit = scanner.nextInt();
                                    System.out.println("enter master id:");
                                    id = scanner.nextLong();
                                    master = masterService.findById(id);
                                    course = new Course(courseName, unit, master);
                                    courseService.save(course);
                                } catch (InputMismatchException e) {
                                    System.out.println("Wrong Input");
                                }
                                break;
                            case 8:
                                scanner.nextLine();
                                try {
                                    System.out.println("enter course id: ");
                                    id = scanner.nextLong();
                                    System.out.println("Enter course new name:");
                                    courseName = scanner.nextLine();
                                    System.out.println("enter new unit");
                                    unit = scanner.nextInt();
                                    System.out.println("enter new master id:");
                                    id = scanner.nextLong();
                                    master = masterService.findById(id);
                                    course = new Course(courseName, unit, master);
                                    courseService.update(course);
                                } catch (InputMismatchException e) {
                                    System.out.println("Wrong Input");
                                }
                                break;
                            case 9:
                                scanner.nextLine();
                                System.out.println("enter course id: ");
                                try {
                                    courseService.deleteById(scanner.nextInt());

                                } catch (InputMismatchException e) {
                                    System.out.println("Wrong Input");
                                }
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
                    while (loop) {
                        System.out.println("\t****StudentMenu**** \n1.show Self info" +
                                "\n2.show all courses \n3.pick a course" +
                                "\n4.pickedCourses \n5.Get all my scores \n6.My Status\n7.Exit");
                        try {
                            studentMenu = scanner.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Wrong Input");
                        }


                        switch (studentMenu) {     //StudentMenu
                            case 1:
                                System.out.println(student);
                                break;
                            case 2:
                                courseService.findAll();
                                break;
                            case 3:
                                scanner.nextLine();
                                System.out.println("enter master id: ");
                                try {
                                    masterId = scanner.nextLong();
                                    master = masterService.findById(masterId);
                                    master.setUserName("******");
                                    master.setPassword("******");
                                    master.setSalary(0L);
                                    System.out.println("enter course id:");
                                    Integer idWithInt = scanner.nextInt();
                                    course = courseService.findById(idWithInt);
                                    List<Score> scoreList;
                                    Student finalStudent = student;

//                                    scoreList.forEach(
//                                            score1 -> scoreService.findAll(finalStudent.getId()).add(score1));
                                    score = new Score(null, null, course, master, student);
                                    scoreList = scoreService.findAll(student.getId());
                                    Course finalCourse = course;
                                    scoreList.stream().filter(score1 -> score1.getCourse().getId().equals(finalCourse.getId()));

                                    if (scoreList.isEmpty()) {
                                        scoreService.save(score);
                                        System.out.println("picked: "+course);
                                    } else System.out.println("Already picked!");
                                } catch (InputMismatchException e) {
                                    System.out.println("Wrong Input");
                                }

                                break;
                            case 4:
                                System.out.println(scoreService.findAll(student.getId()));
                                break;
                            case 5:
                                scoreService.findAll(student.getId()).forEach(System.out::println);
                                break;
                            case 6:
                                studentService.status(student.getId());
                                break;
                            case 7:
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
                    while (loop) {
                        System.out.println("\t****MasterMenu**** \n1.show Self info" +
                                "\n2.add student score \n3.salary Check " +
                                "\n4.Exit ");
                        masterMenu = scanner.nextInt();

                        switch (masterMenu) {     //MasterMenu
                            case 1:
                                System.out.println(master);
                                break;
                            case 2:
                                System.out.println("Enter course id:");
                                course = courseService.findById(scanner.nextInt());
                                System.out.println("Enter student id: ");
                                student = studentService.findById(scanner.nextLong());
                                System.out.println("Enter score: ");
                                scoreOfStudent = scanner.nextDouble();
                                if (0.00d <= scoreOfStudent && scoreOfStudent <= 20.0d) {
                                    score = new Score(null, scoreOfStudent, course, master, student);
                                    scoreService.save(score);
                                } else throw new RuntimeException
                                        ("Score mist be between 0.00 to 20.00");
                                System.out.println("Done! ");
                                break;
                            case 3:
                                master.setSalary(master.getSalary() + (master.getNumberOfLessonTeach() * 1000000));
                                System.out.println("Main salary + side salary : " + master.getSalary() + "\n" +
                                        "number of lessen teach:" + master.getNumberOfLessonTeach());
                                break;
                            case 4:
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
