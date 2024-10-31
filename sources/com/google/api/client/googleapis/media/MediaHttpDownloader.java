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

/* loaded from: classes2.dex */
public final class MediaHttpDownloader {

    /* renamed from: a */
    private final HttpRequestFactory f14675a;

    /* renamed from: b */
    private final HttpTransport f14676b;

    /* renamed from: d */
    private MediaHttpDownloaderProgressListener f14678d;

    /* renamed from: f */
    private long f14680f;

    /* renamed from: h */
    private long f14682h;

    /* renamed from: c */
    private boolean f14677c = false;

    /* renamed from: e */
    private int f14679e = 33554432;

    /* renamed from: g */
    private DownloadState f14681g = DownloadState.NOT_STARTED;
    private long i = -1;

    /* loaded from: classes2.dex */
    public enum DownloadState {
        NOT_STARTED,
        MEDIA_IN_PROGRESS,
        MEDIA_COMPLETE
    }

    public MediaHttpDownloader(HttpTransport httpTransport, HttpRequestInitializer httpRequestInitializer) {
        Preconditions.a(httpTransport);
        this.f14676b = httpTransport;
        this.f14675a = httpRequestInitializer == null ? httpTransport.createRequestFactory() : httpTransport.createRequestFactory(httpRequestInitializer);
    }

    private void b(String str) {
        if (str != null && this.f14680f == 0) {
            this.f14680f = Long.parseLong(str.substring(str.indexOf(47) + 1));
        }
    }

    public void a(GenericUrl genericUrl, OutputStream outputStream) throws IOException {
        a(genericUrl, null, outputStream);
    }

    public void a(GenericUrl genericUrl, HttpHeaders httpHeaders, OutputStream outputStream) throws IOException {
        Preconditions.a(this.f14681g == DownloadState.NOT_STARTED);
        genericUrl.put("alt", "media");
        if (this.f14677c) {
            a(DownloadState.MEDIA_IN_PROGRESS);
            this.f14680f = a(this.i, genericUrl, httpHeaders, outputStream).e().c().longValue();
            this.f14682h = this.f14680f;
            a(DownloadState.MEDIA_COMPLETE);
            return;
        }
        while (true) {
            long j = (this.f14682h + this.f14679e) - 1;
            long j2 = this.i;
            if (j2 != -1) {
                j = Math.min(j2, j);
            }
            String d2 = a(j, genericUrl, httpHeaders, outputStream).e().d();
            long a2 = a(d2);
            b(d2);
            long j3 = this.f14680f;
            if (j3 <= a2) {
                this.f14682h = j3;
                a(DownloadState.MEDIA_COMPLETE);
                return;
            } else {
                this.f14682h = a2;
                a(DownloadState.MEDIA_IN_PROGRESS);
            }
        }
    }

    public double b() {
        long j = this.f14680f;
        if (j == 0) {
            return 0.0d;
        }
        double d2 = this.f14682h;
        double d3 = j;
        Double.isNaN(d2);
        Double.isNaN(d3);
        return d2 / d3;
    }

    private HttpResponse a(long j, GenericUrl genericUrl, HttpHeaders httpHeaders, OutputStream outputStream) throws IOException {
        HttpRequest a2 = this.f14675a.a(genericUrl);
        if (httpHeaders != null) {
            a2.e().putAll(httpHeaders);
        }
        if (this.f14682h != 0 || j != -1) {
            StringBuilder sb = new StringBuilder();
            sb.append("bytes=");
            sb.append(this.f14682h);
            sb.append("-");
            if (j != -1) {
                sb.append(j);
            }
            a2.e().j(sb.toString());
        }
        HttpResponse a3 = a2.a();
        try {
            IOUtils.a(a3.b(), outputStream);
            return a3;
        } finally {
            a3.a();
        }
    }

    private long a(String str) {
        if (str == null) {
            return 0L;
        }
        return Long.parseLong(str.substring(str.indexOf(45) + 1, str.indexOf(47))) + 1;
    }

    public MediaHttpDownloader a(MediaHttpDownloaderProgressListener mediaHttpDownloaderProgressListener) {
        this.f14678d = mediaHttpDownloaderProgressListener;
        return this;
    }

    public MediaHttpDownloader a(int i) {
        Preconditions.a(i > 0 && i <= 33554432);
        this.f14679e = i;
        return this;
    }

    private void a(DownloadState downloadState) throws IOException {
        this.f14681g = downloadState;
        MediaHttpDownloaderProgressListener mediaHttpDownloaderProgressListener = this.f14678d;
        if (mediaHttpDownloaderProgressListener != null) {
            mediaHttpDownloaderProgressListener.a(this);
        }
    }

    public DownloadState a() {
        return this.f14681g;
    }
}
