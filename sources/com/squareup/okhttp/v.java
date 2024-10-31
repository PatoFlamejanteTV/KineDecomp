package com.squareup.okhttp;

import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

/* compiled from: Handshake.java */
/* loaded from: classes3.dex */
public final class v {

    /* renamed from: a */
    private final String f25536a;

    /* renamed from: b */
    private final List<Certificate> f25537b;

    /* renamed from: c */
    private final List<Certificate> f25538c;

    private v(String str, List<Certificate> list, List<Certificate> list2) {
        this.f25536a = str;
        this.f25537b = list;
        this.f25538c = list2;
    }

    public static v a(SSLSession sSLSession) {
        Certificate[] certificateArr;
        List emptyList;
        List emptyList2;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite != null) {
            try {
                certificateArr = sSLSession.getPeerCertificates();
            } catch (SSLPeerUnverifiedException unused) {
                certificateArr = null;
            }
            if (certificateArr != null) {
                emptyList = com.squareup.okhttp.a.o.a(certificateArr);
            } else {
                emptyList = Collections.emptyList();
            }
            Certificate[] localCertificates = sSLSession.getLocalCertificates();
            if (localCertificates != null) {
                emptyList2 = com.squareup.okhttp.a.o.a(localCertificates);
            } else {
                emptyList2 = Collections.emptyList();
            }
            return new v(cipherSuite, emptyList, emptyList2);
        }
        throw new IllegalStateException("cipherSuite == null");
    }

    public List<Certificate> b() {
        return this.f25538c;
    }

    public List<Certificate> c() {
        return this.f25537b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof v)) {
            return false;
        }
        v vVar = (v) obj;
        return this.f25536a.equals(vVar.f25536a) && this.f25537b.equals(vVar.f25537b) && this.f25538c.equals(vVar.f25538c);
    }

    public int hashCode() {
        return ((((527 + this.f25536a.hashCode()) * 31) + this.f25537b.hashCode()) * 31) + this.f25538c.hashCode();
    }

    public static v a(String str, List<Certificate> list, List<Certificate> list2) {
        if (str != null) {
            return new v(str, com.squareup.okhttp.a.o.a(list), com.squareup.okhttp.a.o.a(list2));
        }
        throw new IllegalArgumentException("cipherSuite == null");
    }

    public String a() {
        return this.f25536a;
    }
}
