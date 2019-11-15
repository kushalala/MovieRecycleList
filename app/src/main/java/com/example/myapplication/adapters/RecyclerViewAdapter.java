package com.example.myapplication.adapters;

import android.content.Context;
import android.content.Intent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;


import com.example.myapplication.R;
import com.example.myapplication.activities.AnimeActivity;
import com.example.myapplication.model.Anime;
import com.example.myapplication.model.Movies;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Aws on 11/03/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext ;
    private List<Movies> mData ;
    RequestOptions option;


    public RecyclerViewAdapter(Context mContext, List<Movies> mData) {
        this.mContext = mContext;
        this.mData = mData;

        // Request option for Glide
        option = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view ;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.anime_row_item,parent,false) ;
        final MyViewHolder viewHolder = new MyViewHolder(view) ;
        viewHolder.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(mContext, AnimeActivity.class);
                i.putExtra("movies_title",mData.get(viewHolder.getAdapterPosition()).getTitle());
                i.putExtra("movies_genre",mData.get(viewHolder.getAdapterPosition()).getGenre());
                i.putExtra("movies_description",mData.get(viewHolder.getAdapterPosition()).getDescription());
                i.putExtra("movies_price",mData.get(viewHolder.getAdapterPosition()).getPrice());
                i.putExtra("movies_image",mData.get(viewHolder.getAdapterPosition()).getImage_url());

                mContext.startActivity(i);

            }
        });




        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.tv_name.setText(mData.get(position).getTitle());
        //holder.tv_rating.setText(String.valueOf(mData.get(position).getPrice()));
        holder.tv_category.setText(mData.get(position).getGenre());

        // Load Image from the internet and set it into Imageview using Glide

        //NEEDS FIX PLS
        Glide.with(mContext).load(mData.get(position).getImage_url()).apply(option).into(holder.img_thumbnail);



    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_name ;
        TextView tv_rating ;
        TextView tv_studio ;
        TextView tv_category;
        ImageView img_thumbnail;
        LinearLayout view_container;





        public MyViewHolder(View itemView) {
            super(itemView);

            view_container = itemView.findViewById(R.id.container);
            tv_name = itemView.findViewById(R.id.anime_name);
            tv_category = itemView.findViewById(R.id.categorie);
            tv_rating = itemView.findViewById(R.id.rating);
            img_thumbnail = itemView.findViewById(R.id.thumbnail);

        }
    }

}
