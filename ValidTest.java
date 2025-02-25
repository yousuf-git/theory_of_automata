import java.util.List;

public class ValidTest {

    public static void main(String[] args) {

        // List<List<String>> alphabetsList = List.of(
        // List.of("a", "b", "c"),
        // List.of("a", "b", "c", "d"),
        // List.of("a", "b", "c", "d", "e")
        // );
        /*
         * 
         * test1 = [] # invalid
         * test2 = ['a', 'ba', 'da', 'aba'] # invalid
         * test3 = ['b', 'ab', 'aab', 'aaab', 'aaabb'] # invalid
         * test4 = ['b', 'aba', 'ab', 'a']
         */
        List<List<String>> alphabetsList = List.of(
                List.of(),
                List.of("a", "ba", "da", "aba"),
                List.of("b", "ab", "aab", "aaab", "aaabb"),
                List.of("b", "aba", "ab", "a"));

        alphabetsList.forEach(alphabet -> {
            System.out.print("Σ = " + alphabet + "\t");
            if (Alphabet.isValid(alphabet)) {
                System.out.println("Valid Alphabet");
            } else {
                System.out.println("Invalid Alphabet");
            }
        });
    }

    public static boolean isValid(List<String> alphabet) {
        if (alphabet == null || alphabet.isEmpty()) {
            return false;
        }

        for (int i = 0; i < alphabet.size() - 1; i++) {
            String currToken = alphabet.get(i);
            for (int j = i + 1; j < alphabet.size(); j++) {
                if (alphabet.get(j).startsWith(currToken))
                    return false;
            }
        }
        return true;
    }
}
