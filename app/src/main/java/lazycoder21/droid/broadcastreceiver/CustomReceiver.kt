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

/*
* A BroadcastReceiver is either a static receiver or a dynamic receiver, depending on how you register it:
    * To register a receiver statically, use the <receiver> element in AndroidManifest.xml file.
         Static receivers are also called manifest-declared receivers.
    * To register a receiver dynamically, use the app context or activity context.
        The receiver receives broadcasts as long as the registering context is valid,
        meaning as long as the corresponding app or activity is running.
        Dynamic receivers are also called context-registered receivers.
    * Registering for a local broadcast is similar to registering for a system broadcast,
      which we do using a dynamic receiver.
    * For broadcasts sent using LocalBroadcastManager, static registration in the manifest is not allowed.

* Android provides three ways for your app to send custom broadcasts:
    * Normal broadcasts are asynchronous.
        Receivers of normal broadcasts run in an undefined order, often at the same time.
        To send a normal broadcast, create a broadcast intent and pass it to sendBroadcast(Intent).
    * Local broadcasts are sent to receivers that are in the same app as the sender.
        To send a local broadcast, create a broadcast intent and pass it to LocalBroadcastManager.sendBroadcast.
    * Ordered broadcasts are delivered to one receiver at a time.
        As each receiver executes, it can propagate a result to the next receiver,
        or it can cancel the broadcast so that the broadcast is not passed to other receivers.
        To send an ordered broadcast, create a broadcast intent and pass it to sendOrderedBroadcast(Intent, String).
* */