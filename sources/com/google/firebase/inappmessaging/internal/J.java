package com.google.firebase.inappmessaging.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final /* synthetic */ class J implements io.reactivex.c.e {

    /* renamed from: a, reason: collision with root package name */
    private static final J f17794a = new J();

    private J() {
    }

    public static io.reactivex.c.e a() {
        return f17794a;
    }

    @Override // io.reactivex.c.e
    public void accept(Object obj) {
        Logging.d("Impressions store read fail: " + ((Throwable) obj).getMessage());
    }
}
