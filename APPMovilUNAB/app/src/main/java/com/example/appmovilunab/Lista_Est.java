package com.example.appmovilunab;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appmovilunab.adapters.CustomListViewAdapter;
import com.example.appmovilunab.items.RowItem;

import java.util.ArrayList;
import java.util.List;

public class Lista_Est  extends Activity implements AdapterView.OnItemClickListener {
    String x="FUNCIONA";
    TextView btn3;
    String subtext;
    String fruit;
    private Integer posiiton;
    private String view;





    public static final String[] titles = new String[] { "Federico Fellini",
            "Tristan Tzara", "Edvard Munch", "Marcel Duchamp" };

    public static final String[] descriptions = new String[] {
            "20112108132",
            "20112108145", "20112108198",
            "20112108109" };

    public static final Integer[] images = { R.drawable.habilitado,
            R.drawable.inhabilitado, R.drawable.habilitado, R.drawable.habilitado};

    ListView listView;
    List<RowItem> rowItems;



    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list1);
        String x="txt";
        TextView btn3;
        String fruit;
//
//        btn3 = (TextView) findViewById(R.id.button3);
//        btn3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent intent =new Intent(ImageTextListViewActivity.this, MainActivity2.class);
//                intent.putExtra("dato", x);
//                startActivity(intent);
//
//            }
        //    });

        rowItems = new ArrayList<RowItem>();
        for (int i = 0; i < titles.length; i++) {
            RowItem item = new RowItem(images[i], titles[i], descriptions[i]);
            rowItems.add(item);
        }

        listView = (ListView) findViewById(R.id.listEst2);
        CustomListViewAdapter adapter = new CustomListViewAdapter(this,
                R.layout.list_item, rowItems);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }


    public String getSubtext(String subtext) {
        return this.subtext;
    }

    public void setSubtext(String subtext) {
        this.subtext = subtext;
    }

    public String getFruit(String fruit) {
        return this.fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        fruit = String.valueOf(position + 1);
        subtext = String.valueOf(rowItems.get(position));
        getFruit(fruit);
        getSubtext(subtext);
        Intent intent =new Intent(Lista_Est.this, Detalle_Estudiante.class);
        intent.putExtra("dato", x);
        //startActivity(intent);


//        Toast toast = Toast.makeText(getApplicationContext(),
//               // "Item " + (position + 1) + ": " + rowItems.get(position), Toast.LENGTH_SHORT);
//                "Item " + fruit + ": " + subtext, Toast.LENGTH_SHORT);
//        toast.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 0);
//        toast.show();

        //this.view = "fruit";

        onItemClick(view);


    }
    public void onItemClick(View view){
        //setFruit(fruit);
        //setSubtext(subtext);

        Toast toast = Toast.makeText(getApplicationContext(),
                // "Item " + (position + 1) + ": " + rowItems.get(position), Toast.LENGTH_SHORT);
                "Item " + fruit + ": " + subtext + view, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();


    }




}
