package lazycoder21.droid.broadcastreceiver

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import lazycoder21.droid.broadcastreceiver.CustomReceiver.Companion.ACTION_CUSTOM_BROADCAST

class MainActivity : AppCompatActivity() {

    private val customReceiver = CustomReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    //region local broadcast manager
    private fun sendCustomLocalBroadcast() {
        val customBroadcastIntent = Intent(ACTION_CUSTOM_BROADCAST)
        LocalBroadcastManager.getInstance(this).sendBroadcast(customBroadcastIntent)

    }

    private fun registerLocalBroadCastReceiver() {
        LocalBroadcastManager.getInstance(this)
            .registerReceiver(customReceiver, IntentFilter(ACTION_CUSTOM_BROADCAST))
    }

    private fun unRegisterLocalBroadCastReceiver() {
        LocalBroadcastManager.getInstance(this)
            .unregisterReceiver(customReceiver)
    }
    //endregion

    //region system broadcast receiver
    private fun registerSystemBroadCastReceiver() {
        val intentFilter = IntentFilter().apply {
            addAction(Intent.ACTION_POWER_DISCONNECTED)
            addAction(Intent.ACTION_POWER_CONNECTED)
        }

        //registered using the MainActivity context.
        // receiver is active and able to receive broadcasts as long as MainActivity is running
        this.registerReceiver(customReceiver, intentFilter)
    }

    private fun unRegisterSystemBroadCastReceiver(){
        this.unregisterReceiver(customReceiver)
    }
    //endregion

    override fun onDestroy() {

        super.onDestroy()
    }
}