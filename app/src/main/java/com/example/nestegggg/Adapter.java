package com.example.nestegggg;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<Adapter.Holder>{


    private Context context;
    private ArrayList<Model> arrayList;

    DataBaseHelper databaseHelper;

    public Adapter(Context context, ArrayList<Model> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        //initialize
        databaseHelper = new DataBaseHelper(context);
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

        //set views
        holder.goalimg.setImageURI(Uri.parse(image));
        holder.title.setText(title);
        holder.amount.setText(amount);

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                deleteDialog(""+id);
                return false;
            }
        });
    }

    private void deleteDialog(String id) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setIcon(R.drawable.ic_action_delete);
        builder.setCancelable(false);
        builder.setTitle("Delete");
        builder.setMessage("Are you want to delete?");

        builder.setPositiveButton("Yes", (dialog, which) -> {
            databaseHelper.deleteInfo(id);
            ((MainActivity)context).onResume();
            Toast.makeText(context, "Delete Successfully!", Toast.LENGTH_SHORT).show();
        });

        builder.setNegativeButton("No", (dialog, which) -> dialog.cancel());

        builder.create().show();
    }

    private void editDialog(String position, final String id, final String title, final String amount, final String addTimeStamp, final String updateTimeStamp) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setIcon(R.drawable.ic_action_edit);
        builder.setCancelable(false);
        builder.setTitle("Edit");
        builder.setMessage("Are you want to edit?");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Intent intent = new Intent(context, AddGoals.class);
                intent.putExtra("ID", id);
                intent.putExtra("TITLE", title);
                intent.putExtra("AMOUNT", amount);
                intent.putExtra("ADD_TIMESTAMP", addTimeStamp);
                intent.putExtra("UPDATE_TIMESTAMP", updateTimeStamp);
                intent.putExtra("editMode", true);
                context.startActivity(intent);

            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.create().show();
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class Holder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView goalimg;
        TextView title, amount;
        public Holder(@NonNull View itemView) {
            super(itemView);
            goalimg = itemView.findViewById(R.id.goalIMG);
            title = itemView.findViewById(R.id.goaltitle);
            amount = itemView.findViewById(R.id.goalamount);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int goal = getAdapterPosition();
            Toast.makeText(context, "goal"+goal, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(context, Goals.class);
            context.startActivity(intent);
        }
    }
}
