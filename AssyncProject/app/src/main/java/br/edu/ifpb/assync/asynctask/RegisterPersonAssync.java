package br.edu.ifpb.assync.asynctask;

import android.os.AsyncTask;
import android.util.Log;
import com.google.gson.Gson;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import br.edu.ifpb.assync.entity.Person;

/**
 * Created by Thomas on 05/10/2016.
 */
public class RegisterPersonAssync extends AsyncTask<Person, Void, String>{

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }
    @Override
    protected String doInBackground(Person... pessoas) {

        String answer = "";
        try {

            Gson gson = new Gson();
            String pessoaJson = gson.toJson(pessoas[0]);

            URL url = new URL("http://ladoss.info:8773/Convite_SERVICE/convidado/cadastrar");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("POST");
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.connect();
            DataOutputStream wr = new DataOutputStream(
            urlConnection.getOutputStream());
            wr.writeBytes(pessoaJson);
            wr.close();

            Log.i("ExampleAsyncTaskJson","Resposta: "+urlConnection.getResponseCode());

            if(urlConnection.getResponseCode() == 200){
                answer= "O usuário foi cadastrado com sucesso";
            }else{
                answer = "Problemas técnicos,por favor contate o admnistrador!";
            }
            urlConnection.disconnect();

        } catch (IOException e) {
            Log.e("Erro ", e.getMessage());
        }

        return answer;
    }
    @Override
    protected void onPostExecute(String result){
        super.onPostExecute(result);
    }
}
