package com.umeng.commonsdk.proguard;

/* compiled from: TMessage.java */
/* loaded from: classes3.dex */
public final class ag {

    /* renamed from: a */
    public final String f26179a;

    /* renamed from: b */
    public final byte f26180b;

    /* renamed from: c */
    public final int f26181c;

    public ag() {
        this("", (byte) 0, 0);
    }

    public boolean a(ag agVar) {
        return this.f26179a.equals(agVar.f26179a) && this.f26180b == agVar.f26180b && this.f26181c == agVar.f26181c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ag) {
            return a((ag) obj);
        }
        return false;
    }

    public String toString() {
        return "<TMessage name:'" + this.f26179a + "' type: " + ((int) this.f26180b) + " seqid:" + this.f26181c + ">";
    }

    public ag(String str, byte b2, int i) {
        this.f26179a = str;
        this.f26180b = b2;
        this.f26181c = i;
    }
}
