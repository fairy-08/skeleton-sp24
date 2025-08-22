import java.util.ArrayList;
import java.util.List;

public class ListExercises {

    /** Returns the total sum in a list of integers */
	public static int sum(List<Integer> L) {
        // TODO: Fill in this function.
        int result = 0;
        for (int num : L) {
            result += num;
        }
        return result;
    }

    /** Returns a list containing the even numbers of the given list */
    public static List<Integer> evens(List<Integer> L) {
        // TODO: Fill in this function.
        List<Integer> lst = new ArrayList<>();
        for (int num : L) {
            if (num % 2 == 0) {
                lst.add(num);
            }
        }
        return lst;
    }

    /** Returns a list containing the common item of the two given lists */
    public static List<Integer> common(List<Integer> L1, List<Integer> L2) {
        // TODO: Fill in this function.
        List<Integer> lst = new ArrayList<>();
        for (int num1 : L1) {
            boolean isCommon = false;
            for (int num2 : L2) {
                if (num1 == num2) {
                    isCommon = true;
                }
            }
            if (isCommon) {
                lst.add(num1);
            }
        }
        return lst;
    }


    /** Returns the number of occurrences of the given character in a list of strings. */
    public static int countOccurrencesOfC(List<String> words, char c) {
        // TODO: Fill in this function.
        int times = 0;
        String s = String.valueOf(c);
        for (String word : words) {
            if (word.contains(s)) {
                times++;
            }
        }
        return times;
    }
}
