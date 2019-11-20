package ru.unfortunately.school.conventervalues;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import ru.unfortunately.school.conventervalues.Adapters.ValuesSpinnerAdapter;
import ru.unfortunately.school.conventervalues.Models.Conversion;
import ru.unfortunately.school.conventervalues.Models.Units;

public class ConverterFragment extends Fragment {

    private static final String ARG_CONVERSION = "conversion";

    private EditText mLeftEditText;
    private EditText mRightEditText;
    private Spinner mLeftSpinner;
    private Spinner mRightSpinner;

    private Conversion mConversion;


    private ConverterFragment(){
        super(R.layout.fragment_conventer);
    }

    public static ConverterFragment newInstance(Conversion conversion) {

        Bundle args = new Bundle();
        ConverterFragment fragment = new ConverterFragment();
        int value = conversion.ordinal();
        args.putSerializable(ARG_CONVERSION, conversion);
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = super.onCreateView(inflater, container, savedInstanceState);
        mConversion = (Conversion) getArguments().getSerializable(ARG_CONVERSION);
        initViews(root);
        return root;
    }

    private void initViews(View root){
        mLeftEditText = root.findViewById(R.id.edit_text_left);
        mRightEditText = root.findViewById(R.id.edit_text_right);
        mLeftSpinner = root.findViewById(R.id.spinner_left);
        mRightSpinner = root.findViewById(R.id.spinner_right);
        if(mConversion == null)
            mConversion = Conversion.AREA;
        TextView mHeader = root.findViewById(R.id.text_view_header);
        mHeader.setText(mConversion.mLabelRes);
        setUpEditTexts();
        setUpSpinner(mLeftSpinner);
        setUpSpinner(mRightSpinner);
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
        final List<Units> units = new ArrayList<>(mConversion.units);
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

}
