package com.android.billingclient.api;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.android.billingclient.api.H;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BillingClientImpl.java */
/* renamed from: com.android.billingclient.api.q, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class ResultReceiverC0703q extends ResultReceiver {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C f7939a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResultReceiverC0703q(C c2, Handler handler) {
        super(handler);
        this.f7939a = c2;
    }

    @Override // android.os.ResultReceiver
    public void onReceiveResult(int i, Bundle bundle) {
        C0691e c0691e;
        c0691e = this.f7939a.f7852d;
        O b2 = c0691e.b();
        if (b2 == null) {
            c.b.a.a.a.b("BillingClient", "PurchasesUpdatedListener is null - no way to return the response.");
            return;
        }
        List<M> a2 = c.b.a.a.a.a(bundle);
        H.a b3 = H.b();
        b3.a(i);
        b3.a(c.b.a.a.a.a(bundle, "BillingClient"));
        b2.a(b3.a(), a2);
    }
}
