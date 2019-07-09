package comp.example.hreday.androidbeginner;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import java.util.List;

public class YoutubeAdapter extends RecyclerView.Adapter<YoutubeAdapter.ViewHolder> {


    List<YoutubeList> youtubeListList;

    public YoutubeAdapter() {


    }

    public YoutubeAdapter(List<YoutubeList> youtubeListList) {
        this.youtubeListList = youtubeListList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{


        WebView webView;


        public ViewHolder(View itemView) {
            super(itemView);


            webView=itemView.findViewById(R.id.webViewId);

            webView.getSettings().setJavaScriptEnabled(true);
            webView.setWebChromeClient(new WebChromeClient() {


                                       }


            );
        }
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_video,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(YoutubeAdapter.ViewHolder holder, int position) {

        holder.webView.loadData(youtubeListList.get(position).getVideoUrl(),"text/html","utf-8");

    }

    @Override
    public int getItemCount() {
        return youtubeListList.size();
    }
}
