package util;

import java.util.ArrayList;
import java.util.List;

public class StringUtils {

    public static final String DELIMINATOR = ">";

    public static List<String> splitInput(String input) {
        List<String> result = new ArrayList<>();
        for (String split : input.split(DELIMINATOR)
        ) {
            result.add(split.trim());
        }
        return result;
    }
}
