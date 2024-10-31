package com.google.firebase.inappmessaging.internal;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* renamed from: com.google.firebase.inappmessaging.internal.w */
/* loaded from: classes2.dex */
public final /* synthetic */ class C1642w implements io.reactivex.c.e {

    /* renamed from: a */
    private final ImpressionStorageClient f18003a;

    private C1642w(ImpressionStorageClient impressionStorageClient) {
        this.f18003a = impressionStorageClient;
    }

    public static io.reactivex.c.e a(ImpressionStorageClient impressionStorageClient) {
        return new C1642w(impressionStorageClient);
    }

    @Override // io.reactivex.c.e
    public void accept(Object obj) {
        this.f18003a.b();
    }
}
