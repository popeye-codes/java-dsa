package com.shivam.filehandling;

import java.io.*;

public class Main {
    public static void main(String[] args) {

//        try (InputStreamReader isr = new InputStreamReader(System.in)) {
//            System.out.println("Enter some letters: ");
//            /// taking Data in Byte - Stream
//            int letters = isr.read();
//
//            while (isr.ready()) {
//                ///  putting out data in Character - Stream => reading one char at a time
//                System.out.println((char) letters);
//                letters = isr.read();
//            }
//            isr.close();
//            System.out.println();
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }

//        ///  file Reader
//        try (FileReader fre = new FileReader("src/com/raj/fileHandling/note.txt")) {
//
//            int letters = fr.read();
//
//            while (fr.ready()) {
//                ///  putting out data in Character - Stream
//                System.out.println((char) letters);
//                letters = fr.read();
//            }
//            System.out.println();
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//
//        // constructor is of type reader => convert "System.in " into character String using this i.e; new InputStreamReader(System.in)
//       /// byte to char String and then reading char - String using bufferedReader
//        try {
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            System.out.println("You typed: " + br.readLine()); /// read entire Line at once
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//
//
//        /// to read entire file
//        try {
//            BufferedReader br = new BufferedReader( new FileReader("src/com/raj/fileHandling/note.txt"));
//            while (!br.ready()) {
//                System.out.println(br.readLine());
//            }
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//
//

        /// -------------- Writer / output ------------>
        ///  Only 4 - public Method are available here: -> getEncoding(), write(), flush() and close()

        OutputStream os = System.out;
        /// os.write(😍); => error because RaNGE is Exceeded

        System.out.println();

        try {
            OutputStreamWriter osw = new OutputStreamWriter(System.out); // will take outStream type in it
            osw.write("Hello World"); // As inside OutputStream Method being Overloaded => Called the Method That takes string Type as Argument.

            osw.write(97);
            osw.write(10);
            osw.write('A');
            osw.write('\n');

            char[] arr = "hello world".toCharArray();
            osw.write(arr);

            osw.flush(); //🌟important
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }



        /// ------- BufferedWriter ------
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("src/com/raj/fileHandling/note.txt", true)); // will take outStream type in it
            bw.write("Hare Krishna");
            bw.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
