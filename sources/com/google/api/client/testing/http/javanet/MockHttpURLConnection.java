package com.google.api.client.testing.http.javanet;

import com.google.api.client.util.Beta;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;

@Beta
/* loaded from: classes2.dex */
public class MockHttpURLConnection extends HttpURLConnection {

    /* renamed from: a */
    @Deprecated
    public static final byte[] f14870a = new byte[1];

    /* renamed from: b */
    @Deprecated
    public static final byte[] f14871b = new byte[5];

    /* renamed from: c */
    private boolean f14872c;

    /* renamed from: d */
    private OutputStream f14873d;

    /* renamed from: e */
    private InputStream f14874e;

    /* renamed from: f */
    private InputStream f14875f;

    /* renamed from: g */
    private Map<String, List<String>> f14876g;

    @Override // java.net.URLConnection
    public void connect() throws IOException {
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        return this.f14875f;
    }

    @Override // java.net.URLConnection
    public String getHeaderField(String str) {
        List<String> list = this.f14876g.get(str);
        if (list == null) {
            return null;
        }
        return list.get(0);
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        return this.f14876g;
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() throws IOException {
        if (((HttpURLConnection) this).responseCode < 400) {
            return this.f14874e;
        }
        throw new IOException();
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        OutputStream outputStream = this.f14873d;
        return outputStream != null ? outputStream : super.getOutputStream();
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws IOException {
        return ((HttpURLConnection) this).responseCode;
    }

    @Override // java.net.URLConnection
    public void setDoOutput(boolean z) {
        this.f14872c = true;
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        return false;
    }
}
