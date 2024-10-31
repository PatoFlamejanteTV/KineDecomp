package io.grpc;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import io.grpc.AbstractC2513n;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

/* compiled from: CallOptions.java */
@Immutable
/* renamed from: io.grpc.e */
/* loaded from: classes3.dex */
public final class C2406e {

    /* renamed from: a */
    public static final C2406e f27183a = new C2406e();

    /* renamed from: b */
    private C2526v f27184b;

    /* renamed from: c */
    private Executor f27185c;

    /* renamed from: d */
    @Nullable
    private String f27186d;

    /* renamed from: e */
    @Nullable
    private InterfaceC2405d f27187e;

    /* renamed from: f */
    @Nullable
    private String f27188f;

    /* renamed from: g */
    private Object[][] f27189g;

    /* renamed from: h */
    private List<AbstractC2513n.a> f27190h;
    private boolean i;

    @Nullable
    private Integer j;

    @Nullable
    private Integer k;

    /* compiled from: CallOptions.java */
    /* renamed from: io.grpc.e$a */
    /* loaded from: classes3.dex */
    public static final class a<T> {

        /* renamed from: a */
        private final String f27191a;

        /* renamed from: b */
        private final T f27192b;

        private a(String str, T t) {
            this.f27191a = str;
            this.f27192b = t;
        }

        public String toString() {
            return this.f27191a;
        }

        public static <T> a<T> a(String str, T t) {
            Preconditions.a(str, "name");
            return new a<>(str, t);
        }
    }

    private C2406e() {
        this.f27189g = (Object[][]) Array.newInstance((Class<?>) Object.class, 0, 2);
        this.f27190h = Collections.emptyList();
    }

    public C2406e a(@Nullable C2526v c2526v) {
        C2406e c2406e = new C2406e(this);
        c2406e.f27184b = c2526v;
        return c2406e;
    }

    @Nullable
    public String b() {
        return this.f27188f;
    }

    @Nullable
    public InterfaceC2405d c() {
        return this.f27187e;
    }

    @Nullable
    public C2526v d() {
        return this.f27184b;
    }

    @Nullable
    public Executor e() {
        return this.f27185c;
    }

    @Nullable
    public Integer f() {
        return this.j;
    }

    @Nullable
    public Integer g() {
        return this.k;
    }

    public List<AbstractC2513n.a> h() {
        return this.f27190h;
    }

    public boolean i() {
        return this.i;
    }

    public C2406e j() {
        C2406e c2406e = new C2406e(this);
        c2406e.i = true;
        return c2406e;
    }

    public C2406e k() {
        C2406e c2406e = new C2406e(this);
        c2406e.i = false;
        return c2406e;
    }

    public String toString() {
        MoreObjects.ToStringHelper a2 = MoreObjects.a(this).a("deadline", this.f27184b).a("authority", this.f27186d).a("callCredentials", this.f27187e);
        Executor executor = this.f27185c;
        return a2.a("executor", executor != null ? executor.getClass() : null).a("compressorName", this.f27188f).a("customOptions", Arrays.deepToString(this.f27189g)).a("waitForReady", i()).a("maxInboundMessageSize", this.j).a("maxOutboundMessageSize", this.k).a("streamTracerFactories", this.f27190h).toString();
    }

    public C2406e b(int i) {
        Preconditions.a(i >= 0, "invalid maxsize %s", i);
        C2406e c2406e = new C2406e(this);
        c2406e.k = Integer.valueOf(i);
        return c2406e;
    }

    @Nullable
    public String a() {
        return this.f27186d;
    }

    private C2406e(C2406e c2406e) {
        this.f27189g = (Object[][]) Array.newInstance((Class<?>) Object.class, 0, 2);
        this.f27190h = Collections.emptyList();
        this.f27184b = c2406e.f27184b;
        this.f27186d = c2406e.f27186d;
        this.f27187e = c2406e.f27187e;
        this.f27185c = c2406e.f27185c;
        this.f27188f = c2406e.f27188f;
        this.f27189g = c2406e.f27189g;
        this.i = c2406e.i;
        this.j = c2406e.j;
        this.k = c2406e.k;
        this.f27190h = c2406e.f27190h;
    }

    public C2406e a(Executor executor) {
        C2406e c2406e = new C2406e(this);
        c2406e.f27185c = executor;
        return c2406e;
    }

    public C2406e a(AbstractC2513n.a aVar) {
        C2406e c2406e = new C2406e(this);
        ArrayList arrayList = new ArrayList(this.f27190h.size() + 1);
        arrayList.addAll(this.f27190h);
        arrayList.add(aVar);
        c2406e.f27190h = Collections.unmodifiableList(arrayList);
        return c2406e;
    }

    public <T> C2406e a(a<T> aVar, T t) {
        Preconditions.a(aVar, "key");
        Preconditions.a(t, "value");
        C2406e c2406e = new C2406e(this);
        int i = 0;
        while (true) {
            Object[][] objArr = this.f27189g;
            if (i >= objArr.length) {
                i = -1;
                break;
            }
            if (aVar.equals(objArr[i][0])) {
                break;
            }
            i++;
        }
        c2406e.f27189g = (Object[][]) Array.newInstance((Class<?>) Object.class, this.f27189g.length + (i == -1 ? 1 : 0), 2);
        Object[][] objArr2 = this.f27189g;
        System.arraycopy(objArr2, 0, c2406e.f27189g, 0, objArr2.length);
        if (i == -1) {
            Object[][] objArr3 = c2406e.f27189g;
            int length = this.f27189g.length;
            Object[] objArr4 = new Object[2];
            objArr4[0] = aVar;
            objArr4[1] = t;
            objArr3[length] = objArr4;
        } else {
            c2406e.f27189g[i][1] = t;
        }
        return c2406e;
    }

    public <T> T a(a<T> aVar) {
        Preconditions.a(aVar, "key");
        int i = 0;
        while (true) {
            Object[][] objArr = this.f27189g;
            if (i >= objArr.length) {
                return (T) ((a) aVar).f27192b;
            }
            if (aVar.equals(objArr[i][0])) {
                return (T) this.f27189g[i][1];
            }
            i++;
        }
    }

    public C2406e a(int i) {
        Preconditions.a(i >= 0, "invalid maxsize %s", i);
        C2406e c2406e = new C2406e(this);
        c2406e.j = Integer.valueOf(i);
        return c2406e;
    }
}
