package comwow2778.naver.blog.app11;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by seon on 2017-04-27.
 */

public class GridAdapter extends BaseAdapter {
    ArrayList<fruit> data = new ArrayList<>();
    ArrayList<String> cart = new ArrayList<>();
    Boolean Visible = false;
    Context context;
    TextView fruit_price;
    public GridAdapter(ArrayList<fruit> data, Context context){
        this.data = data;
        this.context = context;
    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.grid_item, null);
        }
        final TextView fruit_name =(TextView)convertView.findViewById(R.id.fruit_name);
        fruit_price = (TextView)convertView.findViewById(R.id.fruit_price);
        final ImageView img = (ImageView)convertView.findViewById(R.id.fruit_image);

        fruit fruit = data.get(position);
        if(Visible){
            fruit_price.setVisibility(TextView.VISIBLE);
        }
        else {
            fruit_price.setVisibility(TextView.GONE);
        }
        fruit_name.setText(fruit.getName());
        fruit_price.setText(fruit.getPrice());
        img.setImageResource(fruit.imglist[fruit.getImgno()]);
        return convertView;
    }

    public void setVisible(Boolean isVisible){
        Visible = isVisible;
        notifyDataSetChanged();
    }

    void addfruit(fruit fruit){
        data.add(fruit);
        this.notifyDataSetChanged();
    }

    public void setSelectVisible(Boolean isVisible){
        cart.clear();
        Visible = isVisible;
        notifyDataSetChanged();
    }

    public void addFruit(fruit one){
        data.add(one);
        notifyDataSetChanged();
    }

    public void ModifiedFruit(fruit one, int position){
        fruit fruitdata = data.get(position);
        fruitdata.setName(one.getName());
        fruitdata.setImgno(one.getImgno());
        fruitdata.setPrice(one.getPrice());
        notifyDataSetChanged();
    }
}
