package maze.run.Facebookv2.di.auth

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import maze.run.Facebookv2.di.viewmodelkey.viewmodelkey
import maze.run.Facebookv2.ui.ViewModels.authviewModel.authviewModel


@Module
abstract class authviewModelModul {

    @Binds
    @IntoMap
    @viewmodelkey(authviewModel::class)


    abstract fun bindAuthViewModel(viewModel: authviewModel?): ViewModel?


}