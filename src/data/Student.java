package data;

public class Student {

    private String studentName;
    private int studentId;
    private int studentAge;
    private static int idAcum = 0;

    public Student(String studentName, int studentAge) {
        setStudentName(studentName);
        setStudentAge(studentAge);
        setStudentId();
    }

    public void getStudentInfo() {
        System.out.println("ID: " + getStudentId() +
                "\nName: " + getStudentName() +
                "\nAge: " + getStudentAge() +
                "\n---------------------------------------------"
        );
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId() {
        studentId = ++idAcum;
    }

    public int getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(int studentAge) {
        this.studentAge = studentAge;
    }
}
