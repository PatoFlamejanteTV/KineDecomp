package com.google.api.client.auth.oauth;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.util.Beta;
import com.google.api.client.util.escape.PercentEscaper;
import com.google.common.collect.Multiset;
import com.google.common.collect.TreeMultiset;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

@Beta
/* loaded from: classes2.dex */
public final class OAuthParameters implements HttpExecuteInterceptor, HttpRequestInitializer {

    /* renamed from: a */
    private static final SecureRandom f14581a = new SecureRandom();

    /* renamed from: b */
    private static final PercentEscaper f14582b = new PercentEscaper("-_.~", false);

    /* renamed from: c */
    public OAuthSigner f14583c;

    /* renamed from: d */
    public String f14584d;

    /* renamed from: e */
    public String f14585e;

    /* renamed from: f */
    public String f14586f;

    /* renamed from: g */
    public String f14587g;

    /* renamed from: h */
    public String f14588h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;

    /* loaded from: classes2.dex */
    public static class a implements Comparable<a> {

        /* renamed from: a */
        private final String f14589a;

        /* renamed from: b */
        private final String f14590b;

        public a(String str, String str2) {
            this.f14589a = str;
            this.f14590b = str2;
        }

        public String a() {
            return this.f14589a;
        }

        public String getValue() {
            return this.f14590b;
        }

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(a aVar) {
            int compareTo = this.f14589a.compareTo(aVar.f14589a);
            return compareTo == 0 ? this.f14590b.compareTo(aVar.f14590b) : compareTo;
        }
    }

    public void a() {
        this.f14586f = Long.toHexString(Math.abs(f14581a.nextLong()));
    }

    public void b() {
        this.j = Long.toString(System.currentTimeMillis() / 1000);
    }

    public String c() {
        StringBuilder sb = new StringBuilder("OAuth");
        a(sb, "realm", this.f14587g);
        a(sb, "oauth_callback", this.f14584d);
        a(sb, "oauth_consumer_key", this.f14585e);
        a(sb, "oauth_nonce", this.f14586f);
        a(sb, "oauth_signature", this.f14588h);
        a(sb, "oauth_signature_method", this.i);
        a(sb, "oauth_timestamp", this.j);
        a(sb, "oauth_token", this.k);
        a(sb, "oauth_verifier", this.l);
        a(sb, "oauth_version", this.m);
        return sb.substring(0, sb.length() - 1);
    }

    public void a(String str, GenericUrl genericUrl) throws GeneralSecurityException {
        OAuthSigner oAuthSigner = this.f14583c;
        String a2 = oAuthSigner.a();
        this.i = a2;
        TreeMultiset create = TreeMultiset.create();
        a((Multiset<a>) create, "oauth_callback", this.f14584d);
        a((Multiset<a>) create, "oauth_consumer_key", this.f14585e);
        a((Multiset<a>) create, "oauth_nonce", this.f14586f);
        a((Multiset<a>) create, "oauth_signature_method", a2);
        a((Multiset<a>) create, "oauth_timestamp", this.j);
        a((Multiset<a>) create, "oauth_token", this.k);
        a((Multiset<a>) create, "oauth_verifier", this.l);
        a((Multiset<a>) create, "oauth_version", this.m);
        for (Map.Entry<String, Object> entry : genericUrl.entrySet()) {
            Object value = entry.getValue();
            if (value != null) {
                String key = entry.getKey();
                if (value instanceof Collection) {
                    Iterator it = ((Collection) value).iterator();
                    while (it.hasNext()) {
                        a(create, key, it.next());
                    }
                } else {
                    a(create, key, value);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (E e2 : create.elementSet()) {
            if (z) {
                z = false;
            } else {
                sb.append('&');
            }
            sb.append(e2.a());
            String value2 = e2.getValue();
            if (value2 != null) {
                sb.append('=');
                sb.append(value2);
            }
        }
        String sb2 = sb.toString();
        GenericUrl genericUrl2 = new GenericUrl();
        String g2 = genericUrl.g();
        genericUrl2.c(g2);
        genericUrl2.a(genericUrl.d());
        genericUrl2.a(genericUrl.e());
        int f2 = genericUrl.f();
        if (("http".equals(g2) && f2 == 80) || ("https".equals(g2) && f2 == 443)) {
            f2 = -1;
        }
        genericUrl2.a(f2);
        this.f14588h = oAuthSigner.a(a(str) + '&' + a(genericUrl2.build()) + '&' + a(sb2));
    }

    @Override // com.google.api.client.http.HttpRequestInitializer
    public void b(HttpRequest httpRequest) throws IOException {
        httpRequest.a(this);
    }

    private void a(StringBuilder sb, String str, String str2) {
        if (str2 != null) {
            sb.append(' ');
            sb.append(a(str));
            sb.append("=\"");
            sb.append(a(str2));
            sb.append("\",");
        }
    }

    private void a(Multiset<a> multiset, String str, String str2) {
        if (str2 != null) {
            a(multiset, str, (Object) str2);
        }
    }

    private void a(Multiset<a> multiset, String str, Object obj) {
        multiset.add(new a(a(str), obj == null ? null : a(obj.toString())));
    }

    public static String a(String str) {
        return f14582b.a(str);
    }

    @Override // com.google.api.client.http.HttpExecuteInterceptor
    public void a(HttpRequest httpRequest) throws IOException {
        a();
        b();
        try {
            a(httpRequest.i(), httpRequest.o());
            httpRequest.e().b(c());
        } catch (GeneralSecurityException e2) {
            IOException iOException = new IOException();
            iOException.initCause(e2);
            throw iOException;
        }
    }
}
