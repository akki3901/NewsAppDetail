package com.webtomob.newsapp.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "link", strict = false)
public class Link {

    @Element(name = "href")
    private String href;

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
}
