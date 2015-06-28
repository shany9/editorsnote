package com.roar.editorsnote.model;

/**
 * Created by jai on 21/6/15.
 */
public class ArticleLink {

    String id;
    String heading;
    String content;
    String timestamp;
    String source;
    String link;

    public ArticleLink(String id, String heading, String timestamp, String source, String link) {
        this.id = id;
        this.heading = heading;
        this.timestamp = timestamp;
        this.source = source;
        this.link = link;
    }

    public ArticleLink() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "Article Link{" +
                "id='" + id + '\'' +
                ", heading='" + heading + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", source='" + source + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
