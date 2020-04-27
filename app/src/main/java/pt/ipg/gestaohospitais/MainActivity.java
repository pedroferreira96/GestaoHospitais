package pt.ipg.gestaohospitais;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.FontsContract;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button buttonRegistarDoente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonRegistarDoente = (Button) findViewById(R.id.buttonRegistarDoente);
        buttonRegistarDoente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegistarDoenteActivity();
            }
        });

    }

    public void openRegistarDoenteActivity(){
        Intent intent = new Intent(this, RegistarDoenteActivity.class);
        startActivity(intent);
    }

}
