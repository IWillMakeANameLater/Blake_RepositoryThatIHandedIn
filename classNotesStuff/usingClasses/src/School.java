import java.util.*;

public class School {

    // Fields
    private ArrayList<Teacher> teachers;
    private ArrayList<Student> students;

    private String name;
    private String ownerName;
    private String mascot;

    // Methods

    // Full constructor
    // Requires an existing list of teachers ( Why would a NEW school already have a list of Teachers and Students ?)
    // and students
    // as well as the Name of the school
    // the person who owns the school ( Is that the same thing as the principal ? )
    // and the Mascot (however important that is, I swear I didn't run out of ideas for what fields to put in for the school)
    public School(ArrayList<Teacher> teachers, ArrayList<Student> students, String name, String ownerName, String mascot){
        this.teachers = teachers;
        this.students = students;
        this.name = name;
        this.ownerName = ownerName;
        this.mascot = mascot;
    }

    // In case the person doesn't want to specify the students and teachers already in the school
    // Either because those teachers and students have not been hired or enrolled yet
    // Or someone is being lazy,
    // Here would be a shorter way to make a school
    public School(String name, String ownerName, String mascot){
        this.teachers = new ArrayList<Teacher>();
        this.students = new ArrayList<Student>();
        this.name = name;
        this.ownerName = ownerName;
        this.mascot = mascot;
    }

    // Hire (add) a new teacher
    public void addTeacher( Teacher teacher){
        this.teachers.add(teacher);
    }

    // Fire (remove) a teacher from the school (list of teachers)
    public Teacher removeTeacher( int removeAt ){
        if (removeAt < this.students.toArray().length && removeAt >= 0){
            return this.teachers.remove(removeAt);
        } else {
            return null;
        }
    }

    // Enroll (Add) a new student to the list (of attendance obviously)
    public void addStudent( Student student){
        this.students.add(student);
    }

    // Expell ( Remove ) a student (for bad behavior) from the list of students (for attendance)
    public Student removeStudent( int removeAt ){
        if (removeAt < this.students.toArray().length && removeAt >= 0){
            return this.students.remove(removeAt);
        } else {
            return null;
        }
    }

    // Do a head count / attendance check / etc. of the students in the school
    // ( Because, the law, and parents would freak out being the parents they are if someone went missing )
    // Returns the list of students
    // In case someone needs it
    // But will also print the list of students by itself
    public ArrayList<Student> showAllStudents(){
        StringBuilder printString = new StringBuilder("\nStudents:");
        for(int i = 0; i < this.students.toArray().length; i++){
            printString.append(" ").append(this.students.get(i));
            if (i != this.students.toArray().length-1){
                printString.append(",");
            }
        }

        System.out.println(printString.toString());

        return this.students;
    }

    // Do a head count / attendance/ etc. of the teachers in the school ( Don't think they want to do attendance or have to legally but whatever, probably for calculating hours worked for salary or something )
    // It returns the list of teachers as well
    // In case someone needs it for whatever reason
    // It will print the list of teachers by itself though.
    public ArrayList<Teacher> showAllTeachers(){
        StringBuilder printString = new StringBuilder("\nTeachers:");

        for(int i = 0; i < this.teachers.toArray().length; i++){
            printString.append(" ").append(this.teachers.get(i));
            if (i != this.teachers.toArray().length-1){
                printString.append(",");
            }
        }

        System.out.println(printString.toString());

        return this.teachers;
    }
}
