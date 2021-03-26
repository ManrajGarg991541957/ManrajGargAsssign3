package manraj.garg.s991541957.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import manraj.garg.s991541957.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class ManrajFragment extends Fragment {

    private PageViewModel pageViewModel;
    private CanvasView customCanvas;
    private static final String TAG = "Manraj";

    public ManrajFragment(){

    }

    public static ManrajFragment newInstance() {
        return new ManrajFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
       pageViewModel.setIndex(TAG);
    }

    public void clearCanvas(View view)
    {
        customCanvas.wipeCanvas();
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        final TextView textView = root.findViewById(R.id.section_label);
        customCanvas = (CanvasView) root.findViewById(R.id.signature_canvas);

        return root;
    }
}