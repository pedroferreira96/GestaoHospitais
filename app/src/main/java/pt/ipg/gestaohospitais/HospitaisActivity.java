package pt.ipg.gestaohospitais;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class HospitaisActivity extends AppCompatActivity {

    private Button buttonConfirmarRegisto;
    RadioGroup radioGroup;
    RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospitais);

        radioGroup = findViewById(R.id.radioGroup);

        buttonConfirmarRegisto = (Button) findViewById(R.id.buttonConfirmarRegisto);
        buttonConfirmarRegisto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int radioId = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(radioId);

                Toast.makeText(HospitaisActivity.this, "Registo Guardado", Toast.LENGTH_SHORT).show();
                openMainActivity();
            }
        });

    }

    public void RadioButtonClicked(View view){
        String selectedHospital = "";
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()){
            case R.id.radioButtonGuarda:
                if(checked){
                    selectedHospital = "Hospital Sousa Martins, Guarda";
                    break;
                }
            case R.id.radioButtonLisboa:
                if(checked){
                    selectedHospital = "Hospital de Santa Maria, Lisboa";
                    break;
                }
            case R.id.radioButtonPorto:
                if(checked){
                    selectedHospital = "Hospital de São João, Porto";
                    break;
                }
            case R.id.radioButtonFaro:
                if(checked){
                    selectedHospital = "Hospital de Faro";
                    break;
                }
        }
    }

    public void openMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
