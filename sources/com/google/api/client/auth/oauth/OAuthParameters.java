package com.google.api.client.auth.oauth;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.util.Beta;
import com.google.api.client.util.escape.PercentEscaper;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

@Beta
/* loaded from: classes.dex */
public final class OAuthParameters implements HttpExecuteInterceptor, HttpRequestInitializer {
    private static final SecureRandom l = new SecureRandom();
    private static final PercentEscaper m = new PercentEscaper("-_.~", false);

    /* renamed from: a, reason: collision with root package name */
    public OAuthSigner f2406a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;

    public void a() {
        this.d = Long.toHexString(Math.abs(l.nextLong()));
    }

    public void b() {
        this.h = Long.toString(System.currentTimeMillis() / 1000);
    }

    public void a(String str, GenericUrl genericUrl) throws GeneralSecurityException {
        boolean z;
        OAuthSigner oAuthSigner = this.f2406a;
        String a2 = oAuthSigner.a();
        this.g = a2;
        TreeMap<String, String> treeMap = new TreeMap<>();
        a(treeMap, "oauth_callback", this.b);
        a(treeMap, "oauth_consumer_key", this.c);
        a(treeMap, "oauth_nonce", this.d);
        a(treeMap, "oauth_signature_method", a2);
        a(treeMap, "oauth_timestamp", this.h);
        a(treeMap, "oauth_token", this.i);
        a(treeMap, "oauth_verifier", this.j);
        a(treeMap, "oauth_version", this.k);
        for (Map.Entry<String, Object> entry : genericUrl.entrySet()) {
            Object value = entry.getValue();
            if (value != null) {
                String key = entry.getKey();
                if (value instanceof Collection) {
                    Iterator it = ((Collection) value).iterator();
                    while (it.hasNext()) {
                        a(treeMap, key, it.next());
                    }
                } else {
                    a(treeMap, key, value);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        boolean z2 = true;
        for (Map.Entry<String, String> entry2 : treeMap.entrySet()) {
            if (z2) {
                z = false;
            } else {
                sb.append('&');
                z = z2;
            }
            sb.append(entry2.getKey());
            String value2 = entry2.getValue();
            if (value2 != null) {
                sb.append('=').append(value2);
            }
            z2 = z;
        }
        String sb2 = sb.toString();
        GenericUrl genericUrl2 = new GenericUrl();
        String e = genericUrl.e();
        genericUrl2.a(e);
        genericUrl2.b(genericUrl.f());
        genericUrl2.a(genericUrl.h());
        int g = genericUrl.g();
        if (("http".equals(e) && g == 80) || ("https".equals(e) && g == 443)) {
            g = -1;
        }
        genericUrl2.a(g);
        String j = genericUrl2.j();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(a(str)).append('&');
        sb3.append(a(j)).append('&');
        sb3.append(a(sb2));
        this.f = oAuthSigner.a(sb3.toString());
    }

    public String c() {
        StringBuilder sb = new StringBuilder("OAuth");
        a(sb, "realm", this.e);
        a(sb, "oauth_callback", this.b);
        a(sb, "oauth_consumer_key", this.c);
        a(sb, "oauth_nonce", this.d);
        a(sb, "oauth_signature", this.f);
        a(sb, "oauth_signature_method", this.g);
        a(sb, "oauth_timestamp", this.h);
        a(sb, "oauth_token", this.i);
        a(sb, "oauth_verifier", this.j);
        a(sb, "oauth_version", this.k);
        return sb.substring(0, sb.length() - 1);
    }

    private void a(StringBuilder sb, String str, String str2) {
        if (str2 != null) {
            sb.append(' ').append(a(str)).append("=\"").append(a(str2)).append("\",");
        }
    }

    private void a(TreeMap<String, String> treeMap, String str, String str2) {
        if (str2 != null) {
            a(treeMap, str, (Object) str2);
        }
    }

    private void a(TreeMap<String, String> treeMap, String str, Object obj) {
        treeMap.put(a(str), obj == null ? null : a(obj.toString()));
    }

    public static String a(String str) {
        return m.a(str);
    }

    @Override // com.google.api.client.http.HttpRequestInitializer
    public void a(HttpRequest httpRequest) throws IOException {
        httpRequest.a(this);
    }

    @Override // com.google.api.client.http.HttpExecuteInterceptor
    public void b(HttpRequest httpRequest) throws IOException {
        a();
        b();
        try {
            a(httpRequest.b(), httpRequest.c());
            httpRequest.g().b(c());
        } catch (GeneralSecurityException e) {
            IOException iOException = new IOException();
            iOException.initCause(e);
            throw iOException;
        }
    }
}
