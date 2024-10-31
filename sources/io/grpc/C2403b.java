package io.grpc;

import com.google.common.base.Objects;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

/* compiled from: Attributes.java */
@Immutable
/* renamed from: io.grpc.b */
/* loaded from: classes3.dex */
public final class C2403b {

    /* renamed from: a */
    public static final C2403b f27155a = new C2403b(Collections.emptyMap());

    /* renamed from: b */
    static final /* synthetic */ boolean f27156b = false;

    /* renamed from: c */
    private final Map<C0153b<?>, Object> f27157c;

    /* compiled from: Attributes.java */
    /* renamed from: io.grpc.b$a */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a */
        private C2403b f27158a;

        /* renamed from: b */
        private Map<C0153b<?>, Object> f27159b;

        /* synthetic */ a(C2403b c2403b, C2402a c2402a) {
            this(c2403b);
        }

        private Map<C0153b<?>, Object> a(int i) {
            if (this.f27159b == null) {
                this.f27159b = new IdentityHashMap(i);
            }
            return this.f27159b;
        }

        private a(C2403b c2403b) {
            this.f27158a = c2403b;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public <T> a a(C0153b<T> c0153b, T t) {
            a(1).put(c0153b, t);
            return this;
        }

        public <T> a a(C2403b c2403b) {
            a(c2403b.f27157c.size()).putAll(c2403b.f27157c);
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public C2403b a() {
            if (this.f27159b != null) {
                for (Map.Entry entry : this.f27158a.f27157c.entrySet()) {
                    if (!this.f27159b.containsKey(entry.getKey())) {
                        this.f27159b.put(entry.getKey(), entry.getValue());
                    }
                }
                this.f27158a = new C2403b(this.f27159b);
                this.f27159b = null;
            }
            return this.f27158a;
        }
    }

    /* compiled from: Attributes.java */
    @Immutable
    /* renamed from: io.grpc.b$b */
    /* loaded from: classes3.dex */
    public static final class C0153b<T> {

        /* renamed from: a */
        private final String f27162a;

        private C0153b(String str) {
            this.f27162a = str;
        }

        public static <T> C0153b<T> a(String str) {
            return new C0153b<>(str);
        }

        public String toString() {
            return this.f27162a;
        }
    }

    /* synthetic */ C2403b(Map map, C2402a c2402a) {
        this(map);
    }

    public static a b() {
        return new a();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C2403b.class != obj.getClass()) {
            return false;
        }
        C2403b c2403b = (C2403b) obj;
        if (this.f27157c.size() != c2403b.f27157c.size()) {
            return false;
        }
        for (Map.Entry<C0153b<?>, Object> entry : this.f27157c.entrySet()) {
            if (!c2403b.f27157c.containsKey(entry.getKey()) || !Objects.a(entry.getValue(), c2403b.f27157c.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        return this.f27157c.hashCode();
    }

    public String toString() {
        return this.f27157c.toString();
    }

    private C2403b(Map<C0153b<?>, Object> map) {
        if (!f27156b && map == null) {
            throw new AssertionError();
        }
        this.f27157c = map;
    }

    @Nullable
    public <T> T a(C0153b<T> c0153b) {
        return (T) this.f27157c.get(c0153b);
    }

    public Set<C0153b<?>> a() {
        return Collections.unmodifiableSet(this.f27157c.keySet());
    }
}
