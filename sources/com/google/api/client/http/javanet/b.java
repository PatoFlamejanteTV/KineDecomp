package com.google.api.client.http.javanet;

import com.google.api.client.http.LowLevelHttpResponse;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NetHttpResponse.java */
/* loaded from: classes.dex */
public final class b extends LowLevelHttpResponse {

    /* renamed from: a, reason: collision with root package name */
    private final HttpURLConnection f2486a;
    private final int b;
    private final String c;
    private final ArrayList<String> d = new ArrayList<>();
    private final ArrayList<String> e = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(HttpURLConnection httpURLConnection) throws IOException {
        this.f2486a = httpURLConnection;
        int responseCode = httpURLConnection.getResponseCode();
        this.b = responseCode == -1 ? 0 : responseCode;
        this.c = httpURLConnection.getResponseMessage();
        ArrayList<String> arrayList = this.d;
        ArrayList<String> arrayList2 = this.e;
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
    public int e() {
        return this.b;
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public InputStream a() throws IOException {
        InputStream errorStream;
        try {
            errorStream = this.f2486a.getInputStream();
        } catch (IOException e) {
            errorStream = this.f2486a.getErrorStream();
        }
        if (errorStream == null) {
            return null;
        }
        return new a(errorStream);
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public String b() {
        return this.f2486a.getContentEncoding();
    }

    public long i() {
        String headerField = this.f2486a.getHeaderField("Content-Length");
        if (headerField == null) {
            return -1L;
        }
        return Long.parseLong(headerField);
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public String c() {
        return this.f2486a.getHeaderField("Content-Type");
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public String f() {
        return this.c;
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public String d() {
        String headerField = this.f2486a.getHeaderField(0);
        if (headerField == null || !headerField.startsWith("HTTP/1.")) {
            return null;
        }
        return headerField;
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public int g() {
        return this.d.size();
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public String a(int i) {
        return this.d.get(i);
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public String b(int i) {
        return this.e.get(i);
    }

    @Override // com.google.api.client.http.LowLevelHttpResponse
    public void h() {
        this.f2486a.disconnect();
    }

    /* compiled from: NetHttpResponse.java */
    /* loaded from: classes.dex */
    private final class a extends FilterInputStream {
        private long b;

        public a(InputStream inputStream) {
            super(inputStream);
            this.b = 0L;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int read = this.in.read(bArr, i, i2);
            if (read == -1) {
                a();
            } else {
                this.b += read;
            }
            return read;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            int read = this.in.read();
            if (read == -1) {
                a();
            } else {
                this.b++;
            }
            return read;
        }

        private void a() throws IOException {
            long i = b.this.i();
            if (i != -1 && this.b != 0 && this.b < i) {
                throw new IOException(new StringBuilder(102).append("Connection closed prematurely: bytesRead = ").append(this.b).append(", Content-Length = ").append(i).toString());
            }
        }
    }
}
