package com.facebook.internal;

import android.net.Uri;
import com.facebook.LoggingBehavior;
import com.facebook.internal.FileLruCache;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UrlRedirectCache.java */
/* loaded from: classes.dex */
public class C {

    /* renamed from: a, reason: collision with root package name */
    static final String f9270a = "C";

    /* renamed from: b, reason: collision with root package name */
    private static final String f9271b = f9270a + "_Redirect";

    /* renamed from: c, reason: collision with root package name */
    private static FileLruCache f9272c;

    C() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Uri a(Uri uri) {
        Throwable th;
        InputStreamReader inputStreamReader;
        InputStreamReader inputStreamReader2;
        boolean z;
        if (uri == null) {
            return null;
        }
        String uri2 = uri.toString();
        try {
            FileLruCache b2 = b();
            inputStreamReader2 = null;
            z = false;
            while (true) {
                try {
                    InputStream inputStream = b2.get(uri2, f9271b);
                    if (inputStream == null) {
                        break;
                    }
                    z = true;
                    inputStreamReader = new InputStreamReader(inputStream);
                    try {
                        char[] cArr = new char[128];
                        StringBuilder sb = new StringBuilder();
                        while (true) {
                            int read = inputStreamReader.read(cArr, 0, cArr.length);
                            if (read <= 0) {
                                break;
                            }
                            sb.append(cArr, 0, read);
                        }
                        Utility.closeQuietly(inputStreamReader);
                        inputStreamReader2 = inputStreamReader;
                        uri2 = sb.toString();
                    } catch (IOException unused) {
                        Utility.closeQuietly(inputStreamReader);
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        Utility.closeQuietly(inputStreamReader);
                        throw th;
                    }
                } catch (IOException unused2) {
                    inputStreamReader = inputStreamReader2;
                } catch (Throwable th3) {
                    th = th3;
                    inputStreamReader = inputStreamReader2;
                }
            }
        } catch (IOException unused3) {
            inputStreamReader = null;
        } catch (Throwable th4) {
            th = th4;
            inputStreamReader = null;
        }
        if (!z) {
            Utility.closeQuietly(inputStreamReader2);
            return null;
        }
        Uri parse = Uri.parse(uri2);
        Utility.closeQuietly(inputStreamReader2);
        return parse;
    }

    static synchronized FileLruCache b() throws IOException {
        FileLruCache fileLruCache;
        synchronized (C.class) {
            if (f9272c == null) {
                f9272c = new FileLruCache(f9270a, new FileLruCache.Limits());
            }
            fileLruCache = f9272c;
        }
        return fileLruCache;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Uri uri, Uri uri2) {
        if (uri == null || uri2 == null) {
            return;
        }
        OutputStream outputStream = null;
        try {
            outputStream = b().openPutStream(uri.toString(), f9271b);
            outputStream.write(uri2.toString().getBytes());
        } catch (IOException unused) {
        } catch (Throwable th) {
            Utility.closeQuietly(outputStream);
            throw th;
        }
        Utility.closeQuietly(outputStream);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a() {
        try {
            b().clearCache();
        } catch (IOException e2) {
            Logger.log(LoggingBehavior.CACHE, 5, f9270a, "clearCache failed " + e2.getMessage());
        }
    }
}
