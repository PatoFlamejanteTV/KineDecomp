package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.Map;
import java.util.WeakHashMap;

@zzark
/* loaded from: classes2.dex */
public final class zzbap {
    private boolean zzenv;
    private Context zztv;
    private boolean zztd = false;
    private final Map<BroadcastReceiver, IntentFilter> zzenu = new WeakHashMap();
    private final BroadcastReceiver zzent = new _d(this);

    public final synchronized void zzc(Context context, Intent intent) {
        for (Map.Entry<BroadcastReceiver, IntentFilter> entry : this.zzenu.entrySet()) {
            if (entry.getValue().hasAction(intent.getAction())) {
                entry.getKey().onReceive(context, intent);
            }
        }
    }

    public final synchronized void initialize(Context context) {
        if (this.zztd) {
            return;
        }
        this.zztv = context.getApplicationContext();
        if (this.zztv == null) {
            this.zztv = context;
        }
        zzaan.initialize(this.zztv);
        this.zzenv = ((Boolean) zzwu.zzpz().zzd(zzaan.zzcul)).booleanValue();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        this.zztv.registerReceiver(this.zzent, intentFilter);
        this.zztd = true;
    }

    public final synchronized void zza(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (this.zzenv) {
            this.zzenu.put(broadcastReceiver, intentFilter);
        } else {
            context.registerReceiver(broadcastReceiver, intentFilter);
        }
    }

    public final synchronized void zza(Context context, BroadcastReceiver broadcastReceiver) {
        if (this.zzenv) {
            this.zzenu.remove(broadcastReceiver);
        } else {
            context.unregisterReceiver(broadcastReceiver);
        }
    }
}
