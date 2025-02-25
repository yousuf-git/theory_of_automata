import java.util.ArrayList;

import java.util.List;

import javax.naming.directory.InvalidAttributesException;

public class Alphabet<T> {

    private List<T> tokens;
    
    Alphabet() {
        tokens = new ArrayList<>();
    }

    Alphabet(List<T> tokens) throws InvalidAttributesException {
        if (isValid(tokens)) {
            this.tokens = tokens;
            return;
        }
        throw new InvalidAttributesException("Not valid tokens for Alphabet !");
    }

    // getter, setter

    public void setTokens(List<T> tokens) {
        this.tokens = tokens;
    }
    
    public List<T> getTokens() {
        return tokens;
    }

    public String toString() {
        return tokens.toString();
    }
    
    // add
    public void add(T token) {
        tokens.add(token);
    }

    // remove
    public void remove(T token) {
        if (token == null) {
            return;
        }
        tokens.remove(token);
    }

    public boolean isEmpty() {
        return tokens.isEmpty();
    }

    public static boolean isValid(List<?> tokens) {
        if (tokens.isEmpty()) {
            return false;
        }

        for (int i = 0; i < tokens.size() - 1; i++) {
            String currToken = tokens.get(i).toString();
            for (int j = i + 1; j < tokens.size(); j++) {
                if (tokens.get(j).toString().startsWith(currToken))
                    return false;
            }
        }
        return true;
    }

    public boolean containsToken(Object token) {
        return tokens.contains(token);
    }

    public boolean isValidWord(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }

        // int len = 0;
        int idx = 0;
        int strSize = str.length();
        while (idx < strSize) {
            String currToken = String.valueOf(str.charAt(idx));
            boolean isFound = false;
            while (idx < strSize) {
                if (this.containsToken(currToken)) {
                    isFound = true;
                    break;
                } else {
                    if (idx + 1 == strSize) return false;               // last char not found as token
                    currToken += String.valueOf(str.charAt(++idx));     // increasing token size
                }
            }
            if (isFound) {
                idx++;
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    /*
     * @return      0 if not a valid word over this Alphabet, length otherwise
     */
    public int lengthOf(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }

        int len = 0;            // Length to calculate with respect to this Alphabet
        int idx = 0;
        int strSize = str.length();     // overall characters in given string
        while (idx < strSize) {
            String currToken = String.valueOf(str.charAt(idx));
            boolean isFound = false;
            while (idx < strSize) {
                if (this.containsToken(currToken)) {
                    isFound = true;
                    break;
                } else {
                    if (idx + 1 == strSize) return 0;               // last char not found as token
                    currToken += String.valueOf(str.charAt(++idx));     // increasing token size
                }
            }
            if (isFound) {
                idx++;
                len++;
            } else {
                return 0;
            }
        }
        return len;
    }
    
    // static boolean isEmpty(int[] alphabets) {
    //     return alphabets.length == 0;
    // }
}