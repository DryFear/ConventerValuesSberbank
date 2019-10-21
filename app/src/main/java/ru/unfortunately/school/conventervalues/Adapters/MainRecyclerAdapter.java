package ru.unfortunately.school.conventervalues.Adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import ru.unfortunately.school.conventervalues.Models.Conversion;
import ru.unfortunately.school.conventervalues.R;
import ru.unfortunately.school.conventervalues.RecyclerItemOnClickListener;

public class MainRecyclerAdapter extends Adapter<MainRecyclerAdapter.NamesHolder> {
    private static final String TAG = "MainRecyclerAdapter";

    private List<Conversion> mConventers;
    private RecyclerItemOnClickListener mMainListener;

    public MainRecyclerAdapter(RecyclerItemOnClickListener listener) {
        mMainListener = listener;
    }

    @NonNull
    @Override
    public NamesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_names_of_value, parent, false);
        return new NamesHolder(view, mMainListener);
    }

    @Override
    public void onBindViewHolder(@NonNull NamesHolder holder, int position) {
        holder.bindView(mConventers.get(position));
    }


    public void setValues(List<Conversion> mUnits){
        this.mConventers = new ArrayList<>(mUnits);
    }

    @Override
    public int getItemCount() {
        return mConventers.size();
    }

    static class NamesHolder extends RecyclerView.ViewHolder{

        private final TextView mName;
        private final RecyclerItemOnClickListener mListener;

        public NamesHolder(@NonNull View itemView, @NonNull RecyclerItemOnClickListener listener) {
            super(itemView);
            mListener = listener;
            mName = itemView.findViewById(R.id.name_of_value);
        }


        public void bindView(final Conversion conversion) {
            mName.setText(mName.getContext().getResources().getString(conversion.mLabelRes));
            Log.d(TAG, "bindView() called with");
            mName.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onClick(conversion);
                }
            });
        }
    }
}
