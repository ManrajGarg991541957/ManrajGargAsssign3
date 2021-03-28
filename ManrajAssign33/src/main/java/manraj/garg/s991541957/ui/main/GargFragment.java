package manraj.garg.s991541957.ui.main;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import manraj.garg.s991541957.ManrajActivity;
import manraj.garg.s991541957.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GargFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GargFragment extends Fragment implements View.OnClickListener{

    private View root;
    private static final String TAG = "Garg";
    AnimationDrawable mframeAnimation = null;
    private PageViewModel pageViewModel;
    final private int REQUEST_CODE_ASK_PERMISSIONS = 123;
    String number = getString(R.string.callNumber);
    ImageView img;

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
        root = inflater.inflate(R.layout.fragment_garg, container, false);
        img = (ImageView)root.findViewById(R.id.ImageView_Boy);

        // Handle Start Button
        final Button onButton = (Button) root.findViewById(R.id.ButtonStart);
        onButton.setOnClickListener((View.OnClickListener) this);

        // Handle Stop Button
        final Button offButton = (Button) root.findViewById(R.id.ButtonStop);
        offButton.setOnClickListener((View.OnClickListener) this);

        //Handle Call Button
        final Button callButton = (Button) root.findViewById(R.id.ButtonCall);
        callButton.setOnClickListener((View.OnClickListener) this);

        return root;
    }

    @Override
    public void onClick(View v) {

        switch(v.getId())
        {
            case R.id.ButtonStart:
                startAnimation();
                break;
            case R.id.ButtonStop:
                stopAnimation();
                break;
            case R.id.ButtonCall:
                    if (ContextCompat.checkSelfPermission(getContext(), android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        requestPermissions(new String[]{Manifest.permission.CALL_PHONE},
                                REQUEST_CODE_ASK_PERMISSIONS);
                    }else{
                        call();
                    }
                    break;
        }
    }


    public void call()
    {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse(getString(R.string.telNumber)));
        getActivity().startActivity(intent);
    }

    private void startAnimation()
    {

        BitmapDrawable frame1 = (BitmapDrawable)getResources().getDrawable(R.drawable.raptors);
        BitmapDrawable frame2 = (BitmapDrawable)getResources().getDrawable(R.drawable.leaf);
        BitmapDrawable frame3 = (BitmapDrawable)getResources().getDrawable(R.drawable.city);
        BitmapDrawable frame4 = (BitmapDrawable)getResources().getDrawable(R.drawable.toronto);

        // Get the background, which has been compiled to an AnimationDrawable object.
        int reasonableDuration = 250;
        mframeAnimation = new AnimationDrawable();
        mframeAnimation.setOneShot(false);	// loop continuously
        mframeAnimation.addFrame(frame1, reasonableDuration);
        mframeAnimation.addFrame(frame2, reasonableDuration);
        mframeAnimation.addFrame(frame3, reasonableDuration);
        mframeAnimation.addFrame(frame4, reasonableDuration);

        img.setBackground(mframeAnimation);

        mframeAnimation.setVisible(true,true);
        mframeAnimation.start();
    }

    private void stopAnimation()
    {
        mframeAnimation.stop();
        mframeAnimation.setVisible(false,false);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_ASK_PERMISSIONS:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                  call();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }
}