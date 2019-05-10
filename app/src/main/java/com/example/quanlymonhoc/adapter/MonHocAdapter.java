package com.example.quanlymonhoc.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quanlymonhoc.R;
import com.example.quanlymonhoc.model.MonHoc;

import java.util.ArrayList;
import java.util.List;

public class MonHocAdapter extends RecyclerView.Adapter<MonHocAdapter.MyViewHolder> {
    private List<MonHoc> monhocs;
    private Context context;
    private ItemClickListener callback;



    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView maMh, tenMh, soTiet;
        public ImageView avatar;


        public MyViewHolder(View view) {
            super(view);
            maMh = (TextView) view.findViewById(R.id.txtMaRow);
            tenMh = (TextView) view.findViewById(R.id.txtTenRow);
            soTiet = (TextView) view.findViewById(R.id.txtSotietRow);
            avatar = (ImageView) view.findViewById(R.id.imageView);
        }

    }


    public MonHocAdapter(List<MonHoc> monHocs, Context context) {
        this.monhocs = monHocs;
        this.context = context;
    }

    public void setItemClickListener(ItemClickListener itemClickListener)
    {
        this.callback = itemClickListener;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.subject_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        MonHoc cl = monhocs.get(position);
        holder.maMh.setText(cl.getMaMH());
        holder.tenMh.setText(cl.getTenMH());
        holder.soTiet.setText(Integer.toString(cl.getSotiet()));
        holder.avatar.setImageResource(R.drawable.avatarpng);
        holder.itemView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onClick(position);
            }
        });

    };

    @Override
    public int getItemCount() {
        return this.monhocs.size();
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}
