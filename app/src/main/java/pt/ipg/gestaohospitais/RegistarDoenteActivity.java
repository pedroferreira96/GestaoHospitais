package pt.ipg.gestaohospitais;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegistarDoenteActivity extends AppCompatActivity {

    private Button buttonAbrirSintomas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registar_doente);

        buttonAbrirSintomas = (Button) findViewById(R.id.buttonAbrirSintomas);
        buttonAbrirSintomas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSintomasActivity();
            }
        });

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

        Intent intent = new Intent(this, SintomasActivity.class);
        startActivity(intent);
    }
}
