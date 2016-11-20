package id.barkoststudio.tripgarut;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toolbar;

import id.barkoststudio.tripgarut.adapter.TempatWisataAdapter;

import static id.barkoststudio.tripgarut.R.id.toolbar;

public class TempatWisataActivity extends Activity {

    private RecyclerView mRecyclerView;
    private StaggeredGridLayoutManager mStaggeredLayoutManager;
    private TempatWisataAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tempat_wisata);

        mStaggeredLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);

        mRecyclerView = (RecyclerView) findViewById(R.id.list);
        mRecyclerView.setLayoutManager(mStaggeredLayoutManager);

        mRecyclerView.setHasFixedSize(true); //Data size is fixed - improves performance
        mAdapter = new TempatWisataAdapter(this);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(onItemClickListener);
    }

    TempatWisataAdapter.OnItemClickListener onItemClickListener = new TempatWisataAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(View v, int position) {
            Intent transitionIntent = new Intent(TempatWisataActivity.this, DetailActivity.class);
            transitionIntent.putExtra(DetailActivity.EXTRA_PARAM_ID, position);
            ImageView placeImage = (ImageView) v.findViewById(R.id.placeImage);
            LinearLayout placeNameHolder = (LinearLayout) v.findViewById(R.id.placeNameHolder);

            View navigationBar = findViewById(android.R.id.navigationBarBackground);
            View statusBar = findViewById(android.R.id.statusBarBackground);

            Pair<View, String> imagePair = Pair.create((View) placeImage, "tImage");
            Pair<View, String> holderPair = Pair.create((View) placeNameHolder, "tNameHolder");
            Pair<View, String> statusPair = Pair.create(statusBar, Window.STATUS_BAR_BACKGROUND_TRANSITION_NAME);

            ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(TempatWisataActivity.this, imagePair, holderPair, statusPair);
            ActivityCompat.startActivity(TempatWisataActivity.this, transitionIntent, options.toBundle());
        }
    };
}
