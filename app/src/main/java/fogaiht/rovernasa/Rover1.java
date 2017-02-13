package fogaiht.rovernasa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class Rover1 extends AppCompatActivity {

//    @Override
//        public void onBackPressed()
//        {
//            startActivity(new Intent(getBaseContext(), activity.class));
//        }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rover1);

//        Button iniciar = (Button) findViewById(R.id.button3);
//        iniciar.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                startActivity(new Intent(getBaseContext(), Rover2.class));
//            }
//        });

        final Intent intent1 = new Intent(Rover1.this, Rover2.class);

        Intent intent = getIntent();

        final Bundle bundle = intent.getExtras();

        final String grid_x = bundle.getString("txt1");
        final String grid_y = bundle.getString("txt2");

        final EditText X = (EditText) findViewById(R.id.editTextX);
        final EditText Y = (EditText) findViewById(R.id.editTextY);
        final EditText D = (EditText) findViewById(R.id.editTextD);
        final EditText C = (EditText) findViewById(R.id.editText2);

        Button iniciar = (Button) findViewById(R.id.button3);
        iniciar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Rover a = new Rover();

                int pos_x = Integer.parseInt(X.getText().toString());
                int pos_y = Integer.parseInt(Y.getText().toString());
                int griid_x = Integer.parseInt(grid_x);
                int griid_y = Integer.parseInt(grid_y);

                int command;

                String direction = D.getText().toString();
                String comm = C.getText().toString();

                a.inputGrid(griid_x, griid_y);
                a.insert_status(pos_x, pos_y, direction);
                command = a.action_move(comm);

                TextView teste = (TextView) findViewById(R.id.testetxt);
                teste.setText(a.print_status());

                String txt1 = "";
                String txt2 = "";
                String txtF1 = "";

                txt1 = grid_x;
                txt2 = grid_y;
                txtF1 = teste.getText().toString();

                Bundle bundle1 = new Bundle();
                Bundle bundle2 = new Bundle();
                Bundle bundleF = new Bundle();

                bundle1.putString("txt1", txt1);
                bundle2.putString("txt2", txt2);
                bundleF.putString("txtF1", txtF1);

                intent1.putExtras(bundle1);
                intent1.putExtras(bundle2);
                intent1.putExtras(bundleF);

                String aux;
                aux = exceptions(pos_x, pos_y, direction, griid_x, griid_y, command);

                if (aux.equals("intent2")) {
                    startActivity(intent1);
                }
            }
        });
    }

    private String exceptions(int posx, int posy, String d, int gridx, int gridy, int c) {
        if (posx > gridx || posy > gridy) {
            Toast.makeText(getApplicationContext(), "Fora dos Limites, Tente Novamente!", Toast.LENGTH_SHORT).show();

        } else if (!"N".equalsIgnoreCase(d) && !"S".equalsIgnoreCase(d)
                && !"E".equalsIgnoreCase(d) && !"W".equalsIgnoreCase(d)) {
            Toast.makeText(getApplicationContext(), "Direção Não Existe, Tente Novamente", Toast.LENGTH_SHORT).show();
        } else if (c == 1){
            Toast.makeText(getApplicationContext(), "Comando Inválido, Tente Novamente", Toast.LENGTH_SHORT).show();
        } else {
            return "intent2";
        }
        return "intentX";
    }
}
