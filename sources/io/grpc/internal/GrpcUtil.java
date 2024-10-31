package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.base.Stopwatch;
import com.google.common.base.Supplier;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.qq.e.comm.constants.ErrorCode;
import io.grpc.AbstractC2513n;
import io.grpc.F;
import io.grpc.J;
import io.grpc.P;
import io.grpc.Status;
import io.grpc.internal.ClientStreamListener;
import io.grpc.internal.Kc;
import io.grpc.internal.Oc;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* loaded from: classes3.dex */
public final class GrpcUtil {

    /* renamed from: a, reason: collision with root package name */
    private static final Logger f27337a = Logger.getLogger(GrpcUtil.class.getName());

    /* renamed from: b, reason: collision with root package name */
    public static final Charset f27338b = Charset.forName("US-ASCII");

    /* renamed from: c, reason: collision with root package name */
    public static final boolean f27339c;

    /* renamed from: d, reason: collision with root package name */
    public static final P.e<Long> f27340d;

    /* renamed from: e, reason: collision with root package name */
    public static final P.e<String> f27341e;

    /* renamed from: f, reason: collision with root package name */
    public static final P.e<byte[]> f27342f;

    /* renamed from: g, reason: collision with root package name */
    public static final P.e<String> f27343g;

    /* renamed from: h, reason: collision with root package name */
    public static final P.e<byte[]> f27344h;
    public static final P.e<String> i;
    public static final P.e<String> j;
    public static final P.e<String> k;
    public static final Splitter l;
    public static final long m;
    public static final long n;
    public static final long o;
    public static final long p;
    public static final Zb q;
    public static final Zb r;
    public static final Kc.b<ExecutorService> s;
    public static final Kc.b<ScheduledExecutorService> t;
    public static final Supplier<Stopwatch> u;

    /* loaded from: classes3.dex */
    public enum Http2Error {
        NO_ERROR(0, Status.q),
        PROTOCOL_ERROR(1, Status.p),
        INTERNAL_ERROR(2, Status.p),
        FLOW_CONTROL_ERROR(3, Status.p),
        SETTINGS_TIMEOUT(4, Status.p),
        STREAM_CLOSED(5, Status.p),
        FRAME_SIZE_ERROR(6, Status.p),
        REFUSED_STREAM(7, Status.q),
        CANCEL(8, Status.f27130c),
        COMPRESSION_ERROR(9, Status.p),
        CONNECT_ERROR(10, Status.p),
        ENHANCE_YOUR_CALM(11, Status.k.b("Bandwidth exhausted")),
        INADEQUATE_SECURITY(12, Status.i.b("Permission denied as protocol is not secure enough to call")),
        HTTP_1_1_REQUIRED(13, Status.f27131d);

        private static final Http2Error[] codeMap = a();
        private final int code;
        private final Status status;

        Http2Error(int i, Status status) {
            this.code = i;
            this.status = status.a("HTTP/2 error code: " + name());
        }

        private static Http2Error[] a() {
            Http2Error[] values = values();
            Http2Error[] http2ErrorArr = new Http2Error[((int) values[values.length - 1].code()) + 1];
            for (Http2Error http2Error : values) {
                http2ErrorArr[(int) http2Error.code()] = http2Error;
            }
            return http2ErrorArr;
        }

        public static Http2Error forCode(long j) {
            Http2Error[] http2ErrorArr = codeMap;
            if (j >= http2ErrorArr.length || j < 0) {
                return null;
            }
            return http2ErrorArr[(int) j];
        }

        public static Status statusForCode(long j) {
            Http2Error forCode = forCode(j);
            if (forCode == null) {
                return Status.a(INTERNAL_ERROR.status().e().value()).b("Unrecognized HTTP/2 error code: " + j);
            }
            return forCode.status();
        }

        public long code() {
            return this.code;
        }

        public Status status() {
            return this.status;
        }
    }

    /* loaded from: classes3.dex */
    private static final class a implements F.a<byte[]> {
        private a() {
        }

        @Override // io.grpc.P.g
        public /* bridge */ /* synthetic */ Object a(byte[] bArr) {
            a(bArr);
            return bArr;
        }

        @Override // io.grpc.P.g
        public byte[] a(byte[] bArr) {
            return bArr;
        }

        public byte[] b(byte[] bArr) {
            return bArr;
        }

        /* synthetic */ a(Ta ta) {
            this();
        }

        @Override // io.grpc.P.g
        public /* bridge */ /* synthetic */ byte[] a(Object obj) {
            byte[] bArr = (byte[]) obj;
            b(bArr);
            return bArr;
        }
    }

    static {
        f27339c = System.getProperty("com.google.appengine.runtime.environment") != null && "1.7".equals(System.getProperty("java.specification.version"));
        f27340d = P.e.a("grpc-timeout", new b());
        f27341e = P.e.a("grpc-encoding", io.grpc.P.f27117b);
        Ta ta = null;
        f27342f = io.grpc.F.a("grpc-accept-encoding", new a(ta));
        f27343g = P.e.a("content-encoding", io.grpc.P.f27117b);
        f27344h = io.grpc.F.a("accept-encoding", new a(ta));
        i = P.e.a("content-type", io.grpc.P.f27117b);
        j = P.e.a("te", io.grpc.P.f27117b);
        k = P.e.a("user-agent", io.grpc.P.f27117b);
        l = Splitter.a(',').b();
        m = TimeUnit.MINUTES.toNanos(1L);
        n = TimeUnit.SECONDS.toNanos(20L);
        o = TimeUnit.HOURS.toNanos(2L);
        p = TimeUnit.SECONDS.toNanos(20L);
        q = new C2418bc();
        r = new Ta();
        s = new Ua();
        t = new Va();
        u = new Wa();
    }

    private GrpcUtil() {
    }

    public static Zb a() {
        if (f27339c) {
            return r;
        }
        return q;
    }

    private static Status.Code b(int i2) {
        if (i2 >= 100 && i2 < 200) {
            return Status.Code.INTERNAL;
        }
        if (i2 != 400) {
            if (i2 == 401) {
                return Status.Code.UNAUTHENTICATED;
            }
            if (i2 == 403) {
                return Status.Code.PERMISSION_DENIED;
            }
            if (i2 != 404) {
                if (i2 != 429) {
                    if (i2 != 431) {
                        switch (i2) {
                            case ErrorCode.AdError.JSON_PARSE_ERROR /* 502 */:
                            case ErrorCode.AdError.DETAIl_URL_ERROR /* 503 */:
                            case 504:
                                break;
                            default:
                                return Status.Code.UNKNOWN;
                        }
                    }
                }
                return Status.Code.UNAVAILABLE;
            }
            return Status.Code.UNIMPLEMENTED;
        }
        return Status.Code.INTERNAL;
    }

    @VisibleForTesting
    /* loaded from: classes3.dex */
    static class b implements P.b<Long> {
        b() {
        }

        @Override // io.grpc.P.b
        public String a(Long l) {
            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
            if (l.longValue() < 0) {
                throw new IllegalArgumentException("Timeout too small");
            }
            if (l.longValue() < 100000000) {
                return l + "n";
            }
            if (l.longValue() < 100000000000L) {
                return timeUnit.toMicros(l.longValue()) + com.facebook.appevents.u.f9225a;
            }
            if (l.longValue() < 100000000000000L) {
                return timeUnit.toMillis(l.longValue()) + "m";
            }
            if (l.longValue() < 100000000000000000L) {
                return timeUnit.toSeconds(l.longValue()) + "S";
            }
            if (l.longValue() < 6000000000000000000L) {
                return timeUnit.toMinutes(l.longValue()) + "M";
            }
            return timeUnit.toHours(l.longValue()) + "H";
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.grpc.P.b
        public Long a(String str) {
            Preconditions.a(str.length() > 0, "empty timeout");
            Preconditions.a(str.length() <= 9, "bad timeout format");
            long parseLong = Long.parseLong(str.substring(0, str.length() - 1));
            char charAt = str.charAt(str.length() - 1);
            if (charAt == 'H') {
                return Long.valueOf(TimeUnit.HOURS.toNanos(parseLong));
            }
            if (charAt == 'M') {
                return Long.valueOf(TimeUnit.MINUTES.toNanos(parseLong));
            }
            if (charAt == 'S') {
                return Long.valueOf(TimeUnit.SECONDS.toNanos(parseLong));
            }
            if (charAt == 'u') {
                return Long.valueOf(TimeUnit.MICROSECONDS.toNanos(parseLong));
            }
            if (charAt == 'm') {
                return Long.valueOf(TimeUnit.MILLISECONDS.toNanos(parseLong));
            }
            if (charAt == 'n') {
                return Long.valueOf(parseLong);
            }
            throw new IllegalArgumentException(String.format("Invalid timeout unit: %s", Character.valueOf(charAt)));
        }
    }

    public static Status a(int i2) {
        return b(i2).toStatus().b("HTTP status code " + i2);
    }

    public static String a(String str, @Nullable String str2) {
        StringBuilder sb = new StringBuilder();
        if (str2 != null) {
            sb.append(str2);
            sb.append(' ');
        }
        sb.append("grpc-java-");
        sb.append(str);
        sb.append('/');
        sb.append("1.12.0");
        return sb.toString();
    }

    public static boolean b(String str) {
        char charAt;
        if (str == null || 16 > str.length()) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        if (lowerCase.startsWith("application/grpc")) {
            return lowerCase.length() == 16 || (charAt = lowerCase.charAt(16)) == '+' || charAt == ';';
        }
        return false;
    }

    public static URI a(String str) {
        Preconditions.a(str, "authority");
        try {
            return new URI(null, str, null, null, null);
        } catch (URISyntaxException e2) {
            throw new IllegalArgumentException("Invalid authority: " + str, e2);
        }
    }

    public static ThreadFactory a(String str, boolean z) {
        if (f27339c) {
            return MoreExecutors.b();
        }
        return new ThreadFactoryBuilder().a(z).a(str).a();
    }

    public static String a(InetSocketAddress inetSocketAddress) {
        try {
            return (String) InetSocketAddress.class.getMethod("getHostString", new Class[0]).invoke(inetSocketAddress, new Object[0]);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return inetSocketAddress.getHostName();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static Y a(J.c cVar, boolean z) {
        J.e c2 = cVar.c();
        Y e2 = c2 != null ? ((AbstractC2431f) c2).e() : null;
        if (e2 != null) {
            AbstractC2513n.a b2 = cVar.b();
            return b2 == null ? e2 : new Xa(e2, b2);
        }
        if (!cVar.a().g()) {
            if (cVar.d()) {
                return new Ka(cVar.a(), ClientStreamListener.RpcProgress.DROPPED);
            }
            if (!z) {
                return new Ka(cVar.a(), ClientStreamListener.RpcProgress.PROCESSED);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Oc.a aVar) {
        while (true) {
            InputStream next = aVar.next();
            if (next == null) {
                return;
            } else {
                a(next);
            }
        }
    }

    public static void a(@Nullable InputStream inputStream) {
        if (inputStream == null) {
            return;
        }
        try {
            inputStream.close();
        } catch (IOException e2) {
            f27337a.log(Level.WARNING, "exception caught in closeQuietly", (Throwable) e2);
        }
    }
}
