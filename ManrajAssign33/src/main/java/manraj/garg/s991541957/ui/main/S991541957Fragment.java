package manraj.garg.s991541957.ui.main;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.TextView;

import manraj.garg.s991541957.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link S991541957Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class S991541957Fragment extends Fragment {

    private TextView firstName;
    private TextView lastName;
    private Animation rotation;
    Context context;

    private static final String TAG = "S991541957";

    private PageViewModel pageViewModel;

    public S991541957Fragment(){
    }

    public static S991541957Fragment newInstance() {
        return new S991541957Fragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        pageViewModel.setIndex(TAG);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        context = container.getContext();
        View root = inflater.inflate(R.layout.fragment_s991541957, container, false);
        firstName = (TextView) root.findViewById(R.id.manrajFirstName);
        lastName = (TextView) root.findViewById(R.id.manrajLastName);

        rotation = AnimationUtils.loadAnimation(context, R.anim.rotator);
        firstName.startAnimation(rotation);
        lastName.startAnimation(rotation);

        return root;
    }
}