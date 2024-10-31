package com.google.common.cache;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Splitter;
import com.google.common.cache.LocalCache;
import com.google.common.collect.ImmutableMap;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

@GwtIncompatible
/* loaded from: classes2.dex */
public final class CacheBuilderSpec {

    /* renamed from: a, reason: collision with root package name */
    private static final Splitter f15164a = Splitter.a(',').b();

    /* renamed from: b, reason: collision with root package name */
    private static final Splitter f15165b = Splitter.a('=').b();

    /* renamed from: c, reason: collision with root package name */
    private static final ImmutableMap<String, l> f15166c = ImmutableMap.builder().a("initialCapacity", new d()).a("maximumSize", new h()).a("maximumWeight", new i()).a("concurrencyLevel", new b()).a("weakKeys", new f(LocalCache.Strength.WEAK)).a("softValues", new m(LocalCache.Strength.SOFT)).a("weakValues", new m(LocalCache.Strength.WEAK)).a("recordStats", new j()).a("expireAfterAccess", new a()).a("expireAfterWrite", new n()).a("refreshAfterWrite", new k()).a("refreshInterval", new k()).a();

    /* renamed from: d, reason: collision with root package name */
    @VisibleForTesting
    Integer f15167d;

    /* renamed from: e, reason: collision with root package name */
    @VisibleForTesting
    Long f15168e;

    /* renamed from: f, reason: collision with root package name */
    @VisibleForTesting
    Long f15169f;

    /* renamed from: g, reason: collision with root package name */
    @VisibleForTesting
    Integer f15170g;

    /* renamed from: h, reason: collision with root package name */
    @VisibleForTesting
    LocalCache.Strength f15171h;

    @VisibleForTesting
    LocalCache.Strength i;

    @VisibleForTesting
    Boolean j;

    @VisibleForTesting
    long k;

    @VisibleForTesting
    TimeUnit l;

    @VisibleForTesting
    long m;

    @VisibleForTesting
    TimeUnit n;

    @VisibleForTesting
    long o;

    @VisibleForTesting
    TimeUnit p;
    private final String q;

    /* loaded from: classes2.dex */
    static class a extends c {
        a() {
        }
    }

    /* loaded from: classes2.dex */
    static class b extends e {
        b() {
        }
    }

    /* loaded from: classes2.dex */
    static abstract class c implements l {
        c() {
        }
    }

    /* loaded from: classes2.dex */
    static class d extends e {
        d() {
        }
    }

    /* loaded from: classes2.dex */
    static abstract class e implements l {
        e() {
        }
    }

    /* loaded from: classes2.dex */
    static class f implements l {

        /* renamed from: a, reason: collision with root package name */
        private final LocalCache.Strength f15172a;

        public f(LocalCache.Strength strength) {
            this.f15172a = strength;
        }
    }

    /* loaded from: classes2.dex */
    static abstract class g implements l {
        g() {
        }
    }

    /* loaded from: classes2.dex */
    static class h extends g {
        h() {
        }
    }

    /* loaded from: classes2.dex */
    static class i extends g {
        i() {
        }
    }

    /* loaded from: classes2.dex */
    static class j implements l {
        j() {
        }
    }

    /* loaded from: classes2.dex */
    static class k extends c {
        k() {
        }
    }

    /* loaded from: classes2.dex */
    private interface l {
    }

    /* loaded from: classes2.dex */
    static class m implements l {

        /* renamed from: a, reason: collision with root package name */
        private final LocalCache.Strength f15173a;

        public m(LocalCache.Strength strength) {
            this.f15173a = strength;
        }
    }

    /* loaded from: classes2.dex */
    static class n extends c {
        n() {
        }
    }

    public String a() {
        return this.q;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CacheBuilderSpec)) {
            return false;
        }
        CacheBuilderSpec cacheBuilderSpec = (CacheBuilderSpec) obj;
        return Objects.a(this.f15167d, cacheBuilderSpec.f15167d) && Objects.a(this.f15168e, cacheBuilderSpec.f15168e) && Objects.a(this.f15169f, cacheBuilderSpec.f15169f) && Objects.a(this.f15170g, cacheBuilderSpec.f15170g) && Objects.a(this.f15171h, cacheBuilderSpec.f15171h) && Objects.a(this.i, cacheBuilderSpec.i) && Objects.a(this.j, cacheBuilderSpec.j) && Objects.a(a(this.k, this.l), a(cacheBuilderSpec.k, cacheBuilderSpec.l)) && Objects.a(a(this.m, this.n), a(cacheBuilderSpec.m, cacheBuilderSpec.n)) && Objects.a(a(this.o, this.p), a(cacheBuilderSpec.o, cacheBuilderSpec.p));
    }

    public int hashCode() {
        return Objects.a(this.f15167d, this.f15168e, this.f15169f, this.f15170g, this.f15171h, this.i, this.j, a(this.k, this.l), a(this.m, this.n), a(this.o, this.p));
    }

    public String toString() {
        return MoreObjects.a(this).a(a()).toString();
    }

    @Nullable
    private static Long a(long j2, @Nullable TimeUnit timeUnit) {
        if (timeUnit == null) {
            return null;
        }
        return Long.valueOf(timeUnit.toNanos(j2));
    }
}
