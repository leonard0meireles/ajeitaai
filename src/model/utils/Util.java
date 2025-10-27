import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/**
 * Util class
 * @author Leonardo
 * @version 0.0.1
 * @since 0.0.1
 */
public class Util {
    /**
     * Read the file based on string path param and returns all the lines in the
     * file as list of strings
     * 
     * @param path
     * @return list of strings
     * @since 0.0.1
     * @throws IOException
     */
    public static List<String> readFile(String path) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            return lines;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Make the file and align the elements in a single line, separate by commas.
     * Example: a, b, c, d, e, f ... z
     * @param lines
     * @since 0.0.1
     * @throws IOException
     */
    public static void makeFile(List<String> lines, String path) {
        Scanner scanner = new Scanner(System.in);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(path)))) {
            for (String string : lines) {
                if (lines.getLast().equals(string)) {
                    bufferedWriter.append(string);
                } else {
                    bufferedWriter.append(string + ", ");
                }
            }
            System.out.println("Output file created!!!!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        scanner.close();
    }
    /**
     * Method to print the help message.
     * @since 0.0.1
     */
    public static void printHelp() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Usage: java -jar ajeitaai.jar [OPTIONS] FILE");
        stringBuilder.append("\n Options: ");
        stringBuilder.append("\n   -h, --help \t\t\t Print the help and exit");
        stringBuilder.append("\n   -v, --version \t\t Print the current version and exit");
        stringBuilder.append("\n   -f, --file FILE \t\t Read the file with data on the format: " +
                "\n\t\t\t\t a\n\t\t\t\t b\n\t\t\t\t c\n\t\t\t\t d\n\t\t\t\t ... \n\t\t\t\t " +
                "And create a new file by default named as \"output.txt\" with the format: a, b, c, d ...");
        stringBuilder.append("\n -o, --output FILE \t\t Output filename");
        System.out.println(stringBuilder.toString());
    }
}
