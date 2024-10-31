package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.internal.zzgr;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

@zzgr
/* loaded from: classes.dex */
public class zzh {

    /* renamed from: a, reason: collision with root package name */
    public static final zzh f542a = new zzh();

    protected zzh() {
    }

    public static zzh a() {
        return f542a;
    }

    public AdRequestParcel a(Context context, zzy zzyVar) {
        Date a2 = zzyVar.a();
        long time = a2 != null ? a2.getTime() : -1L;
        String b = zzyVar.b();
        int c = zzyVar.c();
        Set<String> d = zzyVar.d();
        List unmodifiableList = !d.isEmpty() ? Collections.unmodifiableList(new ArrayList(d)) : null;
        boolean a3 = zzyVar.a(context);
        int l = zzyVar.l();
        Location e = zzyVar.e();
        Bundle a4 = zzyVar.a(AdMobAdapter.class);
        boolean f = zzyVar.f();
        String g = zzyVar.g();
        SearchAdRequest i = zzyVar.i();
        SearchAdRequestParcel searchAdRequestParcel = i != null ? new SearchAdRequestParcel(i) : null;
        Context applicationContext = context.getApplicationContext();
        return new AdRequestParcel(6, time, a4, c, unmodifiableList, a3, l, f, g, searchAdRequestParcel, e, b, zzyVar.k(), zzyVar.m(), Collections.unmodifiableList(new ArrayList(zzyVar.n())), zzyVar.h(), applicationContext != null ? com.google.android.gms.ads.internal.zzp.e().zza(Thread.currentThread().getStackTrace(), applicationContext.getPackageName()) : null);
    }
}
