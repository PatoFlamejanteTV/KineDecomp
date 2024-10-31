package io.grpc;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicReferenceArray;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* loaded from: classes3.dex */
public final class MethodDescriptor<ReqT, RespT> {

    /* renamed from: a */
    private final MethodType f27100a;

    /* renamed from: b */
    private final String f27101b;

    /* renamed from: c */
    private final b<ReqT> f27102c;

    /* renamed from: d */
    private final b<RespT> f27103d;

    /* renamed from: e */
    @Nullable
    private final Object f27104e;

    /* renamed from: f */
    private final boolean f27105f;

    /* renamed from: g */
    private final boolean f27106g;

    /* renamed from: h */
    private final boolean f27107h;
    private final AtomicReferenceArray<Object> i;

    /* loaded from: classes3.dex */
    public enum MethodType {
        UNARY,
        CLIENT_STREAMING,
        SERVER_STREAMING,
        BIDI_STREAMING,
        UNKNOWN;

        public final boolean clientSendsOneMessage() {
            return this == UNARY || this == SERVER_STREAMING;
        }

        public final boolean serverSendsOneMessage() {
            return this == UNARY || this == CLIENT_STREAMING;
        }
    }

    /* loaded from: classes3.dex */
    public static final class a<ReqT, RespT> {

        /* renamed from: a */
        private b<ReqT> f27108a;

        /* renamed from: b */
        private b<RespT> f27109b;

        /* renamed from: c */
        private MethodType f27110c;

        /* renamed from: d */
        private String f27111d;

        /* renamed from: e */
        private boolean f27112e;

        /* renamed from: f */
        private boolean f27113f;

        /* renamed from: g */
        private Object f27114g;

        /* renamed from: h */
        private boolean f27115h;

        /* synthetic */ a(Q q) {
            this();
        }

        public a<ReqT, RespT> a(b<ReqT> bVar) {
            this.f27108a = bVar;
            return this;
        }

        public a<ReqT, RespT> b(b<RespT> bVar) {
            this.f27109b = bVar;
            return this;
        }

        public a<ReqT, RespT> c(boolean z) {
            this.f27115h = z;
            return this;
        }

        private a() {
        }

        public a<ReqT, RespT> a(MethodType methodType) {
            this.f27110c = methodType;
            return this;
        }

        public a<ReqT, RespT> b(boolean z) {
            this.f27113f = z;
            return this;
        }

        public a<ReqT, RespT> a(String str) {
            this.f27111d = str;
            return this;
        }

        public a<ReqT, RespT> a(@Nullable Object obj) {
            this.f27114g = obj;
            return this;
        }

        public a<ReqT, RespT> a(boolean z) {
            this.f27112e = z;
            return this;
        }

        @CheckReturnValue
        public MethodDescriptor<ReqT, RespT> a() {
            return new MethodDescriptor<>(this.f27110c, this.f27111d, this.f27108a, this.f27109b, this.f27114g, this.f27112e, this.f27113f, this.f27115h);
        }
    }

    /* loaded from: classes3.dex */
    public interface b<T> {
        InputStream a(T t);

        T a(InputStream inputStream);
    }

    /* loaded from: classes3.dex */
    public interface c<T> extends d<T> {
    }

    /* loaded from: classes3.dex */
    public interface d<T> extends b<T> {
    }

    /* synthetic */ MethodDescriptor(MethodType methodType, String str, b bVar, b bVar2, Object obj, boolean z, boolean z2, boolean z3, Q q) {
        this(methodType, str, bVar, bVar2, obj, z, z2, z3);
    }

    @CheckReturnValue
    public static <ReqT, RespT> a<ReqT, RespT> g() {
        return a((b) null, (b) null);
    }

    public String a() {
        return this.f27101b;
    }

    public b<ReqT> b() {
        return this.f27102c;
    }

    public b<RespT> c() {
        return this.f27103d;
    }

    public MethodType d() {
        return this.f27100a;
    }

    public boolean e() {
        return this.f27106g;
    }

    public boolean f() {
        return this.f27107h;
    }

    public String toString() {
        return MoreObjects.a(this).a("fullMethodName", this.f27101b).a("type", this.f27100a).a("idempotent", this.f27105f).a("safe", this.f27106g).a("sampledToLocalTracing", this.f27107h).a("requestMarshaller", this.f27102c).a("responseMarshaller", this.f27103d).a("schemaDescriptor", this.f27104e).a().toString();
    }

    private MethodDescriptor(MethodType methodType, String str, b<ReqT> bVar, b<RespT> bVar2, Object obj, boolean z, boolean z2, boolean z3) {
        boolean z4 = true;
        this.i = new AtomicReferenceArray<>(1);
        Preconditions.a(methodType, "type");
        this.f27100a = methodType;
        Preconditions.a(str, "fullMethodName");
        this.f27101b = str;
        Preconditions.a(bVar, "requestMarshaller");
        this.f27102c = bVar;
        Preconditions.a(bVar2, "responseMarshaller");
        this.f27103d = bVar2;
        this.f27104e = obj;
        this.f27105f = z;
        this.f27106g = z2;
        this.f27107h = z3;
        if (z2 && methodType != MethodType.UNARY) {
            z4 = false;
        }
        Preconditions.a(z4, "Only unary methods can be specified safe");
    }

    public RespT a(InputStream inputStream) {
        return this.f27103d.a(inputStream);
    }

    @CheckReturnValue
    public <NewReqT, NewRespT> a<NewReqT, NewRespT> b(b<NewReqT> bVar, b<NewRespT> bVar2) {
        a<NewReqT, NewRespT> g2 = g();
        g2.a(bVar);
        g2.b(bVar2);
        g2.a(this.f27100a);
        g2.a(this.f27101b);
        g2.a(this.f27105f);
        g2.b(this.f27106g);
        g2.c(this.f27107h);
        g2.a(this.f27104e);
        return g2;
    }

    public InputStream a(ReqT reqt) {
        return this.f27102c.a((b<ReqT>) reqt);
    }

    public static String a(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        Preconditions.a(str, "fullServiceName");
        sb.append(str);
        sb.append("/");
        Preconditions.a(str2, "methodName");
        sb.append(str2);
        return sb.toString();
    }

    @Nullable
    public static String a(String str) {
        Preconditions.a(str, "fullMethodName");
        int lastIndexOf = str.lastIndexOf(47);
        if (lastIndexOf == -1) {
            return null;
        }
        return str.substring(0, lastIndexOf);
    }

    @CheckReturnValue
    public static <ReqT, RespT> a<ReqT, RespT> a(b<ReqT> bVar, b<RespT> bVar2) {
        a<ReqT, RespT> aVar = new a<>();
        aVar.a((b) bVar);
        aVar.b(bVar2);
        return aVar;
    }
}
