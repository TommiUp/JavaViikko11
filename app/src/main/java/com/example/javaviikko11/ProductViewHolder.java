package com.example.javaviikko11;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProductViewHolder extends RecyclerView.ViewHolder {
    TextView productName, productNotes;
    ImageView deleteImage, editImage;
    EditText editName;

    public ProductViewHolder(@NonNull View itemView) {
        super(itemView);
        productName = itemView.findViewById(R.id.txtProduct);
        productNotes = itemView.findViewById(R.id.txtNotes);
        deleteImage = itemView.findViewById(R.id.imageDelete);
        editImage = itemView.findViewById(R.id.imageEdit);
        editName = itemView.findViewById(R.id.editNameText);
    }
}

