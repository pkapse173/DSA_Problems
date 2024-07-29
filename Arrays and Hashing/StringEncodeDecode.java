//Problem: String Encode and Decode
/*
 * INPUT: ["neet","code","love","you"]
 * OUTPUT: ["neet","code","love","you"]
 */
/*
 * Approach - Arrays
 * Time Complexity - O(L) - L is the length of String
 * Space Complexity - O(L) - L is the length of String
 */
import java.util.ArrayList;
import java.util.List;

public class StringEncodeDecode {
    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        for (String s : strs) {
            encoded.append(s.length()).append("#").append(s);
        }
        return encoded.toString();
    }

    public List<String> decode(String str) {
        List<String> decoded = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            String s = str.substring(j + 1, j + 1 + length);
            decoded.add(s);
            i = j + 1 + length;
        }
        return decoded;
    
    }
}
