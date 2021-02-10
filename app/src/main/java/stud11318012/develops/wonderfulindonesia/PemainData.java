package stud11318012.develops.wonderfulindonesia;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PemainData extends AppCompatActivity {

    public static final String EXTRA_PLAYER = "extra_player";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Pemain selectedPlayer = getIntent().getParcelableExtra(EXTRA_PLAYER);
        if(selectedPlayer!=null){
            ImageView imgFoto = findViewById(R.id.pemain);
            imgFoto.setImageResource(selectedPlayer.getImgResource());


            TextView txtNama = findViewById(R.id.nama);
            txtNama.setText(selectedPlayer.getNamaPemain());

            TextView txtNationality = findViewById(R.id.nationality);
            txtNationality.setText("Nationality : " + selectedPlayer.getNationality());

            TextView txtPosition = findViewById(R.id.position1);
            txtPosition.setText("POSITION : " + selectedPlayer.getPosition());

            TextView txtCareer = findViewById(R.id.career1);
            txtCareer.setText("Career : " + selectedPlayer.getCareer());

            TextView txtAppearances = findViewById(R.id.appearances1);
            txtAppearances.setText("Appearances : " +selectedPlayer.getAppearances());

            TextView txtGoal = findViewById(R.id.goals1);
            txtGoal.setText("GOALS : " +selectedPlayer.getGoalCount());

        }

    }
}

