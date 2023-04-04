package com.example.javaviikko11;

import android.content.Context;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Storage {
    private static Storage instance = null;
    private ArrayList<Product> products;

    private Storage() {
        products = new ArrayList<>();
        instance = this;
    }

    public static Storage getInstance() {
        if (instance == null) {
            instance = new Storage();
        }
        return instance;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public Product getProductByIdWithoutRemove(int id) {
        return products.get(id);
    }



    public void saveProducts(Context context){
        try {
            ObjectOutputStream productWriter = new ObjectOutputStream(context.openFileOutput("products.data", Context.MODE_PRIVATE));
            productWriter.writeObject(products);
            productWriter.close();
            System.out.println("Ostosten tallentaminen ONNISTUI");
        } catch (IOException e){
            System.out.println("Ostosten tallentaminen ei onnistunut");
        }
    }

    public void loadProducts(Context context){
        try {
            ObjectInputStream productReader = new ObjectInputStream(context.openFileInput("products.data"));
            products = (ArrayList<Product>) productReader.readObject();
            productReader.close();
            System.out.println("Ostosten lataaminen ONNISTUI");
        } catch (FileNotFoundException e){
            System.out.println("Ostosten lataaminen ei onnistunut");
            e.printStackTrace();
        } catch (IOException e){
            System.out.println("Ostosten lataaminen ei onnistunut");
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            System.out.println("Ostosten lataaminen ei onnistunut");
            e.printStackTrace();
        }
    }
}
