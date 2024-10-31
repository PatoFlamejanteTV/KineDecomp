package com.google.api.client.http.javanet;

import com.facebook.stetho.server.http.HttpHeaders;
import com.google.api.client.http.LowLevelHttpResponse;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: NetHttpResponse.java */
/* loaded from: classes2.dex */
public final class b extends LowLevelHttpResponse {

    /* renamed from: a */
    private final HttpURLConnection f14817a;

    /* renamed from: b */
    private final int f14818b;

    /* renamed from: c */
    private final String f14819c;

    /* renamed from: d */
    private final ArrayList<String> f14820d = new ArrayList<>();

    /* renamed from: e */
    private final ArrayList<String> f14821e = new ArrayList<>();

    public b(HttpURLConnection httpURLConnection) throws IOException {
        this.f14817a = httpURLConnection;
        int responseCode = httpURLConnection.getResponseCode();
        this.f14818b = responseCode == -1 ? 0 : responseCode;
        this.f14819c = httpURLConnection.getResponseMessage();
        ArrayList<String> arrayList = this.f14820d;
        ArrayList<String> arrayList2 = this.f14821e;
        for (Map.Entry<String, List<String>> entry : httpURLConnection.getHeaderFields().entrySet()) {
            String key = entry.getKey();
            if (key != null) {
                for (String str : entry.getValue()) {
                    if (str != null) {
                        arrayList.add(key);
                        arrayList2.add(str);
                    }
                }
            }
        }
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public String a(int i) {
        return this.f14820d.get(i);
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public InputStream b() throws IOException {
        InputStream errorStream;
        try {
            errorStream = this.f14817a.getInputStream();
        } catch (IOException unused) {
            errorStream = this.f14817a.getErrorStream();
        }
        if (errorStream == null) {
            return null;
        }
        return new a(errorStream);
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public String c() {
        return this.f14817a.getContentEncoding();
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public String d() {
        return this.f14817a.getHeaderField(HttpHeaders.CONTENT_TYPE);
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public int e() {
        return this.f14820d.size();
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public String f() {
        return this.f14819c;
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public int g() {
        return this.f14818b;
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public String h() {
        String headerField = this.f14817a.getHeaderField(0);
        if (headerField == null || !headerField.startsWith("HTTP/1.")) {
            return null;
        }
        return headerField;
    }

    public long i() {
        String headerField = this.f14817a.getHeaderField(HttpHeaders.CONTENT_LENGTH);
        if (headerField == null) {
            return -1L;
        }
        return Long.parseLong(headerField);
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public void a() {
        this.f14817a.disconnect();
    }

    /* compiled from: NetHttpResponse.java */
    /* loaded from: classes2.dex */
    private final class a extends FilterInputStream {

        /* renamed from: a */
        private long f14822a;

        public a(InputStream inputStream) {
            super(inputStream);
            this.f14822a = 0L;
        }

        private void a() throws IOException {
            long i = b.this.i();
            if (i == -1) {
                return;
            }
            long j = this.f14822a;
            if (j == 0 || j >= i) {
                return;
            }
            throw new IOException("Connection closed prematurely: bytesRead = " + this.f14822a + ", Content-Length = " + i);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int read = ((FilterInputStream) this).in.read(bArr, i, i2);
            if (read == -1) {
                a();
            } else {
                this.f14822a += read;
            }
            return read;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public long skip(long j) throws IOException {
            long skip = ((FilterInputStream) this).in.skip(j);
            this.f14822a += skip;
            return skip;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            int read = ((FilterInputStream) this).in.read();
            if (read == -1) {
                a();
            } else {
                this.f14822a++;
            }
            return read;
        }
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public String b(int i) {
        return this.f14821e.get(i);
    }
}
