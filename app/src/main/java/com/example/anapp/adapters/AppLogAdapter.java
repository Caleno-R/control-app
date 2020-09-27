package com.example.anapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.DocumentSnapshot;
import com.example.anapp.R;
import com.example.anapp.models.AppLog;

public class AppLogAdapter extends FirestoreRecyclerAdapter<AppLog,AppLogAdapter.AppLogHolder> {

    public AppLogAdapter(@NonNull FirestoreRecyclerOptions<AppLog> options) {
        super(options);
    }
    @Override
    protected void onBindViewHolder(@NonNull AppLogHolder appLogHolder, int i, @NonNull AppLog appLog) {
        appLogHolder.tvAppname.setText(appLog.getappName());
        appLogHolder.tvApptime.setText(appLog.getAppTime());
        appLogHolder.ivApp.setImageResource(appLog.getImage());
    }

    @NonNull
    @Override
    public AppLogAdapter.AppLogHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_app_log,parent,false);
        return new AppLogHolder(v);
    }

    class AppLogHolder extends RecyclerView.ViewHolder{
        TextView tvAppname,tvApptime;
        ImageView ivApp;



        public AppLogHolder(@NonNull View itemView) {
            super(itemView);
            tvAppname=itemView.findViewById(R.id.tvAppName_AL);
            ivApp=itemView.findViewById(R.id.ivApp_AL);
            tvApptime=itemView.findViewById(R.id.tvAppTime_AL);



        }
    }

}