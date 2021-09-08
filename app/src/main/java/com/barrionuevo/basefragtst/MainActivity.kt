package com.barrionuevo.basefragtst

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.barrionuevo.basefragtst.databinding.ActivityMainBinding
import com.barrionuevo.basefragtst.extension.showShortToast
import com.barrionuevo.basefragtst.frag.BaseFragment
import com.barrionuevo.basefragtst.frag.MyBottomNavigationView
import com.barrionuevo.basefragtst.frag.NavegationFragment
import com.barrionuevo.basefragtst.frag.NavegationFragment2

class MainActivity : AppCompatActivity(), BaseFragment.Companion.OnBaseFragmentInteract {
    private val fm = supportFragmentManager
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //
        val frag = NavegationFragment.newInstance()
        setFrag(frag, "NavegationFragment")
    }


    private fun <T : Fragment?> setFrag(type: T, sTag: String) {
        if (fm.findFragmentByTag(sTag) == null) {
            val ft = fm.beginTransaction()
            ft.replace(binding.container.id, type as Fragment, sTag)
            ft.addToBackStack(sTag)
            ft.commit()
        }else{
            fm.popBackStack(sTag, 0)
        }
    }

    override fun onBtnLeftClickListener() {
        val frag = NavegationFragment.newInstance()
        setFrag(frag, "NavegationFragment")
    }

    override fun onBtnMenuClickListener() {
        showShortToast("onBtnMenuClickListener")
    }

    override fun onBtnRightClickListener() {
        val frag2 = NavegationFragment2.newInstance()
        setFrag(frag2, "Navegation2Fragment")
    }
}