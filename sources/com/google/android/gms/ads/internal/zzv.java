package com.google.android.gms.ads.internal;

import android.content.Context;
import com.google.android.gms.internal.ads.zzark;
import com.google.android.gms.internal.ads.zzawm;
import com.google.android.gms.internal.ads.zzawn;
import com.google.android.gms.internal.ads.zzaws;
import com.google.android.gms.internal.ads.zzbdj;
import com.google.android.gms.internal.ads.zzbdr;
import com.google.android.gms.internal.ads.zzbfd;
import com.google.android.gms.internal.ads.zzbfr;
import com.google.android.gms.internal.ads.zzur;

@zzark
/* loaded from: classes.dex */
public final class zzv {

    /* renamed from: a, reason: collision with root package name */
    public final zzbfr f10264a;

    /* renamed from: b, reason: collision with root package name */
    public final zzbdj f10265b;

    /* renamed from: c, reason: collision with root package name */
    public final zzaws f10266c;

    /* renamed from: d, reason: collision with root package name */
    public final zzur f10267d;

    private zzv(zzbfr zzbfrVar, zzbdj zzbdjVar, zzaws zzawsVar, zzur zzurVar) {
        this.f10264a = zzbfrVar;
        this.f10265b = zzbdjVar;
        this.f10266c = zzawsVar;
        this.f10267d = zzurVar;
    }

    public static zzv a(Context context) {
        return new zzv(new zzbfd(), new zzbdr(), new zzawm(new zzawn()), new zzur(context));
    }
}
