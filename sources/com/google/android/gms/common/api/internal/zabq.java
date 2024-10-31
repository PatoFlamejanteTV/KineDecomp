package com.google.android.gms.common.api.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/* loaded from: classes.dex */
public final class zabq extends BroadcastReceiver {

    /* renamed from: a */
    private Context f10899a;

    /* renamed from: b */
    private final zabr f10900b;

    public zabq(zabr zabrVar) {
        this.f10900b = zabrVar;
    }

    public final void a(Context context) {
        this.f10899a = context;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Uri data = intent.getData();
        if ("com.google.android.gms".equals(data != null ? data.getSchemeSpecificPart() : null)) {
            this.f10900b.a();
            a();
        }
    }

    public final synchronized void a() {
        if (this.f10899a != null) {
            this.f10899a.unregisterReceiver(this);
        }
        this.f10899a = null;
    }
}
