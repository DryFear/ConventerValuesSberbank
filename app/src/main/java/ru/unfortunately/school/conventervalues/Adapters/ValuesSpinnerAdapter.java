package ru.unfortunately.school.conventervalues.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ru.unfortunately.school.conventervalues.Models.Units;
import ru.unfortunately.school.conventervalues.R;

public class ValuesSpinnerAdapter extends BaseAdapter {

    private List<Units> mUnits;

    public ValuesSpinnerAdapter(List<Units> units){
        mUnits = new ArrayList<>(units);
    }

    @Override
    public int getCount() {
        return mUnits.size();
    }

    @Override
    public Units getItem(int position) {
        return mUnits.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(
                    android.R.layout.simple_list_item_1, parent, false);
            ViewHolder holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }
        ViewHolder holder = (ViewHolder) convertView.getTag();
        holder.mValue.setText(getItem(position).mLabelRes);
        return convertView;
    }

    private class ViewHolder{
        private final TextView mValue;

        ViewHolder(View view){
            mValue = view.findViewById(android.R.id.text1);
            mValue.setTextSize(mValue.getResources().getDimension(R.dimen.spinner_text_size));
        }
    }
}
