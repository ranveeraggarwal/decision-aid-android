package com.ranveeraggarwal.decisionaid.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ranveeraggarwal.decisionaid.R;
import com.ranveeraggarwal.decisionaid.models.ContentSlide;
import com.ranveeraggarwal.decisionaid.utilities.AssetLoader;
import com.ranveeraggarwal.decisionaid.utilities.ClipboardUtilities;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;

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

public class ContentSlideActivity extends AppCompatActivity {

    ContentSlide contentSlide;
    TextView content;
    TextView title;
    Button button_1;
    Button button_2;
    Button button_3;
    Button button_4;
    LinearLayout b13;
    LinearLayout b24;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contentslide);

        // Initialize all values
        title = findViewById(R.id.activity_contentslide_title);
        content = findViewById(R.id.activity_contentslide_content);
        button_1 = findViewById(R.id.activity_contentslide_data_1);
        button_2 = findViewById(R.id.activity_contentslide_data_2);
        button_3 = findViewById(R.id.activity_contentslide_data_3);
        button_4 = findViewById(R.id.activity_contentslide_data_4);

        b13 = findViewById(R.id.activity_contentslide_b13);
        b24 = findViewById(R.id.activity_contentslide_b24);

        // Grab the incoming data
        Intent intent = getIntent();
        contentSlide = (ContentSlide) intent.getSerializableExtra("item");

        // Set toolbar
        toolbar = findViewById(R.id.activity_contentslide_toolbar);
        setSupportActionBar(toolbar);
        assert getSupportActionBar() != null;
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(contentSlide.getTag());

        // Throw content as HTML
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            content.setText(Html.fromHtml(contentSlide.getContent(), Html.FROM_HTML_MODE_COMPACT));
        } else {
            Spanned sp = Html.fromHtml(contentSlide.getContent());
            content.setText(sp);
        }

        // Set content title
        title.setText(contentSlide.getTitle());

        boolean button1_set = false;
        boolean button2_set = false;
        boolean button3_set = false;
        boolean button4_set = false;

        // Get data from assets
        // ToDo: Set the correct filename here to get data.
        String fileContent = AssetLoader.readAssets(this, "data.json");
        try {
            JSONObject json = new JSONObject(fileContent);
            Iterator<?> keys = json.keys();

            while (keys.hasNext()) {
                if (button1_set && button2_set && button3_set && button4_set) break;
                String key = (String) keys.next();
                if (json.get(key) instanceof JSONArray) {
                    JSONArray json_array = json.getJSONArray(key);
                    for (int i = 0; i < json_array.length(); i++) {
                        if (button1_set && button2_set && button3_set && button4_set) break;
                        JSONObject row = json_array.getJSONObject(i);
                        final ContentSlide dataItemTemp = new ContentSlide(
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
                        // The first button is set to previous by default
                        if (!button1_set && dataItemTemp.getId() == contentSlide.getLink1()) {
                            button_1.setVisibility(View.VISIBLE);
                            b13.setVisibility(View.VISIBLE);
                            button_1.setText(R.string.button_previous);
                            button_1.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent = new Intent(view.getContext(), ContentSlideActivity.class);
                                    intent.putExtra("item", dataItemTemp);
                                    startActivity(intent);
                                    finish();
                                }
                            });
                            button1_set = true;
                        }
                        // The second button is set to next by default
                        if (!button2_set && dataItemTemp.getId() == contentSlide.getLink2()) {
                            button_2.setVisibility(View.VISIBLE);
                            b13.setVisibility(View.VISIBLE);
                            button_2.setText(R.string.button_next);
                            button_2.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent = new Intent(view.getContext(), ContentSlideActivity.class);
                                    intent.putExtra("item", dataItemTemp);
                                    startActivity(intent);
                                    finish();
                                }
                            });
                            button2_set = true;
                        }
                        // The extra two buttons
                        if (!button3_set && dataItemTemp.getId() == contentSlide.getLink3()) {
                            b24.setVisibility(View.VISIBLE);
                            button_3.setVisibility(View.VISIBLE);
                            button_3.setText(dataItemTemp.getTag());
                            button_3.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent = new Intent(view.getContext(), ContentSlideActivity.class);
                                    intent.putExtra("item", dataItemTemp);
                                    startActivity(intent);
                                    finish();
                                }
                            });
                            button3_set = true;
                        }
                        if (!button4_set && dataItemTemp.getId() == contentSlide.getLink4()) {
                            b24.setVisibility(View.VISIBLE);
                            button_4.setVisibility(View.VISIBLE);
                            button_4.setText(dataItemTemp.getTag());
                            button_4.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent = new Intent(view.getContext(), ContentSlideActivity.class);
                                    intent.putExtra("item", dataItemTemp);
                                    startActivity(intent);
                                    finish();
                                }
                            });
                            button4_set = true;
                        }
                    }
                }
            }

        } catch (JSONException e) {
            Log.e("Fragment", "JSONException", e);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main_activity, menu);

        MenuItem actionItem = menu.findItem(R.id.activity_main_action_copy);
        actionItem.setVisible(true);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        } else if (menuItem.getItemId() == R.id.activity_main_action_copy) {
            ClipboardUtilities.setClipboard(this, contentSlide.getContent().replace("<br>", "\n"));
            Toast.makeText(this, "Content Copied!", Toast.LENGTH_SHORT)
                    .show();
            return true;
        }

        return super.onOptionsItemSelected(menuItem);
    }

}

