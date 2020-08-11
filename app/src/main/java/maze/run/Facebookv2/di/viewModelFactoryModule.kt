package maze.run.Facebookv2.di

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.BindsInstance
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import maze.run.Facebookv2.ui.ViewModels.ViewModelProviderFactory
import javax.inject.Singleton


@Module
abstract class viewModelFactoryModule {
    @Binds
    abstract fun factory(viewModelProviderFactory: ViewModelProviderFactory?): ViewModelProvider.Factory?
}
