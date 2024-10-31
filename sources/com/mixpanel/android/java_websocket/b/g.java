package com.mixpanel.android.java_websocket.b;

import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;

/* compiled from: HandshakedataImpl1.java */
/* loaded from: classes.dex */
public class g implements c {

    /* renamed from: a, reason: collision with root package name */
    private byte[] f2993a;
    private TreeMap<String, String> b = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    @Override // com.mixpanel.android.java_websocket.b.f
    public Iterator<String> b() {
        return Collections.unmodifiableSet(this.b.keySet()).iterator();
    }

    @Override // com.mixpanel.android.java_websocket.b.f
    public String b(String str) {
        String str2 = this.b.get(str);
        if (str2 == null) {
            return "";
        }
        return str2;
    }

    @Override // com.mixpanel.android.java_websocket.b.f
    public byte[] c() {
        return this.f2993a;
    }

    @Override // com.mixpanel.android.java_websocket.b.c
    public void a(byte[] bArr) {
        this.f2993a = bArr;
    }

    @Override // com.mixpanel.android.java_websocket.b.c
    public void a(String str, String str2) {
        this.b.put(str, str2);
    }

    @Override // com.mixpanel.android.java_websocket.b.f
    public boolean c(String str) {
        return this.b.containsKey(str);
    }
}
