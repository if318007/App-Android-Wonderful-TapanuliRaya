package stud11318012.develops.wonderfulindonesia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Restaurant extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);
    }
    public void pesan1(View view){
        Intent intent = new Intent(getApplicationContext(),Pesan.class);
        startActivity(intent);
    }
    public void pesan2(View view){
        Intent intent = new Intent(getApplicationContext(),Pesan.class);
        startActivity(intent);
    }
    public void pesan3(View view){
        Intent intent = new Intent(getApplicationContext(),Pesan.class);
        startActivity(intent);
    }
}
