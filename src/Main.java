import java.awt.*;
import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) throws IOException {


        while (true) {

            System.out.println("What do You Want: chose a/s/e");

            Scanner sc = new Scanner(System.in);
            String var = sc.nextLine();
            if (var.equals("e")){
                break;
            }

            File f = new File("password.txt");
            if (!f.exists()) {
                f.createNewFile();
            }

            switch (var) {
                case "a":
                    System.out.println("Enter Site adress");
                    String site = new Scanner(System.in).nextLine();
                    System.out.println("Enter Login");
                    String login = new Scanner(System.in).nextLine();
                    System.out.println("Enter Password");
                    String password = new Scanner(System.in).nextLine();


                    BufferedReader br = new BufferedReader(new FileReader(f));
                    List<String> strings = new LinkedList<>();
                    String str = null;
                    while ((str = br.readLine()) != null) {
                            strings.add(str);
                        }
                    strings.add(ANSI_RESET+"site: ".concat("www.")+site+" login: "+ANSI_RED+login+ANSI_RESET+ANSI_RESET+" password: "+ANSI_RED+password+ANSI_RESET);
                    br.close();

                    PrintWriter pw = new PrintWriter(f);
                    for (String st : strings) {
                        pw.println(st);
                        }
                    pw.close();

                    break;

                case "s":
                    BufferedReader bufr = new BufferedReader(new FileReader(f));
                    List<String>stringss = new LinkedList<>();
                    String st = null;
                    while ((st = bufr.readLine()) != null) {
                        System.out.println(st);
                    }
                    bufr.close();

                        break;

            }



            }
        }
    }


