package maze.run.Facebookv2.di.auth

import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import maze.run.Facebookv2.ui.auth.AuthActivity
import javax.inject.Singleton


@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(
        modules = [
              authviewModelModul::class,
              AuthModule::class
        ]
    )
    abstract fun authactivity() :AuthActivity



}