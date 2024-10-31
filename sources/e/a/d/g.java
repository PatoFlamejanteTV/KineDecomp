package e.a.d;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import e.a.d.d;
import java.util.Map;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.ThreadSafe;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NoopStats.java */
/* loaded from: classes3.dex */
public final class g {

    /* compiled from: NoopStats.java */
    @Immutable
    /* loaded from: classes3.dex */
    public static final class a extends e {

        /* renamed from: a */
        static final e f26749a = new a();

        private a() {
        }

        @Override // e.a.d.e
        public e a(d.a aVar, double d2) {
            return this;
        }

        @Override // e.a.d.e
        public e a(d.b bVar, long j) {
            return this;
        }

        @Override // e.a.d.e
        public void a(e.a.e.f fVar) {
            Preconditions.a(fVar, "tags");
        }
    }

    /* compiled from: NoopStats.java */
    @Immutable
    /* loaded from: classes3.dex */
    public static final class c extends j {

        /* renamed from: a */
        static final j f26751a = new c();

        private c() {
        }

        @Override // e.a.d.j
        public e a() {
            return g.a();
        }
    }

    static e a() {
        return a.f26749a;
    }

    static j b() {
        return c.f26751a;
    }

    public static i c() {
        return new b();
    }

    static k d() {
        return new d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: NoopStats.java */
    @ThreadSafe
    /* loaded from: classes3.dex */
    public static final class b extends i {

        /* renamed from: a */
        private final k f26750a;

        private b() {
            this.f26750a = g.d();
        }

        @Override // e.a.d.i
        public j a() {
            return g.b();
        }

        /* synthetic */ b(f fVar) {
            this();
        }
    }

    /* compiled from: NoopStats.java */
    @ThreadSafe
    /* loaded from: classes3.dex */
    public static final class d extends k {

        /* renamed from: a */
        private static final e.a.a.b f26752a = e.a.a.b.a(0, 0);

        /* renamed from: b */
        private final Map<Object, Object> f26753b;

        private d() {
            this.f26753b = Maps.c();
        }

        /* synthetic */ d(f fVar) {
            this();
        }
    }
}
