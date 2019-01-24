package com.example.gautamnarayanan.lab3;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Gautam Narayanan on 1/24/2019.
 */

public class MyAdapter extends BaseAdapter {


    String[] ids;
    Context context;
    boolean flag = true;
    int count = 0;

    public MyAdapter(Context context,String[] ids) {
        this.ids = ids;
        this.context=context;
    }

    @Override
    public int getCount() {
        return ids.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }



    @Override
    public View getView(int i, View view, final ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.my_layout,viewGroup,false);

        final Button b = (Button)view.findViewById(R.id.myButton);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                if(flag)
                    b.setText("X");
                else
                    b.setText("O");

                flag = !flag;
                checkWin(viewGroup);
            }
        });
        return  view;
    }

    void checkWin(ViewGroup viewGroup)
    {
        int n = viewGroup.getChildCount();
        String id[]=new String[n];
        for(int i=0;i<n;i++)
        {
            View v=viewGroup.getChildAt(i);
            Button b = (Button)v.findViewById(R.id.myButton);
            id[i] = b.getText().toString();
        }

        if((id[0].equals(id[1])&& id[0].equals(id[2])&&!id[0].isEmpty())|| (id[3].equals(id[4])&& id[4].equals(id[5])&&!id[3].isEmpty())||(id[6].equals(id[7])&& id[7].equals(id[8])&&!id[6].isEmpty()))
        {
            if(flag)
                Toast.makeText(context,"O wins",Toast.LENGTH_LONG).show();
            else
                Toast.makeText(context,"X wins",Toast.LENGTH_LONG).show();

        }

        else
        if((id[0]==id[3]&& id[3]==id[6]&&!id[0].isEmpty())|| (id[1]==id[4]&& id[4]==id[7]&&!id[1].isEmpty())||(id[2]==id[5]&& id[5]==id[8]&&!id[2].isEmpty()))
        {
            if(flag)
                Toast.makeText(context,"O wins",Toast.LENGTH_LONG).show();
            else
                Toast.makeText(context,"X wins",Toast.LENGTH_LONG).show();

        }
        else
        if((id[0]==id[4]&& id[4]==id[8]&&!id[0].isEmpty())||(id[2]==id[4]&& id[4]==id[6]&&!id[2].isEmpty()))
        {
            if(flag)
                Toast.makeText(context,"O wins",Toast.LENGTH_LONG).show();
            else
                Toast.makeText(context,"X wins",Toast.LENGTH_LONG).show();
        }
        else
        if(count==9)
            Toast.makeText(context,"Draw",Toast.LENGTH_LONG).show();

    }




}
