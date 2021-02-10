package stud11318012.develops.wonderfulindonesia;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.app.Activity.RESULT_OK;

public class AkunFragment extends Fragment {
    private ListView listPlayer;
    private ArrayList<Pemain> players;
    private ImageView imageHolder;

    private final int requestCode = 1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_akun, container, false);
        TextView nama = v.findViewById(R.id.tv_namaMain);
        nama.setText(Preferences.getLoggedInUser(getActivity().getBaseContext()));
        v.findViewById(R.id.button_logoutMain).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Menghapus Status login dan kembali ke Login Activity
                Preferences.clearLoggedInUser(getActivity().getBaseContext());
                startActivity(new Intent(getActivity().getBaseContext(),Login.class));
                getActivity().finish();
            }
        });
//        TextView ppk = v.findViewById(R.id.password);
//        Intent i = new Intent(getContext(), Login.class);
        Button capturedImageButton = (Button) v.findViewById(R.id.take_picture);
        listPlayer   = v.findViewById(R.id.list);
        imageHolder = v.findViewById(R.id.captured_photo);
        players = generateDummmyData();

        ListPemainAdapter adapter = new ListPemainAdapter(getActivity(), players);
        listPlayer.setAdapter(adapter);
        listPlayer.setOnItemClickListener(listener);

        capturedImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent photoCaptureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                startActivityForResult(photoCaptureIntent, requestCode);

            }
        });
        return v;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if(this.requestCode == requestCode && resultCode == RESULT_OK){

            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imageHolder.setImageBitmap(bitmap);

        }


    }



    AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            if(position == 0){
                Intent detailIntent = new Intent(getActivity(), PemainData.class);
                detailIntent.putExtra(PemainData.EXTRA_PLAYER, players.get(position));
                startActivity(detailIntent);
            }
            else if( position ==1){
                Intent detailIntent1 = new Intent(getActivity(), ContentProvider.class);
                startActivity(detailIntent1);

            }
            else if( position ==2){
                Intent detailIntent1 = new Intent(getActivity(), MainActivity2.class);
                startActivity(detailIntent1);

            }
            else if( position ==3){
                Uri uri = Uri.parse("https://www.klook.com/id/faq");
                Intent i = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(i);

            }

        }
    };

    private static ArrayList<Pemain> generateDummmyData(){
        ArrayList<Pemain> dummyPlayers = new ArrayList<>();

        Pemain player = new Pemain();
        player.setNamaPemain("Favorite");
        player.setNationality("Daftar destinasi favorite anda");
        player.setPosition("Midfielder");
        player.setCareer("1911–1918");
        player.setAppearances(15);
        player.setGoalCount(4);
        player.setImgResource(R.drawable.favorite);

        dummyPlayers.add(player);

        player = new Pemain();
        player.setNamaPemain("undang");
        player.setNationality("undang teman mu");
        player.setPosition("Midfielder");
        player.setCareer("1911–1921");
        player.setAppearances(20);
        player.setGoalCount(0);
        player.setImgResource(R.drawable.tamu);

        dummyPlayers.add(player);

        player = new Pemain();
        player.setNamaPemain("Daftar Tamu dan Penumpang");
        player.setNationality("Isi data teman perjalanan anda ");
        player.setPosition("Forward");
        player.setCareer("1911–1928");
        player.setAppearances(27);
        player.setGoalCount(23);
        player.setImgResource(R.drawable.undang);

        dummyPlayers.add(player);

        player = new Pemain();
        player.setNamaPemain("Pusat bantuan");
        player.setNationality("Kami siap membantu anda");
        player.setPosition("Midfielder");
        player.setCareer("1913–1918");
        player.setAppearances(8);
        player.setGoalCount(0);
        player.setImgResource(R.drawable.bantuan);

        dummyPlayers.add(player);
        return dummyPlayers;
    }

    }
