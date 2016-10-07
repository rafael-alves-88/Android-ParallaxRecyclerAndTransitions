package rafael.alves.parallaxrecyclerandtransitionsample.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.yayandroid.parallaxrecyclerview.ParallaxRecyclerView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rafael.alves.parallaxrecyclerandtransitionsample.adapter.CitiesListAdapter;
import rafael.alves.parallaxrecyclerandtransitionsample.R;
import rafael.alves.parallaxrecyclerandtransitionsample.model.City;

public class MainActivity extends AppCompatActivity {

    //region [ ButterKnife ]
    @Bind(R.id.recyclerView)
    ParallaxRecyclerView recyclerView;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    //endregion

    //region [ LifeCycle ]
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new CitiesListAdapter(this, City.getCities(), new CitiesListAdapter.OnCityClickListener() {
            @SuppressLint("NewApi")
            @Override
            public void onCityClick(String cityImage) {
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra(DetailsActivity.BUNDLE_IMAGE, cityImage);
                startActivity(intent);
            }
        }));
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
    //endregion

    //region [ Buttons ]
    @OnClick(R.id.fab)
    public void onFabClick(View view) {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }
    //endregion
}
