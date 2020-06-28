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

public class EditarDoenteActivity extends AppCompatActivity {

    private String selectedNome, selectedNumeroCC, selectedIdade, selectedMorada, selectedTelefone;
    private Button buttonGravar, buttonApagar;
    private EditText editable_nome, editable_numeroCC, editable_idade, editable_morada, editable_telefone;
    DatabaseHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_doente);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        buttonGravar = (Button) findViewById(R.id.buttonGravar);
        buttonApagar = (Button) findViewById(R.id.buttonApagar);
        editable_nome = (EditText) findViewById(R.id.editable_nome);
        editable_numeroCC = (EditText) findViewById(R.id.editable_numeroCC);
        editable_idade = (EditText) findViewById(R.id.editable_idade);
        editable_morada = (EditText) findViewById(R.id.editable_morada);
        editable_telefone = (EditText) findViewById(R.id.editable_telefone);

        Intent receivedIntent = getIntent();

        selectedNome = receivedIntent.getStringExtra("nomeUtente");
        selectedNumeroCC = receivedIntent.getStringExtra("numeroCC");
        selectedIdade = receivedIntent.getStringExtra("idade");
        selectedMorada = receivedIntent.getStringExtra("morada");
        selectedTelefone = receivedIntent.getStringExtra("telefone");

        buttonApagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDB.deleteData(selectedNome,selectedNumeroCC,selectedIdade,selectedMorada,selectedTelefone);
                editable_nome.setText("");
                editable_numeroCC.setText("");
                editable_idade.setText("");
                editable_morada.setText("");
                editable_telefone.setText("");
                Toast.makeText(EditarDoenteActivity.this, "Registo Apagado!",Toast.LENGTH_SHORT).show();
            }
        });

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
                Intent intent = new Intent(EditarDoenteActivity.this, LoginActivity.class);
                startActivity(intent);
            default: return super.onOptionsItemSelected(item);
        }
    }
}