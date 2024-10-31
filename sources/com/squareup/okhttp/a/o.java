package com.squareup.okhttp.a;

import android.support.v4.media.session.PlaybackStateCompat;
import com.squareup.okhttp.HttpUrl;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.net.Socket;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import okio.ByteString;
import okio.z;

/* compiled from: Util.java */
/* loaded from: classes3.dex */
public final class o {

    /* renamed from: a */
    public static final byte[] f25217a = new byte[0];

    /* renamed from: b */
    public static final String[] f25218b = new String[0];

    /* renamed from: c */
    public static final Charset f25219c = Charset.forName("UTF-8");

    public static void a(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static boolean b(z zVar, int i, TimeUnit timeUnit) throws IOException {
        long nanoTime = System.nanoTime();
        long c2 = zVar.e().d() ? zVar.e().c() - nanoTime : Long.MAX_VALUE;
        zVar.e().a(Math.min(c2, timeUnit.toNanos(i)) + nanoTime);
        try {
            okio.g gVar = new okio.g();
            while (zVar.b(gVar, PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) != -1) {
                gVar.a();
            }
            if (c2 == Long.MAX_VALUE) {
                zVar.e().a();
            } else {
                zVar.e().a(nanoTime + c2);
            }
            return true;
        } catch (InterruptedIOException unused) {
            if (c2 == Long.MAX_VALUE) {
                zVar.e().a();
            } else {
                zVar.e().a(nanoTime + c2);
            }
            return false;
        } catch (Throwable th) {
            if (c2 == Long.MAX_VALUE) {
                zVar.e().a();
            } else {
                zVar.e().a(nanoTime + c2);
            }
            throw th;
        }
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    public static void a(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (AssertionError e2) {
                if (!a(e2)) {
                    throw e2;
                }
            } catch (RuntimeException e3) {
                throw e3;
            } catch (Exception unused) {
            }
        }
    }

    public static void a(Closeable closeable, Closeable closeable2) throws IOException {
        try {
            closeable.close();
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            closeable2.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        if (th == null) {
            return;
        }
        if (!(th instanceof IOException)) {
            if (!(th instanceof RuntimeException)) {
                if (!(th instanceof Error)) {
                    throw new AssertionError(th);
                }
                throw ((Error) th);
            }
            throw ((RuntimeException) th);
        }
        throw ((IOException) th);
    }

    public static boolean b(String[] strArr, String str) {
        return Arrays.asList(strArr).contains(str);
    }

    public static boolean a(z zVar, int i, TimeUnit timeUnit) {
        try {
            return b(zVar, i, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    public static String a(String str) {
        try {
            return ByteString.of(MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"))).hex();
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e2) {
            throw new AssertionError(e2);
        }
    }

    public static ByteString a(ByteString byteString) {
        try {
            return ByteString.of(MessageDigest.getInstance("SHA-1").digest(byteString.toByteArray()));
        } catch (NoSuchAlgorithmException e2) {
            throw new AssertionError(e2);
        }
    }

    public static <T> List<T> a(List<T> list) {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    public static <T> List<T> a(T... tArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone()));
    }

    public static <K, V> Map<K, V> a(Map<K, V> map) {
        return Collections.unmodifiableMap(new LinkedHashMap(map));
    }

    public static ThreadFactory a(String str, boolean z) {
        return new n(str, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T[] a(Class<T> cls, T[] tArr, T[] tArr2) {
        List a2 = a((Object[]) tArr, (Object[]) tArr2);
        return (T[]) a2.toArray((Object[]) Array.newInstance((Class<?>) cls, a2.size()));
    }

    private static <T> List<T> a(T[] tArr, T[] tArr2) {
        ArrayList arrayList = new ArrayList();
        for (T t : tArr) {
            int length = tArr2.length;
            int i = 0;
            while (true) {
                if (i < length) {
                    T t2 = tArr2[i];
                    if (t.equals(t2)) {
                        arrayList.add(t2);
                        break;
                    }
                    i++;
                }
            }
        }
        return arrayList;
    }

    public static String a(HttpUrl httpUrl) {
        if (httpUrl.j() != HttpUrl.a(httpUrl.l())) {
            return httpUrl.g() + ":" + httpUrl.j();
        }
        return httpUrl.g();
    }

    public static boolean a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static String[] a(String[] strArr, String str) {
        String[] strArr2 = new String[strArr.length + 1];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        strArr2[strArr2.length - 1] = str;
        return strArr2;
    }
}
