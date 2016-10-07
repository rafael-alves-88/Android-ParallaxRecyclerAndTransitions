package rafael.alves.parallaxrecyclerandtransitionsample.view;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.TransitionInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;
import rafael.alves.parallaxrecyclerandtransitionsample.R;
import rafael.alves.parallaxrecyclerandtransitionsample.utils.Utils;

public class DetailsActivity extends AppCompatActivity {

    //region [ Public Members ]
    public static String BUNDLE_IMAGE = "BundleImage";
    //endregion

    //region [ ButterKnife ]
    @Bind(R.id.ivSprite) ImageView ivSprite;
    @Bind(R.id.rlViewTop) RelativeLayout rlViewTop;
    @Bind(R.id.rlViewBottom) RelativeLayout rlViewBottom;
    @Bind(R.id.rlButtonsTop) RelativeLayout rlButtonsTop;
    @Bind(R.id.rlButtonsBottom) RelativeLayout rlButtonsBottom;
    //endregion

    //region [ LifeCycle ]
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        ButterKnife.bind(this);

        setupWindowAnimations();

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String image = bundle.getString(BUNDLE_IMAGE);
            Picasso.with(DetailsActivity.this).load(image).into(ivSprite);

            startAnimations();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }
    //endregion

    //region [ Private Methods ]
    /**
     * Setup Transitions
     */
    @SuppressLint("NewApi")
    private void setupWindowAnimations() {
        if (Utils.checkSDKLollipop()) {
            Fade fade = (Fade) TransitionInflater.from(this).inflateTransition(R.transition.fade);
            //fade.setInterpolator(new ReverseInterpolator());
            getWindow().setEnterTransition(fade);

            //Explode explode = (Explode) TransitionInflater.from(this).inflateTransition(R.transition.explode);
            //getWindow().setEnterTransition(explode);
        }
    }

    /**
     * Start Animations
     */
    private void startAnimations() {
        Animation slideTop = AnimationUtils.loadAnimation(this, R.anim.slide_up);
        slideTop.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                rlButtonsTop.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        Animation slideBottom = AnimationUtils.loadAnimation(this, R.anim.slide_down);
        slideBottom.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                rlButtonsBottom.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        rlViewTop.startAnimation(slideTop);
        rlViewBottom.startAnimation(slideBottom);
    }
    //endregion
}
