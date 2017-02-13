package fogaiht.rovernasa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button btnOk = (Button) findViewById(R.id.btn1);
        btnOk.setOnClickListener(oncli);
    }

    private View.OnClickListener oncli = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            // TODO Auto-generated method stub
            Intent intent1 = new Intent(MainActivity.this, Rover1.class);
            Intent intent2 = new Intent(MainActivity.this, Rover2.class);

            TextView edtGridX = (TextView) findViewById(R.id.editTextGridX);
            TextView edtGridY = (TextView) findViewById(R.id.editTextGridY);

            String txt1 = "";
            String txt2 = "";

            txt1 = edtGridX.getText().toString();
            txt2 = edtGridY.getText().toString();

            Bundle bundle1 = new Bundle();
            Bundle bundle2 = new Bundle();

            bundle1.putString("txt1", txt1);
            bundle2.putString("txt2", txt2);

            intent1.putExtras(bundle1);
            intent1.putExtras(bundle2);

            startActivity(intent1);

        }
    };

}

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.main);
//
//
//
//        final EditText X = (EditText) findViewById(R.id.editTextGridX);
//        final EditText Y = (EditText) findViewById(R.id.editTextGridY);
//
//        final int griid_x = Integer.parseInt(X.getText().toString());
//        final int griid_y = Integer.parseInt(Y.getText().toString());
//
//        Intent intent= new Intent(this, MainActivity.class);
//        intent.putExtra("gridX", griid_x);
//        intent.putExtra("gridY", griid_y);
//        startActivity(intent);
//
//        Button iniciar = (Button) findViewById(R.id.btn1);
//        iniciar.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//
//
//
//                Rover a = new Rover();
//                a.inputGrid(griid_x,griid_y);
//
//
//                TextView teste = (TextView) findViewById(R.id.textView8);
////                teste.setText(a.print_status());
//                teste.setText(a.print_grid());
//
//                startActivity(new Intent(getBaseContext(), Rover1.class));
//            }
//        });
//
//
////        int griid_x = Integer.parseInt(String.valueOf(R.string.grid_x));
////        int griid_y = Integer.parseInt(String.valueOf(R.string.grid_y));
//
//
//
//
////        roverClass.
//    }
//}
