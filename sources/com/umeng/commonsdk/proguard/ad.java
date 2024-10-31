package com.umeng.commonsdk.proguard;

/* compiled from: TField.java */
/* loaded from: classes3.dex */
public class ad {

    /* renamed from: a */
    public final String f26171a;

    /* renamed from: b */
    public final byte f26172b;

    /* renamed from: c */
    public final short f26173c;

    public ad() {
        this("", (byte) 0, (short) 0);
    }

    public boolean a(ad adVar) {
        return this.f26172b == adVar.f26172b && this.f26173c == adVar.f26173c;
    }

    public String toString() {
        return "<TField name:'" + this.f26171a + "' type:" + ((int) this.f26172b) + " field-id:" + ((int) this.f26173c) + ">";
    }

    public ad(String str, byte b2, short s) {
        this.f26171a = str;
        this.f26172b = b2;
        this.f26173c = s;
    }
}
