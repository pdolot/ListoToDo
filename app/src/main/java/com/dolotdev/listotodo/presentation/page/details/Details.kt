package com.dolotdev.listotodo.presentation.page.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dolotdev.listotodo.R
import com.dolotdev.listotodo.base.BaseFragment

class Details : BaseFragment() {
    private val viewModel by lazy { DetailsViewModel() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.page_details, container, false)
    }
}

