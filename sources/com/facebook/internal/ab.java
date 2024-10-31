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
public class ab {

    /* renamed from: a, reason: collision with root package name */
    static final String f281a = ab.class.getSimpleName();
    private static final String b = f281a + "_Redirect";
    private static volatile FileLruCache c;

    ab() {
    }

    static synchronized FileLruCache a() throws IOException {
        FileLruCache fileLruCache;
        synchronized (ab.class) {
            if (c == null) {
                c = new FileLruCache(f281a, new FileLruCache.Limits());
            }
            fileLruCache = c;
        }
        return fileLruCache;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Uri a(Uri uri) {
        InputStreamReader inputStreamReader;
        Throwable th;
        Uri uri2 = null;
        boolean z = false;
        if (uri != null) {
            String uri3 = uri.toString();
            try {
                FileLruCache a2 = a();
                String str = uri3;
                InputStreamReader inputStreamReader2 = null;
                while (true) {
                    try {
                        InputStream inputStream = a2.get(str, b);
                        if (inputStream == null) {
                            break;
                        }
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
                            str = sb.toString();
                            inputStreamReader2 = inputStreamReader;
                            z = true;
                        } catch (IOException e) {
                            Utility.closeQuietly(inputStreamReader);
                            return uri2;
                        } catch (Throwable th2) {
                            th = th2;
                            Utility.closeQuietly(inputStreamReader);
                            throw th;
                        }
                    } catch (IOException e2) {
                        inputStreamReader = inputStreamReader2;
                    } catch (Throwable th3) {
                        th = th3;
                        inputStreamReader = inputStreamReader2;
                    }
                }
                if (z) {
                    uri2 = Uri.parse(str);
                    Utility.closeQuietly(inputStreamReader2);
                } else {
                    Utility.closeQuietly(inputStreamReader2);
                }
            } catch (IOException e3) {
                inputStreamReader = null;
            } catch (Throwable th4) {
                inputStreamReader = null;
                th = th4;
            }
        }
        return uri2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Uri uri, Uri uri2) {
        OutputStream outputStream;
        Throwable th;
        OutputStream openPutStream;
        if (uri != null && uri2 != null) {
            try {
                try {
                    openPutStream = a().openPutStream(uri.toString(), b);
                } catch (Throwable th2) {
                    outputStream = null;
                    th = th2;
                }
                try {
                    openPutStream.write(uri2.toString().getBytes());
                    Utility.closeQuietly(openPutStream);
                } catch (Throwable th3) {
                    outputStream = openPutStream;
                    th = th3;
                    Utility.closeQuietly(outputStream);
                    throw th;
                }
            } catch (IOException e) {
                Utility.closeQuietly(null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b() {
        try {
            a().clearCache();
        } catch (IOException e) {
            Logger.log(LoggingBehavior.CACHE, 5, f281a, "clearCache failed " + e.getMessage());
        }
    }
}
