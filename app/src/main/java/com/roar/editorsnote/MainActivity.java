package com.roar.editorsnote;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.roar.editorsnote.adapters.NavDrawerListAdapter;
import com.roar.editorsnote.fragments.ArticleListFragment;
import com.roar.editorsnote.model.NavDrawerItem;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Author";
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ArrayList<NavDrawerItem> navDrawerItems;
    private NavDrawerListAdapter adapter;
    private ActionBarDrawerToggle mDrawerToggle;
    private Toolbar mToolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final String[] menuitems = {
                getString(R.string.hindu),
                getString(R.string.ht),
                getString(R.string.et),
                getString(R.string.toi),
                getString(R.string.ie)};
        initDrawer(menuitems);
        if (savedInstanceState == null) {
            // on first time display view for first nav item
            displayView(0, menuitems);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void initDrawer(final String[] menuitems) {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle(getResources().getString(R.string.app_name));
        //getSupportActionBar().setLogo(R.drawable.schwabe_logo_left_menu);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, mToolbar,
                R.string.app_name,
                R.string.app_name
        );
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        mDrawerToggle.syncState();
        mDrawerLayout.setScrimColor(getResources().getColor(android.R.color.transparent));

        // Drawer
        mDrawerList = (ListView) findViewById(R.id.list_slidermenu);

        navDrawerItems = new ArrayList<NavDrawerItem>();


        for (String s : menuitems) {
            navDrawerItems.add(
                    new NavDrawerItem(
                            s,
                            R.drawable.abc_ic_clear_mtrl_alpha,
                            R.drawable.abc_ic_clear_mtrl_alpha,
                            false,
                            false
                    ));
        }

        // setting the nav drawer list adapter
        adapter = new NavDrawerListAdapter(getApplicationContext(), navDrawerItems);
        mDrawerList.setAdapter(adapter);
        mDrawerList.setOnItemClickListener(new ListView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                displayView(position, menuitems);
            }
        });
    }

    private void displayView(int position, String[] menuitems) {
        // update the main content by replacing fragments
        Fragment fragment = ArticleListFragment.newInstance(menuitems[position]);

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.
                    beginTransaction().
                    addToBackStack(this.getClass().getName())
                    .replace(R.id.frame_container, fragment).commit();

            //update selected item and title, then close the drawer
            mDrawerList.setItemChecked(position, true);
            //mDrawerList.setSelection(position);
            mDrawerLayout.closeDrawer(mDrawerList);
        } else {
            // error in creating fragment
            Log.e("MainActivity", "Error in creating fragment");
        }
    }

}
