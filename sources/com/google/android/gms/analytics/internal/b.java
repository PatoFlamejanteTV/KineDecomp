package com.google.android.gms.analytics.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    static final String f699a = b.class.getName();
    private final zzf b;
    private boolean c;
    private boolean d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(zzf zzfVar) {
        com.google.android.gms.common.internal.zzx.a(zzfVar);
        this.b = zzfVar;
    }

    private void g() {
        i();
        j();
    }

    private Context h() {
        return this.b.b();
    }

    private zzaf i() {
        return this.b.f();
    }

    private zzb j() {
        return this.b.i();
    }

    public void a() {
        g();
        if (this.c) {
            return;
        }
        Context h = h();
        h.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        IntentFilter intentFilter = new IntentFilter("com.google.analytics.RADIO_POWERED");
        intentFilter.addCategory(h.getPackageName());
        h.registerReceiver(this, intentFilter);
        this.d = f();
        this.b.f().a("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.d));
        this.c = true;
    }

    public void b() {
        if (d()) {
            this.b.f().b("Unregistering connectivity change receiver");
            this.c = false;
            this.d = false;
            try {
                h().unregisterReceiver(this);
            } catch (IllegalArgumentException e) {
                i().e("Failed to unregister the network broadcast receiver", e);
            }
        }
    }

    public void c() {
        if (Build.VERSION.SDK_INT <= 10) {
            return;
        }
        Context h = h();
        Intent intent = new Intent("com.google.analytics.RADIO_POWERED");
        intent.addCategory(h.getPackageName());
        intent.putExtra(f699a, true);
        h.sendOrderedBroadcast(intent, null);
    }

    public boolean d() {
        return this.c;
    }

    public boolean e() {
        if (!this.c) {
            this.b.f().e("Connectivity unknown. Receiver not registered");
        }
        return this.d;
    }

    protected boolean f() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) h().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.isConnected()) {
                    return true;
                }
            }
            return false;
        } catch (SecurityException e) {
            return false;
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        g();
        String action = intent.getAction();
        this.b.f().a("NetworkBroadcastReceiver received action", action);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            boolean f = f();
            if (this.d != f) {
                this.d = f;
                j().a(f);
                return;
            }
            return;
        }
        if (!"com.google.analytics.RADIO_POWERED".equals(action)) {
            this.b.f().d("NetworkBroadcastReceiver received unknown action", action);
        } else {
            if (intent.hasExtra(f699a)) {
                return;
            }
            j().f();
        }
    }
}
