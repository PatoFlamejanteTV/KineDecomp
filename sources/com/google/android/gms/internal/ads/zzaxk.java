package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@zzark
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zzaxk {
    private Context mContext;
    private zzrf zzblu;
    private zzbbi zzbob;
    private String zzeiz;
    private zzbcb<ArrayList<String>> zzejd;
    private final Object mLock = new Object();
    private final zzayc zzeiv = new zzayc();
    private final zzaxt zzeiw = new zzaxt(zzwu.zzqa(), this.zzeiv);
    private boolean zzbps = false;

    @Nullable
    private zzaaq zzeix = null;

    @Nullable
    private Boolean zzeiy = null;
    private final AtomicInteger zzeja = new AtomicInteger(0);
    private final C1052qd zzejb = new C1052qd(null);
    private final Object zzejc = new Object();

    @TargetApi(16)
    private static ArrayList<String> zzae(Context context) {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            PackageInfo b2 = Wrappers.a(context).b(context.getApplicationInfo().packageName, 4096);
            if (b2.requestedPermissions != null && b2.requestedPermissionsFlags != null) {
                int i = 0;
                while (true) {
                    String[] strArr = b2.requestedPermissions;
                    if (i >= strArr.length) {
                        break;
                    }
                    if ((b2.requestedPermissionsFlags[i] & 2) != 0) {
                        arrayList.add(strArr[i]);
                    }
                    i++;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return arrayList;
    }

    @Nullable
    public final Context getApplicationContext() {
        return this.mContext;
    }

    @Nullable
    public final Resources getResources() {
        if (this.zzbob.zzeow) {
            return this.mContext.getResources();
        }
        try {
            zzbbe.zzbm(this.mContext).getResources();
            return null;
        } catch (zzbbg e2) {
            zzbbd.zzc("Cannot load resource from dynamite apk or local jar", e2);
            return null;
        }
    }

    public final void zza(Boolean bool) {
        synchronized (this.mLock) {
            this.zzeiy = bool;
        }
    }

    public final void zzal(boolean z) {
        this.zzejb.a(z);
    }

    public final void zzb(Throwable th, String str) {
        zzare.zzc(this.mContext, this.zzbob).zza(th, str, ((Float) zzwu.zzpz().zzd(zzaan.zzcoi)).floatValue());
    }

    @TargetApi(23)
    public final void zzd(Context context, zzbbi zzbbiVar) {
        synchronized (this.mLock) {
            if (!this.zzbps) {
                this.mContext = context.getApplicationContext();
                this.zzbob = zzbbiVar;
                com.google.android.gms.ads.internal.zzbv.h().zza(this.zzeiw);
                zzaaq zzaaqVar = null;
                this.zzeiv.zza(this.mContext, null, true);
                zzare.zzc(this.mContext, this.zzbob);
                this.zzeiz = com.google.android.gms.ads.internal.zzbv.e().zzo(context, zzbbiVar.zzdp);
                this.zzblu = new zzrf(context.getApplicationContext(), this.zzbob);
                com.google.android.gms.ads.internal.zzbv.n();
                if (!((Boolean) zzwu.zzpz().zzd(zzaan.zzcpw)).booleanValue()) {
                    zzaxz.v("CsiReporterFactory: CSI is not enabled. No CSI reporter created.");
                } else {
                    zzaaqVar = new zzaaq();
                }
                this.zzeix = zzaaqVar;
                if (this.zzeix != null) {
                    zzbbo.zza((zzbcb) new C1038pd(this).zzwa(), "AppState.registerCsiReporter");
                }
                this.zzbps = true;
                zzyr();
            }
        }
    }

    @Nullable
    public final zzaaq zzyh() {
        zzaaq zzaaqVar;
        synchronized (this.mLock) {
            zzaaqVar = this.zzeix;
        }
        return zzaaqVar;
    }

    public final Boolean zzyi() {
        Boolean bool;
        synchronized (this.mLock) {
            bool = this.zzeiy;
        }
        return bool;
    }

    public final boolean zzyj() {
        return this.zzejb.a();
    }

    public final boolean zzyk() {
        return this.zzejb.b();
    }

    public final void zzyl() {
        this.zzejb.c();
    }

    public final zzrf zzym() {
        return this.zzblu;
    }

    public final void zzyn() {
        this.zzeja.incrementAndGet();
    }

    public final void zzyo() {
        this.zzeja.decrementAndGet();
    }

    public final int zzyp() {
        return this.zzeja.get();
    }

    @Deprecated
    public final zzayb zzyq() {
        zzayc zzaycVar;
        synchronized (this.mLock) {
            zzaycVar = this.zzeiv;
        }
        return zzaycVar;
    }

    public final zzbcb<ArrayList<String>> zzyr() {
        if (PlatformVersion.c() && this.mContext != null) {
            if (!((Boolean) zzwu.zzpz().zzd(zzaan.zzctm)).booleanValue()) {
                synchronized (this.zzejc) {
                    if (this.zzejd != null) {
                        return this.zzejd;
                    }
                    zzbcb<ArrayList<String>> zza = zzayf.zza(new Callable(this) { // from class: com.google.android.gms.internal.ads.od

                        /* renamed from: a, reason: collision with root package name */
                        private final zzaxk f12383a;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.f12383a = this;
                        }

                        @Override // java.util.concurrent.Callable
                        public final Object call() {
                            return this.f12383a.zzyt();
                        }
                    });
                    this.zzejd = zza;
                    return zza;
                }
            }
        }
        return zzbbq.zzm(new ArrayList());
    }

    public final zzaxt zzys() {
        return this.zzeiw;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ ArrayList zzyt() throws Exception {
        return zzae(zzaum.zzu(this.mContext));
    }

    public final void zza(Throwable th, String str) {
        zzare.zzc(this.mContext, this.zzbob).zza(th, str);
    }
}
