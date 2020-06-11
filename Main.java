package encryptdecrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String mode = "enc";
        int key = 0;
        String data = "";
        String input = "";
        String output = "";
        int z = args.length;
        for (int i = 0; i < args.length - 1; i++) {
            if (args[i].equals("-mode")) {
                mode = args[i + 1];
            } else if (args[i].equals("-key")) {
                key = Integer.parseInt(args[i + 1]);
            } else if (args[i].equals("-data")) {
                data = args[i + 1];
            } else if (args[i].equals("-in")) {
                input = args[i + 1];
            } else if (args[i].equals("-out")) {
                output = args[i + 1];
            }
        }
        File file = new File(input);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }


        try {
            if (data.equals("")) {
                while (scanner.hasNext()) {
                    data = scanner.nextLine();
                }
            }
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }

        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(output);
        } catch (FileNotFoundException e) {
            System.out.println("Error " + e.getMessage());
        }


        if (mode.equals("enc")) {
            char[] chars = data.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                int x = chars[i];
                int y = x + key;
                chars[i] = (char) y;
            }
            String res = String.valueOf(chars);
            if (output.equals("")) {
                System.out.println(res);
            } else printWriter.write(res);
        } else if (mode.equals("dec")) {
            char[] chars = data.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                int x = chars[i];
                int y = x - key;
                chars[i] = (char) y;
            }
            String res = String.valueOf(chars);
            if (output.equals("")) {
                System.out.println(res);
            } else printWriter.write(res);
        }

        scanner.close();
        printWriter.close();


    }
}

