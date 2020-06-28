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

public class SintomasActivity extends AppCompatActivity {

    private Button buttonAbrirHospitais;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sintomas);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        buttonAbrirHospitais = (Button) findViewById(R.id.buttonAbrirHospitais);
        buttonAbrirHospitais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHospitaisActivity();
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
                Intent intent = new Intent(SintomasActivity.this, LoginActivity.class);
                startActivity(intent);
            default: return super.onOptionsItemSelected(item);
        }
    }

    public void openHospitaisActivity(){
        Intent intent = new Intent(this, HospitaisActivity.class);
        startActivity(intent);
    }
}
