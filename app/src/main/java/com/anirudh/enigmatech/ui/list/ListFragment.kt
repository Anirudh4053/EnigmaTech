package com.anirudh.enigmatech.ui.list

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.anirudh.enigmatech.HomeActivity
import com.anirudh.enigmatech.R
import com.anirudh.enigmatech.data.NEW_CODE
import com.anirudh.enigmatech.data.model.User
import com.anirudh.enigmatech.ui.detail.DetailActivity
import io.realm.Realm
import kotlinx.android.synthetic.main.fragment_list.view.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance

class ListFragment : Fragment(), KodeinAware {
    private val TAG = HomeActivity::class.java.simpleName
    private lateinit var adapter: DashAdapter
    private lateinit var dashboardViewModel: ListViewModel
    private lateinit var activityVal: HomeActivity
    private val itemList = arrayListOf<User>()
    private lateinit var realm: Realm
    override val kodein by kodein()
    private val factory by instance<ListViewModelFactory>()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        //dashboardViewModel = ViewModelProvider(this).get(ListViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_list, container, false)
        dashboardViewModel = ViewModelProvider(this,factory).get(ListViewModel::class.java)
        //val textView: TextView = root.findViewById(R.id.text_dashboard)
        activityVal = (activity as HomeActivity)
        root.apply {
            this.fabAddBtn.setOnClickListener {
                val i = Intent(activityVal,DetailActivity::class.java)
                startActivityForResult(i,NEW_CODE)
            }
            recyclerView.layoutManager = LinearLayoutManager(activityVal)
            adapter = DashAdapter(activityVal,itemList) {
                println("All list clicked")
            }
            recyclerView.adapter = adapter
            dashboardViewModel.readData()
            dashboardViewModel.userList.observe(activityVal, {
                itemList.addAll(it)
                adapter.notifyDataSetChanged()
            })
        }
        return root
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            if(requestCode == NEW_CODE) {
                if (data != null) {
                    val refresh = data.getBooleanExtra("refresh",false)
                    if(refresh){
                        itemList.clear()
                        dashboardViewModel.readData()
                    }
                }
            }
        }
    }


}