package com.example.datastoragehomework11.presentation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.datastoragehomework11.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.*

class PositionsFragment : Fragment() {

    private lateinit var disposable: Disposable
    private lateinit var viewModel: MainViewModel
    private lateinit var recyclerViewPositions: RecyclerView
    private lateinit var positionListAdapter: PositionListAdapter
    private lateinit var button: FloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_positions, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button = view.findViewById(R.id.floatingActionButtonAddPosition)
        button.setOnClickListener {
            Toast.makeText(it.context, "Not yet implemented", Toast.LENGTH_SHORT).show()
        }
        recyclerViewPositions = view.findViewById(R.id.RVPositions)
        viewModel = ViewModelProvider(this, MainViewModelFactory(this.context!!)).get(MainViewModel::class.java)
        positionListAdapter = PositionListAdapter()
        disposable = viewModel.getPositions()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                positionListAdapter.submitList(it)
            },{
                Log.i("MyRes", "viewModel error in Positions fragment: $it")
            })
        recyclerViewPositions.adapter = positionListAdapter
        positionListAdapter.onPositionItemClickListener = {
            Toast.makeText(view.context, "Тут сейчас будет переход", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        if (this::disposable.isInitialized && !disposable.isDisposed)
            disposable.dispose()
        super.onDestroyView()
    }
}