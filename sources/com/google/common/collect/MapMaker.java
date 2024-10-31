package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Ascii;
import com.google.common.base.Equivalence;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.MapMakerInternalMap;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes2.dex */
public final class MapMaker {

    /* renamed from: a, reason: collision with root package name */
    boolean f15539a;

    /* renamed from: b, reason: collision with root package name */
    int f15540b = -1;

    /* renamed from: c, reason: collision with root package name */
    int f15541c = -1;

    /* renamed from: d, reason: collision with root package name */
    MapMakerInternalMap.Strength f15542d;

    /* renamed from: e, reason: collision with root package name */
    MapMakerInternalMap.Strength f15543e;

    /* renamed from: f, reason: collision with root package name */
    Equivalence<Object> f15544f;

    /* JADX INFO: Access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    @GwtIncompatible
    public MapMaker a(Equivalence<Object> equivalence) {
        Preconditions.b(this.f15544f == null, "key equivalence was already set to %s", this.f15544f);
        Preconditions.a(equivalence);
        this.f15544f = equivalence;
        this.f15539a = true;
        return this;
    }

    @CanIgnoreReturnValue
    public MapMaker b(int i) {
        Preconditions.b(this.f15540b == -1, "initial capacity was already set to %s", this.f15540b);
        Preconditions.a(i >= 0);
        this.f15540b = i;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Equivalence<Object> c() {
        return (Equivalence) MoreObjects.a(this.f15544f, d().defaultEquivalence());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MapMakerInternalMap.Strength d() {
        return (MapMakerInternalMap.Strength) MoreObjects.a(this.f15542d, MapMakerInternalMap.Strength.STRONG);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MapMakerInternalMap.Strength e() {
        return (MapMakerInternalMap.Strength) MoreObjects.a(this.f15543e, MapMakerInternalMap.Strength.STRONG);
    }

    public <K, V> ConcurrentMap<K, V> f() {
        if (!this.f15539a) {
            return new ConcurrentHashMap(b(), 0.75f, a());
        }
        return MapMakerInternalMap.create(this);
    }

    @CanIgnoreReturnValue
    @GwtIncompatible
    public MapMaker g() {
        return a(MapMakerInternalMap.Strength.WEAK);
    }

    public String toString() {
        MoreObjects.ToStringHelper a2 = MoreObjects.a(this);
        int i = this.f15540b;
        if (i != -1) {
            a2.a("initialCapacity", i);
        }
        int i2 = this.f15541c;
        if (i2 != -1) {
            a2.a("concurrencyLevel", i2);
        }
        MapMakerInternalMap.Strength strength = this.f15542d;
        if (strength != null) {
            a2.a("keyStrength", Ascii.a(strength.toString()));
        }
        MapMakerInternalMap.Strength strength2 = this.f15543e;
        if (strength2 != null) {
            a2.a("valueStrength", Ascii.a(strength2.toString()));
        }
        if (this.f15544f != null) {
            a2.a("keyEquivalence");
        }
        return a2.toString();
    }

    @CanIgnoreReturnValue
    public MapMaker a(int i) {
        Preconditions.b(this.f15541c == -1, "concurrency level was already set to %s", this.f15541c);
        Preconditions.a(i > 0);
        this.f15541c = i;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        int i = this.f15540b;
        if (i == -1) {
            return 16;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MapMaker b(MapMakerInternalMap.Strength strength) {
        Preconditions.b(this.f15543e == null, "Value strength was already set to %s", this.f15543e);
        Preconditions.a(strength);
        this.f15543e = strength;
        if (strength != MapMakerInternalMap.Strength.STRONG) {
            this.f15539a = true;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        int i = this.f15541c;
        if (i == -1) {
            return 4;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MapMaker a(MapMakerInternalMap.Strength strength) {
        Preconditions.b(this.f15542d == null, "Key strength was already set to %s", this.f15542d);
        Preconditions.a(strength);
        this.f15542d = strength;
        if (strength != MapMakerInternalMap.Strength.STRONG) {
            this.f15539a = true;
        }
        return this;
    }
}
