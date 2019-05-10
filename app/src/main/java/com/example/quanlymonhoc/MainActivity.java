package com.example.quanlymonhoc;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quanlymonhoc.adapter.ItemClickListener;
import com.example.quanlymonhoc.adapter.MonHocAdapter;
import com.example.quanlymonhoc.model.MonHoc;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<MonHoc> monHocs;
    MonHocAdapter monHocAdapter;
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    Button insert, update, delete;

    int index = -1;

    TextView mamh, tenmh, sotiet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycleMonHoc);
        mamh = (TextView) findViewById(R.id.edtMa);
        tenmh = (TextView) findViewById(R.id.edtTen);
        sotiet = (TextView) findViewById(R.id.edtSotiet);

        fakeMonHoc();
        monHocAdapter = new MonHocAdapter(this.monHocs, this);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(monHocAdapter);
        monHocAdapter.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(int position) {
                index = position;
            }
        });
    }

    private MonHoc getMonHoc() {
        MonHoc monHoc = new MonHoc(mamh.getText().toString(), tenmh.getText().toString(), Integer.parseInt(sotiet.getText().toString()));
        return monHoc;
    }


    private void fakeMonHoc(){
        this.monHocs = new ArrayList<>();
        monHocs.add(new MonHoc("001", "Toan cao cap", 40));
        monHocs.add(new MonHoc("002", "Toan thap cap", 50));
        monHocs.add(new MonHoc("003", "Toan vua cap", 60));
    }

    public void insertMH(View view) {
        MonHoc mh = getMonHoc();
        monHocs.add(mh);
        monHocAdapter.notifyDataSetChanged();
    }

    public void deleteMH(View view) {
        if(monHocs.size() >= 0 && index >= 0 && index < monHocs.size()) {
            monHocs.remove(index);
            monHocAdapter.notifyDataSetChanged();
            Toast.makeText(this, "Xóa thành công", Toast.LENGTH_SHORT).show(); }
        else
            Toast.makeText(this, "Xóa không thành công", Toast.LENGTH_SHORT).show(); }

    public void updateMH(View view)
    {
        String ma = mamh.getText().toString();
        String ten = tenmh.getText().toString();
        String st = sotiet.getText().toString();

        monHocs.get(index).setMaMH(ma);
        monHocs.get(index).setSotiet(Integer.parseInt(st));
        monHocs.get(index).setTenMH(ten);
        Toast.makeText(this, "Update Thành Công!", Toast.LENGTH_SHORT).show();
        monHocAdapter.notifyDataSetChanged();
    }

}
