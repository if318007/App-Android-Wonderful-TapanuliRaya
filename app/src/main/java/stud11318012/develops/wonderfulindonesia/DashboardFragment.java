package stud11318012.develops.wonderfulindonesia;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class DashboardFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View v = inflater.inflate(R.layout.fragment_dashboard, container, false);
        View.OnClickListener handler = new View.OnClickListener() {
            public void onClick(View v) {
                switch (v.getId()) {

                    case R.id.share:
                        shareTextUrl();
                        break;
                    case R.id.share1:
                        shareTextUrl();
                        break;
                    case R.id.share2:
                        shareTextUrl();
                        break;


                }
            }
        };

        v.findViewById(R.id.share).setOnClickListener(handler);
        final RatingBar simpleRatingBar = (RatingBar) v.findViewById(R.id.simpleRatingBar);
        Button submitButton = (Button) v.findViewById(R.id.submitButton);
        // perform click event on button
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get values and then displayed in a toast
                String totalStars = "Total Stars:: " + simpleRatingBar.getNumStars();
                String rating = "Rating :: " + simpleRatingBar.getRating();
                Toast.makeText(getActivity(), totalStars + "\n" + rating, Toast.LENGTH_LONG).show();
            }
        });
        return v;
    }
    private void shareTextUrl() {
        Intent share = new Intent(android.content.Intent.ACTION_SEND);
        share.setType("text/plain");
        share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);

        // Add data to the intent, the receiving app will decide
        // what to do with it.
        share.putExtra(Intent.EXTRA_SUBJECT, "Title Of The Post");
        share.putExtra(Intent.EXTRA_TEXT, "https://borneochannel.com/makanan-khas-sumatera-utara/amp/");

        startActivity(Intent.createChooser(share, "Share link!"));
    }

}