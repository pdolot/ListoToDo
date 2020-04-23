package com.dolotdev.listotodo.presentation.page.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dolotdev.listotodo.R
import com.dolotdev.listotodo.base.BaseFragment

class ListToDo : BaseFragment() {
    private val viewModel by lazy { ListToDoViewModel() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.page_list, container, false)
    }
}

