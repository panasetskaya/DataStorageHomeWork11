package com.example.datastoragehomework11.presentation

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.datastoragehomework11.data.MainRepositoryImpl
import com.example.datastoragehomework11.domain.*
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class MainViewModel(context: Context): ViewModel() {

    private val repo = MainRepositoryImpl(context)
    private val compositeDisposable = CompositeDisposable()

    private val addEmployeeUseCase = AddEmployeeUseCase(repo)
    private val addPositionUseCase = AddPositionUseCase(repo)
    private val getAllPositionsUseCase = GetAllPositionsUseCase(repo)
    private val getEmployeesByPosition = GetEmployeesByPosition(repo)

    fun addEmployee(employee: Employee) {
        val disposable = Completable.fromRunnable {
            addEmployeeUseCase.invoke(employee)
        }
            .subscribeOn(Schedulers.io())
            .subscribe({
                Log.i("MyRes", "addEmployee complete")
            },{
                Log.i("MyRes", "addEmployee error: $it")
            })
        compositeDisposable.add(disposable)
    }

    fun addPosition(position: Position) {
        val disposable = Completable.fromRunnable {
            addPositionUseCase.invoke(position)
        }
            .subscribeOn(Schedulers.io())
            .subscribe({
                Log.i("MyRes", "addPosition complete")
            },{
                Log.i("MyRes", "addPosition error: $it")
            })
        compositeDisposable.add(disposable)

    }

    fun getEmployees(thisPosition: String): LiveData<List<Employee>> {
        return getEmployeesByPosition.invoke(thisPosition)
    }

    fun getPositions(): LiveData<List<Position>> {
        return getAllPositionsUseCase.invoke()
    }


    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}