package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.auth.api.signin.internal.HashAccumulator;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class GoogleSignInOptions extends AbstractSafeParcelable implements Api.ApiOptions.Optional, ReflectedParcelable {
    private final int i;
    private final ArrayList<Scope> j;
    private Account k;
    private boolean l;
    private final boolean m;
    private final boolean n;
    private String o;
    private String p;
    private ArrayList<GoogleSignInOptionsExtensionParcelable> q;
    private Map<Integer, GoogleSignInOptionsExtensionParcelable> r;

    /* renamed from: a */
    @VisibleForTesting
    public static final Scope f10560a = new Scope("profile");

    /* renamed from: b */
    @VisibleForTesting
    public static final Scope f10561b = new Scope(NotificationCompat.CATEGORY_EMAIL);

    /* renamed from: c */
    @VisibleForTesting
    public static final Scope f10562c = new Scope("openid");

    /* renamed from: d */
    @VisibleForTesting
    public static final Scope f10563d = new Scope("https://www.googleapis.com/auth/games_lite");

    /* renamed from: e */
    @VisibleForTesting
    public static final Scope f10564e = new Scope("https://www.googleapis.com/auth/games");

    /* renamed from: f */
    public static final GoogleSignInOptions f10565f = new Builder().c().d().a();

    /* renamed from: g */
    public static final GoogleSignInOptions f10566g = new Builder().a(f10563d, new Scope[0]).a();
    public static final Parcelable.Creator<GoogleSignInOptions> CREATOR = new zad();

    /* renamed from: h */
    private static Comparator<Scope> f10567h = new b();

    @SafeParcelable.Constructor
    public GoogleSignInOptions(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) ArrayList<Scope> arrayList, @SafeParcelable.Param(id = 3) Account account, @SafeParcelable.Param(id = 4) boolean z, @SafeParcelable.Param(id = 5) boolean z2, @SafeParcelable.Param(id = 6) boolean z3, @SafeParcelable.Param(id = 7) String str, @SafeParcelable.Param(id = 8) String str2, @SafeParcelable.Param(id = 9) ArrayList<GoogleSignInOptionsExtensionParcelable> arrayList2) {
        this(i, arrayList, account, z, z2, z3, str, str2, b(arrayList2));
    }

    private final JSONObject X() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            Collections.sort(this.j, f10567h);
            ArrayList<Scope> arrayList = this.j;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Scope scope = arrayList.get(i);
                i++;
                jSONArray.put(scope.a());
            }
            jSONObject.put("scopes", jSONArray);
            if (this.k != null) {
                jSONObject.put("accountName", this.k.name);
            }
            jSONObject.put("idTokenRequested", this.l);
            jSONObject.put("forceCodeForRefreshToken", this.n);
            jSONObject.put("serverAuthRequested", this.m);
            if (!TextUtils.isEmpty(this.o)) {
                jSONObject.put("serverClientId", this.o);
            }
            if (!TextUtils.isEmpty(this.p)) {
                jSONObject.put("hostedDomain", this.p);
            }
            return jSONObject;
        } catch (JSONException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static Map<Integer, GoogleSignInOptionsExtensionParcelable> b(List<GoogleSignInOptionsExtensionParcelable> list) {
        HashMap hashMap = new HashMap();
        if (list == null) {
            return hashMap;
        }
        for (GoogleSignInOptionsExtensionParcelable googleSignInOptionsExtensionParcelable : list) {
            hashMap.put(Integer.valueOf(googleSignInOptionsExtensionParcelable.a()), googleSignInOptionsExtensionParcelable);
        }
        return hashMap;
    }

    public static GoogleSignInOptions e(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("scopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(jSONArray.getString(i)));
        }
        String optString = jSONObject.optString("accountName", null);
        return new GoogleSignInOptions(3, (ArrayList<Scope>) new ArrayList(hashSet), !TextUtils.isEmpty(optString) ? new Account(optString, "com.google") : null, jSONObject.getBoolean("idTokenRequested"), jSONObject.getBoolean("serverAuthRequested"), jSONObject.getBoolean("forceCodeForRefreshToken"), jSONObject.optString("serverClientId", null), jSONObject.optString("hostedDomain", null), new HashMap());
    }

    @KeepForSdk
    public ArrayList<GoogleSignInOptionsExtensionParcelable> O() {
        return this.q;
    }

    @KeepForSdk
    public ArrayList<Scope> P() {
        return new ArrayList<>(this.j);
    }

    @KeepForSdk
    public String Q() {
        return this.o;
    }

    @KeepForSdk
    public boolean R() {
        return this.n;
    }

    @KeepForSdk
    public boolean U() {
        return this.l;
    }

    @KeepForSdk
    public boolean V() {
        return this.m;
    }

    public final String W() {
        return X().toString();
    }

    @KeepForSdk
    public Account a() {
        return this.k;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0069, code lost:            if (r3.o.equals(r4.Q()) != false) goto L70;     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x004a, code lost:            if (r3.k.equals(r4.a()) != false) goto L63;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r0 = 0
            if (r4 != 0) goto L4
            return r0
        L4:
            com.google.android.gms.auth.api.signin.GoogleSignInOptions r4 = (com.google.android.gms.auth.api.signin.GoogleSignInOptions) r4     // Catch: java.lang.ClassCastException -> L85
            java.util.ArrayList<com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable> r1 = r3.q     // Catch: java.lang.ClassCastException -> L85
            int r1 = r1.size()     // Catch: java.lang.ClassCastException -> L85
            if (r1 > 0) goto L85
            java.util.ArrayList<com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable> r1 = r4.q     // Catch: java.lang.ClassCastException -> L85
            int r1 = r1.size()     // Catch: java.lang.ClassCastException -> L85
            if (r1 <= 0) goto L18
            goto L85
        L18:
            java.util.ArrayList<com.google.android.gms.common.api.Scope> r1 = r3.j     // Catch: java.lang.ClassCastException -> L85
            int r1 = r1.size()     // Catch: java.lang.ClassCastException -> L85
            java.util.ArrayList r2 = r4.P()     // Catch: java.lang.ClassCastException -> L85
            int r2 = r2.size()     // Catch: java.lang.ClassCastException -> L85
            if (r1 != r2) goto L85
            java.util.ArrayList<com.google.android.gms.common.api.Scope> r1 = r3.j     // Catch: java.lang.ClassCastException -> L85
            java.util.ArrayList r2 = r4.P()     // Catch: java.lang.ClassCastException -> L85
            boolean r1 = r1.containsAll(r2)     // Catch: java.lang.ClassCastException -> L85
            if (r1 != 0) goto L35
            goto L85
        L35:
            android.accounts.Account r1 = r3.k     // Catch: java.lang.ClassCastException -> L85
            if (r1 != 0) goto L40
            android.accounts.Account r1 = r4.a()     // Catch: java.lang.ClassCastException -> L85
            if (r1 != 0) goto L85
            goto L4c
        L40:
            android.accounts.Account r1 = r3.k     // Catch: java.lang.ClassCastException -> L85
            android.accounts.Account r2 = r4.a()     // Catch: java.lang.ClassCastException -> L85
            boolean r1 = r1.equals(r2)     // Catch: java.lang.ClassCastException -> L85
            if (r1 == 0) goto L85
        L4c:
            java.lang.String r1 = r3.o     // Catch: java.lang.ClassCastException -> L85
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.ClassCastException -> L85
            if (r1 == 0) goto L5f
            java.lang.String r1 = r4.Q()     // Catch: java.lang.ClassCastException -> L85
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.ClassCastException -> L85
            if (r1 == 0) goto L85
            goto L6b
        L5f:
            java.lang.String r1 = r3.o     // Catch: java.lang.ClassCastException -> L85
            java.lang.String r2 = r4.Q()     // Catch: java.lang.ClassCastException -> L85
            boolean r1 = r1.equals(r2)     // Catch: java.lang.ClassCastException -> L85
            if (r1 == 0) goto L85
        L6b:
            boolean r1 = r3.n     // Catch: java.lang.ClassCastException -> L85
            boolean r2 = r4.R()     // Catch: java.lang.ClassCastException -> L85
            if (r1 != r2) goto L85
            boolean r1 = r3.l     // Catch: java.lang.ClassCastException -> L85
            boolean r2 = r4.U()     // Catch: java.lang.ClassCastException -> L85
            if (r1 != r2) goto L85
            boolean r1 = r3.m     // Catch: java.lang.ClassCastException -> L85
            boolean r4 = r4.V()     // Catch: java.lang.ClassCastException -> L85
            if (r1 != r4) goto L85
            r4 = 1
            return r4
        L85:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.signin.GoogleSignInOptions.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        ArrayList arrayList = new ArrayList();
        ArrayList<Scope> arrayList2 = this.j;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Scope scope = arrayList2.get(i);
            i++;
            arrayList.add(scope.a());
        }
        Collections.sort(arrayList);
        return new HashAccumulator().a(arrayList).a(this.k).a(this.o).a(this.n).a(this.l).a(this.m).a();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a(parcel, 1, this.i);
        SafeParcelWriter.d(parcel, 2, P(), false);
        SafeParcelWriter.a(parcel, 3, (Parcelable) a(), i, false);
        SafeParcelWriter.a(parcel, 4, U());
        SafeParcelWriter.a(parcel, 5, V());
        SafeParcelWriter.a(parcel, 6, R());
        SafeParcelWriter.a(parcel, 7, Q(), false);
        SafeParcelWriter.a(parcel, 8, this.p, false);
        SafeParcelWriter.d(parcel, 9, O(), false);
        SafeParcelWriter.a(parcel, a2);
    }

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a */
        private Set<Scope> f10568a;

        /* renamed from: b */
        private boolean f10569b;

        /* renamed from: c */
        private boolean f10570c;

        /* renamed from: d */
        private boolean f10571d;

        /* renamed from: e */
        private String f10572e;

        /* renamed from: f */
        private Account f10573f;

        /* renamed from: g */
        private String f10574g;

        /* renamed from: h */
        private Map<Integer, GoogleSignInOptionsExtensionParcelable> f10575h;

        public Builder() {
            this.f10568a = new HashSet();
            this.f10575h = new HashMap();
        }

        public final Builder a(Scope scope, Scope... scopeArr) {
            this.f10568a.add(scope);
            this.f10568a.addAll(Arrays.asList(scopeArr));
            return this;
        }

        public final Builder b() {
            this.f10568a.add(GoogleSignInOptions.f10561b);
            return this;
        }

        public final Builder c() {
            this.f10568a.add(GoogleSignInOptions.f10562c);
            return this;
        }

        public final Builder d() {
            this.f10568a.add(GoogleSignInOptions.f10560a);
            return this;
        }

        public final GoogleSignInOptions a() {
            if (this.f10568a.contains(GoogleSignInOptions.f10564e) && this.f10568a.contains(GoogleSignInOptions.f10563d)) {
                this.f10568a.remove(GoogleSignInOptions.f10563d);
            }
            if (this.f10571d && (this.f10573f == null || !this.f10568a.isEmpty())) {
                c();
            }
            return new GoogleSignInOptions(3, new ArrayList(this.f10568a), this.f10573f, this.f10571d, this.f10569b, this.f10570c, this.f10572e, this.f10574g, this.f10575h, null);
        }

        public Builder(GoogleSignInOptions googleSignInOptions) {
            this.f10568a = new HashSet();
            this.f10575h = new HashMap();
            Preconditions.a(googleSignInOptions);
            this.f10568a = new HashSet(googleSignInOptions.j);
            this.f10569b = googleSignInOptions.m;
            this.f10570c = googleSignInOptions.n;
            this.f10571d = googleSignInOptions.l;
            this.f10572e = googleSignInOptions.o;
            this.f10573f = googleSignInOptions.k;
            this.f10574g = googleSignInOptions.p;
            this.f10575h = GoogleSignInOptions.b(googleSignInOptions.q);
        }
    }

    private GoogleSignInOptions(int i, ArrayList<Scope> arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2, Map<Integer, GoogleSignInOptionsExtensionParcelable> map) {
        this.i = i;
        this.j = arrayList;
        this.k = account;
        this.l = z;
        this.m = z2;
        this.n = z3;
        this.o = str;
        this.p = str2;
        this.q = new ArrayList<>(map.values());
        this.r = map;
    }

    /* synthetic */ GoogleSignInOptions(int i, ArrayList arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2, Map map, b bVar) {
        this(3, (ArrayList<Scope>) arrayList, account, z, z2, z3, str, str2, (Map<Integer, GoogleSignInOptionsExtensionParcelable>) map);
    }
}
