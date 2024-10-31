package com.google.common.net;

import com.facebook.appevents.AppEventsConstants;
import com.google.common.annotations.Beta;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;

@Beta
/* loaded from: classes2.dex */
public final class InetAddresses {

    /* renamed from: a, reason: collision with root package name */
    private static final Inet4Address f2924a = (Inet4Address) a("127.0.0.1");
    private static final Inet4Address b = (Inet4Address) a("0.0.0.0");

    @Beta
    /* loaded from: classes2.dex */
    public static final class TeredoInfo {
    }

    private InetAddresses() {
    }

    public static InetAddress a(String str) {
        byte[] b2 = b(str);
        if (b2 == null) {
            throw new IllegalArgumentException(String.format("'%s' is not an IP string literal.", str));
        }
        return a(b2);
    }

    private static byte[] b(String str) {
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt == '.') {
                z = true;
            } else if (charAt == ':') {
                if (z) {
                    return null;
                }
                z2 = true;
            } else if (Character.digit(charAt, 16) == -1) {
                return null;
            }
        }
        if (z2) {
            if (z && (str = e(str)) == null) {
                return null;
            }
            return d(str);
        }
        if (z) {
            return c(str);
        }
        return null;
    }

    private static byte[] c(String str) {
        String[] split = str.split("\\.", 5);
        if (split.length != 4) {
            return null;
        }
        byte[] bArr = new byte[4];
        for (int i = 0; i < bArr.length; i++) {
            try {
                bArr[i] = f(split[i]);
            } catch (NumberFormatException e) {
                return null;
            }
        }
        return bArr;
    }

    private static byte[] d(String str) {
        int length;
        int i;
        int i2;
        String[] split = str.split(":", 10);
        if (split.length < 3 || split.length > 9) {
            return null;
        }
        int i3 = -1;
        for (int i4 = 1; i4 < split.length - 1; i4++) {
            if (split[i4].length() == 0) {
                if (i3 >= 0) {
                    return null;
                }
                i3 = i4;
            }
        }
        if (i3 >= 0) {
            int length2 = (split.length - i3) - 1;
            if (split[0].length() == 0) {
                i2 = i3 - 1;
                if (i2 != 0) {
                    return null;
                }
            } else {
                i2 = i3;
            }
            if (split[split.length - 1].length() == 0 && length2 - 1 != 0) {
                return null;
            }
            int i5 = length2;
            length = i2;
            i = i5;
        } else {
            length = split.length;
            i = 0;
        }
        int i6 = 8 - (length + i);
        if (i3 < 0 ? i6 != 0 : i6 < 1) {
            return null;
        }
        ByteBuffer allocate = ByteBuffer.allocate(16);
        for (int i7 = 0; i7 < length; i7++) {
            try {
                allocate.putShort(g(split[i7]));
            } catch (NumberFormatException e) {
                return null;
            }
        }
        for (int i8 = 0; i8 < i6; i8++) {
            allocate.putShort((short) 0);
        }
        while (i > 0) {
            allocate.putShort(g(split[split.length - i]));
            i--;
        }
        return allocate.array();
    }

    private static String e(String str) {
        int lastIndexOf = str.lastIndexOf(58);
        String substring = str.substring(0, lastIndexOf + 1);
        byte[] c = c(str.substring(lastIndexOf + 1));
        if (c == null) {
            return null;
        }
        return substring + Integer.toHexString(((c[0] & 255) << 8) | (c[1] & 255)) + ":" + Integer.toHexString((c[3] & 255) | ((c[2] & 255) << 8));
    }

    private static byte f(String str) {
        int parseInt = Integer.parseInt(str);
        if (parseInt > 255 || (str.startsWith(AppEventsConstants.EVENT_PARAM_VALUE_NO) && str.length() > 1)) {
            throw new NumberFormatException();
        }
        return (byte) parseInt;
    }

    private static short g(String str) {
        int parseInt = Integer.parseInt(str, 16);
        if (parseInt > 65535) {
            throw new NumberFormatException();
        }
        return (short) parseInt;
    }

    private static InetAddress a(byte[] bArr) {
        try {
            return InetAddress.getByAddress(bArr);
        } catch (UnknownHostException e) {
            throw new AssertionError(e);
        }
    }
}
