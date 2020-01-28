package com.mirobotic.picworker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.mirobotic.picworker.fragments.*
import org.greenrobot.eventbus.EventBus
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T



class MainActivity : AppCompatActivity(), OnActivityInteractionListener {


    companion object {
        const val SCREEN_WORKER= 0
        const val SCREEN_ADAPTIVE = 1
        const val SCREEN_LOCATE_US = 2
        const val SCREEN_TECHNOLOGY = 3
        const val SCREEN_TECHNICAL = 4
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

            SCREEN_WORKER -> {
                tag = WorkerFragment::class.java.simpleName
                fragment = WorkerFragment()
            }

        }

        if (fragment != null) {

            EventBus.getDefault().post(false)

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

        if (fragment != null) {

            EventBus.getDefault().post(true)

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
