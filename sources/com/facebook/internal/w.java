package com.facebook.internal;

import android.content.Context;
import android.net.Uri;
import com.facebook.LoggingBehavior;
import com.facebook.internal.FileLruCache;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ImageResponseCache.java */
/* loaded from: classes.dex */
public class w {

    /* renamed from: a, reason: collision with root package name */
    static final String f9339a = "w";

    /* renamed from: b, reason: collision with root package name */
    private static FileLruCache f9340b;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ImageResponseCache.java */
    /* loaded from: classes.dex */
    public static class a extends BufferedInputStream {

        /* renamed from: a, reason: collision with root package name */
        HttpURLConnection f9341a;

        a(InputStream inputStream, HttpURLConnection httpURLConnection) {
            super(inputStream, 8192);
            this.f9341a = httpURLConnection;
        }

        @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            super.close();
            Utility.disconnectQuietly(this.f9341a);
        }
    }

    w() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static InputStream a(Uri uri, Context context) {
        if (uri != null && a(uri)) {
            try {
                return b(context).get(uri.toString());
            } catch (IOException e2) {
                Logger.log(LoggingBehavior.CACHE, 5, f9339a, e2.toString());
            }
        }
        return null;
    }

    static synchronized FileLruCache b(Context context) throws IOException {
        FileLruCache fileLruCache;
        synchronized (w.class) {
            if (f9340b == null) {
                f9340b = new FileLruCache(f9339a, new FileLruCache.Limits());
            }
            fileLruCache = f9340b;
        }
        return fileLruCache;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static InputStream a(Context context, HttpURLConnection httpURLConnection) throws IOException {
        if (httpURLConnection.getResponseCode() != 200) {
            return null;
        }
        Uri parse = Uri.parse(httpURLConnection.getURL().toString());
        InputStream inputStream = httpURLConnection.getInputStream();
        try {
            return a(parse) ? b(context).interceptAndPut(parse.toString(), new a(inputStream, httpURLConnection)) : inputStream;
        } catch (IOException unused) {
            return inputStream;
        }
    }

    private static boolean a(Uri uri) {
        if (uri == null) {
            return false;
        }
        String host = uri.getHost();
        if (host.endsWith("fbcdn.net")) {
            return true;
        }
        return host.startsWith("fbcdn") && host.endsWith("akamaihd.net");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context) {
        try {
            b(context).clearCache();
        } catch (IOException e2) {
            Logger.log(LoggingBehavior.CACHE, 5, f9339a, "clearCache failed " + e2.getMessage());
        }
    }
}
