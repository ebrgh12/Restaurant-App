package com.girish.restaurants;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.girish.restaurants.model.RestaurantsResponse;

import java.util.ArrayList;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder>{

    private Context context;
    private ArrayList<RestaurantsResponse> restaurantArrayList;

    public RestaurantAdapter(Context context, ArrayList<RestaurantsResponse> restaurantArrayList) {
        this.context = context;
        this.restaurantArrayList = restaurantArrayList;
    }

    @Override
    public RestaurantViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.restauarant_list_item,parent,false);
        return new RestaurantViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RestaurantViewHolder holder, int position) {

        holder.movieTitle.setText(restaurantArrayList.get(position).getName());
        holder.rate.setText(Double.toString(restaurantArrayList.get(position).getBusinessId()));

        String imagePath="https://image.tmdb.org/t/p/w500"+restaurantArrayList.get(position).getCoverImgUrl();

        Glide.with(context)
                .load(imagePath)
                .placeholder(R.drawable.loading)
                .into(holder.movieImage);


    }

    @Override
    public int getItemCount() {
        return restaurantArrayList.size();
    }


    public class RestaurantViewHolder extends RecyclerView.ViewHolder {


        public TextView movieTitle, rate;
        public ImageView movieImage;

        public RestaurantViewHolder(View itemView) {
            super(itemView);

            movieImage = (ImageView) itemView.findViewById(R.id.ivMovie);
            rate = (TextView) itemView.findViewById(R.id.tvRating);
            movieTitle = (TextView) itemView.findViewById(R.id.tvTitle);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    int position=getAdapterPosition();

                    if(position!= RecyclerView.NO_POSITION) {

                        /*Response selctedMovie = restaurantArrayList.get(position);

                        Intent intent=new Intent(context, DashBoardActivity.class);
                        intent.putExtra("movie",selctedMovie);
                        context.startActivity(intent);*/
                    }
                }
            });


        }
    }
}
