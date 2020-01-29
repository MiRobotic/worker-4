package com.mirobotic.picworker.fragments


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mirobotic.picworker.MainActivity
import com.mirobotic.picworker.MainActivity.Companion.BACK

import com.mirobotic.picworker.R
import com.mirobotic.picworker.SkillDialog
import kotlinx.android.synthetic.main.fragment_adaptive.*
import kotlinx.android.synthetic.main.fragment_adaptive.btnBack
import kotlinx.android.synthetic.main.fragment_adaptive.btnHome
import kotlinx.android.synthetic.main.fragment_adaptive.btnNext
import kotlinx.android.synthetic.main.fragment_technology.*

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
            onActivityInteractionListener.showBack(BACK)
        }

        btnNext.setOnClickListener {
            onActivityInteractionListener.showContent(MainActivity.SCREEN_TECHNOLOGY)
        }

        viewLeadership.setOnClickListener {
            SkillDialog(context!!,
                "\"Leadership Excellence\"",
                "Thank you for your interest!" +
                    "Approach our Course Consultant to enquire more on the course & redeem a special gift from us.").show()
        }

        viewBusinessExcellence.setOnClickListener {
            SkillDialog(context!!,
                "\"Business Excellence\"",
                "Thank you for your interest! " +
                    "Approach our Course Consultant to enquire more on the course & redeem a special gift from us.").show()
        }

        viewPersonal.setOnClickListener {
            SkillDialog(context!!,
                "\"Personal Effectiveness\"",
                "Thank you for your interest! " +
                    "Approach our Course Consultant to enquire more on the course & redeem a special gift from us.").show()
        }
        viewCommunityCare.setOnClickListener {
            SkillDialog(context!!,
                "\"Personal Effectiveness\"",
                "Thank you for your interest!" +
                    " Approach our Course Consultant to enquire more on the course & redeem a special gift from us.").show()
        }
        viewCustomer.setOnClickListener {
            SkillDialog(context!!,
                "\"Customer Excellence\"",
                "Thank you for your interest! " +
                    "Approach our Course Consultant to enquire more on the course & redeem a special gift from us.").show()
        }

    }

}
