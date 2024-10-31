package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.common.internal.zzx;

/* loaded from: classes.dex */
public class s extends BroadcastReceiver {

    /* renamed from: a */
    static final String f2044a = s.class.getName();
    private final zzv b;
    private boolean c;
    private boolean d;

    public s(zzv zzvVar) {
        zzx.a(zzvVar);
        this.b = zzvVar;
    }

    private Context d() {
        return this.b.m();
    }

    private zzp e() {
        return this.b.f();
    }

    public void a() {
        this.b.a();
        this.b.t();
        if (this.c) {
            return;
        }
        d().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        this.d = this.b.l().b();
        e().t().a("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.d));
        this.c = true;
    }

    public void b() {
        this.b.a();
        this.b.t();
        if (c()) {
            e().t().a("Unregistering connectivity change receiver");
            this.c = false;
            this.d = false;
            try {
                d().unregisterReceiver(this);
            } catch (IllegalArgumentException e) {
                e().b().a("Failed to unregister the network broadcast receiver", e);
            }
        }
    }

    public boolean c() {
        this.b.t();
        return this.c;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.b.a();
        String action = intent.getAction();
        e().t().a("NetworkBroadcastReceiver received action", action);
        if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            e().o().a("NetworkBroadcastReceiver received unknown action", action);
            return;
        }
        boolean b = this.b.l().b();
        if (this.d != b) {
            this.d = b;
            this.b.g().a(new t(this, b));
        }
    }
}
