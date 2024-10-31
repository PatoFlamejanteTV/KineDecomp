package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.google.android.gms.common.api.internal.GoogleServices;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.measurement.AppMeasurement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class zzda extends Aa {

    /* renamed from: c, reason: collision with root package name */
    @VisibleForTesting
    protected C1411da f14002c;

    /* renamed from: d, reason: collision with root package name */
    private zzcx f14003d;

    /* renamed from: e, reason: collision with root package name */
    private final Set<zzcy> f14004e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f14005f;

    /* renamed from: g, reason: collision with root package name */
    private final AtomicReference<String> f14006g;

    /* renamed from: h, reason: collision with root package name */
    @VisibleForTesting
    protected boolean f14007h;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzda(zzbw zzbwVar) {
        super(zzbwVar);
        this.f14004e = new CopyOnWriteArraySet();
        this.f14007h = true;
        this.f14006g = new AtomicReference<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D() {
        if (j().i(n().z()) && this.f13672a.c() && this.f14007h) {
            b().x().a("Recording app launch after enabling measurement for the first time (FE)");
            C();
        } else {
            b().x().a("Updating Scion state (FE)");
            o().C();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(boolean z) {
        c();
        d();
        t();
        b().x().a("Setting app measurement enabled (FE)", Boolean.valueOf(z));
        i().a(z);
        D();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        c();
        t();
        Preconditions.a(conditionalUserProperty);
        Preconditions.b(conditionalUserProperty.mName);
        if (!this.f13672a.c()) {
            b().x().a("Conditional property not cleared since collection is disabled");
            return;
        }
        try {
            o().a(new zzo(conditionalUserProperty.mAppId, conditionalUserProperty.mOrigin, new zzfv(conditionalUserProperty.mName, 0L, null, null), conditionalUserProperty.mCreationTimestamp, conditionalUserProperty.mActive, conditionalUserProperty.mTriggerEventName, null, conditionalUserProperty.mTriggerTimeout, null, conditionalUserProperty.mTimeToLive, h().a(conditionalUserProperty.mAppId, conditionalUserProperty.mExpiredEventName, conditionalUserProperty.mExpiredEventParams, conditionalUserProperty.mOrigin, conditionalUserProperty.mCreationTimestamp, true, false)));
        } catch (IllegalArgumentException unused) {
        }
    }

    public final String A() {
        if (this.f13672a.x() != null) {
            return this.f13672a.x();
        }
        try {
            return GoogleServices.a();
        } catch (IllegalStateException e2) {
            this.f13672a.b().q().a("getGoogleAppId failed with exception", e2);
            return null;
        }
    }

    public final String B() {
        d();
        return this.f14006g.get();
    }

    public final void C() {
        c();
        d();
        t();
        if (this.f13672a.E()) {
            o().B();
            this.f14007h = false;
            String v = i().v();
            if (TextUtils.isEmpty(v)) {
                return;
            }
            f().l();
            if (v.equals(Build.VERSION.RELEASE)) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("_po", v);
            b("auto", "_ou", bundle);
        }
    }

    public final void a(boolean z) {
        t();
        d();
        zzgs().a(new RunnableC1407ba(this, z));
    }

    public final void b(boolean z) {
        t();
        d();
        zzgs().a(new RunnableC1409ca(this, z));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c(String str, String str2, Bundle bundle) {
        d();
        c();
        a(str, str2, a().a(), bundle);
    }

    @Override // com.google.android.gms.measurement.internal.O
    public final /* bridge */ /* synthetic */ zzaa f() {
        return super.f();
    }

    @Override // com.google.android.gms.measurement.internal.O
    public final /* bridge */ /* synthetic */ zzaq g() {
        return super.g();
    }

    @Override // com.google.android.gms.measurement.internal.O, com.google.android.gms.measurement.internal.Q
    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    @Override // com.google.android.gms.measurement.internal.O
    public final /* bridge */ /* synthetic */ zzfy h() {
        return super.h();
    }

    @Override // com.google.android.gms.measurement.internal.O
    public final /* bridge */ /* synthetic */ C1428m i() {
        return super.i();
    }

    @Override // com.google.android.gms.measurement.internal.O
    public final /* bridge */ /* synthetic */ zzq j() {
        return super.j();
    }

    @Override // com.google.android.gms.measurement.internal.C1417ga
    public final /* bridge */ /* synthetic */ void k() {
        super.k();
    }

    @Override // com.google.android.gms.measurement.internal.C1417ga
    public final /* bridge */ /* synthetic */ zzam n() {
        return super.n();
    }

    @Override // com.google.android.gms.measurement.internal.C1417ga
    public final /* bridge */ /* synthetic */ zzeb o() {
        return super.o();
    }

    @Override // com.google.android.gms.measurement.internal.C1417ga
    public final /* bridge */ /* synthetic */ zzdy p() {
        return super.p();
    }

    @Override // com.google.android.gms.measurement.internal.C1417ga
    public final /* bridge */ /* synthetic */ zzfd r() {
        return super.r();
    }

    @Override // com.google.android.gms.measurement.internal.Aa
    protected final boolean v() {
        return false;
    }

    public final String y() {
        zzdx z = this.f13672a.k().z();
        if (z != null) {
            return z.f14009b;
        }
        return null;
    }

    public final String z() {
        zzdx z = this.f13672a.k().z();
        if (z != null) {
            return z.f14008a;
        }
        return null;
    }

    @Override // com.google.android.gms.measurement.internal.O, com.google.android.gms.measurement.internal.Q
    public final /* bridge */ /* synthetic */ zzbr zzgs() {
        return super.zzgs();
    }

    @Override // com.google.android.gms.measurement.internal.O, com.google.android.gms.measurement.internal.Q
    public final /* bridge */ /* synthetic */ zzn zzgw() {
        return super.zzgw();
    }

    public final List<zzfv> c(boolean z) {
        d();
        t();
        b().x().a("Fetching user attributes (FE)");
        if (zzgs().q()) {
            b().q().a("Cannot get all user properties from analytics worker thread");
            return Collections.emptyList();
        }
        if (zzn.a()) {
            b().q().a("Cannot get all user properties from main thread");
            return Collections.emptyList();
        }
        AtomicReference atomicReference = new AtomicReference();
        synchronized (atomicReference) {
            this.f13672a.zzgs().a(new W(this, atomicReference, z));
            try {
                atomicReference.wait(5000L);
            } catch (InterruptedException e2) {
                b().t().a("Interrupted waiting for get user properties", e2);
            }
        }
        List<zzfv> list = (List) atomicReference.get();
        if (list != null) {
            return list;
        }
        b().t().a("Timed out waiting for get user properties");
        return Collections.emptyList();
    }

    public final void a(String str, String str2, Bundle bundle, boolean z) {
        a(str, str2, bundle, false, true, a().a());
    }

    public final void b(String str, String str2, Bundle bundle) {
        a(str, str2, bundle, true, true, a().a());
    }

    private final void b(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        zzgs().a(new U(this, str, str2, j, zzfy.b(bundle), z, z2, z3, str3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(String str, String str2, long j, Bundle bundle) {
        d();
        c();
        a(str, str2, j, bundle, true, this.f14003d == null || zzfy.d(str2), false, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        c();
        t();
        Preconditions.a(conditionalUserProperty);
        Preconditions.b(conditionalUserProperty.mName);
        Preconditions.b(conditionalUserProperty.mOrigin);
        Preconditions.a(conditionalUserProperty.mValue);
        if (!this.f13672a.c()) {
            b().x().a("Conditional property not sent since collection is disabled");
            return;
        }
        zzfv zzfvVar = new zzfv(conditionalUserProperty.mName, conditionalUserProperty.mTriggeredTimestamp, conditionalUserProperty.mValue, conditionalUserProperty.mOrigin);
        try {
            zzag a2 = h().a(conditionalUserProperty.mAppId, conditionalUserProperty.mTriggeredEventName, conditionalUserProperty.mTriggeredEventParams, conditionalUserProperty.mOrigin, 0L, true, false);
            o().a(new zzo(conditionalUserProperty.mAppId, conditionalUserProperty.mOrigin, zzfvVar, conditionalUserProperty.mCreationTimestamp, false, conditionalUserProperty.mTriggerEventName, h().a(conditionalUserProperty.mAppId, conditionalUserProperty.mTimedOutEventName, conditionalUserProperty.mTimedOutEventParams, conditionalUserProperty.mOrigin, 0L, true, false), conditionalUserProperty.mTriggerTimeout, a2, conditionalUserProperty.mTimeToLive, h().a(conditionalUserProperty.mAppId, conditionalUserProperty.mExpiredEventName, conditionalUserProperty.mExpiredEventParams, conditionalUserProperty.mOrigin, 0L, true, false)));
        } catch (IllegalArgumentException unused) {
        }
    }

    public final void b(AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        Preconditions.a(conditionalUserProperty);
        Preconditions.b(conditionalUserProperty.mAppId);
        k();
        c(new AppMeasurement.ConditionalUserProperty(conditionalUserProperty));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(java.lang.String r31, java.lang.String r32, long r33, android.os.Bundle r35, boolean r36, boolean r37, boolean r38, java.lang.String r39) {
        /*
            Method dump skipped, instructions count: 1070
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzda.a(java.lang.String, java.lang.String, long, android.os.Bundle, boolean, boolean, boolean, java.lang.String):void");
    }

    private final void b(String str, String str2, String str3, Bundle bundle) {
        long a2 = a().a();
        Preconditions.b(str2);
        AppMeasurement.ConditionalUserProperty conditionalUserProperty = new AppMeasurement.ConditionalUserProperty();
        conditionalUserProperty.mAppId = str;
        conditionalUserProperty.mName = str2;
        conditionalUserProperty.mCreationTimestamp = a2;
        if (str3 != null) {
            conditionalUserProperty.mExpiredEventName = str3;
            conditionalUserProperty.mExpiredEventParams = bundle;
        }
        zzgs().a(new Y(this, conditionalUserProperty));
    }

    public final List<AppMeasurement.ConditionalUserProperty> b(String str, String str2) {
        d();
        return b((String) null, str, str2);
    }

    @Override // com.google.android.gms.measurement.internal.C1417ga, com.google.android.gms.measurement.internal.O
    public final /* bridge */ /* synthetic */ void d() {
        super.d();
    }

    @VisibleForTesting
    private final List<AppMeasurement.ConditionalUserProperty> b(String str, String str2, String str3) {
        if (zzgs().q()) {
            b().q().a("Cannot get conditional user properties from analytics worker thread");
            return Collections.emptyList();
        }
        if (zzn.a()) {
            b().q().a("Cannot get conditional user properties from main thread");
            return Collections.emptyList();
        }
        AtomicReference atomicReference = new AtomicReference();
        synchronized (atomicReference) {
            this.f13672a.zzgs().a(new Z(this, atomicReference, str, str2, str3));
            try {
                atomicReference.wait(5000L);
            } catch (InterruptedException e2) {
                b().t().a("Interrupted waiting for get conditional user properties", str, e2);
            }
        }
        List<zzo> list = (List) atomicReference.get();
        if (list == null) {
            b().t().a("Timed out waiting for get conditional user properties", str);
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (zzo zzoVar : list) {
            AppMeasurement.ConditionalUserProperty conditionalUserProperty = new AppMeasurement.ConditionalUserProperty();
            conditionalUserProperty.mAppId = zzoVar.f14073a;
            conditionalUserProperty.mOrigin = zzoVar.f14074b;
            conditionalUserProperty.mCreationTimestamp = zzoVar.f14076d;
            zzfv zzfvVar = zzoVar.f14075c;
            conditionalUserProperty.mName = zzfvVar.f14052b;
            conditionalUserProperty.mValue = zzfvVar.getValue();
            conditionalUserProperty.mActive = zzoVar.f14077e;
            conditionalUserProperty.mTriggerEventName = zzoVar.f14078f;
            zzag zzagVar = zzoVar.f14079g;
            if (zzagVar != null) {
                conditionalUserProperty.mTimedOutEventName = zzagVar.f13897a;
                zzad zzadVar = zzagVar.f13898b;
                if (zzadVar != null) {
                    conditionalUserProperty.mTimedOutEventParams = zzadVar.a();
                }
            }
            conditionalUserProperty.mTriggerTimeout = zzoVar.f14080h;
            zzag zzagVar2 = zzoVar.i;
            if (zzagVar2 != null) {
                conditionalUserProperty.mTriggeredEventName = zzagVar2.f13897a;
                zzad zzadVar2 = zzagVar2.f13898b;
                if (zzadVar2 != null) {
                    conditionalUserProperty.mTriggeredEventParams = zzadVar2.a();
                }
            }
            conditionalUserProperty.mTriggeredTimestamp = zzoVar.f14075c.f14053c;
            conditionalUserProperty.mTimeToLive = zzoVar.j;
            zzag zzagVar3 = zzoVar.k;
            if (zzagVar3 != null) {
                conditionalUserProperty.mExpiredEventName = zzagVar3.f13897a;
                zzad zzadVar3 = zzagVar3.f13898b;
                if (zzadVar3 != null) {
                    conditionalUserProperty.mExpiredEventParams = zzadVar3.a();
                }
            }
            arrayList.add(conditionalUserProperty);
        }
        return arrayList;
    }

    private final void c(AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        long a2 = a().a();
        Preconditions.a(conditionalUserProperty);
        Preconditions.b(conditionalUserProperty.mName);
        Preconditions.b(conditionalUserProperty.mOrigin);
        Preconditions.a(conditionalUserProperty.mValue);
        conditionalUserProperty.mCreationTimestamp = a2;
        String str = conditionalUserProperty.mName;
        Object obj = conditionalUserProperty.mValue;
        if (h().c(str) != 0) {
            b().q().a("Invalid conditional user property name", g().c(str));
            return;
        }
        if (h().b(str, obj) != 0) {
            b().q().a("Invalid conditional user property value", g().c(str), obj);
            return;
        }
        Object c2 = h().c(str, obj);
        if (c2 == null) {
            b().q().a("Unable to normalize conditional user property value", g().c(str), obj);
            return;
        }
        conditionalUserProperty.mValue = c2;
        long j = conditionalUserProperty.mTriggerTimeout;
        if (!TextUtils.isEmpty(conditionalUserProperty.mTriggerEventName) && (j > 15552000000L || j < 1)) {
            b().q().a("Invalid conditional user property timeout", g().c(str), Long.valueOf(j));
            return;
        }
        long j2 = conditionalUserProperty.mTimeToLive;
        if (j2 <= 15552000000L && j2 >= 1) {
            zzgs().a(new X(this, conditionalUserProperty));
        } else {
            b().q().a("Invalid conditional user property time to live", g().c(str), Long.valueOf(j2));
        }
    }

    @Override // com.google.android.gms.measurement.internal.C1417ga, com.google.android.gms.measurement.internal.O
    public final /* bridge */ /* synthetic */ void c() {
        super.c();
    }

    @VisibleForTesting
    private final Map<String, Object> b(String str, String str2, String str3, boolean z) {
        if (zzgs().q()) {
            b().q().a("Cannot get user properties from analytics worker thread");
            return Collections.emptyMap();
        }
        if (zzn.a()) {
            b().q().a("Cannot get user properties from main thread");
            return Collections.emptyMap();
        }
        AtomicReference atomicReference = new AtomicReference();
        synchronized (atomicReference) {
            this.f13672a.zzgs().a(new RunnableC1405aa(this, atomicReference, str, str2, str3, z));
            try {
                atomicReference.wait(5000L);
            } catch (InterruptedException e2) {
                b().t().a("Interrupted waiting for get user properties", e2);
            }
        }
        List<zzfv> list = (List) atomicReference.get();
        if (list == null) {
            b().t().a("Timed out waiting for get user properties");
            return Collections.emptyMap();
        }
        ArrayMap arrayMap = new ArrayMap(list.size());
        for (zzfv zzfvVar : list) {
            arrayMap.put(zzfvVar.f14052b, zzfvVar.getValue());
        }
        return arrayMap;
    }

    @Override // com.google.android.gms.measurement.internal.O, com.google.android.gms.measurement.internal.Q
    public final /* bridge */ /* synthetic */ zzas b() {
        return super.b();
    }

    public final void a(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) {
        boolean z3;
        d();
        String str3 = str == null ? "app" : str;
        Bundle bundle2 = bundle == null ? new Bundle() : bundle;
        if (z2 && this.f14003d != null && !zzfy.d(str2)) {
            z3 = false;
            b(str3, str2, j, bundle2, z2, z3, !z, null);
        }
        z3 = true;
        b(str3, str2, j, bundle2, z2, z3, !z, null);
    }

    public final void a(String str, String str2, Object obj, boolean z) {
        a(str, str2, obj, z, a().a());
    }

    public final void a(String str, String str2, Object obj, boolean z, long j) {
        if (str == null) {
            str = "app";
        }
        String str3 = str;
        int i = 6;
        if (z) {
            i = h().c(str2);
        } else {
            zzfy h2 = h();
            if (h2.b("user property", str2)) {
                if (!h2.a("user property", zzcw.f13993a, str2)) {
                    i = 15;
                } else if (h2.a("user property", 24, str2)) {
                    i = 0;
                }
            }
        }
        if (i != 0) {
            h();
            this.f13672a.p().a(i, "_ev", zzfy.a(str2, 24, true), str2 != null ? str2.length() : 0);
            return;
        }
        if (obj != null) {
            int b2 = h().b(str2, obj);
            if (b2 != 0) {
                h();
                this.f13672a.p().a(b2, "_ev", zzfy.a(str2, 24, true), ((obj instanceof String) || (obj instanceof CharSequence)) ? String.valueOf(obj).length() : 0);
                return;
            } else {
                Object c2 = h().c(str2, obj);
                if (c2 != null) {
                    a(str3, str2, j, c2);
                    return;
                }
                return;
            }
        }
        a(str3, str2, j, (Object) null);
    }

    private final void a(String str, String str2, long j, Object obj) {
        zzgs().a(new V(this, str, str2, obj, j));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(String str, String str2, Object obj, long j) {
        Preconditions.b(str);
        Preconditions.b(str2);
        c();
        d();
        t();
        if (!this.f13672a.c()) {
            b().x().a("User property not set since app measurement is disabled");
        } else if (this.f13672a.E()) {
            b().x().a("Setting user property (FE)", g().a(str2), obj);
            o().a(new zzfv(str2, j, obj, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(String str) {
        this.f14006g.set(str);
    }

    public final void a(zzcy zzcyVar) {
        d();
        t();
        Preconditions.a(zzcyVar);
        if (this.f14004e.add(zzcyVar)) {
            return;
        }
        b().t().a("OnEventListener already registered");
    }

    public final void a(AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        Preconditions.a(conditionalUserProperty);
        d();
        AppMeasurement.ConditionalUserProperty conditionalUserProperty2 = new AppMeasurement.ConditionalUserProperty(conditionalUserProperty);
        if (!TextUtils.isEmpty(conditionalUserProperty2.mAppId)) {
            b().t().a("Package name should be null when calling setConditionalUserProperty");
        }
        conditionalUserProperty2.mAppId = null;
        c(conditionalUserProperty2);
    }

    public final void a(String str, String str2, Bundle bundle) {
        d();
        b((String) null, str, str2, bundle);
    }

    public final void a(String str, String str2, String str3, Bundle bundle) {
        Preconditions.b(str);
        k();
        b(str, str2, str3, bundle);
    }

    public final List<AppMeasurement.ConditionalUserProperty> a(String str, String str2, String str3) {
        Preconditions.b(str);
        k();
        return b(str, str2, str3);
    }

    public final Map<String, Object> a(String str, String str2, boolean z) {
        d();
        return b((String) null, str, str2, z);
    }

    public final Map<String, Object> a(String str, String str2, String str3, boolean z) {
        Preconditions.b(str);
        k();
        return b(str, str2, str3, z);
    }

    @Override // com.google.android.gms.measurement.internal.O, com.google.android.gms.measurement.internal.Q
    public final /* bridge */ /* synthetic */ Clock a() {
        return super.a();
    }
}
