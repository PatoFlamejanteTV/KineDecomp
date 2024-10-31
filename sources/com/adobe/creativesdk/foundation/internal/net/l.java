package com.adobe.creativesdk.foundation.internal.net;

import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

/* compiled from: AdobeNetworkHttpResponse.java */
/* loaded from: classes.dex */
public class l {

    /* renamed from: a */
    protected ByteBuffer f5118a = null;

    /* renamed from: b */
    protected int f5119b = 0;

    /* renamed from: c */
    protected URL f5120c = null;

    /* renamed from: d */
    protected Map<String, List<String>> f5121d = null;

    /* renamed from: e */
    protected int f5122e = 0;

    /* renamed from: f */
    protected int f5123f = 0;

    /* renamed from: g */
    private boolean f5124g = false;

    /* renamed from: h */
    private Exception f5125h = null;
    private Boolean i = false;

    public void a(boolean z) {
        this.f5124g = z;
    }

    public void b(boolean z) {
        this.i = Boolean.valueOf(z);
    }

    public byte[] c() {
        ByteBuffer byteBuffer = this.f5118a;
        if (byteBuffer != null) {
            return byteBuffer.array();
        }
        return null;
    }

    public String d() {
        ByteBuffer byteBuffer = this.f5118a;
        if (byteBuffer != null) {
            try {
                return new String(byteBuffer.array(), "UTF-8");
            } catch (UnsupportedEncodingException e2) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, l.class.getName(), "Error during getDataString operation", e2);
            }
        }
        return null;
    }

    public Map<String, List<String>> e() {
        return this.f5121d;
    }

    public Exception f() {
        return this.f5125h;
    }

    public int g() {
        return this.f5119b;
    }

    public URL h() {
        return this.f5120c;
    }

    public boolean i() {
        return this.f5124g;
    }

    public boolean j() {
        return this.i.booleanValue();
    }

    public void a(Exception exc) {
        this.f5125h = exc;
    }

    public int b() {
        return this.f5122e;
    }

    public void a(URL url) {
        this.f5120c = url;
    }

    public void b(int i) {
        this.f5122e = i;
    }

    public void c(int i) {
        this.f5119b = i;
    }

    public void a(ByteBuffer byteBuffer) {
        this.f5118a = byteBuffer;
    }

    public void a(Map<String, List<String>> map) {
        this.f5121d = map;
    }

    public int a() {
        return this.f5123f;
    }

    public void a(int i) {
        this.f5123f = i;
    }
}
