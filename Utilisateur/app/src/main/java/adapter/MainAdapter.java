package adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.example.utilisateur.Anime;
import com.example.utilisateur.PageAnime;
import com.example.utilisateur.PopUp;
import com.example.utilisateur.R;
import com.example.utilisateur.flightMode;


import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    Context context;
    List<Anime> animeList;
    int position;


    public MainAdapter(Context context, List<Anime> animeList) {
        this.context = context;
        this.animeList = animeList;
    }


    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.vignette,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Glide.with(context).load(animeList.get(position).getImage()).into(holder.ImageAnime);
        holder.TextNameAnime.setText(animeList.get(position).getTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, PageAnime.class);
                i.putExtra("animeImage", animeList.get(position).getImage());
                i.putExtra("animeName", animeList.get(position).getTitle());
                i.putExtra("animeSynopsis",animeList.get(position).getSynopsis());

                context.startActivity(i);
                checkAirplaneMode();
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                PopUp popup = new PopUp(context);
                popup.setAnimeName(animeList.get(position).getTitle());
                Glide.with(context).load(animeList.get(position).getImage()).into(popup.getimageview());
                checkAirplaneMode();
                popup.build();
                return false;
            }
        });

    }

    @Override
    public int getItemCount() {
        return animeList.size();
    }

    private void checkAirplaneMode() {
        if (isAirplaneModeOn(context)) {
            Intent otherActivity = new Intent(context, flightMode.class);
            context.startActivity(otherActivity);

        }
    }

    private static boolean isAirplaneModeOn(Context context) {
        return Settings.System.getInt(context.getContentResolver(), Settings.Global.AIRPLANE_MODE_ON, 0) != 0;
    }

    public static final class ViewHolder extends RecyclerView.ViewHolder{

        ImageView ImageAnime;
        TextView TextNameAnime;

        public ViewHolder(View itemView){
            super(itemView);
            ImageAnime = itemView.findViewById(R.id.image_item);
            TextNameAnime = itemView.findViewById(R.id.nom_item);

        }
    }
}
