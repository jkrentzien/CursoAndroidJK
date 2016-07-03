package pe.edu.cibertec.buscadorpersonas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public static final String DNI = "DNI";
    EditText text;
    ImageView img;
    String dni = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (EditText) findViewById(R.id.dnisearch);
        img = (ImageView) findViewById(R.id.picture);
    }

    public void busqueda(View view) {
        dni = text.getText().toString();
        int idImg = getResources().getIdentifier("dni"+dni,"drawable",getPackageName());
        Log.d("TAG",""+idImg);
        if (idImg != 0){
            img.setImageResource(idImg);
        } else {
            img.setImageResource(R.mipmap.ic_launcher);
        }
    }

    public void verDetalle(View view) {
        if (!dni.equals("")){

            Intent intent = new Intent(getApplicationContext(),PersonaDetail.class);
            intent.putExtra(DNI,dni);
            startActivity(intent);
        }

    }


}
