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

/* loaded from: classes2.dex */
public final class MediaHttpUploader {

    /* renamed from: b, reason: collision with root package name */
    private final AbstractInputStreamContent f14684b;

    /* renamed from: c, reason: collision with root package name */
    private final HttpRequestFactory f14685c;

    /* renamed from: d, reason: collision with root package name */
    private final HttpTransport f14686d;

    /* renamed from: e, reason: collision with root package name */
    private HttpContent f14687e;

    /* renamed from: f, reason: collision with root package name */
    private long f14688f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f14689g;
    private HttpRequest j;
    private InputStream k;
    private boolean l;
    private MediaHttpUploaderProgressListener m;
    private long o;
    private Byte q;
    private long r;
    private int s;
    private byte[] t;
    private boolean u;

    /* renamed from: a, reason: collision with root package name */
    private UploadState f14683a = UploadState.NOT_STARTED;

    /* renamed from: h, reason: collision with root package name */
    private String f14690h = "POST";
    private HttpHeaders i = new HttpHeaders();
    String n = "*";
    private int p = 10485760;
    Sleeper v = Sleeper.f14980a;

    /* loaded from: classes2.dex */
    public enum UploadState {
        NOT_STARTED,
        INITIATION_STARTED,
        INITIATION_COMPLETE,
        MEDIA_IN_PROGRESS,
        MEDIA_COMPLETE
    }

    public MediaHttpUploader(AbstractInputStreamContent abstractInputStreamContent, HttpTransport httpTransport, HttpRequestInitializer httpRequestInitializer) {
        Preconditions.a(abstractInputStreamContent);
        this.f14684b = abstractInputStreamContent;
        Preconditions.a(httpTransport);
        this.f14686d = httpTransport;
        this.f14685c = httpRequestInitializer == null ? httpTransport.createRequestFactory() : httpTransport.createRequestFactory(httpRequestInitializer);
    }

    private HttpResponse b(GenericUrl genericUrl) throws IOException {
        a(UploadState.MEDIA_IN_PROGRESS);
        HttpContent httpContent = this.f14684b;
        if (this.f14687e != null) {
            httpContent = new MultipartContent().a(Arrays.asList(this.f14687e, this.f14684b));
            genericUrl.put("uploadType", "multipart");
        } else {
            genericUrl.put("uploadType", "media");
        }
        HttpRequest a2 = this.f14685c.a(this.f14690h, genericUrl, httpContent);
        a2.e().putAll(this.i);
        HttpResponse a3 = a(a2);
        try {
            if (c()) {
                this.o = b();
            }
            a(UploadState.MEDIA_COMPLETE);
            return a3;
        } catch (Throwable th) {
            a3.a();
            throw th;
        }
    }

    private boolean c() throws IOException {
        return b() >= 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x0066, code lost:            r13.o = b();     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0072, code lost:            if (r13.f14684b.b() == false) goto L20;     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0074, code lost:            r13.k.close();     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0079, code lost:            a(com.google.api.client.googleapis.media.MediaHttpUploader.UploadState.MEDIA_COMPLETE);     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x007e, code lost:            return r14;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.google.api.client.http.HttpResponse d(com.google.api.client.http.GenericUrl r14) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 253
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.api.client.googleapis.media.MediaHttpUploader.d(com.google.api.client.http.GenericUrl):com.google.api.client.http.HttpResponse");
    }

    public HttpResponse a(GenericUrl genericUrl) throws IOException {
        Preconditions.a(this.f14683a == UploadState.NOT_STARTED);
        if (this.l) {
            return b(genericUrl);
        }
        return d(genericUrl);
    }

    private HttpResponse c(GenericUrl genericUrl) throws IOException {
        a(UploadState.INITIATION_STARTED);
        genericUrl.put("uploadType", "resumable");
        HttpContent httpContent = this.f14687e;
        if (httpContent == null) {
            httpContent = new EmptyContent();
        }
        HttpRequest a2 = this.f14685c.a(this.f14690h, genericUrl, httpContent);
        this.i.set("X-Upload-Content-Type", (Object) this.f14684b.getType());
        if (c()) {
            this.i.set("X-Upload-Content-Length", (Object) Long.valueOf(b()));
        }
        a2.e().putAll(this.i);
        HttpResponse a3 = a(a2);
        try {
            a(UploadState.INITIATION_COMPLETE);
            return a3;
        } catch (Throwable th) {
            a3.a();
            throw th;
        }
    }

    private HttpResponse a(HttpRequest httpRequest) throws IOException {
        if (!this.u && !(httpRequest.b() instanceof EmptyContent)) {
            httpRequest.a(new GZipEncoding());
        }
        return b(httpRequest);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Beta
    public void a() throws IOException {
        Preconditions.a(this.j, "The current request should not be null");
        this.j.a(new EmptyContent());
        this.j.e().d("bytes */" + this.n);
    }

    public MediaHttpUploader a(HttpContent httpContent) {
        this.f14687e = httpContent;
        return this;
    }

    public MediaHttpUploader a(boolean z) {
        this.u = z;
        return this;
    }

    public MediaHttpUploader a(String str) {
        Preconditions.a(str.equals("POST") || str.equals("PUT") || str.equals("PATCH"));
        this.f14690h = str;
        return this;
    }

    private long b() throws IOException {
        if (!this.f14689g) {
            this.f14688f = this.f14684b.getLength();
            this.f14689g = true;
        }
        return this.f14688f;
    }

    public MediaHttpUploader a(HttpHeaders httpHeaders) {
        this.i = httpHeaders;
        return this;
    }

    private void a(UploadState uploadState) throws IOException {
        this.f14683a = uploadState;
        MediaHttpUploaderProgressListener mediaHttpUploaderProgressListener = this.m;
        if (mediaHttpUploaderProgressListener != null) {
            mediaHttpUploaderProgressListener.a(this);
        }
    }

    private HttpResponse b(HttpRequest httpRequest) throws IOException {
        new MethodOverride().a(httpRequest);
        httpRequest.a(false);
        return httpRequest.a();
    }

    private long b(String str) {
        if (str == null) {
            return 0L;
        }
        return Long.parseLong(str.substring(str.indexOf(45) + 1)) + 1;
    }

    private void d() throws IOException {
        int i;
        int i2;
        int i3;
        HttpContent byteArrayContent;
        if (c()) {
            i = (int) Math.min(this.p, b() - this.o);
        } else {
            i = this.p;
        }
        if (c()) {
            this.k.mark(i);
            long j = i;
            byteArrayContent = new InputStreamContent(this.f14684b.getType(), ByteStreams.a(this.k, j)).b(true).a(j).a(false);
            this.n = String.valueOf(b());
        } else {
            byte[] bArr = this.t;
            if (bArr == null) {
                i3 = this.q == null ? i + 1 : i;
                this.t = new byte[i + 1];
                Byte b2 = this.q;
                if (b2 != null) {
                    this.t[0] = b2.byteValue();
                }
                i2 = 0;
            } else {
                i2 = (int) (this.r - this.o);
                System.arraycopy(bArr, this.s - i2, bArr, 0, i2);
                Byte b3 = this.q;
                if (b3 != null) {
                    this.t[i2] = b3.byteValue();
                }
                i3 = i - i2;
            }
            int a2 = ByteStreams.a(this.k, this.t, (i + 1) - i3, i3);
            if (a2 < i3) {
                int max = i2 + Math.max(0, a2);
                if (this.q != null) {
                    max++;
                    this.q = null;
                }
                if (this.n.equals("*")) {
                    this.n = String.valueOf(this.o + max);
                }
                i = max;
            } else {
                this.q = Byte.valueOf(this.t[i]);
            }
            byteArrayContent = new ByteArrayContent(this.f14684b.getType(), this.t, 0, i);
            this.r = this.o + i;
        }
        this.s = i;
        this.j.a(byteArrayContent);
        if (i == 0) {
            this.j.e().d("bytes */" + this.n);
            return;
        }
        this.j.e().d("bytes " + this.o + "-" + ((this.o + i) - 1) + "/" + this.n);
    }
}
