package maze.run.Facebookv2.di.auth

import dagger.Module
import dagger.Provides
import maze.run.Facebookv2.pojo.PostsApi
import javax.inject.Singleton
import retrofit2.Retrofit
@Module
class AuthModule {

    @Provides
    open fun postapi(retrofit:Retrofit) :PostsApi{
        return retrofit.create(PostsApi::class.java
        )
    }
}