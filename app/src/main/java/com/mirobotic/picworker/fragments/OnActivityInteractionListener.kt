package com.mirobotic.picworker.fragments

interface OnActivityInteractionListener {

    fun showScreen(screen: Int)

    fun showContent(screen: Int)

    fun showBack(screen: Int)

    fun showWorker()

    fun showHome()

}