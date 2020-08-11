package maze.run.Facebookv2.ui.ViewModels.authviewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import maze.run.Facebookv2.pojo.Posts
import maze.run.Facebookv2.pojo.PostsApi
import javax.inject.Inject


class authviewModel : ViewModel {
    lateinit var postsApi:PostsApi
     var list_posts :MutableLiveData<List<Posts>> = MutableLiveData<List<Posts>>()

    @Inject constructor(
        postsApi: PostsApi){
        this.postsApi=postsApi
        if (postsApi==null){
            Log.d(TAG, "api is null: ")
        }
        else{
            Log.d(TAG, "api not: ")
        }
    }

    suspend fun getposts():MutableLiveData<List<Posts>>{


        viewModelScope.launch(Dispatchers.Main) {

            val responce=postsApi.getposts()
            val items: List<Posts>? = responce.body()
            list_posts.value=items

        }


        return withContext(Dispatchers.IO){
            list_posts
        }
    }

    companion object {
        private const val TAG = "authviewModel"
    }
}