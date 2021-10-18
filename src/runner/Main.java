package runner;

import data.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        University university1 = new University();

        university1.addFullTimeTeacher("Augusto Berrío", 8000, 20);
        university1.addFullTimeTeacher("Gustavo Rendón", 8200, 18);
        university1.addFullTimeTeacher("Alberto Buitrago", 1560, 8);
        university1.addFullTimeTeacher("Adriana Gaviria", 2400, 12);

        university1.addPartTimeTeacher("Marcela Pulgarín", 1465, 8);
        university1.addPartTimeTeacher("Patricia Sánchez", 1155, 12);
        university1.addPartTimeTeacher("Lucas Restrepo", 850, 4);
        university1.addPartTimeTeacher("Juan Ocampo", 900, 6);

        university1.addCourse("Maths", 402, university1.getTeacherList().get(0));
        university1.addCourse("Science", 101, university1.getTeacherList().get(7));
        university1.addCourse("Music", 1520, university1.getTeacherList().get(1));
        university1.addCourse("Arts", 304, university1.getTeacherList().get(3));
        university1.addCourse("History", 202, university1.getTeacherList().get(6));
        university1.addCourse("Economics", 304, university1.getTeacherList().get(4));
        university1.addCourse("Physics", 908, university1.getTeacherList().get(2));
        university1.addCourse("Business", 624, university1.getTeacherList().get(5));

        university1.addStudent("Mateo Montoya", 23);
        university1.addStudent("Darío Zapata", 32);
        university1.addStudent("Laura Palacio", 18);
        university1.addStudent("Dani Cifuentes", 24);
        university1.addStudent("Catalina Maya", 17);
        university1.addStudent("Frank Cortés", 20);
        university1.addStudent("Marcela Pineda", 22);
        university1.addStudent("Helena Sepúlveda", 30);
        university1.addStudent("Salomé Saenz", 29);
        university1.addStudent("Isabel Castillo", 33);

        university1.addStudentToCourse(1, 7);
        university1.addStudentToCourse(1, 6);
        university1.addStudentToCourse(1, 1);
        university1.addStudentToCourse(2, 5);
        university1.addStudentToCourse(2, 1);
        university1.addStudentToCourse(2, 8);
        university1.addStudentToCourse(3, 3);
        university1.addStudentToCourse(3, 2);
        university1.addStudentToCourse(3, 4);
        university1.addStudentToCourse(4, 1);
        university1.addStudentToCourse(4, 10);
        university1.addStudentToCourse(4, 3);
        university1.addStudentToCourse(5, 2);
        university1.addStudentToCourse(5, 5);
        university1.addStudentToCourse(5, 4);
        university1.addStudentToCourse(6, 6);
        university1.addStudentToCourse(6, 7);
        university1.addStudentToCourse(6, 8);
        university1.addStudentToCourse(7, 5);
        university1.addStudentToCourse(7, 1);
        university1.addStudentToCourse(7, 3);
        university1.addStudentToCourse(8, 2);
        university1.addStudentToCourse(8, 10);
        university1.addStudentToCourse(8, 7);

        int optionSelected;
        do {
            Scanner sc = new Scanner(System.in);

            System.out.println("Welcome to your university portal. Please select an option:\n" +
                    "1. List all the teachers with their relevant data.\n" +
                    "2. See all the courses we offer.\n" +
                    "3. Create a new student and add it to a course.\n" +
                    "4. Create a new course with all its required data.\n" +
                    "5. See all courses which a selected student belongs to.\n" +
                    "0. Close the portal.");

            optionSelected = sc.nextInt();

            switch (optionSelected) {
                case 1:
                    System.out.println("================================" +
                            "\nHere's our teachers list" +
                            "\n================================");

                    for (Teacher i : university1.getTeacherList()) {
                        i.getTeacherInfo();
                    }
                    break;
                case 2:
                    System.out.println("================================" +
                            "\nHere's our courses list" +
                            "\n================================");

                    for (Course i : university1.getCourseList()) {
                        System.out.println(i.getCourseName() +
                                "\nID: " +
                                i.getCourseId() +
                                "\n------------------");
                    }

                    System.out.println("================================" +
                            "\nIf you want to see extra information about a specific course, please enter its ID. " +
                            "\nOtherwise, enter 0 to go back to the main menu." +
                            "\n================================");

                    int optionSelectedSubmenu = sc.nextInt();

                    if(optionSelectedSubmenu < 0 || optionSelectedSubmenu > university1.getCourseList().size()) {
                        do {
                            System.out.println("Please enter a valid ID number, it must be between 1 and " + university1.getCourseList().size() +
                                    ". \nOr simply enter 0 to go back to the main menu.");
                            optionSelectedSubmenu = sc.nextInt();
                        } while(optionSelectedSubmenu < 0 || optionSelectedSubmenu > university1.getCourseList().size());
                    }
                    if(optionSelectedSubmenu == 0) {
                        System.out.println("Going back to main menu...");
                    } else {
                        university1.getCourseList().get(optionSelectedSubmenu - 1).getCourseInfo();
                        for (Student element: university1.getCourseList().get(optionSelectedSubmenu - 1).getStudentCourseList()) {
                            element.getStudentInfo();
                        }
                    }
                    break;
                case 3:
                    System.out.println("Enter student's first name");
                    String studentFirstName = sc.next();
                    System.out.println("Enter student's last name");
                    String studentLastName = sc.next();
                    String studentName = studentFirstName + " " + studentLastName;
                    System.out.println("Enter student's age");
                    int studentAge = sc.nextInt();

                    university1.addStudent(studentName, studentAge);

                    System.out.println("Now, look at the available courses and enter the ID of the course where you want to include the new student:" +
                            "\n-------------------------------------------------------------------------------------------------------------");
                    for (Course i : university1.getCourseList()) {
                        System.out.println(i.getCourseName() +
                                "\nID: " +
                                i.getCourseId() +
                                "\n------------------");
                    }

                    int idSelected = sc.nextInt();

                    if(idSelected < 0 || idSelected > university1.getCourseList().size()) {
                        do {
                            System.out.println("Please enter a valid ID number, it must be between 1 and " + university1.getCourseList().size() +
                                    ". \nOr simply enter 0 to go back to the main menu.");
                            idSelected = sc.nextInt();
                        } while(idSelected < 0 || idSelected > university1.getCourseList().size());
                    }
                    if(idSelected == 0) {
                        System.out.println("Going back to main menu...");
                    } else {
                        university1.addStudentToCourse(idSelected, university1.getStudentList().size() - 1);
                        System.out.println("The student " + studentName + " was successfully added to " +
                                university1.getCourseList().get(idSelected - 1).getCourseName() + " course" +
                                "\n---------------------------------------------------------------");
                    }
                    break;
                case 4:
                    System.out.println("Enter the course name:");
                    String courseName = sc.next();
                    System.out.println("Enter the classroom number");
                    int classroomNumber = sc.nextInt();
                    System.out.println("Now let's assign an existing random teacher to this new course." +
                            "\nPlease select a number between 1 and " + university1.getTeacherList().size());

                    int teacherId = sc.nextInt();

                    if(teacherId < 0 || teacherId > university1.getTeacherList().size()) {
                        do {
                            System.out.println("Please enter a valid ID number, it must be between 1 and " + university1.getTeacherList().size() +
                                    ". \nOr simply enter 0 to go back to the main menu.");
                            teacherId = sc.nextInt();
                        } while(teacherId < 0 || teacherId > university1.getTeacherList().size());
                    }
                    if(teacherId == 0) {
                        System.out.println("Going back to main menu...");
                    }

                    System.out.println("Now let's add some random students." +
                            "\nFirst random student. Select a number between 1 and " + university1.getStudentList().size());
                    int firstStudentId = sc.nextInt();
                    if(firstStudentId < 0 || firstStudentId > university1.getStudentList().size()) {
                        do {
                            System.out.println("Please enter a valid ID number, it must be between 1 and " + university1.getStudentList().size() +
                                    ". \nOr simply enter 0 to go back to the main menu.");
                            firstStudentId = sc.nextInt();
                        } while(firstStudentId < 0 || firstStudentId > university1.getStudentList().size());
                    }
                    if(firstStudentId == 0) {
                        System.out.println("Going back to main menu...");
                    }

                    System.out.println("Add another student. Remember to only select a number between 1 and " + university1.getStudentList().size());
                    int secondStudentId = sc.nextInt();
                    if(secondStudentId < 0 || secondStudentId > university1.getStudentList().size()) {
                        do {
                            System.out.println("Please enter a valid ID number, it must be between 1 and " + university1.getStudentList().size() +
                                    ". \nOr simply enter 0 to go back to the main menu.");
                            secondStudentId = sc.nextInt();
                        } while(secondStudentId < 0 || secondStudentId > university1.getStudentList().size());
                    }
                    if(secondStudentId == 0) {
                        System.out.println("Going back to main menu...");
                    }

                    System.out.println("Add the last student. Don't forget to only select a number between 1 and " + university1.getStudentList().size());
                    int thirdStudentId = sc.nextInt();
                    if(thirdStudentId < 0 || thirdStudentId > university1.getStudentList().size()) {
                        do {
                            System.out.println("Please enter a valid ID number, it must be between 1 and " + university1.getStudentList().size() +
                                    ". \nOr simply enter 0 to go back to the main menu.");
                            thirdStudentId = sc.nextInt();
                        } while(thirdStudentId < 0 || thirdStudentId > university1.getStudentList().size());
                    }
                    if(thirdStudentId == 0) {
                        System.out.println("Going back to main menu...");
                    }
                    university1.addCourse(courseName, classroomNumber, university1.getTeacherList().get(teacherId));
                    university1.addStudentToCourse(university1.getCourseList().size(), firstStudentId);
                    university1.addStudentToCourse(university1.getCourseList().size(), secondStudentId);
                    university1.addStudentToCourse(university1.getCourseList().size(), thirdStudentId);
                    System.out.println("Info successfully updated!");
                    break;
                case 5:
                    System.out.println("Please enter the student ID to get all the info. Remember to select a number between 1 and " +
                            university1.getStudentList().size());

                    int id = sc.nextInt();
                    if(id < 0 || id > university1.getStudentList().size()) {
                        do {
                            System.out.println("Please enter a valid ID number, it must be between 1 and " + university1.getStudentList().size() +
                                    ". \nOr simply enter 0 to go back to the main menu.");
                            id = sc.nextInt();
                        } while(id < 0 || id > university1.getStudentList().size());
                    }
                    if(id == 0) {
                        System.out.println("Going back to main menu...");
                    }

                    System.out.println("This is the student info:");
                    university1.getStudentList().get(id - 1).getStudentInfo();
                    System.out.println("The student assist to the following courses:");
                    for (Course i : university1.getCourseList()) {
                        for (Student j : i.getStudentCourseList()) {
                            if(id == j.getStudentId()) {
                                System.out.println(i.getCourseName() +
                                        "\n----------------------------------");
                            }
                        }
                    }
                    break;
                default:
                    System.out.println("Please enter a valid option");
                    break;
            }
        } while(optionSelected != 0);
    }
}
