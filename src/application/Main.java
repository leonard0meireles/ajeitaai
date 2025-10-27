import java.util.List;
/**
 * Main Class
 * @author Leonardo
 * @version 0.0.1
 * @since 0.0.1
 */
public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            Util.printHelp();
            return;
        }
        if (args[0].equals("-h") || args[0].equals("--help")) {
           Util.printHelp();
        }
        if ((args[0].equals("-f") || args[0].equals("--file")) && (args[2].equals("-o") || args[2].equals("--output"))) {
            List<String> lines = Util.readFile(args[1]);
            Util.makeFile(lines, args[3]);
            return;    
        }
        if (args[0].equals("-f") || args[0].equals("--file")) {
            List<String> lines = Util.readFile(args[1]);
            Util.makeFile(lines, "output.txt");
            return;    
        }
        if (args[0].equals("-v") || args[0].equals("--version")) {
            System.out.println("ajeitaai version 0.0.1");
        }
        
    }
}
