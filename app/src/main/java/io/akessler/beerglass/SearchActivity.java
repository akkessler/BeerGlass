package io.akessler.beerglass;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import io.akessler.beerglass.adapter.BeerArrayAdapter;
import io.akessler.beerglass.model.Beer;

public class SearchActivity extends AppCompatActivity {

    EditText searchText;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_beer:
                    searchText.setHint(R.string.hint_beer);
                    return true;
                case R.id.navigation_style:
                    searchText.setHint(R.string.hint_style);
                    return true;
                case R.id.navigation_glass:
                    searchText.setHint(R.string.hint_glass);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        HideTitleUtility.hide(this);
        setContentView(R.layout.activity_search);

        initListView();

        searchText = findViewById(R.id.searchText);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    void initListView() {
        final ListView listView = findViewById(R.id.listView);
        final List<Beer> beers = new ArrayList<>();
        for(int i=0; i<20; i++) {
            // FIXME Load beer list from database
            Beer b = new Beer(i);
            beers.add(b);
        }

        // maybe make ArrayAdapter for interface,
        // so custom define layout logic is contained within model implementing interface impl
        final BeerArrayAdapter adapter = new BeerArrayAdapter(this, beers);
        listView.setAdapter(adapter);

        // TODO Extract
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    int position, long id) {
                final Beer item = (Beer) parent.getItemAtPosition(position);
                view.animate().setDuration(2000).alpha(0)
                        .withEndAction(new Runnable() {
                            @Override
                            public void run() {
                                beers.remove(item);
                                adapter.notifyDataSetChanged();
                                view.setAlpha(1);
                            }
                        });
            }

        });
    }

}
