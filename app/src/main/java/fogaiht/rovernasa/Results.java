package fogaiht.rovernasa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Results extends AppCompatActivity {

//    @Override
//        public void onBackPressed()
//        {
//            startActivity(new Intent(getBaseContext(), activity.class));
//        }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.final_activity);

        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();

        String pos_finalRv1 = bundle.getString("txtF1");
        String pos_finalRv2 = bundle.getString("txtF2");

        TextView teste = (TextView) findViewById(R.id.txtR1);
        teste.setText(pos_finalRv1);

        TextView teste2 = (TextView) findViewById(R.id.txtR2);
        teste2.setText(pos_finalRv2);

    }
}
