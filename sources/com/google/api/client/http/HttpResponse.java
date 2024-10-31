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

/* loaded from: classes2.dex */
public final class HttpResponse {

    /* renamed from: a */
    private InputStream f14774a;

    /* renamed from: b */
    private final String f14775b;

    /* renamed from: c */
    private final String f14776c;

    /* renamed from: d */
    private final HttpMediaType f14777d;

    /* renamed from: e */
    LowLevelHttpResponse f14778e;

    /* renamed from: f */
    private final int f14779f;

    /* renamed from: g */
    private final String f14780g;

    /* renamed from: h */
    private final HttpRequest f14781h;
    private int i;
    private boolean j;
    private boolean k;

    public HttpResponse(HttpRequest httpRequest, LowLevelHttpResponse lowLevelHttpResponse) throws IOException {
        StringBuilder sb;
        this.f14781h = httpRequest;
        this.i = httpRequest.c();
        this.j = httpRequest.p();
        this.f14778e = lowLevelHttpResponse;
        this.f14775b = lowLevelHttpResponse.c();
        int g2 = lowLevelHttpResponse.g();
        boolean z = false;
        this.f14779f = g2 < 0 ? 0 : g2;
        String f2 = lowLevelHttpResponse.f();
        this.f14780g = f2;
        Logger logger = HttpTransport.LOGGER;
        if (this.j && logger.isLoggable(Level.CONFIG)) {
            z = true;
        }
        if (z) {
            sb = new StringBuilder();
            sb.append("-------------- RESPONSE --------------");
            sb.append(StringUtils.f14981a);
            String h2 = lowLevelHttpResponse.h();
            if (h2 != null) {
                sb.append(h2);
            } else {
                sb.append(this.f14779f);
                if (f2 != null) {
                    sb.append(' ');
                    sb.append(f2);
                }
            }
            sb.append(StringUtils.f14981a);
        } else {
            sb = null;
        }
        httpRequest.j().a(lowLevelHttpResponse, z ? sb : null);
        String d2 = lowLevelHttpResponse.d();
        d2 = d2 == null ? httpRequest.j().getContentType() : d2;
        this.f14776c = d2;
        this.f14777d = d2 != null ? new HttpMediaType(d2) : null;
        if (z) {
            logger.config(sb.toString());
        }
    }

    private boolean l() throws IOException {
        int g2 = g();
        if (!f().i().equals("HEAD") && g2 / 100 != 1 && g2 != 204 && g2 != 304) {
            return true;
        }
        i();
        return false;
    }

    public void a(OutputStream outputStream) throws IOException {
        IOUtils.a(b(), outputStream);
    }

    public InputStream b() throws IOException {
        if (!this.k) {
            InputStream b2 = this.f14778e.b();
            if (b2 != null) {
                try {
                    String str = this.f14775b;
                    if (str != null && str.contains("gzip")) {
                        b2 = new GZIPInputStream(b2);
                    }
                    Logger logger = HttpTransport.LOGGER;
                    if (this.j && logger.isLoggable(Level.CONFIG)) {
                        b2 = new LoggingInputStream(b2, logger, Level.CONFIG, this.i);
                    }
                    this.f14774a = b2;
                } catch (EOFException unused) {
                    b2.close();
                } catch (Throwable th) {
                    b2.close();
                    throw th;
                }
            }
            this.k = true;
        }
        return this.f14774a;
    }

    public Charset c() {
        HttpMediaType httpMediaType = this.f14777d;
        if (httpMediaType != null && httpMediaType.b() != null) {
            return this.f14777d.b();
        }
        return Charsets.f14916b;
    }

    public String d() {
        return this.f14776c;
    }

    public HttpHeaders e() {
        return this.f14781h.j();
    }

    public HttpRequest f() {
        return this.f14781h;
    }

    public int g() {
        return this.f14779f;
    }

    public String h() {
        return this.f14780g;
    }

    public void i() throws IOException {
        InputStream b2 = b();
        if (b2 != null) {
            b2.close();
        }
    }

    public boolean j() {
        return HttpStatusCodes.b(this.f14779f);
    }

    public String k() throws IOException {
        InputStream b2 = b();
        if (b2 == null) {
            return "";
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        IOUtils.a(b2, (OutputStream) byteArrayOutputStream);
        return byteArrayOutputStream.toString(c().name());
    }

    public void a() throws IOException {
        i();
        this.f14778e.a();
    }

    public <T> T a(Class<T> cls) throws IOException {
        if (l()) {
            return (T) this.f14781h.h().a(b(), c(), cls);
        }
        return null;
    }
}
