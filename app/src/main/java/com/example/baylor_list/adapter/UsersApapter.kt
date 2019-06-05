package com.example.baylor_list.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.baylor_list.R
import com.example.baylor_list.detail
import com.example.baylor_list.model.User
import kotlinx.android.synthetic.main.user_row.view.*

class UsersApapter(private val users: List<User>) : RecyclerView.Adapter<UsersApapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_row,parent,false)

        return ViewHolder(view)

    }

    override fun getItemCount() = users.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val user = users[position]
        holder.firstName.text = user.name
        holder.email.text =user.email

        holder?.user = user

    }


    class ViewHolder(itemView: View , var user: User?=null) : RecyclerView.ViewHolder(itemView) {

        val firstName: TextView = itemView.firstName
        val email: TextView = itemView.email



        init {
            itemView.setOnClickListener {

               val intent = Intent(itemView.context,detail::class.java)

                intent.putExtra("Name", user?.name)
                intent.putExtra("Username",user?.username)
                intent.putExtra("Phone",user?.phone)
                intent.putExtra("Website",user?.website)
                intent.putExtra("Email",user?.email)
                intent.putExtra("Street", user?.address?.street.toString())
                intent.putExtra("Suite",user?.address?.suite.toString())
                intent.putExtra("City",user?.address?.city.toString())
                intent.putExtra("Zip",user?.address?.zipcode.toString())
                intent.putExtra("Company", user?.company?.name.toString())

                itemView.context.startActivity(intent)
            }
        }

    }



}
