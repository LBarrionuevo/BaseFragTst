package com.barrionuevo.basefragtst.frag

import com.barrionuevo.basefragtst.databinding.BottomNavigationControlsBinding


class MyBottomNavigationView(val bottomNavigationView: BottomNavigationControlsBinding) {


    fun addClickListener( mListener: BaseFragment.Companion.OnBaseFragmentInteract){
        bottomNavigationView.btnLeftNav.setOnClickListener {
            mListener.onBtnLeftClickListener()
        }
        bottomNavigationView.btnMenuNav.setOnClickListener {
            mListener.onBtnMenuClickListener()
        }
        bottomNavigationView.btnRightNav.setOnClickListener {
            mListener.onBtnRightClickListener()
        }
    }


}