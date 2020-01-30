package com.mirobotic.picworker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.mirobotic.picworker.fragments.*


class MainActivity : AppCompatActivity(), OnActivityInteractionListener {


    companion object {
        const val SCREEN_HOME = 1
        const val SCREEN_ADAPTIVE = 2
        const val SCREEN_LOCATE_US = 3
        const val SCREEN_TECHNOLOGY = 4
        const val SCREEN_TECHNICAL = 5
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            showHome()
        }

    }

    override fun showContent(screen: Int) {

        var fragment: Fragment? = null
        var tag = ""

        when (screen) {

            SCREEN_HOME -> {
                tag = HomeFragment::class.java.simpleName
                fragment = HomeFragment()
            }
            SCREEN_ADAPTIVE -> {
                tag = AdaptiveFragment::class.java.simpleName
                fragment = AdaptiveFragment()
            }
            SCREEN_LOCATE_US -> {
                tag = LocateUsFragment::class.java.simpleName
                fragment = LocateUsFragment()
            }
            SCREEN_TECHNICAL -> {
                tag = TechnicalFragment::class.java.simpleName
                fragment = TechnicalFragment()
            }
            SCREEN_TECHNOLOGY -> {
                tag = TechnologyFragment::class.java.simpleName
                fragment = TechnologyFragment()
            }

        }

        Log.e("showContent","tag = $tag | $screen")

        if (fragment != null) {
            val ft = supportFragmentManager.beginTransaction()
            ft.replace(R.id.fragmentContent, fragment, tag)
            ft.commit()
        }


    }

    override fun showHome() {

        val fm = supportFragmentManager

        val fragment = fm.findFragmentById(R.id.fragmentMain)
        var ft = fm.beginTransaction()

        if (fragment != null) {
            ft.remove(fragment)
        }
        ft.commit()

        ft = fm.beginTransaction()
        ft.replace(R.id.fragmentContent, HomeFragment(), HomeFragment::class.java.simpleName)
        ft.commit()

        ft = fm.beginTransaction()
        ft.replace(R.id.fragmentVideo, VideoPlayerFragment(), VideoPlayerFragment::class.java.simpleName)
        ft.commit()

    }

    override fun onBackPressed() {

        val fragment = supportFragmentManager.findFragmentById(R.id.fragmentContent)

        if (fragment != null && fragment.tag != null) {

            when(fragment.tag) {

                HomeFragment::class.java.simpleName -> {
                    super.onBackPressed()
                }
                AdaptiveFragment::class.java.simpleName -> {
                    showContent(SCREEN_HOME)
                }
                TechnologyFragment::class.java.simpleName -> {
                    showContent(SCREEN_ADAPTIVE)
                }
                TechnicalFragment::class.java.simpleName -> {
                    showContent(SCREEN_TECHNOLOGY)
                }
                LocateUsFragment::class.java.simpleName -> {
                    showContent(SCREEN_TECHNICAL)
                }
            }


        }

    }

    override fun showWorker() {

        startActivity(Intent(this, WorkerActivity::class.java))

    }
}
