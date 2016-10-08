package br.edu.ifpb.assync.listener;

import android.content.Intent;
import android.view.View;

import br.edu.ifpb.assync.activity.ListarActivity;
import br.edu.ifpb.assync.activity.MainActivity;

/**
 * Created by Thomas on 06/10/2016.
 */
public class ScreenList implements View.OnClickListener {
    MainActivity mainActivity;

    public ScreenList(MainActivity mainActivity){

        this.mainActivity = mainActivity;
    }
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this.mainActivity,ListarActivity.class);
        this.mainActivity.startActivity(intent);
    }
}
