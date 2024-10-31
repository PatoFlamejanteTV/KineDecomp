package e.a.e;

import com.google.common.base.Preconditions;
import java.util.Collections;
import java.util.Iterator;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.ThreadSafe;

/* compiled from: NoopTags.java */
/* loaded from: classes3.dex */
final class d {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: NoopTags.java */
    @Immutable
    /* loaded from: classes3.dex */
    public static final class a extends e.a.e.f {

        /* renamed from: a, reason: collision with root package name */
        static final e.a.e.f f26758a = new a();

        private a() {
        }

        @Override // e.a.e.f
        protected Iterator<e.a.e.e> a() {
            return Collections.emptySet().iterator();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: NoopTags.java */
    @Immutable
    /* renamed from: e.a.e.d$d, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0151d extends io.opencensus.tags.propagation.b {

        /* renamed from: a, reason: collision with root package name */
        static final io.opencensus.tags.propagation.b f26762a = new C0151d();

        private C0151d() {
        }

        @Override // io.opencensus.tags.propagation.b
        public io.opencensus.tags.propagation.a a() {
            return d.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: NoopTags.java */
    @Immutable
    /* loaded from: classes3.dex */
    public static final class e extends j {

        /* renamed from: a, reason: collision with root package name */
        static final j f26763a = new e();

        private e() {
        }

        @Override // e.a.e.j
        public e.a.e.f a() {
            return d.a();
        }

        @Override // e.a.e.j
        public e.a.e.f b() {
            return d.a();
        }

        @Override // e.a.e.j
        public g a(e.a.e.f fVar) {
            Preconditions.a(fVar, "tags");
            return d.c();
        }
    }

    /* compiled from: NoopTags.java */
    @ThreadSafe
    /* loaded from: classes3.dex */
    private static final class f extends l {
        private f() {
        }

        @Override // e.a.e.l
        public io.opencensus.tags.propagation.b a() {
            return d.d();
        }

        @Override // e.a.e.l
        public j b() {
            return d.e();
        }
    }

    static e.a.e.f a() {
        return a.f26758a;
    }

    static io.opencensus.tags.propagation.a b() {
        return b.f26759a;
    }

    static g c() {
        return c.f26761a;
    }

    static io.opencensus.tags.propagation.b d() {
        return C0151d.f26762a;
    }

    static j e() {
        return e.f26763a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static l f() {
        return new f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: NoopTags.java */
    @Immutable
    /* loaded from: classes3.dex */
    public static final class b extends io.opencensus.tags.propagation.a {

        /* renamed from: a, reason: collision with root package name */
        static final io.opencensus.tags.propagation.a f26759a = new b();

        /* renamed from: b, reason: collision with root package name */
        static final byte[] f26760b = new byte[0];

        private b() {
        }

        @Override // io.opencensus.tags.propagation.a
        public byte[] a(e.a.e.f fVar) {
            Preconditions.a(fVar, "tags");
            return f26760b;
        }

        @Override // io.opencensus.tags.propagation.a
        public e.a.e.f a(byte[] bArr) {
            Preconditions.a(bArr, "bytes");
            return d.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: NoopTags.java */
    @Immutable
    /* loaded from: classes3.dex */
    public static final class c extends g {

        /* renamed from: a, reason: collision with root package name */
        static final g f26761a = new c();

        private c() {
        }

        @Override // e.a.e.g
        public g a(h hVar, i iVar) {
            Preconditions.a(hVar, "key");
            Preconditions.a(iVar, "value");
            return this;
        }

        @Override // e.a.e.g
        public e.a.e.f a() {
            return d.a();
        }
    }
}
