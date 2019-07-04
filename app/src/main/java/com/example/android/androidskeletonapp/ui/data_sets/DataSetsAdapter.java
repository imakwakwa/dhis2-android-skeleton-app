package com.example.android.androidskeletonapp.ui.data_sets;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;

import com.example.android.androidskeletonapp.R;
import com.example.android.androidskeletonapp.data.service.DateFormatHelper;
import com.example.android.androidskeletonapp.data.service.StyleBinderHelper;
import com.example.android.androidskeletonapp.ui.base.DiffByIdItemCallback;
import com.example.android.androidskeletonapp.ui.base.ListItemHolder;
import com.example.android.androidskeletonapp.ui.base.ListItemWithStyleHolder;
import com.example.android.androidskeletonapp.ui.base.ListItemWithSyncHolder;

import org.hisp.dhis.android.core.common.ObjectStyle;
import org.hisp.dhis.android.core.dataset.DataSet;
import org.hisp.dhis.android.core.maintenance.D2Error;

import static com.example.android.androidskeletonapp.data.service.StyleBinderHelper.setBackgroundColor;

public class DataSetsAdapter extends PagedListAdapter<DataSet, ListItemWithStyleHolder> {

    protected DataSetsAdapter(){

        super(new DiffByIdItemCallback<>());
    }

    @NonNull
    @Override
    public  ListItemWithStyleHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_with_style, parent, false);
        return new ListItemWithStyleHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ListItemWithStyleHolder holder, int position) {
        DataSet dataSet = getItem(position);
        holder.title.setText(dataSet.displayName().toString());
        holder.subtitle1.setText(dataSet.periodType().toString());
        holder.icon.setImageResource(R.drawable.ic_view_list_black_24dp);
        StyleBinderHelper.bindStyle(holder, dataSet.style());
    }
}
