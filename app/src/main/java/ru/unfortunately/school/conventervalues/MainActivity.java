package ru.unfortunately.school.conventervalues;

import android.content.Intent;
import android.os.Bundle;

import java.util.Arrays;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ru.unfortunately.school.conventervalues.Adapters.MainRecyclerAdapter;
import ru.unfortunately.school.conventervalues.Models.Conversion;

public class MainActivity extends AppCompatActivity implements RecyclerItemOnClickListener {

    private static final String TAG = "MainActivityTAG";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRecyclerView();

    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recycler);
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        MainRecyclerAdapter adapter = new MainRecyclerAdapter(this);
        adapter.setValues(Arrays.asList(Conversion.values()));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onClick(@NonNull Conversion conversion) {
        Intent intent = new Intent(this, ConventerActivity.class);
        intent.putExtra("Conversion", conversion);
        startActivity(intent);
    }
}
