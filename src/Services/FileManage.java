package Services;

import Models.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManage {
    public FileManage(){

    }
    public static void writeToFile(List<Product> PRODUCTS){
        try {
            FileWriter fileWriter = new FileWriter("data.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Product product : PRODUCTS) {
                bufferedWriter.write(product.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }

    public static List<Product> readFromFile(){
        List<Product> PRODUCTS = new ArrayList<>();
        try{
            FileReader fileReader = new FileReader("data.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while (true){
                line = bufferedReader.readLine();
                if (line == null){
                    break;
                }
                String txt[] = line.split(";");
                String name = txt[0];
                Integer quantity = Integer.parseInt(txt[1]);
                Integer price = Integer.parseInt(txt[2]);
                String description = txt[3];
                PRODUCTS.add(new Product(name, quantity, price, description));
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return PRODUCTS;
    }
}
