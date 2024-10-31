package com.google.firebase.inappmessaging.display.internal;

/* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
/* loaded from: classes2.dex */
public final class PicassoErrorListener_Factory implements d.a.c<PicassoErrorListener> {

    /* renamed from: a */
    private static final PicassoErrorListener_Factory f17557a = new PicassoErrorListener_Factory();

    public static d.a.c<PicassoErrorListener> a() {
        return f17557a;
    }

    @Override // javax.inject.Provider
    public PicassoErrorListener get() {
        return new PicassoErrorListener();
    }
}
