package com.example.btvn.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.btvn.R;
import com.example.btvn.models.Markup;

import org.w3c.dom.Text;

import java.util.List;

public class MarkupAdapter extends RecyclerView.Adapter<MarkupAdapter.ViewHolder> {
    Context context;
    List<Markup> markupList;

    public MarkupAdapter(Context context, List<Markup> markupList) {
        this.context = context;
        this.markupList = markupList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.markup_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Markup markup = markupList.get(position);
        holder.href.setText(markup.getHref());
    }

    @Override
    public int getItemCount() {
        return markupList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView href;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            href = itemView.findViewById(R.id.tv_href);
        }
    }
}
