
import java.util.Random;
import java.util.Scanner;

public class project2 {

    interface Payment {
        void pay(String upi, double amount);

    }

    public static class UPIPayment implements Payment {

        @Override
        public void pay(String upi, double amount) {
            if (amount > 0) {
                System.out.println();
                System.out.println("PAYMENT OF RS. " + amount + " HAS BEEN MADE SUCCESSFULLY USING UPI ID: " + upi + "     ");
                System.out.println();
            } else {
                System.out.println("Invalid payment amount. Please enter a valid amount.");
            }
        }
    }

    public static class details {
        String name;
        int age;
        String gender;
        String coach;

        details(String name, int age, String gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }
    }

    public static class train extends details {
        String from;
        String to;
        String date;
        char coach;
        int tire;

        train(String name, int age, String gender, String from, String to, String date, char coach, int tire) {
            super(name, age, gender);
            this.name = name;
            this.age = age;
            this.gender = gender;
            this.from = from;
            this.to = to;
            this.date = date;
            this.coach = coach;
            this.tire = tire;
        }
    }

    public static void showdetails(String name, int age, String gender, String from, String to, String date, char coach, int tire) {
        Random random = new Random();
        int r1 = random.nextInt(100000000, 999999999);
        int r2 = random.nextInt(100);
        System.out.println("________________________________________________________________________________________________");
        System.out.println("                                PERSONAL DETAILS                                                ");
        System.out.println("PASSANGER NAME     : " + name + "         Age     : " + age + "      GENDER     : " + gender+"  ");
        System.out.println("                                                                                                ");
        System.out.println("________________________________________________________________________________________________");
        System.out.println("                                 TRAIN DETAILS                                                  ");
        System.out.println("FROM               : " + from + "             TO     : " + to + "          DATE     : " +date+" ");
        System.out.println("                                                                                                ");
        System.out.println("COACH              : " + coach + "        SEAT.NO     : " + r2 + "          TIER     : " +tire+"");
        System.out.println("                                                                                                ");
        System.out.println("PNR NUMBER         : " +r1+"                                                                    ");
        System.out.println("________________________________________________________________________________________________");

    }


    // FOR USER PERSONAL DETAILS
    public static void getdetails() {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter your name");
        String name = s.nextLine();
        System.out.println("Enter your Gender (M for MALE) (F for FEMALE)");
        String gender = s.nextLine();
        System.out.println("Enter your Age");
        int age = s.nextInt();

        details pass1 = new details(name, age, gender);
        gettraininfo(name, gender, age);
    }

    public static void gettraininfo(String name, String gender, int age) {
        Scanner s = new Scanner(System.in);
        System.out.println("From where do you need the train?");
        String from = s.nextLine();
        System.out.println("Until where do you need the train?");
        String to = s.nextLine();
        System.out.println("For which date do you need the train? IN FORMAT DD-MM-YYYY");
        String date = s.nextLine();
        System.out.println("In which coach do you need the seat?");
        System.out.println("(A FOR AC) (S FOR SLEEPER) (G FOR GENERAL)");
        char coach = s.next().charAt(0);

        Payment payment = new UPIPayment();
        Random random = new Random();

        if (coach == 'A') {
            System.out.println("Which tier is needed in AC?");
            System.out.println("(1 FOR FIRST A.C) (2 FOR SECOND A.C) (3 FOR THIRD A.C)");
            int tire = s.nextInt();
            if (tire == 1) {
                int r4 = random.nextInt(4000, 5000);
                System.out.println("ENTER AMOUNT " + r4 + " TO BOOK YOUR SEAT");
                int amount = s.nextInt();
                System.out.println("ENTER UPI ID TO PAY");
                s.nextLine();
                String upi = s.nextLine();
                payment.pay(upi, amount);
                showdetails(name, age, gender, from, to, date, coach, tire);

            } else if (tire == 2) {
                int r4 = random.nextInt(2000, 3000);
                System.out.println("ENTER AMOUNT " + r4 + " TO BOOK YOUR SEAT");
                int amount = s.nextInt();
                System.out.println("ENTER UPI ID TO PAY");
                s.nextLine();
                String upi = s.nextLine();
                payment.pay(upi, amount);
                showdetails(name, age, gender, from, to, date, coach, tire);
            } else {
                int r4 = random.nextInt(1000, 2100);
                System.out.println("ENTER AMOUNT " + r4 + " TO BOOK YOUR SEAT");
                int amount = s.nextInt();
                System.out.println("ENTER UPI ID TO PAY");
                s.nextLine();
                String upi = s.nextLine();
                payment.pay(upi, amount);
                showdetails(name, age, gender, from, to, date, coach, tire);
            }

        } else if (coach == 'S') {
            int r4 = random.nextInt(400, 1000);
            System.out.println("ENTER UPI ID TO PAY");
            s.nextLine();
            String upi = s.nextLine();
            System.out.println("ENTER AMOUNT " + r4 + " TO BOOK YOUR SEAT");
            int amount = s.nextInt();
            payment.pay(upi, amount);
            int tire = 0;
            showdetails(name, age, gender, from, to, date, coach, tire);
        } else {
            int r4 = random.nextInt(100, 400);
            System.out.println("ENTER UPI ID TO PAY");
            String upi = s.nextLine();
            s.nextLine();
            System.out.println("ENTER AMOUNT " + r4 + " TO BOOK YOUR SEAT");
            int amount = s.nextInt();
            payment.pay(upi, amount);
            int tire = 0;
            showdetails(name, age, gender, from, to, date, coach, tire);
        }


    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String username = "Anurag@123";
        int pin = 12345;
        System.out.println("WELOCOME TO IRCTC TRAIN BOOKING");
        System.out.println("ENTER USER NAME");
        String youruser = s.nextLine();
        System.out.println("ENTER PIN TO LOGIN");
        int yourpin = s.nextInt();
        if (username.equals(youruser) && pin == yourpin) {
            System.out.println("YOU LOGIN SUCCESSFULLY");
            getdetails();
        } else {
            System.out.println("YOU ENTER WRONG USERENAME AND PIN");
        }
    }
}