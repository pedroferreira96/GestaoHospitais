package pt.ipg.gestaohospitais;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListaHospitaisActivity extends AppCompatActivity {

    DatabaseHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_hospitais);

        ListView listViewHospitais = (ListView) findViewById(R.id.listViewHospitais);
        myDB = new DatabaseHelper(this);

        ArrayList<String> listHospitais = new ArrayList<>();
        Cursor data = myDB.getHospitalListContents();

        if(data.getCount() == 0){
            Toast.makeText(ListaHospitaisActivity.this, "Não há nenhum hospital!", Toast.LENGTH_SHORT).show();
        }else {
            while (data.moveToNext()){
                listHospitais.add(data.getString(1));
                ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listHospitais);
                listViewHospitais.setAdapter(listAdapter);
            }
        }
    }
}