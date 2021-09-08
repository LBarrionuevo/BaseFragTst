package com.barrionuevo.basefragtst.frag

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.barrionuevo.basefragtst.MainActivity
import com.barrionuevo.basefragtst.R
import com.barrionuevo.basefragtst.databinding.NavegationFragmentBinding


class NavegationFragment : BaseFragment<NavegationFragmentBinding>() {


    override fun getViewBinding(): NavegationFragmentBinding  = NavegationFragmentBinding.inflate(layoutInflater)



    override fun setUpViews() {
        super.setUpViews()
        binding.ivImage.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.ic_baseline_4g_plus_mobiledata_24));
    }
    companion object {
        @JvmStatic
        fun newInstance(
        ) = NavegationFragment()
    }


}