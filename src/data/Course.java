package data;

import java.util.ArrayList;
import java.util.List;

public class Course {

    private String courseName;
    private int courseId;
    private int classroomNumber;
    private List<Student> studentCourseList;
    private Teacher courseTeacher;
    private static int idAcum = 0;

    public Course(String courseName, int classroomNumber, Teacher courseTeacher) {
        setCourseName(courseName);
        setCourseId();
        setClassroomNumber(classroomNumber);
        setCourseTeacher(courseTeacher);
        studentCourseList = new ArrayList<>();
    }

    public void getCourseInfo() {
        System.out.println("COURSE INFO:" +
                "\nName: " + getCourseName() +
                "\nCourse ID: " + getCourseId() +
                "\nClassroom number: " + getClassroomNumber() +
                "\nTeacher's name: " + getCourseTeacher().getTeacherName() +
                "\n\n-->Student list: " +
                "\n----------------------"
        );
    }

    public void addStudentToCourse(Student student) {
        studentCourseList.add(student);
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId() {
        courseId = ++idAcum;
    }

    public int getClassroomNumber() {
        return classroomNumber;
    }

    public void setClassroomNumber(int classroomNumber) {
        this.classroomNumber = classroomNumber;
    }

    public List<Student> getStudentCourseList() {
        return studentCourseList;
    }

    public void setStudentCourseList(List<Student> studentCourseList) {
        this.studentCourseList = studentCourseList;
    }

    public Teacher getCourseTeacher() {
        return courseTeacher;
    }

    public void setCourseTeacher(Teacher courseTeacher) {
        this.courseTeacher = courseTeacher;
    }
}
