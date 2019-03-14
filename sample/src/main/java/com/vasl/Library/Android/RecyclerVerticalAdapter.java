package com.vasl.Library.Android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vasl.recyclerlibrary.baseClasses.BaseRecyclerAdapter;
import com.vasl.recyclerlibrary.baseClasses.BaseRecyclerAdapterItemBaseScroll;
import com.vasl.recyclerlibrary.globalObjects.RowModel;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerVerticalAdapter extends BaseRecyclerAdapterItemBaseScroll {

    private Context context;

    private ArrayList<RowModel> item;

    public RecyclerVerticalAdapter(Context context, ArrayList<RowModel> item) {
        this.context = context;
        this.item = item;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_vertical, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        ViewHolder holder = (ViewHolder) viewHolder;

        RowModel rowModel = item.get(position);

        holder.textView.setText(rowModel.getTitle());

        GlideApp
                .with(context)
                .load(rowModel.getImageUrl())
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return item.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        SquareImageView imageView;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.categoryIconImageView);
            textView = itemView.findViewById(R.id.titleTextView);
        }
    }
}
