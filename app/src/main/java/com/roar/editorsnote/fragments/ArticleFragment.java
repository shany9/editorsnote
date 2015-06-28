package com.roar.editorsnote.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.roar.editorsnote.MainActivity;
import com.roar.editorsnote.R;
import com.roar.editorsnote.adapters.ArticleLinkAdapter;
import com.roar.editorsnote.model.Article;
import com.roar.editorsnote.model.ArticleLink;
import com.roar.editorsnote.parser.EditorialParser;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ArticleFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ArticleFragment extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_LINK = "link";
    private String articleLink;
    public ArrayList<ArticleLink> articleLinks = new ArrayList<ArticleLink>();



    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param link Parameter 1.
     * @return A new instance of fragment ArticleFragment.
     */
    public static ArticleFragment newInstance(String link) {
        ArticleFragment fragment = new ArticleFragment();
        Bundle args = new Bundle();
        args.putString(ARG_LINK, link);
        fragment.setArguments(args);
        return fragment;
    }

    public ArticleFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            articleLink = getArguments().getString(ARG_LINK);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_article, container, false);
    }

    @Override
    public void onViewCreated(final View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        Ion.with(getActivity())
                .load(articleLink)
                .asString()
                .setCallback(new FutureCallback<String>() {
                    @Override
                    public void onCompleted(Exception e, String result) {
                         Article article = EditorialParser.getHinduArticle(result);
                        ((MainActivity)getActivity()).getSupportActionBar().setTitle(article.getHeading());
                        ((TextView)view.findViewById(R.id.tv_body)).setText(Html.fromHtml(article.getContent()));

                    }
                });

    }
}
