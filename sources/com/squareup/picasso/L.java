package com.squareup.picasso;

import android.content.Context;
import android.net.Uri;
import android.net.http.HttpResponseCache;
import android.os.Build;
import com.facebook.stetho.server.http.HttpHeaders;
import com.squareup.picasso.Downloader;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: UrlConnectionDownloader.java */
/* loaded from: classes3.dex */
public class L implements Downloader {

    /* renamed from: a */
    static volatile Object f25595a;

    /* renamed from: b */
    private static final Object f25596b = new Object();

    /* renamed from: c */
    private static final ThreadLocal<StringBuilder> f25597c = new K();

    /* renamed from: d */
    private final Context f25598d;

    /* compiled from: UrlConnectionDownloader.java */
    /* loaded from: classes3.dex */
    public static class a {
        static Object a(Context context) throws IOException {
            File b2 = N.b(context);
            HttpResponseCache installed = HttpResponseCache.getInstalled();
            return installed == null ? HttpResponseCache.install(b2, N.a(b2)) : installed;
        }
    }

    public L(Context context) {
        this.f25598d = context.getApplicationContext();
    }

    protected HttpURLConnection a(Uri uri) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(uri.toString()).openConnection();
        httpURLConnection.setConnectTimeout(15000);
        httpURLConnection.setReadTimeout(20000);
        return httpURLConnection;
    }

    @Override // com.squareup.picasso.Downloader
    public Downloader.a a(Uri uri, int i) throws IOException {
        String sb;
        if (Build.VERSION.SDK_INT >= 14) {
            a(this.f25598d);
        }
        HttpURLConnection a2 = a(uri);
        a2.setUseCaches(true);
        if (i != 0) {
            if (NetworkPolicy.isOfflineOnly(i)) {
                sb = "only-if-cached,max-age=2147483647";
            } else {
                StringBuilder sb2 = f25597c.get();
                sb2.setLength(0);
                if (!NetworkPolicy.shouldReadFromDiskCache(i)) {
                    sb2.append("no-cache");
                }
                if (!NetworkPolicy.shouldWriteToDiskCache(i)) {
                    if (sb2.length() > 0) {
                        sb2.append(',');
                    }
                    sb2.append("no-store");
                }
                sb = sb2.toString();
            }
            a2.setRequestProperty("Cache-Control", sb);
        }
        int responseCode = a2.getResponseCode();
        if (responseCode < 300) {
            return new Downloader.a(a2.getInputStream(), N.a(a2.getHeaderField("X-Android-Response-Source")), a2.getHeaderFieldInt(HttpHeaders.CONTENT_LENGTH, -1));
        }
        a2.disconnect();
        throw new Downloader.ResponseException(responseCode + " " + a2.getResponseMessage(), i, responseCode);
    }

    private static void a(Context context) {
        if (f25595a == null) {
            try {
                synchronized (f25596b) {
                    if (f25595a == null) {
                        f25595a = a.a(context);
                    }
                }
            } catch (IOException unused) {
            }
        }
    }
}
