package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class _b implements zzbbm<List<zzabr>, zzabm> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f12023a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ Integer f12024b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ Integer f12025c;

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ int f12026d;

    /* renamed from: e, reason: collision with root package name */
    private final /* synthetic */ int f12027e;

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ int f12028f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ int f12029g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ boolean f12030h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public _b(zzapw zzapwVar, String str, Integer num, Integer num2, int i, int i2, int i3, int i4, boolean z) {
        this.f12023a = str;
        this.f12024b = num;
        this.f12025c = num2;
        this.f12026d = i;
        this.f12027e = i2;
        this.f12028f = i3;
        this.f12029g = i4;
        this.f12030h = z;
    }

    @Override // com.google.android.gms.internal.ads.zzbbm
    public final /* synthetic */ zzabm apply(List<zzabr> list) {
        List<zzabr> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return null;
        }
        String str = this.f12023a;
        Integer num = this.f12024b;
        Integer num2 = this.f12025c;
        int i = this.f12026d;
        return new zzabm(str, list2, num, num2, i > 0 ? Integer.valueOf(i) : null, this.f12027e + this.f12028f, this.f12029g, this.f12030h);
    }
}
