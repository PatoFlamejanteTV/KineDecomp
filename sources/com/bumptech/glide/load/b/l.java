package com.bumptech.glide.load.b;

import android.net.Uri;
import android.text.TextUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Map;

/* compiled from: GlideUrl.java */
/* loaded from: classes.dex */
public class l implements com.bumptech.glide.load.c {

    /* renamed from: a */
    private final n f8618a;

    /* renamed from: b */
    private final URL f8619b;

    /* renamed from: c */
    private final String f8620c;

    /* renamed from: d */
    private String f8621d;

    /* renamed from: e */
    private URL f8622e;

    /* renamed from: f */
    private volatile byte[] f8623f;

    /* renamed from: g */
    private int f8624g;

    public l(URL url) {
        this(url, n.f8626b);
    }

    private byte[] d() {
        if (this.f8623f == null) {
            this.f8623f = a().getBytes(com.bumptech.glide.load.c.f8677a);
        }
        return this.f8623f;
    }

    private String e() {
        if (TextUtils.isEmpty(this.f8621d)) {
            String str = this.f8620c;
            if (TextUtils.isEmpty(str)) {
                URL url = this.f8619b;
                com.bumptech.glide.g.l.a(url);
                str = url.toString();
            }
            this.f8621d = Uri.encode(str, "@#&=*+-_.,:!?()/~'%;$");
        }
        return this.f8621d;
    }

    private URL f() throws MalformedURLException {
        if (this.f8622e == null) {
            this.f8622e = new URL(e());
        }
        return this.f8622e;
    }

    public String a() {
        String str = this.f8620c;
        if (str != null) {
            return str;
        }
        URL url = this.f8619b;
        com.bumptech.glide.g.l.a(url);
        return url.toString();
    }

    public Map<String, String> b() {
        return this.f8618a.getHeaders();
    }

    public URL c() throws MalformedURLException {
        return f();
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object obj) {
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return a().equals(lVar.a()) && this.f8618a.equals(lVar.f8618a);
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        if (this.f8624g == 0) {
            this.f8624g = a().hashCode();
            this.f8624g = (this.f8624g * 31) + this.f8618a.hashCode();
        }
        return this.f8624g;
    }

    public String toString() {
        return a();
    }

    public l(String str) {
        this(str, n.f8626b);
    }

    @Override // com.bumptech.glide.load.c
    public void a(MessageDigest messageDigest) {
        messageDigest.update(d());
    }

    public l(URL url, n nVar) {
        com.bumptech.glide.g.l.a(url);
        this.f8619b = url;
        this.f8620c = null;
        com.bumptech.glide.g.l.a(nVar);
        this.f8618a = nVar;
    }

    public l(String str, n nVar) {
        this.f8619b = null;
        com.bumptech.glide.g.l.a(str);
        this.f8620c = str;
        com.bumptech.glide.g.l.a(nVar);
        this.f8618a = nVar;
    }
}
