package ru.britishdesign.rm.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.britishdesign.rm.R;

public class RemindersFragment extends AbstractTabFragment {
    private static final int LAYOUT = R.layout.fragment_events;


    public static RemindersFragment getInstance(Context context) {

        Bundle args = new Bundle();
        RemindersFragment fragment = new RemindersFragment();
        fragment.setArguments(args);
        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.tab_item_reminders));

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