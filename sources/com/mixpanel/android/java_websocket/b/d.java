package com.mixpanel.android.java_websocket.b;

/* compiled from: HandshakeImpl1Client.java */
/* loaded from: classes.dex */
public class d extends g implements b {

    /* renamed from: a, reason: collision with root package name */
    private String f2991a = "*";

    @Override // com.mixpanel.android.java_websocket.b.b
    public void a(String str) throws IllegalArgumentException {
        if (str == null) {
            throw new IllegalArgumentException("http resource descriptor must not be null");
        }
        this.f2991a = str;
    }

    @Override // com.mixpanel.android.java_websocket.b.a
    public String a() {
        return this.f2991a;
    }
}
