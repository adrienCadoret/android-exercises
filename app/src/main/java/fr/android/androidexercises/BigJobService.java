package fr.android.androidexercises;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by cado on 10/11/2017.
 */

public class BigJobService extends IntentService {


    public BigJobService() {
        super(BigJobService.class.getSimpleName());
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        long endTime = System.currentTimeMillis() + 5* 1000;
        try{
            wait(endTime - System.currentTimeMillis());
        } catch (Exception e){

        }

        Toast.makeText(this, "It's finish", Toast.LENGTH_LONG).show();
    }
}
