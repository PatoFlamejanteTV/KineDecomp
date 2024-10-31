package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.internal.zzgr;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@zzgr
/* loaded from: classes.dex */
public final class zzy {

    /* renamed from: a, reason: collision with root package name */
    public static final String f557a = zzl.a().a("emulator");
    private final Date b;
    private final String c;
    private final int d;
    private final Set<String> e;
    private final Location f;
    private final boolean g;
    private final Bundle h;
    private final Map<Class<? extends NetworkExtras>, NetworkExtras> i;
    private final String j;
    private final String k;
    private final SearchAdRequest l;
    private final int m;
    private final Set<String> n;
    private final Bundle o;
    private final Set<String> p;

    /* loaded from: classes.dex */
    public static final class zza {
        private Date g;
        private String h;
        private Location j;
        private String l;
        private String m;

        /* renamed from: a, reason: collision with root package name */
        private final HashSet<String> f558a = new HashSet<>();
        private final Bundle b = new Bundle();
        private final HashMap<Class<? extends NetworkExtras>, NetworkExtras> c = new HashMap<>();
        private final HashSet<String> d = new HashSet<>();
        private final Bundle e = new Bundle();
        private final HashSet<String> f = new HashSet<>();
        private int i = -1;
        private boolean k = false;
        private int n = -1;

        public void a(int i) {
            this.i = i;
        }

        public void a(Location location) {
            this.j = location;
        }

        public void a(Class<? extends MediationAdapter> cls, Bundle bundle) {
            this.b.putBundle(cls.getName(), bundle);
        }

        public void a(String str) {
            this.f558a.add(str);
        }

        public void a(Date date) {
            this.g = date;
        }

        public void a(boolean z) {
            this.n = z ? 1 : 0;
        }

        public void b(String str) {
            this.d.add(str);
        }

        public void c(String str) {
            this.d.remove(str);
        }
    }

    public zzy(zza zzaVar) {
        this(zzaVar, null);
    }

    public zzy(zza zzaVar, SearchAdRequest searchAdRequest) {
        this.b = zzaVar.g;
        this.c = zzaVar.h;
        this.d = zzaVar.i;
        this.e = Collections.unmodifiableSet(zzaVar.f558a);
        this.f = zzaVar.j;
        this.g = zzaVar.k;
        this.h = zzaVar.b;
        this.i = Collections.unmodifiableMap(zzaVar.c);
        this.j = zzaVar.l;
        this.k = zzaVar.m;
        this.l = searchAdRequest;
        this.m = zzaVar.n;
        this.n = Collections.unmodifiableSet(zzaVar.d);
        this.o = zzaVar.e;
        this.p = Collections.unmodifiableSet(zzaVar.f);
    }

    public Bundle a(Class<? extends MediationAdapter> cls) {
        return this.h.getBundle(cls.getName());
    }

    public Date a() {
        return this.b;
    }

    public boolean a(Context context) {
        return this.n.contains(zzl.a().a(context));
    }

    public String b() {
        return this.c;
    }

    public int c() {
        return this.d;
    }

    public Set<String> d() {
        return this.e;
    }

    public Location e() {
        return this.f;
    }

    public boolean f() {
        return this.g;
    }

    public String g() {
        return this.j;
    }

    public String h() {
        return this.k;
    }

    public SearchAdRequest i() {
        return this.l;
    }

    public Map<Class<? extends NetworkExtras>, NetworkExtras> j() {
        return this.i;
    }

    public Bundle k() {
        return this.h;
    }

    public int l() {
        return this.m;
    }

    public Bundle m() {
        return this.o;
    }

    public Set<String> n() {
        return this.p;
    }
}
