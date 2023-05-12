package com.myfitness.ui.main

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.myfitness.R
import com.myfitness.databinding.ItemUserBinding
import com.myfitness.service.model.Result
import com.myfitness.ui.detail.DetailsActivity


class UserAdapter(
    val context: Context, val list: ArrayList<Result>
) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_user, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = list[position]
        val binding = holder.binding
        Glide.with(context).load(model.picture.large).into(binding.imgUser)

        binding.txtUserName.text = "${model.name.title} ${model.name.first} ${model.name.last}"
        binding.txtDob.text = model.dob.date
        binding.txtTime.text = model.registered.date

        binding.txtAddress.text =
            "${model.location.street} ${model.location.city} ${model.location.state} ${model.location.country} ${model.location.postcode} ${model.location.country}"


        binding.rlMain.setOnClickListener {
            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra("MY_MODEL_KEY", model);
            context.startActivity(intent);
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ItemUserBinding.bind(itemView)
    }
}