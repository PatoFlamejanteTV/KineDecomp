package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.android.gms.clearcut.ClearcutLogger;
import com.google.firebase.inappmessaging.internal.MetricsLoggerClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final /* synthetic */ class a implements MetricsLoggerClient.ClearcutLoggerInterface {

    /* renamed from: a, reason: collision with root package name */
    private final ClearcutLogger f17965a;

    private a(ClearcutLogger clearcutLogger) {
        this.f17965a = clearcutLogger;
    }

    public static MetricsLoggerClient.ClearcutLoggerInterface a(ClearcutLogger clearcutLogger) {
        return new a(clearcutLogger);
    }

    @Override // com.google.firebase.inappmessaging.internal.MetricsLoggerClient.ClearcutLoggerInterface
    public void a(byte[] bArr) {
        this.f17965a.a(bArr).a();
    }
}
