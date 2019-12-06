package com.webtomob.newsapp.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "entry", strict = false)
public class Entry {

    @Element
    private String published;

    @Element
    private String updated;

    @Element
    private String title;

    @Element
    private String content;

    /*@Element
    private String link;*/

    @Element
    private String id;

    @Element
    private Author author;


    public String getPublished() {
        return published;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
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

    /*public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }*/

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
