package maze.run.Facebookv2.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import maze.run.Facebookv2.di.auth.ActivityBuilderModule
import maze.run.Facebookv2.di.auth.authviewModelModul
import maze.run.Facebookv2.ui.BaseApplication
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivityBuilderModule::class,
        AppModule::class,
        viewModelFactoryModule::class

    ]
)
interface AppComponent : AndroidInjector<BaseApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun applicaion(application: Application): Builder
        fun build(): AppComponent
    }
}