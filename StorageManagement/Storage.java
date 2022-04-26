package projects.P11_depoYonetimi;

import java.util.*;

public class Storage implements stockEntry {

    public static final String W = "\u001B[37m";
    public static final String R = "\u001B[31m";
    public static final String G = "\u001B[32m";
    public static final String Y = "\u001B[33m";
    public static final String B = "\u001B[34m";

    static Scanner scanner = new Scanner(System.in);
    static Map<Integer, Items> itemMap = new HashMap<>();
    static List<String> occupiedShelves = new ArrayList<>();




    public static void defaultItems() {
        Items mlz1 = new Items("Aluminum","Zahit A.Ş",50,"Linear Meter");
        Items mlz2 = new Items("MDF","Orma A.Ş.",5,"Panel");
        Items mlz3 = new Items("Isıcam","Trakya Cam",9,"Square Meter");
        Items mlz4 = new Items("Çelik","Tosya",6,"Ton");

        itemMap.put(mlz1.getId(),mlz1);
        itemMap.put(mlz2.getId(),mlz2);
        itemMap.put(mlz3.getId(),mlz3);
        itemMap.put(mlz4.getId(),mlz4);
    }


//----------------------------------------------------ANAMENU METHODU --------------------------------------------------

    public   void mainMenu()  {

         System.out.println(R + "========================== İŞLEMLER =======================\r\n"
                + "   ____________________             ____________________    \n"
                + "   | 1- DEFINE ITEM    |            | 2- LIST ALL ITEMS |   \n"
                + "   ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯             ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯    \n"
                + "   ______________________           ____________________    \n"
                + "   | 3- STOCK ENTRY     |           | 4- SHELF UPDATE   |   \n"
                + "   ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯           ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯    \n"
                + "   ____________________             ____________________    \n"
                + "   | 5- STOCK OUT      |             | 6- PROGRAM EXIT  |   \n"
                + "   ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯             ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯       " + B);

            System.out.print("Please make your main menu selection: ");

            int choice = TryCatches.intInput();


            switch (choice) {

                case 0:
                    System.out.println("Terminating program...");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();  }
                    break;
                case 1:
                    defineItem();
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();  }
                    mainMenu();
                    break;
                case 2:
                    listAllItems();
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();  }
                    criticalAmountWarning();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();  }
                    mainMenu();
                    break;
                case 3:
                    itemEntry();
                    mainMenu();
                    break;
                case 4:
                    updateShelf();
                    mainMenu();
                    break;
                case 5:
                    itemExit();
                    criticalAmountWarning();
                    mainMenu();
                    break;
                default:
                    System.out.println("Lütfen menüde bulunan işlemlerden birini seçiniz. Seçim ekranına tekrar yönlendiriyorum ");
                    mainMenu();
                    break;

            }


    }//anaMenu()

//----------------------------------------------------URUN TANIMLAMA METHODU --------------------------------------------------

    public   void defineItem() {
        System.out.print("Product name: ");
        String name= scanner.nextLine();
        System.out.print("Product producer: ");
        String producer = scanner.nextLine();
        System.out.print("Product unit: ");
        String unit =scanner.nextLine();
        System.out.println("Product Shelf: ");
        String shelf= scanner.nextLine();

        Items mlz1 = new Items(name,producer,unit,shelf);

        itemMap.put(mlz1.getId(),mlz1);
        occupiedShelves.add(mlz1.getShelf());


        System.out.println(mlz1.getName().toUpperCase()+" item has been added to the list.");
        System.out.println(mlz1.getId()+" : "+ mlz1);
    }

//----------------------------------------------------URUN LİSTELE METHODU --------------------------------------------------

    public  void listAllItems() {
        System.out.println("                        STORAGE CURRENT YIELDS                   ");

        System.out.println("Item ID   Item Name   Producer   Quantity      Unit       Shelf      ");
        System.out.println("==================================================================");
        for (Integer w : itemMap.keySet()) {
            Items mlz = itemMap.get(w);

            System.out.printf("%-6d    %-10S    %-10S     %-4s     %-7S      %-8s\n",
                    w,  mlz.getName(), mlz.getProducer(),  mlz.getAmount(), mlz.getUnit(),  mlz.getShelf());
        }       // id       un             hekimoglu           0                 kg            raf
        System.out.println("==================================================================");
    }

//----------------------------------------------------URUN GİRİSİ METHODU --------------------------------------------------

    public  void itemEntry()   {
        System.out.println("Please specify the item ID: ");
        int urunId= TryCatches.intInput();
        if(!itemMap.containsKey(urunId)){
            System.out.println("There is no such an item with the ID you provided. Press 1 to define new item" +
                    "press 0 for main menu: ");
            if(scanner.nextInt()==1){
                defineItem();
            } else mainMenu();
        } else {
            System.out.println("Please enter an amount: ");
            int quantity = TryCatches.intInput();

            if(quantity>0){
                itemMap.get(urunId).setAmount(quantity+
                        itemMap.get(urunId).getAmount());

                System.out.println("Item "+itemMap.get(urunId).getName().toUpperCase()+" has been added "+ quantity+" "+ itemMap.get(urunId).getUnit());

            } else {
                itemMap.get(urunId).setAmount(quantity);
            }


        }
    }
//----------------------------------------------------URUN RAFA KOY METHODU --------------------------------------------------
    public  void updateShelf()  {
        System.out.print("Please specify an ID for shleving: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if(!itemMap.containsKey(id)){
            System.out.println("There is no such an item with the ID you provided. Press 1 to define new item" +
                    "press 0 for main menu: ");
            if(scanner.nextInt()==1){
                scanner.nextLine();
                defineItem();
            } else mainMenu();
        } else {
            System.out.println("Please specify a shelf number: ");

            String shelfNo = scanner.nextLine();

            itemMap.get(id).setShelf(shelfNo);
            System.out.println(itemMap.get(id).getName()+" has been appointed a new shelf number. Current shelf: "+ itemMap.get(id).getShelf());
        }

    }


//----------------------------------------------------URUN CİKİS METHODU ---------------------------------------------------------
    public  void itemExit()  {
        System.out.println("Please specify an ID for item exit: ");
        int id = TryCatches.intInput();

        if(!itemMap.containsKey(id)){
            System.out.println("There is no such an item with the ID you provided. Press 1 to define new item" +
                    "press 0 for main menu: ");
            if(TryCatches.intInput()==1){
                defineItem();
            } else mainMenu();
        } else {

           Items urunID = itemMap.get(id);

            System.out.println(urunID.getName().toUpperCase()+" currently has amount number:  "+ urunID.getAmount()+" please specify the amount you want to eject: ");
            int amount = scanner.nextInt();

            if(amount>urunID.getAmount()){
                System.out.println("You are not allowed to eject more item than current amount. If you want to eject the whole stock, press 1, else press 2");
                int input = scanner.nextInt();
                if(input==1){

                    urunID.setAmount(0);

                    System.out.println("Item named: "+urunID.getName().toUpperCase()+" has been removed entirely from the store ( " +urunID.getAmount()+" "+urunID.getUnit() +" ) " +
                            "Remaining:  "+ urunID.getAmount());




                } else {
                    System.out.println("No item exit has been executed. You are being redirected to the main menu: ");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();  }

                }
            } else{
                int newAmount= urunID.getAmount()-amount;

                urunID.setAmount(newAmount);

                System.out.println("Item named: "+urunID.getName()+" has been removed from store amount of:  "+newAmount+" "+urunID.getUnit());
            }
        }

    }



//----------------------------------------------------KRİTİK AZALAN MİKTAR KONTROL METHODU ---------------------------------------------------------
    public static void criticalAmountWarning()  {

        System.out.println("Checking stock amounts...");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();  }
      Map<Integer, Items> itemsLowOnAmount = new HashMap<>();

        for (Items w: itemMap.values()) {
            if(w.getAmount()<10){
                itemsLowOnAmount.put(w.getId(),w);
            }
        }

        if(!itemsLowOnAmount.isEmpty()){
            System.out.println(R+"Warning ! Following items are lower than the critical amount limit: ");
            System.out.println(" ID    Item Name    Quantity   Unit");
            System.out.println("======================================");
            for (Items each :itemsLowOnAmount.values() ) {
                System.out.printf("%-5d   %-9S   %-4d  %-7S\n",each.getId(),each.getName(),each.getAmount(),each.getUnit());
            }
            System.out.println("======================================");
        }
        System.out.println("");
    }

}//class
