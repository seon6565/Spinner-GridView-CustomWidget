package comwow2778.naver.blog.app11;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by seon on 2017-04-27.
 */

public class addfruit extends LinearLayout implements View.OnClickListener {
   // final static int imglist[] = {R.drawable.abocado, R.drawable.banana, R.drawable.cherry, R.drawable.cranberry
    //        ,R.drawable.grape, R.drawable.orange, R.drawable.watermelon, R.drawable.kiwi};
   // final static int pricelist[] = {1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000};
    int imgno=0;
    int priceno =0;
    int position =0;
    AutoCompleteTextView et;
    ImageView img;
    Button b_next,b_add;
   // static final String[] list = {"abocado", "banana","cherry","cranberry","grape","orange","watermelon","kiwi"};
  //  ArrayAdapter<String> autoSearch;
    public addfruit(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }
    void init(Context context){
        LayoutInflater.from(context).inflate(R.layout.fruit_add,this);
        et = (AutoCompleteTextView)findViewById(R.id.f_name);
        img =(ImageView)findViewById(R.id.image1);
        b_next=(Button)findViewById(R.id.b_next);
        b_add  =(Button)findViewById(R.id.b_add);
        b_add.setOnClickListener(this);
        b_next.setOnClickListener(this);
    }

    void setWidget(String name, int no) {
        imgno = no;
        priceno = no;
        et.setText(name);
        img.setImageResource(fruit.imglist[imgno]);
        b_add.setText("M");
    }
    @Override
    public void onClick(View v) {
        if(v==b_add){
            if(b_add.getText().toString().equals("ADD")) {
                onaddListener.onAdd(et.getText().toString(), imgno, Integer.toString(fruit.pricelist[priceno]));
            }
            else{
                onaddListener.onEdit(et.getText().toString(), imgno, Integer.toString(fruit.pricelist[priceno]));
                b_add.setText("ADD");
            }
        }
        else if(v == b_next){
            imgno++;
            priceno++;
            if(imgno>7){
                imgno=0;
                priceno=0;
            }
            img.setImageResource(fruit.imglist[imgno]);
        }

    }



    interface onaddListener{
        void onAdd(String name, int imgno, String price);
        void onEdit(String name, int imgno, String price);
        //void onCancel(String name, int imageno);
    }
    public onaddListener onaddListener;

    public void setOnaddListener(onaddListener onaddListener){
        this.onaddListener = onaddListener;
    }
}
