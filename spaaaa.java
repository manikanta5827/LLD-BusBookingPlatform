import java.util.*;

class intro {

  static Scanner sc = new Scanner(System.in);
  static int count = 0, c = 0, d = 0;
  static long number;

  // --------------------------------INTRO-------------------------------------
  static {
    System.out.println(
        "                                        	* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * ");
    System.out.println();
    System.out.println(
        "                                                         	      TRIE BUS BOOKING ");
    System.out.println();
    System.out.println(
        "                                        	* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * ");
  }

  // ---------------------------------USER LOGIN------------------------------
  static void start() {
    System.out.println();
    System.out.println();
    System.out.print(
        "                                          	1.Login                 2.Chatbot     	    3.Exit");
    System.out.println();
    System.out.println();
    System.out.print(
        "                                          	Choose your choice				: ");
    int login = sc.nextInt();
    System.out.println();
    switch (login) {
      case 1:
        Login();
        break;
      case 2:
        chat_bot.chatbot();
        start();
      case 3:
        System.out.println("                             			Exit.....");
        return;
      default:
        System.out.print(
            "                                          	Please enter valid option.....");
        start();
    }
  }

  // ------------------------------- USER MOBILE NUMBER VALIDATING
  // -------------------------------
  static void Login() {
    System.out.print(
        "                                          	Enter mobile number				: ");
    number = sc.nextLong();
    System.out.println();
    // ----------------------------- MOBILE NUMBER VALID OR NOT
    // -------------------------
    while (number > 9999999999l || number < 5999999999l) {
      System.out.println(
          "                                          	Please enter valid mobile number....");
      count++;
      if (count <= 5) {
        if (count > 3) {
          System.out.println();
          System.out.printf(
              "                                         	You have %d chances more...",
              5 - count + 1);
          System.out.println();
        }
        System.out.println();
        System.out.print(
            "                                          	Enter mobile number				: ");
        number = sc.nextLong();
      } else {
        System.out.println();
        System.out.println(
            "                                         	Minimum Attempts reached Try again after some time......");
        return;
      }
    }
    // --------------------------------------------------------------------------------
    // Valid MOBILE NUMBER success
    // ----------------------------------------------------------------------------
    System.out.println(
        "                                        	OTP sent to your registered mobile number");
    System.out.println();
    otp();
    Bus();
  }

  // -------------------------- OTP GENERATION --------------------------------
  static void otp() {
    int Generated_otp = (int) (Math.random() * 10000);
    while (Generated_otp < 1111) {
      Generated_otp = (int) (Math.random() * 10000);
    }
    System.out.println("						OTP						: " + Generated_otp);
    System.out.println();
    System.out.print("						Enter your OTP   				: ");
    int user_otp = sc.nextInt();
    // ----------------------- OTP WRONG RESUBMIT THE OTP --------------------------
    while (user_otp != Generated_otp) {
      System.out.println();
      System.out.println("						OTP is wrong..please re enter");
      System.out.println();
      Generated_otp = (int) (Math.random() * 10000);
      while (Generated_otp < 1111) {
        Generated_otp = (int) (Math.random() * 10000);
      }
      System.out.println("						OTP						: " + Generated_otp);
      System.out.println();
      System.out.print("						Enter your OTP   				: ");
      user_otp = sc.nextInt();
    }
    System.out.println();
  }

  static void Bus() {
    System.out.println("						1.Bus Booking    				2.Exit");
    System.out.println();
    System.out.print("                                                ");
    int choose = sc.nextInt();
    switch (choose) {
      case 1:
        chat_bot.location_input();
        break;
      case 2:
        System.out.println("						Exit");
        return;
      default:
        System.out.println();
        System.out.println("						Please enter valid platform number");
        c++;
        if (c < 4) {
          if (c == 2) {
            System.out.println();
            System.out.println(
                "						Minimum attempts are reached Try again after some time....");
          } else {
            System.out.println();
            System.out.println("						You have only 1 attempts left");
            System.out.println();
            Bus();
            return;
          }
        }
    }
  }
}

// ----------------------------chat bot-----------------------------
class chat_bot {

  static Scanner sc = new Scanner(System.in);
  static List<String> locations_chat = new ArrayList<>(
      Arrays.asList(
          "HYDERABAD",
          "VIJAYAWADA",
          "BANGLORE",
          "MADRAS",
          "BOMBAY",
          "KOLKATA",
          "JAIPUR",
          "PUNE"));
  static List<String> locations = new ArrayList<>(
      Arrays.asList(
          "HYDERABAD ",
          "VIJAYAWADA",
          "BANGLORE  ",
          "MADRAS    ",
          "BOMBAY    ",
          "KOLKATA   ",
          "JAIPUR    ",
          "PUNE      "));

  static void chatbot() {
    Hashtable<String, String> set = new Hashtable<>();
    set.put(
        "hii",
        "                                         \t Hello I am siri how can i help you");
    set.put(
        "what'syourname",
        "                                               \t    my name is siri how can i help you");
    set.put(
        "hello",
        "                                          \tHello my name is siri how can i help you");
    intro();
    options();
    while (true) {
      String si = sc.next();
      si = si.replace(" ", "");
      si = si.toLowerCase();
      if (si.equals("1"))
        Bus_Availability();
      else if (si.equals("2"))
        Bus_Tracking();
      else if (si.equals("3"))
        customer_care();
      else if (si.equals("exit"))
        return;
      else if (set.containsKey(si)) {
        System.out.println();
        System.out.println(set.get(si));
      }
      options();
    }
  }

  static void intro() {
    System.out.println(
        "                                          \t                     Enter exit to exit ");
    System.out.println(
        "                                          \t            Welcome to Trie Bus booking services");
    System.out.println();
    System.out.println(
        "                                         \t Hello I am siri how can i help you");
  }

  static void options() {
    System.out.println();
    System.out.println(
        "                                          \t1.Bus Availability");
    System.out.println(
        "                                          \t2.Bus Tracking");
    System.out.println(
        "                                          \t3.Customer care");
    System.out.println();
    System.out.print(
        "                                          \tchoose your option:");
  }

  static void Bus_Availability() {
    System.out.println();
    System.out.print(
        "                                          \tEnter Start point:");
    String s = sc.next();
    s = s.replace(" ", "");
    s = s.toUpperCase();
    System.out.println();
    System.err.print(
        "                                          \tEnter Destination point:");
    String d = sc.next();
    d = d.replace(" ", "");
    d = d.toUpperCase();
    System.out.println();
    if (locations_chat.contains(s) && locations_chat.contains(d)) {
      System.out.println(
          "                                          \tBuses available in this route");
      System.out.println();
      inbetween_cities();
    } else {
      System.out.println(
          "                                         \t No available Buses in this route");
      System.out.println();
    }
  }

  static void inbetween_cities() {
    System.out.println(
        "                                          \t In between cities");
    System.out.println();
  }

  static void Bus_Tracking() {
    System.out.println(
        "                                         \t Bus tracking");
    System.out.println(
        "                                         \t currently unable to track bus.Please try after some time...");
    System.out.println();
  }

  static void customer_care() {
    System.out.println();
    System.out.println(
        "                                          \t         -------- CONTACT DETAILS -------");
    System.out.println();
    System.out.println(
        "                                          \t              Global: +1 040-675466");
    System.out.println(
        "                                          \t              India: +91 9826730674");
    System.out.println(
        "                                          \t              Asia : +41 8340 76344");
    System.out.println(
        "                                          \t              America : +1 9276 64537");
    System.out.println();
  }

  static String Travel[] = new String[3];
  static String Buses_list[] = new String[5];
  static String Buses_list2[] = new String[5];
  static int type;

  static void location_input() {
    int start_point = 0;
    for (int i = 0; i < 3; i++) {
      if (i == 0) {
        System.out.println();
        System.out.println("						Enter Starting point");
        for (int j = 0; j < locations.size(); j++) {
          System.out.println();
          System.out.print("                                                ");
          System.out.print((j + 1) + ":" + locations.get(j) + " ");
          System.out.println(
              "              " + (j + 1 + 1) + ":" + locations.get(j + 1) + " ");
          j++;
        }
        System.out.println();
        System.out.print("                                                ");
        start_point = sc.nextInt() - 1;
        while (start_point >= locations.size()) {
          System.out.println();
          System.out.print(
              "                                                Please enter valid Starting point :");
          start_point = sc.nextInt() - 1;
        }
        Travel[i] = locations.get(start_point);
      } else if (i == 1) {
        System.out.println();
        System.out.println("						Enter Destination Point");
        for (int j = 0; j < locations.size(); j++) {
          System.out.println();
          System.out.print("                                                ");
          System.out.print((j + 1) + ":" + locations.get(j) + " ");
          System.out.println(
              "              " + (j + 1 + 1) + ":" + locations.get(j + 1) + " ");
          j++;
        }
        System.out.println();
        System.out.print("                                                ");
        int destiny = sc.nextInt() - 1;
        while (destiny >= locations.size() || destiny == start_point) {
          System.out.println();
          System.out.print(
              "                                                Please enter valid Destination point :");
          destiny = sc.nextInt() - 1;
        }
        Travel[i] = locations.get(destiny);
      } else {
        System.out.println();
        System.out.print("						Journey Date 					: ");
        String s = sc.nextLine();
        String d = sc.nextLine();
        Travel[i] = d;
        System.out.println();
      }
    }
    ac_nonac();
  }

  static void ac_nonac() {
    System.out.println("						1.Ac Buses");
    System.out.println();
    System.out.println("						2.Non-Ac Buses");
    System.out.println();
    System.out.println("						3.Both");
    System.out.println();
    System.out.print("                                                ");
    type = sc.nextInt();
    while (type > 3) {
      System.out.println();
      System.out.print("						Please enter valid option : ");
      type = sc.nextInt();
      System.out.println();
    }
    display_buses();
  }

  static void Minimap(String[] Travel) {
    System.out.println();
    for (int i = 0; i < 3; i++) {
      if (i == 0) {
        System.out.print("						From : " + Travel[i] + " ");
      } else if (i == 1) {
        System.out.print("   To : " + Travel[i] + " ");
      } else {
        System.out.println("   Journey Date : " + Travel[i] + " ");
        System.out.println();
      }
    }
  }

  static void ac(int start) {
    for (int i = 0; i < Buses_list.length; i++) {
      System.out.print("       						");
      System.out.println((start++) + "." + Buses_list[i]);
    }
  }

  static void NON_ac(int start) {
    for (int i = 0; i < Buses_list2.length; i++) {
      System.out.print("						");
      System.out.println((start++) + "." + Buses_list2[i]);
    }
  }

  static void display_buses() {
    switch (type) {
      case 1:
        Minimap(Travel);
        ac(1);
        System.out.println();
        System.out.print("						Enter Bus Number				: ");
        BUS_Pattern.pattern();
        break;
      case 2:
        Minimap(Travel);
        NON_ac(1);
        System.out.println();
        System.out.print("						Enter Bus Number				: ");
        BUS_Pattern.pattern();
        break;
      case 3:
        Minimap(Travel);
        ac(1);
        NON_ac(6);
        System.out.println();
        System.out.println();
        System.out.print("						Enter Bus Number				: ");
        BUS_Pattern.pattern();
        break;
    }
  }
}

// ------------------------------ BUS PATTERN --------------------------
class BUS_Pattern extends chat_bot {

  static String[][] seats = new String[6][11];
  static int bus_number;
  static String bus_name;

  static void pattern() {
    int la = Buses_list.length;
    bus_number = sc.nextInt();
    if (type == 3) {
      la = Buses_list.length + Buses_list2.length;
    }
    while (bus_number > la) {
      System.out.println();
      System.out.print("						Please enter valid Travels number :       ");
      bus_number = sc.nextInt();
    }

    int row = 1, col = 1;
    for (int i = 0; i < 6; i++) {
      for (int j = 0; j < 11; j++) {
        if (i == 0 && j == 0)
          seats[i][j] = "   ";
        else if (i == 0 && j > 0)
          seats[i][j] = (row++) + "  ";
        else if (j == 0 && i > 0)
          seats[i][j] = (col++) + "  ";
        else if (i == 1 &&
            j == 3 ||
            i == 1 &&
                j == 5
            ||
            i == 2 &&
                j == 4
            ||
            i == 2 &&
                j == 7
            ||
            i == 4 &&
                j == 7
            ||
            i == 5 &&
                j == 10
            ||
            i == 5 &&
                j == 2)
          seats[i][j] = "@  ";
        else if (i == 3 && j < 10)
          seats[i][j] = "   ";
        else
          seats[i][j] = "*  ";
      }
    }
    // --------------------------------------------------------------------------
    // PRINTING SEAT SELECTION FOR USER
    // -----------------------------------------------------------------------------
    System.out.println();
    for (int i = 0; i < 6; i++) {
      for (int j = 0; j < 11; j++) {
        if (j == 0)
          System.out.print(
              "                                                              ");
        System.out.print(seats[i][j]);
      }
      System.out.println();
      System.out.println();
    }
    System.out.println(
        "                                                * --> occupied");
    System.out.println(
        "                                                @ --> not occupied");
    System.out.println();
    validating_seat();
    // ------------------------------USER INPUT FOR SEAT SELECTION
    // --------------------------------
  }

  static void validating_seat() {
    System.out.print("						Enter valid seat number 			: ");
    int a = sc.nextInt();
    System.out.println();
    int column = a % 10;
    int roww = a /= 10;
    while (seats[roww][column].equals("*  ")) {
      System.out.println("						Seat is Occupied ");
      System.out.println();
      System.out.print("						Enter valid seat number 			: ");
      a = sc.nextInt();
      column = a % 10;
      roww = a /= 10;
    }
    System.out.println(
        "                                               -------------------- Traveller Details -------------------------");
    System.out.println();
    new userDetails().user();
  }
}

// ----------------------------- USER DETAILS ------------------------------
class userDetails {

  static userDetails obj = new userDetails();
  static Scanner sc = new Scanner(System.in);
  private static String name;
  private static int age;
  private static String gender;
  private static String mail;

  static String m1() {
    return name;
  }

  static int m2() {
    return age;
  }

  static String m3() {
    return gender;
  }

  static String m4() {
    return mail;
  }

  void user() {
    System.out.print("						Enter User Name					: ");
    this.name = sc.next();
    System.out.println();
    // age method calling
    System.out.print("						Enter Age					: ");
    obj.Age(sc.nextInt());
    // gender method calling
    System.out.println();
    System.out.println("						1.Male    2.Female     ");
    System.out.println();
    System.out.print("						Choose Gender\t\t\t\t\t: ");
    obj.gender(sc.nextInt());
    // mail id method calling
    System.out.print("						Enter Mail ID					: ");
    obj.mail_verification(sc.next());
    System.out.println();
    System.out.println(
        "                                              ------------------------------- PAYMENY GATEWAY ----------------------------------");
    System.out.println();
    paymentt.paymentPlatform();
  }

  void Age(int age) {
    System.out.println();
    if (age < 18 || age > 100) {
      System.out.println("					 	Age is not valid");
      System.out.print("						Enter Age					: ");
      Age(sc.nextInt());
    } else {
      this.age = age;
    }
  }

  void gender(int gen) {
    System.out.println();

    switch (gen) {
      case 1:
        this.gender = "Male";
        break;
      case 2:
        this.gender = "Female";
        break;
      default:
        System.out.println();
        System.out.println("						Enter valid option");
        System.out.println();
        System.out.println("						1.Male    2.Female     ");
        System.out.println();
        System.out.print("						Choose Gender\t\t\t\t\t: ");
        gender(sc.nextInt());
    }
  }

  void mail_verification(String mail) {
    int k = mail.indexOf('@');
    String m = mail.substring(k, mail.length());
    if (!m.equals("@gmail.com")) {
      System.out.println();
      System.out.println("						Mai id is not valid");
      System.out.println();
      System.out.print("						Enter Mail ID					: ");
      mail_verification(sc.next());
    } else {
      this.mail = mail;
    }
  }
}

// --------------------------------- PAYMENT ---------------------------------
interface i1 {
  abstract void payment(int platform);
}

interface i2 {
  abstract void debit(int platform);
}

abstract class ab_payment implements i1, i2 {

  static Scanner sc = new Scanner(System.in);
  static int cvv;
  static long number;

  ab_payment(int cvv) {
    this.cvv = cvv;
  }

  public void payment(int platform) {
    System.out.print("						Enter your payment mobile number 		: ");
    number = sc.nextLong();
    System.out.println();
    while (number != intro.number) {
      System.out.println();
      System.out.print("						Enter your payment mobile number 		: ");
      number = sc.nextLong();
    }
    // ----------------------------- OTP generation
    // -----------------------------------------
    intro.otp();
    bank_and_balance(platform);
    int processing = sc.nextInt();
    while ((processing > 3)) {
      System.out.println();
      System.out.print("						Enter valid option : ");
      processing = sc.nextInt();
    }
    switch (processing) {
      case 1:
        RECEipt.BillReceipt();
        break;
      case 2:
        paymentt.paymentPlatform();
        break;
      case 3:
        System.out.println("						payment cancelled");
        System.out.println();
        break;
    }
  }

  public void debit(int platform) {
    System.out.print("						Enter your 12 Digit Debit card number 		: ");
    long debit_card_number = sc.nextLong();
    String spam_number = "" + debit_card_number;
    while (spam_number.length() != 12) {
      System.out.println();
      System.out.print("						Enter valid Debit card number 		: ");
      debit_card_number = sc.nextLong();
      spam_number = "" + debit_card_number;
    }
    System.out.println();
    System.out.print("						Enter cvv number 		: ");
    this.cvv = sc.nextInt();
    String spam_cvv = "" + cvv;
    while (spam_cvv.length() != 3) {
      System.out.println();
      System.out.print("						Enter valid cvv number 		: ");
      this.cvv = sc.nextInt();
      spam_cvv = "" + cvv;
      System.out.println();
    }
    intro.otp();
    bank_and_balance(platform);
    int processing = sc.nextInt();

    while ((processing > 3)) {
      System.out.println();
      System.out.print("						Enter valid option : ");
      processing = sc.nextInt();
    }

    switch (processing) {
      case 1:
        RECEipt.BillReceipt();
        break;
      case 2:
        paymentt.paymentPlatform();
        break;
      case 3:
        System.out.println("						payment cancelled");
        System.out.println();
        break;
    }
  }

  static void bank_and_balance(int platform) {
    System.out.println();
    System.out.println("					        Bank Name 				        : SBI Bank ");
    System.out.println();
    if (platform == 1)
      System.out.println(
          "					        Balance Amount 					: " + paymentt.paytm_balance);
    else if (platform == 2)
      System.out.println(
          "					        Balance Amount 					: " + paymentt.phonepe_balance);
    else if (platform == 3)
      System.out.println(
          "					        Balance Amount 					: " + paymentt.gpay_balance);
    else
      System.out.println(
          "					        Balance Amount 					: " + paymentt.debit_balance);
    System.out.println();
    System.out.println("						Enter 1 To proceed  ");
    System.out.println();
    System.out.println("						Enter 2 To choose another platform  ");
    System.out.println();
    System.out.println("						Enter 3 To exit  ");
    System.out.println();
    System.out.print("                                                ");
  }
}

// ----------------------------------------------------------------------------------
// CHOOSE YOUR PAYMENT PLATFORM
// --------------------------------------------------------------------------
class paymentt extends ab_payment {

  static Scanner sc = new Scanner(System.in);
  static int d = 0;
  static int paytm_balance = 4000;
  static int phonepe_balance = 29000;
  static int gpay_balance = 11000;
  static int debit_balance = 1023000;
  static int credit_balance = 320000;

  // SUPER
  paymentt() {
    super(123);
  }

  static ab_payment obj = new paymentt();

  static void paymentPlatform() {
    System.out.print("                                    		");
    System.out.println("1.Paytm");
    System.out.print("                                    		");
    System.out.println("2.PhonePe");
    System.out.print("                                    		");
    System.out.println("3.GPay");
    System.out.print("                                    		");
    System.out.println("4.Debit Card");
    System.out.print("                                    		");
    System.out.println("5.Credit Card");
    System.out.println();
    System.out.print("     						Choose your payment method			: ");
    int select = sc.nextInt();
    System.out.println();
    switch (select) {
      case 1:
        System.out.println(
            "------------------------------------------------------------PAYTM PLATFORM -----------------------------------------------------");
        System.out.println();
        obj.payment(select);
        break;
      case 2:
        System.out.println(
            "\"------------------------------------------------------------PHONEPE PLATFORM -----------------------------------------------------");
        System.out.println();
        obj.payment(select);
        break;
      case 3:
        System.out.println(
            "\"------------------------------------------------------------GPAY PLATFORM -----------------------------------------------------");
        System.out.println();
        obj.payment(select);
        break;
      case 4:
        System.out.println(
            "\"------------------------------------------------------------DEBIT CARD -----------------------------------------------------");
        System.out.println();
        obj.debit(select);
        break;
      case 5:
        System.out.println(
            "\"------------------------------------------------------------CREDIT CARD -----------------------------------------------------");
        System.out.println();
        obj.debit(select);
        break;
      default:
        System.out.println("     						Please Choose valid Payment method");
        d++;
        if (d <= 2) {
          if (d == 2) {
            System.out.println("You have only 1 attempts left");
          }
          paymentPlatform();
        } else {
          System.out.println(
              "Minimum attempts are reached Try again after some time....");
          System.out.println("* Exit *");
          return;
        }
    }
  }
}

class RECEipt extends BUS_Pattern {

  // --------------------------------------------------------------------------------------BILL
  // RECEPIT
  // ---------------------------------------------------------------------------------------
  static void BillReceipt() {
    System.out.print(
        "                                         ---------------------------------RECEIPT ----------------------------------");
    System.out.println();
    System.out.println();
    System.out.println();
    System.out.print("\t\t\t\t\t\tBus Journey Completed...");
    System.out.println("           Booking ID GOBUSIOS7BE90B84CB  \n");
    System.out.println("\t\t\t\t\t\tBooked on 20 Dec 2023\n");
    System.out.println();
    System.out.println("\t\t\t\t\t\t" + Travel[0] + "-->" + Travel[1]);
    System.out.println();
    System.out.printf("\t\t\t\t\t\t%s\n\n", Travel[2]);
    if (type == 1) {
      System.out.println(
          "                                                Travels Name : " +
              Buses_list[bus_number - 1]);
      System.out.println();
    } else if (type == 2) {
      System.out.println(
          "                                                Travels Name : " +
              Buses_list2[bus_number - 1]);
      System.out.println();
    } else {
      if (bus_number >= 1 && bus_number <= 5) {
        System.out.println(
            "                                                Travels Name : " +
                Buses_list[bus_number - 1]);
        System.out.println();
      } else if (bus_number >= 6 && bus_number <= 10) {
        System.out.println(
            "                                                Travels Name : " +
                Buses_list2[bus_number - 6]);
        System.out.println();
      }
    }
    System.out.println();
    System.out.println("						Name 						: " + "Sri " + userDetails.m1());
    System.out.println();
    System.out.println("						Age 						: " + userDetails.m2());
    System.out.println();
    System.out.println("						Gender 						: " + userDetails.m3());
    System.out.println();
    System.out.println("\t\t\t\t\t\tMail-Id \t\t\t\t	: " + userDetails.m4());
    System.out.println();
    System.out.println("\t\t\t\t\t\tContact number \t\t\t\t	: " + intro.number);
    System.out.println();
    System.out.println("						Charges includes GST \t\t\t	: 1200.00 ");
    System.out.println();
    System.out.println("\t\t\t\t\t\tTransaction status \t\t\t	: SUCCESS");
    return;
  }
}

class Teslking extends chat_bot {

  public static void main(String[] args) {
    Buses_list[0] = "A1tours and Travels     - 10:00AM-14:00PM  310.00 ";
    Buses_list[1] = "Abtravels               - 11:30AM-15:30PM  350.00 ";
    Buses_list[2] = "Classic Travels         - 11:40AM-16:40PM  400.00 ";
    Buses_list[3] = "Orange Travels          - 12:00AM-17:00PM  450.00 ";
    Buses_list[4] = "Aditya Travels          - 12:30AM-17:30PM  500.00 ";

    Buses_list2[0] = "VRL Travels            - 04:00AM-06:00AM  300.00 ";
    Buses_list2[1] = "Shrinath Travels       - 05:00AM-07:00AM  370.00 ";
    Buses_list2[2] = "NEETA Travels          - 06:00AM-08:00AM  460.00 ";
    Buses_list2[3] = "SRS Travels 		   - 08:00AM-10:00AM  550.00 ";
    Buses_list2[4] = "HANS Travels 	       - 09:00AM-11:00AM  600.00 ";
    intro.start();
  }
}
