package comwow2778.naver.blog.app11;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<fruit> fruit = new ArrayList<fruit>();
    ArrayList<String> searchlist = new ArrayList<String>();
    ArrayAdapter<String> s_adapter;
    GridAdapter adapter;
    GridView gridview;
    int dataPosition = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridview = (GridView)findViewById(R.id.grid);
        fruit.add(new fruit("아보카도",0,"1000"));
        fruit.add(new fruit("바나나",1,"2000"));
        fruit.add(new fruit("체리",2,"3000"));
        fruit.add(new fruit("크렌베리",3,"4000"));
        fruit.add(new fruit("포도",4,"5000"));
        fruit.add(new fruit("키위",5,"6000"));
        fruit.add(new fruit("오렌지",6,"7000"));
        fruit.add(new fruit("참외",7,"8000"));
        for (int i = 0; i < fruit.size(); i++) {
            searchlist.add(fruit.get(i).getName());
        }

        s_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, searchlist);
        adapter = new GridAdapter(fruit, this);
        gridview.setAdapter(adapter);
        final addfruit addfruit = (addfruit) findViewById(R.id.add);
        final addcart addcart = (addcart) findViewById(R.id.cart);
        addfruit.et.setAdapter(s_adapter);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                fruit item = (fruit) adapter.getItem(position);
                String name = item.getName();
                int img = item.getImgno();
                addfruit.setWidget(name, img);
                dataPosition = position;
            }
        });
        addfruit.setOnaddListener(new addfruit.onaddListener() {
            @Override
            public void onAdd(String name, int imgno, String price) {
                adapter.addFruit(new fruit(name, imgno, price));
            }

            @Override
            public void onEdit(String name, int imgno, String price) {
                adapter.ModifiedFruit(new fruit(name, imgno, price), dataPosition);
            }
        });
        addcart.setOnCheckBoxChangedListener(new addcart.OnCheckBoxChangedListener() {
            @Override
            public void Checked(Boolean ischecked) {
                adapter.setVisible(ischecked);
            }
        });

    }
}

