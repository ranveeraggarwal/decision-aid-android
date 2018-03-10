package com.ranveeraggarwal.decisionaid.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ranveeraggarwal.decisionaid.R;
import com.ranveeraggarwal.decisionaid.adapters.ContentSlideListItemAdapter;
import com.ranveeraggarwal.decisionaid.models.ContentSlide;
import com.ranveeraggarwal.decisionaid.utilities.AssetLoader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
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

public class ContentSlideListFragment extends Fragment {

    String header;

    public ContentSlideListFragment() {
        // Required empty public constructor
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public List<ContentSlide> fetchData() {
        List<ContentSlide> dataItemData = new ArrayList<>();
        // ToDo: Put in the filename that contains the data here.
        String fileContent = AssetLoader.readAssets(getContext(), "data.json");
        try {
            JSONObject json = new JSONObject(fileContent);
            JSONArray json_array = json.getJSONArray(header);
            for (int i = 0; i < json_array.length(); i++) {
                JSONObject row = json_array.getJSONObject(i);
                ContentSlide dataItem = new ContentSlide(
                        row.getInt("id"),
                        row.getString("tag"),
                        row.getString("title"),
                        row.getString("content"),
                        row.getInt("image"),
                        row.getInt("link1"),
                        row.getInt("link2"),
                        row.getInt("link3"),
                        row.getInt("link4")
                );
                dataItemData.add(dataItem);
            }
        } catch (JSONException e) {
            Log.e("Fragment", "JSONException", e);
        }
        return dataItemData;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_contentslide, container, false);

        RecyclerView dataOptionsList = root.findViewById(R.id.contentslide_fragment_list);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        dataOptionsList.setLayoutManager(layoutManager);

        ContentSlideListItemAdapter contentSlideListItemAdapter = new ContentSlideListItemAdapter(getActivity(), fetchData());
        dataOptionsList.setAdapter(contentSlideListItemAdapter);

        return root;
    }

}
