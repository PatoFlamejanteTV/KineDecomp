package com.squareup.okhttp;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import okio.ByteString;

/* compiled from: CertificatePinner.java */
/* loaded from: classes3.dex */
public final class k {

    /* renamed from: a */
    public static final k f25505a = new a().a();

    /* renamed from: b */
    private final Map<String, Set<ByteString>> f25506b;

    /* compiled from: CertificatePinner.java */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a */
        private final Map<String, Set<ByteString>> f25507a = new LinkedHashMap();

        public k a() {
            return new k(this);
        }
    }

    /* synthetic */ k(a aVar, C2387j c2387j) {
        this(aVar);
    }

    public void a(String str, List<Certificate> list) throws SSLPeerUnverifiedException {
        Set<ByteString> a2 = a(str);
        if (a2 == null) {
            return;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (a2.contains(a((X509Certificate) list.get(i)))) {
                return;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Certificate pinning failure!");
        sb.append("\n  Peer certificate chain:");
        int size2 = list.size();
        for (int i2 = 0; i2 < size2; i2++) {
            X509Certificate x509Certificate = (X509Certificate) list.get(i2);
            sb.append("\n    ");
            sb.append(a((Certificate) x509Certificate));
            sb.append(": ");
            sb.append(x509Certificate.getSubjectDN().getName());
        }
        sb.append("\n  Pinned certificates for ");
        sb.append(str);
        sb.append(":");
        for (ByteString byteString : a2) {
            sb.append("\n    sha1/");
            sb.append(byteString.base64());
        }
        throw new SSLPeerUnverifiedException(sb.toString());
    }

    private k(a aVar) {
        this.f25506b = com.squareup.okhttp.a.o.a(aVar.f25507a);
    }

    Set<ByteString> a(String str) {
        Set<ByteString> set;
        Set<ByteString> set2 = this.f25506b.get(str);
        int indexOf = str.indexOf(46);
        if (indexOf != str.lastIndexOf(46)) {
            set = this.f25506b.get("*." + str.substring(indexOf + 1));
        } else {
            set = null;
        }
        if (set2 == null && set == null) {
            return null;
        }
        if (set2 == null || set == null) {
            return set2 != null ? set2 : set;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.addAll(set2);
        linkedHashSet.addAll(set);
        return linkedHashSet;
    }

    public static String a(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return "sha1/" + a((X509Certificate) certificate).base64();
        }
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }

    private static ByteString a(X509Certificate x509Certificate) {
        return com.squareup.okhttp.a.o.a(ByteString.of(x509Certificate.getPublicKey().getEncoded()));
    }
}
