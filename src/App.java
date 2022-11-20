import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        String[] lines = getFileText();
        BidBoard board = new BidBoard();
        for (String line : lines) {
            String[] values = line.split(",");
            switch (values[0]) {
                case "u":
                    board.update(values[3], Integer.parseInt(values[1]), Integer.parseInt(values[2]));
                    break;
                case "q":
                    if(values[1].equals("size")) System.out.println(board.query(values[2]));
                    else System.out.println(board.query(values[1]));
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
    public void update (String type, int price, int size) {
        if(type.equals("bid")) {
            bidsList.add(new BidBid(type, price, size));
        }
        if(type.equals("ask")) {
            bidsList.add(new BidAsk(type, price, size));
        }

    }

    public String query (String queryType) {
        int bestBid = -1;
        if (queryType.equals("best_bid")) {
            for (int i = 0; i < bidsList.size(); i++) {
                if(bidsList.get(i).getType().equals("bid")) {
                    if(bestBid == -1) bestBid = i;
                    if(bidsList.get(i).getPrice() > bidsList.get(bestBid).getPrice()) bestBid = i;
                } else {
                    continue;
                }
            }
        }
        if (queryType.equals("best_ask")) {
            for (int i = 0; i < bidsList.size(); i++) {
                if(bidsList.get(i).getType().equals("ask")) {
                    if(bestBid == -1) bestBid = i;
                    if(bidsList.get(i).getPrice() > bidsList.get(bestBid).getPrice()) bestBid = i;
                } else {
                    continue;
                }
            }
        }
        return bidsList.get(bestBid).getBid();
    }
    public int query (int queryPrice) {
        int size = 0;
        for (int i = 0; i < bidsList.size(); i++) {
            if(bidsList.get(i).getPrice() == queryPrice) {
                size += bidsList.get(i).getSize();
            } else {
                continue;
            }
        }
        return size;
    }

    public void order (String orderType, int orderSize) {

    }
}

class Bid {
    private String _type;
    private int _price;
    private int _size;
    
    public Bid (String type, int price, int size) {
        _type = type;
        _price = price;
        _size = size;
    }

    public int getPrice() {
        return _price;
    }

    public int getSize() {
        return _size;
    }

    public String getType() {
        return _type;
    }

    public String getBid() {
        return String.format("%d, %d", _price, _size);
    }
}

class BidBid extends Bid {

    public BidBid(String type, int price, int size) {
        super(type, price, size);
    }

}

class BidAsk extends Bid {

    public BidAsk(String type, int price, int size) {
        super(type, price, size);
    }
    
}