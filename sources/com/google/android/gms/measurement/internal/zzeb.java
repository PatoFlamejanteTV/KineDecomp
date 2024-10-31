package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@VisibleForTesting
/* loaded from: classes2.dex */
public final class zzeb extends Aa {

    /* renamed from: c, reason: collision with root package name */
    private final zzes f14018c;

    /* renamed from: d, reason: collision with root package name */
    private zzaj f14019d;

    /* renamed from: e, reason: collision with root package name */
    private volatile Boolean f14020e;

    /* renamed from: f, reason: collision with root package name */
    private final _a f14021f;

    /* renamed from: g, reason: collision with root package name */
    private final Ia f14022g;

    /* renamed from: h, reason: collision with root package name */
    private final List<Runnable> f14023h;
    private final _a i;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzeb(zzbw zzbwVar) {
        super(zzbwVar);
        this.f14023h = new ArrayList();
        this.f14022g = new Ia(zzbwVar.a());
        this.f14018c = new zzes(this);
        this.f14021f = new C1421ia(this, zzbwVar);
        this.i = new C1431na(this, zzbwVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E() {
        c();
        this.f14022g.b();
        this.f14021f.a(zzai.U.a().longValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F() {
        c();
        if (z()) {
            b().y().a("Inactivity, disconnecting from the service");
            y();
        }
    }

    private final boolean G() {
        zzgw();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H() {
        c();
        b().y().a("Processing queued up service tasks", Integer.valueOf(this.f14023h.size()));
        Iterator<Runnable> it = this.f14023h.iterator();
        while (it.hasNext()) {
            try {
                it.next().run();
            } catch (Exception e2) {
                b().q().a("Task exception while flushing queue", e2);
            }
        }
        this.f14023h.clear();
        this.i.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x010d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A() {
        /*
            Method dump skipped, instructions count: 391
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzeb.A():void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void B() {
        c();
        t();
        a(new RunnableC1427la(this, a(true)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void C() {
        c();
        t();
        a(new RunnableC1433oa(this, a(true)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Boolean D() {
        return this.f14020e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final void a(zzaj zzajVar, AbstractSafeParcelable abstractSafeParcelable, zzk zzkVar) {
        int i;
        List<AbstractSafeParcelable> a2;
        c();
        d();
        t();
        boolean G = G();
        int i2 = 0;
        int i3 = 100;
        while (i2 < 1001 && i3 == 100) {
            ArrayList arrayList = new ArrayList();
            if (!G || (a2 = q().a(100)) == null) {
                i = 0;
            } else {
                arrayList.addAll(a2);
                i = a2.size();
            }
            if (abstractSafeParcelable != null && i < 100) {
                arrayList.add(abstractSafeParcelable);
            }
            int size = arrayList.size();
            int i4 = 0;
            while (i4 < size) {
                Object obj = arrayList.get(i4);
                i4++;
                AbstractSafeParcelable abstractSafeParcelable2 = (AbstractSafeParcelable) obj;
                if (abstractSafeParcelable2 instanceof zzag) {
                    try {
                        zzajVar.a((zzag) abstractSafeParcelable2, zzkVar);
                    } catch (RemoteException e2) {
                        b().q().a("Failed to send event to the service", e2);
                    }
                } else if (abstractSafeParcelable2 instanceof zzfv) {
                    try {
                        zzajVar.a((zzfv) abstractSafeParcelable2, zzkVar);
                    } catch (RemoteException e3) {
                        b().q().a("Failed to send attribute to the service", e3);
                    }
                } else if (abstractSafeParcelable2 instanceof zzo) {
                    try {
                        zzajVar.a((zzo) abstractSafeParcelable2, zzkVar);
                    } catch (RemoteException e4) {
                        b().q().a("Failed to send conditional property to the service", e4);
                    }
                } else {
                    b().q().a("Discarding data. Unrecognized parcel type.");
                }
            }
            i2++;
            i3 = i;
        }
    }

    @Override // com.google.android.gms.measurement.internal.O, com.google.android.gms.measurement.internal.Q
    public final /* bridge */ /* synthetic */ zzas b() {
        return super.b();
    }

    @Override // com.google.android.gms.measurement.internal.C1417ga, com.google.android.gms.measurement.internal.O
    public final /* bridge */ /* synthetic */ void c() {
        super.c();
    }

    @Override // com.google.android.gms.measurement.internal.C1417ga, com.google.android.gms.measurement.internal.O
    public final /* bridge */ /* synthetic */ void d() {
        super.d();
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
    public final /* bridge */ /* synthetic */ zzda m() {
        return super.m();
    }

    @Override // com.google.android.gms.measurement.internal.C1417ga
    public final /* bridge */ /* synthetic */ zzam n() {
        return super.n();
    }

    @Override // com.google.android.gms.measurement.internal.C1417ga
    public final /* bridge */ /* synthetic */ zzao q() {
        return super.q();
    }

    @Override // com.google.android.gms.measurement.internal.Aa
    protected final boolean v() {
        return false;
    }

    public final void y() {
        c();
        t();
        this.f14018c.a();
        try {
            ConnectionTracker.a().a(getContext(), this.f14018c);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        this.f14019d = null;
    }

    public final boolean z() {
        c();
        t();
        return this.f14019d != null;
    }

    @Override // com.google.android.gms.measurement.internal.O, com.google.android.gms.measurement.internal.Q
    public final /* bridge */ /* synthetic */ zzbr zzgs() {
        return super.zzgs();
    }

    @Override // com.google.android.gms.measurement.internal.O, com.google.android.gms.measurement.internal.Q
    public final /* bridge */ /* synthetic */ zzn zzgw() {
        return super.zzgw();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(zzag zzagVar, String str) {
        Preconditions.a(zzagVar);
        c();
        t();
        boolean G = G();
        a(new RunnableC1435pa(this, G, G && q().a(zzagVar), zzagVar, a(true), str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(zzo zzoVar) {
        Preconditions.a(zzoVar);
        c();
        t();
        zzgw();
        a(new RunnableC1437qa(this, true, q().a(zzoVar), new zzo(zzoVar), a(true), zzoVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(AtomicReference<List<zzo>> atomicReference, String str, String str2, String str3) {
        c();
        t();
        a(new RunnableC1438ra(this, atomicReference, str, str2, str3, a(false)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(AtomicReference<List<zzfv>> atomicReference, String str, String str2, String str3, boolean z) {
        c();
        t();
        a(new RunnableC1440sa(this, atomicReference, str, str2, str3, z, a(false)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(zzfv zzfvVar) {
        c();
        t();
        a(new RunnableC1442ta(this, G() && q().a(zzfvVar), zzfvVar, a(true)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(AtomicReference<List<zzfv>> atomicReference, boolean z) {
        c();
        t();
        a(new RunnableC1423ja(this, atomicReference, a(false), z));
    }

    public final void a(AtomicReference<String> atomicReference) {
        c();
        t();
        a(new RunnableC1425ka(this, atomicReference, a(false)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(zzdx zzdxVar) {
        c();
        t();
        a(new RunnableC1429ma(this, zzdxVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @VisibleForTesting
    public final void a(zzaj zzajVar) {
        c();
        Preconditions.a(zzajVar);
        this.f14019d = zzajVar;
        E();
        H();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(ComponentName componentName) {
        c();
        if (this.f14019d != null) {
            this.f14019d = null;
            b().y().a("Disconnected from device MeasurementService", componentName);
            c();
            A();
        }
    }

    private final void a(Runnable runnable) throws IllegalStateException {
        c();
        if (z()) {
            runnable.run();
        } else {
            if (this.f14023h.size() >= 1000) {
                b().q().a("Discarding data. Max runnable queue size reached");
                return;
            }
            this.f14023h.add(runnable);
            this.i.a(60000L);
            A();
        }
    }

    private final zzk a(boolean z) {
        zzgw();
        return n().a(z ? b().z() : null);
    }

    @Override // com.google.android.gms.measurement.internal.O, com.google.android.gms.measurement.internal.Q
    public final /* bridge */ /* synthetic */ Clock a() {
        return super.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ zzaj a(zzeb zzebVar, zzaj zzajVar) {
        zzebVar.f14019d = null;
        return null;
    }
}
