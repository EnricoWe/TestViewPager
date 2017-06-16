package de.enricoweinhold.TestViewPager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class SlideFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Get the ViewGroup that contains your layout
        ViewGroup viewGroup = (ViewGroup)inflater.inflate(R.layout.viewpager_content, container, false);
        TextView textView = (TextView) viewGroup.findViewById(R.id.textview);

        //Get pagenumber from arguments
        Bundle bundle = this.getArguments();
        textView.setText(bundle.getInt("PAGENUMBER") + "");

        return viewGroup;
    }
}
