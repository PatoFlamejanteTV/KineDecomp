package com.android.billingclient.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* compiled from: BillingBroadcastManager.java */
/* renamed from: com.android.billingclient.api.e */
/* loaded from: classes.dex */
public class C0691e {

    /* renamed from: a */
    private final Context f7906a;

    /* renamed from: b */
    private final a f7907b;

    /* compiled from: BillingBroadcastManager.java */
    /* renamed from: com.android.billingclient.api.e$a */
    /* loaded from: classes.dex */
    public class a extends BroadcastReceiver {

        /* renamed from: a */
        private final O f7908a;

        /* renamed from: b */
        private boolean f7909b;

        /* synthetic */ a(C0691e c0691e, O o, C0690d c0690d) {
            this(o);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            this.f7908a.a(c.b.a.a.a.a(intent, "BillingBroadcastManager"), c.b.a.a.a.a(intent.getExtras()));
        }

        private a(O o) {
            this.f7908a = o;
        }

        public void a(Context context, IntentFilter intentFilter) {
            if (this.f7909b) {
                return;
            }
            context.registerReceiver(C0691e.this.f7907b, intentFilter);
            this.f7909b = true;
        }

        public void a(Context context) {
            if (this.f7909b) {
                context.unregisterReceiver(C0691e.this.f7907b);
                this.f7909b = false;
            } else {
                c.b.a.a.a.b("BillingBroadcastManager", "Receiver is not registered.");
            }
        }
    }

    public C0691e(Context context, O o) {
        this.f7906a = context;
        this.f7907b = new a(o);
    }

    public O b() {
        return this.f7907b.f7908a;
    }

    public void c() {
        this.f7907b.a(this.f7906a, new IntentFilter("com.android.vending.billing.PURCHASES_UPDATED"));
    }

    public void a() {
        this.f7907b.a(this.f7906a);
    }
}
