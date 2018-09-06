package ru.britishdesign.rm.fragment;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;

import java.util.Date;

public class AbstractTabFragment extends Fragment {
    private String title;
    private Date remindDate;
    protected Context context;
    protected View view;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getRemindDate() {
        return remindDate;
    }

    public void setRemindDate(Date remindDate) {
        this.remindDate = remindDate;
    }
}
