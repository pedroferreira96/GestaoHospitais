package pt.ipg.gestaohospitais;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
        Intent intent = new Intent(this, SintomasActivity.class);
        startActivity(intent);
    }
}
