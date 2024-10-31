package retrofit2;

import java.io.IOException;
import java.util.Map;
import javax.annotation.Nullable;
import okhttp3.D;
import okhttp3.L;

/* compiled from: ParameterHandler.java */
/* loaded from: classes3.dex */
public abstract class z<T> {

    /* compiled from: ParameterHandler.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends z<T> {

        /* renamed from: a */
        private final String f29537a;

        /* renamed from: b */
        private final retrofit2.j<T, String> f29538b;

        /* renamed from: c */
        private final boolean f29539c;

        public a(String str, retrofit2.j<T, String> jVar, boolean z) {
            H.a(str, "name == null");
            this.f29537a = str;
            this.f29538b = jVar;
            this.f29539c = z;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // retrofit2.z
        public void a(B b2, @Nullable T t) throws IOException {
            String a2;
            if (t == null || (a2 = this.f29538b.a(t)) == null) {
                return;
            }
            b2.a(this.f29537a, a2, this.f29539c);
        }
    }

    /* compiled from: ParameterHandler.java */
    /* loaded from: classes3.dex */
    static final class b<T> extends z<Map<String, T>> {

        /* renamed from: a */
        private final retrofit2.j<T, String> f29540a;

        /* renamed from: b */
        private final boolean f29541b;

        public b(retrofit2.j<T, String> jVar, boolean z) {
            this.f29540a = jVar;
            this.f29541b = z;
        }

        @Override // retrofit2.z
        public void a(B b2, @Nullable Map<String, T> map) throws IOException {
            if (map != null) {
                for (Map.Entry<String, T> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (key != null) {
                        T value = entry.getValue();
                        if (value != null) {
                            String a2 = this.f29540a.a(value);
                            if (a2 != null) {
                                b2.a(key, a2, this.f29541b);
                            } else {
                                throw new IllegalArgumentException("Field map value '" + value + "' converted to null by " + this.f29540a.getClass().getName() + " for key '" + key + "'.");
                            }
                        } else {
                            throw new IllegalArgumentException("Field map contained null value for key '" + key + "'.");
                        }
                    } else {
                        throw new IllegalArgumentException("Field map contained null key.");
                    }
                }
                return;
            }
            throw new IllegalArgumentException("Field map was null.");
        }
    }

    /* compiled from: ParameterHandler.java */
    /* loaded from: classes3.dex */
    static final class c<T> extends z<T> {

        /* renamed from: a */
        private final String f29542a;

        /* renamed from: b */
        private final retrofit2.j<T, String> f29543b;

        public c(String str, retrofit2.j<T, String> jVar) {
            H.a(str, "name == null");
            this.f29542a = str;
            this.f29543b = jVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // retrofit2.z
        public void a(B b2, @Nullable T t) throws IOException {
            String a2;
            if (t == null || (a2 = this.f29543b.a(t)) == null) {
                return;
            }
            b2.a(this.f29542a, a2);
        }
    }

    /* compiled from: ParameterHandler.java */
    /* loaded from: classes3.dex */
    static final class d<T> extends z<T> {

        /* renamed from: a */
        private final okhttp3.z f29544a;

        /* renamed from: b */
        private final retrofit2.j<T, L> f29545b;

        public d(okhttp3.z zVar, retrofit2.j<T, L> jVar) {
            this.f29544a = zVar;
            this.f29545b = jVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // retrofit2.z
        public void a(B b2, @Nullable T t) {
            if (t == null) {
                return;
            }
            try {
                b2.a(this.f29544a, this.f29545b.a(t));
            } catch (IOException e2) {
                throw new RuntimeException("Unable to convert " + t + " to RequestBody", e2);
            }
        }
    }

    /* compiled from: ParameterHandler.java */
    /* loaded from: classes3.dex */
    static final class e<T> extends z<Map<String, T>> {

        /* renamed from: a */
        private final retrofit2.j<T, L> f29546a;

        /* renamed from: b */
        private final String f29547b;

        public e(retrofit2.j<T, L> jVar, String str) {
            this.f29546a = jVar;
            this.f29547b = str;
        }

        @Override // retrofit2.z
        public void a(B b2, @Nullable Map<String, T> map) throws IOException {
            if (map != null) {
                for (Map.Entry<String, T> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (key != null) {
                        T value = entry.getValue();
                        if (value != null) {
                            b2.a(okhttp3.z.a("Content-Disposition", "form-data; name=\"" + key + "\"", "Content-Transfer-Encoding", this.f29547b), this.f29546a.a(value));
                        } else {
                            throw new IllegalArgumentException("Part map contained null value for key '" + key + "'.");
                        }
                    } else {
                        throw new IllegalArgumentException("Part map contained null key.");
                    }
                }
                return;
            }
            throw new IllegalArgumentException("Part map was null.");
        }
    }

    /* compiled from: ParameterHandler.java */
    /* loaded from: classes3.dex */
    static final class f<T> extends z<T> {

        /* renamed from: a */
        private final String f29548a;

        /* renamed from: b */
        private final retrofit2.j<T, String> f29549b;

        /* renamed from: c */
        private final boolean f29550c;

        public f(String str, retrofit2.j<T, String> jVar, boolean z) {
            H.a(str, "name == null");
            this.f29548a = str;
            this.f29549b = jVar;
            this.f29550c = z;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // retrofit2.z
        public void a(B b2, @Nullable T t) throws IOException {
            if (t != null) {
                b2.b(this.f29548a, this.f29549b.a(t), this.f29550c);
                return;
            }
            throw new IllegalArgumentException("Path parameter \"" + this.f29548a + "\" value must not be null.");
        }
    }

    /* compiled from: ParameterHandler.java */
    /* loaded from: classes3.dex */
    static final class g<T> extends z<T> {

        /* renamed from: a */
        private final String f29551a;

        /* renamed from: b */
        private final retrofit2.j<T, String> f29552b;

        /* renamed from: c */
        private final boolean f29553c;

        public g(String str, retrofit2.j<T, String> jVar, boolean z) {
            H.a(str, "name == null");
            this.f29551a = str;
            this.f29552b = jVar;
            this.f29553c = z;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // retrofit2.z
        public void a(B b2, @Nullable T t) throws IOException {
            String a2;
            if (t == null || (a2 = this.f29552b.a(t)) == null) {
                return;
            }
            b2.c(this.f29551a, a2, this.f29553c);
        }
    }

    /* compiled from: ParameterHandler.java */
    /* loaded from: classes3.dex */
    static final class h<T> extends z<Map<String, T>> {

        /* renamed from: a */
        private final retrofit2.j<T, String> f29554a;

        /* renamed from: b */
        private final boolean f29555b;

        public h(retrofit2.j<T, String> jVar, boolean z) {
            this.f29554a = jVar;
            this.f29555b = z;
        }

        @Override // retrofit2.z
        public void a(B b2, @Nullable Map<String, T> map) throws IOException {
            if (map != null) {
                for (Map.Entry<String, T> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (key != null) {
                        T value = entry.getValue();
                        if (value != null) {
                            String a2 = this.f29554a.a(value);
                            if (a2 != null) {
                                b2.c(key, a2, this.f29555b);
                            } else {
                                throw new IllegalArgumentException("Query map value '" + value + "' converted to null by " + this.f29554a.getClass().getName() + " for key '" + key + "'.");
                            }
                        } else {
                            throw new IllegalArgumentException("Query map contained null value for key '" + key + "'.");
                        }
                    } else {
                        throw new IllegalArgumentException("Query map contained null key.");
                    }
                }
                return;
            }
            throw new IllegalArgumentException("Query map was null.");
        }
    }

    /* compiled from: ParameterHandler.java */
    /* loaded from: classes3.dex */
    static final class i<T> extends z<T> {

        /* renamed from: a */
        private final retrofit2.j<T, String> f29556a;

        /* renamed from: b */
        private final boolean f29557b;

        public i(retrofit2.j<T, String> jVar, boolean z) {
            this.f29556a = jVar;
            this.f29557b = z;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // retrofit2.z
        public void a(B b2, @Nullable T t) throws IOException {
            if (t == null) {
                return;
            }
            b2.c(this.f29556a.a(t), null, this.f29557b);
        }
    }

    /* compiled from: ParameterHandler.java */
    /* loaded from: classes3.dex */
    static final class j extends z<D.b> {

        /* renamed from: a */
        static final j f29558a = new j();

        private j() {
        }

        @Override // retrofit2.z
        public void a(B b2, @Nullable D.b bVar) {
            if (bVar != null) {
                b2.a(bVar);
            }
        }
    }

    public final z<Object> a() {
        return new y(this);
    }

    public abstract void a(B b2, @Nullable T t) throws IOException;

    public final z<Iterable<T>> b() {
        return new x(this);
    }
}
