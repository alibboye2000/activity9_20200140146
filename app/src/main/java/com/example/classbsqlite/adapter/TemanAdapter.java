package com.example.classbsqlite.adapter;

import android.icu.text.Transliterator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.parser.expansion.Position;

import com.example.classbsqlite.R;
import com.example.classbsqlite.database.Teman;

import java.util.ArrayList;

public class TemanAdapter extends RecyclerView.Adapter<TemanAdapter.TemanViewHolder> {
    private ArrayList<Teman> listData;

    public TemanAdapter(ArrayList<Teman> listData) {
        this.listData = listData;
    }

    @Override
    public TemanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInf = LayoutInflater.from(parent.getContext());
        View view = layoutInf.inflate(R.layout.row_data_teman,parent, false);
        return new TemanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TemanViewHolder holder, int position) {
        String nm, tlp;

        nm = listData.get(position).getNama();
        tlp = listData.get(position).getNama();

        holder.namaTxt.setText(nm);
        holder.telponTxt.setText(tlp);

    }

    @Override
    public int getItemCount() {
        return (listData != null )? listData.size() :0;
    }

    public class TemanViewHolder extends RecyclerView.ViewHolder {
        private CardView cardku;
        private TextView namaTxt, telponTxt;

        public TemanViewHolder(View view) {
            super(view);
            cardku=(CardView) view.findViewById(R.id.Kartuku);
            namaTxt=(TextView) view.findViewById(R.id.textNama);
            telponTxt=(TextView)view.findViewById(R.id.textTelpon);
        }
    }
}
