import com.sun.javaws.exceptions.InvalidArgumentException;
import com.sun.tools.corba.se.idl.InvalidArgument;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringQuizz {

    public static String removeDuplicates(char[] str) throws InvalidArgumentException {
        // Code from book is such a mess and wrong :
        /*if (str == null) return;
        int len = str.length;
        if (len < 2) return;
        int tail = 1;

        for (int i = 1; i < len; ++i) {
            int j;
            for (j = 0; j < tail; ++j) {
                if (str[i] == str[j]) break;
            }
            if (j == tail) {
                str[tail] = str[i];
                ++tail;
            }
        }
        str[tail] = 0;*/

        if(str == null) throw new InvalidArgumentException(new String[]{"Arguments should not be null"});


        Character[] characters = new Character[str.length];
        for (int i = 0; i < str.length; i++) {
            characters[i] = str[i];
        }
        Map<Character, Long> freq =
                Stream.of(characters).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        StringBuilder builder = new StringBuilder();
        for (Character character : freq.keySet()) {
            builder.append(character);
            //System.out.println("map = " + String.valueOf(character));
        }
        String noDupString = builder.toString();
        System.out.println("noDupString " + noDupString);
        return noDupString;
    }


    static boolean anagram(String s, String t) throws InvalidArgumentException {

        if(s == null | t == null) throw new InvalidArgumentException(new String[]{"Arguments should not be null"});

        if (s.length() != t.length()) return false;
        int[] letters = new int[256];
        int num_unique_chars = 0;
        int num_completed_t = 0;
        char[] s_array = s.toCharArray();
        for (char c : s_array) { // count number of each char in s.
            if (letters[c] == 0) ++num_unique_chars;
            ++letters[c];
        }
        for (int i = 0; i < t.length(); ++i) {
            int c = (int) t.charAt(i);
            if (letters[c] == 0) { // Found more of char c in t than in s.
                return false;
            }
            --letters[c];
            if (letters[c] == 0) {
                ++num_completed_t;
                if (num_completed_t == num_unique_chars) {
                    // it’s a match if t has been processed completely
                    return i == t.length() - 1;
                }
            }
        }
        return false;
    }

}
