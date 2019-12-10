package com.gosigitgo.thirdcodelabmovie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gosigitgo.thirdcodelabmovie.fragment.MovieFragment
import com.gosigitgo.thirdcodelabmovie.fragment.TvFragment
import kotlinx.android.synthetic.main.bottom_nav.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //menempelkan menu
        nav_menu.setOnNavigationItemSelectedListener {
            when (it.itemId){
                R.id.action_movie -> {
                    transactionMovieFragment(savedInstanceState)
                }
                R.id.action_tv -> {
                    transactionTvFragment(savedInstanceState)
                }
            }
            true
        }
        nav_menu.selectedItemId = R.id.action_tv
    }
    private fun transactionMovieFragment (savedInstanceState: Bundle?){
        if (savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                .replace(R.id.fm_main,
                    MovieFragment(), MovieFragment::class.java.simpleName)
                .commit()

        }
    }
    private fun transactionTvFragment (savedInstanceState: Bundle?){
        if (savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                .replace(R.id.fm_main,
                    TvFragment(), TvFragment::class.java.simpleName)
                .commit()

        }
    }
}
