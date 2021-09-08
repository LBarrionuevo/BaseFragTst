package com.barrionuevo.basefragtst.frag

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.barrionuevo.basefragtst.MainActivity
import com.barrionuevo.basefragtst.databinding.BottomNavigationControlsBinding
import com.barrionuevo.basefragtst.databinding.NavegationFragment2Binding
import com.barrionuevo.basefragtst.databinding.NavegationFragmentBinding

abstract class BaseFragment<VBinding : ViewBinding> : Fragment() {

    protected lateinit var binding: VBinding
    protected abstract fun getViewBinding(): VBinding

    //
    protected var _mListener: BaseFragment.Companion.OnBaseFragmentInteract? = null
    protected val mListener get() = _mListener!!
    //

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        binding = getViewBinding()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        when (binding) {
            is NavegationFragmentBinding -> {
                (binding as NavegationFragmentBinding).apply {
                    setBtnListeners(this.include)
                }
            }
            is NavegationFragment2Binding -> {
                (binding as NavegationFragment2Binding).apply {
                    setBtnListeners(this.include)
                }
            }
        }

        setUpViews()
    }

    private fun setBtnListeners(include: BottomNavigationControlsBinding) {
        include.btnLeftNav.setOnClickListener {
            mListener.onBtnLeftClickListener()
        }
        include.btnMenuNav.setOnClickListener {
            mListener.onBtnMenuClickListener()
        }
        include.btnRightNav.setOnClickListener {
            mListener.onBtnRightClickListener()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is MainActivity) {
            _mListener = context
        } else {
            throw RuntimeException(
                context.toString()
                        + " must implement OnListFragmentInteractionListener"
            )
        }
    }

    open fun setUpViews() {}


    override fun onDestroyView() {
        super.onDestroyView()
    }

    companion object{
        interface OnBaseFragmentInteract{
            fun onBtnLeftClickListener()
            fun onBtnMenuClickListener()
            fun onBtnRightClickListener()
        }
    }
}