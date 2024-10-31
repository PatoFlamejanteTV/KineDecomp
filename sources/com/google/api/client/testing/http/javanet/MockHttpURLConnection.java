package com.google.api.client.testing.http.javanet;

import com.google.api.client.util.Beta;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;

@Beta
/* loaded from: classes.dex */
public class MockHttpURLConnection extends HttpURLConnection {

    /* renamed from: a, reason: collision with root package name */
    @Deprecated
    public static final byte[] f2512a = new byte[1];

    @Deprecated
    public static final byte[] b = new byte[5];
    private boolean c;
    private OutputStream d;
    private InputStream e;
    private InputStream f;
    private Map<String, List<String>> g;

    @Override // java.net.HttpURLConnection
    public void disconnect() {
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        return false;
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws IOException {
        return this.responseCode;
    }

    @Override // java.net.URLConnection
    public void setDoOutput(boolean z) {
        this.c = true;
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        return this.d != null ? this.d : super.getOutputStream();
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() throws IOException {
        if (this.responseCode < 400) {
            return this.e;
        }
        throw new IOException();
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        return this.f;
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        return this.g;
    }

    @Override // java.net.URLConnection
    public String getHeaderField(String str) {
        List<String> list = this.g.get(str);
        if (list == null) {
            return null;
        }
        return list.get(0);
    }
}
