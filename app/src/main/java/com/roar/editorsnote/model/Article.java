package com.roar.editorsnote.model;

/**
 * Created by jai on 21/6/15.
 */
public class Article {
    String id;
    String heading;
    String content;
    String timestamp;
    String source;
    String link;

    public Article(String id, String heading, String content, String timestamp, String source, String link) {
        this.id = id;
        this.heading = heading;
        this.content = content;
        this.timestamp = timestamp;
        this.source = source;
        this.link = link;
    }

    public Article() {
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
        return "Article{" +
                "id='" + id + '\'' +
                ", heading='" + heading + '\'' +
                ", content='" + content + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", source='" + source + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
