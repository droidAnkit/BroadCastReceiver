package lazycoder21.droid.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class CustomReceiver : BroadcastReceiver() {

    companion object {
        const val ACTION_CUSTOM_BROADCAST = "lazycoder21.droid.broadcastreceiver.ACTION_CUSTOM_BROADCAST"
    }

    override fun onReceive(context: Context, intent: Intent) {
        when(intent.action) {
            Intent.ACTION_POWER_CONNECTED -> context.showToast("Power connected")
            Intent.ACTION_POWER_DISCONNECTED -> context.showToast("Power disconnected")
            CustomReceiver.ACTION_CUSTOM_BROADCAST -> context.showToast("Custom Broadcast")

        }
    }
}