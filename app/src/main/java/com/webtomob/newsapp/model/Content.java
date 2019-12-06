package com.webtomob.newsapp.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "content", strict = false)
public class Content {

    @Element
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
