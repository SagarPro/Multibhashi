package sagsaguz.multibhashi.network

import android.content.Context
import android.net.ConnectivityManager

object Network {

    fun isInternetAvaialble(context: Context?): Boolean {
        val connectivityManager = context!!.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }

}