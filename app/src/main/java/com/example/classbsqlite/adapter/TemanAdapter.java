package com.example.classbsqlite.adapter;

import android.content.Intent;
import android.graphics.Paint;
import android.service.controls.Control;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.processor.Context;

import com.example.classbsqlite.MainActivity;
import com.example.classbsqlite.R;
import com.example.classbsqlite.database.DBController;
import com.example.classbsqlite.database.Teman;
import com.example.classbsqlite.edit_teman;

import java.util.ArrayList;
import java.util.HashMap;

public class TemanAdapter extends RecyclerView.Adapter<TemanAdapter.TemanViewHolder> {
    private ArrayList<Teman> listData;
    private Context control;

    public TemanAdapter(ArrayList<Teman> listData) {
        this.listData = listData;
    }



    @Override
    public TemanAdapter.TemanViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInf = LayoutInflater.from(parent.getContext());
        View view = layoutInf.inflate(R.layout.row_data_teman,parent, false);
        control = parent.getContext();
        return new TemanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TemanAdapter.TemanViewHolder holder, int position) {
        String nm, tlp,nma,id;

        id = listData.get(position).getId();
        nma = listData.get(position).getNama();
        nm = listData.get(position).getNama();
        tlp = listData.get(position).getTelpon();
        DBController db = new DBController(control);

        holder.namaTxtView.setTextSize(30);
        holder.namaTxt.setText(nm);
        holder.telponTxt.setText(tlp);

        holder.card.setOnLongClic(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                PopupMenu popupMenu = new PopupMenu(control, holder.card);
                PopupMenu.inflate(R.menu.popup_menu);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.mnEdit:
                                Intent i = new Intent(control, edit_teman.class);
                                i.putExtra("id", id);
                                i.putExtra("nama",nma);
                                i.putExtra("telpon",tlp);
                                control.startActivity(i);
                                break;
                            case R.id.mnHapus:
                                HashMap<String,String> values = new HashMap<>();
                                values.put("id",id);
                                db.DeleteData(values);
                                Intent j = new Intent(control, MainActivity.class);
                                control.startActivity(j);
                                break;


                        }
                        return true;
                    }
                });
                popupMenu.show();
                return false;
            }
        });

    }

    @Override
    public int getItemCount() {
        return (listData != null )? listData.size() :0;
    }

    public class TemanViewHolder extends RecyclerView.ViewHolder {

        public int card;
        private CardView cardku;
        private TextView namaTxtView, namaTxt, telponTxt;

        public TemanViewHolder(View view) {
            super(view);
            cardku=(CardView) view.findViewById(R.id.Kartuku);
            namaTxt=(TextView) view.findViewById(R.id.textNama);
            telponTxt=(TextView)view.findViewById(R.id.textTelpon);
        }
    }
}
