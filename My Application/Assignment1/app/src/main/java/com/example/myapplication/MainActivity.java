package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity; import androidx.fragment.app.Fragment;
import android.os.Bundle; import android.text.TextUtils; import android.widget.Toast;
import com.example.myapplication.databinding.ActivityMainBinding;
public class MainActivity extends AppCompatActivity {

    public static ActivityMainBinding mainBinding;

    private int currentFragment = 1;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());

        Fragment1 fragment1 = Fragment1.newInstance(null, null);
        Fragment2 fragment2 = Fragment2.newInstance(null, null);


        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, fragment1)
                .commit();


        mainBinding.buttonContinue.setOnClickListener(view -> {
            if (currentFragment == 1) {

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, fragment2)
                        .addToBackStack(null)
                        .commit();
                currentFragment = 2;

            } else if (currentFragment == 2) {

                if (Fragment2.fragment2Binding != null &&
                        !TextUtils.isEmpty(Fragment2.fragment2Binding.editText.getText().toString())) {

                    name = Fragment2.fragment2Binding.editText.getText().toString().trim();


                    Fragment3 fragment3 = Fragment3.newInstance(name);
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragment_container, fragment3)
                            .addToBackStack(null)
                            .commit();

                    currentFragment = 3;

                } else {
                    Toast.makeText(getApplicationContext(), "Please enter your name!", Toast.LENGTH_SHORT).show();
                }

            } else if (currentFragment == 3) {

                Toast.makeText(getApplicationContext(), "App Finished Successfully!", Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
}