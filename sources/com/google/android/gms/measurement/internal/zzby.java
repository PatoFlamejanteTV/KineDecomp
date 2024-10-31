package com.google.android.gms.measurement.internal;

import android.os.Binder;
import android.text.TextUtils;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.GoogleSignatureVerifier;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.UidVerifier;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

/* loaded from: classes2.dex */
public final class zzby extends zzak {

    /* renamed from: a, reason: collision with root package name */
    private final zzfo f13986a;

    /* renamed from: b, reason: collision with root package name */
    private Boolean f13987b;

    /* renamed from: c, reason: collision with root package name */
    private String f13988c;

    public zzby(zzfo zzfoVar) {
        this(zzfoVar, null);
    }

    @Override // com.google.android.gms.measurement.internal.zzaj
    public final void a(zzag zzagVar, zzk zzkVar) {
        Preconditions.a(zzagVar);
        b(zzkVar, false);
        a(new G(this, zzagVar, zzkVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final zzag b(zzag zzagVar, zzk zzkVar) {
        zzad zzadVar;
        boolean z = false;
        if ("_cmp".equals(zzagVar.f13897a) && (zzadVar = zzagVar.f13898b) != null && zzadVar.size() != 0) {
            String g2 = zzagVar.f13898b.g("_cis");
            if (!TextUtils.isEmpty(g2) && (("referrer broadcast".equals(g2) || "referrer API".equals(g2)) && this.f13986a.f().m(zzkVar.f14064a))) {
                z = true;
            }
        }
        if (!z) {
            return zzagVar;
        }
        this.f13986a.b().w().a("Event has been filtered ", zzagVar.toString());
        return new zzag("_cmpx", zzagVar.f13898b, zzagVar.f13899c, zzagVar.f13900d);
    }

    @Override // com.google.android.gms.measurement.internal.zzaj
    public final void c(zzk zzkVar) {
        b(zzkVar, false);
        a(new RunnableC1445v(this, zzkVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzaj
    public final String d(zzk zzkVar) {
        b(zzkVar, false);
        return this.f13986a.d(zzkVar);
    }

    private zzby(zzfo zzfoVar, String str) {
        Preconditions.a(zzfoVar);
        this.f13986a = zzfoVar;
        this.f13988c = null;
    }

    @Override // com.google.android.gms.measurement.internal.zzaj
    public final void a(zzag zzagVar, String str, String str2) {
        Preconditions.a(zzagVar);
        Preconditions.b(str);
        a(str, true);
        a(new H(this, zzagVar, str));
    }

    @Override // com.google.android.gms.measurement.internal.zzaj
    public final byte[] a(zzag zzagVar, String str) {
        Preconditions.b(str);
        Preconditions.a(zzagVar);
        a(str, true);
        this.f13986a.b().x().a("Log and bundle. event", this.f13986a.d().a(zzagVar.f13897a));
        long b2 = this.f13986a.a().b() / 1000000;
        try {
            byte[] bArr = (byte[]) this.f13986a.zzgs().b(new I(this, zzagVar, str)).get();
            if (bArr == null) {
                this.f13986a.b().q().a("Log and bundle returned null. appId", zzas.a(str));
                bArr = new byte[0];
            }
            this.f13986a.b().x().a("Log and bundle processed. event, size, time_ms", this.f13986a.d().a(zzagVar.f13897a), Integer.valueOf(bArr.length), Long.valueOf((this.f13986a.a().b() / 1000000) - b2));
            return bArr;
        } catch (InterruptedException | ExecutionException e2) {
            this.f13986a.b().q().a("Failed to log and bundle. appId, event, error", zzas.a(str), this.f13986a.d().a(zzagVar.f13897a), e2);
            return null;
        }
    }

    private final void b(zzk zzkVar, boolean z) {
        Preconditions.a(zzkVar);
        a(zzkVar.f14064a, false);
        this.f13986a.e().c(zzkVar.f14065b, zzkVar.r);
    }

    @Override // com.google.android.gms.measurement.internal.zzaj
    public final void b(zzk zzkVar) {
        a(zzkVar.f14064a, false);
        a(new F(this, zzkVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzaj
    public final void a(zzfv zzfvVar, zzk zzkVar) {
        Preconditions.a(zzfvVar);
        b(zzkVar, false);
        if (zzfvVar.getValue() == null) {
            a(new J(this, zzfvVar, zzkVar));
        } else {
            a(new K(this, zzfvVar, zzkVar));
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzaj
    public final List<zzfv> a(zzk zzkVar, boolean z) {
        b(zzkVar, false);
        try {
            List<Qa> list = (List) this.f13986a.zzgs().a(new L(this, zzkVar)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (Qa qa : list) {
                if (z || !zzfy.d(qa.f13679c)) {
                    arrayList.add(new zzfv(qa));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e2) {
            this.f13986a.b().q().a("Failed to get user attributes. appId", zzas.a(zzkVar.f14064a), e2);
            return null;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzaj
    public final void a(zzk zzkVar) {
        b(zzkVar, false);
        a(new M(this, zzkVar));
    }

    private final void a(String str, boolean z) {
        boolean z2;
        if (!TextUtils.isEmpty(str)) {
            if (z) {
                try {
                    if (this.f13987b == null) {
                        if (!"com.google.android.gms".equals(this.f13988c) && !UidVerifier.a(this.f13986a.getContext(), Binder.getCallingUid()) && !GoogleSignatureVerifier.a(this.f13986a.getContext()).a(Binder.getCallingUid())) {
                            z2 = false;
                            this.f13987b = Boolean.valueOf(z2);
                        }
                        z2 = true;
                        this.f13987b = Boolean.valueOf(z2);
                    }
                    if (this.f13987b.booleanValue()) {
                        return;
                    }
                } catch (SecurityException e2) {
                    this.f13986a.b().q().a("Measurement Service called with invalid calling package. appId", zzas.a(str));
                    throw e2;
                }
            }
            if (this.f13988c == null && GooglePlayServicesUtilLight.uidHasPackageName(this.f13986a.getContext(), Binder.getCallingUid(), str)) {
                this.f13988c = str;
            }
            if (str.equals(this.f13988c)) {
                return;
            } else {
                throw new SecurityException(String.format("Unknown calling package name '%s'.", str));
            }
        }
        this.f13986a.b().q().a("Measurement Service called without app package");
        throw new SecurityException("Measurement Service called without app package");
    }

    @Override // com.google.android.gms.measurement.internal.zzaj
    public final void a(long j, String str, String str2, String str3) {
        a(new N(this, str2, str3, str, j));
    }

    @Override // com.google.android.gms.measurement.internal.zzaj
    public final void a(zzo zzoVar, zzk zzkVar) {
        Preconditions.a(zzoVar);
        Preconditions.a(zzoVar.f14075c);
        b(zzkVar, false);
        zzo zzoVar2 = new zzo(zzoVar);
        zzoVar2.f14073a = zzkVar.f14064a;
        if (zzoVar.f14075c.getValue() == null) {
            a(new RunnableC1449x(this, zzoVar2, zzkVar));
        } else {
            a(new RunnableC1451y(this, zzoVar2, zzkVar));
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzaj
    public final void a(zzo zzoVar) {
        Preconditions.a(zzoVar);
        Preconditions.a(zzoVar.f14075c);
        a(zzoVar.f14073a, true);
        zzo zzoVar2 = new zzo(zzoVar);
        if (zzoVar.f14075c.getValue() == null) {
            a(new RunnableC1453z(this, zzoVar2));
        } else {
            a(new A(this, zzoVar2));
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzaj
    public final List<zzfv> a(String str, String str2, boolean z, zzk zzkVar) {
        b(zzkVar, false);
        try {
            List<Qa> list = (List) this.f13986a.zzgs().a(new B(this, zzkVar, str, str2)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (Qa qa : list) {
                if (z || !zzfy.d(qa.f13679c)) {
                    arrayList.add(new zzfv(qa));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e2) {
            this.f13986a.b().q().a("Failed to get user attributes. appId", zzas.a(zzkVar.f14064a), e2);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzaj
    public final List<zzfv> a(String str, String str2, String str3, boolean z) {
        a(str, true);
        try {
            List<Qa> list = (List) this.f13986a.zzgs().a(new C(this, str, str2, str3)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (Qa qa : list) {
                if (z || !zzfy.d(qa.f13679c)) {
                    arrayList.add(new zzfv(qa));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e2) {
            this.f13986a.b().q().a("Failed to get user attributes. appId", zzas.a(str), e2);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzaj
    public final List<zzo> a(String str, String str2, zzk zzkVar) {
        b(zzkVar, false);
        try {
            return (List) this.f13986a.zzgs().a(new D(this, zzkVar, str, str2)).get();
        } catch (InterruptedException | ExecutionException e2) {
            this.f13986a.b().q().a("Failed to get conditional user properties", e2);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzaj
    public final List<zzo> a(String str, String str2, String str3) {
        a(str, true);
        try {
            return (List) this.f13986a.zzgs().a(new E(this, str, str2, str3)).get();
        } catch (InterruptedException | ExecutionException e2) {
            this.f13986a.b().q().a("Failed to get conditional user properties", e2);
            return Collections.emptyList();
        }
    }

    @VisibleForTesting
    private final void a(Runnable runnable) {
        Preconditions.a(runnable);
        if (zzai.ha.a().booleanValue() && this.f13986a.zzgs().q()) {
            runnable.run();
        } else {
            this.f13986a.zzgs().a(runnable);
        }
    }
}
