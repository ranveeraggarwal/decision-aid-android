package com.ranveeraggarwal.decisionaid.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;
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

public class IntroActivity extends AppIntro {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Grab colors from values.colors
        int colorPrimary = ContextCompat.getColor(this, R.color.colorPrimary);
        int colorDivider = ContextCompat.getColor(this, R.color.colorDivider);

        // ToDo: Create introduction slides as necessary.
        // Create introduction slides
        addSlide(AppIntroFragment.newInstance("Hello!",
                "Introduction text for the app.",
                R.drawable.ic_arrow_back_white, colorPrimary));
        addSlide(AppIntroFragment.newInstance("Sections",
                "Swipe left/right to switch between sections.",
                R.drawable.ic_done_white, colorPrimary));
        addSlide(AppIntroFragment.newInstance("Scrolling",
                "Scroll up/down to view more content.",
                R.drawable.ic_navigate_before_white, colorPrimary));
        addSlide(AppIntroFragment.newInstance("Questionnaire",
                "Some more information here.",
                R.drawable.ic_launcher_foreground, colorPrimary));

        // Override bar/separator color.
        setBarColor(colorPrimary);
        setSeparatorColor(colorDivider);

        // Hide Skip/Done button.
        showSkipButton(true);
        setProgressButtonEnabled(true);
    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);

        goToMainActivity();
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);

        goToMainActivity();
    }

    private void goToMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
