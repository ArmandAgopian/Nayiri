package com.armdev.nayiri;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private WebView mWebView;
    private TextInputEditText mEditText;

    private static Configuration configuration = new Configuration();
    private static Locale locale;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_am:
                    mWebView.loadUrl("http://nayiri.com/search?l=en&dt=HY_HY");
                    return true;
                case R.id.navigation_amen:
                    mWebView.loadUrl("http://nayiri.com/search?l=en&dt=HY_EN");
                    return true;
                case R.id.navigation_enam:
                    mWebView.loadUrl("http://nayiri.com/search?l=en&dt=EN_HY");
                    return true;
                case R.id.navigation_amfr:
                    mWebView.loadUrl("http://nayiri.com/search?l=en&dt=HY_FR");
                    return true;
                case R.id.navigation_fram:
                    mWebView.loadUrl("http://nayiri.com/search?l=en&dt=FR_HY");
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        mToolbar.inflateMenu(R.menu.options);

        mWebView = (WebView) findViewById(R.id.webview);
        mWebView.setWebViewClient(new WebViewClient());
        mWebView.loadUrl("http://nayiri.com/search?l=en&dt=HY_HY");

        mEditText = (TextInputEditText) findViewById(R.id.edit);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options, menu);

        menu.findItem(R.id.default_language).setChecked(true);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.language:
                return true;
            case R.id.default_language:
                if (item.isChecked()) {
                    item.setChecked(false);
                } else {
                    item.setChecked(true);
                }

                configuration.setToDefaults();
                return true;
            case R.id.armenian:
                if (item.isChecked()) {
                    item.setChecked(false);
                } else {
                    item.setChecked(true);
                }

                locale = new Locale("hy");
                configuration.setLocale(locale);
                return true;
            case R.id.english:
                if (item.isChecked()) {
                    item.setChecked(false);
                } else {
                    item.setChecked(true);
                }

                configuration.setLocale(Locale.US);
                return true;
            case R.id.russian:
                if (item.isChecked()) {
                    item.setChecked(false);
                } else {
                    item.setChecked(true);
                }

                locale = new Locale("ru");
                configuration.setLocale(locale);
                return true;
            case R.id.french:
                if (item.isChecked()) {
                    item.setChecked(false);
                } else {
                    item.setChecked(true);
                }

                configuration.setLocale(Locale.FRENCH);
                return true;
            case R.id.german:
                if (item.isChecked()) {
                    item.setChecked(false);
                } else {
                    item.setChecked(true);
                }

                configuration.setLocale(Locale.GERMAN);
                return true;
            case R.id.turkish:
                if (item.isChecked()) {
                    item.setChecked(false);
                } else {
                    item.setChecked(true);
                }

                Locale locale = new Locale("tr");
                configuration.setLocale(locale);
                return true;
            case R.id.about:

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && mWebView.canGoBack()) {
            mWebView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
