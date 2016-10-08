package br.edu.ifpb.assync.asynctask;

import android.os.AsyncTask;
import android.util.JsonReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpb.assync.entity.Person;

/**
 * Created by Thomas on 05/10/2016.
 */
public class ListPersonAssync extends AsyncTask<String,Void,List<Person>> {

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected List<Person> doInBackground(String... params) {
        String urlString = params[0];
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection)
                    url.openConnection();

            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type","application/json");
            connection.connect();

            InputStream instream = connection.getInputStream();
            JsonReader reader = new JsonReader(new InputStreamReader(instream, "UTF-8"));
            List<Person> pessoas = getPessoas(reader);
            instream.close();

            return pessoas;
        } catch (ProtocolException e1) {
            e1.printStackTrace();
        } catch (MalformedURLException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return null;

    }

    public List<Person> getPessoas(JsonReader reader) throws IOException {
        List<Person> pessoas = new ArrayList<Person>();
        reader.beginArray();
        while (reader.hasNext()) {
            pessoas.add(getPessoa(reader));
        }
        reader.endArray();
        return pessoas;
    }
    public Person getPessoa(JsonReader reader) throws IOException {

        String nome = null;
        String email = null;
        String endereco = null;
        String cpf = null;

        reader.beginObject();

        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("nome")) {
                nome = reader.nextString();
            } else if (name.equals("email")) {
                email = reader.nextString();
            } else if (name.equals("endereco")) {
                endereco = reader.nextString();
            } else if (name.equals("cpf")) {
                cpf = reader.nextString();
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return new Person(nome, email,endereco, cpf);
    }

    @Override
    protected void onPostExecute(List<Person> result){
        super.onPostExecute(result);
    }

}
