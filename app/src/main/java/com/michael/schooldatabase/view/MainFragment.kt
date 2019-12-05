package com.michael.schooldatabase.view;

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.michael.schooldatabase.*
import com.michael.schooldatabase.model.RVAdapter
import com.michael.schooldatabase.model.VM
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    companion object { fun newInstance() = MainFragment() }

    private val vm = VM()
    private val RV: RVAdapter by lazy { RVAdapter(context!!) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        vm.buildDatabase(context!!)
        vm.reset()
        rv_part_search.layoutManager = LinearLayoutManager(activity)
        rv_part_search.adapter = RV
        vm.getSearch().observe(viewLifecycleOwner, Observer { grades ->
            RV.grades = grades.data ?: listOf()
            tv_result.setText("Result: " + grades.data?.size + " Grade(s)")
        })
        btn_part_search.setOnClickListener {
            tv_part_search.clearFocus()
            vm.searchSuppliers(tv_part_search.text.trim().toString())
        }
    }
}

