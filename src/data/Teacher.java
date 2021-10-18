package data;

public abstract class Teacher {

    private String teacherName;
    private double teacherBaseSalary;
    private int teacherId;
    private static int idAcum = 0;

    public Teacher(String teacherName, double teacherBaseSalary) {
        setTeacherName(teacherName);
        setTeacherBaseSalary(teacherBaseSalary);
        setTeacherId();
    }

    public void getTeacherInfo() {
        System.out.println("ID: " + getTeacherId() +
                "\nName: " + getTeacherName() +
                "\nSalary: $" + calculateTeacherSalary()
        );
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public double getTeacherBaseSalary() {
        return teacherBaseSalary;
    }

    public void setTeacherBaseSalary(double teacherBaseSalary) {
        this.teacherBaseSalary = teacherBaseSalary;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId() {
        teacherId = ++idAcum;
    }

    public abstract double calculateTeacherSalary();
}
