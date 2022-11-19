import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class App {
    public static void main(String[] args) throws Exception {
        getFileText();
    }
    
    public static String getFileText() {
        String inputData = " ";
        try {
            File input = new File("src/input.txt");
            Scanner fileReader = new Scanner(input);
            while(fileReader.hasNextLine()) {
                inputData += fileReader.nextLine();
                System.out.println(inputData);
            }
            fileReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occured while reading file");
            e.printStackTrace();
            return inputData;
        }
        return inputData;
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