package com.example.anapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.example.anapp.adapters.AppBlockerAdapter;
import com.example.anapp.models.AppInfo;

public class AppBlockerActivity extends AppCompatActivity {
    private FirebaseFirestore db=FirebaseFirestore.getInstance();
    private CollectionReference appsRef=db.collection("children").document().collection("apps");
    private AppBlockerAdapter adapter;
    private SwitchCompat switchAppBlocker,switchAutoRestrict;

    private TextView tvSaveAB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_blocker);
        setUpRecyclerView();

    }
    private void setUpRecyclerView(){
        Query query=appsRef;

        FirestoreRecyclerOptions<AppInfo> options=new FirestoreRecyclerOptions.Builder<AppInfo>()
                .setQuery(query,AppInfo.class)
                .build();

        adapter=new AppBlockerAdapter(options);

        RecyclerView recyclerView=findViewById(R.id.appBlocker_recyclev);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


        adapter.setOnClickListener(new AppBlockerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(DocumentSnapshot documentSnapshot, int position) {
                String id=documentSnapshot.getId();
                String path =documentSnapshot.getReference().getPath();

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
        tvSaveAB=findViewById(R.id.tvSaveAB);
        switchAppBlocker=findViewById(R.id.switchAppBlocker);
        switchAutoRestrict=findViewById(R.id.switchAutoRestrict);


        //tvSaveAB on click listener
        tvSaveAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });

        //Switch App Blocker
switchAppBlocker.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if(b){ }else{ }
    }
});
        //Switch Auto Restrict
        switchAutoRestrict.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) { if(b){ }else{ } }
        });


    }
    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}