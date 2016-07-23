package me.jangofetthd.pockemongoguide;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.appodeal.ads.Appodeal;
import com.dexafree.materialList.card.Card;
import com.dexafree.materialList.card.CardProvider;
import com.dexafree.materialList.card.OnActionClickListener;
import com.dexafree.materialList.card.action.TextViewAction;
import com.dexafree.materialList.view.MaterialListView;
import com.localytics.android.Localytics;

import butterknife.BindView;
import butterknife.ButterKnife;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.material_listview1) MaterialListView mListView;
    //MaterialListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        //mListView = (MaterialListView)findViewById(R.id.material_listview1);
        initializeCards();
        mListView.smoothScrollToPosition(0);

    }


    private void initializeCards(){
        mListView.getAdapter().add(getProvider(
                getString(R.string.s1_title),
                getString(R.string.s1_subtitle),
                R.drawable.start1,
                android.R.color.black,
                R.raw.howtoplay
        ).endConfig().build());

        if (Locale.getDefault().getLanguage().equals("ru")) //доступно только для русских пользователей
        mListView.getAdapter().add(getProvider(
                getString(R.string.s15_title),
                getString(R.string.s15_desciption),
                R.drawable.basic_banner,
                android.R.color.black,
                R.raw.basic
        ).endConfig().build());

        mListView.getAdapter().add(getProvider(
                getString(R.string.s2_title),
                getString(R.string.s2_subtitle),
                R.drawable.download1,
                android.R.color.black,
                R.raw.download
                ).endConfig().build());

        mListView.getAdapter().add(getProvider(
                getString(R.string.s3_title),
                getString(R.string.s3_subtitle),
                R.drawable.gum1,
                android.R.color.black,
                R.raw.fastup
        ).endConfig().build());

        mListView.getAdapter().add(getProvider(
                getString(R.string.s4_title),
                getString(R.string.s4_subtitle),
                R.drawable.error1,
                android.R.color.black,
                R.raw.error
        ).endConfig().build());

        mListView.getAdapter().add(getProvider(
                getString(R.string.s5_title),
                getString(R.string.s5_subtitle),
                R.drawable.pokeball1,
                android.R.color.black,
                R.raw.whatapokeball
        ).endConfig().build());

        mListView.getAdapter().add(getProvider(
                getString(R.string.s6_title),
                getString(R.string.s6_subtitle),
                R.drawable.gumgift1,
                android.R.color.black,
                R.raw.whatgiftgum
        ).endConfig().build());

        mListView.getAdapter().add(getProvider(
                getString(R.string.s7_title),
                getString(R.string.s7_subtitle),
                R.drawable.pikachu1,
                android.R.color.black,
                R.raw.howtopikachu
        ).endConfig().build());

        mListView.getAdapter().add(getProvider(
                getString(R.string.s8_title),
                getString(R.string.s8_subtitle),
                R.drawable.map1,
                android.R.color.black,
                R.raw.howtoatackoints
        ).endConfig().build());

        mListView.getAdapter().add(getProvider(
                getString(R.string.s9_title),
                getString(R.string.s9_subtitle),
                R.drawable.lowbattery1,
                android.R.color.black,
                R.raw.fastlowbattery
        ).endConfig().build());

        mListView.getAdapter().add(getProvider(
                getString(R.string.s10_title),
                getString(R.string.s10_subtitle),
                R.drawable.lvl22,
                android.R.color.black,
                R.raw.whatshouldiknow22levelsago
        ).endConfig().build());

        mListView.getAdapter().add(getProvider(
                getString(R.string.s11_title),
                getString(R.string.s11_subtitle),
                R.drawable.eevee1,
                android.R.color.black,
                R.raw.eeveeevolutions
        ).endConfig().build());

        mListView.getAdapter().add(getProvider(
                getString(R.string.s12_title),
                getString(R.string.s12_subtitle),
                R.drawable.enemy1,
                android.R.color.black,
                R.raw.battlewithany
        ).endConfig().build());

        mListView.getAdapter().add(getProvider(
                getString(R.string.s13_title),
                getString(R.string.s13_subtitle),
                R.drawable.pokemonnear1,
                android.R.color.black,
                R.raw.howtofind
        ).endConfig().build());

        mListView.getAdapter().add(getProvider(
                getString(R.string.s14_title),
                getString(R.string.s14_subtitle),
                R.drawable.morexp1,
                android.R.color.black,
                R.raw.earnextraxp
        ).endConfig().build());
    }

    @Override
    protected void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);

        Localytics.onNewIntent(this, intent);
    }

    private CardProvider getProvider(final String title, String shortDescription, int imageResourceId, int titleColorResource, final int pageResource) {
        return new Card.Builder(this)
                .setTag("BIG_IMAGE_BUTTONS_CARD")
                .withProvider(new CardProvider())
                .setTitleResourceColor(titleColorResource)
                .setLayout(R.layout.cardview)
                .setTitle(title)
                .setDescription(shortDescription)
                .setDrawable(imageResourceId)
                .addAction(R.id.left_text_button, new TextViewAction(this)
                        .setText(R.string.button_more)
                        .setTextResourceColor(R.color.black_button)
                        .setListener(new OnActionClickListener() {
                            @Override
                            public void onActionClicked(View view, Card card) {
                                Log.d("more", "CARD");
                                //@TODO pageResource

                                Intent goDetails = new Intent(MainActivity.this, DetailsActivity.class);
                                goDetails.putExtra("page", pageResource);
                                goDetails.putExtra("title", title);
                                startActivity(goDetails);
                                //mListView.getAdapter().add(generateNewCard());
                                //Toast.makeText(mContext, "Added new card", Toast.LENGTH_SHORT).show();
                            }
                        }))
                .addAction(R.id.right_text_button, new TextViewAction(this)
                        .setText(R.string.button_share)
                        .setTextResourceColor(R.color.accent_material_dark)
                        .setListener(new OnActionClickListener() {
                            @Override
                            public void onActionClicked(View view, Card card) {
                                Intent intent = new Intent(android.content.Intent.ACTION_SEND);
                                intent.setType("text/plain");
                                intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.share_title));
                                intent.putExtra(Intent.EXTRA_TEXT, title+getString(R.string.share_body) + " https://play.google.com/store/apps/details?id=me.jangofetthd.pockemongoguide");
                                startActivity(intent);
                            }
                        }));
    }
}
