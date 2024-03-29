package com.example.baylor_list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.baylor_list.adapter.UsersApapter
import com.example.baylor_list.model.User
import com.example.baylor_list.networking.ApiService
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import android.R.attr.orientation
import androidx.recyclerview.widget.DividerItemDecoration



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        FetchUsers()


    }

    private fun FetchUsers() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(ApiService::class.java)


        api.fetchAllUsers().enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {


                showData(response.body()!!)


            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {

                d("juan", "Failure" + t)

            }


        })
    }

    override fun onResume() {
        super.onResume()

        FetchUsers()
    }


    private fun showData(users: List<User>) {


        recyclerView.apply {


            val dividerItemDecoration = DividerItemDecoration(applicationContext, DividerItemDecoration.VERTICAL)
            recyclerView.addItemDecoration(dividerItemDecoration)

            layoutManager = LinearLayoutManager(this@MainActivity)

            adapter = UsersApapter(users)



        }



    }

}
