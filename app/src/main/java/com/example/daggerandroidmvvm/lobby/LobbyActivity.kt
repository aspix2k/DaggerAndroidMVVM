package com.example.daggerandroidmvvm.lobby

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.example.daggerandroidmvvm.R
import com.example.daggerandroidmvvm.common.viewmodel.Response
import com.example.daggerandroidmvvm.common.viewmodel.Status
import dagger.android.AndroidInjection
import timber.log.Timber
import javax.inject.Inject

class LobbyActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: LobbyViewModelFactory

    @BindView(R.id.greeting_textview)
    lateinit var greetingTextView: TextView

    @BindView(R.id.loading_indicator)
    lateinit var loadingIndicator: ProgressBar

    private var viewModel: LobbyViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lobby_activity)

        ButterKnife.bind(this)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(LobbyViewModel::class.java)

        viewModel!!.response().observe(this, Observer<Response> { processResponse(it) })
    }

    @OnClick(R.id.common_greeting_button)
    fun onCommonGreetingButtonClicked() {
        viewModel!!.loadCommonGreeting()
    }

    @OnClick(R.id.lobby_greeting_button)
    fun onLobbyGreetingButtonClicked() {
        viewModel!!.loadLobbyGreeting()
    }

    private fun processResponse(response: Response) {
        when (response.status) {
            Status.LOADING -> renderLoadingState()

            Status.SUCCESS -> renderDataState(response.data)

            Status.ERROR -> renderErrorState(response.error)
        }
    }

    private fun renderLoadingState() {
        greetingTextView.visibility = View.GONE
        loadingIndicator.visibility = View.VISIBLE
    }

    private fun renderDataState(greeting: String?) {
        loadingIndicator.visibility = View.GONE
        greetingTextView.visibility = View.VISIBLE
        greetingTextView.text = greeting
    }

    private fun renderErrorState(throwable: Throwable?) {
        Timber.e(throwable)
        loadingIndicator.visibility = View.GONE
        greetingTextView.visibility = View.GONE
        Toast.makeText(this, R.string.greeting_error, Toast.LENGTH_SHORT).show()
    }
}
