package comwow2778.naver.blog.app11;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;

/**
 * Created by seon on 2017-05-02.
 */

public class addcart extends LinearLayout implements View.OnClickListener  {
    CheckBox c1;
    int Visible = 0;
    public addcart(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    @Override
    public void onClick(View v) {

    }

    void init(Context context){
        LayoutInflater.from(context).inflate(R.layout.cart_add,this);
        c1 = (CheckBox)findViewById(R.id.c1);

        c1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                onCheckBoxChangedListener.Checked(c1.isChecked());
            }
        });
    }
    interface OnCheckBoxChangedListener{
        void Checked(Boolean ischecked);
    }

    public OnCheckBoxChangedListener onCheckBoxChangedListener;

    public void setOnCheckBoxChangedListener(OnCheckBoxChangedListener onCheckBoxChangedListener){
        this.onCheckBoxChangedListener = onCheckBoxChangedListener;
    }
}
