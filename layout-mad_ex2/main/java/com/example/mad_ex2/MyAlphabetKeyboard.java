package com.example.mad_ex2;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputConnection;
import android.widget.LinearLayout;
import android.widget.Button;

public class MyAlphabetKeyboard extends LinearLayout implements View.OnClickListener {
    private Button[] b = new Button[29];
    private SparseArray<String> keyValues=new SparseArray<>();
    private InputConnection inputConnection;

    public MyAlphabetKeyboard(Context context) {
        this(context,null,0);
    }

    public MyAlphabetKeyboard(Context context, AttributeSet attrs) {
        this(context,attrs,0);
    }

    public MyAlphabetKeyboard(Context context,AttributeSet attrs, int defStyleAttr) {
        super(context,attrs,defStyleAttr);
        init(context,attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        LayoutInflater.from(context).inflate(R.layout.my_alphabet_keyboard,this,true);
        b[0]= (Button) findViewById(R.id.button_a);
        b[0].setOnClickListener(this);
        b[1]= (Button) findViewById(R.id.button_b);
        b[1].setOnClickListener(this);
        b[2]= (Button) findViewById(R.id.button_c);
        b[2].setOnClickListener(this);
        b[3]= (Button) findViewById(R.id.button_d);
        b[3].setOnClickListener(this);
        b[4]= (Button) findViewById(R.id.button_e);
        b[4].setOnClickListener(this);
        b[5]= (Button) findViewById(R.id.button_f);
        b[5].setOnClickListener(this);
        b[6]= (Button) findViewById(R.id.button_g);
        b[6].setOnClickListener(this);
        b[7]= (Button) findViewById(R.id.button_h);
        b[7].setOnClickListener(this);
        b[8]= (Button) findViewById(R.id.button_i);
        b[8].setOnClickListener(this);
        b[9]= (Button) findViewById(R.id.button_j);
        b[9].setOnClickListener(this);
        b[10]= (Button) findViewById(R.id.button_k);
        b[10].setOnClickListener(this);
        b[11]= (Button) findViewById(R.id.button_l);
        b[11].setOnClickListener(this);
        b[12]= (Button) findViewById(R.id.button_m);
        b[12].setOnClickListener(this);
        b[13]= (Button) findViewById(R.id.button_n);
        b[13].setOnClickListener(this);
        b[14]= (Button) findViewById(R.id.button_o);
        b[14].setOnClickListener(this);
        b[15]= (Button) findViewById(R.id.button_p);
        b[15].setOnClickListener(this);
        b[16]= (Button) findViewById(R.id.button_q);
        b[16].setOnClickListener(this);
        b[17]= (Button) findViewById(R.id.button_r);
        b[17].setOnClickListener(this);
        b[18]= (Button) findViewById(R.id.button_s);
        b[18].setOnClickListener(this);
        b[19]= (Button) findViewById(R.id.button_t);
        b[19].setOnClickListener(this);
        b[20]= (Button) findViewById(R.id.button_u);
        b[20].setOnClickListener(this);
        b[21]= (Button) findViewById(R.id.button_v);
        b[21].setOnClickListener(this);
        b[22]= (Button) findViewById(R.id.button_w);
        b[22].setOnClickListener(this);
        b[23]= (Button) findViewById(R.id.button_x);
        b[23].setOnClickListener(this);
        b[24]= (Button) findViewById(R.id.button_y);
        b[24].setOnClickListener(this);
        b[25]= (Button) findViewById(R.id.button_z);
        b[25].setOnClickListener(this);
        b[26]= (Button) findViewById(R.id.button_enter);
        b[26].setOnClickListener(this);
        b[27]= (Button) findViewById(R.id.button_space);
        b[27].setOnClickListener(this);
        b[28]= (Button) findViewById(R.id.button_delete);
        b[28].setOnClickListener(this);

        keyValues.put(R.id.button_a,"a");
        keyValues.put(R.id.button_b,"b");
        keyValues.put(R.id.button_c,"c");
        keyValues.put(R.id.button_d,"d");
        keyValues.put(R.id.button_e,"e");
        keyValues.put(R.id.button_f,"f");
        keyValues.put(R.id.button_g,"g");
        keyValues.put(R.id.button_h,"h");
        keyValues.put(R.id.button_i,"i");
        keyValues.put(R.id.button_j,"j");
        keyValues.put(R.id.button_k,"k");
        keyValues.put(R.id.button_l,"l");
        keyValues.put(R.id.button_m,"m");
        keyValues.put(R.id.button_n,"n");
        keyValues.put(R.id.button_o,"o");
        keyValues.put(R.id.button_p,"p");
        keyValues.put(R.id.button_q,"q");
        keyValues.put(R.id.button_r,"r");
        keyValues.put(R.id.button_s,"s");
        keyValues.put(R.id.button_t,"t");
        keyValues.put(R.id.button_u,"u");
        keyValues.put(R.id.button_v,"v");
        keyValues.put(R.id.button_w,"w");
        keyValues.put(R.id.button_x,"x");
        keyValues.put(R.id.button_y,"y");
        keyValues.put(R.id.button_z,"z");
        keyValues.put(R.id.button_space," ");
        keyValues.put(R.id.button_enter,"\n");
    }

    @Override
    public void onClick(View view) {
        if(inputConnection == null) return;

        if(view.getId() == R.id.button_delete) {
            CharSequence selectedText=inputConnection.getSelectedText(0);
            if(TextUtils.isEmpty(selectedText)) {
                inputConnection.deleteSurroundingText(1,0);
            } else {
                inputConnection.commitText("",1);
            }
        } else {
            String value=keyValues.get(view.getId());
            inputConnection.commitText(value,1);
        }
    }

    public void setInputConection(InputConnection ic) {
        inputConnection=ic;
    }
}
