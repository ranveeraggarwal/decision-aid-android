package com.ranveeraggarwal.decisionaid.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ranveeraggarwal.decisionaid.R;
import com.ranveeraggarwal.decisionaid.activities.ContentSlideActivity;
import com.ranveeraggarwal.decisionaid.models.ContentSlide;
import com.ranveeraggarwal.decisionaid.views.ContentSlideViewHolder;

import java.util.Collections;
import java.util.List;

/**
 * A decision aid framework.
 * Copyright (C) 2018 Ranveer Aggarwal
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

public class ContentSlideListItemAdapter extends RecyclerView.Adapter<ContentSlideViewHolder> {

    private LayoutInflater introductionItemInflater;
    private List<ContentSlide> dataItemData = Collections.emptyList();
    private Context context;

    public ContentSlideListItemAdapter(Context context, List<ContentSlide> dataItemData) {
        introductionItemInflater = LayoutInflater.from(context);
        this.dataItemData = dataItemData;
        this.context = context;
    }

    @Override
    public ContentSlideViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = introductionItemInflater.inflate(R.layout.fragment_contentslide_list_item, parent, false);
        return new ContentSlideViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ContentSlideViewHolder holder, int position) {
        final ContentSlide dataItem = dataItemData.get(position);
        holder.title.setText(dataItem.getTag());
        holder.subtitle.setText(dataItem.getTitle());
        holder.root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ContentSlideActivity.class);
                intent.putExtra("item", dataItem);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataItemData.size();
    }
}
