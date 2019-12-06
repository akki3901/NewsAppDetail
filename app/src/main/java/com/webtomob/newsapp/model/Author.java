package com.webtomob.newsapp.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "author", strict = false)
public class Author {

    @Element
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
