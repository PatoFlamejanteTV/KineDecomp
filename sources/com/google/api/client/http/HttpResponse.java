package com.google.api.client.http;

import com.google.api.client.util.Charsets;
import com.google.api.client.util.IOUtils;
import com.google.api.client.util.LoggingInputStream;
import com.google.api.client.util.StringUtils;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPInputStream;

/* loaded from: classes.dex */
public final class HttpResponse {

    /* renamed from: a, reason: collision with root package name */
    LowLevelHttpResponse f2467a;
    private InputStream b;
    private final String c;
    private final String d;
    private final HttpMediaType e;
    private final int f;
    private final String g;
    private final HttpRequest h;
    private int i;
    private boolean j;
    private boolean k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HttpResponse(HttpRequest httpRequest, LowLevelHttpResponse lowLevelHttpResponse) throws IOException {
        StringBuilder sb;
        this.h = httpRequest;
        this.i = httpRequest.e();
        this.j = httpRequest.f();
        this.f2467a = lowLevelHttpResponse;
        this.c = lowLevelHttpResponse.b();
        int e = lowLevelHttpResponse.e();
        this.f = e < 0 ? 0 : e;
        String f = lowLevelHttpResponse.f();
        this.g = f;
        Logger logger = HttpTransport.LOGGER;
        boolean z = this.j && logger.isLoggable(Level.CONFIG);
        if (z) {
            sb = new StringBuilder();
            sb.append("-------------- RESPONSE --------------").append(StringUtils.f2548a);
            String d = lowLevelHttpResponse.d();
            if (d != null) {
                sb.append(d);
            } else {
                sb.append(this.f);
                if (f != null) {
                    sb.append(' ').append(f);
                }
            }
            sb.append(StringUtils.f2548a);
        } else {
            sb = null;
        }
        httpRequest.h().a(lowLevelHttpResponse, z ? sb : null);
        String c = lowLevelHttpResponse.c();
        c = c == null ? httpRequest.h().e() : c;
        this.d = c;
        this.e = c != null ? new HttpMediaType(c) : null;
        if (z) {
            logger.config(sb.toString());
        }
    }

    public String a() {
        return this.d;
    }

    public HttpHeaders b() {
        return this.h.h();
    }

    public boolean c() {
        return HttpStatusCodes.a(this.f);
    }

    public int d() {
        return this.f;
    }

    public String e() {
        return this.g;
    }

    public HttpRequest f() {
        return this.h;
    }

    public InputStream g() throws IOException {
        InputStream inputStream;
        Throwable th;
        if (!this.k) {
            InputStream a2 = this.f2467a.a();
            if (a2 != null) {
                try {
                    try {
                        String str = this.c;
                        if (str != null && str.contains("gzip")) {
                            a2 = new GZIPInputStream(a2);
                        }
                        try {
                            Logger logger = HttpTransport.LOGGER;
                            if (this.j && logger.isLoggable(Level.CONFIG)) {
                                a2 = new LoggingInputStream(a2, logger, Level.CONFIG, this.i);
                            }
                            this.b = a2;
                        } catch (Throwable th2) {
                            inputStream = a2;
                            th = th2;
                            inputStream.close();
                            throw th;
                        }
                    } catch (EOFException e) {
                        a2.close();
                    }
                } catch (Throwable th3) {
                    inputStream = a2;
                    th = th3;
                }
            }
            this.k = true;
        }
        return this.b;
    }

    public void a(OutputStream outputStream) throws IOException {
        IOUtils.a(g(), outputStream);
    }

    public void h() throws IOException {
        InputStream g = g();
        if (g != null) {
            g.close();
        }
    }

    public void i() throws IOException {
        h();
        this.f2467a.h();
    }

    public <T> T a(Class<T> cls) throws IOException {
        if (l()) {
            return (T) this.h.m().a(g(), k(), cls);
        }
        return null;
    }

    private boolean l() throws IOException {
        int d = d();
        if (!f().b().equals("HEAD") && d / 100 != 1 && d != 204 && d != 304) {
            return true;
        }
        h();
        return false;
    }

    public String j() throws IOException {
        InputStream g = g();
        if (g == null) {
            return "";
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        IOUtils.a(g, (OutputStream) byteArrayOutputStream);
        return byteArrayOutputStream.toString(k().name());
    }

    public Charset k() {
        return (this.e == null || this.e.d() == null) ? Charsets.b : this.e.d();
    }
}
