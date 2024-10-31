package com.google.common.net;

import com.facebook.appevents.AppEventsConstants;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Splitter;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Locale;
import javax.annotation.Nullable;

@Beta
@GwtIncompatible
/* loaded from: classes2.dex */
public final class InetAddresses {

    /* renamed from: a */
    private static final Splitter f16012a = Splitter.a('.').a(4);

    /* renamed from: b */
    private static final Inet4Address f16013b = (Inet4Address) a("127.0.0.1");

    /* renamed from: c */
    private static final Inet4Address f16014c = (Inet4Address) a("0.0.0.0");

    @Beta
    /* loaded from: classes2.dex */
    public static final class TeredoInfo {
    }

    private InetAddresses() {
    }

    public static InetAddress a(String str) {
        byte[] c2 = c(str);
        if (c2 != null) {
            return a(c2);
        }
        throw a("'%s' is not an IP string literal.", str);
    }

    @Nullable
    private static String b(String str) {
        int lastIndexOf = str.lastIndexOf(58) + 1;
        String substring = str.substring(0, lastIndexOf);
        byte[] f2 = f(str.substring(lastIndexOf));
        if (f2 == null) {
            return null;
        }
        return substring + Integer.toHexString(((f2[0] & 255) << 8) | (f2[1] & 255)) + ":" + Integer.toHexString((f2[3] & 255) | ((f2[2] & 255) << 8));
    }

    @Nullable
    private static byte[] c(String str) {
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt == '.') {
                z2 = true;
            } else if (charAt == ':') {
                if (z2) {
                    return null;
                }
                z = true;
            } else if (Character.digit(charAt, 16) == -1) {
                return null;
            }
        }
        if (!z) {
            if (z2) {
                return f(str);
            }
            return null;
        }
        if (z2 && (str = b(str)) == null) {
            return null;
        }
        return g(str);
    }

    private static short d(String str) {
        int parseInt = Integer.parseInt(str, 16);
        if (parseInt <= 65535) {
            return (short) parseInt;
        }
        throw new NumberFormatException();
    }

    private static byte e(String str) {
        int parseInt = Integer.parseInt(str);
        if (parseInt > 255 || (str.startsWith(AppEventsConstants.EVENT_PARAM_VALUE_NO) && str.length() > 1)) {
            throw new NumberFormatException();
        }
        return (byte) parseInt;
    }

    @Nullable
    private static byte[] f(String str) {
        byte[] bArr = new byte[4];
        try {
            Iterator<String> it = f16012a.a((CharSequence) str).iterator();
            int i = 0;
            while (it.hasNext()) {
                int i2 = i + 1;
                bArr[i] = e(it.next());
                i = i2;
            }
            if (i == 4) {
                return bArr;
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @Nullable
    private static byte[] g(String str) {
        int length;
        int i;
        String[] split = str.split(":", 10);
        if (split.length < 3 || split.length > 9) {
            return null;
        }
        int i2 = -1;
        for (int i3 = 1; i3 < split.length - 1; i3++) {
            if (split[i3].length() == 0) {
                if (i2 >= 0) {
                    return null;
                }
                i2 = i3;
            }
        }
        if (i2 >= 0) {
            i = (split.length - i2) - 1;
            if (split[0].length() == 0) {
                length = i2 - 1;
                if (length != 0) {
                    return null;
                }
            } else {
                length = i2;
            }
            if (split[split.length - 1].length() == 0 && i - 1 != 0) {
                return null;
            }
        } else {
            length = split.length;
            i = 0;
        }
        int i4 = 8 - (length + i);
        if (i2 < 0 ? i4 != 0 : i4 < 1) {
            return null;
        }
        ByteBuffer allocate = ByteBuffer.allocate(16);
        for (int i5 = 0; i5 < length; i5++) {
            try {
                allocate.putShort(d(split[i5]));
            } catch (NumberFormatException unused) {
                return null;
            }
        }
        for (int i6 = 0; i6 < i4; i6++) {
            allocate.putShort((short) 0);
        }
        while (i > 0) {
            allocate.putShort(d(split[split.length - i]));
            i--;
        }
        return allocate.array();
    }

    private static InetAddress a(byte[] bArr) {
        try {
            return InetAddress.getByAddress(bArr);
        } catch (UnknownHostException e2) {
            throw new AssertionError(e2);
        }
    }

    private static IllegalArgumentException a(String str, Object... objArr) {
        return new IllegalArgumentException(String.format(Locale.ROOT, str, objArr));
    }
}
