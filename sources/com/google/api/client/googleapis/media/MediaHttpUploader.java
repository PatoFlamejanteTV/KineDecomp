package com.google.api.client.googleapis.media;

import com.google.api.client.googleapis.MethodOverride;
import com.google.api.client.http.AbstractInputStreamContent;
import com.google.api.client.http.ByteArrayContent;
import com.google.api.client.http.EmptyContent;
import com.google.api.client.http.GZipEncoding;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.InputStreamContent;
import com.google.api.client.http.MultipartContent;
import com.google.api.client.util.Beta;
import com.google.api.client.util.ByteStreams;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.Sleeper;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class MediaHttpUploader {
    private final AbstractInputStreamContent d;
    private final HttpRequestFactory e;
    private final HttpTransport f;
    private HttpContent g;
    private long h;
    private boolean i;
    private HttpRequest l;
    private InputStream m;
    private boolean n;
    private MediaHttpUploaderProgressListener o;
    private long p;
    private Byte r;
    private long s;
    private int t;
    private byte[] u;
    private boolean v;
    private UploadState c = UploadState.NOT_STARTED;
    private String j = "POST";
    private HttpHeaders k = new HttpHeaders();

    /* renamed from: a, reason: collision with root package name */
    String f2438a = "*";
    private int q = 10485760;
    Sleeper b = Sleeper.f2547a;

    /* loaded from: classes.dex */
    public enum UploadState {
        NOT_STARTED,
        INITIATION_STARTED,
        INITIATION_COMPLETE,
        MEDIA_IN_PROGRESS,
        MEDIA_COMPLETE
    }

    public MediaHttpUploader(AbstractInputStreamContent abstractInputStreamContent, HttpTransport httpTransport, HttpRequestInitializer httpRequestInitializer) {
        this.d = (AbstractInputStreamContent) Preconditions.a(abstractInputStreamContent);
        this.f = (HttpTransport) Preconditions.a(httpTransport);
        this.e = httpRequestInitializer == null ? httpTransport.createRequestFactory() : httpTransport.createRequestFactory(httpRequestInitializer);
    }

    public HttpResponse a(GenericUrl genericUrl) throws IOException {
        Preconditions.a(this.c == UploadState.NOT_STARTED);
        if (this.n) {
            return b(genericUrl);
        }
        return c(genericUrl);
    }

    private HttpResponse b(GenericUrl genericUrl) throws IOException {
        a(UploadState.MEDIA_IN_PROGRESS);
        HttpContent httpContent = this.d;
        if (this.g != null) {
            httpContent = new MultipartContent().a(Arrays.asList(this.g, this.d));
            genericUrl.put("uploadType", "multipart");
        } else {
            genericUrl.put("uploadType", "media");
        }
        HttpRequest a2 = this.e.a(this.j, genericUrl, httpContent);
        a2.g().putAll(this.k);
        HttpResponse b = b(a2);
        try {
            if (b()) {
                this.p = c();
            }
            a(UploadState.MEDIA_COMPLETE);
            return b;
        } catch (Throwable th) {
            b.i();
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x005f, code lost:            r10.p = c();     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x006b, code lost:            if (r10.d.c() == false) goto L19;     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x006d, code lost:            r10.m.close();     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0072, code lost:            a(com.google.api.client.googleapis.media.MediaHttpUploader.UploadState.MEDIA_COMPLETE);     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.google.api.client.http.HttpResponse c(com.google.api.client.http.GenericUrl r11) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 254
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.api.client.googleapis.media.MediaHttpUploader.c(com.google.api.client.http.GenericUrl):com.google.api.client.http.HttpResponse");
    }

    private boolean b() throws IOException {
        return c() >= 0;
    }

    private long c() throws IOException {
        if (!this.i) {
            this.h = this.d.a();
            this.i = true;
        }
        return this.h;
    }

    private HttpResponse d(GenericUrl genericUrl) throws IOException {
        a(UploadState.INITIATION_STARTED);
        genericUrl.put("uploadType", "resumable");
        HttpRequest a2 = this.e.a(this.j, genericUrl, this.g == null ? new EmptyContent() : this.g);
        this.k.set("X-Upload-Content-Type", (Object) this.d.d());
        if (b()) {
            this.k.set("X-Upload-Content-Length", Long.valueOf(c()));
        }
        a2.g().putAll(this.k);
        HttpResponse b = b(a2);
        try {
            a(UploadState.INITIATION_COMPLETE);
            return b;
        } catch (Throwable th) {
            b.i();
            throw th;
        }
    }

    private HttpResponse a(HttpRequest httpRequest) throws IOException {
        new MethodOverride().b(httpRequest);
        httpRequest.a(false);
        return httpRequest.p();
    }

    private HttpResponse b(HttpRequest httpRequest) throws IOException {
        if (!this.v && !(httpRequest.d() instanceof EmptyContent)) {
            httpRequest.a(new GZipEncoding());
        }
        return a(httpRequest);
    }

    private void d() throws IOException {
        int i;
        int i2;
        int i3;
        HttpContent byteArrayContent;
        if (b()) {
            i = (int) Math.min(this.q, c() - this.p);
        } else {
            i = this.q;
        }
        if (b()) {
            this.m.mark(i);
            byteArrayContent = new InputStreamContent(this.d.d(), ByteStreams.a(this.m, i)).b(true).a(i).a(false);
            this.f2438a = String.valueOf(c());
        } else {
            if (this.u == null) {
                int i4 = this.r == null ? i + 1 : i;
                this.u = new byte[i + 1];
                if (this.r != null) {
                    this.u[0] = this.r.byteValue();
                    i3 = i4;
                    i2 = 0;
                } else {
                    i3 = i4;
                    i2 = 0;
                }
            } else {
                i2 = (int) (this.s - this.p);
                System.arraycopy(this.u, this.t - i2, this.u, 0, i2);
                if (this.r != null) {
                    this.u[i2] = this.r.byteValue();
                }
                i3 = i - i2;
            }
            int a2 = ByteStreams.a(this.m, this.u, (i + 1) - i3, i3);
            if (a2 < i3) {
                i = Math.max(0, a2) + i2;
                if (this.r != null) {
                    i++;
                    this.r = null;
                }
                if (this.f2438a.equals("*")) {
                    this.f2438a = String.valueOf(this.p + i);
                }
            } else {
                this.r = Byte.valueOf(this.u[i]);
            }
            byteArrayContent = new ByteArrayContent(this.d.d(), this.u, 0, i);
            this.s = this.p + i;
        }
        this.t = i;
        this.l.a(byteArrayContent);
        if (i == 0) {
            this.l.g().d("bytes */0");
            return;
        }
        HttpHeaders g = this.l.g();
        long j = this.p;
        long j2 = (this.p + i) - 1;
        String valueOf = String.valueOf(String.valueOf(this.f2438a));
        g.d(new StringBuilder(valueOf.length() + 48).append("bytes ").append(j).append("-").append(j2).append("/").append(valueOf).toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Beta
    public void a() throws IOException {
        Preconditions.a(this.l, "The current request should not be null");
        this.l.a(new EmptyContent());
        HttpHeaders g = this.l.g();
        String valueOf = String.valueOf(String.valueOf(b() ? Long.valueOf(c()) : "*"));
        g.d(new StringBuilder(valueOf.length() + 8).append("bytes */").append(valueOf).toString());
    }

    private long b(String str) {
        if (str == null) {
            return 0L;
        }
        return Long.parseLong(str.substring(str.indexOf(45) + 1)) + 1;
    }

    public MediaHttpUploader a(HttpContent httpContent) {
        this.g = httpContent;
        return this;
    }

    public MediaHttpUploader a(boolean z) {
        this.v = z;
        return this;
    }

    public MediaHttpUploader a(String str) {
        Preconditions.a(str.equals("POST") || str.equals("PUT"));
        this.j = str;
        return this;
    }

    public MediaHttpUploader a(HttpHeaders httpHeaders) {
        this.k = httpHeaders;
        return this;
    }

    private void a(UploadState uploadState) throws IOException {
        this.c = uploadState;
        if (this.o != null) {
            this.o.a(this);
        }
    }
}
