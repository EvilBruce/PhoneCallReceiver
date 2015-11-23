package com.example.wdw88_000.phonecallreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class SmsReceiver extends BroadcastReceiver {

    private static final String ACTION_SMS_RECEIVED = "android.provider.Telephony.SMS_RECEIVED";
    @Override
    public void onReceive(Context context, Intent intent) {

        String action = intent.getAction();
        if(action.equals(ACTION_SMS_RECEIVED)){
            Toast.makeText(context, "SMS recevied", Toast.LENGTH_SHORT).show();
            Intent service = new Intent(context, MyService.class);
            context.startService(service);
        }
        if(action.equals(Intent.ACTION_NEW_OUTGOING_CALL)){
            String phoneNumber = intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);
            Toast.makeText(context, "call OUT:" + phoneNumber, Toast.LENGTH_SHORT).show();
        }
    }



}

