package com.example.gautamnarayanan.lab3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {

    String ids[] = {"b1","b2","b3","b4","b5","b6","b7","b8","b9"};
    boolean flags =true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button refresh = (Button)findViewById(R.id.refresh);
        final GridView myGrid = (GridView)findViewById(R.id.myGrid);
        final MyAdapter myadapter = new MyAdapter(this,ids);
        myGrid.setAdapter(myadapter);

        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myadapter.notifyDataSetChanged();
            }
        });


    }
}
