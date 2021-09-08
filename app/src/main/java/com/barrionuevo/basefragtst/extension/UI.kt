package com.barrionuevo.basefragtst.extension

import android.content.Context
import android.widget.Toast
import android.widget.Toast.makeText

fun Context.showShortToast(msg:String){
    makeText(this, msg,  Toast.LENGTH_SHORT).show()
}

