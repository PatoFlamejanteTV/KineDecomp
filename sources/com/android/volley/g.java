package com.android.volley;

import android.text.TextUtils;

/* compiled from: Header.java */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a */
    private final String f8063a;

    /* renamed from: b */
    private final String f8064b;

    public g(String str, String str2) {
        this.f8063a = str;
        this.f8064b = str2;
    }

    public final String a() {
        return this.f8063a;
    }

    public final String b() {
        return this.f8064b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || g.class != obj.getClass()) {
            return false;
        }
        g gVar = (g) obj;
        return TextUtils.equals(this.f8063a, gVar.f8063a) && TextUtils.equals(this.f8064b, gVar.f8064b);
    }

    public int hashCode() {
        return (this.f8063a.hashCode() * 31) + this.f8064b.hashCode();
    }

    public String toString() {
        return "Header[name=" + this.f8063a + ",value=" + this.f8064b + "]";
    }
}
