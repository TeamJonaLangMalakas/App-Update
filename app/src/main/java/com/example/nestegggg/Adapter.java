package com.example.nestegggg;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<Adapter.Holder> {


    private Context context;
    private ArrayList<Model> arrayList;

    DataBaseHelper databaseHelper;

    public Adapter(Context context, ArrayList<Model> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        Model model = arrayList.get(position);
        // get for views
        final String id = model.getId();
        final String image = model.getImage();
        final String title = model.getTitle();
        final String amount = model.getAmount();
        final String addTimeStamp = model.getAddTimeStamp();
        final String updateTimeStamp = model.getUpdateTimeStamp();

        holder.goalimg.setImageURI(Uri.parse(image));
        holder.title.setText(title);
        holder.amount.setText(amount);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class Holder extends RecyclerView.ViewHolder{

        ImageView goalimg;
        TextView title, amount;
        public Holder(@NonNull View itemView) {
            super(itemView);
            goalimg = itemView.findViewById(R.id.goalIMG);
            title = itemView.findViewById(R.id.goaltitle);
            amount = itemView.findViewById(R.id.goalamount);
        }
    }
}
