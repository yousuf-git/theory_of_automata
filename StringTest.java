import java.util.List;

public class StringTest {
    public static void main(String[] args) {
        // List<String> tokens = List.of("b", "ab", "aaba");
        List<String> tokens = List.of("0", "10", "110");
        
        try {
            Alphabet<String> alphabet = new Alphabet<>(tokens);    
            // String str = "aabaabb";                             // Target string (len = 3)
            String str = "00101011010100";                         // Target string (len = 8)
            if (alphabet.isValidWord(str)) {
                System.out.println(str + " is valid Word from alphabet " + alphabet.toString());
                int len = alphabet.lengthOf(str);
                System.out.println("Length: " + len);
            } else {
                System.out.println(str + " is not a Valid Word over " + alphabet.toString());
            }
            
        
        } catch (Exception e) {
            System.out.println(e.getMessage());     // if not valid tokens are used for alphabet
        }
        

    }
}
