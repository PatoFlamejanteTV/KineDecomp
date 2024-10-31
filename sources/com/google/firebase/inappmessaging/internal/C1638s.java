package com.google.firebase.inappmessaging.internal;

import android.os.Bundle;
import com.google.firebase.analytics.connector.AnalyticsConnector;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* renamed from: com.google.firebase.inappmessaging.internal.s */
/* loaded from: classes2.dex */
final class C1638s implements AnalyticsConnector.AnalyticsConnectorListener {

    /* renamed from: a */
    private io.reactivex.f<String> f17994a;

    public C1638s(io.reactivex.f<String> fVar) {
        this.f17994a = fVar;
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorListener
    public void a(int i, Bundle bundle) {
        if (i == 2) {
            this.f17994a.onNext(bundle.getString(com.umeng.analytics.pro.b.ao));
        }
    }
}
