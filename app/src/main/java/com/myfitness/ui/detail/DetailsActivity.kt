package com.myfitness.ui.detail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import com.bumptech.glide.Glide
import com.myfitness.databinding.ActivityDetailsBinding
import com.myfitness.service.model.Result
import com.myfitness.ui.base.BaseActivity


class DetailsActivity : BaseActivity() {

    private val binding by lazy { ActivityDetailsBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val usermodel: Result? = intent.getSerializableExtra("MY_MODEL_KEY") as Result?
        binding.txtUserName.text =
            "${usermodel?.name?.title} ${usermodel?.name?.first} ${usermodel?.name?.last}"
        binding.txtMobileNumber.text = usermodel!!.phone
        binding.txtEmail.text = usermodel.email
        Glide.with(activity).load(usermodel?.picture?.large).into(binding.userImg)

        binding.llMobileNumber.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + usermodel.phone))
            startActivity(intent)
        }

        binding.llEmail.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:${usermodel.email}"))
            startActivity(Intent.createChooser(intent, "Send Email"))
        }


        binding.btnBack.setOnClickListener {
            onBackPressed()
        }
    }
}