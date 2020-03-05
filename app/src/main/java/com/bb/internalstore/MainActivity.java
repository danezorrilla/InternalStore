package com.bb.internalstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView fruitListView;

    private List fruitList = new ArrayList<Fruit>();
    private FruitAdapter fruitAdapter;

    //Step 1
    public static final String FILE_NAME = "fruit_db.txt";
    private String delimiter = "|";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fruitListView = findViewById(R.id.list_view);

        try{
            createMockFruits();
        } catch(IOException e){
            e.printStackTrace();
        }
        //displayFruit();
    }

    private void createMockFruits() throws IOException{
        //fruitList.add(writeToInternal(new Fruit("Apple", "08:05")));
        writeToInternal(new Fruit("Apple", "08:05"));

        readFromInternal();
    }

    private void writeToInternal(Fruit fruit) throws IOException {
        FileOutputStream fileOS = openFileOutput(FILE_NAME, Context.MODE_APPEND);

        String fruitString = fruit.getFruitName() + delimiter + fruit.getTimeEaten() + "\n";
        byte [] fruitBytes = fruitString.getBytes();
        fileOS.write(fruitBytes);
        fileOS.close();
    }

    private void readFromInternal() throws IOException{
        FileReader reader = new FileReader(getFilesDir().getPath()+"/"+FILE_NAME);
        BufferedReader bufferedReader = new BufferedReader(reader);

        String currentFruit = null;

        while((currentFruit = bufferedReader.readLine()) != null){
            Log.d("TAG_X,", "Current Fruit: " + currentFruit);

            String [] fr = currentFruit.split("\\"+delimiter);
           // String [] fr2 = currentFruit.split("\\|");
            //System.out.println(fr2);

            //System.out.println(fr);
            Fruit fruit = new Fruit(fr[0], fr[1]);
            //System.out.println(fruit);
            fruitList.add(fruit);
            //fruitList.clear();
            System.out.println(fruitList.get(0).toString());
        }

        fruitAdapter = new FruitAdapter(fruitList);
        fruitListView.setAdapter(fruitAdapter);

        bufferedReader.close();
        reader.close();
    }
}
