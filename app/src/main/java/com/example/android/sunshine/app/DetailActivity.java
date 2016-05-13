package com.example.android.sunshine.app;

/**
 * Created by kevin on 5/11/2016.
 */

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;

//package com.example.android.sunshine.app;

        import android.os.Bundle;
        import android.support.v4.app.Fragment;
        import android.view.LayoutInflater;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DetailActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_settings){
            startActivity(new Intent(this, SettingsActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.fragment_detail, container, false);

            Intent detailActivity = getActivity().getIntent();
            if(detailActivity != null && detailActivity.hasExtra(Intent.EXTRA_TEXT)) {
                String weatherDetail = detailActivity.getStringExtra(Intent.EXTRA_TEXT);

                TextView detailText = (TextView) rootView.findViewById(R.id.deatil_text_view);
                detailText.setText(weatherDetail);
            }
            return rootView;
        }
    }
}