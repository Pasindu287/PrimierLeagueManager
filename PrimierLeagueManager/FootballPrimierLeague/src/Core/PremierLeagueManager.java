package Core;

import GUI.MainMenu;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class PremierLeagueManager implements LeagueManager  {
    public static List<FootballClub> list = new ArrayList<>();//main array list
    public static List<SchoolFootBallClub> scllist = new ArrayList<>();//school club arry  list
    public static List<UniversityFootballClub> unilist = new ArrayList<>();//university club arry list
    public static Scanner scn = new Scanner(System.in);

    public static void premierLeague() throws IOException {
        readData("Football.text", 1);//read the data in file
        readData("SclFootball.text", 2);//read the data in file
        readData("UniFootball.text", 3);//read the data in file
        boolean y = true;
        MainMenu gui = new MainMenu();
        do {
            System.out.println("Enter 1 to add new Football club \n2 Add Footall Match \n3 To delete Football club ");
            System.out.println("4 to Display the various statistics for Football  club\n5 to Display the Premier League Table \n6 open GUI  \n7 to exit");
            System.out.print("Enter your choice : ");
            int choice = scn.nextInt();
            switch (choice) {//choice to select ithem league manager want
                case 1:
                    crateFootballClb();
                    //create new foot ball club
                    break;
                case 2:
                    addfootballmatch();
                    //create new foot ball match
                    break;
                case 3:
                    deleteFootballClb();
                    //delete foot ball club
                    break;
                case 4:
                    statisticsOfClub();
                    //statisticsfoot ball club
                    break;
                case 5:
                    premierLeagueTable();
                    //premier League Table
                    break;
                case 6:
                    gui.openGui();
                    //GUI part
                    break;
                case 7:
                    toexit();
                    break;

                default:
                    System.out.println("Invalid input");
                    break;
            }
            System.out.println("want to process more in Main Console? y/n");
            String x = scn.next();
            char ch = x.charAt(0);
            if (ch == 'n')
                y = false;
        }
        while (y != false);
    }

        public static void crateFootballClb () {
            boolean y = true;
            do {
                System.out.println();
                System.out.println("Select type of Football Club \n1. FootBall club \n2.School FootBall club \n3.University FootBall club ");
                System.out.print("\n4 to exit");
                System.out.print("Enter the Selection : ");
                int selection = scn.nextInt();
                switch (selection) {
                    case 1:
                        mainFootballClub();
                        break;
                    case 2:
                        schoolFootBallClub();
                        break;
                    case 3:
                        UniversityFootBallClub();
                        break;
                    case 4:
                        toexit();
                        break;
                    default:
                        System.out.println("Invalid input");
                        break;
                }
                System.out.println("want to process more for add football club? y/n");
                String x = scn.next();
                char ch = x.charAt(0);
                if (ch == 'n')
                    y = false;

            } while (y != false);


        }
        public static void addfootballmatch() {
            boolean y = true;
            do {
                System.out.println();
                System.out.println("Select type of Football Club \n1. FootBall club \n2.School FootBall club \n3.University FootBall club ");
                System.out.print("\n4 to exit");
                System.out.print("Enter the Selection : ");
                int selection = scn.nextInt();
                scn.nextLine();
                switch (selection) {
                    case 1:
                        System.out.println(" ");
                        System.out.println("Enter Date Following format(DD/MM/YYYY) : ");
                        String date = scn.nextLine();
                        Date enteredDate = new Date();
                        try {//create date following formate
                            enteredDate = new SimpleDateFormat("dd/MM/yyyy").parse(date);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        System.out.println("Enter Football club name: ");
                        String club1Name = scn.nextLine();
                        System.out.println("Enter Football club Score:");
                        int club1Score ;
                        do {//validate
                            try {
                                club1Score = scn.nextInt();
                                break;
                            } catch (InputMismatchException e) {
                            }
                        } while (true);
                        scn.nextLine();
                        System.out.println("Enter Football club name:");
                        String club2Name = scn.nextLine();
                        System.out.println("Enter Football club Score:");
                        int club2Score;
                        do {
                            try {
                                club2Score = scn.nextInt();
                                break;
                            } catch (InputMismatchException e) {
                            }
                        } while (true);
                        boolean foundBothClubs = false;
                        outer:
                        for (int i = 0; i < list.size(); i++) {
                            if (list.get(i).getFtballclbName().equalsIgnoreCase(club1Name)) {//find first football club
                                inner:
                                for (int x = 0; x < list.size(); x++) {
                                    if (list.get(x).getFtballclbName().equalsIgnoreCase(club2Name)) {//find second football club
                                        foundBothClubs = true;
                                        Match match1 = new Match(club1Name, club1Score, club2Name, club2Score, enteredDate, false);
                                        Match match2 = new Match(club2Name, club2Score, club1Name, club1Score, enteredDate, true);
                                        list.get(i).setPlayed();
                                        list.get(x).setPlayed();
                                        list.get(i).setGoals(club1Score);
                                        list.get(x).setGoals(club2Score);
                                        if (club1Score > club2Score) {
                                            list.get(i).setWon();
                                            list.get(x).setLost();
                                        } else if (club1Score < club2Score) {
                                            list.get(x).setWon();
                                            list.get(i).setLost();
                                        } else if (club1Score == club2Score) {
                                            list.get(i).setDraw();
                                            list.get(x).setDraw();
                                        }
                                        list.get(i).addMatch(match1);//add footbll match
                                        list.get(x).addMatch(match2);//add footbll match
                                        System.out.println("Match was Added!!!");

                                        try {
                                            File file = new File("Football.text");
                                            FileOutputStream fileOutputStream = new FileOutputStream(file);
                                            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                                            objectOutputStream.writeObject(list);


                                        } catch (Exception e) {
                                            System.out.println(e);
                                        }
                                        break outer;


                                    }
                                }
                            }
                        }

                        if (!foundBothClubs) {
                            System.out.println("no club found !!");
                        }
                        break;

                    case 2:
                        System.out.println(" ");
                        System.out.println("Enter Date Following format(DD/MM/YYYY) : ");
                        String scldate = scn.nextLine();
                        Date enteredsclDate = new Date();
                        try {
                            enteredsclDate = new SimpleDateFormat("dd/MM/yyyy").parse(scldate);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        System.out.println("Enter Football club name ");
                        String sclclub1Name = scn.nextLine();
                        System.out.println("Enter Football club Score");
                        int sclclub1Score;
                        do {
                            try {
                                sclclub1Score = scn.nextInt();
                                break;
                            } catch (InputMismatchException e) {
                            }
                        } while (true);
                        scn.nextLine();
                        System.out.println("Enter Football club name ");
                        String sclclub2Name = scn.nextLine();
                        System.out.println("Enter Football club Score");
                        int sclclub2Score;
                        do {
                            try {
                                sclclub2Score = scn.nextInt();
                                break;
                            } catch (InputMismatchException e) {
                            }
                        } while (true);
                        boolean sclfoundBothClubs = false;

                        outer:
                        for (int i = 0; i < scllist.size(); i++) {
                            if (scllist.get(i).getSclftballclbName().equalsIgnoreCase(sclclub1Name)) {
                                inner:
                                for (int x = 0; x < scllist.size(); x++) {
                                    if (scllist.get(x).getSclftballclbName().equalsIgnoreCase(sclclub2Name)) {
                                        sclfoundBothClubs = true;
                                        Match match1 = new Match(sclclub1Name, sclclub1Score, sclclub2Name, sclclub2Score, enteredsclDate, false);
                                        Match match2 = new Match(sclclub2Name, sclclub2Score, sclclub1Name, sclclub1Score, enteredsclDate, false);
                                        scllist.get(i).setPlayed() ;
                                        scllist.get(x).setPlayed();
                                        scllist.get(i).setGoals(sclclub1Score);
                                        scllist.get(x).setGoals(sclclub2Score);
                                        if (sclclub1Score > sclclub2Score) {
                                            scllist.get(i).setWon();
                                            scllist.get(x).setLost();

                                        } else if (sclclub1Score < sclclub2Score) {
                                            scllist.get(x).setWon();
                                            scllist.get(i).setLost();

                                        } else if (sclclub1Score == sclclub2Score) {
                                            scllist.get(i).setDraw();
                                            scllist.get(x).setDraw();
                                        }
                                        scllist.get(i).addMatch(match1);
                                        scllist.get(x).addMatch(match2);
                                        System.out.println("Match was Added!!!");

                                        try {
                                            File file = new File("SclFootball.text");
                                            FileOutputStream fileOutputStream = new FileOutputStream(file);
                                            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                                            objectOutputStream.writeObject(scllist);


                                        } catch (Exception e) {
                                            System.out.println(e);
                                        }
                                        break outer;
                                    }
                                }
                            }
                        }

                        if (!sclfoundBothClubs) {
                            System.out.println("no club found !!");
                        }

                        break;
                    case 3:
                        System.out.println(" ");
                        System.out.println("Enter Date Following format(DD/MM/YYYY) : ");
                        String unidate = scn.nextLine();
                        Date entereduniDate = new Date();
                        try {
                            entereduniDate = new SimpleDateFormat("dd/MM/yyyy").parse(unidate);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        System.out.println("Enter Football club name ");
                        String uniclub1Name = scn.nextLine();
                        System.out.println("Enter Football club Score");
                        int uniclub1Score ;
                        do {
                            try {
                                uniclub1Score = scn.nextInt();
                                break;
                            } catch (InputMismatchException e) {
                            }
                        } while (true);
                        scn.nextLine();
                        System.out.println("Enter Football club name ");
                        String uniclub2Name = scn.nextLine();
                        System.out.println("Enter Football club Score");
                        int uniclub2Score ;
                        do {
                            try {
                                uniclub2Score = scn.nextInt();
                                break;
                            } catch (InputMismatchException e) {
                            }
                        } while (true);
                        boolean unifoundBothClubs = false;

                        outer:
                        for (int i = 0; i < unilist.size(); i++) {
                            if (unilist.get(i).getUniftballclbName().equalsIgnoreCase(uniclub1Name)) {
                                inner:
                                for (int x = 0; x < unilist.size(); x++) {
                                    if (unilist.get(x).getUniftballclbName().equalsIgnoreCase(uniclub2Name)) {
                                        unifoundBothClubs = true;
                                        Match match1 = new Match(uniclub1Name, uniclub1Score, uniclub2Name, uniclub2Score, entereduniDate, false);
                                        Match match2 = new Match(uniclub2Name, uniclub2Score, uniclub1Name, uniclub1Score, entereduniDate, false);
                                        unilist.get(i).setPlayed() ;
                                        unilist.get(x).setPlayed();
                                        unilist.get(i).setGoals(uniclub1Score);
                                        unilist.get(x).setGoals(uniclub2Score);
                                        if (uniclub1Score > uniclub2Score) {
                                            unilist.get(i).setWon();
                                            unilist.get(x).setLost();

                                        } else if (uniclub1Score < uniclub2Score) {
                                            unilist.get(x).setWon();
                                            unilist.get(i).setLost();

                                        } else if (uniclub1Score == uniclub2Score) {
                                            unilist.get(i).setDraw();
                                            unilist.get(x).setDraw();
                                        }
                                        unilist.get(i).addMatch(match1);
                                        unilist.get(x).addMatch(match2);
                                        System.out.println(" Match was Added!!!");
                                        try {
                                            File file = new File("UniFootball.text");
                                            FileOutputStream fileOutputStream = new FileOutputStream(file);
                                            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                                            objectOutputStream.writeObject(list);


                                        } catch (Exception e) {
                                            System.out.println(e);
                                        }
                                        break outer;
                                    }
                                }
                            }
                        }

                        if (!unifoundBothClubs) {
                            System.out.println("no club found !!");
                        }

                        break;
                    case 4:
                        toexit();
                        break;
                    default:
                        System.out.println("Invalid input !!");
                        break;
                }
                System.out.println("want to process more for Add Matches? y/n");
                String x = scn.next();
                char ch = x.charAt(0);
                if (ch == 'n')
                    y = false;

            } while (y != false);

        }

        private static void mainFootballClub () {
            System.out.println("Enter Following FootBallClub Details");
            System.out.println("   ");
            String srt = scn.nextLine();
            System.out.print("FootBallClub Name : ");
            String ftballclbName = scn.nextLine();
            System.out.print("FootBallClub Colour : ");
            String ftballclbColour = scn.nextLine();
            System.out.print("FootBallClub Couch Name : ");
            String ftballclbCouach = scn.nextLine();
            System.out.print("FootBallClub ID : ");
            int ftballclbId;
            do {//validate
                try {
                    ftballclbId = scn.nextInt();
                    break;
                } catch (InputMismatchException e) {
                }
            } while (true);

            FootballClub Ft = new FootballClub(ftballclbName, ftballclbColour,
                    ftballclbCouach, ftballclbId);
            list.add(Ft);
            System.out.println(" Foot ball Club is Added!!");

            try {
                File file = new File("Football.text");
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(list);


            } catch (Exception e) {
                System.out.println(e);
            }


        }

        public static void schoolFootBallClub () {
            System.out.println("Enter Following School FootBallClub Details");
            System.out.println("    ");
            String srt = scn.nextLine();
            System.out.print("School Name : ");
            String sclName = scn.nextLine();
            System.out.print("School FootBallClub Name : ");
            String sclftballclbName = scn.nextLine();
            System.out.print("School FootBallClub Colour : ");
            String sclftballclbColour = scn.nextLine();
            System.out.print("School FootBallClub Couch Name : ");
            String sclftballclbCouach = scn.nextLine();
            System.out.print("School FootBallClub ID : ");
            int sclftballclbId;

            do {//validate
                try {
                    sclftballclbId = scn.nextInt();
                    break;
                } catch (InputMismatchException e) {
                }
            } while (true);

            SchoolFootBallClub sclFt = new SchoolFootBallClub(sclName, sclftballclbName, sclftballclbColour,
                    sclftballclbCouach, sclftballclbId);
            scllist.add(sclFt);
            System.out.println("School Foot ball Club is Added!!");

            try {
                File file = new File("SclFootball.text");
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(scllist);
            } catch (Exception e) {
                System.out.println(e);
            }

            }
        private static void UniversityFootBallClub () {
            System.out.println("Enter Following University FootBallClub Details");
            System.out.println("   ");
            String srt = scn.nextLine();
            System.out.print("University Name : ");
            String uniName = scn.nextLine();
            System.out.print("University FootBallClub Name : ");
            String uniftballclbName = scn.nextLine();
            System.out.print("University FootBallClub Colour : ");
            String uniftballclbColour = scn.nextLine();
            System.out.print("University FootBallClub Couch Name : ");
            String uniftballclbCouach = scn.nextLine();
            System.out.print("University FootBallClub ID : ");
            int uniftballclbId;
            do {
                try {//validate
                    uniftballclbId = scn.nextInt();
                    break;
                } catch (InputMismatchException e) {
                }
            } while (true);
            UniversityFootballClub uniFt = new UniversityFootballClub(uniName, uniftballclbName, uniftballclbColour,
                    uniftballclbCouach, uniftballclbId);
            unilist.add(uniFt);//add the list
            System.out.println("university Foot ball Club is Added!!");
            try {
                File file = new File("UniFootball.text");//add the file
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(unilist);
            } catch (Exception e) {
                System.out.println(e);
            }


        }


        public static void deleteFootballClb () {
            boolean y = true;
            do {
                System.out.println();
                System.out.println("Select type of Football Club \n1. FootBall club \n2.School FootBall club \n3.University FootBall club ");
                System.out.print("\n4 to exit");
                System.out.print("Enter the Selection : ");
                int selection = scn.nextInt();
                switch (selection) {
                    case 1:
                        System.out.println("    ");
                        String srt = scn.nextLine();
                        System.out.println("Insert club name: ");
                        String ftballclbName = scn.nextLine();
                        boolean clubFound = false;
                        for (FootballClub Ft : list) {
                            if (Ft.getFtballclbName().equals(ftballclbName)) {
                                list.remove(Ft);
                                System.out.println("Club " + Ft.getFtballclbName() + " removed!!!");
                                try {
                                    File file = new File("Football.text");
                                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                                    objectOutputStream.writeObject(list);
                                } catch (Exception e) {
                                    System.out.println(e);
                                }
                                clubFound = true;
                                break;
                            }
                        }
                        if(!clubFound) {
                            System.out.println("No such club in league");
                        }
                        break;
                    case 2:
                        System.out.println("    ");
                        System.out.println("Insert club name: ");
                        String sclftballclbName = scn.nextLine();
                        boolean sclclubFound = false;
                        for (SchoolFootBallClub sclFt : scllist) {
                            if (sclFt.getSclftballclbName().equals(sclftballclbName)) {
                                list.remove(sclFt);
                                System.out.println("Club " + sclFt.getSclftballclbName() + " removed!!!");
                                try {
                                    File file = new File("SclFootball.text");
                                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                                    objectOutputStream.writeObject(scllist);

                                } catch (Exception e) {
                                    System.out.println(e);
                                }
                                sclclubFound = true;
                                break;
                            }
                        }
                        if(!sclclubFound) {
                            System.out.println("No such club in league");
                        }
                        break;
                    case 3:
                        System.out.println("    ");
                        System.out.println("Insert club name: ");
                        String uniftballclbName = scn.nextLine();
                        boolean uniclubFound = false;
                        for (UniversityFootballClub uniFt : unilist) {
                            if (uniFt.getUniftballclbName().equals(uniftballclbName)) {
                                list.remove(uniFt);//remove from list
                                System.out.println("Club " + uniFt.getUniftballclbName() + " removed!!!");
                                try {//remove from file
                                    File file = new File("UniFootball.text");
                                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                                    objectOutputStream.writeObject(unilist);
                                } catch (Exception e) {
                                    System.out.println(e);
                                }
                            uniclubFound = true;
                            break;
                        }
                }
                if(!uniclubFound) {
                    System.out.println("No such club in league");
                }
                break;

                    case 4:
                        toexit();
                        break;
                    default:
                        System.out.println("Invalid input");
                        break;
                }
                System.out.println("want to process more for delete football club? y/n");
                String x = scn.next();
                char ch = x.charAt(0);
                if (ch == 'n')
                    y = false;

            } while (y != false);



        }
        public static void statisticsOfClub () {//statistics of all club
            boolean y = true;
            do {
                System.out.println();
                System.out.println("Select type of Football Club \n1. FootBall club \n2.School FootBall club \n3.University FootBall club ");
                System.out.print("\n4 to exit");
                System.out.print("Enter the Selection : ");
                int selection = scn.nextInt();
                switch (selection) {
                    case 1:
                    System.out.println("    ");
                    String srt = scn.nextLine();
                    System.out.println("Insert club name: ");
                    String line = scn.nextLine();
                    boolean foundClub = false;
                    for (FootballClub Ft : list) {
                        if (Ft.getFtballclbName().equals(line)) {
                            System.out.println("Club " + Ft.getFtballclbName() + " matches won: " + Ft.getWon());
                            System.out.println("Club " + Ft.getFtballclbName() + " matches lost: " + Ft.getLost());
                            System.out.println("Club " + Ft.getFtballclbName() + " matches draw: " + Ft.getDraw());
                            System.out.println("Club " + Ft.getFtballclbName() + " matches played: " + Ft.getPlayed());
                            foundClub = true;
                            break;
                        }
                    }

                    if (!foundClub)
                        System.out.println("No such club in Premier league!!");
                    break;
                    case 2:
                        System.out.println("    ");
                        String sot = scn.nextLine();
                        System.out.println("Insert club name: ");
                        String name = scn.nextLine();
                        boolean sclfoundClub = false;
                        for (SchoolFootBallClub sclFt: scllist) {
                            if (sclFt.getSclftballclbName().equals(name)) {
                                System.out.println("Club " + sclFt.getSclftballclbName() + " matches won: " + sclFt.getWon());
                                System.out.println("Club " + sclFt.getSclftballclbName() + " matches lost: " + sclFt.getLost());
                                System.out.println("Club " + sclFt.getSclftballclbName() + " matches draw: " + sclFt.getDraw());
                                System.out.println("Club " + sclFt.getSclftballclbName() + " matches played: " + sclFt.getPlayed());
                                sclfoundClub = true;
                                break;
                            }
                        }

                        if (!sclfoundClub)
                            System.out.println("No such club in Premier league!!");
                        break;
                    case 3:
                        System.out.println("    ");
                        String st = scn.nextLine();
                        System.out.println("Insert club name: ");
                        String club = scn.nextLine();
                        boolean unifoundClub = false;
                        for (UniversityFootballClub uniFt: unilist) {
                            if (uniFt.getUniftballclbName().equals(club)) {
                                System.out.println("Club " + uniFt.getUniftballclbName() + " matches won: " + uniFt.getWon());
                                System.out.println("Club " + uniFt.getUniftballclbName() + " matches lost: " + uniFt.getLost());
                                System.out.println("Club " + uniFt.getUniftballclbName() + " matches draw: " + uniFt.getDraw());
                                System.out.println("Club " + uniFt.getUniftballclbName() + " matches played: " + uniFt.getPlayed());
                                unifoundClub = true;
                                break;
                            }
                        }

                        if (!unifoundClub)
                            System.out.println("No such club in Premier league!!");
                        break;
                    case 4:
                        toexit();
                        break;
                    default:
                        System.out.println("Invalid input");
                        break;
                }
                System.out.println("want to process more for delete football club? y/n");
                String x = scn.next();
                char ch = x.charAt(0);
                if (ch == 'n')
                    y = false;

            } while (y != false);



        }


        public static void readData (String filename, int type) {
            try{//read the data in file
                File file = new File(filename);
                FileInputStream fileInputStream = new FileInputStream(file);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                Object obj = objectInputStream.readObject();
                switch (type) {
                    case 1:
                        list = (List<FootballClub>) obj;
                        break;
                    case 2:
                        scllist = (List<SchoolFootBallClub>) obj;
                    case 3:
                        unilist = (List<UniversityFootballClub>) obj;
                }
                objectInputStream.close();
                fileInputStream.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }


        public static void premierLeagueTable () { //premier eague Table
            boolean y = true;
            do {
                System.out.println();
                System.out.println("Select type of Football Club Table\n1. FootBall club Table \n2.School FootBall club Table \n3.University FootBall club Table");
                System.out.print("\n4 to exit");
                System.out.print("Enter the Selection : ");
                int selection = scn.nextInt();
                switch (selection) {
                    case 1:
                        Collections.sort(list, new CustomComparator<>());
                        for (FootballClub Ft : list) {
                            System.out.println("Club Name: " + Ft.getFtballclbName() + "Club Colour: " + Ft.getFtballclbColour() + "Couch Name:" + Ft.getFtballclbCouach() + "Club ID :" + Ft.getFtballclbId() +
                                    " Played matches: " + Ft.getPlayed() + " Won matches: " + Ft.getWon() + " Defect matches: " + Ft.getLost() + " Draw matches: " + Ft.getDraw());
                        }
                        break;
                    case 2:
                        Collections.sort(scllist,new CustomComparator<>());
                        for(SchoolFootBallClub sclFt : scllist){
                            System.out.println("School Name :" + sclFt.getSclName()+"Club Name: " + sclFt.getSclftballclbName() + " Club Colour:" + sclFt.getSclftballclbColour()+ "Couch Name: " + sclFt.getSclftballclbCouach()+" Club ID :" + sclFt.getSclftballclbId() +
                                    " Played matches: " + sclFt.getPlayed() + " Won matches: " + sclFt.getWon() + " Defect matches: " + sclFt.getLost() + " Draw matches: " + sclFt.getDraw());
                        }
                        break;
                    case 3:
                        Collections.sort(unilist, new CustomComparator<>());
                        for(UniversityFootballClub uniFt : unilist){
                            System.out.println("University Name :" + uniFt.getUniName()+"Club Name: " + uniFt.getUniftballclbName()  + " Club Colour:" + uniFt.getUniftballclbColour() + "Couch Name:" + uniFt.getUniftballclbCouach() + "Club ID" + uniFt.getUniftballclbId() +
                                    " Played matches: " + uniFt.getPlayed() + " Won matches: " + uniFt.getWon() + " Defect matches: " + uniFt.getLost() + " Draw matches: " + uniFt.getDraw());
                        }
                        break;

                    case 4:
                        toexit();
                        break;
                    default:
                        System.out.println("Invalid input");
                        break;
                }
                System.out.println("want to process more for add football club? y/n");
                String x = scn.next();
                char ch = x.charAt(0);
                if (ch == 'n')
                    y = false;

            } while (y != false);



        }



        public static void toexit () {

            System.exit(0);
        }
    }

