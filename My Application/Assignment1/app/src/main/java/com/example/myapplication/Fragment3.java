package com.example.myapplication;
import android.os.Bundle; import androidx.annotation.NonNull; import androidx.annotation.Nullable; import androidx.fragment.app.Fragment; import android.view.LayoutInflater; import android.view.View; import android.view.ViewGroup; import com.example.myapplication.databinding.Fragment3Binding;
public class Fragment3 extends Fragment {
    public static Fragment3Binding fragment3Binding;
    private static final String ARG_NAME = "user_name";
    private String userName;

    public Fragment3() {

    }

    public static Fragment3 newInstance(String name) {
        Fragment3 fragment = new Fragment3();
        Bundle args = new Bundle();
        args.putString(ARG_NAME, name);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            userName = getArguments().getString(ARG_NAME);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragment3Binding = Fragment3Binding.inflate(inflater, container, false);

        if (userName != null) {
            fragment3Binding.textViewWelcome.setText("Welcome, " + userName);
        }

        return fragment3Binding.getRoot();
    }
}