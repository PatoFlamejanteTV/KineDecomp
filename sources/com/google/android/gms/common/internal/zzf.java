package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.view.View;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.zzqx;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class zzf {

    /* renamed from: a, reason: collision with root package name */
    private final Account f1005a;
    private final Set<Scope> b;
    private final Set<Scope> c;
    private final Map<Api<?>, zza> d;
    private final int e;
    private final View f;
    private final String g;
    private final String h;
    private final zzqx i;
    private Integer j;

    /* loaded from: classes.dex */
    public static final class zza {

        /* renamed from: a, reason: collision with root package name */
        public final Set<Scope> f1006a;
        public final boolean b;
    }

    public zzf(Account account, Set<Scope> set, Map<Api<?>, zza> map, int i, View view, String str, String str2, zzqx zzqxVar) {
        this.f1005a = account;
        this.b = set == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(set);
        this.d = map == null ? Collections.EMPTY_MAP : map;
        this.f = view;
        this.e = i;
        this.g = str;
        this.h = str2;
        this.i = zzqxVar;
        HashSet hashSet = new HashSet(this.b);
        Iterator<zza> it = this.d.values().iterator();
        while (it.hasNext()) {
            hashSet.addAll(it.next().f1006a);
        }
        this.c = Collections.unmodifiableSet(hashSet);
    }

    public static zzf a(Context context) {
        return new GoogleApiClient.Builder(context).a();
    }

    @Deprecated
    public String a() {
        if (this.f1005a != null) {
            return this.f1005a.name;
        }
        return null;
    }

    public Set<Scope> a(Api<?> api) {
        zza zzaVar = this.d.get(api);
        if (zzaVar == null || zzaVar.f1006a.isEmpty()) {
            return this.b;
        }
        HashSet hashSet = new HashSet(this.b);
        hashSet.addAll(zzaVar.f1006a);
        return hashSet;
    }

    public void a(Integer num) {
        this.j = num;
    }

    public Account b() {
        return this.f1005a;
    }

    public Account c() {
        return this.f1005a != null ? this.f1005a : new Account("<<default account>>", "com.google");
    }

    public int d() {
        return this.e;
    }

    public Set<Scope> e() {
        return this.b;
    }

    public Set<Scope> f() {
        return this.c;
    }

    public Map<Api<?>, zza> g() {
        return this.d;
    }

    public String h() {
        return this.g;
    }

    public String i() {
        return this.h;
    }

    public View j() {
        return this.f;
    }

    public zzqx k() {
        return this.i;
    }

    public Integer l() {
        return this.j;
    }
}
