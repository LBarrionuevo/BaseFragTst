package com.barrionuevo.basefragtst.frag

import androidx.core.content.ContextCompat
import com.barrionuevo.basefragtst.R
import com.barrionuevo.basefragtst.databinding.NavegationFragment2Binding
import com.barrionuevo.basefragtst.databinding.NavegationFragmentBinding

class NavegationFragment2 : BaseFragment<NavegationFragment2Binding>() {

    override fun getViewBinding(): NavegationFragment2Binding = NavegationFragment2Binding.inflate(layoutInflater)

    override fun setUpViews() {
        super.setUpViews()
        binding.ivImage.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.ic_baseline_4g_mobiledata_24));
    }

    companion object {
        @JvmStatic
        fun newInstance(
        ) = NavegationFragment2()
    }


}