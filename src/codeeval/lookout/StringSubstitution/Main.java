package codeeval.lookout.StringSubstitution;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        BufferedReader bufferedReader = null;
        try {
            File file = new File("C://University/Project_X/inteview_practise/CircularBuffer/src/com/codeeval/lookout/StringSubstitution/playground.txt");
            bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            // Read each line in file.
            while ((line = bufferedReader.readLine()) != null) {
                String[] lineArray = line.split("\\s");
                if (lineArray.length > 0) {
                    for (String ip : lineArray) {
                        List<String> parsed = new ArrayList<String>();

                        Scanner mainScanner = new Scanner(ip);
                        mainScanner.useDelimiter(";");

                        while (mainScanner.hasNext()) {
                            parsed.add(mainScanner.next());
                        }
                        if (parsed.size() == 2) {
                                /*
                                 * Index 0 has the given string S(example: 10011011001),
		            			 * and index 1 has the string F1,R1,F2,R2,...,FN,RN (example: 0110,1001,1001,0,10,11) 
		            			 */
                            handleStringSubstitution(parsed.get(0), parsed.get(1));
                        }

                    }

                }
            }
        } catch (IOException e) {
            System.out.println("File Read Error: " + e.getMessage());
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                System.out.println("Erro closing file." + e.getMessage());
            }

        }

    }

    /**
     * @param inputString      - Given string S
     * @param substituteString - substitution strings
     */
    public static void handleStringSubstitution(String inputString, String substituteString) {

        Map<String, String> substituteStrings = new LinkedHashMap<String, String>();

        Scanner in = new Scanner(substituteString);
        in.useDelimiter(",");
		
		/*
		 * Store the substitution strings in a LinkedHashMap as order needs to be maintained.
		 * Map key: the substring that needs to be searched in the given string S.
		 * Map value: the replacement substring. 
		 */
        while (in.hasNext()) {
            String key = in.next();
            if (in.hasNext()) {
                substituteStrings.put(key, in.next());
            }
        }

        // array that indicates whether a particular index in a string has already been replaced.
        Map<Integer, Boolean> skipIndex = new HashMap<Integer, Boolean>();


        for (String key : substituteStrings.keySet()) {
            Pattern p = Pattern.compile(key);
            Matcher m = p.matcher(inputString);

            while (m.find()) {
                // Indicates whether we need to skip this particular match.
                boolean skipMatch = false;

                int start = m.start();
                int end = m.end();

                for (int i = start; i < end; i++) {
                    if (null != skipIndex.get(i) && skipIndex.get(i)) {
                        skipMatch = true;
                        break;
                    }
                }
                if (skipMatch) {
                    // The given string was already replaced at this index position by an earlier iteration. So skip it.
                    continue;
                } else {
                    // Replace string.

                    int valueLength = substituteStrings.get(key).length();

                    StringBuilder builder = new StringBuilder(inputString);
                    builder.delete(start, end);
                    builder.insert(start, substituteStrings.get(key));
                    inputString = builder.toString();

                    for (int i = start; i < start + valueLength; i++) {
                        skipIndex.put(i, true);
                    }

                    m = p.matcher(inputString);
                }
            }
        }

        // Prints the desired string.
        System.out.println("Result is :" + inputString);

    }


}
