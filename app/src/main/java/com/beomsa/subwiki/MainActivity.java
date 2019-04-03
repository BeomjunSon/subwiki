package com.beomsa.subwiki;

import android.os.Bundle;

import androidx.annotation.NonNull;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.squareup.picasso.Picasso;
import androidx.appcompat.app.AppCompatActivity;
import jp.wasabeef.picasso.transformations.BlurTransformation;

import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_board:
                    mTextMessage.setText(R.string.title_borads);
                    return true;
                case R.id.navigation_options:
                    mTextMessage.setText(R.string.title_settings);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ImageView picassoImageView = (ImageView) findViewById(R.id.mainImage);
        Picasso.with(this)
                .load(R.drawable.bg_subway_1)
                .transform(new BlurTransformation(this, 25))
                .into(picassoImageView);

        // 검색 바
        final SearchView searchBar = (SearchView) findViewById(R.id.mainSearchForm);
        searchBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchBar.setIconified(false);
            }
        });

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
