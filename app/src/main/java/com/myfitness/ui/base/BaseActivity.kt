package com.myfitness.ui.base

import androidx.appcompat.app.AppCompatActivity
import com.myfitness.service.AppDelegate

abstract class BaseActivity : AppCompatActivity() {

    val activity by lazy { this }
    val appDelegate by lazy { application as AppDelegate }
}