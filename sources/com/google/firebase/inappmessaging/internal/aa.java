package com.google.firebase.inappmessaging.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final /* synthetic */ class aa implements io.reactivex.c.e {

    /* renamed from: a, reason: collision with root package name */
    private static final aa f17849a = new aa();

    private aa() {
    }

    public static io.reactivex.c.e a() {
        return f17849a;
    }

    @Override // io.reactivex.c.e
    public void accept(Object obj) {
        Logging.c("App foreground rate limited ? : " + ((Boolean) obj));
    }
}
