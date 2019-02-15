package be.ehb.mopapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;

import be.ehb.mopapp.model.MopDao;
import be.ehb.mopapp.recyclerutilities.MopAdapter;
import be.ehb.mopapp.recyclerutilities.RecyclerTouchListener;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvMopjes;
    private MopAdapter adapter;
    private SearchView.OnQueryTextListener searchListener = new SearchView.OnQueryTextListener() {
        //op enter gedrukt
        @Override
        public boolean onQueryTextSubmit(String query) {
            adapter.getFilter().filter(query);
            return false;
        }
//als een karakter is getypt || verwijderd
        @Override
        public boolean onQueryTextChange(String newText) {
            adapter.getFilter().filter(newText);
            return false;
        }
    };

//menu opbouwen
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.hoofd_menu,menu);
        //searchview halen van mijn menu
        SearchView searchView = (SearchView) menu.findItem(R.id.mi_search).getActionView();
        searchView.setOnQueryTextListener(searchListener);

        return super.onCreateOptionsMenu(menu);
    }

    //iets aangeraakt in het menu

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//welk item?
        if (item.getItemId() == R.id.mi_add) {
//start navigatie
        Intent intent = new Intent(this,DetailActivity.class);
        startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //verwijzing naar recycler
        rvMopjes = findViewById(R.id.rv_mopjes);
        //adpter, hoe recycler opvullen
        adapter = new MopAdapter(MopDao.getInstance().getMopLijst());
        rvMopjes.setAdapter(adapter);
        //hoe elementen weergeven (horizontale lijst?, verticale lijst?)
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        //voor de geinteresseerden, kan ook in andere richtlingen
        //((LinearLayout
        rvMopjes.setLayoutManager(layoutManager);
        //listener toevoegen aan recyclerview
        rvMopjes.addOnItemTouchListener(new RecyclerTouchListener(this, new RecyclerTouchListener.ClickListener() {
            @Override
            public void OnClick(View view, int position) {
                Log.i("TEST", MopDao.getInstance().getMopLijst().get(position).getMop());
                //vuil bij elkaar gehacht, verwijzing naar viewholder meegeven aan rij
                MopAdapter.MopViewHolder verviewijzing = (MopAdapter.MopViewHolder) view.getTag();
                verviewijzing.tvClou.setVisibility(View.VISIBLE);
            }
        }));
    }


    }

