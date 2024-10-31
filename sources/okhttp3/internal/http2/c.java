package okhttp3.internal.http2;

import java.io.IOException;
import okio.ByteString;

/* compiled from: Http2.java */
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a */
    static final ByteString f29049a = ByteString.encodeUtf8("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    /* renamed from: b */
    private static final String[] f29050b = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

    /* renamed from: c */
    static final String[] f29051c = new String[64];

    /* renamed from: d */
    static final String[] f29052d = new String[256];

    static {
        int i = 0;
        int i2 = 0;
        while (true) {
            String[] strArr = f29052d;
            if (i2 >= strArr.length) {
                break;
            }
            strArr[i2] = okhttp3.a.e.a("%8s", Integer.toBinaryString(i2)).replace(' ', '0');
            i2++;
        }
        String[] strArr2 = f29051c;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        for (int i3 : iArr) {
            f29051c[i3 | 8] = f29051c[i3] + "|PADDED";
        }
        String[] strArr3 = f29051c;
        strArr3[4] = "END_HEADERS";
        strArr3[32] = "PRIORITY";
        strArr3[36] = "END_HEADERS|PRIORITY";
        for (int i4 : new int[]{4, 32, 36}) {
            for (int i5 : iArr) {
                int i6 = i5 | i4;
                f29051c[i6] = f29051c[i5] + '|' + f29051c[i4];
                f29051c[i6 | 8] = f29051c[i5] + '|' + f29051c[i4] + "|PADDED";
            }
        }
        while (true) {
            String[] strArr4 = f29051c;
            if (i >= strArr4.length) {
                return;
            }
            if (strArr4[i] == null) {
                strArr4[i] = f29052d[i];
            }
            i++;
        }
    }

    private c() {
    }

    public static IllegalArgumentException a(String str, Object... objArr) {
        throw new IllegalArgumentException(okhttp3.a.e.a(str, objArr));
    }

    public static IOException b(String str, Object... objArr) throws IOException {
        throw new IOException(okhttp3.a.e.a(str, objArr));
    }

    public static String a(boolean z, int i, int i2, byte b2, byte b3) {
        String[] strArr = f29050b;
        String a2 = b2 < strArr.length ? strArr[b2] : okhttp3.a.e.a("0x%02x", Byte.valueOf(b2));
        String a3 = a(b2, b3);
        Object[] objArr = new Object[5];
        objArr[0] = z ? "<<" : ">>";
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = a2;
        objArr[4] = a3;
        return okhttp3.a.e.a("%s 0x%08x %5d %-13s %s", objArr);
    }

    static String a(byte b2, byte b3) {
        if (b3 == 0) {
            return "";
        }
        if (b2 != 2 && b2 != 3) {
            if (b2 == 4 || b2 == 6) {
                return b3 == 1 ? "ACK" : f29052d[b3];
            }
            if (b2 != 7 && b2 != 8) {
                String[] strArr = f29051c;
                String str = b3 < strArr.length ? strArr[b3] : f29052d[b3];
                if (b2 != 5 || (b3 & 4) == 0) {
                    return (b2 != 0 || (b3 & 32) == 0) ? str : str.replace("PRIORITY", "COMPRESSED");
                }
                return str.replace("HEADERS", "PUSH_PROMISE");
            }
        }
        return f29052d[b3];
    }
}
