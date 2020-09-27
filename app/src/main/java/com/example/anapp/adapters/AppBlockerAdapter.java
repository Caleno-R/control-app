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
import com.example.anapp.models.AppInfo;

public class AppBlockerAdapter extends FirestoreRecyclerAdapter<AppInfo,AppBlockerAdapter.AppHolder> {
    private OnItemClickListener listener;
    public AppBlockerAdapter(@NonNull FirestoreRecyclerOptions<AppInfo> options) {
        super(options);
    }
    @Override
    protected void onBindViewHolder(@NonNull AppHolder appHolder, int i, @NonNull AppInfo appInfo) {
        appHolder.tvAppname.setText(appInfo.getappName());
        appHolder.ivApp.setImageResource(appInfo.getImage());
    }

    @NonNull
    @Override
    public AppBlockerAdapter.AppHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_app_blocker,parent,false);
        return new AppHolder(v);
    }

    class AppHolder extends RecyclerView.ViewHolder{
        TextView tvAppname;
        ImageView ivApp;
        CheckBox cbAppBlocker;


        public AppHolder(@NonNull View itemView) {
            super(itemView);
            tvAppname=itemView.findViewById(R.id.tvAppName);
            ivApp=itemView.findViewById(R.id.ivApp);
            cbAppBlocker=itemView.findViewById(R.id.checkbox_AB);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position=getAdapterPosition();
                    if(position !=RecyclerView.NO_POSITION && listener!=null){
                        listener.onItemClick(getSnapshots().getSnapshot(position),position);

                    }
                }
            });
            cbAppBlocker.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if (b){

                    }else {

                    }
                }
            });
        }
    }
    public interface OnItemClickListener{
        void  onItemClick(DocumentSnapshot documentSnapshot,int position);
    }

    public void setOnClickListener(OnItemClickListener listener){
        this.listener=listener;
    }
}
