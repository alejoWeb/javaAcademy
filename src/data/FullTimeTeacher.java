package data;

public class FullTimeTeacher extends Teacher {

    private double teacherYearsOfExperience;

    public FullTimeTeacher(String teacherName, double teacherBaseSalary, double teacherYearsOfExperience) {
        super(teacherName, teacherBaseSalary);
        setTeacherYearsOfExperience(teacherYearsOfExperience);
    }

    @Override
    public double calculateTeacherSalary() {
        return getTeacherBaseSalary() * teacherYearsOfExperience * 1.1;
    }

    @Override
    public void getTeacherInfo() {
        super.getTeacherInfo();
        System.out.println("Years of experience: " + getTeacherYearsOfExperience() +
                "\nType: Full time teacher" +
                "\n---------------------------------------------");
    }

    public double getTeacherYearsOfExperience() {
        return teacherYearsOfExperience;
    }

    public void setTeacherYearsOfExperience(double teacherYearsOfExperience) {
        this.teacherYearsOfExperience = teacherYearsOfExperience;
    }

}

