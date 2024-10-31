package com.fasterxml.jackson.core;

/* compiled from: JsonStreamContext.java */
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a */
    protected int f9675a;

    /* renamed from: b */
    protected int f9676b;

    public final int a() {
        int i = this.f9676b;
        if (i < 0) {
            return 0;
        }
        return i;
    }

    public abstract String b();

    public final int c() {
        return this.f9676b + 1;
    }

    public final boolean d() {
        return this.f9675a == 1;
    }

    public final boolean e() {
        return this.f9675a == 2;
    }

    public final boolean f() {
        return this.f9675a == 0;
    }

    public String g() {
        int i = this.f9675a;
        return i != 0 ? i != 1 ? i != 2 ? "?" : "Object" : "Array" : "root";
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        int i = this.f9675a;
        if (i == 0) {
            sb.append("/");
        } else if (i != 1) {
            sb.append('{');
            String b2 = b();
            if (b2 != null) {
                sb.append('\"');
                com.fasterxml.jackson.core.io.a.a(sb, b2);
                sb.append('\"');
            } else {
                sb.append('?');
            }
            sb.append('}');
        } else {
            sb.append('[');
            sb.append(a());
            sb.append(']');
        }
        return sb.toString();
    }
}
