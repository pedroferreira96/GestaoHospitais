package pt.ipg.gestaohospitais;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.provider.FontsContract;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button buttonRegistarDoente;
    private Button buttonDoentesInternados;
    private Button buttonListaHospitais;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.itemSair:
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            default: return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        buttonRegistarDoente = (Button) findViewById(R.id.buttonRegistarDoente);
        buttonRegistarDoente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegistarDoenteActivity();
            }
        });

        buttonDoentesInternados = (Button) findViewById(R.id.buttonDoentesInternados);
        buttonDoentesInternados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDoentesActivity();
            }
        });

        buttonListaHospitais = (Button) findViewById(R.id.buttonListaHospitais);
        buttonListaHospitais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListaHospitaisActivity.class);
                startActivity(intent);
            }
        });

    }

    public void openRegistarDoenteActivity(){
        Intent intent = new Intent(this, RegistarDoenteActivity.class);
        startActivity(intent);
    }

    public void openDoentesActivity(){
        Intent intent = new Intent(this,DoentesActivity.class);
        startActivity(intent);
    }

}
