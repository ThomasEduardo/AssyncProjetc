package br.edu.ifpb.assync.activity;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.os.Bundle;
import android.widget.Button;
import br.edu.ifpb.assync.R;
import br.edu.ifpb.assync.listener.RegistListener;
import butterknife.BindView;
import butterknife.ButterKnife;

public class RegisterActivity extends Activity {
    @BindView(R.id.name)EditText name;
    @BindView(R.id.address)EditText address;
    @BindView(R.id.cpf)EditText cpf;
    @BindView(R.id.email)EditText email;
    @BindView(R.id.register)Button register;
    @BindView(R.id.btReturn)Button btReturn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);

        ButterKnife.bind(this);
        register.setOnClickListener(new RegistListener(this));
    }


        public EditText getName(){
            return name;
        }

        public void setName(EditText name) {
            this.name = name;
        }

        public EditText getAddress() {
            return address;
        }

        public void setAddress(EditText address) {
            this.address = address;
        }

        public EditText getCpf() {
            return cpf;
        }

        public void setCpf(EditText cpf) {
            this.cpf = cpf;
        }

        public EditText getEmail() {
            return email;
        }

        public void setEmail(EditText email) {
            this.email = email;
        }

        public Button getRegister() {
            return register;
        }

        public void setBtRegister(Button register) {
            this.register = register;
        }



    public Button getBtreturn() { return btReturn; }

    public void setBtReturn(Button btReturn) { this.btReturn = btReturn; }


    public void voltar(View v){

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

}