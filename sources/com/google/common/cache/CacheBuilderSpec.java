package com.google.common.cache;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.base.Splitter;
import com.google.common.cache.LocalCache;
import com.google.common.collect.ImmutableMap;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

@Beta
/* loaded from: classes.dex */
public final class CacheBuilderSpec {
    private static final Splitter m = Splitter.a(',').a();
    private static final Splitter n = Splitter.a('=').a();
    private static final ImmutableMap<String, Object> o = ImmutableMap.builder().b("initialCapacity", new d()).b("maximumSize", new h()).b("maximumWeight", new i()).b("concurrencyLevel", new b()).b("weakKeys", new f(LocalCache.Strength.WEAK)).b("softValues", new k(LocalCache.Strength.SOFT)).b("weakValues", new k(LocalCache.Strength.WEAK)).b("expireAfterAccess", new a()).b("expireAfterWrite", new l()).b("refreshAfterWrite", new j()).b("refreshInterval", new j()).b();

    /* renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    Integer f2599a;

    @VisibleForTesting
    Long b;

    @VisibleForTesting
    Long c;

    @VisibleForTesting
    Integer d;

    @VisibleForTesting
    LocalCache.Strength e;

    @VisibleForTesting
    LocalCache.Strength f;

    @VisibleForTesting
    long g;

    @VisibleForTesting
    TimeUnit h;

    @VisibleForTesting
    long i;

    @VisibleForTesting
    TimeUnit j;

    @VisibleForTesting
    long k;

    @VisibleForTesting
    TimeUnit l;
    private final String p;

    public String a() {
        return this.p;
    }

    public String toString() {
        return Objects.a(this).a((Object) a()).toString();
    }

    public int hashCode() {
        return Objects.a(this.f2599a, this.b, this.c, this.d, this.e, this.f, a(this.g, this.h), a(this.i, this.j), a(this.k, this.l));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CacheBuilderSpec)) {
            return false;
        }
        CacheBuilderSpec cacheBuilderSpec = (CacheBuilderSpec) obj;
        return Objects.a(this.f2599a, cacheBuilderSpec.f2599a) && Objects.a(this.b, cacheBuilderSpec.b) && Objects.a(this.c, cacheBuilderSpec.c) && Objects.a(this.d, cacheBuilderSpec.d) && Objects.a(this.e, cacheBuilderSpec.e) && Objects.a(this.f, cacheBuilderSpec.f) && Objects.a(a(this.g, this.h), a(cacheBuilderSpec.g, cacheBuilderSpec.h)) && Objects.a(a(this.i, this.j), a(cacheBuilderSpec.i, cacheBuilderSpec.j)) && Objects.a(a(this.k, this.l), a(cacheBuilderSpec.k, cacheBuilderSpec.l));
    }

    @Nullable
    private static Long a(long j2, @Nullable TimeUnit timeUnit) {
        if (timeUnit == null) {
            return null;
        }
        return Long.valueOf(timeUnit.toNanos(j2));
    }

    /* loaded from: classes2.dex */
    static abstract class e {
        e() {
        }
    }

    /* loaded from: classes2.dex */
    static abstract class g {
        g() {
        }
    }

    /* loaded from: classes2.dex */
    static class d extends e {
        d() {
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
    static class b extends e {
        b() {
        }
    }

    /* loaded from: classes2.dex */
    static class f {

        /* renamed from: a, reason: collision with root package name */
        private final LocalCache.Strength f2600a;

        public f(LocalCache.Strength strength) {
            this.f2600a = strength;
        }
    }

    /* loaded from: classes2.dex */
    static class k {

        /* renamed from: a, reason: collision with root package name */
        private final LocalCache.Strength f2601a;

        public k(LocalCache.Strength strength) {
            this.f2601a = strength;
        }
    }

    /* loaded from: classes2.dex */
    static abstract class c {
        c() {
        }
    }

    /* loaded from: classes2.dex */
    static class a extends c {
        a() {
        }
    }

    /* loaded from: classes2.dex */
    static class l extends c {
        l() {
        }
    }

    /* loaded from: classes2.dex */
    static class j extends c {
        j() {
        }
    }
}
