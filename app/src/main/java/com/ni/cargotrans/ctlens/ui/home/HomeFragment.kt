package com.ni.cargotrans.ctlens.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.ni.cargotrans.ctlens.databinding.FragmentHomeBinding
import com.ni.cargotrans.ctlens.scanner.LensActivity

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _fragmentHomeBinding: FragmentHomeBinding? = null
    private val fragmentHomeBinding get() = _fragmentHomeBinding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)
        _fragmentHomeBinding = FragmentHomeBinding.inflate(
            inflater,
            container,
            false
        )

        return fragmentHomeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        fragmentHomeBinding.fragmentHomeScanbtn.setOnClickListener {
            val lensIntent = Intent(activity, LensActivity::class.java)
            startActivity(lensIntent)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _fragmentHomeBinding = null
    }
}