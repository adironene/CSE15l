//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class MarkdownParse {

    private static String content = "";

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0;
        while (currentIndex < markdown.length()) {
            int openBracket = markdown.indexOf("[", currentIndex);
            int closeBracket = markdown.indexOf("]", openBracket);
            int openParen = markdown.indexOf("(", closeBracket);
            int closeParen = markdown.indexOf(")", openParen);
            if (openBracket == -1 || closeBracket == -1 || openParen == -1 || closeParen == -1) {
                break;
            }
            if (openBracket != 0 && markdown.substring(openBracket - 1, openBracket).equals("!")) {
                currentIndex = closeParen + 1;
                continue;
            }
            toReturn.add(markdown.substring(openParen + 1, closeParen));
            currentIndex = closeParen + 1;
        }

        return toReturn;
    }
    private static String checkString(Path p) throws IOException{
        try {
            content = Files.readString(p);
        } catch (java.nio.file.NoSuchFileException e) {
            System.out.println("Please type the name of MarkDown file to be parsed");
            Scanner scan = new Scanner(System.in);
            Path newPath = Path.of(scan.nextLine());
            checkString(newPath);
        }
        return content;
    }
    public static void main(String[] args) throws IOException {
        Path fileName;
        if (args.length == 0) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Please type the name of MarkDown file to be parsed");
            fileName = Path.of(scan.nextLine());
        } else {
            fileName = Path.of(args[0]);
        }
        ArrayList<String> links = getLinks(checkString(fileName));
        System.out.println(links);
    }
}