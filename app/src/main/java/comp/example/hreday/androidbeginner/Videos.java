package comp.example.hreday.androidbeginner;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Vector;


/**
 * A simple {@link Fragment} subclass.
 */
public class Videos extends Fragment {

    private RecyclerView recyclerView;
    Vector<YoutubeList> youtubeListVector=new Vector<YoutubeList>();



    public Videos() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View v=inflater.inflate(R.layout.fragment_videos, container, false);

        recyclerView=v.findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplication()));


        youtubeListVector.add(new YoutubeList("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/WM_0NrlF1lg?list=PLK6pXSzzP1uYJmxt0kW2KPp4r1a53FyrP\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>"));
        youtubeListVector.add(new YoutubeList("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/YVu_xSzn2u0?list=PLGCjwl1RrtcTXrWuRTa59RyRmQ4OedWrt\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>"));
        youtubeListVector.add(new YoutubeList("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/PkoGCNtukRU?list=PLGCjwl1RrtcTXrWuRTa59RyRmQ4OedWrt\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>"));
        youtubeListVector.add(new YoutubeList("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/tOn5HsQPhUY?list=PLGCjwl1RrtcTXrWuRTa59RyRmQ4OedWrt\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>"));
        youtubeListVector.add(new YoutubeList("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/hoF5A30fbu4?list=PLGCjwl1RrtcTXrWuRTa59RyRmQ4OedWrt\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>"));
        youtubeListVector.add(new YoutubeList("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/sTk7q3f-t0I?list=PLGCjwl1RrtcTXrWuRTa59RyRmQ4OedWrt\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>"));
        youtubeListVector.add(new YoutubeList("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/KEp5RAZNMng?list=PLGCjwl1RrtcTXrWuRTa59RyRmQ4OedWrt\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>"));

        youtubeListVector.add(new YoutubeList("<<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/2pOCfKYO5Ao?list=PLGCjwl1RrtcTXrWuRTa59RyRmQ4OedWrt\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>"));


        youtubeListVector.add(new YoutubeList("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/oi-UAwiBigQ?list=PLGCjwl1RrtcTXrWuRTa59RyRmQ4OedWrt\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>"));
        youtubeListVector.add(new YoutubeList("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/vS9FWxJUrYc?list=PLGCjwl1RrtcTXrWuRTa59RyRmQ4OedWrt\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>"));
        youtubeListVector.add(new YoutubeList("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/ZexkBnk9zaI?list=PLGCjwl1RrtcTXrWuRTa59RyRmQ4OedWrt\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>"));
        youtubeListVector.add(new YoutubeList("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/LPqBlIn-Qd4?list=PLGCjwl1RrtcTXrWuRTa59RyRmQ4OedWrt\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>"));
        youtubeListVector.add(new YoutubeList("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/mSi7bNk4ySM?list=PLGCjwl1RrtcTXrWuRTa59RyRmQ4OedWrt\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>"));
        youtubeListVector.add(new YoutubeList("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/Zy2DKo0v-OY?list=PLGCjwl1RrtcTXrWuRTa59RyRmQ4OedWrt\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>"));
        YoutubeAdapter youtubeAdapter=new YoutubeAdapter(youtubeListVector);
        recyclerView.setAdapter(youtubeAdapter);



        // Inflate the layout for this fragment
        return v;
    }

}
























