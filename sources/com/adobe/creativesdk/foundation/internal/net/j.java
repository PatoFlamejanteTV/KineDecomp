package com.adobe.creativesdk.foundation.internal.net;

import android.net.Uri;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: AdobeNetworkHttpRequest.java */
/* loaded from: classes.dex */
public class j {

    /* renamed from: a */
    private Map<String, String> f5108a;

    /* renamed from: b */
    private URL f5109b;

    /* renamed from: c */
    private AdobeNetworkHttpRequestMethod f5110c;

    /* renamed from: d */
    private boolean f5111d;

    /* renamed from: e */
    private InputStream f5112e;

    /* renamed from: f */
    private Map<String, String> f5113f;

    /* renamed from: g */
    private boolean f5114g;

    public j() {
        this.f5109b = null;
        this.f5110c = null;
        this.f5112e = null;
        this.f5113f = null;
        this.f5114g = true;
        this.f5111d = true;
        this.f5113f = new HashMap();
        this.f5108a = new LinkedHashMap();
    }

    public void a(URL url) {
        this.f5109b = url;
    }

    public void a(Map<String, String> map) {
    }

    public void b(Map<String, String> map) {
        this.f5108a = map;
    }

    public Map<String, String> c() {
        return this.f5108a;
    }

    public String d() {
        Map<String, String> map = this.f5108a;
        if (map == null) {
            return null;
        }
        Uri.Builder builder = new Uri.Builder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            builder.appendQueryParameter(entry.getKey(), entry.getValue());
        }
        String uri = builder.build().toString();
        return uri.isEmpty() ? uri : uri.substring(1);
    }

    public AdobeNetworkHttpRequestMethod e() {
        return this.f5110c;
    }

    public Map<String, String> f() {
        return this.f5113f;
    }

    public URL g() {
        return this.f5109b;
    }

    public boolean h() {
        return this.f5114g;
    }

    public void a(AdobeNetworkHttpRequestMethod adobeNetworkHttpRequestMethod) {
        this.f5110c = adobeNetworkHttpRequestMethod;
    }

    public InputStream b() {
        return this.f5112e;
    }

    public void a(String str, String str2) {
        if (this.f5108a == null) {
            this.f5108a = new LinkedHashMap();
        }
        if (this.f5108a.get(str) == null) {
            this.f5108a.put(str, str2);
        }
    }

    public void b(String str, String str2) {
        this.f5113f.put(str, str2);
    }

    public void a(byte[] bArr) {
        if (bArr != null) {
            org.apache.commons.io.d.a(this.f5112e);
            this.f5112e = new ByteArrayInputStream(bArr);
        }
    }

    public void a(String str) throws FileNotFoundException {
        org.apache.commons.io.d.a(this.f5112e);
        this.f5112e = new BufferedInputStream(new FileInputStream(new File(str)), 32768);
    }

    public j(URL url, AdobeNetworkHttpRequestMethod adobeNetworkHttpRequestMethod, Map<String, String> map) {
        this();
        this.f5109b = url;
        this.f5110c = adobeNetworkHttpRequestMethod;
        a(adobeNetworkHttpRequestMethod);
        this.f5108a = map;
    }

    public void a() {
        org.apache.commons.io.d.a(this.f5112e);
        this.f5112e = null;
    }
}
