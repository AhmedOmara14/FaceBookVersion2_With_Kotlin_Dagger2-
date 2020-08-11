package maze.run.Facebookv2.ui

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import maze.run.Facebookv2.di.DaggerAppComponent

class BaseApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
         return DaggerAppComponent.builder().applicaion(this).build()
    }
}