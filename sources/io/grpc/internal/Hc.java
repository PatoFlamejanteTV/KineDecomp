package io.grpc.internal;

import android.support.v4.app.NotificationCompat;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.math.LongMath;
import io.grpc.internal.wc;
import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* compiled from: ServiceConfigUtil.java */
@VisibleForTesting
/* loaded from: classes3.dex */
public final class Hc {

    /* renamed from: a, reason: collision with root package name */
    private static final long f27358a = TimeUnit.SECONDS.toNanos(1);

    private static long a(long j, long j2) {
        long j3 = j + j2;
        return (((j2 ^ j) > 0L ? 1 : ((j2 ^ j) == 0L ? 0 : -1)) < 0) | ((j ^ j3) >= 0) ? j3 : ((j3 >>> 63) ^ 1) + Long.MAX_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static Double a(Map<String, Object> map) {
        if (map.containsKey("backoffMultiplier")) {
            return b(map, "backoffMultiplier");
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static Long b(Map<String, Object> map) {
        if (!map.containsKey("initialBackoff")) {
            return null;
        }
        try {
            return Long.valueOf(a(e(map, "initialBackoff")));
        } catch (ParseException e2) {
            throw new RuntimeException(e2);
        }
    }

    @VisibleForTesting
    @Nullable
    public static String c(Map<String, Object> map) {
        if (map.containsKey("loadBalancingPolicy")) {
            return e(map, "loadBalancingPolicy");
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static Integer d(Map<String, Object> map) {
        if (map.containsKey("maxAttempts")) {
            return Integer.valueOf(b(map, "maxAttempts").intValue());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static Long e(Map<String, Object> map) {
        if (!map.containsKey("maxBackoff")) {
            return null;
        }
        try {
            return Long.valueOf(a(e(map, "maxBackoff")));
        } catch (ParseException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static Integer f(Map<String, Object> map) {
        if (map.containsKey("maxRequestMessageBytes")) {
            return Integer.valueOf(b(map, "maxRequestMessageBytes").intValue());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static Integer g(Map<String, Object> map) {
        if (map.containsKey("maxResponseMessageBytes")) {
            return Integer.valueOf(b(map, "maxResponseMessageBytes").intValue());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static List<Map<String, Object>> h(Map<String, Object> map) {
        if (!map.containsKey("methodConfig")) {
            return null;
        }
        List c2 = c(map, "methodConfig");
        b((List<Object>) c2);
        return c2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static String i(Map<String, Object> map) {
        if (map.containsKey("method")) {
            return e(map, "method");
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static List<Map<String, Object>> j(Map<String, Object> map) {
        if (!map.containsKey("name")) {
            return null;
        }
        List c2 = c(map, "name");
        b((List<Object>) c2);
        return c2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static Map<String, Object> k(Map<String, Object> map) {
        if (map.containsKey("retryPolicy")) {
            return d(map, "retryPolicy");
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static List<String> l(Map<String, Object> map) {
        if (!map.containsKey("retryableStatusCodes")) {
            return null;
        }
        List c2 = c(map, "retryableStatusCodes");
        a((List<Object>) c2);
        return c2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static String m(Map<String, Object> map) {
        if (map.containsKey(NotificationCompat.CATEGORY_SERVICE)) {
            return e(map, NotificationCompat.CATEGORY_SERVICE);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static wc.h n(@Nullable Map<String, Object> map) {
        if (map == null || !map.containsKey("retryThrottling")) {
            return null;
        }
        Map<String, Object> d2 = d(map, "retryThrottling");
        float floatValue = b(d2, "maxTokens").floatValue();
        float floatValue2 = b(d2, "tokenRatio").floatValue();
        Preconditions.b(floatValue > 0.0f, "maxToken should be greater than zero");
        Preconditions.b(floatValue2 > 0.0f, "tokenRatio should be greater than zero");
        return new wc.h(floatValue, floatValue2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static Long o(Map<String, Object> map) {
        if (!map.containsKey("timeout")) {
            return null;
        }
        try {
            return Long.valueOf(a(e(map, "timeout")));
        } catch (ParseException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static Boolean p(Map<String, Object> map) {
        if (map.containsKey("waitForReady")) {
            return a(map, "waitForReady");
        }
        return null;
    }

    static Boolean a(Map<String, Object> map, String str) {
        Object obj = map.get(str);
        Preconditions.a(obj, "no such key %s", str);
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        throw new ClassCastException(String.format("value %s for key %s in %s is not Boolean", obj, str, map));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<Object> c(Map<String, Object> map, String str) {
        Object obj = map.get(str);
        Preconditions.a(obj, "no such key %s", str);
        if (obj instanceof List) {
            return (List) obj;
        }
        throw new ClassCastException(String.format("value %s for key %s in %s is not List", obj, str, map));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Map<String, Object> d(Map<String, Object> map, String str) {
        Object obj = map.get(str);
        Preconditions.a(obj, "no such key %s", str);
        if (obj instanceof Map) {
            return (Map) obj;
        }
        throw new ClassCastException(String.format("value %s for key %s in %s is not object", obj, str, map));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Double b(Map<String, Object> map, String str) {
        Object obj = map.get(str);
        Preconditions.a(obj, "no such key %s", str);
        if (obj instanceof Double) {
            return (Double) obj;
        }
        throw new ClassCastException(String.format("value %s for key %s in %s is not Double", obj, str, map));
    }

    static String e(Map<String, Object> map, String str) {
        Object obj = map.get(str);
        Preconditions.a(obj, "no such key %s", str);
        if (obj instanceof String) {
            return (String) obj;
        }
        throw new ClassCastException(String.format("value %s for key %s in %s is not String", obj, str, map));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<String> a(List<Object> list) {
        for (int i = 0; i < list.size(); i++) {
            if (!(list.get(i) instanceof String)) {
                throw new ClassCastException(String.format("value %s for idx %d in %s is not string", list.get(i), Integer.valueOf(i), list));
            }
        }
        return list;
    }

    private static List<Map<String, Object>> b(List<Object> list) {
        for (int i = 0; i < list.size(); i++) {
            if (!(list.get(i) instanceof Map)) {
                throw new ClassCastException(String.format("value %s for idx %d in %s is not object", list.get(i), Integer.valueOf(i), list));
            }
        }
        return list;
    }

    private static long a(String str) throws ParseException {
        boolean z;
        String str2;
        if (!str.isEmpty() && str.charAt(str.length() - 1) == 's') {
            if (str.charAt(0) == '-') {
                str = str.substring(1);
                z = true;
            } else {
                z = false;
            }
            String substring = str.substring(0, str.length() - 1);
            int indexOf = substring.indexOf(46);
            if (indexOf != -1) {
                str2 = substring.substring(indexOf + 1);
                substring = substring.substring(0, indexOf);
            } else {
                str2 = "";
            }
            long parseLong = Long.parseLong(substring);
            int b2 = str2.isEmpty() ? 0 : b(str2);
            if (parseLong >= 0) {
                if (z) {
                    parseLong = -parseLong;
                    b2 = -b2;
                }
                try {
                    return b(parseLong, b2);
                } catch (IllegalArgumentException unused) {
                    throw new ParseException("Duration value is out of range.", 0);
                }
            }
            throw new ParseException("Invalid duration string: " + str, 0);
        }
        throw new ParseException("Invalid duration string: " + str, 0);
    }

    private static int b(String str) throws ParseException {
        int i = 0;
        for (int i2 = 0; i2 < 9; i2++) {
            i *= 10;
            if (i2 < str.length()) {
                if (str.charAt(i2) >= '0' && str.charAt(i2) <= '9') {
                    i += str.charAt(i2) - '0';
                } else {
                    throw new ParseException("Invalid nanoseconds.", 0);
                }
            }
        }
        return i;
    }

    private static long b(long j, int i) {
        long j2 = i;
        long j3 = f27358a;
        if (j2 <= (-j3) || j2 >= j3) {
            j = LongMath.a(j, j2 / f27358a);
            i = (int) (j2 % f27358a);
        }
        if (j > 0 && i < 0) {
            i = (int) (i + f27358a);
            j--;
        }
        if (j < 0 && i > 0) {
            i = (int) (i - f27358a);
            j++;
        }
        if (a(j, i)) {
            return a(TimeUnit.SECONDS.toNanos(j), i);
        }
        throw new IllegalArgumentException(String.format("Duration is not valid. See proto definition for valid values. Seconds (%s) must be in range [-315,576,000,000, +315,576,000,000]. Nanos (%s) must be in range [-999,999,999, +999,999,999]. Nanos must have the same sign as seconds", Long.valueOf(j), Integer.valueOf(i)));
    }

    private static boolean a(long j, int i) {
        if (j >= -315576000000L && j <= 315576000000L) {
            long j2 = i;
            if (j2 >= -999999999 && j2 < f27358a) {
                if (j >= 0 && i >= 0) {
                    return true;
                }
                if (j <= 0 && i <= 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
