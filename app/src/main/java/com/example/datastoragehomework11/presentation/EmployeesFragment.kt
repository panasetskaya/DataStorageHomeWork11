package com.example.datastoragehomework11.presentation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView
import com.example.datastoragehomework11.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

class EmployeesFragment : Fragment() {

    private lateinit var disposable: Disposable
    private lateinit var viewModel: MainViewModel
    private lateinit var recyclerViewEmployees: RecyclerView
    private lateinit var employeeListAdapter: EmployeeListAdapter
    private lateinit var button: FloatingActionButton

    private lateinit var pBar: ProgressBar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_employees, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pBar = view.findViewById(R.id.progressBarEmployees)
        button = view.findViewById(R.id.floatingActionButtonAddEmployee)
        button.setOnClickListener {
            Toast.makeText(it.context, "Not yet implemented", Toast.LENGTH_SHORT).show()
        }
        recyclerViewEmployees = view.findViewById(R.id.RVEmployees)
        viewModel = ViewModelProvider(this, MainViewModelFactory(this.context!!)).get(MainViewModel::class.java)
        employeeListAdapter = EmployeeListAdapter()
        val position = EmployeesFragmentArgs.fromBundle(arguments!!).position
        disposable = viewModel.getEmployees(position)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                employeeListAdapter.submitList(it)
                pBar.visibility = View.GONE
            },{
                Log.i("MyRes", "viewModel error in Employees fragment: $it")
            })
        recyclerViewEmployees.adapter = employeeListAdapter
    }

    override fun onDestroyView() {
        if (this::disposable.isInitialized && !disposable.isDisposed)
            disposable.dispose()
        super.onDestroyView()
    }
}