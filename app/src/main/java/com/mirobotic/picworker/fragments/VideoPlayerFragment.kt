package com.mirobotic.picworker.fragments


import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.VideoView

import com.mirobotic.picworker.R
import kotlinx.android.synthetic.main.fragment_video_player.*

/**
 * A simple [Fragment] subclass.
 */
class VideoPlayerFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_video_player, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val uri = Uri.parse("android.resource://"+context?.packageName+"/"+R.raw.intro)

        videoPlayer.setVideoURI(uri)
        videoPlayer.setOnPreparedListener {

            it.isLooping = true
            it.setVolume(0f,0f)
        }

    }

    override fun onResume() {
        super.onResume()
        videoPlayer.start()
    }

    override fun onPause() {
        super.onPause()
        videoPlayer.pause()
    }


}