package data;

import java.util.ArrayList;
import java.util.List;

public class University {

    private List<Teacher> teacherList;
    private List<Student> studentList;
    private List<Course> courseList;

    public University() {
        teacherList = new ArrayList<Teacher>();
        studentList = new ArrayList<Student>();
        courseList = new ArrayList<Course>();
    }

    public void addFullTimeTeacher(String teacherName, double teacherBaseSalary, int teacherYearsOfExperience) {
        teacherList.add(new FullTimeTeacher(teacherName, teacherBaseSalary, teacherYearsOfExperience));
    }

    public void addPartTimeTeacher(String teacherName, double teacherBaseSalary, int teacherActiveHoursPerWeek) {
        teacherList.add(new PartTimeTeacher(teacherName, teacherBaseSalary, teacherActiveHoursPerWeek));
    }

    public void addStudent(String studentName, int studentAge) {
        studentList.add(new Student(studentName, studentAge));
    }

    public void addCourse(String courseName, int classroomNumber, Teacher courseTeacher) {
        courseList.add(new Course(courseName, classroomNumber, courseTeacher));
    }

    public void addStudentToCourse(int courseId, int studentId) {
        courseList.get(courseId - 1).addStudentToCourse(studentList.get(studentId - 1));
    }

    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }
}