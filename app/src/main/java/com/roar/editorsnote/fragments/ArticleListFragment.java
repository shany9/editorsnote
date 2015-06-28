package com.roar.editorsnote.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.roar.editorsnote.R;
import com.roar.editorsnote.adapters.ArticleLinkAdapter;
import com.roar.editorsnote.model.Article;
import com.roar.editorsnote.model.ArticleLink;
import com.roar.editorsnote.parser.EditorialParser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ArticleListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ArticleListFragment extends Fragment {
    private static final String ARG_SOURCE = "source";

    private static final String HINDU = "http://www.thehindu.com/opinion/editorial/";
    private static final String HT = "source";
    private static final String ET = "source";
    private static final String TOI = "source";
    private static final String IE = "source";

    private String mSource;

    public ArrayList<ArticleLink> articleLinks = new ArrayList<ArticleLink>();

    RecyclerView rv;
    LinearLayoutManager llm;
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param source Source of the news article.
     * @return A new instance of fragment ArticleListFragment.
     */

    public static ArticleListFragment newInstance(String source) {
        ArticleListFragment fragment = new ArticleListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_SOURCE, source);
        fragment.setArguments(args);
        return fragment;
    }

    public ArticleListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mSource = getArguments().getString(ARG_SOURCE);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_article_list, container, false);
        rv = (RecyclerView)rootView.findViewById(R.id.recycler_view);
        llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);
        return rootView;
    }

    @Override
    public void onViewCreated(final View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String url="";
        if(mSource.equals(getActivity().getString(R.string.hindu))){
            url = HINDU;
        }

        if(mSource.equals(getActivity().getString(R.string.ht))){
            url = HT;
        }
        if(mSource.equals(getActivity().getString(R.string.et))){
            url = ET;
        }
        if(mSource.equals(getActivity().getString(R.string.toi))){
            url = TOI;
        }
        if(mSource.equals(getActivity().getString(R.string.ie))){
            url = IE;
        }



        Ion.with(getActivity())
                .load(url)
                .asString()
                .setCallback(new FutureCallback<String>() {
                    @Override
                    public void onCompleted(Exception e, String result) {
                        if(mSource.equals(getActivity().getString(R.string.hindu))){
                            articleLinks = EditorialParser.getHinduEditorialLinks(result);
                        }

//                        if(mSource.equals(getActivity().getString(R.string.ht))){
//                            articleLinks = EditorialParser.getHinduEditorialLinks(result);
//                        }
//                        if(mSource.equals(getActivity().getString(R.string.et))){
//                            articleLinks = EditorialParser.getHinduEditorialLinks(result);
//                        }
//                        if(mSource.equals(getActivity().getString(R.string.toi))){
//                            articleLinks = EditorialParser.getHinduEditorialLinks(result);
//                        }
//                        if(mSource.equals(getActivity().getString(R.string.ie))){
//                            articleLinks = EditorialParser.getHinduEditorialLinks(result);
//                        }

                        Log.e("Author" , articleLinks.toString());
                        ArticleLinkAdapter adapter = new ArticleLinkAdapter(getActivity(),articleLinks, mSource);

                        rv.setAdapter(adapter);

                    }
                });



    }

}
