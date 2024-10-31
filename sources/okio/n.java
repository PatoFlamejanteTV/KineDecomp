package okio;

import java.nio.charset.Charset;
import org.keyczar.Keyczar;

/* compiled from: Util.java */
/* loaded from: classes.dex */
final class n {

    /* renamed from: a, reason: collision with root package name */
    public static final Charset f4937a = Charset.forName(Keyczar.DEFAULT_ENCODING);

    public static void a(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException(String.format("size=%s offset=%s byteCount=%s", Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)));
        }
    }

    public static int a(int i) {
        return (((-16777216) & i) >>> 24) | ((16711680 & i) >>> 8) | ((65280 & i) << 8) | ((i & 255) << 24);
    }

    public static long a(long j) {
        return (((-72057594037927936L) & j) >>> 56) | ((71776119061217280L & j) >>> 40) | ((280375465082880L & j) >>> 24) | ((1095216660480L & j) >>> 8) | ((4278190080L & j) << 8) | ((16711680 & j) << 24) | ((65280 & j) << 40) | ((255 & j) << 56);
    }
}
