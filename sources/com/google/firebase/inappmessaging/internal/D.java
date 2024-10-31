package com.google.firebase.inappmessaging.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final /* synthetic */ class D implements io.reactivex.c.e {

    /* renamed from: a, reason: collision with root package name */
    private static final D f17726a = new D();

    private D() {
    }

    public static io.reactivex.c.e a() {
        return f17726a;
    }

    @Override // io.reactivex.c.e
    public void accept(Object obj) {
        Logging.d("Cache read error: " + ((Throwable) obj).getMessage());
    }
}
