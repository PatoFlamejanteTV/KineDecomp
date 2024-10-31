package com.flurry.sdk;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ byte[] f488a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ l d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(l lVar, byte[] bArr, String str, String str2) {
        this.d = lVar;
        this.f488a = bArr;
        this.b = str;
        this.c = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.d.e();
        try {
            this.d.d(this.f488a, this.b, this.c);
        } catch (Exception e) {
            as.a(6, l.d, "storeData error", e);
        }
    }
}
