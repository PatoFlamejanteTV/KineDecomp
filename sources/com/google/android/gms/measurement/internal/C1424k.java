package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.measurement.internal.k, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C1424k extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    private final zzfo f13787a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f13788b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f13789c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1424k(zzfo zzfoVar) {
        Preconditions.a(zzfoVar);
        this.f13787a = zzfoVar;
    }

    public final void a() {
        this.f13787a.l();
        this.f13787a.zzgs().c();
        this.f13787a.zzgs().c();
        if (this.f13788b) {
            this.f13787a.b().y().a("Unregistering connectivity change receiver");
            this.f13788b = false;
            this.f13789c = false;
            try {
                this.f13787a.getContext().unregisterReceiver(this);
            } catch (IllegalArgumentException e2) {
                this.f13787a.b().q().a("Failed to unregister the network broadcast receiver", e2);
            }
        }
    }

    public final void b() {
        this.f13787a.l();
        this.f13787a.zzgs().c();
        if (this.f13788b) {
            return;
        }
        this.f13787a.getContext().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        this.f13789c = this.f13787a.j().r();
        this.f13787a.b().y().a("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.f13789c));
        this.f13788b = true;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.f13787a.l();
        String action = intent.getAction();
        this.f13787a.b().y().a("NetworkBroadcastReceiver received action", action);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            boolean r = this.f13787a.j().r();
            if (this.f13789c != r) {
                this.f13789c = r;
                this.f13787a.zzgs().a(new RunnableC1426l(this, r));
                return;
            }
            return;
        }
        this.f13787a.b().t().a("NetworkBroadcastReceiver received unknown action", action);
    }
}
