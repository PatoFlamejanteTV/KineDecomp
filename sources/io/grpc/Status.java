package io.grpc;

import com.facebook.stetho.dumpapp.Framer;
import com.google.common.base.Charsets;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.umeng.commonsdk.proguard.ap;
import io.grpc.P;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* loaded from: classes3.dex */
public final class Status {

    /* renamed from: a */
    private static final List<Status> f27128a = h();

    /* renamed from: b */
    public static final Status f27129b = Code.OK.toStatus();

    /* renamed from: c */
    public static final Status f27130c = Code.CANCELLED.toStatus();

    /* renamed from: d */
    public static final Status f27131d = Code.UNKNOWN.toStatus();

    /* renamed from: e */
    public static final Status f27132e = Code.INVALID_ARGUMENT.toStatus();

    /* renamed from: f */
    public static final Status f27133f = Code.DEADLINE_EXCEEDED.toStatus();

    /* renamed from: g */
    public static final Status f27134g = Code.NOT_FOUND.toStatus();

    /* renamed from: h */
    public static final Status f27135h = Code.ALREADY_EXISTS.toStatus();
    public static final Status i = Code.PERMISSION_DENIED.toStatus();
    public static final Status j = Code.UNAUTHENTICATED.toStatus();
    public static final Status k = Code.RESOURCE_EXHAUSTED.toStatus();
    public static final Status l = Code.FAILED_PRECONDITION.toStatus();
    public static final Status m = Code.ABORTED.toStatus();
    public static final Status n = Code.OUT_OF_RANGE.toStatus();
    public static final Status o = Code.UNIMPLEMENTED.toStatus();
    public static final Status p = Code.INTERNAL.toStatus();
    public static final Status q = Code.UNAVAILABLE.toStatus();
    public static final Status r = Code.DATA_LOSS.toStatus();
    static final P.e<Status> s = P.e.a("grpc-status", false, (P.g) new a());
    private static final P.g<String> t = new b();
    static final P.e<String> u = P.e.a("grpc-message", false, (P.g) t);
    private final Code v;
    private final String w;
    private final Throwable x;

    /* loaded from: classes3.dex */
    public enum Code {
        OK(0),
        CANCELLED(1),
        UNKNOWN(2),
        INVALID_ARGUMENT(3),
        DEADLINE_EXCEEDED(4),
        NOT_FOUND(5),
        ALREADY_EXISTS(6),
        PERMISSION_DENIED(7),
        RESOURCE_EXHAUSTED(8),
        FAILED_PRECONDITION(9),
        ABORTED(10),
        OUT_OF_RANGE(11),
        UNIMPLEMENTED(12),
        INTERNAL(13),
        UNAVAILABLE(14),
        DATA_LOSS(15),
        UNAUTHENTICATED(16);

        private final int value;
        private final byte[] valueAscii;

        Code(int i) {
            this.value = i;
            this.valueAscii = Integer.toString(i).getBytes(Charsets.f15076a);
        }

        public byte[] a() {
            return this.valueAscii;
        }

        public Status toStatus() {
            return (Status) Status.f27128a.get(this.value);
        }

        public int value() {
            return this.value;
        }
    }

    /* loaded from: classes3.dex */
    private static final class a implements P.g<Status> {
        private a() {
        }

        /* synthetic */ a(da daVar) {
            this();
        }

        @Override // io.grpc.P.g
        public byte[] a(Status status) {
            return status.e().a();
        }

        @Override // io.grpc.P.g
        public Status a(byte[] bArr) {
            return Status.b(bArr);
        }
    }

    /* loaded from: classes3.dex */
    private static final class b implements P.g<String> {

        /* renamed from: a */
        private static final byte[] f27136a = {48, Framer.STDOUT_FRAME_PREFIX, Framer.STDERR_FRAME_PREFIX, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70};

        private b() {
        }

        private static boolean a(byte b2) {
            return b2 < 32 || b2 >= 126 || b2 == 37;
        }

        private static String b(byte[] bArr) {
            ByteBuffer allocate = ByteBuffer.allocate(bArr.length);
            int i = 0;
            while (i < bArr.length) {
                if (bArr[i] == 37 && i + 2 < bArr.length) {
                    try {
                        allocate.put((byte) Integer.parseInt(new String(bArr, i + 1, 2, Charsets.f15076a), 16));
                        i += 3;
                    } catch (NumberFormatException unused) {
                    }
                }
                allocate.put(bArr[i]);
                i++;
            }
            return new String(allocate.array(), 0, allocate.position(), Charsets.f15078c);
        }

        /* synthetic */ b(da daVar) {
            this();
        }

        @Override // io.grpc.P.g
        public byte[] a(String str) {
            byte[] bytes = str.getBytes(Charsets.f15078c);
            for (int i = 0; i < bytes.length; i++) {
                if (a(bytes[i])) {
                    return a(bytes, i);
                }
            }
            return bytes;
        }

        private static byte[] a(byte[] bArr, int i) {
            byte[] bArr2 = new byte[((bArr.length - i) * 3) + i];
            if (i != 0) {
                System.arraycopy(bArr, 0, bArr2, 0, i);
            }
            int i2 = i;
            while (i < bArr.length) {
                byte b2 = bArr[i];
                if (a(b2)) {
                    bArr2[i2] = 37;
                    byte[] bArr3 = f27136a;
                    bArr2[i2 + 1] = bArr3[(b2 >> 4) & 15];
                    bArr2[i2 + 2] = bArr3[b2 & ap.m];
                    i2 += 3;
                } else {
                    bArr2[i2] = b2;
                    i2++;
                }
                i++;
            }
            byte[] bArr4 = new byte[i2];
            System.arraycopy(bArr2, 0, bArr4, 0, i2);
            return bArr4;
        }

        @Override // io.grpc.P.g
        public String a(byte[] bArr) {
            for (int i = 0; i < bArr.length; i++) {
                byte b2 = bArr[i];
                if (b2 < 32 || b2 >= 126 || (b2 == 37 && i + 2 < bArr.length)) {
                    return b(bArr);
                }
            }
            return new String(bArr, 0);
        }
    }

    private Status(Code code) {
        this(code, null, null);
    }

    public static Status b(byte[] bArr) {
        if (bArr.length == 1 && bArr[0] == 48) {
            return f27129b;
        }
        return c(bArr);
    }

    private static Status c(byte[] bArr) {
        int i2;
        int i3;
        int length = bArr.length;
        char c2 = 1;
        if (length != 1) {
            i2 = (length == 2 && bArr[0] >= 48 && bArr[0] <= 57) ? 0 + ((bArr[0] - 48) * 10) : 0;
            return f27131d.b("Unknown code " + new String(bArr, Charsets.f15076a));
        }
        c2 = 0;
        if (bArr[c2] >= 48 && bArr[c2] <= 57 && (i3 = i2 + (bArr[c2] - 48)) < f27128a.size()) {
            return f27128a.get(i3);
        }
        return f27131d.b("Unknown code " + new String(bArr, Charsets.f15076a));
    }

    private static List<Status> h() {
        TreeMap treeMap = new TreeMap();
        for (Code code : Code.values()) {
            Status status = (Status) treeMap.put(Integer.valueOf(code.value()), new Status(code));
            if (status != null) {
                throw new IllegalStateException("Code value duplication between " + status.e().name() + " & " + code.name());
            }
        }
        return Collections.unmodifiableList(new ArrayList(treeMap.values()));
    }

    @Nullable
    public Throwable d() {
        return this.x;
    }

    public Code e() {
        return this.v;
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Nullable
    public String f() {
        return this.w;
    }

    public boolean g() {
        return Code.OK == this.v;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        MoreObjects.ToStringHelper a2 = MoreObjects.a(this).a("code", this.v.name()).a("description", this.w);
        Throwable th = this.x;
        Object obj = th;
        if (th != null) {
            obj = Throwables.a(th);
        }
        return a2.a("cause", obj).toString();
    }

    private Status(Code code, @Nullable String str, @Nullable Throwable th) {
        Preconditions.a(code, "code");
        this.v = code;
        this.w = str;
        this.x = th;
    }

    public static Status a(int i2) {
        if (i2 >= 0 && i2 <= f27128a.size()) {
            return f27128a.get(i2);
        }
        return f27131d.b("Unknown code " + i2);
    }

    public Status b(Throwable th) {
        return Objects.a(this.x, th) ? this : new Status(this.v, this.w, th);
    }

    public static Status a(Throwable th) {
        Preconditions.a(th, com.umeng.commonsdk.proguard.e.ar);
        for (Throwable th2 = th; th2 != null; th2 = th2.getCause()) {
            if (th2 instanceof StatusException) {
                return ((StatusException) th2).getStatus();
            }
            if (th2 instanceof StatusRuntimeException) {
                return ((StatusRuntimeException) th2).getStatus();
            }
        }
        return f27131d.b(th);
    }

    public Status b(String str) {
        return Objects.a(this.w, str) ? this : new Status(this.v, str, this.x);
    }

    public StatusException b() {
        return new StatusException(this);
    }

    public StatusRuntimeException c() {
        return new StatusRuntimeException(this);
    }

    public static String a(Status status) {
        if (status.w == null) {
            return status.v.toString();
        }
        return status.v + ": " + status.w;
    }

    public Status a(String str) {
        if (str == null) {
            return this;
        }
        if (this.w == null) {
            return new Status(this.v, str, this.x);
        }
        return new Status(this.v, this.w + "\n" + str, this.x);
    }

    public StatusRuntimeException a(P p2) {
        return new StatusRuntimeException(this, p2);
    }
}
