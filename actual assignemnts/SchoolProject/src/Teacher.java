public class Teacher {
    //Fields

    private String firstName;
    private String lastName;
    private String subject;

    //Methods


    // Full Constructor
    // This requires them to have a first name
    // A last name
    // and what subject they'd like to teach
    // ( Quite strange that it does not ask for or even require an actual degree or credentials )
    public Teacher(String firstName, String lastName, String subject){
        this.firstName = firstName;
        this.lastName = lastName;
        this.subject = subject;
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString(){ // Make the teacher introduce themselves ( do they even do that anymore ?)
        return "\nName: " + this.firstName + " " + this.lastName + "\nSubject: " + this.subject;
    }
}
