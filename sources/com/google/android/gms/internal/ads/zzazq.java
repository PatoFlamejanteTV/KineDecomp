package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.Objects;

/* loaded from: classes2.dex */
public final class zzazq {
    public final int count;
    public final String name;
    private final double zzemq;
    private final double zzemr;
    public final double zzems;

    public zzazq(String str, double d2, double d3, double d4, int i) {
        this.name = str;
        this.zzemr = d2;
        this.zzemq = d3;
        this.zzems = d4;
        this.count = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzazq)) {
            return false;
        }
        zzazq zzazqVar = (zzazq) obj;
        return Objects.a(this.name, zzazqVar.name) && this.zzemq == zzazqVar.zzemq && this.zzemr == zzazqVar.zzemr && this.count == zzazqVar.count && Double.compare(this.zzems, zzazqVar.zzems) == 0;
    }

    public final int hashCode() {
        return Objects.a(this.name, Double.valueOf(this.zzemq), Double.valueOf(this.zzemr), Double.valueOf(this.zzems), Integer.valueOf(this.count));
    }

    public final String toString() {
        return Objects.a(this).a("name", this.name).a("minBound", Double.valueOf(this.zzemr)).a("maxBound", Double.valueOf(this.zzemq)).a("percent", Double.valueOf(this.zzems)).a("count", Integer.valueOf(this.count)).toString();
    }
}
