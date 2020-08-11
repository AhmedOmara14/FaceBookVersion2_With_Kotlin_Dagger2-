package maze.run.Facebookv2.ui.auth

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_auth.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import maze.run.Facebookv2.R
import maze.run.Facebookv2.ui.ViewModels.ViewModelProviderFactory
import maze.run.Facebookv2.ui.ViewModels.authviewModel.authviewModel
import maze.run.Facebookv2.ui.adapter.Adapter
import javax.inject.Inject

class AuthActivity : DaggerAppCompatActivity() {


    @Inject
    lateinit var viewModelProviderFactory: ViewModelProviderFactory

    lateinit var authviewModel: authviewModel
    var i: Int = 0

    lateinit var adapter: Adapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        recycler.setLayoutManager(
            LinearLayoutManager(
                this,
                LinearLayoutManager.VERTICAL,
                false
            )
        )
        authviewModel = ViewModelProviders.of(this, viewModelProviderFactory)
            .get(maze.run.Facebookv2.ui.ViewModels.authviewModel.authviewModel::class.java)

        Log.d(TAG, "onCreate:"+ authviewModel)

        GlobalScope.launch(Dispatchers.Main) {
            authviewModel.getposts().observe(this@AuthActivity, Observer { posts ->
               adapter = Adapter(this@AuthActivity)
                adapter.setlist(posts)
               recycler.adapter = adapter
            })
        }

    }

    companion object {
        private const val TAG = "AuthActivity"
    }
}