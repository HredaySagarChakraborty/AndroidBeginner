package comp.example.hreday.androidbeginner;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter2 extends RecyclerView.Adapter<Adapter2.ViewHolder> {


    List<Upload1> list;

    Context context;
    private onItemClickListener listener;

    public Adapter2() {
    }

    public Adapter2(List<Upload1> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.sample1,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {


        Upload1 upload=list.get(position);
        holder.textView.setText(upload.getImageName());
        Picasso.with(context)
                .load(upload.getImageUrl())
                .placeholder(R.mipmap.ic_launcher)
                .fit()
                .centerCrop()
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnCreateContextMenuListener,MenuItem.OnMenuItemClickListener {


        TextView  textView;
        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);


            textView=itemView.findViewById(R.id.projectText);
            imageView=itemView.findViewById(R.id.projectImg);
            itemView.setOnClickListener(this);
            itemView.setOnCreateContextMenuListener(this);
        }


        @Override
        public void onClick(View v) {
            if(listener!=null){


                int position=getAdapterPosition();
                if(position!= RecyclerView.NO_POSITION){

                    listener.onItemClick(position);
                }
            }

        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            menu.setHeaderTitle("Chosse any action");
            MenuItem doAntTask =menu.add(Menu.NONE,1,1,"do any task");
            MenuItem delete=menu.add(Menu.NONE,2,2,"delete");

            doAntTask.setOnMenuItemClickListener(this);
            delete.setOnMenuItemClickListener(this);

        }

        @Override
        public boolean onMenuItemClick(MenuItem item) {
            if(listener!=null){


                int position=getAdapterPosition();
                if(position!= RecyclerView.NO_POSITION){

                    switch (item.getItemId()){


                        case 1:
                            listener.onDoAnyTask(position);
                            return  true;


                        case 2:

                            listener.onDelete(position);
                            return  true;
                    }
                }
            }


            return false;
        }
    }

    public  interface  onItemClickListener{

        void onItemClick(int position);
        void onDoAnyTask(int poition);
        void onDelete(int position);


    }
    public void setOnItemClickListener(onItemClickListener listener){

        this.listener=listener;
    }
}
