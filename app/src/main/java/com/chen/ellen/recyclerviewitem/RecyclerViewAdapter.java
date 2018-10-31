package com.chen.ellen.recyclerviewitem;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private String text;

    private Context context;

    public RecyclerViewAdapter(Context context,String text){

        this.context = context;
        this.text = text;

    }

    public int TYPEA = 0;
    public int TYPEB = 1;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        if(i == TYPEA){
            return  new MyViewHolderA(LayoutInflater.from(context).inflate(R.layout.item1,null));
        }else if(i == TYPEB){
            return  new MyViewHolderB(LayoutInflater.from(context).inflate(R.layout.item2,null));
        }

        return null;

    }

    @Override
    public int getItemViewType(int position) {
        if(position %5 ==0){
            return TYPEB;
        }else {
            return TYPEA;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {


        if(viewHolder instanceof  MyViewHolderA){

            //这里是ViewHolderA
            MyViewHolderA myViewHolderA = (MyViewHolderA) viewHolder;
            myViewHolderA.textView.setText(this.text);

        }else if(viewHolder instanceof MyViewHolderB){

            MyViewHolderB myViewHolderB = (MyViewHolderB) viewHolder;


        }


    }


    @Override
    public int getItemCount() {
        return 20;
    }

    class MyViewHolderA extends RecyclerView.ViewHolder{


        TextView textView;

        public MyViewHolderA(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv1);
        }

    }

    class MyViewHolderB extends RecyclerView.ViewHolder{

        public MyViewHolderB(@NonNull View itemView) {
            super(itemView);
        }
    }

}
