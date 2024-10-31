package com.google.android.gms.ads.internal.client;

import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.internal.zzgr;
import java.util.ArrayList;
import java.util.List;

@zzgr
/* loaded from: classes.dex */
public final class zzf {

    /* renamed from: a, reason: collision with root package name */
    private long f541a;
    private Bundle b;
    private int c;
    private List<String> d;
    private boolean e;
    private int f;
    private boolean g;
    private String h;
    private SearchAdRequestParcel i;
    private Location j;
    private String k;
    private Bundle l;
    private Bundle m;
    private List<String> n;
    private String o;
    private String p;

    public zzf() {
        this.f541a = -1L;
        this.b = new Bundle();
        this.c = -1;
        this.d = new ArrayList();
        this.e = false;
        this.f = -1;
        this.g = false;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = new Bundle();
        this.m = new Bundle();
        this.n = new ArrayList();
        this.o = null;
        this.p = null;
    }

    public zzf(AdRequestParcel adRequestParcel) {
        this.f541a = adRequestParcel.b;
        this.b = adRequestParcel.c;
        this.c = adRequestParcel.d;
        this.d = adRequestParcel.e;
        this.e = adRequestParcel.f;
        this.f = adRequestParcel.g;
        this.g = adRequestParcel.h;
        this.h = adRequestParcel.i;
        this.i = adRequestParcel.j;
        this.j = adRequestParcel.k;
        this.k = adRequestParcel.l;
        this.l = adRequestParcel.m;
        this.m = adRequestParcel.n;
        this.n = adRequestParcel.o;
        this.o = adRequestParcel.p;
        this.p = adRequestParcel.q;
    }

    public AdRequestParcel a() {
        return new AdRequestParcel(6, this.f541a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p);
    }

    public zzf a(Location location) {
        this.j = location;
        return this;
    }
}
