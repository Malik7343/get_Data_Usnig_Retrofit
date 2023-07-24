package com.example.fetchdatausingvolley

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

class MyAdapter(val context : Activity, val productArrayList : List<Product>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.eachitem, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return productArrayList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = productArrayList[position]
        holder.title.text = currentItem.title
        holder.dis.text = currentItem.description
        holder.price.text = currentItem.price.toString()
        holder.rating.text = currentItem.rating.toString()

        // image view , how to show image in image view if the image is in form of url, 3rd Party Library
        // Picasso
        Picasso.get().load(currentItem.thumbnail).into(holder.image);
    }

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        var title : TextView
        var image : ShapeableImageView
        var dis : TextView
        var price : TextView
        var rating : TextView

        init {
            title = itemView.findViewById(R.id.productTitle)
            dis = itemView.findViewById(R.id.productDis)
            price = itemView.findViewById(R.id.productPrice)
            rating = itemView.findViewById(R.id.productRating)
            image = itemView.findViewById(R.id.productImage)

        }
    }

}