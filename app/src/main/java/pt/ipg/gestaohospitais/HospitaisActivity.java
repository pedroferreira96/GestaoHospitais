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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class HospitaisActivity extends AppCompatActivity {

    DatabaseHelper myDB;

    private Button buttonConfirmarRegisto;
    RadioGroup radioGroup;
    RadioButton radioButtonGuarda, radioButtonLisboa, radioButtonPorto, radioButtonFaro;
    String selectedType = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospitais);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        myDB = new DatabaseHelper(this);

        radioGroup = findViewById(R.id.radioGroup);
        radioButtonGuarda = findViewById(R.id.radioButtonGuarda);
        radioButtonLisboa = findViewById(R.id.radioButtonLisboa);
        radioButtonPorto = findViewById(R.id.radioButtonPorto);
        radioButtonFaro = findViewById(R.id.radioButtonFaro);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.radioButtonGuarda){
                    selectedType = radioButtonGuarda.getText().toString();
                }else if(checkedId==R.id.radioButtonLisboa){
                    selectedType = radioButtonLisboa.getText().toString();
                }else if(checkedId==R.id.radioButtonPorto){
                    selectedType = radioButtonPorto.getText().toString();
                }else{
                    selectedType = radioButtonFaro.getText().toString();
                }
            }
        });



        buttonConfirmarRegisto = (Button) findViewById(R.id.buttonConfirmarRegisto);
        buttonConfirmarRegisto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //String newEntry = selectedType;
                addHospital(selectedType);

                //int radioId = radioGroup.getCheckedRadioButtonId();
                //radioButton = findViewById(radioId);

                //Toast.makeText(HospitaisActivity.this, "Registo Guardado", Toast.LENGTH_SHORT).show();
                openMainActivity();
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
                Intent intent = new Intent(HospitaisActivity.this, LoginActivity.class);
                startActivity(intent);
            default: return super.onOptionsItemSelected(item);
        }
    }

    public void addHospital(String selectedType){
        boolean insertData = myDB.addHospital(selectedType);

        if(insertData==true){
            Toast.makeText(this, "Hospital registado!", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Ocorreu um erro no registo do hospital na bd.", Toast.LENGTH_LONG).show();
        }
    }

    public void openMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
