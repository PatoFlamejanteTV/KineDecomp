package com.google.common.cache;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Ascii;
import com.google.common.base.Equivalence;
import com.google.common.base.MoreObjects;
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

/* loaded from: classes2.dex */
public final class CacheBuilder<K, V> {

    /* renamed from: a, reason: collision with root package name */
    static final Supplier<? extends AbstractCache.StatsCounter> f15156a = Suppliers.a(new a());

    /* renamed from: b, reason: collision with root package name */
    static final CacheStats f15157b = new CacheStats(0, 0, 0, 0, 0, 0);

    /* renamed from: c, reason: collision with root package name */
    static final Supplier<AbstractCache.StatsCounter> f15158c = new b();

    /* renamed from: d, reason: collision with root package name */
    static final Ticker f15159d = new c();

    /* renamed from: e, reason: collision with root package name */
    private static final Logger f15160e = Logger.getLogger(CacheBuilder.class.getName());
    Weigher<? super K, ? super V> k;
    LocalCache.Strength l;
    LocalCache.Strength m;
    Equivalence<Object> q;
    Equivalence<Object> r;
    RemovalListener<? super K, ? super V> s;
    Ticker t;

    /* renamed from: f, reason: collision with root package name */
    boolean f15161f = true;

    /* renamed from: g, reason: collision with root package name */
    int f15162g = -1;

    /* renamed from: h, reason: collision with root package name */
    int f15163h = -1;
    long i = -1;
    long j = -1;
    long n = -1;
    long o = -1;
    long p = -1;
    Supplier<? extends AbstractCache.StatsCounter> u = f15156a;

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

    public static CacheBuilder<Object, Object> o() {
        return new CacheBuilder<>();
    }

    private void q() {
        Preconditions.b(this.p == -1, "refreshAfterWrite requires a LoadingCache");
    }

    private void r() {
        if (this.k == null) {
            Preconditions.b(this.j == -1, "maximumWeight requires weigher");
        } else if (this.f15161f) {
            Preconditions.b(this.j != -1, "weigher requires maximumWeight");
        } else if (this.j == -1) {
            f15160e.log(Level.WARNING, "ignoring weigher specified without maximumWeight");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @GwtIncompatible
    public CacheBuilder<K, V> a(Equivalence<Object> equivalence) {
        Preconditions.b(this.q == null, "key equivalence was already set to %s", this.q);
        Preconditions.a(equivalence);
        this.q = equivalence;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @GwtIncompatible
    public CacheBuilder<K, V> b(Equivalence<Object> equivalence) {
        Preconditions.b(this.r == null, "value equivalence was already set to %s", this.r);
        Preconditions.a(equivalence);
        this.r = equivalence;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long c() {
        long j = this.o;
        if (j == -1) {
            return 0L;
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long d() {
        long j = this.n;
        if (j == -1) {
            return 0L;
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        int i = this.f15162g;
        if (i == -1) {
            return 16;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Equivalence<Object> f() {
        return (Equivalence) MoreObjects.a(this.q, g().defaultEquivalence());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LocalCache.Strength g() {
        return (LocalCache.Strength) MoreObjects.a(this.l, LocalCache.Strength.STRONG);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long h() {
        if (this.n == 0 || this.o == 0) {
            return 0L;
        }
        return this.k == null ? this.i : this.j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long i() {
        long j = this.p;
        if (j == -1) {
            return 0L;
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <K1 extends K, V1 extends V> RemovalListener<K1, V1> j() {
        return (RemovalListener) MoreObjects.a(this.s, NullListener.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Supplier<? extends AbstractCache.StatsCounter> k() {
        return this.u;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Equivalence<Object> l() {
        return (Equivalence) MoreObjects.a(this.r, m().defaultEquivalence());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LocalCache.Strength m() {
        return (LocalCache.Strength) MoreObjects.a(this.m, LocalCache.Strength.STRONG);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <K1 extends K, V1 extends V> Weigher<K1, V1> n() {
        return (Weigher) MoreObjects.a(this.k, OneWeigher.INSTANCE);
    }

    @GwtIncompatible
    public CacheBuilder<K, V> p() {
        return a(LocalCache.Strength.WEAK);
    }

    public String toString() {
        MoreObjects.ToStringHelper a2 = MoreObjects.a(this);
        int i = this.f15162g;
        if (i != -1) {
            a2.a("initialCapacity", i);
        }
        int i2 = this.f15163h;
        if (i2 != -1) {
            a2.a("concurrencyLevel", i2);
        }
        long j = this.i;
        if (j != -1) {
            a2.a("maximumSize", j);
        }
        long j2 = this.j;
        if (j2 != -1) {
            a2.a("maximumWeight", j2);
        }
        if (this.n != -1) {
            a2.a("expireAfterWrite", this.n + "ns");
        }
        if (this.o != -1) {
            a2.a("expireAfterAccess", this.o + "ns");
        }
        LocalCache.Strength strength = this.l;
        if (strength != null) {
            a2.a("keyStrength", Ascii.a(strength.toString()));
        }
        LocalCache.Strength strength2 = this.m;
        if (strength2 != null) {
            a2.a("valueStrength", Ascii.a(strength2.toString()));
        }
        if (this.q != null) {
            a2.a("keyEquivalence");
        }
        if (this.r != null) {
            a2.a("valueEquivalence");
        }
        if (this.s != null) {
            a2.a("removalListener");
        }
        return a2.toString();
    }

    public CacheBuilder<K, V> a(int i) {
        Preconditions.b(this.f15163h == -1, "concurrency level was already set to %s", this.f15163h);
        Preconditions.a(i > 0);
        this.f15163h = i;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        int i = this.f15163h;
        if (i == -1) {
            return 4;
        }
        return i;
    }

    @GwtIncompatible
    public CacheBuilder<K, V> b(long j) {
        Preconditions.b(this.j == -1, "maximum weight was already set to %s", this.j);
        Preconditions.b(this.i == -1, "maximum size was already set to %s", this.i);
        this.j = j;
        Preconditions.a(j >= 0, "maximum weight must not be negative");
        return this;
    }

    public CacheBuilder<K, V> a(long j) {
        Preconditions.b(this.i == -1, "maximum size was already set to %s", this.i);
        Preconditions.b(this.j == -1, "maximum weight was already set to %s", this.j);
        Preconditions.b(this.k == null, "maximum size can not be combined with weigher");
        Preconditions.a(j >= 0, "maximum size must not be negative");
        this.i = j;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CacheBuilder<K, V> b(LocalCache.Strength strength) {
        Preconditions.b(this.m == null, "Value strength was already set to %s", this.m);
        Preconditions.a(strength);
        this.m = strength;
        return this;
    }

    public CacheBuilder<K, V> b(long j, TimeUnit timeUnit) {
        Preconditions.b(this.n == -1, "expireAfterWrite was already set to %s ns", this.n);
        Preconditions.a(j >= 0, "duration cannot be negative: %s %s", j, timeUnit);
        this.n = timeUnit.toNanos(j);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @GwtIncompatible
    public <K1 extends K, V1 extends V> CacheBuilder<K1, V1> a(Weigher<? super K1, ? super V1> weigher) {
        Preconditions.b(this.k == null);
        if (this.f15161f) {
            Preconditions.b(this.i == -1, "weigher can not be combined with maximum size", this.i);
        }
        Preconditions.a(weigher);
        this.k = weigher;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CacheBuilder<K, V> a(LocalCache.Strength strength) {
        Preconditions.b(this.l == null, "Key strength was already set to %s", this.l);
        Preconditions.a(strength);
        this.l = strength;
        return this;
    }

    public CacheBuilder<K, V> a(long j, TimeUnit timeUnit) {
        Preconditions.b(this.o == -1, "expireAfterAccess was already set to %s ns", this.o);
        Preconditions.a(j >= 0, "duration cannot be negative: %s %s", j, timeUnit);
        this.o = timeUnit.toNanos(j);
        return this;
    }

    public CacheBuilder<K, V> a(Ticker ticker) {
        Preconditions.b(this.t == null);
        Preconditions.a(ticker);
        this.t = ticker;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ticker a(boolean z) {
        Ticker ticker = this.t;
        return ticker != null ? ticker : z ? Ticker.b() : f15159d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @CheckReturnValue
    public <K1 extends K, V1 extends V> CacheBuilder<K1, V1> a(RemovalListener<? super K1, ? super V1> removalListener) {
        Preconditions.b(this.s == null);
        Preconditions.a(removalListener);
        this.s = removalListener;
        return this;
    }

    public <K1 extends K, V1 extends V> LoadingCache<K1, V1> a(CacheLoader<? super K1, V1> cacheLoader) {
        r();
        return new LocalCache.LocalLoadingCache(this, cacheLoader);
    }

    public <K1 extends K, V1 extends V> Cache<K1, V1> a() {
        r();
        q();
        return new LocalCache.LocalManualCache(this);
    }
}
