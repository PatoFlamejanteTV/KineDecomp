package com.nexstreaming.app.general.util;

import com.nexstreaming.kinemaster.ui.settings.FragmentC2201x;

/* compiled from: Size.java */
/* loaded from: classes2.dex */
public class F {

    /* renamed from: a */
    public final int f19820a;

    /* renamed from: b */
    public final int f19821b;

    public F(int i, int i2) {
        this.f19820a = i;
        this.f19821b = i2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof F)) {
            return false;
        }
        F f2 = (F) obj;
        return f2.f19820a == this.f19820a && f2.f19821b == this.f19821b;
    }

    public int hashCode() {
        return (this.f19820a * com.umeng.commonsdk.internal.a.f26056g) + this.f19821b;
    }

    public String toString() {
        return this.f19820a + FragmentC2201x.f23219a + this.f19821b;
    }
}
