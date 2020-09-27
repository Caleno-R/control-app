package com.example.anapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.anapp.adapters.AppLogAdapter;
import com.example.anapp.adapters.AppLogAdapter;
import com.example.anapp.models.AppLog;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class AppLogActivity extends AppCompatActivity {
    private FirebaseFirestore db=FirebaseFirestore.getInstance();
    private CollectionReference appsRef=db.collection("children").document().collection("apps");
    private AppLogAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_log);
        setUpRecyclerView();
    }
    private void setUpRecyclerView(){
        Query query=appsRef;

        FirestoreRecyclerOptions<AppLog> options=new FirestoreRecyclerOptions.Builder<AppLog>()
                .setQuery(query,AppLog.class)
                .build();

        adapter=new AppLogAdapter(options);

        RecyclerView recyclerView=findViewById(R.id.appLog_recyclev);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


       
    }
}