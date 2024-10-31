package com.google.api.client.googleapis.media;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.util.IOUtils;
import com.google.api.client.util.Preconditions;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public final class MediaHttpDownloader {

    /* renamed from: a, reason: collision with root package name */
    private final HttpRequestFactory f2437a;
    private final HttpTransport b;
    private MediaHttpDownloaderProgressListener d;
    private long f;
    private long h;
    private boolean c = false;
    private int e = 33554432;
    private DownloadState g = DownloadState.NOT_STARTED;
    private long i = -1;

    /* loaded from: classes.dex */
    public enum DownloadState {
        NOT_STARTED,
        MEDIA_IN_PROGRESS,
        MEDIA_COMPLETE
    }

    public MediaHttpDownloader(HttpTransport httpTransport, HttpRequestInitializer httpRequestInitializer) {
        this.b = (HttpTransport) Preconditions.a(httpTransport);
        this.f2437a = httpRequestInitializer == null ? httpTransport.createRequestFactory() : httpTransport.createRequestFactory(httpRequestInitializer);
    }

    public void a(GenericUrl genericUrl, OutputStream outputStream) throws IOException {
        a(genericUrl, null, outputStream);
    }

    public void a(GenericUrl genericUrl, HttpHeaders httpHeaders, OutputStream outputStream) throws IOException {
        Preconditions.a(this.g == DownloadState.NOT_STARTED);
        genericUrl.put("alt", "media");
        if (this.c) {
            a(DownloadState.MEDIA_IN_PROGRESS);
            this.f = a(this.i, genericUrl, httpHeaders, outputStream).b().c().longValue();
            this.h = this.f;
            a(DownloadState.MEDIA_COMPLETE);
            return;
        }
        while (true) {
            long j = (this.h + this.e) - 1;
            if (this.i != -1) {
                j = Math.min(this.i, j);
            }
            String d = a(j, genericUrl, httpHeaders, outputStream).b().d();
            long a2 = a(d);
            b(d);
            if (this.f <= a2) {
                this.h = this.f;
                a(DownloadState.MEDIA_COMPLETE);
                return;
            } else {
                this.h = a2;
                a(DownloadState.MEDIA_IN_PROGRESS);
            }
        }
    }

    private HttpResponse a(long j, GenericUrl genericUrl, HttpHeaders httpHeaders, OutputStream outputStream) throws IOException {
        HttpRequest a2 = this.f2437a.a(genericUrl);
        if (httpHeaders != null) {
            a2.g().putAll(httpHeaders);
        }
        if (this.h != 0 || j != -1) {
            StringBuilder sb = new StringBuilder();
            sb.append("bytes=").append(this.h).append("-");
            if (j != -1) {
                sb.append(j);
            }
            a2.g().k(sb.toString());
        }
        HttpResponse p = a2.p();
        try {
            IOUtils.a(p.g(), outputStream);
            return p;
        } finally {
            p.i();
        }
    }

    private long a(String str) {
        if (str == null) {
            return 0L;
        }
        return Long.parseLong(str.substring(str.indexOf(45) + 1, str.indexOf(47))) + 1;
    }

    private void b(String str) {
        if (str != null && this.f == 0) {
            this.f = Long.parseLong(str.substring(str.indexOf(47) + 1));
        }
    }

    public MediaHttpDownloader a(boolean z) {
        this.c = z;
        return this;
    }

    public MediaHttpDownloader a(MediaHttpDownloaderProgressListener mediaHttpDownloaderProgressListener) {
        this.d = mediaHttpDownloaderProgressListener;
        return this;
    }

    public MediaHttpDownloader a(int i) {
        Preconditions.a(i > 0 && i <= 33554432);
        this.e = i;
        return this;
    }

    private void a(DownloadState downloadState) throws IOException {
        this.g = downloadState;
        if (this.d != null) {
            this.d.a(this);
        }
    }

    public DownloadState a() {
        return this.g;
    }

    public double b() {
        if (this.f == 0) {
            return 0.0d;
        }
        return this.h / this.f;
    }
}
