import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        String[] lines = getFileText();
        for (String line : lines) {
            String[] values = line.split(",");
            switch (values[0]) {
                case "u":
                    System.out.println(Integer.parseInt(values[1]));
                    break;
                case "q":
                    System.out.println("q");
                    break;
                case "o":
                    System.out.println("o");
                    break;
            
                default:
                    break;
            }
        }
    }
    
    public static String[] getFileText() {
        int numberOfLines = 0;
        File input = new File("C:/Users/fckptn/Desktop/js/jsNode/testTaskProj/javaBidTestTask/src/input.txt");
        try {
            Scanner fileReader = new Scanner(input);
            while(fileReader.hasNextLine()) {
                numberOfLines++;
                fileReader.nextLine();
            }            
            fileReader.close();
        }
        catch (Exception e) {
            System.out.println("An error occured while reading file");
            System.out.println(e.getMessage());
        }

        String[] lines = new String[numberOfLines];
        try {
            Scanner fileReader = new Scanner(input);
            int iterator = 0;
            while(fileReader.hasNextLine()) {
                lines[iterator] = fileReader.nextLine();
                iterator++;
            }
            fileReader.close();
        }
        catch(Exception e) {
            System.out.println("An error occured while reading file");
        }
        return lines; 
    }
}

class BidBoard {
    List<Bid> bidsList;
    public BidBoard () {
        bidsList = new ArrayList<Bid>();
    }
    public void update (char type, int price, int size) {
        bidsList.add(new Bid(type, price, size));
    }

    public String query (String queryType) {
        if (queryType == "best_bid") return " ";//getBid(Collections.max(bidsList));
        if (queryType == "best_ask") return " ";
        return " ";
    }
    public String query (String queryType, int querySize) {
        return " ";
    }

    public void order (String orderType, int orderSize) {

    }
}

class Bid {
    char _type;
    int _price;
    int _size;
    
    public Bid (char type, int price, int size) {
        _type = type;
        _price = price;
        _size = size;
    }

    public int getPrice() {
        return _price;
    }

    public String getBid() {
        return String.format("%d, %d", _price, _size);
    }
}