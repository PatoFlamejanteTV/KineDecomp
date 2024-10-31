package com.google.firebase.inappmessaging.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final /* synthetic */ class Y implements io.reactivex.c.e {

    /* renamed from: a, reason: collision with root package name */
    private static final Y f17845a = new Y();

    private Y() {
    }

    public static io.reactivex.c.e a() {
        return f17845a;
    }

    @Override // io.reactivex.c.e
    public void accept(Object obj) {
        Logging.d("Cache write error: " + ((Throwable) obj).getMessage());
    }
}
