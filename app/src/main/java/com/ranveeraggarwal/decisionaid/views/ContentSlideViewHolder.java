package com.ranveeraggarwal.decisionaid.views;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.ranveeraggarwal.decisionaid.R;

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

public class ContentSlideViewHolder extends RecyclerView.ViewHolder {

    public TextView title;
    public TextView subtitle;

    public View root;

    public ContentSlideViewHolder(View itemView) {
        super(itemView);

        title = itemView.findViewById(R.id.contentslide_list_item_title);
        subtitle = itemView.findViewById(R.id.contentslide_list_item_subtitle);

        root = itemView;
    }
}

