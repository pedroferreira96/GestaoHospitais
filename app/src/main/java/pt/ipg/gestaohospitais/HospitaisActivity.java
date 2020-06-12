package pt.ipg.gestaohospitais;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HospitaisActivity extends AppCompatActivity {

    private Button buttonConfirmarRegisto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospitais);

        buttonConfirmarRegisto = (Button) findViewById(R.id.buttonConfirmarRegisto);
        buttonConfirmarRegisto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HospitaisActivity.this, "Registo Guardado", Toast.LENGTH_SHORT).show();
                openMainActivity();
            }
        });

    }

    public void openMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
