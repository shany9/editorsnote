package com.roar.editorsnote.parser;

import android.util.Log;

import com.roar.editorsnote.model.Article;
import com.roar.editorsnote.model.ArticleLink;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

/**
 * Created by jai on 21/6/15.
 */
public class EditorialParser {

    public static ArrayList<ArticleLink> getHinduEditorialLinks(String html){
        ArrayList<ArticleLink> list = new ArrayList<ArticleLink>();

        Document doc = Jsoup.parse(html);
        Elements elements = new Elements();


        elements.addAll(doc.select(".section-top h1 > a"));
        elements.addAll(doc.select(".sub-headlines h2 > a"));
        elements.addAll(doc.select(".sub-headlines h3 > a"));
        elements.addAll(doc.select(".section-columns h3 > a"));


        for(Element element : elements){
            ArticleLink link = new ArticleLink();
            link.setId("0");
            //Log.e("Author", "Data " + element.attr("href"));
            link.setLink(element.attr("href"));

            Log.e("Author", "Data " + element.text());
            link.setHeading(element.text());

            link.setSource("The Hindu");

            String s = element.attr("alt");
            String ts = s.substring(s.indexOf(":") + 1, s.indexOf("Published:")).trim();
            //String ts = " lalala";
            Log.e("Author", "Data " + ts);
            link.setTimestamp(ts);

            list.add(link);
        }
        return list;
    }

    public static Article getHinduArticle(String html){
        Article article = new Article();
        Document doc = Jsoup.parse(html);
        article.setHeading(doc.select(".detail-title").get(0).text().toString());
        Elements articleParas = doc.select(".body");
        String content = "";
        for(Element e : articleParas){
            content +=  e.text() + "<br/> <br/> <br/>";
        }
        article.setContent(content);
        Log.e("Article: ", article.toString());
        return article;
    }

}
