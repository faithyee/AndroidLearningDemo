package com.faithyee.androidlearningdemo.ui.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.faithyee.androidlearningdemo.R;

public class ViewDemoDisplay5Act extends AppCompatActivity {

    private ListView lv_one;
    private ListView lv_two;
    private ListView lv_thr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_view_demo_display5);
        lv_one=(ListView)this.findViewById(R.id.lv_one);
        lv_two=(ListView)this.findViewById(R.id.lv_two);
        lv_thr=(ListView)this.findViewById(R.id.lv_thr);
        String[] strs1 = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15"};
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,strs1);
        lv_one.setAdapter(adapter1);

        String[] strs2 = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,strs2);
        lv_two.setAdapter(adapter2);

        String[] strs3 = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O"};
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,strs3);
        lv_thr.setAdapter(adapter2);
    }
}
