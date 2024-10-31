package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.support.v4.util.ArraySet;
import android.view.View;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.signin.SignInOptions;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@VisibleForTesting
@KeepForSdk
/* loaded from: classes.dex */
public final class ClientSettings {

    /* renamed from: a */
    private final Account f11064a;

    /* renamed from: b */
    private final Set<Scope> f11065b;

    /* renamed from: c */
    private final Set<Scope> f11066c;

    /* renamed from: d */
    private final Map<Api<?>, OptionalApiSettings> f11067d;

    /* renamed from: e */
    private final int f11068e;

    /* renamed from: f */
    private final View f11069f;

    /* renamed from: g */
    private final String f11070g;

    /* renamed from: h */
    private final String f11071h;
    private final SignInOptions i;
    private final boolean j;
    private Integer k;

    @KeepForSdk
    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a */
        private Account f11072a;

        /* renamed from: b */
        private ArraySet<Scope> f11073b;

        /* renamed from: c */
        private Map<Api<?>, OptionalApiSettings> f11074c;

        /* renamed from: e */
        private View f11076e;

        /* renamed from: f */
        private String f11077f;

        /* renamed from: g */
        private String f11078g;
        private boolean i;

        /* renamed from: d */
        private int f11075d = 0;

        /* renamed from: h */
        private SignInOptions f11079h = SignInOptions.f14122a;

        public final Builder a(Account account) {
            this.f11072a = account;
            return this;
        }

        @KeepForSdk
        public final Builder b(String str) {
            this.f11077f = str;
            return this;
        }

        public final Builder a(Collection<Scope> collection) {
            if (this.f11073b == null) {
                this.f11073b = new ArraySet<>();
            }
            this.f11073b.addAll(collection);
            return this;
        }

        public final Builder a(String str) {
            this.f11078g = str;
            return this;
        }

        @KeepForSdk
        public final ClientSettings a() {
            return new ClientSettings(this.f11072a, this.f11073b, this.f11074c, this.f11075d, this.f11076e, this.f11077f, this.f11078g, this.f11079h, this.i);
        }
    }

    /* loaded from: classes.dex */
    public static final class OptionalApiSettings {

        /* renamed from: a */
        public final Set<Scope> f11080a;
    }

    public ClientSettings(Account account, Set<Scope> set, Map<Api<?>, OptionalApiSettings> map, int i, View view, String str, String str2, SignInOptions signInOptions, boolean z) {
        this.f11064a = account;
        this.f11065b = set == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(set);
        this.f11067d = map == null ? Collections.EMPTY_MAP : map;
        this.f11069f = view;
        this.f11068e = i;
        this.f11070g = str;
        this.f11071h = str2;
        this.i = signInOptions;
        this.j = z;
        HashSet hashSet = new HashSet(this.f11065b);
        Iterator<OptionalApiSettings> it = this.f11067d.values().iterator();
        while (it.hasNext()) {
            hashSet.addAll(it.next().f11080a);
        }
        this.f11066c = Collections.unmodifiableSet(hashSet);
    }

    @KeepForSdk
    @Nullable
    public final Account a() {
        return this.f11064a;
    }

    @KeepForSdk
    @Nullable
    @Deprecated
    public final String b() {
        Account account = this.f11064a;
        if (account != null) {
            return account.name;
        }
        return null;
    }

    @KeepForSdk
    public final Account c() {
        Account account = this.f11064a;
        return account != null ? account : new Account(BaseGmsClient.DEFAULT_ACCOUNT, "com.google");
    }

    @KeepForSdk
    public final Set<Scope> d() {
        return this.f11066c;
    }

    @Nullable
    public final Integer e() {
        return this.k;
    }

    public final Map<Api<?>, OptionalApiSettings> f() {
        return this.f11067d;
    }

    @Nullable
    public final String g() {
        return this.f11071h;
    }

    @KeepForSdk
    @Nullable
    public final String h() {
        return this.f11070g;
    }

    @KeepForSdk
    public final Set<Scope> i() {
        return this.f11065b;
    }

    @Nullable
    public final SignInOptions j() {
        return this.i;
    }

    public final boolean k() {
        return this.j;
    }

    public final void a(Integer num) {
        this.k = num;
    }

    @KeepForSdk
    public final Set<Scope> a(Api<?> api) {
        OptionalApiSettings optionalApiSettings = this.f11067d.get(api);
        if (optionalApiSettings != null && !optionalApiSettings.f11080a.isEmpty()) {
            HashSet hashSet = new HashSet(this.f11065b);
            hashSet.addAll(optionalApiSettings.f11080a);
            return hashSet;
        }
        return this.f11065b;
    }
}
