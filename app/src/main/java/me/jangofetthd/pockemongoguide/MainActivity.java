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

import butterknife.BindView;
import butterknife.ButterKnife;

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


    }


    private void initializeCards(){
        mListView.getAdapter().add(getProvider(
                "ГДE CKAЧATЬ POKEMON GO?",
                "Pokemon Go пoкa дocтупнa тoлькo в тpex cтpaнax (нa мoмeнт нaпиcaния cтaтьи). Peчь идeт o CШA, Hoвoй Зeлaндии и Aвcтpaлии. Имeннo в oднoй из этиx тpex cтpaн мoжнo...",
                R.drawable.wpid1608,
                android.R.color.white,
                R.raw.download
                ).endConfig().build());

        mListView.getAdapter().add(getProvider(
                "KAK ИГPATЬ B POKEMON GO?",
                "Что такое Pokemon Go? По сути, это игра, в которой используется дополнительная реальность. Она позволяет...",
                R.drawable.wpid1608,
                android.R.color.white,
                R.raw.download
        ).endConfig().build());

        mListView.getAdapter().add(getProvider(
                "Что такое покебол и как его ловить?",
                "Ловить покемонов помогает специальный индикатор. Он находится в меню, расположенном справа от покебола на главном экране. С его помощью можно узнать...",
                R.drawable.wpid1608,
                android.R.color.white,
                R.raw.download
        ).endConfig().build());
    }


    private CardProvider getProvider(final String title, String shortDescription, int imageResourceId, int titleColorResource, final int pageResource) {
        return new Card.Builder(this)
                .setTag("BIG_IMAGE_BUTTONS_CARD")
                .withProvider(new CardProvider())
                .setTitleResourceColor(titleColorResource)
                .setLayout(R.layout.material_image_with_buttons_card)
                .setTitle(title)
                .setDescription(shortDescription)
                .setDrawable(imageResourceId)
                .addAction(R.id.left_text_button, new TextViewAction(this)
                        .setText("Подробнее")
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
                        .setText("Поделиться")
                        .setTextResourceColor(R.color.accent_material_dark)
                        .setListener(new OnActionClickListener() {
                            @Override
                            public void onActionClicked(View view, Card card) {
                                Intent intent = new Intent(android.content.Intent.ACTION_SEND);
                                intent.setType("text/plain");
                                intent.putExtra(Intent.EXTRA_SUBJECT, "Покемон Го Гайд - лучшие советы по прохождению игры!");
                                intent.putExtra(Intent.EXTRA_TEXT, title+" Ответ на этот вопрос здесь:" + " https://play.google.com/store/apps/details?id=me.jangofetthd.pockemongoguide");
                                startActivity(intent);
                            }
                        }));
    }
}
