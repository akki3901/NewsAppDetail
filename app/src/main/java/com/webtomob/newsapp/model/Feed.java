package com.webtomob.newsapp.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "feed" , strict = false)

public class Feed {

    @Element
    private String title;

    @Element
    private String icon;

    @Element
    private String id;

    @ElementList(inline = true, required = false)
    public List<Entry> entry;

    /*@Element
    private Link link;*/


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Entry> getEntry() {
        return entry;
    }

    public void setEntry(List<Entry> entry) {
        this.entry = entry;
    }

    /*public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }*/
}