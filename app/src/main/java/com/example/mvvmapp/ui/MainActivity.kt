package com.example.mvvmapp.ui


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmapp.R
import com.example.mvvmapp.Repository.Model.User
import com.example.mvvmapp.Repository.Model.UserDatabase
import com.example.mvvmapp.Repository.UserRepository
import com.example.mvvmapp.ViewModel.UserViewModel
import com.example.mvvmapp.ViewModel.ViewModelFactory
import com.example.mvvmapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel:UserViewModel
    private var repository:UserRepository? = null
    private val database by lazy{UserDatabase.getDatabase(this)?.userdao()}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
       repository = database?.let { UserRepository(it) }
        viewModel = ViewModelProvider(this, ViewModelFactory(repository)).get(UserViewModel::class.java)
          show_data()


        binding.BtOne.setOnClickListener {
            val name = binding.ETOne.text.toString()
            val city = binding.ETTwo.text.toString()
            val id = binding.ETId.text.toString().toInt()
            val newUser = User(id, name, city)
            viewModel.insertAll(newUser)
            show_data()

        }
        binding.BtTwo.setOnClickListener {
            val intent = Intent(this, ViewUserActivity::class.java)
            startActivity(intent)
        }


    }
    fun show_data(){
        val listView = binding.LVOne
        val list: ArrayList<String> = ArrayList()
        lateinit var arrayAdapter: ArrayAdapter<String>
        viewModel.getdata()?.forEach {
            list.add(it.id.toString() + "   " + it.name.toString()+ "  "+it.city)
        }
        arrayAdapter = ArrayAdapter(this, R.layout.list_text, list)
        arrayAdapter.notifyDataSetChanged()
        listView.adapter = arrayAdapter
    }
}