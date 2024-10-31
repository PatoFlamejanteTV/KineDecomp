package com.google.android.gms.internal.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.search.SearchAdRequest;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@zzark
/* loaded from: classes2.dex */
public final class zzyx {
    private final boolean zzbli;
    private final int zzcjs;
    private final String zzcjt;
    private final int zzcjv;
    private final int zzcjy;
    private final String zzcjz;
    private final String zzckb;
    private final Bundle zzckd;
    private final String zzckf;
    private final boolean zzckh;
    private final Bundle zzclz;
    private final Map<Class<? extends NetworkExtras>, NetworkExtras> zzcma;
    private final SearchAdRequest zzcmb;
    private final Set<String> zzcmc;
    private final Set<String> zzcmd;
    private final zzbjc zzcme;
    private final Date zzih;
    private final Set<String> zzij;
    private final Location zzil;

    public zzyx(zzyy zzyyVar) {
        this(zzyyVar, null);
    }

    @Deprecated
    public final Date getBirthday() {
        return this.zzih;
    }

    public final String getContentUrl() {
        return this.zzckb;
    }

    public final Bundle getCustomEventExtrasBundle(Class<? extends CustomEvent> cls) {
        Bundle bundle = this.zzclz.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter");
        if (bundle != null) {
            return bundle.getBundle(cls.getName());
        }
        return null;
    }

    public final Bundle getCustomTargeting() {
        return this.zzckd;
    }

    @Deprecated
    public final int getGender() {
        return this.zzcjv;
    }

    public final Set<String> getKeywords() {
        return this.zzij;
    }

    public final Location getLocation() {
        return this.zzil;
    }

    public final boolean getManualImpressionsEnabled() {
        return this.zzbli;
    }

    @Deprecated
    public final <T extends NetworkExtras> T getNetworkExtras(Class<T> cls) {
        return (T) this.zzcma.get(cls);
    }

    public final Bundle getNetworkExtrasBundle(Class<? extends MediationAdapter> cls) {
        return this.zzclz.getBundle(cls.getName());
    }

    public final String getPublisherProvidedId() {
        return this.zzcjz;
    }

    @Deprecated
    public final boolean isDesignedForFamilies() {
        return this.zzckh;
    }

    public final boolean isTestDevice(Context context) {
        Set<String> set = this.zzcmc;
        zzwu.zzpv();
        return set.contains(zzbat.zzbf(context));
    }

    public final String zzqi() {
        return this.zzckf;
    }

    public final SearchAdRequest zzqj() {
        return this.zzcmb;
    }

    public final Map<Class<? extends NetworkExtras>, NetworkExtras> zzqk() {
        return this.zzcma;
    }

    public final Bundle zzql() {
        return this.zzclz;
    }

    public final int zzqm() {
        return this.zzcjy;
    }

    public final Set<String> zzqn() {
        return this.zzcmd;
    }

    public final int zzqo() {
        return this.zzcjs;
    }

    public final String zzqp() {
        return this.zzcjt;
    }

    public zzyx(zzyy zzyyVar, SearchAdRequest searchAdRequest) {
        Date date;
        String str;
        int i;
        HashSet hashSet;
        Location location;
        boolean z;
        Bundle bundle;
        HashMap hashMap;
        String str2;
        String str3;
        int i2;
        HashSet hashSet2;
        Bundle bundle2;
        HashSet hashSet3;
        boolean z2;
        int i3;
        String str4;
        date = zzyyVar.zzih;
        this.zzih = date;
        str = zzyyVar.zzckb;
        this.zzckb = str;
        i = zzyyVar.zzcjv;
        this.zzcjv = i;
        hashSet = zzyyVar.zzcmf;
        this.zzij = Collections.unmodifiableSet(hashSet);
        location = zzyyVar.zzil;
        this.zzil = location;
        z = zzyyVar.zzbli;
        this.zzbli = z;
        bundle = zzyyVar.zzclz;
        this.zzclz = bundle;
        hashMap = zzyyVar.zzcmg;
        this.zzcma = Collections.unmodifiableMap(hashMap);
        str2 = zzyyVar.zzcjz;
        this.zzcjz = str2;
        str3 = zzyyVar.zzckf;
        this.zzckf = str3;
        this.zzcmb = searchAdRequest;
        i2 = zzyyVar.zzcjy;
        this.zzcjy = i2;
        hashSet2 = zzyyVar.zzcmh;
        this.zzcmc = Collections.unmodifiableSet(hashSet2);
        bundle2 = zzyyVar.zzckd;
        this.zzckd = bundle2;
        hashSet3 = zzyyVar.zzcmi;
        this.zzcmd = Collections.unmodifiableSet(hashSet3);
        z2 = zzyyVar.zzckh;
        this.zzckh = z2;
        this.zzcme = null;
        i3 = zzyyVar.zzcjs;
        this.zzcjs = i3;
        str4 = zzyyVar.zzcjt;
        this.zzcjt = str4;
    }
}
