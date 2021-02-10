package stud11318012.develops.wonderfulindonesia;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;


public class HomeFragment extends Fragment {
    ViewFlipper flip;

    int images[] = {R.drawable.pantai1, R.drawable.ranu_kumbolo, R.drawable.negeri_bakara, R.drawable.pusuk_buhit};
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view1= inflater.inflate(R.layout.fragment_home, container, false);

        TextView nama = view1.findViewById(R.id.tv_namaMain);
        nama.setText(Preferences.getLoggedInUser(getActivity().getBaseContext()));

        flip = (ViewFlipper) view1.findViewById(R.id.im1);
        getContext().registerReceiver(this.myBatteryReceiver, new
                IntentFilter(Intent.ACTION_BATTERY_CHANGED));

        for (int a= 0; a < images.length; a++){
            setFlipperImage(images[a]);

        }
        return  view1;

    }

    private void  setFlipperImage(int res){
        Log.i("Set Flipper Called", res+"");
        ImageView img = new ImageView(getContext());
        img.setBackgroundResource(res);
        flip.addView(img);
        flip.setFlipInterval(4000);
        flip.setAutoStart(true);

        flip.setInAnimation(getContext(),android.R.anim.slide_out_right);
        flip.setInAnimation(getContext(),android.R.anim.slide_in_left);

    }
    private BroadcastReceiver myBatteryReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int lvl = intent.getIntExtra("level", 0);
            if (lvl <= 5) {
                Toast.makeText(context, "Battery low!",
                        Toast.LENGTH_LONG).show();
            }
        }
    };

}
