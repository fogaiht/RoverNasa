package fogaiht.rovernasa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Rover2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rover2);

        final Intent intent1 = new Intent(Rover2.this, Results.class);
        final Intent intent = getIntent();
        final Bundle bundle = intent.getExtras();

        final String grid_x = bundle.getString("txt1");
        final String grid_y = bundle.getString("txt2");
        final String txtF1 = bundle.getString("txtF1");

        final EditText X = (EditText) findViewById(R.id.editTextX);
        final EditText Y = (EditText) findViewById(R.id.editTextY);
        final EditText D = (EditText) findViewById(R.id.editTextD);
        final EditText C = (EditText) findViewById(R.id.editText2);


        Button iniciar = (Button) findViewById(R.id.btn2);
        iniciar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Rover b = new Rover();

                int pos_x = Integer.parseInt(X.getText().toString());
                int pos_y = Integer.parseInt(Y.getText().toString());
                int griid_x = Integer.parseInt(grid_x);
                int griid_y = Integer.parseInt(grid_y);
                int command;

                String direction = D.getText().toString();
                String comm = C.getText().toString();

                b.inputGrid(griid_x, griid_y);
                b.insert_status(pos_x, pos_y, direction);
                command = b.action_move(comm);

                TextView info2 = (TextView) findViewById(R.id.info2);
                info2.setText(b.print_status());

                String txt1 = grid_x;
                String txt2 = grid_y;
                String txtF2 = info2.getText().toString();

                Bundle bundle1 = new Bundle();
                Bundle bundle2 = new Bundle();
                Bundle bundleF1 = new Bundle();
                Bundle bundleF2 = new Bundle();

                bundle1.putString("txt1", txt1);
                bundle2.putString("txt2", txt2);
                bundleF1.putString("txtF1", txtF1);
                bundleF2.putString("txtF2", txtF2);

                intent1.putExtras(bundle1);
                intent1.putExtras(bundle2);
                intent1.putExtras(bundleF1);
                intent1.putExtras(bundleF2);

                String aux;
                aux = exceptions(pos_x, pos_y, direction, griid_x, griid_y, command);

                if (aux.equals("next")) {
                    startActivity(intent1);
                }
            }
        });
    }

    private String exceptions(int posx, int posy, String d, int gridx, int gridy, int c) {
        if (posx > gridx || posy > gridy) {
            Toast.makeText(getApplicationContext(), "Fora dos Limites, Tente Novamente", Toast.LENGTH_SHORT).show();
        } else if (!"N".equalsIgnoreCase(d) && !"S".equalsIgnoreCase(d)
                && !"E".equalsIgnoreCase(d) && !"W".equalsIgnoreCase(d)) {
            Toast.makeText(getApplicationContext(), "Direção Não Existe, Tente Novamente", Toast.LENGTH_SHORT).show();
        } else if (c == 1) {
            Toast.makeText(getApplicationContext(), "Comando Inválido ou Rover fora dos limites, Tente Novamente", Toast.LENGTH_SHORT).show();
        } else {
            return "next";
        }
        return "intentX";
    }
}
