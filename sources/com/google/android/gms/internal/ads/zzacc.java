package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@zzark
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zzacc extends zzach {
    private final Object mLock;
    private zzals zzdbv;
    private zzalv zzdbw;
    private zzaly zzdbx;
    private final zzace zzdby;
    private zzacd zzdbz;
    private boolean zzdca;
    private boolean zzdcb;

    public zzacc(Context context, zzace zzaceVar, zzcu zzcuVar, zzals zzalsVar, zzacf zzacfVar) {
        this(context, zzaceVar, zzcuVar, zzacfVar);
        this.zzdbv = zzalsVar;
    }

    private static HashMap<String, View> zzb(Map<String, WeakReference<View>> map) {
        HashMap<String, View> hashMap = new HashMap<>();
        if (map == null) {
            return hashMap;
        }
        synchronized (map) {
            for (Map.Entry<String, WeakReference<View>> entry : map.entrySet()) {
                View view = entry.getValue().get();
                if (view != null) {
                    hashMap.put(entry.getKey(), view);
                }
            }
        }
        return hashMap;
    }

    private final void zzl(View view) {
        try {
            if (this.zzdbx != null && !this.zzdbx.getOverrideClickHandling()) {
                this.zzdbx.zzk(ObjectWrapper.a(view));
                this.zzdby.onAdClicked();
            } else if (this.zzdbv != null && !this.zzdbv.getOverrideClickHandling()) {
                this.zzdbv.zzk(ObjectWrapper.a(view));
                this.zzdby.onAdClicked();
            } else {
                if (this.zzdbw == null || this.zzdbw.getOverrideClickHandling()) {
                    return;
                }
                this.zzdbw.zzk(ObjectWrapper.a(view));
                this.zzdby.onAdClicked();
            }
        } catch (RemoteException e2) {
            zzbbd.zzc("Failed to call performClick", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzach, com.google.android.gms.internal.ads.zzacd
    public final void cancelUnconfirmedClick() {
        synchronized (this.mLock) {
            if (this.zzdbz != null) {
                this.zzdbz.cancelUnconfirmedClick();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzach, com.google.android.gms.internal.ads.zzacd
    public final void recordCustomClickGesture() {
        Preconditions.a("recordCustomClickGesture must be called on the main UI thread.");
        synchronized (this.mLock) {
            if (this.zzdbz != null) {
                if (this.zzdcb) {
                    this.zzdbz.zzsi();
                }
                this.zzdbz.recordCustomClickGesture();
                this.zzdby.onAdClicked();
            } else if (!this.zzdcb) {
                zzbbd.zzeo("Custom click reporting for 3p ads failed. enableCustomClickGesture is not set.");
            } else if (!zzsk()) {
                zzbbd.zzeo("Custom click reporting for 3p ads failed. Ad unit id not whitelisted.");
            } else if (zzst() != null) {
                zzl(zzst().zzsw());
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzach, com.google.android.gms.internal.ads.zzacd
    public final void setClickConfirmingView(View view) {
        synchronized (this.mLock) {
            if (this.zzdbz != null) {
                this.zzdbz.setClickConfirmingView(view);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0038, code lost:            r4 = null;     */
    @Override // com.google.android.gms.internal.ads.zzach, com.google.android.gms.internal.ads.zzacd
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.view.View zza(android.view.View.OnClickListener r3, boolean r4) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.mLock
            monitor-enter(r0)
            com.google.android.gms.internal.ads.zzacd r1 = r2.zzdbz     // Catch: java.lang.Throwable -> L44
            if (r1 == 0) goto Lf
            com.google.android.gms.internal.ads.zzacd r1 = r2.zzdbz     // Catch: java.lang.Throwable -> L44
            android.view.View r3 = r1.zza(r3, r4)     // Catch: java.lang.Throwable -> L44
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L44
            return r3
        Lf:
            r3 = 0
            com.google.android.gms.internal.ads.zzaly r4 = r2.zzdbx     // Catch: android.os.RemoteException -> L31 java.lang.Throwable -> L44
            if (r4 == 0) goto L1b
            com.google.android.gms.internal.ads.zzaly r4 = r2.zzdbx     // Catch: android.os.RemoteException -> L31 java.lang.Throwable -> L44
            com.google.android.gms.dynamic.IObjectWrapper r4 = r4.zzvb()     // Catch: android.os.RemoteException -> L31 java.lang.Throwable -> L44
            goto L38
        L1b:
            com.google.android.gms.internal.ads.zzals r4 = r2.zzdbv     // Catch: android.os.RemoteException -> L31 java.lang.Throwable -> L44
            if (r4 == 0) goto L26
            com.google.android.gms.internal.ads.zzals r4 = r2.zzdbv     // Catch: android.os.RemoteException -> L31 java.lang.Throwable -> L44
            com.google.android.gms.dynamic.IObjectWrapper r4 = r4.zzvb()     // Catch: android.os.RemoteException -> L31 java.lang.Throwable -> L44
            goto L38
        L26:
            com.google.android.gms.internal.ads.zzalv r4 = r2.zzdbw     // Catch: android.os.RemoteException -> L31 java.lang.Throwable -> L44
            if (r4 == 0) goto L37
            com.google.android.gms.internal.ads.zzalv r4 = r2.zzdbw     // Catch: android.os.RemoteException -> L31 java.lang.Throwable -> L44
            com.google.android.gms.dynamic.IObjectWrapper r4 = r4.zzvb()     // Catch: android.os.RemoteException -> L31 java.lang.Throwable -> L44
            goto L38
        L31:
            r4 = move-exception
            java.lang.String r1 = "Failed to call getAdChoicesContent"
            com.google.android.gms.internal.ads.zzbbd.zzc(r1, r4)     // Catch: java.lang.Throwable -> L44
        L37:
            r4 = r3
        L38:
            if (r4 == 0) goto L42
            java.lang.Object r3 = com.google.android.gms.dynamic.ObjectWrapper.a(r4)     // Catch: java.lang.Throwable -> L44
            android.view.View r3 = (android.view.View) r3     // Catch: java.lang.Throwable -> L44
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L44
            return r3
        L42:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L44
            return r3
        L44:
            r3 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L44
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzacc.zza(android.view.View$OnClickListener, boolean):android.view.View");
    }

    public final void zzc(zzacd zzacdVar) {
        synchronized (this.mLock) {
            this.zzdbz = zzacdVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzach, com.google.android.gms.internal.ads.zzacd
    public final void zzd(MotionEvent motionEvent) {
        synchronized (this.mLock) {
            if (this.zzdbz != null) {
                this.zzdbz.zzd(motionEvent);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzach, com.google.android.gms.internal.ads.zzacd
    public final void zzjl() {
        zzacd zzacdVar = this.zzdbz;
        if (zzacdVar != null) {
            zzacdVar.zzjl();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzach, com.google.android.gms.internal.ads.zzacd
    public final void zzjm() {
        zzacd zzacdVar = this.zzdbz;
        if (zzacdVar != null) {
            zzacdVar.zzjm();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzach, com.google.android.gms.internal.ads.zzacd
    public final void zzsi() {
        this.zzdcb = true;
        zzacd zzacdVar = this.zzdbz;
        if (zzacdVar != null) {
            zzacdVar.zzsi();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzach, com.google.android.gms.internal.ads.zzacd
    public final boolean zzsj() {
        synchronized (this.mLock) {
            if (this.zzdbz != null) {
                return this.zzdbz.zzsj();
            }
            return this.zzdby.zzjo();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzach, com.google.android.gms.internal.ads.zzacd
    public final boolean zzsk() {
        synchronized (this.mLock) {
            if (this.zzdbz != null) {
                return this.zzdbz.zzsk();
            }
            return this.zzdby.zzjq();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzach, com.google.android.gms.internal.ads.zzacd
    public final boolean zzsl() {
        synchronized (this.mLock) {
            if (this.zzdbz != null) {
                return this.zzdbz.zzsl();
            }
            return this.zzdby.zzjp();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzach, com.google.android.gms.internal.ads.zzacd
    public final void zzsm() {
        Preconditions.a("recordDownloadedImpression must be called on main UI thread.");
        synchronized (this.mLock) {
            this.zzdch = true;
            if (this.zzdbz != null) {
                this.zzdbz.zzsm();
            }
        }
    }

    public final boolean zzsn() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzdca;
        }
        return z;
    }

    public final zzacd zzso() {
        zzacd zzacdVar;
        synchronized (this.mLock) {
            zzacdVar = this.zzdbz;
        }
        return zzacdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzach
    public final zzbgg zzsp() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzach, com.google.android.gms.internal.ads.zzacd
    public final void zzsq() {
    }

    @Override // com.google.android.gms.internal.ads.zzach, com.google.android.gms.internal.ads.zzacd
    public final void zzsr() {
    }

    public zzacc(Context context, zzace zzaceVar, zzcu zzcuVar, zzalv zzalvVar, zzacf zzacfVar) {
        this(context, zzaceVar, zzcuVar, zzacfVar);
        this.zzdbw = zzalvVar;
    }

    public zzacc(Context context, zzace zzaceVar, zzcu zzcuVar, zzaly zzalyVar, zzacf zzacfVar) {
        this(context, zzaceVar, zzcuVar, zzacfVar);
        this.zzdbx = zzalyVar;
    }

    private zzacc(Context context, zzace zzaceVar, zzcu zzcuVar, zzacf zzacfVar) {
        super(context, zzaceVar, null, zzcuVar, null, zzacfVar, null, null);
        this.zzdca = false;
        this.zzdcb = false;
        this.mLock = new Object();
        this.zzdby = zzaceVar;
    }

    @Override // com.google.android.gms.internal.ads.zzach, com.google.android.gms.internal.ads.zzacd
    public final void zzb(View view, Map<String, WeakReference<View>> map) {
        synchronized (this.mLock) {
            try {
                if (this.zzdbx != null) {
                    this.zzdbx.zzm(ObjectWrapper.a(view));
                } else if (this.zzdbv != null) {
                    this.zzdbv.zzm(ObjectWrapper.a(view));
                } else if (this.zzdbw != null) {
                    this.zzdbw.zzm(ObjectWrapper.a(view));
                }
            } catch (RemoteException e2) {
                zzbbd.zzc("Failed to call untrackView", e2);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzach, com.google.android.gms.internal.ads.zzacd
    public final void zza(zzaet zzaetVar) {
        synchronized (this.mLock) {
            if (this.zzdbz != null) {
                this.zzdbz.zza(zzaetVar);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzach, com.google.android.gms.internal.ads.zzacd
    public final void zza(View view, Map<String, WeakReference<View>> map) {
        Preconditions.a("recordImpression must be called on the main UI thread.");
        synchronized (this.mLock) {
            this.zzdcg = true;
            if (this.zzdbz != null) {
                this.zzdbz.zza(view, map);
                this.zzdby.recordImpression();
            } else {
                try {
                    if (this.zzdbx != null && !this.zzdbx.getOverrideImpressionRecording()) {
                        this.zzdbx.recordImpression();
                        this.zzdby.recordImpression();
                    } else if (this.zzdbv != null && !this.zzdbv.getOverrideImpressionRecording()) {
                        this.zzdbv.recordImpression();
                        this.zzdby.recordImpression();
                    } else if (this.zzdbw != null && !this.zzdbw.getOverrideImpressionRecording()) {
                        this.zzdbw.recordImpression();
                        this.zzdby.recordImpression();
                    }
                } catch (RemoteException e2) {
                    zzbbd.zzc("Failed to call recordImpression", e2);
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzach, com.google.android.gms.internal.ads.zzacd
    public final void zza(View view, Map<String, WeakReference<View>> map, Bundle bundle, View view2) {
        Preconditions.a("performClick must be called on the main UI thread.");
        synchronized (this.mLock) {
            if (this.zzdcb && zzsk()) {
                return;
            }
            if (this.zzdbz != null) {
                this.zzdbz.zza(view, map, bundle, view2);
                this.zzdby.onAdClicked();
            } else {
                zzl(view);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzach
    public final void zza(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, View.OnTouchListener onTouchListener, View.OnClickListener onClickListener) {
        synchronized (this.mLock) {
            this.zzdca = true;
            HashMap<String, View> zzb = zzb(map);
            HashMap<String, View> zzb2 = zzb(map2);
            try {
                if (this.zzdbx != null) {
                    this.zzdbx.zzb(ObjectWrapper.a(view), ObjectWrapper.a(zzb), ObjectWrapper.a(zzb2));
                } else if (this.zzdbv != null) {
                    this.zzdbv.zzb(ObjectWrapper.a(view), ObjectWrapper.a(zzb), ObjectWrapper.a(zzb2));
                    this.zzdbv.zzl(ObjectWrapper.a(view));
                } else if (this.zzdbw != null) {
                    this.zzdbw.zzb(ObjectWrapper.a(view), ObjectWrapper.a(zzb), ObjectWrapper.a(zzb2));
                    this.zzdbw.zzl(ObjectWrapper.a(view));
                }
            } catch (RemoteException e2) {
                zzbbd.zzc("Failed to call prepareAd", e2);
            }
            this.zzdca = false;
        }
    }
}
