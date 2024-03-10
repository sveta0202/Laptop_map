
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

 public class Main {

    public static void main(String[] args) {
        // заполение экземпляров
       Laptop n1 = new Laptop("Asus", "Black", 49000,"123456q");
       n1.setRam(64);
       n1.setStorage("SDD");
       Laptop n2 = new Laptop("Samsung", "Black", 56000,"654321w"); 
       n2.setRam(16);
       n2.setStorage("HDD");
       Laptop n3 = new Laptop("Sony", "White", 64000,"098765er"); 
       n3.setRam(32);
       n3.setStorage("SDD"); 
       Laptop n4 = new Laptop("Sumsung", "White", 29000,"567890ty"); 
       n4.setRam(8);
       n4.setStorage("HDD");       
       Laptop n5 = new Laptop("Asus", "Black", 86000,"019283zx"); 
       n5.setRam(16);
       n5.setStorage("SDD");  
       Laptop n6 = new Laptop("Digma", "White", 15000,"85786783cv"); 
       n6.setRam(64);
       n6.setStorage("HDD");    
//-------------------------------------------------------------------------------------------------------------

        Set<Laptop> compSet = new HashSet<>(Arrays.asList(n1, n2, n3, n4, n5, n6));
        
        // вывод ноутбуков по желанию
        System.out.println("Выводить все возмоэные ноутбуки? 1 - yes, 2 - no");
        Scanner d = new Scanner(System.in);
        int a = d.nextInt(); 
        if(a == 1){
            System.out.println("Ноутбуки:"); 
        for (Laptop comp: compSet) {
        System.out.println(comp);
        }
    
        }
       // хранение условий фильтрации в HashMap
       HashMap<Integer,String> filterlist = new HashMap<>();

       filterlist.put(1," - Минимальная цена");
       filterlist.put(2," - Объем оперативная память в Гб");
       filterlist.put(3," - Вид накопителя HDD/SDD"); 
       filterlist.put(4," - Цвет Black/White");   
       filterlist.put(5," - Настройка фильтра");    
       filterlist.put(6," - Завершение работы");                  

       // вывод фильтров

       System.out.println("Фильтры:");       
        for (Map.Entry<Integer, String> entry : filterlist.entrySet()) {
            System.out.println(entry.getKey() + entry.getValue());
        }      
        System.out.println("Введите номер критерия фильтрации:");
        Scanner n = new Scanner(System.in);
        Scanner m = new Scanner(System.in);    
        int answer = n.nextInt(); 
        
        if (answer == 1){
            System.out.println("Введите минимальное значение цены:");
            int chvalue = n.nextInt(); 
         

            for (Laptop notebook : compSet) {
                int price = notebook.getPrice();

                if (price>chvalue) {
                    System.out.println(notebook);
                }
            }      
        }
        if (answer == 2){
            System.out.println("Введите минимальное значение оперативной памяти (кол-во Гб):");
            int chvalue = n.nextInt(); 
         
            for (Laptop notebook : compSet) {
                int ram = notebook.getRam();

                if (ram>chvalue) {
                    System.out.println(notebook);
                }
            }      
        }
        if (answer == 3){
            System.out.println("Введите вид накопителя (HDD или SDD):");
            String chvalue = m.nextLine(); 
            chvalue = chvalue.toLowerCase();

            for (Laptop notebook : compSet) {
                if (chvalue.equals(notebook.getStorage())) {
                    System.out.println(notebook);
                }
            }      
        }

        if (answer == 4){
            System.out.println("Введите значение критерия фильтрации:");
            String chvalue = m.nextLine(); 
            chvalue = chvalue.toLowerCase();

            for (Laptop notebook : compSet) {
                if (chvalue.equals(notebook.getColor())) {
                    System.out.println(notebook);
                }
            }      
        }

        if (answer == 5){
            System.out.println("Введите требуемые занчения фильтров:");

            HashMap<Integer,String> userfilter = new HashMap<>();
            for (Map.Entry<Integer, String> entry : filterlist.entrySet()) {
                Integer key =  entry.getKey();
                if (key < 5){
                System.out.println(entry.getValue());             
                String value = m.nextLine(); 
                value = value.toLowerCase();
                userfilter.put(key, value);
                }
            }     

             for (Laptop notebook : compSet) {
                boolean Fl = true;
                for (Map.Entry<Integer, String> entry : userfilter.entrySet()) 
                {
             
                int key = entry.getKey();
                int value = 0;
                String value2 = ""; 

            
                if (key == 1 || key == 2 )
                {
                    value2 = entry.getValue();
                    if (value2 != "")  value = Integer.parseInt(entry.getValue());
                }
                else {
                    value2 = entry.getValue();
                }
                // Формирование фильра
                switch (key) {
                    case 1:
                    if (value > 0)
                    {
                    int price = notebook.getPrice();
                    if (price < value) Fl = false;                  
                    }
                    break;
                    case 2:
                    if (value > 0)
                    {
                    int ram = notebook.getRam();
                    if (ram < value) Fl = false;
                    }                  
                    break;                    
                    case 3:
                    if (value2 != "")
                    {
                    
                    if (value2.equals(notebook.getStorage())) 
                    {}
                    else  {
                        Fl = false;
                        System.out.println(value2 + " " + notebook.getStorage());
                    
                    }    
                    }               
                    break;  
                    case 4:
                    if (value2 != "")
                    {
                    if (value2.equals(notebook.getColor())) {}
                    else  Fl = false;  
                    }                 
                    break;                      
                }
                }
                // Вывод результата настраиваемого фильтра
                if (Fl) {
                    System.out.println(notebook);
                }
                else {
                    System.out.println("Такого ноутбука не нашлось");
                }
            }      
        }
    }

}