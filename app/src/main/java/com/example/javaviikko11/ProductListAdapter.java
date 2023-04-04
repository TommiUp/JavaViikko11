package com.example.javaviikko11;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductListAdapter extends RecyclerView.Adapter<ProductViewHolder> {
    private Context context;
    private ArrayList<Product> products;

    private Storage storage = Storage.getInstance();

    public ProductListAdapter(Context context, ArrayList<Product> products) {
        this.context = context;
        this.products = products;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ProductViewHolder(LayoutInflater.from(context).inflate(R.layout.product_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        holder.productName.setText(String.valueOf(products.get(position).getProductName()));
        String notes = products.get(position).getProductNotes();
        if (notes.isEmpty()) {
            holder.productNotes.setVisibility(View.GONE);
        } else {
            holder.productNotes.setVisibility(View.VISIBLE);
            holder.productNotes.setText("Muista: " + notes);
        }
        holder.editName.setText(products.get(position).getProductNotes());
        holder.deleteImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = holder.getAdapterPosition();
                removeProduct(products.get(pos));
            }
        });
        holder.editImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = holder.getAdapterPosition();
                if (holder.editName.getVisibility() == view.VISIBLE){
                    Product product = Storage.getInstance().getProductByIdWithoutRemove(pos);
                    product.setProductNotes(holder.editName.getText().toString());
                    holder.editName.setVisibility(View.GONE);
                    notifyDataSetChanged();
                } else {
                    holder.editName.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    public void removeProduct(Product product) {
        int position = products.indexOf(product);
        if (position != -1) {
            products.remove(position);
            notifyItemRemoved(position);
        }
    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}