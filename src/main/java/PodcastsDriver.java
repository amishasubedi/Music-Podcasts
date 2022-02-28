import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class PodcastsDriver {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

       // You may use these objects to test your Podcast class
       // rather than enter information in the while loop
       Episode e1 = new Episode("The Summit", "Mike Corey", 46);
        Episode e2 = new Episode("The Death Zone", "Mike Corey", 45);
        Episode e3 = new Episode("The Savage Mountain", "Mike Corey", 52);
        Episode e4 = new Episode("Climbing High Peaks", "Mike Corey", 45);

        Episode ep1 = new Episode("Theranos Startup", "Lindsey Graham", 53);
        Episode ep2 = new Episode("The Walgreens Deal","Lindsey Graham", 37);
        Episode ep3 = new Episode("The Race to Publish", "Lindsey Graham",45);
        Episode ep4 = new Episode("Are VC to Blame", "Lindsey Graham",35);



        Podcasts myLibrary = new Podcasts();



        int choose;
        String title;
        String host;
        int duration;
        int pos;
        Episode e;
        do {
            System.out.println("Choose an action");
            System.out.println("1: Play\n2: Play Next\n3: Play Last\n4: Play Episode Number\n5: Delete Next\n6: Delete Last\n7: Delete a Title\n8: Print List\n9: Exit");
            choose = Integer.parseInt(scan.nextLine());

            switch(choose) {
                case 1:
                    System.out.println(myLibrary.play());
                    break;
                case 2:
                    System.out.println("Enter title, host and duration of podcast");
                    title = scan.nextLine();
                    host = scan.nextLine();
                    duration = Integer.parseInt(scan.nextLine());
                    e = new Episode(title, host, duration);
                    myLibrary.playNext(e);
                    break;
                case 3:
                    System.out.println("Enter title, host and duration of podcast");
                    title = scan.nextLine();
                    host = scan.nextLine();
                    duration = Integer.parseInt(scan.nextLine());
                    e = new Episode(title, host, duration);
                    myLibrary.playLast(e);

                    break;
                case 4:
                    System.out.println("Enter title, host, duration of podcast and position to enter");
                    title = scan.nextLine();
                    host = scan.nextLine();
                    duration = Integer.parseInt(scan.nextLine());
                    pos = Integer.parseInt(scan.nextLine());
                    e = new Episode(title, host, duration);
                    myLibrary.playEpisode(pos, e);
                    break;
                case 5:
                    myLibrary.deleteNext();
                    break;
                case 6:
                    myLibrary.deleteLast();
                    break;
                case 7:
                    System.out.println("Enter title to delete");
                    title = scan.nextLine();
                    myLibrary.deleteEpisode(title);
                    break;
                case 8:
                    System.out.println(myLibrary.toString());



            }

        }while (choose != 9);


    }
}
