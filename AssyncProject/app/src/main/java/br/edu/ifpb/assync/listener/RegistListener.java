package br.edu.ifpb.assync.listener;

import android.view.View;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

import br.edu.ifpb.assync.activity.RegisterActivity;
import br.edu.ifpb.assync.asynctask.RegisterPersonAssync;
import br.edu.ifpb.assync.entity.Person;

/**
 * Created by Thomas on 06/10/2016.
 */
public class RegistListener implements View.OnClickListener {

    RegisterActivity registerActivity;

    public RegistListener(RegisterActivity registerActivity){

        this.registerActivity = registerActivity;
    }
    @Override
    public void onClick(View v) {
        Person pp = new Person();

        pp.setName(registerActivity.getName().getText().toString());
        pp.setAddress(registerActivity.getAddress().getText().toString());
        pp.setEmail(registerActivity.getEmail().getText().toString());
        pp.setCpf(registerActivity.getCpf().getText().toString());
        RegisterPersonAssync assync = new RegisterPersonAssync();

        try {
            String message = assync.execute(pp).get();
            Toast toast = Toast.makeText(this.registerActivity,message,Toast.LENGTH_SHORT);
            toast.show();
            registerActivity.getName().setText("");
            registerActivity.getAddress().setText("");
            registerActivity.getEmail().setText("");
            registerActivity.getCpf().setText("");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }
}
