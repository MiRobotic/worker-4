package com.mirobotic.picworker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.mirobotic.picworker.fragments.*

class MainActivity : AppCompatActivity(), OnActivityInteractionListener {

    companion object {
        const val SCREEN_ADAPTIVE = 0
        const val SCREEN_LOCATE_US = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            showHome()
        }

    }




    override fun showScreen(screen: Int) {

        var fragment: Fragment? = null
        var tag = ""

        when (screen) {

            SCREEN_LOCATE_US -> {
                tag = LocateUsFragment::class.java.simpleName
                fragment = LocateUsFragment()
            }

        }

        if (fragment != null) {

            val ft = supportFragmentManager.beginTransaction()
            ft.add(R.id.fragmentMain, fragment, tag)
            ft.addToBackStack(tag)
            ft.commit()

        }


    }

    override fun showContent(screen: Int) {

        var fragment: Fragment? = null
        var tag = ""

        when (screen) {

            SCREEN_ADAPTIVE -> {
                tag = AdaptiveFragment::class.java.simpleName
                fragment = AdaptiveFragment()
            }

        }

        if (fragment != null) {

            val ft = supportFragmentManager.beginTransaction()
            ft.add(R.id.fragmentContent, fragment, tag)
            ft.addToBackStack(tag)
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

    override fun showBack() {
        onBackPressed()
    }

    override fun showNext() {
        onBackPressed()
    }
}
