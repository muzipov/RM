package ru.britishdesign.rm.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.britishdesign.rm.R;

public class UU_EventFragment extends AbstractTabFragment {
    private static final int LAYOUT = R.layout.fragment_events;


    public static UU_EventFragment getInstance(Context context) {

        Bundle args = new Bundle();
        UU_EventFragment fragment = new UU_EventFragment();
        fragment.setArguments(args);
        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.tab_item_uu_events));

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT, container, false);
        return view;
    }

    public void setContext(Context context) {
        this.context = context;

    }

}