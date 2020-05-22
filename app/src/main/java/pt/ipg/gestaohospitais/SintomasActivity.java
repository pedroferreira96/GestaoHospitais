package pt.ipg.gestaohospitais;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SintomasActivity extends AppCompatActivity {

    private Button buttonAbrirHospitais;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sintomas);

        buttonAbrirHospitais = (Button) findViewById(R.id.buttonAbrirHospitais);
        buttonAbrirHospitais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHospitaisActivity();
            }
        });
    }

    public void openHospitaisActivity(){
        Intent intent = new Intent(this, HospitaisActivity.class);
        startActivity(intent);
    }
}
