package com.google.android.gms.ads.internal.purchase;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.zzfw;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzhz;
import com.google.android.gms.internal.zzid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@zzgr
/* loaded from: classes.dex */
public class zzc extends zzhz implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    private final Object f612a;
    private boolean b;
    private Context c;
    private zzfw d;
    private zzb e;
    private zzh f;
    private List<zzf> g;
    private zzk h;

    public zzc(Context context, zzfw zzfwVar, zzk zzkVar) {
        this(context, zzfwVar, zzkVar, new zzb(context), zzh.a(context.getApplicationContext()));
    }

    zzc(Context context, zzfw zzfwVar, zzk zzkVar, zzb zzbVar, zzh zzhVar) {
        this.f612a = new Object();
        this.b = false;
        this.g = null;
        this.c = context;
        this.d = zzfwVar;
        this.h = zzkVar;
        this.e = zzbVar;
        this.f = zzhVar;
        this.g = this.f.a(10L);
    }

    private void a(long j) {
        do {
            if (!b(j)) {
                com.google.android.gms.ads.internal.util.client.zzb.d("Timeout waiting for pending transaction to be processed.");
            }
        } while (!this.b);
    }

    private boolean b(long j) {
        long elapsedRealtime = 60000 - (SystemClock.elapsedRealtime() - j);
        if (elapsedRealtime <= 0) {
            return false;
        }
        try {
            this.f612a.wait(elapsedRealtime);
        } catch (InterruptedException e) {
            com.google.android.gms.ads.internal.util.client.zzb.e("waitWithTimeout_lock interrupted");
        }
        return true;
    }

    protected void a() {
        if (this.g.isEmpty()) {
            return;
        }
        HashMap hashMap = new HashMap();
        for (zzf zzfVar : this.g) {
            hashMap.put(zzfVar.c, zzfVar);
        }
        String str = null;
        while (true) {
            Bundle b = this.e.b(this.c.getPackageName(), str);
            if (b == null || zzp.o().a(b) != 0) {
                break;
            }
            ArrayList<String> stringArrayList = b.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
            ArrayList<String> stringArrayList2 = b.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
            ArrayList<String> stringArrayList3 = b.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
            String string = b.getString("INAPP_CONTINUATION_TOKEN");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= stringArrayList.size()) {
                    break;
                }
                if (hashMap.containsKey(stringArrayList.get(i2))) {
                    String str2 = stringArrayList.get(i2);
                    String str3 = stringArrayList2.get(i2);
                    String str4 = stringArrayList3.get(i2);
                    zzf zzfVar2 = (zzf) hashMap.get(str2);
                    if (zzfVar2.b.equals(zzp.o().a(str3))) {
                        a(zzfVar2, str3, str4);
                        hashMap.remove(str2);
                    }
                }
                i = i2 + 1;
            }
            if (string == null || hashMap.isEmpty()) {
                break;
            } else {
                str = string;
            }
        }
        Iterator it = hashMap.keySet().iterator();
        while (it.hasNext()) {
            this.f.a((zzf) hashMap.get((String) it.next()));
        }
    }

    protected void a(zzf zzfVar, String str, String str2) {
        Intent intent = new Intent();
        zzp.o();
        intent.putExtra("RESPONSE_CODE", 0);
        zzp.o();
        intent.putExtra("INAPP_PURCHASE_DATA", str);
        zzp.o();
        intent.putExtra("INAPP_DATA_SIGNATURE", str2);
        zzid.zzIE.post(new a(this, zzfVar, intent));
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.f612a) {
            this.e.a(iBinder);
            a();
            this.b = true;
            this.f612a.notify();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        com.google.android.gms.ads.internal.util.client.zzb.c("In-app billing service disconnected.");
        this.e.a();
    }

    @Override // com.google.android.gms.internal.zzhz
    public void onStop() {
        synchronized (this.f612a) {
            com.google.android.gms.common.stats.zzb.a().a(this.c, this);
            this.e.a();
        }
    }

    @Override // com.google.android.gms.internal.zzhz
    public void zzbn() {
        synchronized (this.f612a) {
            Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
            intent.setPackage("com.android.vending");
            com.google.android.gms.common.stats.zzb.a().a(this.c, intent, this, 1);
            a(SystemClock.elapsedRealtime());
            com.google.android.gms.common.stats.zzb.a().a(this.c, this);
            this.e.a();
        }
    }
}
