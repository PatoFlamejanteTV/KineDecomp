package com.adobe.creativesdk.foundation.internal.net;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeNetworkHttpMultiPartTask.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.net.h */
/* loaded from: classes.dex */
public class RunnableC0329h implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0322a f5104a;

    /* renamed from: b */
    final /* synthetic */ int f5105b;

    /* renamed from: c */
    final /* synthetic */ int f5106c;

    /* renamed from: d */
    final /* synthetic */ i f5107d;

    public RunnableC0329h(i iVar, C0322a c0322a, int i, int i2) {
        this.f5107d = iVar;
        this.f5104a = c0322a;
        this.f5105b = i;
        this.f5106c = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f5104a.f5092b.a(this.f5105b, this.f5106c);
    }
}
