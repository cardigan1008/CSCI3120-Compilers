public class Main {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.exit(1);
        }
        String inputFile = args[0];
        try {
            java.nio.file.Path path = java.nio.file.Paths.get(inputFile);
            java.util.List<String> lines = java.nio.file.Files.readAllLines(path);
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (java.io.IOException e) {
            System.exit(1);
        }
    }
}
