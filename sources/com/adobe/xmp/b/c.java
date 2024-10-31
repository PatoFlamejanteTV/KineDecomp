package com.adobe.xmp.b;

import com.adobe.xmp.XMPException;
import java.util.Map;

/* compiled from: Options.java */
/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a */
    private int f7576a = 0;

    /* renamed from: b */
    private Map f7577b = null;

    public c() {
    }

    private void d(int i) throws XMPException {
        int b2 = (b() ^ (-1)) & i;
        if (b2 == 0) {
            a(i);
            return;
        }
        throw new XMPException("The option bit(s) 0x" + Integer.toHexString(b2) + " are invalid!", 103);
    }

    protected void a(int i) throws XMPException {
    }

    public void a(int i, boolean z) {
        int i2;
        if (z) {
            i2 = i | this.f7576a;
        } else {
            i2 = (i ^ (-1)) & this.f7576a;
        }
        this.f7576a = i2;
    }

    protected abstract int b();

    public boolean b(int i) {
        return (i & this.f7576a) != 0;
    }

    public void c(int i) throws XMPException {
        d(i);
        this.f7576a = i;
    }

    public boolean equals(Object obj) {
        return a() == ((c) obj).a();
    }

    public int hashCode() {
        return a();
    }

    public String toString() {
        return "0x" + Integer.toHexString(this.f7576a);
    }

    public int a() {
        return this.f7576a;
    }

    public c(int i) throws XMPException {
        d(i);
        c(i);
    }
}
