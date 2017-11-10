package fr.android.androidexercises;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class LibraryActivity extends AppCompatActivity implements Step0Fragment.OnNextStep0Listener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
        // TODO replace Step0Fragment in containerFrameLayout
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.containerFrameLayout, new Step0Fragment(), Step0Fragment.class.getSimpleName())
                .commit();
    }

    @Override
    public void onNext(String data) {
        // TODO replace Step1Fragment in containerFrameLayout
        Step1Fragment fragment = new Step1Fragment();
        fragment.setData(data);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.containerFrameLayout, fragment, Step1Fragment.class.getSimpleName())
                .addToBackStack(Step1Fragment.class.getSimpleName())
                .commit();

    }

}
