package me.jangofetthd.pockemongoguide;

import android.content.res.Resources;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.appodeal.ads.Appodeal;

import java.io.InputStream;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsActivity extends AppCompatActivity {

    @BindView(R.id.webView) WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);

        String appKey = "756de45508b34acce2cdcdb19e27b7ba82d57aefd6a74ee6";
        Appodeal.disableLocationPermissionCheck();
        Appodeal.initialize(this, appKey, Appodeal.BANNER);// | Appodeal.NATIVE);
        Appodeal.setBannerViewId(R.id.appodealBannerView_GameProcess);

    }

    @Override
    public void onResume() {
        super.onResume();
        Appodeal.onResume(this, Appodeal.BANNER);
        Appodeal.show(this, Appodeal.BANNER_BOTTOM);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int value = extras.getInt("page");
            String title = extras.getString("title");
            webView.loadDataWithBaseURL(null, getPageSourceString(value), "text/html", "ru_RU", null);

            getSupportActionBar().setTitle(title);
        }
    }

    private String getPageSourceString(int resId) {
        try {
            Resources res = getResources();
            InputStream in_s = res.openRawResource(resId);

            byte[] b = new byte[in_s.available()];
            in_s.read(b);
            return new String(b);
        } catch (Exception e) {
            return "Ошибка при загрузке инструкции";
        }
    }
}
