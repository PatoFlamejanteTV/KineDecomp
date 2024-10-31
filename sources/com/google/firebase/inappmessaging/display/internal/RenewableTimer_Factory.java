package com.google.firebase.inappmessaging.display.internal;

/* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
/* loaded from: classes2.dex */
public final class RenewableTimer_Factory implements d.a.c<RenewableTimer> {

    /* renamed from: a */
    private static final RenewableTimer_Factory f17559a = new RenewableTimer_Factory();

    public static d.a.c<RenewableTimer> a() {
        return f17559a;
    }

    @Override // javax.inject.Provider
    public RenewableTimer get() {
        return new RenewableTimer();
    }
}
