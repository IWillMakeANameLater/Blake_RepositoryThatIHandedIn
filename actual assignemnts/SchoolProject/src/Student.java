public class Student {
    // Fields

    private String firstName;
    private String lastName;
    private int grade;

    public static int studentCount; // Generator so every student has a unique ID
    private int studentID; // Unique ID of the student

    // Methods

    // Full Constructor
    // Requires their first name
    // Last name
    // and Grade ( Seems strange that they can declare themselves to be grade 13, grade -1, etc.)
    public Student(String firstName, String lastName, int grade){

        this.studentID = studentCount;
        studentCount++;

        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() { // Make the Student introduce themselves
        return "\nName: " + this.firstName + " " + this.lastName + "\nGrade: " + this.grade;
    }
}
