package com.dolotdev.listotodo.presentation.page.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.dolotdev.listotodo.R
import com.dolotdev.listotodo.base.BaseFragment
import com.dolotdev.listotodo.data.model.ItemToDo
import kotlinx.android.synthetic.main.page_details.*

class DetailsPage : BaseFragment() {

    private val viewModel by lazy { DetailsPageViewModel() }
    private val args: DetailsPageArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.page_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.itemId = args.itemId

        viewModel.itemToDo.observe(viewLifecycleOwner, Observer {
            if (it == null) {
                findNavController().popBackStack()
            } else {
                bindData(it)
            }
        })

        viewModel.timer.observe(viewLifecycleOwner, Observer {
            timer.text = it
        })
    }

    private fun bindData(item: ItemToDo) {
        name.text = item.name
        itemId.text = item.id.toString()
    }

    override fun onDestroyView() {
        viewModel.rxDisposer.dispose()
        super.onDestroyView()
    }
}

