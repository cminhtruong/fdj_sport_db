package app.el_even.fdj.framework

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class FDJApplication: Application() {

    override fun onCreate() {
        super.onCreate()
    }
}