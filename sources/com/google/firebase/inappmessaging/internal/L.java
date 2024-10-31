package com.google.firebase.inappmessaging.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public final /* synthetic */ class L implements io.reactivex.c.e {

    /* renamed from: a, reason: collision with root package name */
    private static final L f17796a = new L();

    private L() {
    }

    public static io.reactivex.c.e a() {
        return f17796a;
    }

    @Override // io.reactivex.c.e
    public void accept(Object obj) {
        Logging.a("Event Triggered: " + ((String) obj).toString());
    }
}
