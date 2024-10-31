package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

@zzark
/* loaded from: classes2.dex */
public final class zzads extends NativeAppInstallAd {
    private final zzadp zzdds;
    private final zzade zzddu;
    private final NativeAd.AdChoicesInfo zzddv;
    private final List<NativeAd.Image> zzddt = new ArrayList();
    private final VideoController zzcml = new VideoController();

    /* JADX WARN: Can't wrap try/catch for region: R(13:1|2|3|(2:5|(5:8|(1:22)(2:12|(1:14)(1:21))|(3:16|17|18)(1:20)|19|6))|(2:24|25)|(7:27|28|29|30|(2:32|33)|35|36)|41|28|29|30|(0)|35|36) */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0085, code lost:            r1 = move-exception;     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0086, code lost:            com.google.android.gms.internal.ads.zzbbd.zzb("", r1);     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0078 A[Catch: RemoteException -> 0x0085, TRY_LEAVE, TryCatch #1 {RemoteException -> 0x0085, blocks: (B:30:0x0070, B:32:0x0078), top: B:29:0x0070 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public zzads(com.google.android.gms.internal.ads.zzadp r6) {
        /*
            r5 = this;
            java.lang.String r0 = ""
            r5.<init>()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r5.zzddt = r1
            com.google.android.gms.ads.VideoController r1 = new com.google.android.gms.ads.VideoController
            r1.<init>()
            r5.zzcml = r1
            r5.zzdds = r6
            r6 = 0
            com.google.android.gms.internal.ads.zzadp r1 = r5.zzdds     // Catch: android.os.RemoteException -> L57
            java.util.List r1 = r1.getImages()     // Catch: android.os.RemoteException -> L57
            if (r1 == 0) goto L5b
            java.util.Iterator r1 = r1.iterator()     // Catch: android.os.RemoteException -> L57
        L22:
            boolean r2 = r1.hasNext()     // Catch: android.os.RemoteException -> L57
            if (r2 == 0) goto L5b
            java.lang.Object r2 = r1.next()     // Catch: android.os.RemoteException -> L57
            boolean r3 = r2 instanceof android.os.IBinder     // Catch: android.os.RemoteException -> L57
            if (r3 == 0) goto L49
            android.os.IBinder r2 = (android.os.IBinder) r2     // Catch: android.os.RemoteException -> L57
            if (r2 == 0) goto L49
            java.lang.String r3 = "com.google.android.gms.ads.internal.formats.client.INativeAdImage"
            android.os.IInterface r3 = r2.queryLocalInterface(r3)     // Catch: android.os.RemoteException -> L57
            boolean r4 = r3 instanceof com.google.android.gms.internal.ads.zzadb     // Catch: android.os.RemoteException -> L57
            if (r4 == 0) goto L42
            r2 = r3
            com.google.android.gms.internal.ads.zzadb r2 = (com.google.android.gms.internal.ads.zzadb) r2     // Catch: android.os.RemoteException -> L57
            goto L4a
        L42:
            com.google.android.gms.internal.ads.zzadd r3 = new com.google.android.gms.internal.ads.zzadd     // Catch: android.os.RemoteException -> L57
            r3.<init>(r2)     // Catch: android.os.RemoteException -> L57
            r2 = r3
            goto L4a
        L49:
            r2 = r6
        L4a:
            if (r2 == 0) goto L22
            java.util.List<com.google.android.gms.ads.formats.NativeAd$Image> r3 = r5.zzddt     // Catch: android.os.RemoteException -> L57
            com.google.android.gms.internal.ads.zzade r4 = new com.google.android.gms.internal.ads.zzade     // Catch: android.os.RemoteException -> L57
            r4.<init>(r2)     // Catch: android.os.RemoteException -> L57
            r3.add(r4)     // Catch: android.os.RemoteException -> L57
            goto L22
        L57:
            r1 = move-exception
            com.google.android.gms.internal.ads.zzbbd.zzb(r0, r1)
        L5b:
            com.google.android.gms.internal.ads.zzadp r1 = r5.zzdds     // Catch: android.os.RemoteException -> L69
            com.google.android.gms.internal.ads.zzadb r1 = r1.zzsb()     // Catch: android.os.RemoteException -> L69
            if (r1 == 0) goto L6d
            com.google.android.gms.internal.ads.zzade r2 = new com.google.android.gms.internal.ads.zzade     // Catch: android.os.RemoteException -> L69
            r2.<init>(r1)     // Catch: android.os.RemoteException -> L69
            goto L6e
        L69:
            r1 = move-exception
            com.google.android.gms.internal.ads.zzbbd.zzb(r0, r1)
        L6d:
            r2 = r6
        L6e:
            r5.zzddu = r2
            com.google.android.gms.internal.ads.zzadp r1 = r5.zzdds     // Catch: android.os.RemoteException -> L85
            com.google.android.gms.internal.ads.zzacx r1 = r1.zzse()     // Catch: android.os.RemoteException -> L85
            if (r1 == 0) goto L89
            com.google.android.gms.internal.ads.zzada r1 = new com.google.android.gms.internal.ads.zzada     // Catch: android.os.RemoteException -> L85
            com.google.android.gms.internal.ads.zzadp r2 = r5.zzdds     // Catch: android.os.RemoteException -> L85
            com.google.android.gms.internal.ads.zzacx r2 = r2.zzse()     // Catch: android.os.RemoteException -> L85
            r1.<init>(r2)     // Catch: android.os.RemoteException -> L85
            r6 = r1
            goto L89
        L85:
            r1 = move-exception
            com.google.android.gms.internal.ads.zzbbd.zzb(r0, r1)
        L89:
            r5.zzddv = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzads.<init>(com.google.android.gms.internal.ads.zzadp):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.ads.formats.NativeAd
    /* renamed from: zzsc, reason: merged with bridge method [inline-methods] */
    public final IObjectWrapper zzhy() {
        try {
            return this.zzdds.zzsc();
        } catch (RemoteException e2) {
            zzbbd.zzb("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final void destroy() {
        try {
            this.zzdds.destroy();
        } catch (RemoteException e2) {
            zzbbd.zzb("", e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final NativeAd.AdChoicesInfo getAdChoicesInfo() {
        return this.zzddv;
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final CharSequence getBody() {
        try {
            return this.zzdds.getBody();
        } catch (RemoteException e2) {
            zzbbd.zzb("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final CharSequence getCallToAction() {
        try {
            return this.zzdds.getCallToAction();
        } catch (RemoteException e2) {
            zzbbd.zzb("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final Bundle getExtras() {
        try {
            return this.zzdds.getExtras();
        } catch (RemoteException e2) {
            zzbbd.zzb("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final CharSequence getHeadline() {
        try {
            return this.zzdds.getHeadline();
        } catch (RemoteException e2) {
            zzbbd.zzb("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final NativeAd.Image getIcon() {
        return this.zzddu;
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final List<NativeAd.Image> getImages() {
        return this.zzddt;
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final CharSequence getMediationAdapterClassName() {
        try {
            return this.zzdds.getMediationAdapterClassName();
        } catch (RemoteException e2) {
            zzbbd.zzb("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final CharSequence getPrice() {
        try {
            return this.zzdds.getPrice();
        } catch (RemoteException e2) {
            zzbbd.zzb("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final Double getStarRating() {
        try {
            double starRating = this.zzdds.getStarRating();
            if (starRating == -1.0d) {
                return null;
            }
            return Double.valueOf(starRating);
        } catch (RemoteException e2) {
            zzbbd.zzb("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final CharSequence getStore() {
        try {
            return this.zzdds.getStore();
        } catch (RemoteException e2) {
            zzbbd.zzb("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAppInstallAd
    public final VideoController getVideoController() {
        try {
            if (this.zzdds.getVideoController() != null) {
                this.zzcml.a(this.zzdds.getVideoController());
            }
        } catch (RemoteException e2) {
            zzbbd.zzb("Exception occurred while getting video controller", e2);
        }
        return this.zzcml;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd
    public final void performClick(Bundle bundle) {
        try {
            this.zzdds.performClick(bundle);
        } catch (RemoteException e2) {
            zzbbd.zzb("", e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAd
    public final boolean recordImpression(Bundle bundle) {
        try {
            return this.zzdds.recordImpression(bundle);
        } catch (RemoteException e2) {
            zzbbd.zzb("", e2);
            return false;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeAd
    public final void reportTouchEvent(Bundle bundle) {
        try {
            this.zzdds.reportTouchEvent(bundle);
        } catch (RemoteException e2) {
            zzbbd.zzb("", e2);
        }
    }
}
