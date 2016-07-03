package pe.edu.cibertec.buscadorpersonas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

public class PersonaDetail extends AppCompatActivity {

    private EditText ageText,nameText,dniText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persona_detail);

        dniText = (EditText) findViewById(R.id.dni);
        nameText = (EditText) findViewById(R.id.name);
        ageText = (EditText) findViewById(R.id.age);

        String dni = getIntent().getStringExtra(MainActivity.DNI);
        Log.d("TAG-dni",dni);

        int id = getResources().getIdentifier("dni"+dni,"array",getPackageName());
        Log.d("TAG-id",""+id);
        if (id != 0){
            String[] datos = getResources().getStringArray(id);
            Log.d("TAG","name: "+datos[0]+" age: "+datos[1]);

            dniText.setText(dni);
            nameText.setText(datos[0]);
            ageText.setText(datos[1]);
        }
    }
}
