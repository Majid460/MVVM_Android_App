package com.example.mvvmapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmapp.R
import com.example.mvvmapp.Repository.Model.UserDatabase
import com.example.mvvmapp.Repository.UserRepository
import com.example.mvvmapp.ViewModel.UserViewModel
import com.example.mvvmapp.ViewModel.ViewModelFactory
import com.example.mvvmapp.databinding.ActivityViewUserBinding

class ViewUserActivity : AppCompatActivity() {
    private lateinit var binding: ActivityViewUserBinding
    private lateinit var viewModel: UserViewModel
    private var repository:UserRepository? = null
    private val database by lazy{ UserDatabase.getDatabase(this)?.userdao()}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityViewUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        repository = database?.let { UserRepository(it) }
        viewModel = ViewModelProvider(this, ViewModelFactory(repository)).get(UserViewModel::class.java)
        showData()
    }


    fun showData(){
        var  listView=binding.LVOne
        val list: ArrayList<String> = ArrayList()
        lateinit var arrayAdapter: ArrayAdapter<String>
        viewModel.getdata()?.forEach {
            list.add(it.id.toString()+ "   " + it.name+ "     "+it.city)
        }
        arrayAdapter = ArrayAdapter(this, R.layout.list_text, list)
        arrayAdapter.notifyDataSetChanged()
        listView.adapter = arrayAdapter
    }

    fun findDataById(view: View) {
        var  listView=binding.LVOne
        val editText=binding.ETThree
        val text1=editText.text.toString().toInt()
        val list: ArrayList<String> = ArrayList()
        lateinit var arrayAdapter: ArrayAdapter<String>
        viewModel.getById(text1)?.forEach {
            list.add(it.id.toString()+"   "+it.name+"      "+it.city)
        }
        arrayAdapter = ArrayAdapter(this, R.layout.list_text, list)
        arrayAdapter.notifyDataSetChanged()
        listView.adapter = arrayAdapter
    }
    fun findDataByCity(view:View) {
        var  listView=binding.LVOne
        val editText=binding.ETThree
        val text1=editText.text.toString()
        val list: ArrayList<String> = ArrayList()
        lateinit var arrayAdapter: ArrayAdapter<String>
        viewModel.getByCity(text1)?.forEach {
            list.add(it.id.toString()+"   "+it.name+"      "+it.city)
        }
        arrayAdapter = ArrayAdapter(this, R.layout.list_text, list)
        arrayAdapter.notifyDataSetChanged()
        listView.adapter = arrayAdapter
    }
    fun findDataByName(view:View) {
        var  listView=binding.LVOne
        val editText=binding.ETThree
        val text1=editText.text.toString()
        val list: ArrayList<String> = ArrayList()
        lateinit var arrayAdapter: ArrayAdapter<String>
        viewModel.getByName(text1)?.forEach {
            list.add(it.id.toString()+"   "+it.name+"      "+it.city)
        }
        arrayAdapter = ArrayAdapter(this, R.layout.list_text, list)
        arrayAdapter.notifyDataSetChanged()
        listView.adapter = arrayAdapter
    }
    fun deleteById() {

        val editText=binding.ETThree
        val text1=editText.text.toString().toInt()
        viewModel.deleteId(text1)
        showData()
    }
}