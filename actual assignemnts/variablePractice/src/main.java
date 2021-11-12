import java.util.HashMap;
import java.util.Map;

public class main {
    public static void main(String[] args) {
        int arbitraryNumber = 113;
        double arbitraryDouble = 2.71828;

        String arbitraryString = "Computer Science";

        System.out.print(arbitraryNumber + "\n" + arbitraryDouble + "\n" +  arbitraryString);

        String edgeBorder = "+--------------------------------------------------+";

        Map<String, String> teacherLists = new HashMap<String, String>();
        teacherLists.put("English", "Ms. Kwan");
        teacherLists.put("Math", "Mr. Beaton");
        teacherLists.put("Physics", "Mr. Kwong");
        teacherLists.put("Computer Science", "Mr. Zaremba");
        teacherLists.put("French", "Don't Know");
        teacherLists.put("Chemistry", "IDK");
        teacherLists.put("Art", "One of the two");
        teacherLists.put("Social Studies", "Probably Alves");

        int teacherNumberCount = 0;

        System.out.print("\n" + edgeBorder);
        for(Map.Entry<String, String> teacherClassEntry : teacherLists.entrySet()) {
            String teacherClass = teacherClassEntry.getKey();
            String teacherName = teacherClassEntry.getValue();
            teacherNumberCount++;

            int class_LengthDiff = 26 - teacherClass.length();
            int teacherName_LengthDiff = 15 - teacherName.length();

            System.out.print("\n[ " + teacherNumberCount + " ]");
            for (int i = 0; i <= class_LengthDiff; i++){
                System.out.print(" ");
            }
            System.out.print(teacherClass);
            System.out.print(" |");
            for (int i = 0; i <= teacherName_LengthDiff; i++){
                System.out.print(" ");
            }
            System.out.print(teacherName);
            System.out.print(" |");
        }
        System.out.print("\n" + edgeBorder);
    }
}
