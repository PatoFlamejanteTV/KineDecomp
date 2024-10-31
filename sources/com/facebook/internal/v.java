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
public class v {

    /* renamed from: a, reason: collision with root package name */
    static final String f299a = v.class.getSimpleName();
    private static volatile FileLruCache b;

    v() {
    }

    static synchronized FileLruCache a(Context context) throws IOException {
        FileLruCache fileLruCache;
        synchronized (v.class) {
            if (b == null) {
                b = new FileLruCache(f299a, new FileLruCache.Limits());
            }
            fileLruCache = b;
        }
        return fileLruCache;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static InputStream a(Uri uri, Context context) {
        if (uri == null || !a(uri)) {
            return null;
        }
        try {
            return a(context).get(uri.toString());
        } catch (IOException e) {
            Logger.log(LoggingBehavior.CACHE, 5, f299a, e.toString());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static InputStream a(Context context, HttpURLConnection httpURLConnection) throws IOException {
        if (httpURLConnection.getResponseCode() != 200) {
            return null;
        }
        Uri parse = Uri.parse(httpURLConnection.getURL().toString());
        InputStream inputStream = httpURLConnection.getInputStream();
        try {
            if (a(parse)) {
                return a(context).interceptAndPut(parse.toString(), new a(inputStream, httpURLConnection));
            }
            return inputStream;
        } catch (IOException e) {
            return inputStream;
        }
    }

    private static boolean a(Uri uri) {
        if (uri != null) {
            String host = uri.getHost();
            if (host.endsWith("fbcdn.net")) {
                return true;
            }
            if (host.startsWith("fbcdn") && host.endsWith("akamaihd.net")) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(Context context) {
        try {
            a(context).clearCache();
        } catch (IOException e) {
            Logger.log(LoggingBehavior.CACHE, 5, f299a, "clearCache failed " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ImageResponseCache.java */
    /* loaded from: classes.dex */
    public static class a extends BufferedInputStream {

        /* renamed from: a, reason: collision with root package name */
        HttpURLConnection f300a;

        a(InputStream inputStream, HttpURLConnection httpURLConnection) {
            super(inputStream, Utility.DEFAULT_STREAM_BUFFER_SIZE);
            this.f300a = httpURLConnection;
        }

        @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            super.close();
            Utility.disconnectQuietly(this.f300a);
        }
    }
}
