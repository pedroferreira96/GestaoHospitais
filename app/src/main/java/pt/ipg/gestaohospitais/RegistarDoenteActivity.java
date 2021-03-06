package pt.ipg.gestaohospitais;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistarDoenteActivity extends AppCompatActivity {

    private static final String TAG = "RegistarDoenteActivity";

    private Button buttonAbrirSintomas;
    DatabaseHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registar_doente);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        buttonAbrirSintomas = (Button) findViewById(R.id.buttonAbrirSintomas);
        buttonAbrirSintomas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSintomasActivity();

            }
        });

        myDB = new DatabaseHelper(this);

    }

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
                Intent intent = new Intent(RegistarDoenteActivity.this, LoginActivity.class);
                startActivity(intent);
            default: return super.onOptionsItemSelected(item);
        }
    }

    public void openSintomasActivity(){

        EditText editTextNomeUtente = (EditText) findViewById(R.id.editTextNomeUtente);
        String nomeUtente = editTextNomeUtente.getText().toString();

        if(nomeUtente.length() < 3){
            editTextNomeUtente.setError("Introduza o nome");
            editTextNomeUtente.requestFocus();
            return;
        }

        EditText editTextNumeroCC = (EditText) findViewById(R.id.editTextNumeroCC);
        String numeroCC = editTextNumeroCC.getText().toString();

        if(numeroCC.length() != 8){
            editTextNumeroCC.setError("Introduza o número do cartão de cidadão");
            editTextNumeroCC.requestFocus();
            return;
        }

        EditText editTextIdade = (EditText) findViewById(R.id.editTextIdade);
        String idade = editTextIdade.getText().toString();

        if(idade.length() == 0 || idade.length() > 3){
            editTextIdade.setError("Introduza a idade");
            editTextIdade.requestFocus();
            return;
        }

        EditText editTextMorada = (EditText) findViewById(R.id.editTextMorada);
        String morada = editTextMorada.getText().toString();

        if(morada.length() < 4){
            editTextMorada.setError("Introduza a morada");
            editTextMorada.requestFocus();
            return;
        }

        EditText editTextTelefone = (EditText) findViewById(R.id.editTextTelefone);
        String telefone = editTextTelefone.getText().toString();

        if(telefone.length() != 9){
            editTextTelefone.setError("Introduza um número de telefone válido");
            editTextTelefone.requestFocus();
            return;
        }

        AddData(nomeUtente,numeroCC,idade,morada,telefone);

        Intent intent = new Intent(this, SintomasActivity.class);
        startActivity(intent);
    }

    public void AddData(String nomeUtente, String numeroCC, String idade, String morada, String telefone){
        boolean insertData = myDB.addData(nomeUtente, numeroCC, idade, morada, telefone);

        if(insertData==true){
            Toast.makeText(RegistarDoenteActivity.this, "Dados guardados", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(RegistarDoenteActivity.this, "Ocorreu um erro", Toast.LENGTH_SHORT).show();
        }
    }
}
