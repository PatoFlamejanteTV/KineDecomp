package com.adobe.xmp;

import com.adobe.xmp.a.p;
import com.adobe.xmp.a.q;
import com.adobe.xmp.a.w;
import com.adobe.xmp.a.x;

/* compiled from: XMPMetaFactory.java */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    private static j f7584a = new w();

    /* renamed from: b, reason: collision with root package name */
    private static l f7585b = null;

    public static f a() {
        return new p();
    }

    public static j b() {
        return f7584a;
    }

    public static synchronized l c() {
        l lVar;
        synchronized (h.class) {
            if (f7585b == null) {
                try {
                    f7585b = new g();
                } catch (Throwable th) {
                    System.out.println(th);
                }
            }
            lVar = f7585b;
        }
        return lVar;
    }

    public static f a(byte[] bArr) throws XMPException {
        return a(bArr, (com.adobe.xmp.b.d) null);
    }

    public static f a(byte[] bArr, com.adobe.xmp.b.d dVar) throws XMPException {
        return q.a(bArr, dVar);
    }

    public static String a(f fVar, com.adobe.xmp.b.f fVar2) throws XMPException {
        a(fVar);
        return x.a((p) fVar, fVar2);
    }

    private static void a(f fVar) {
        if (!(fVar instanceof p)) {
            throw new UnsupportedOperationException("The serializing service works onlywith the XMPMeta implementation of this library");
        }
    }
}
