package stud11318012.develops.wonderfulindonesia;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

public class Login extends AppCompatActivity {
//
//    EditText username, password;
//    Button btnLogin;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
//
//
//        username = (EditText) findViewById(R.id.username);
//        password = (EditText) findViewById(R.id.password);
//        btnLogin = (Button)findViewById(R.id.btnLogin);
//
//        btnLogin.setOnClickListener(new View.OnClickListener() {
//            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
//            @Override
//            public void onClick(View v) {
//
//                String usernameKey = username.getText().toString();
//                String passwordKey = password.getText().toString();
//
//                if (usernameKey.equals("fitri") && passwordKey.equals("fitri")){
//                    //jika login berhasil
//                    Toast.makeText(getApplicationContext(), "LOGIN SUKSES",
//                            Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(Login.this, Navigation.class);
//                    Login.this.startActivity(intent);
//                    finish();
//                    NotificationCompat.Builder mBuilder =
//                            new NotificationCompat.Builder(Login.this)
//                                    .setSmallIcon(R.drawable.notif)
//                                    .setContentTitle("My notification")
//                                    .setContentText("Anda sudah berhasil Login")
//                                    .setAutoCancel(true)
//                                    .setVibrate(new long[]{1000, 1000, 1000, 1000,
//                                            1000});
//
//                    Intent resultIntent = new Intent(Login.this, Navigation.class);
//
//                    TaskStackBuilder stackBuilder = TaskStackBuilder.create(Login.this);
//                    stackBuilder.addParentStack(Navigation.class);
//                    stackBuilder.addNextIntent(resultIntent);
//                    PendingIntent resultPendingIntent =
//                            stackBuilder.getPendingIntent(
//                                    0,
//                                    PendingIntent.FLAG_UPDATE_CURRENT
//                            );
//                    mBuilder.setContentIntent(resultPendingIntent);
//                    NotificationManager mNotificationManager =
//                            (NotificationManager)
//                                    getSystemService(Context.NOTIFICATION_SERVICE);
//
//                    mNotificationManager.notify(101, mBuilder.build());
//                }else {
//                    //jika login gagal
//                    AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
//                    builder.setMessage("Username atau Password Anda salah!")
//                            .setNegativeButton("Retry", null).create().show();
//                }
//            }
//
//        });
//    }
//}
private EditText mViewUser, mViewPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        /* Menginisialisasi variable dengan Form User dan Form Password dari Layout LoginActivity */
        mViewUser=findViewById(R.id.et_emailSignin);
        mViewPassword =findViewById(R.id.et_passwordSignin);
        /* Menjalankan Method razia() Jika tombol SignIn di keyboard di sentuh */
        mViewPassword.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE || actionId == EditorInfo.IME_NULL) {
                    razia();
                    return true;
                }
                return false;
            }
        });

        /* Menjalankan Method razia() jika merasakan tombol SignIn disentuh */
        findViewById(R.id.button_signinSignin).setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                razia();
            }
        });
        /* Ke RegisterActivity jika merasakan tombol SignUp disentuh */
        findViewById(R.id.button_signupSignin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),RegisterActivity.class));
            }
        });
    }

    /** ke MainActivity jika data Status Login dari Data Preferences bernilai true */
    @Override
    protected void onStart() {
        super.onStart();
        if (Preferences.getLoggedInStatus(getBaseContext())){

            startActivity(new Intent(getBaseContext(),Navigation.class));
            finish();

        }
    }

    /** Men-check inputan User dan Password dan Memberikan akses ke MainActivity */
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void razia(){
        /* Mereset semua Error dan fokus menjadi default */
        mViewUser.setError(null);
        mViewPassword.setError(null);
        View fokus = null;
        boolean cancel = false;

        /* Mengambil text dari form User dan form Password dengan variable baru bertipe String*/
        String user = mViewUser.getText().toString();
        String password = mViewPassword.getText().toString();

        /* Jika form user kosong atau TIDAK memenuhi kriteria di Method cekUser() maka, Set error
         *  di Form User dengan menset variable fokus dan error di Viewnya juga cancel menjadi true*/
        if (TextUtils.isEmpty(user)){
            mViewUser.setError("This field is required");
            fokus = mViewUser;
            cancel = true;
        }else if(!cekUser(user)){
            mViewUser.setError("This Username is not found");
            fokus = mViewUser;
            cancel = true;
        }

        /* Sama syarat percabangannya dengan User seperti di atas. Bedanya ini untuk Form Password*/
        if (TextUtils.isEmpty(password)){
            mViewPassword.setError("This field is required");
            fokus = mViewPassword;
            cancel = true;
        }else if (!cekPassword(password)){
            mViewPassword.setError("This password is incorrect");
            fokus = mViewPassword;
            cancel = true;
        }

        /* Jika cancel true, variable fokus mendapatkan fokus */
        if (cancel) fokus.requestFocus();
        else masuk();
    }

    /** Menuju ke MainActivity dan Set User dan Status sedang login, di Preferences */
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void masuk(){
        Toast.makeText(getApplicationContext(), "LOGIN SUKSES",
                Toast.LENGTH_SHORT).show();
        Preferences.setLoggedInUser(getBaseContext(),Preferences.getRegisteredUser(getBaseContext()));
        Preferences.setLoggedInStatus(getBaseContext(),true);
        startActivity(new Intent(getBaseContext(),Navigation.class));finish();
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(Login.this)
                        .setSmallIcon(R.drawable.notif)
                        .setContentTitle("My notification")
                        .setContentText("Anda sudah berhasil Login")
                        .setAutoCancel(true)
                        .setVibrate(new long[]{1000, 1000, 1000, 1000,
                                1000});

        Intent resultIntent = new Intent(Login.this, HomeFragment.class);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(Login.this);
        stackBuilder.addParentStack(Navigation.class);
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(
                        0,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );
        mBuilder.setContentIntent(resultPendingIntent);
        NotificationManager mNotificationManager =
                (NotificationManager)
                        getSystemService(Context.NOTIFICATION_SERVICE);

        mNotificationManager.notify(101, mBuilder.build());
    }


    /** True jika parameter password sama dengan data password yang terdaftar dari Preferences */
    private boolean cekPassword(String password){
        return password.equals(Preferences.getRegisteredPass(getBaseContext()));
    }

    /** True jika parameter user sama dengan data user yang terdaftar dari Preferences */
    private boolean cekUser(String user){
        return user.equals(Preferences.getRegisteredUser(getBaseContext()));
    }
}

