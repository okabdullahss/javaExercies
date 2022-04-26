package projects.P11_depoYonetimi;

public class Items extends Storage {

    static int num =1000;

   private String name;
   private int id;
   private String producer;
   private int amount;
   private String unit ="undefined";
   private String shelf ="undefined";



    Items(){   }

    public Items(String name, String producer, String unit, String shelf) {
        this.name = name;
        this.producer = producer;
        this.unit = unit;
        this.id=num++;
        setShelf(shelf);
        this.unit = unit;
    }//p'li constructor



    public Items(String name, String producer, int amount, String unit) {
        this.name = name;
        this.id=num++;
        this.producer = producer;
        setAmount(amount);
        this.unit = unit;


    }//id'siz constructor

    public static int getNum() {
        return num;
    }

    public static void setNum(int num) {
        Items.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        if(amount <0){
            System.out.println("You cant enter an input as negative value");
        } else {
            this.amount = amount;
        }

    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getShelf() {
        return shelf;
    }

    public void setShelf(String shelf) {
     if(!occupiedShelves.contains(shelf)){
        this.shelf = shelf;}
     else {
         String item ="";
         for (Items w : itemMap.values() ) {
             if(w.getShelf().equalsIgnoreCase(shelf)){
                 item=w.getName();
             }
         }
         System.out.println("This shelf is preoccupied. The current item on this shelf is: "+ item);
     }
    }

    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                ", producer='" + producer + '\'' +
                ", amount=" + amount +
                ", unit='" + unit + '\'' +
                ", shelf='" + shelf + '\'' +"\n"
                ;
    }
}//class
