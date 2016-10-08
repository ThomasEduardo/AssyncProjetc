package br.edu.ifpb.assync.activity;

import android.app.Activity;
import android.os.Bundle;
import java.util.List;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import br.edu.ifpb.assync.asynctask.ListPersonAssync;
import br.edu.ifpb.assync.entity.Person;
import java.util.concurrent.ExecutionException;
import br.edu.ifpb.assync.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ListarActivity extends Activity {

    @BindView(R.id.peopleList) ListView peopleList;
    ArrayAdapter<Person> adapter;
    List<Person> people;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);
        ButterKnife.bind(this);
        list();
    }
    public void list(){

        ListPersonAssync listPessoa = new ListPersonAssync();

        try {
            people = listPessoa.execute("http://ladoss.info:8773/Convite_SERVICE/convidado/listar").get();
            adapter= new ArrayAdapter<Person>(this,
                    android.R.layout.simple_list_item_1, people);
            peopleList.setAdapter(adapter);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public ListView getPeopleList() {
        return peopleList;
    }

    public void setPeopleList(ListView peopleList) {
        this.peopleList = peopleList;
    }

    public ArrayAdapter<Person> getAdapter() {
        return adapter;
    }

    public void setAdapter(ArrayAdapter<Person> adapter) {
        this.adapter = adapter;
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }
}
