package com.squareup.okhttp.a.b;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

/* compiled from: AndroidTrustRootIndex.java */
/* loaded from: classes3.dex */
public final class a implements f {

    /* renamed from: a */
    private final X509TrustManager f25149a;

    /* renamed from: b */
    private final Method f25150b;

    public a(X509TrustManager x509TrustManager, Method method) {
        this.f25150b = method;
        this.f25149a = x509TrustManager;
    }

    @Override // com.squareup.okhttp.a.b.f
    public X509Certificate a(X509Certificate x509Certificate) {
        try {
            TrustAnchor trustAnchor = (TrustAnchor) this.f25150b.invoke(this.f25149a, x509Certificate);
            if (trustAnchor != null) {
                return trustAnchor.getTrustedCert();
            }
            return null;
        } catch (IllegalAccessException unused) {
            throw new AssertionError();
        } catch (InvocationTargetException unused2) {
            return null;
        }
    }

    public static f a(X509TrustManager x509TrustManager) {
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            declaredMethod.setAccessible(true);
            return new a(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }
}
