import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class App {
    public static void main(String[] args) throws Exception {
        getFileText();
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
                System.out.println(lines[iterator - 1]);
            }
            fileReader.close();
        }
        catch(Exception e) {
            System.out.println("An error occured while reading file");
        }
        return lines;
    }
}

class Update {
    int _updatePrice;
    int _updateSize;
    String _updateType;
    public Update(int price, int size, String updateType) {
        _updatePrice = price;
        _updateSize = size;
        _updateType = updateType;
    }
}

class Query {
    String _queryType;
    int _queryPrice;
    public Query(String queryType) {
        _queryType = queryType;
    }
    public Query(String queryType, int queryPrice) {
        _queryType = queryType;
        _queryPrice = queryPrice;
    }
}

class Order {
    String _orderType;
    int _orderSize;
    public Order(String orderType, int orderSize) {
        _orderType = orderType;
        _orderSize = orderSize;
    }
}