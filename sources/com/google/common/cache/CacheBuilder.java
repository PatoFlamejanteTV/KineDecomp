package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Ascii;
import com.google.common.base.Equivalence;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.base.Ticker;
import com.google.common.cache.AbstractCache;
import com.google.common.cache.LocalCache;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckReturnValue;

@GwtCompatible
/* loaded from: classes.dex */
public final class CacheBuilder<K, V> {

    /* renamed from: a, reason: collision with root package name */
    static final Supplier<? extends AbstractCache.StatsCounter> f2598a = Suppliers.a(new a());
    static final CacheStats b = new CacheStats(0, 0, 0, 0, 0, 0);
    static final Supplier<AbstractCache.StatsCounter> c = new b();
    static final Ticker d = new c();
    private static final Logger u = Logger.getLogger(CacheBuilder.class.getName());
    Weigher<? super K, ? super V> j;
    LocalCache.Strength k;
    LocalCache.Strength l;
    Equivalence<Object> p;
    Equivalence<Object> q;
    RemovalListener<? super K, ? super V> r;
    Ticker s;
    boolean e = true;
    int f = -1;
    int g = -1;
    long h = -1;
    long i = -1;
    long m = -1;
    long n = -1;
    long o = -1;
    Supplier<? extends AbstractCache.StatsCounter> t = f2598a;

    /* loaded from: classes2.dex */
    enum NullListener implements RemovalListener<Object, Object> {
        INSTANCE;

        @Override // com.google.common.cache.RemovalListener
        public void onRemoval(RemovalNotification<Object, Object> removalNotification) {
        }
    }

    /* loaded from: classes2.dex */
    enum OneWeigher implements Weigher<Object, Object> {
        INSTANCE;

        @Override // com.google.common.cache.Weigher
        public int weigh(Object obj, Object obj2) {
            return 1;
        }
    }

    CacheBuilder() {
    }

    public static CacheBuilder<Object, Object> a() {
        return new CacheBuilder<>();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CacheBuilder<K, V> a(Equivalence<Object> equivalence) {
        Preconditions.b(this.p == null, "key equivalence was already set to %s", this.p);
        this.p = (Equivalence) Preconditions.a(equivalence);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Equivalence<Object> b() {
        return (Equivalence) Objects.b(this.p, i().defaultEquivalence());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CacheBuilder<K, V> b(Equivalence<Object> equivalence) {
        Preconditions.b(this.q == null, "value equivalence was already set to %s", this.q);
        this.q = (Equivalence) Preconditions.a(equivalence);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Equivalence<Object> c() {
        return (Equivalence) Objects.b(this.q, j().defaultEquivalence());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        if (this.f == -1) {
            return 16;
        }
        return this.f;
    }

    public CacheBuilder<K, V> a(int i) {
        Preconditions.b(this.g == -1, "concurrency level was already set to %s", Integer.valueOf(this.g));
        Preconditions.a(i > 0);
        this.g = i;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        if (this.g == -1) {
            return 4;
        }
        return this.g;
    }

    public CacheBuilder<K, V> a(long j) {
        Preconditions.b(this.h == -1, "maximum size was already set to %s", Long.valueOf(this.h));
        Preconditions.b(this.i == -1, "maximum weight was already set to %s", Long.valueOf(this.i));
        Preconditions.b(this.j == null, "maximum size can not be combined with weigher");
        Preconditions.a(j >= 0, "maximum size must not be negative");
        this.h = j;
        return this;
    }

    public CacheBuilder<K, V> b(long j) {
        Preconditions.b(this.i == -1, "maximum weight was already set to %s", Long.valueOf(this.i));
        Preconditions.b(this.h == -1, "maximum size was already set to %s", Long.valueOf(this.h));
        this.i = j;
        Preconditions.a(j >= 0, "maximum weight must not be negative");
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <K1 extends K, V1 extends V> CacheBuilder<K1, V1> a(Weigher<? super K1, ? super V1> weigher) {
        Preconditions.b(this.j == null);
        if (this.e) {
            Preconditions.b(this.h == -1, "weigher can not be combined with maximum size", Long.valueOf(this.h));
        }
        this.j = (Weigher) Preconditions.a(weigher);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long f() {
        if (this.m == 0 || this.n == 0) {
            return 0L;
        }
        return this.j == null ? this.h : this.i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <K1 extends K, V1 extends V> Weigher<K1, V1> g() {
        return (Weigher) Objects.b(this.j, OneWeigher.INSTANCE);
    }

    @GwtIncompatible
    public CacheBuilder<K, V> h() {
        return a(LocalCache.Strength.WEAK);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CacheBuilder<K, V> a(LocalCache.Strength strength) {
        Preconditions.b(this.k == null, "Key strength was already set to %s", this.k);
        this.k = (LocalCache.Strength) Preconditions.a(strength);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LocalCache.Strength i() {
        return (LocalCache.Strength) Objects.b(this.k, LocalCache.Strength.STRONG);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CacheBuilder<K, V> b(LocalCache.Strength strength) {
        Preconditions.b(this.l == null, "Value strength was already set to %s", this.l);
        this.l = (LocalCache.Strength) Preconditions.a(strength);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LocalCache.Strength j() {
        return (LocalCache.Strength) Objects.b(this.l, LocalCache.Strength.STRONG);
    }

    public CacheBuilder<K, V> a(long j, TimeUnit timeUnit) {
        Preconditions.b(this.m == -1, "expireAfterWrite was already set to %s ns", Long.valueOf(this.m));
        Preconditions.a(j >= 0, "duration cannot be negative: %s %s", Long.valueOf(j), timeUnit);
        this.m = timeUnit.toNanos(j);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long k() {
        if (this.m == -1) {
            return 0L;
        }
        return this.m;
    }

    public CacheBuilder<K, V> b(long j, TimeUnit timeUnit) {
        Preconditions.b(this.n == -1, "expireAfterAccess was already set to %s ns", Long.valueOf(this.n));
        Preconditions.a(j >= 0, "duration cannot be negative: %s %s", Long.valueOf(j), timeUnit);
        this.n = timeUnit.toNanos(j);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long l() {
        if (this.n == -1) {
            return 0L;
        }
        return this.n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long m() {
        if (this.o == -1) {
            return 0L;
        }
        return this.o;
    }

    @GwtIncompatible
    public CacheBuilder<K, V> a(Ticker ticker) {
        Preconditions.b(this.s == null);
        this.s = (Ticker) Preconditions.a(ticker);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ticker a(boolean z) {
        if (this.s != null) {
            return this.s;
        }
        return z ? Ticker.b() : d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @GwtIncompatible
    @CheckReturnValue
    public <K1 extends K, V1 extends V> CacheBuilder<K1, V1> a(RemovalListener<? super K1, ? super V1> removalListener) {
        Preconditions.b(this.r == null);
        this.r = (RemovalListener) Preconditions.a(removalListener);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <K1 extends K, V1 extends V> RemovalListener<K1, V1> n() {
        return (RemovalListener) Objects.b(this.r, NullListener.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Supplier<? extends AbstractCache.StatsCounter> o() {
        return this.t;
    }

    public <K1 extends K, V1 extends V> LoadingCache<K1, V1> a(CacheLoader<? super K1, V1> cacheLoader) {
        r();
        return new LocalCache.LocalLoadingCache(this, cacheLoader);
    }

    public <K1 extends K, V1 extends V> Cache<K1, V1> p() {
        r();
        q();
        return new LocalCache.LocalManualCache(this);
    }

    private void q() {
        Preconditions.b(this.o == -1, "refreshAfterWrite requires a LoadingCache");
    }

    private void r() {
        if (this.j == null) {
            Preconditions.b(this.i == -1, "maximumWeight requires weigher");
        } else if (this.e) {
            Preconditions.b(this.i != -1, "weigher requires maximumWeight");
        } else if (this.i == -1) {
            u.log(Level.WARNING, "ignoring weigher specified without maximumWeight");
        }
    }

    public String toString() {
        Objects.ToStringHelper a2 = Objects.a(this);
        if (this.f != -1) {
            a2.a("initialCapacity", this.f);
        }
        if (this.g != -1) {
            a2.a("concurrencyLevel", this.g);
        }
        if (this.i != -1) {
            if (this.j == null) {
                a2.a("maximumSize", this.i);
            } else {
                a2.a("maximumWeight", this.i);
            }
        }
        if (this.m != -1) {
            a2.a("expireAfterWrite", this.m + "ns");
        }
        if (this.n != -1) {
            a2.a("expireAfterAccess", this.n + "ns");
        }
        if (this.k != null) {
            a2.a("keyStrength", Ascii.a(this.k.toString()));
        }
        if (this.l != null) {
            a2.a("valueStrength", Ascii.a(this.l.toString()));
        }
        if (this.p != null) {
            a2.a((Object) "keyEquivalence");
        }
        if (this.q != null) {
            a2.a((Object) "valueEquivalence");
        }
        if (this.r != null) {
            a2.a((Object) "removalListener");
        }
        return a2.toString();
    }
}
