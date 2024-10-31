package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import okhttp3.L;
import okhttp3.O;
import retrofit2.j;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BuiltInConverters.java */
/* renamed from: retrofit2.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2577a extends j.a {

    /* renamed from: a, reason: collision with root package name */
    private boolean f29448a = true;

    /* compiled from: BuiltInConverters.java */
    /* renamed from: retrofit2.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    static final class C0173a implements j<O, O> {

        /* renamed from: a, reason: collision with root package name */
        static final C0173a f29449a = new C0173a();

        C0173a() {
        }

        @Override // retrofit2.j
        public O a(O o) throws IOException {
            try {
                return H.a(o);
            } finally {
                o.close();
            }
        }
    }

    /* compiled from: BuiltInConverters.java */
    /* renamed from: retrofit2.a$b */
    /* loaded from: classes3.dex */
    static final class b implements j<L, L> {

        /* renamed from: a, reason: collision with root package name */
        static final b f29457a = new b();

        b() {
        }

        @Override // retrofit2.j
        public /* bridge */ /* synthetic */ L a(L l) throws IOException {
            L l2 = l;
            a2(l2);
            return l2;
        }

        /* renamed from: a, reason: avoid collision after fix types in other method */
        public L a2(L l) {
            return l;
        }
    }

    /* compiled from: BuiltInConverters.java */
    /* renamed from: retrofit2.a$c */
    /* loaded from: classes3.dex */
    static final class c implements j<O, O> {

        /* renamed from: a, reason: collision with root package name */
        static final c f29458a = new c();

        c() {
        }

        @Override // retrofit2.j
        public /* bridge */ /* synthetic */ O a(O o) throws IOException {
            O o2 = o;
            a2(o2);
            return o2;
        }

        /* renamed from: a, reason: avoid collision after fix types in other method */
        public O a2(O o) {
            return o;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BuiltInConverters.java */
    /* renamed from: retrofit2.a$d */
    /* loaded from: classes3.dex */
    public static final class d implements j<Object, String> {

        /* renamed from: a, reason: collision with root package name */
        static final d f29459a = new d();

        d() {
        }

        @Override // retrofit2.j
        public String a(Object obj) {
            return obj.toString();
        }
    }

    /* compiled from: BuiltInConverters.java */
    /* renamed from: retrofit2.a$e */
    /* loaded from: classes3.dex */
    static final class e implements j<O, kotlin.k> {

        /* renamed from: a, reason: collision with root package name */
        static final e f29460a = new e();

        e() {
        }

        @Override // retrofit2.j
        public kotlin.k a(O o) {
            o.close();
            return kotlin.k.f28545a;
        }
    }

    /* compiled from: BuiltInConverters.java */
    /* renamed from: retrofit2.a$f */
    /* loaded from: classes3.dex */
    static final class f implements j<O, Void> {

        /* renamed from: a, reason: collision with root package name */
        static final f f29461a = new f();

        f() {
        }

        @Override // retrofit2.j
        public Void a(O o) {
            o.close();
            return null;
        }
    }

    @Override // retrofit2.j.a
    @Nullable
    public j<O, ?> a(Type type, Annotation[] annotationArr, F f2) {
        if (type == O.class) {
            if (H.a(annotationArr, (Class<? extends Annotation>) retrofit2.b.t.class)) {
                return c.f29458a;
            }
            return C0173a.f29449a;
        }
        if (type == Void.class) {
            return f.f29461a;
        }
        if (!this.f29448a || type != kotlin.k.class) {
            return null;
        }
        try {
            return e.f29460a;
        } catch (NoClassDefFoundError unused) {
            this.f29448a = false;
            return null;
        }
    }

    @Override // retrofit2.j.a
    @Nullable
    public j<?, L> a(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, F f2) {
        if (L.class.isAssignableFrom(H.c(type))) {
            return b.f29457a;
        }
        return null;
    }
}
