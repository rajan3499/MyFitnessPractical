package com.myfitness.ui.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel

abstract class BaseViewModel : ViewModel() {

    private val job = SupervisorJob()
    protected val uiScope by lazy { CoroutineScope(Dispatchers.Main + job) }
    protected val ioScope by lazy { CoroutineScope(Dispatchers.IO + job) }

    override fun onCleared() {
        super.onCleared()
        uiScope.cancel()
        ioScope.cancel()
    }
}
