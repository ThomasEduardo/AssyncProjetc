package br.edu.ifpb.assync.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import br.edu.ifpb.assync.R;
import br.edu.ifpb.assync.listener.ScreenList;
import br.edu.ifpb.assync.listener.RegisterScreen;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends Activity{
    @BindView(R.id.listMenu)Button listMenu;
    @BindView(R.id.menuRegister)Button menuRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        listMenu.setOnClickListener(new ScreenList(this));
        menuRegister.setOnClickListener(new RegisterScreen(this));

    }

}
