package id.barkoststudio.tripgarut.fragment;

import android.support.v4.app.Fragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import id.barkoststudio.tripgarut.R;
import id.barkoststudio.tripgarut.TempatWisataActivity;

public class FragmentHome extends Fragment {

    public FragmentHome() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        Button button = (Button) view.findViewById(R.id.btnWisata);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(getActivity(), TempatWisataActivity.class);
                startActivity(intent);
            }
        });
        return  view;
    }
}
