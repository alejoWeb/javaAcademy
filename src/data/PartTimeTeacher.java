package data;

public class PartTimeTeacher extends Teacher {

    private double teacherActiveHoursPerWeek;

    public PartTimeTeacher(String teacherName, double teacherBaseSalary, double teacherActiveHoursPerWeek) {
        super(teacherName, teacherBaseSalary);
        setTeacherActiveHoursPerWeek(teacherActiveHoursPerWeek);
    }

    @Override
    public double calculateTeacherSalary() {
        return getTeacherBaseSalary() * teacherActiveHoursPerWeek;
    }

    @Override
    public void getTeacherInfo() {
        super.getTeacherInfo();
        System.out.println("Active hours per week: " + getTeacherActiveHoursPerWeek() +
                "\nType: Part time teacher" +
                "\n---------------------------------------------");
    }

    public double getTeacherActiveHoursPerWeek() {
        return teacherActiveHoursPerWeek;
    }

    public void setTeacherActiveHoursPerWeek(double teacherActiveHoursPerWeek) {
        this.teacherActiveHoursPerWeek = teacherActiveHoursPerWeek;
    }

}

