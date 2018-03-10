package com.ranveeraggarwal.decisionaid.models;

import java.io.Serializable;

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

public class ContentSlide implements Serializable{
    private int id;
    private String tag;
    private String title;
    private String content;
    private int image;
    private int link1;
    private int link2;
    private int link3;
    private int link4;

    public ContentSlide(int id, String tag, String title, String content, int image) {
        this.setId(id);
        this.setTag(tag);
        this.setTitle(title);
        this.setContent(content);
        this.setImage(image);
    }

    public ContentSlide(int id, String tag, String title, String content, int image,
                    int link1, int link2, int link3, int link4) {
        this.setId(id);
        this.setTag(tag);
        this.setTitle(title);
        this.setContent(content);
        this.setImage(image);
        this.setLink1(link1);
        this.setLink2(link2);
        this.setLink3(link3);
        this.setLink4(link4);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLink1() {
        return link1;
    }

    public void setLink1(int link1) {
        this.link1 = link1;
    }

    public int getLink3() {
        return link3;
    }

    public void setLink3(int link3) {
        this.link3 = link3;
    }

    public int getLink4() {
        return link4;
    }

    public void setLink4(int link4) {
        this.link4 = link4;
    }

    public int getLink2() {
        return link2;
    }

    public void setLink2(int link2) {
        this.link2 = link2;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
