package fogaiht.rovernasa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Grid extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid);

        Button btnNext = (Button) findViewById(R.id.btn1);
        btnNext.setOnClickListener(click);
    }

    private View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent intent1 = new Intent(Grid.this, Rover1.class);

            TextView edtGridX = (TextView) findViewById(R.id.editTextGridX);
            TextView edtGridY = (TextView) findViewById(R.id.editTextGridY);

            String txt1 = edtGridX.getText().toString();
            String txt2 = edtGridY.getText().toString();

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