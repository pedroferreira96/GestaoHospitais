package pt.ipg.gestaohospitais;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.FontsContract;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button buttonRegistarDoente;
    private Button buttonDoentesInternados;
    private Button buttonListaHospitais;
    private Button buttonHospitalDireto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonHospitalDireto = (Button) findViewById(R.id.buttonHospitalDireto);
        buttonHospitalDireto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HospitaisActivity.class);
                startActivity(intent);
            }
        });

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
