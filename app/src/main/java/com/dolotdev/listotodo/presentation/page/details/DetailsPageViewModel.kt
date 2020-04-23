package com.dolotdev.listotodo.presentation.page.details

import androidx.lifecycle.MutableLiveData
import com.dolotdev.listotodo.base.BaseViewModel
import com.dolotdev.listotodo.data.database.itemToDo.ItemToDoRepository
import com.dolotdev.listotodo.data.model.ItemToDo
import com.dolotdev.listotodo.di.Injector
import com.dolotdev.listotodo.util.TimeUtil
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class DetailsPageViewModel : BaseViewModel() {

    @Inject
    lateinit var itemToDoRepository: ItemToDoRepository

    var itemId: Long? = null
        set(value) {
            field = value
            field?.let { getItemToDoById(it) }
        }

    val itemToDo = MutableLiveData<ItemToDo?>()
    val timer = MutableLiveData<String>()

    init {
        Injector.component.inject(this)
    }

    private fun getItemToDoById(id: Long) {
        rxDisposer.add(itemToDoRepository.getItemById(id)
            .subscribeBy(
                onSuccess = {
                    itemToDo.postValue(it)
                    startTimer(it)
                },
                onError = {
                    itemToDo.postValue(null)
                }
            ))
    }

    private fun startTimer(item: ItemToDo) {
        timer.postValue(TimeUtil.getElapsedTime(item.creationDate))
        rxDisposer.add(Observable
            .interval(1, TimeUnit.SECONDS)
            .flatMap {
                return@flatMap Observable.create<String> {
                    it.onNext(TimeUtil.getElapsedTime(item.creationDate))
                    it.onComplete()
                }
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                timer.postValue(it)
            })
    }
}