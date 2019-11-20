package ru.unfortunately.school.conventervalues;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import ru.unfortunately.school.conventervalues.Models.Conversion;

public class MainActivity extends AppCompatActivity implements RecyclerItemOnClickListener {

    private static final String TAG = "MainActivityTAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_place, MainFrameFragment.newInstance(this))
                .addToBackStack(null)
                .commit();

    }


    @Override
    public void onClick(@NonNull Conversion conversion) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_place, ConverterFragment.newInstance(conversion))
                .addToBackStack(null)
                .commit();
    }
}
