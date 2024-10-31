package com.flurry.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes.dex */
public class az extends BroadcastReceiver {
    private static az e;

    /* renamed from: a, reason: collision with root package name */
    boolean f472a;
    Boolean b;
    private boolean d = false;
    private List<WeakReference<ay>> c = new LinkedList();

    public static synchronized az a() {
        az azVar;
        synchronized (az.class) {
            if (e == null) {
                e = new az();
            }
            azVar = e;
        }
        return azVar;
    }

    public synchronized void b() {
        Context b = ad.a().b();
        this.d = b.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0;
        this.f472a = a(b);
        if (this.d) {
            d();
        }
    }

    public synchronized void a(ay ayVar) {
        if (ayVar != null) {
            this.c.add(new WeakReference<>(ayVar));
        }
    }

    public boolean c() {
        return this.b != null ? this.b.booleanValue() : this.f472a;
    }

    void d() {
        Context b = ad.a().b();
        this.f472a = a(b);
        b.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        boolean a2 = a(context);
        if (this.f472a != a2) {
            this.f472a = a2;
            Iterator it = new LinkedList(this.c).iterator();
            while (it.hasNext()) {
                ay ayVar = (ay) ((WeakReference) it.next()).get();
                if (ayVar != null) {
                    ayVar.a(this.f472a);
                }
            }
        }
    }

    private boolean a(Context context) {
        if (!this.d || context == null) {
            return true;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
