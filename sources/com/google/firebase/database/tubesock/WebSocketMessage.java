package com.google.firebase.database.tubesock;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class WebSocketMessage {

    /* renamed from: a */
    private byte[] f17237a;

    /* renamed from: b */
    private String f17238b;

    /* renamed from: c */
    private byte f17239c = 1;

    public WebSocketMessage(byte[] bArr) {
        this.f17237a = bArr;
    }

    public String a() {
        return this.f17238b;
    }

    public WebSocketMessage(String str) {
        this.f17238b = str;
    }
}
