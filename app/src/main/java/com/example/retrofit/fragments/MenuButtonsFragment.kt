package com.example.retrofit.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit.AllocationActivity
import com.example.retrofit.CourseActivity
import com.example.retrofit.DepartmentActivity
import com.example.retrofit.MainActivity
import com.example.retrofit.ProfessorActivity
import com.example.retrofit.R
import com.example.retrofit.adapters.MenuButtonsAdapter
import com.example.retrofit.listeners.MenuButtonsClickListener
import com.example.retrofit.model.MenuButton

class MenuButtonsFragment : Fragment(), MenuButtonsClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu_buttons, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val menuRecyclerView : RecyclerView = view.findViewById(R.id.rvMenuList)
        menuRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        val menuButtonsList = listOf(
            MenuButton("Home", R.drawable.ic_home_menu_foreground),
            MenuButton("Professor", R.drawable.ic_professor_menu_foreground),
            MenuButton("Course", R.drawable.ic_course_menu_foreground),
            MenuButton("Department", R.drawable.ic_department_menu_foreground),
            MenuButton("Allocation", R.drawable.ic_allocation_menu_foreground)
        )

        val adapter = MenuButtonsAdapter(menuButtonsList, this)
        menuRecyclerView.adapter = adapter
    }

    override fun loadActivity(position: Int) {
        val intent = when(position) {
            0 -> Intent(requireContext(), MainActivity::class.java)
            1 -> Intent(requireContext(), ProfessorActivity::class.java)
            2 -> Intent(requireContext(), CourseActivity::class.java)
            3 -> Intent(requireContext(), DepartmentActivity::class.java)
            4 -> Intent(requireContext(), AllocationActivity::class.java)
            else -> null
        }

        intent?.let { startActivity(it) }
    }


}