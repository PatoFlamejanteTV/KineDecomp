package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.internal.Objects;

/* loaded from: classes.dex */
public final class zai<O extends Api.ApiOptions> {

    /* renamed from: a */
    private final boolean f10935a;

    /* renamed from: b */
    private final int f10936b;

    /* renamed from: c */
    private final Api<O> f10937c;

    /* renamed from: d */
    private final O f10938d;

    private zai(Api<O> api, O o) {
        this.f10935a = false;
        this.f10937c = api;
        this.f10938d = o;
        this.f10936b = Objects.a(this.f10937c, this.f10938d);
    }

    public static <O extends Api.ApiOptions> zai<O> a(Api<O> api, O o) {
        return new zai<>(api, o);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zai)) {
            return false;
        }
        zai zaiVar = (zai) obj;
        return !this.f10935a && !zaiVar.f10935a && Objects.a(this.f10937c, zaiVar.f10937c) && Objects.a(this.f10938d, zaiVar.f10938d);
    }

    public final int hashCode() {
        return this.f10936b;
    }

    public static <O extends Api.ApiOptions> zai<O> a(Api<O> api) {
        return new zai<>(api);
    }

    public final String a() {
        return this.f10937c.b();
    }

    private zai(Api<O> api) {
        this.f10935a = true;
        this.f10937c = api;
        this.f10938d = null;
        this.f10936b = System.identityHashCode(this);
    }
}
