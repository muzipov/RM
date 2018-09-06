package ru.britishdesign.rm.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ru.britishdesign.rm.R;
import ru.britishdesign.rm.adapter.RemindListAdapter;
import ru.britishdesign.rm.dto.RemindDTO;

public class LessonsFragment extends AbstractTabFragment {
    private static final int LAYOUT = R.layout.fragment_lessons;

    private List<RemindDTO> data;
    private RemindListAdapter adapter;

    public static LessonsFragment getInstance(Context context, List<RemindDTO> data) {

        Bundle args = new Bundle();
        LessonsFragment fragment = new LessonsFragment();
        fragment.setArguments(args);
        fragment.setData(data);
        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.tab_item_lessons));

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT, container, false);

        RecyclerView rv = (RecyclerView) view.findViewById(R.id.recycleView);
        rv.setLayoutManager(new LinearLayoutManager(context));
        adapter = new RemindListAdapter(data);
        rv.setAdapter(adapter);

        return view;
    }


    public void setContext(Context context) {
        this.context = context;

    }

    public void setData(List<RemindDTO> data) {
        this.data = data;
    }

    public void refreshData(ArrayList<RemindDTO> data){
        adapter.setData(data);
        adapter.notifyDataSetChanged();
    }
}
