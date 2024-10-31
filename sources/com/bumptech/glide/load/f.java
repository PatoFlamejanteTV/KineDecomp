package com.bumptech.glide.load;

import com.bumptech.glide.g.l;
import java.security.MessageDigest;

/* compiled from: Option.java */
/* loaded from: classes.dex */
public final class f<T> {

    /* renamed from: a */
    private static final a<Object> f8984a = new e();

    /* renamed from: b */
    private final T f8985b;

    /* renamed from: c */
    private final a<T> f8986c;

    /* renamed from: d */
    private final String f8987d;

    /* renamed from: e */
    private volatile byte[] f8988e;

    /* compiled from: Option.java */
    /* loaded from: classes.dex */
    public interface a<T> {
        void a(byte[] bArr, T t, MessageDigest messageDigest);
    }

    private f(String str, T t, a<T> aVar) {
        l.a(str);
        this.f8987d = str;
        this.f8985b = t;
        l.a(aVar);
        this.f8986c = aVar;
    }

    public static <T> f<T> a(String str) {
        return new f<>(str, null, b());
    }

    private static <T> a<T> b() {
        return (a<T>) f8984a;
    }

    private byte[] c() {
        if (this.f8988e == null) {
            this.f8988e = this.f8987d.getBytes(c.f8677a);
        }
        return this.f8988e;
    }

    public boolean equals(Object obj) {
        if (obj instanceof f) {
            return this.f8987d.equals(((f) obj).f8987d);
        }
        return false;
    }

    public int hashCode() {
        return this.f8987d.hashCode();
    }

    public String toString() {
        return "Option{key='" + this.f8987d + "'}";
    }

    public static <T> f<T> a(String str, T t) {
        return new f<>(str, t, b());
    }

    public static <T> f<T> a(String str, T t, a<T> aVar) {
        return new f<>(str, t, aVar);
    }

    public T a() {
        return this.f8985b;
    }

    public void a(T t, MessageDigest messageDigest) {
        this.f8986c.a(c(), t, messageDigest);
    }
}
