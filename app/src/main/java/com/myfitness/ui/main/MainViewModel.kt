package com.myfitness.ui.main

import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.myfitness.service.AppDelegate
import com.myfitness.service.model.UserModel
import com.myfitness.ui.base.BaseViewModel
import kotlinx.coroutines.launch
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : BaseViewModel() {

    val userModel = MutableLiveData<UserModel>()
    val progress = MutableLiveData<Boolean>()

    fun getUsers(appDelegate: AppDelegate, page: Int) {
        progress.postValue(true)
        ioScope.launch {
            appDelegate.apiInterface.getUserData(page).enqueue(object : Callback<ResponseBody> {
                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>
                ) {
                    progress.postValue(false)
                    if (response.isSuccessful) {
                        response.body()?.let {
                            val res = it.string()
                            val model = Gson().fromJson(res, UserModel::class.java)
                            userModel.postValue(model)
                        }
                    }
                }

                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    progress.postValue(false)
                }

            })
        }
    }
}