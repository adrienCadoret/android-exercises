package fr.android.androidexercises;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.sql.Time;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

public class LibraryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        // Plant logger cf. Android Timber
        Timber.plant(new Timber.DebugTree());

        // TODO build Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://henri-potier.xebia.fr/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // TODO create a service
        HenriPotierService henriPotierService = retrofit.create(HenriPotierService.class);

        // TODO listBooks()
        henriPotierService.getBooks().enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                Timber.d(response.body().toString());
                ListView listView = findViewById(R.id.bookListView);
                final ArrayAdapter<Book> adapter = new ArrayAdapter<Book>(LibraryActivity.this,
                        android.R.layout.activity_list_item, response.body());
                listView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {
                Timber.d("Fail");
            }
        });

        // TODO enqueue call and display book title

        // TODO log books

        // TODO display book as a list
    }

}
