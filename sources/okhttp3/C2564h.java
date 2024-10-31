package okhttp3;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import okio.ByteString;

/* compiled from: CertificatePinner.java */
/* renamed from: okhttp3.h, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2564h {

    /* renamed from: a, reason: collision with root package name */
    public static final C2564h f28983a = new a().a();

    /* renamed from: b, reason: collision with root package name */
    private final Set<b> f28984b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private final okhttp3.a.f.c f28985c;

    /* compiled from: CertificatePinner.java */
    /* renamed from: okhttp3.h$a */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final List<b> f28986a = new ArrayList();

        public C2564h a() {
            return new C2564h(new LinkedHashSet(this.f28986a), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CertificatePinner.java */
    /* renamed from: okhttp3.h$b */
    /* loaded from: classes3.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        final String f28987a;

        /* renamed from: b, reason: collision with root package name */
        final String f28988b;

        /* renamed from: c, reason: collision with root package name */
        final String f28989c;

        /* renamed from: d, reason: collision with root package name */
        final ByteString f28990d;

        boolean a(String str) {
            if (this.f28987a.startsWith("*.")) {
                int indexOf = str.indexOf(46);
                if ((str.length() - indexOf) - 1 == this.f28988b.length()) {
                    String str2 = this.f28988b;
                    if (str.regionMatches(false, indexOf + 1, str2, 0, str2.length())) {
                        return true;
                    }
                }
                return false;
            }
            return str.equals(this.f28988b);
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (this.f28987a.equals(bVar.f28987a) && this.f28989c.equals(bVar.f28989c) && this.f28990d.equals(bVar.f28990d)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return ((((527 + this.f28987a.hashCode()) * 31) + this.f28989c.hashCode()) * 31) + this.f28990d.hashCode();
        }

        public String toString() {
            return this.f28989c + this.f28990d.base64();
        }
    }

    C2564h(Set<b> set, @Nullable okhttp3.a.f.c cVar) {
        this.f28984b = set;
        this.f28985c = cVar;
    }

    static ByteString b(X509Certificate x509Certificate) {
        return ByteString.of(x509Certificate.getPublicKey().getEncoded()).sha256();
    }

    public void a(String str, List<Certificate> list) throws SSLPeerUnverifiedException {
        List<b> a2 = a(str);
        if (a2.isEmpty()) {
            return;
        }
        okhttp3.a.f.c cVar = this.f28985c;
        if (cVar != null) {
            list = cVar.a(list, str);
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            X509Certificate x509Certificate = (X509Certificate) list.get(i);
            int size2 = a2.size();
            ByteString byteString = null;
            ByteString byteString2 = null;
            for (int i2 = 0; i2 < size2; i2++) {
                b bVar = a2.get(i2);
                if (bVar.f28989c.equals("sha256/")) {
                    if (byteString == null) {
                        byteString = b(x509Certificate);
                    }
                    if (bVar.f28990d.equals(byteString)) {
                        return;
                    }
                } else if (bVar.f28989c.equals("sha1/")) {
                    if (byteString2 == null) {
                        byteString2 = a(x509Certificate);
                    }
                    if (bVar.f28990d.equals(byteString2)) {
                        return;
                    }
                } else {
                    throw new AssertionError("unsupported hashAlgorithm: " + bVar.f28989c);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Certificate pinning failure!");
        sb.append("\n  Peer certificate chain:");
        int size3 = list.size();
        for (int i3 = 0; i3 < size3; i3++) {
            X509Certificate x509Certificate2 = (X509Certificate) list.get(i3);
            sb.append("\n    ");
            sb.append(a((Certificate) x509Certificate2));
            sb.append(": ");
            sb.append(x509Certificate2.getSubjectDN().getName());
        }
        sb.append("\n  Pinned certificates for ");
        sb.append(str);
        sb.append(":");
        int size4 = a2.size();
        for (int i4 = 0; i4 < size4; i4++) {
            b bVar2 = a2.get(i4);
            sb.append("\n    ");
            sb.append(bVar2);
        }
        throw new SSLPeerUnverifiedException(sb.toString());
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C2564h) {
            C2564h c2564h = (C2564h) obj;
            if (okhttp3.a.e.a(this.f28985c, c2564h.f28985c) && this.f28984b.equals(c2564h.f28984b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        okhttp3.a.f.c cVar = this.f28985c;
        return ((cVar != null ? cVar.hashCode() : 0) * 31) + this.f28984b.hashCode();
    }

    List<b> a(String str) {
        List<b> emptyList = Collections.emptyList();
        for (b bVar : this.f28984b) {
            if (bVar.a(str)) {
                if (emptyList.isEmpty()) {
                    emptyList = new ArrayList<>();
                }
                emptyList.add(bVar);
            }
        }
        return emptyList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2564h a(@Nullable okhttp3.a.f.c cVar) {
        return okhttp3.a.e.a(this.f28985c, cVar) ? this : new C2564h(this.f28984b, cVar);
    }

    public static String a(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return "sha256/" + b((X509Certificate) certificate).base64();
        }
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }

    static ByteString a(X509Certificate x509Certificate) {
        return ByteString.of(x509Certificate.getPublicKey().getEncoded()).sha1();
    }
}
