package com.dolotdev.listotodo.presentation.page.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.dolotdev.listotodo.R
import com.dolotdev.listotodo.base.BaseFragment
import com.dolotdev.listotodo.data.model.EmptyData
import kotlinx.android.synthetic.main.page_list.*

class ListToDoPage : BaseFragment() {

    private val viewModel by lazy { ListToDoPageViewModel() }
    private val adapter by lazy { ItemListAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.page_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setAdapter()
        setListeners()

        viewModel.itemToDoRepository.getAll().observe(viewLifecycleOwner, Observer {
            adapter.setData(if (it.isNotEmpty()) it else listOf(EmptyData()))
        })
    }

    private fun setListeners() {
        addItem.setOnClickListener {
            recyclerView.smoothScrollToPosition(0)
            viewModel.addItem()
        }

        adapter.onDeleteItemClickListener = {
            viewModel.deleteItem(it)
        }

        adapter.onItemClickListener = ::navigateToDetails
    }

    private fun setAdapter() {
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = this@ListToDoPage.adapter
        }
    }

    private fun navigateToDetails(id: Long) {
        viewModel.incrementClickCounter(id)
        findNavController().navigate(ListToDoPageDirections.toDetailsPage(id))
    }

}

