package pt.ipg.gestaohospitais;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class DoentesActivity extends AppCompatActivity {

    DatabaseHelper myDB;
    ArrayList<User> userList;
    ListView listView;
    User user;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doentes);

        myDB = new DatabaseHelper(this);
        userList = new ArrayList<>();
        Cursor data = myDB.getListContents();
        int numRows = data.getCount();

        if(numRows == 0){
            Toast.makeText(DoentesActivity.this, "Não há doentes registados!", Toast.LENGTH_LONG).show();
        }else {
            int i = 0;
            while (data.moveToNext()){
                user = new User(data.getString(1), data.getString(2), data.getString(3), data.getString(4), data.getString(5));
                userList.add(i,user);
            }
            AdapterList adapter = new AdapterList(this, R.layout.lista_view, userList);
            listView = (ListView) findViewById(R.id.listView);
            listView.setAdapter(adapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(DoentesActivity.this, EditarDoenteActivity.class);
                    startActivity(intent);
                }
            });
        }
    }
}