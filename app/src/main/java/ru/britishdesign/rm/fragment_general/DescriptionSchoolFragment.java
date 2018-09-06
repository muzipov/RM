package ru.britishdesign.rm.fragment_general;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.britishdesign.rm.R;

public class DescriptionSchoolFragment extends Fragment {
    private final static int LAYOUT = R.layout.fragment_description_school;
    private Toolbar toolbar;
    private ViewPager viewPager;

    protected View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanseState){
        view = inflater.inflate(LAYOUT, container, false);
        return view;
    }
}
