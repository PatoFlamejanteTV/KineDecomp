package com.google.ads.mediation;

import android.location.Location;
import com.google.ads.AdRequest;
import java.util.Date;
import java.util.Set;

@Deprecated
/* loaded from: classes.dex */
public class MediationAdRequest {

    /* renamed from: a */
    private final Date f9906a;

    /* renamed from: b */
    private final AdRequest.Gender f9907b;

    /* renamed from: c */
    private final Set<String> f9908c;

    /* renamed from: d */
    private final boolean f9909d;

    /* renamed from: e */
    private final Location f9910e;

    public MediationAdRequest(Date date, AdRequest.Gender gender, Set<String> set, boolean z, Location location) {
        this.f9906a = date;
        this.f9907b = gender;
        this.f9908c = set;
        this.f9909d = z;
        this.f9910e = location;
    }
}
