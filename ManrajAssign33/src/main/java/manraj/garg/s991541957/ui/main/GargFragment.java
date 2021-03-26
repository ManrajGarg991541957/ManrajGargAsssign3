package manraj.garg.s991541957.ui.main;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import manraj.garg.s991541957.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GargFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GargFragment extends Fragment {

    private static final String TAG = "Garg";
    AnimationDrawable mframeAnimation = null;
    private PageViewModel pageViewModel;

    public GargFragment(){

    }

    public static GargFragment newInstance() {
        return new GargFragment();
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
        View root = inflater.inflate(R.layout.fragment_garg, container, false);
        ImageView img = (ImageView)root.findViewById(R.id.ImageView_Boy);

        img.setBackground(mframeAnimation);

        final Button onButton = (Button) root.findViewById(R.id.ButtonStart);
        onButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAnimation();
            }
        });

        // Handle Stop Button
        final Button offButton = (Button) root.findViewById(R.id.ButtonStop);
        offButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopAnimation();
            }
        });

        return root;
    }


    private void startAnimation()
    {

        BitmapDrawable frame1 = (BitmapDrawable)getResources().getDrawable(R.drawable.raptors);
        BitmapDrawable frame2 = (BitmapDrawable)getResources().getDrawable(R.drawable.leaf);

        // Get the background, which has been compiled to an AnimationDrawable object.
        int reasonableDuration = 250;
        mframeAnimation = new AnimationDrawable();
        mframeAnimation.setOneShot(false);	// loop continuously
        mframeAnimation.addFrame(frame1, reasonableDuration);
        mframeAnimation.addFrame(frame2, reasonableDuration);


        mframeAnimation.setVisible(true,true);
        mframeAnimation.start();
    }

    private void stopAnimation()
    {
        mframeAnimation.stop();
        mframeAnimation.setVisible(false,false);

    }
}