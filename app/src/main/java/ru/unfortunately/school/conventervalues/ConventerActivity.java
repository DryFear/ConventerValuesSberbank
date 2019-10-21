package ru.unfortunately.school.conventervalues;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import ru.unfortunately.school.conventervalues.Adapters.ValuesSpinnerAdapter;
import ru.unfortunately.school.conventervalues.Models.Conversion;
import ru.unfortunately.school.conventervalues.Models.Units;

public class ConventerActivity extends AppCompatActivity {

    private static final String TAG = "ConventerActivity";
    
    private EditText mLeftEditText;
    private EditText mRightEditText;
    private Spinner mLeftSpinner;
    private Spinner mRightSpinner;

    private Conversion mConversion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conventer);
        initAll();
        setUpSpinner(mLeftSpinner);
        setUpSpinner(mRightSpinner);
        setUpEditTexts();

    }

    private void setUpEditTexts() {
        mLeftEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                convert(getValueFromLeftTextEdit());
            }
        });
    }

    private double getValueFromLeftTextEdit(){
        double value;
        String stringFromLeftEditText = mLeftEditText.getText().toString();
        try {
            value = Double.parseDouble(stringFromLeftEditText);
        }catch (Exception e){
            value = 0f;
        }
        return value;
    }

    private void convert(double value){
        Units leftUnit = (Units) mLeftSpinner.getSelectedItem();
        Units rightUnit = (Units) mRightSpinner.getSelectedItem();
        double tempValue = leftUnit.mConvertToBase * value;
        mRightEditText.setText(String.valueOf(tempValue * rightUnit.mConvertFromBase));
    }

    private void setUpSpinner(Spinner spinner) {
        final List<Units> units = new ArrayList<>();
        units.addAll(mConversion.units);
        ValuesSpinnerAdapter adapter = new ValuesSpinnerAdapter(units);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                convert(getValueFromLeftTextEdit());

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void initAll() {
        mLeftEditText = findViewById(R.id.edit_text_left);
        mRightEditText = findViewById(R.id.edit_text_right);
        mLeftSpinner = findViewById(R.id.spinner_left);
        mRightSpinner = findViewById(R.id.spinner_right);
        mConversion = (Conversion) getIntent().getSerializableExtra("Conversion");
        if(mConversion == null)
            mConversion = Conversion.AREA;
        TextView mHeader = findViewById(R.id.text_view_header);
        mHeader.setText(mConversion.mLabelRes);
    }
}
