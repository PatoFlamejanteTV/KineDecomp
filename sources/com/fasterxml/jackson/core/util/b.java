package com.fasterxml.jackson.core.util;

import com.facebook.internal.ServerProtocol;
import java.lang.ref.SoftReference;

/* compiled from: BufferRecyclers.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a */
    private static final f f9802a;

    /* renamed from: b */
    protected static final ThreadLocal<SoftReference<a>> f9803b;

    /* renamed from: c */
    protected static final ThreadLocal<SoftReference<com.fasterxml.jackson.core.io.d>> f9804c;

    static {
        f9802a = ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(System.getProperty("com.fasterxml.jackson.core.util.BufferRecyclers.trackReusableBuffers")) ? f.a() : null;
        f9803b = new ThreadLocal<>();
        f9804c = new ThreadLocal<>();
    }

    public static a a() {
        SoftReference<a> softReference;
        SoftReference<a> softReference2 = f9803b.get();
        a aVar = softReference2 == null ? null : softReference2.get();
        if (aVar == null) {
            aVar = new a();
            f fVar = f9802a;
            if (fVar != null) {
                softReference = fVar.a(aVar);
            } else {
                softReference = new SoftReference<>(aVar);
            }
            f9803b.set(softReference);
        }
        return aVar;
    }

    public static com.fasterxml.jackson.core.io.d b() {
        SoftReference<com.fasterxml.jackson.core.io.d> softReference = f9804c.get();
        com.fasterxml.jackson.core.io.d dVar = softReference == null ? null : softReference.get();
        if (dVar != null) {
            return dVar;
        }
        com.fasterxml.jackson.core.io.d dVar2 = new com.fasterxml.jackson.core.io.d();
        f9804c.set(new SoftReference<>(dVar2));
        return dVar2;
    }

    public static byte[] c(String str) {
        return b().c(str);
    }

    public static char[] b(String str) {
        return b().b(str);
    }

    public static byte[] a(String str) {
        return b().a(str);
    }
}
