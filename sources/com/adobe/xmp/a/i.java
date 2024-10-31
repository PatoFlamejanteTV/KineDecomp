package com.adobe.xmp.a;

import com.adobe.xmp.XMPException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ISO8601Converter.java */
/* loaded from: classes.dex */
public class i {

    /* renamed from: a */
    private String f7510a;

    /* renamed from: b */
    private int f7511b = 0;

    public i(String str) {
        this.f7510a = str;
    }

    public char a(int i) {
        if (i < this.f7510a.length()) {
            return this.f7510a.charAt(i);
        }
        return (char) 0;
    }

    public boolean b() {
        return this.f7511b < this.f7510a.length();
    }

    public int c() {
        return this.f7511b;
    }

    public void d() {
        this.f7511b++;
    }

    public char a() {
        if (this.f7511b < this.f7510a.length()) {
            return this.f7510a.charAt(this.f7511b);
        }
        return (char) 0;
    }

    public int a(String str, int i) throws XMPException {
        char a2 = a(this.f7511b);
        int i2 = 0;
        boolean z = false;
        while ('0' <= a2 && a2 <= '9') {
            i2 = (i2 * 10) + (a2 - '0');
            this.f7511b++;
            a2 = a(this.f7511b);
            z = true;
        }
        if (!z) {
            throw new XMPException(str, 5);
        }
        if (i2 > i) {
            return i;
        }
        if (i2 < 0) {
            return 0;
        }
        return i2;
    }
}
