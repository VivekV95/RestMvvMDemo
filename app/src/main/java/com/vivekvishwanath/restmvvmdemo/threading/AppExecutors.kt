package com.vivekvishwanath.restmvvmdemo.threading

import java.util.concurrent.Executors

class AppExecutors {

    val mNetworkIO = Executors.newScheduledThreadPool(3)

    companion object {
        var instance: AppExecutors? = null
        private set
        get() {
            if (field == null) instance = AppExecutors()
            return field
        }
    }
}