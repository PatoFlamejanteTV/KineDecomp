package com.squareup.okhttp;

/* compiled from: Challenge.java */
/* loaded from: classes3.dex */
public final class l {

    /* renamed from: a */
    private final String f25508a;

    /* renamed from: b */
    private final String f25509b;

    public l(String str, String str2) {
        this.f25508a = str;
        this.f25509b = str2;
    }

    public String a() {
        return this.f25509b;
    }

    public String b() {
        return this.f25508a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof l) {
            l lVar = (l) obj;
            if (com.squareup.okhttp.a.o.a(this.f25508a, lVar.f25508a) && com.squareup.okhttp.a.o.a(this.f25509b, lVar.f25509b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.f25509b;
        int hashCode = (899 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f25508a;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return this.f25508a + " realm=\"" + this.f25509b + "\"";
    }
}
