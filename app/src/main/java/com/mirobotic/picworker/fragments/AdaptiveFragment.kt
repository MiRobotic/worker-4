package com.mirobotic.picworker.fragments


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mirobotic.picworker.MainActivity

import com.mirobotic.picworker.R
import kotlinx.android.synthetic.main.fragment_adaptive.*

/**
 * A simple [Fragment] subclass.
 */
class AdaptiveFragment : Fragment() {

    private lateinit var onActivityInteractionListener: OnActivityInteractionListener

    override fun onAttach(context: Context) {
        super.onAttach(context)

        onActivityInteractionListener = context as OnActivityInteractionListener
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_adaptive, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnHome.setOnClickListener {
            onActivityInteractionListener.showHome()
        }

        btnBack.setOnClickListener {
            onActivityInteractionListener.showBack()
        }

        btnNext.setOnClickListener {
            onActivityInteractionListener.showContent(MainActivity.SCREEN_TECHNOLOGY)
        }

    }

}
