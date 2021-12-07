public class Main {
    public static void main(String[] args) {
        School uHellSecondary = new School("University Hell Secondary", "Mr. McDonalds","Hawks"); // ( Initialise a new School object )Somewhere far away in an alternate universe where all light has been lost from the world a new school is founded in a very rainy city in a northern country on earth

        for(int i = 1; i<= 10; i++){
            uHellSecondary.addStudent(new Student("Bob", "Bob", i)); // ( Add students to list of students in school ) All the people who enroll are called bob for some reason, also all grades only have 1 person in them
        }

        for(int i = 0; i < 3; i++){
            uHellSecondary.addTeacher(new Teacher("Vincent", "Kwong", "Physics")); // ( Add 3 teachers to list of teachers in school ) For some reason, 3 Mr. Kwongs have been hired to teach everyone in the school for triple the torture
        }

        uHellSecondary.showAllStudents(); // ( Show all students ) An inspector comes in to check on the school
        uHellSecondary.showAllTeachers(); // ( Show all teachers )

        for(int i = 0; i < 2; i++){ // ( Remove 2 Students from list of students ) 2 Students Drop Out Because school is too hard
            uHellSecondary.removeStudent(0);
        }

        uHellSecondary.removeTeacher(0); // ( Remove a teacher from list of teachers ) One Mr. Kwong gets fired because the school is too hard, but since all the teachers are Mr. Kwong this has no impact on the difficulty of the school

        uHellSecondary.showAllStudents(); // ( Show all students ) The school inspectors do another check on the school's students
        uHellSecondary.showAllTeachers(); // ( Show all teachers ) and teachers

    }
}
