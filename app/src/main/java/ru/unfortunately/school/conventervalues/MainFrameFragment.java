package ru.unfortunately.school.conventervalues;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Arrays;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ru.unfortunately.school.conventervalues.Adapters.MainRecyclerAdapter;
import ru.unfortunately.school.conventervalues.Models.Conversion;

public class MainFrameFragment extends Fragment {


    public static MainFrameFragment newInstance(RecyclerItemOnClickListener listener) {
        
        Bundle args = new Bundle();
        MainFrameFragment fragment = new MainFrameFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private MainFrameFragment(){
        super(R.layout.fragment_main_frame);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = super.onCreateView(inflater, container, savedInstanceState);
        initRecyclerView(root);
        return root;
    }

    private void initRecyclerView(View root) {
        RecyclerView recyclerView = root.findViewById(R.id.recycler);
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        RecyclerItemOnClickListener listener = (RecyclerItemOnClickListener) requireActivity();

        MainRecyclerAdapter adapter = new MainRecyclerAdapter(listener);
        adapter.setValues(Arrays.asList(Conversion.values()));
        recyclerView.setAdapter(adapter);

    }
    
}
