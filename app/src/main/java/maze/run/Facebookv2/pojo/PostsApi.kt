package maze.run.Facebookv2.pojo

import retrofit2.Response
import retrofit2.http.GET

interface PostsApi {
    @GET("posts")
    suspend fun getposts(): Response<List<Posts>>
}