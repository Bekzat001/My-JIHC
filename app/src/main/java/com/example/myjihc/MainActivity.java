
package com.example.myjihc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

public class MainActivity extends AppCompatActivity {

    Button btn_login, btn_register;

    FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        btn_login = (Button) findViewById(R.id.buttonLogin);
        btn_register = (Button) findViewById(R.id.buttonRegister);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,Login_form.class);
                startActivity(intent);
            }
        });

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Signup_Form.class);
                startActivity(intent);
            }
        });

        /*
        TextView tv_animation;
        Animation clockWaseAnimation, zoomAnimation, fadeAnimation, blinkAnimation, moveAnimation;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            tv_animation = findViewById(R.id.tv_animation);

            clockWaseAnimation = AnimationUtils.loadAnimation(getApplicationContext(),
                    R.anim.clockwase);

            zoomAnimation = AnimationUtils.loadAnimation(getApplicationContext(),
                    R.anim.zoom);

            fadeAnimation = AnimationUtils.loadAnimation(getApplicationContext(),
                    R.anim.fade);

            blinkAnimation = AnimationUtils.loadAnimation(getApplicationContext(),
                    R.anim.blink);

            moveAnimation = AnimationUtils.loadAnimation(getApplicationContext(),
                    R.anim.move);
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            MenuInflater menuInflater = getMenuInflater();
            menuInflater.inflate(R.menu.main, menu);
            return super.onCreateOptionsMenu(menu);
        }

        @Override
        public boolean onOptionsItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.clockWise:
                    tv_animation.startAnimation(clockWaseAnimation);
                    break;

                case R.id.fade:
                    tv_animation.startAnimation(fadeAnimation);
                    break;

                case R.id.zoom:
                    tv_animation.startAnimation(zoomAnimation);
                    break;

                case R.id.blink:
                    tv_animation.startAnimation(blinkAnimation);
                    break;

                case R.id.move:
                    tv_animation.startAnimation(moveAnimation);
                    break;
            }
            return true;
        }
        in xml
    <TextView
        android:id="@+id/tv_animation"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Animation"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

*/
    }
}