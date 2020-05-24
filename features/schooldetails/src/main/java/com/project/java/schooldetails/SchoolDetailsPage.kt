package com.project.java.schooldetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.project.java.schooldetails.databinding.FragmentSchoolDetailsLayoutBinding
import dagger.android.support.AndroidSupportInjection
import timber.log.Timber

class SchoolDetailsPage: Fragment() {
    private var binding: FragmentSchoolDetailsLayoutBinding?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this.binding = DataBindingUtil.inflate(inflater, R.layout.fragment_school_details_layout, container, false)
        return this.binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val id: String? = arguments?.getString("school_id")
        Timber.e(id)
        super.onViewCreated(view, savedInstanceState)
    }
}