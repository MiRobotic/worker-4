package com.mirobotic.picworker.fragments

interface OnActivityInteractionListener {

    fun showScreen(screen: Int)

    fun showContent(screen: Int)

    fun showBack()

    fun showWorker()

    fun showHome()

}