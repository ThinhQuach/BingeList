package com.example.sheridancollege.prog39402.thinh.ravi.rumleen.adapter

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.R
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.SignUpActivity
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.casts.Cast
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.movies.Movies

class CastAdapter(context:Activity, private var castList: List<Cast>) :
    RecyclerView.Adapter<CastAdapter.ViewHolder>() {
    lateinit var context1 : Activity

    init {
        context1 = context
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgCast: AppCompatImageView = itemView.findViewById(R.id.imgCast)
        val txtCastName: AppCompatTextView = itemView.findViewById(R.id.txtCastName)
        val txtRoleName: AppCompatTextView = itemView.findViewById(R.id.txtRoleName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_cast, parent, false)
        return ViewHolder(view)
    }

    fun setData(castList:ArrayList<Cast>)
    {
        this.castList = castList
        notifyDataSetChanged()
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val casts = castList[position]
        Glide
            .with(context1)
            .load(casts.image)
            .into(holder.imgCast);
        holder.txtCastName.setText(casts.name)
        holder.txtRoleName.setText(casts.role_name)

    }
    override fun getItemCount(): Int = castList.size
}
