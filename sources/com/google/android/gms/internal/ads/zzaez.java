package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.MuteThisAdListener;
import com.google.android.gms.ads.MuteThisAdReason;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.List;

@zzark
/* loaded from: classes2.dex */
public final class zzaez extends UnifiedNativeAd {
    private final zzaew zzdeb;
    private final zzade zzded;
    private final NativeAd.AdChoicesInfo zzdef;
    private final List<NativeAd.Image> zzdec = new ArrayList();
    private final VideoController zzdee = new VideoController();
    private final List<MuteThisAdReason> zzdeg = new ArrayList();

    /* JADX WARN: Can't wrap try/catch for region: R(14:1|2|3|(2:5|(5:8|(1:22)(2:12|(1:14)(1:21))|(3:16|17|18)(1:20)|19|6))|(3:24|25|(2:27|(5:30|(1:32)(1:39)|(3:34|35|36)(1:38)|37|28)))|(2:41|42)|(7:44|45|46|47|(2:49|50)|52|53)|58|45|46|47|(0)|52|53) */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00bf, code lost:            r1 = move-exception;     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00c0, code lost:            com.google.android.gms.internal.ads.zzbbd.zzb("", r1);     */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00b2 A[Catch: RemoteException -> 0x00bf, TRY_LEAVE, TryCatch #2 {RemoteException -> 0x00bf, blocks: (B:47:0x00aa, B:49:0x00b2), top: B:46:0x00aa }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public zzaez(com.google.android.gms.internal.ads.zzaew r6) {
        /*
            r5 = this;
            java.lang.String r0 = ""
            r5.<init>()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r5.zzdec = r1
            com.google.android.gms.ads.VideoController r1 = new com.google.android.gms.ads.VideoController
            r1.<init>()
            r5.zzdee = r1
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r5.zzdeg = r1
            r5.zzdeb = r6
            r6 = 0
            com.google.android.gms.internal.ads.zzaew r1 = r5.zzdeb     // Catch: android.os.RemoteException -> L5e
            java.util.List r1 = r1.getImages()     // Catch: android.os.RemoteException -> L5e
            if (r1 == 0) goto L62
            java.util.Iterator r1 = r1.iterator()     // Catch: android.os.RemoteException -> L5e
        L29:
            boolean r2 = r1.hasNext()     // Catch: android.os.RemoteException -> L5e
            if (r2 == 0) goto L62
            java.lang.Object r2 = r1.next()     // Catch: android.os.RemoteException -> L5e
            boolean r3 = r2 instanceof android.os.IBinder     // Catch: android.os.RemoteException -> L5e
            if (r3 == 0) goto L50
            android.os.IBinder r2 = (android.os.IBinder) r2     // Catch: android.os.RemoteException -> L5e
            if (r2 == 0) goto L50
            java.lang.String r3 = "com.google.android.gms.ads.internal.formats.client.INativeAdImage"
            android.os.IInterface r3 = r2.queryLocalInterface(r3)     // Catch: android.os.RemoteException -> L5e
            boolean r4 = r3 instanceof com.google.android.gms.internal.ads.zzadb     // Catch: android.os.RemoteException -> L5e
            if (r4 == 0) goto L49
            r2 = r3
            com.google.android.gms.internal.ads.zzadb r2 = (com.google.android.gms.internal.ads.zzadb) r2     // Catch: android.os.RemoteException -> L5e
            goto L51
        L49:
            com.google.android.gms.internal.ads.zzadd r3 = new com.google.android.gms.internal.ads.zzadd     // Catch: android.os.RemoteException -> L5e
            r3.<init>(r2)     // Catch: android.os.RemoteException -> L5e
            r2 = r3
            goto L51
        L50:
            r2 = r6
        L51:
            if (r2 == 0) goto L29
            java.util.List<com.google.android.gms.ads.formats.NativeAd$Image> r3 = r5.zzdec     // Catch: android.os.RemoteException -> L5e
            com.google.android.gms.internal.ads.zzade r4 = new com.google.android.gms.internal.ads.zzade     // Catch: android.os.RemoteException -> L5e
            r4.<init>(r2)     // Catch: android.os.RemoteException -> L5e
            r3.add(r4)     // Catch: android.os.RemoteException -> L5e
            goto L29
        L5e:
            r1 = move-exception
            com.google.android.gms.internal.ads.zzbbd.zzb(r0, r1)
        L62:
            com.google.android.gms.internal.ads.zzaew r1 = r5.zzdeb     // Catch: android.os.RemoteException -> L91
            java.util.List r1 = r1.getMuteThisAdReasons()     // Catch: android.os.RemoteException -> L91
            if (r1 == 0) goto L95
            java.util.Iterator r1 = r1.iterator()     // Catch: android.os.RemoteException -> L91
        L6e:
            boolean r2 = r1.hasNext()     // Catch: android.os.RemoteException -> L91
            if (r2 == 0) goto L95
            java.lang.Object r2 = r1.next()     // Catch: android.os.RemoteException -> L91
            boolean r3 = r2 instanceof android.os.IBinder     // Catch: android.os.RemoteException -> L91
            if (r3 == 0) goto L83
            android.os.IBinder r2 = (android.os.IBinder) r2     // Catch: android.os.RemoteException -> L91
            com.google.android.gms.internal.ads.zzyl r2 = com.google.android.gms.internal.ads.zzym.zzf(r2)     // Catch: android.os.RemoteException -> L91
            goto L84
        L83:
            r2 = r6
        L84:
            if (r2 == 0) goto L6e
            java.util.List<com.google.android.gms.ads.MuteThisAdReason> r3 = r5.zzdeg     // Catch: android.os.RemoteException -> L91
            com.google.android.gms.internal.ads.zzyo r4 = new com.google.android.gms.internal.ads.zzyo     // Catch: android.os.RemoteException -> L91
            r4.<init>(r2)     // Catch: android.os.RemoteException -> L91
            r3.add(r4)     // Catch: android.os.RemoteException -> L91
            goto L6e
        L91:
            r1 = move-exception
            com.google.android.gms.internal.ads.zzbbd.zzb(r0, r1)
        L95:
            com.google.android.gms.internal.ads.zzaew r1 = r5.zzdeb     // Catch: android.os.RemoteException -> La3
            com.google.android.gms.internal.ads.zzadb r1 = r1.zzsb()     // Catch: android.os.RemoteException -> La3
            if (r1 == 0) goto La7
            com.google.android.gms.internal.ads.zzade r2 = new com.google.android.gms.internal.ads.zzade     // Catch: android.os.RemoteException -> La3
            r2.<init>(r1)     // Catch: android.os.RemoteException -> La3
            goto La8
        La3:
            r1 = move-exception
            com.google.android.gms.internal.ads.zzbbd.zzb(r0, r1)
        La7:
            r2 = r6
        La8:
            r5.zzded = r2
            com.google.android.gms.internal.ads.zzaew r1 = r5.zzdeb     // Catch: android.os.RemoteException -> Lbf
            com.google.android.gms.internal.ads.zzacx r1 = r1.zzse()     // Catch: android.os.RemoteException -> Lbf
            if (r1 == 0) goto Lc3
            com.google.android.gms.internal.ads.zzada r1 = new com.google.android.gms.internal.ads.zzada     // Catch: android.os.RemoteException -> Lbf
            com.google.android.gms.internal.ads.zzaew r2 = r5.zzdeb     // Catch: android.os.RemoteException -> Lbf
            com.google.android.gms.internal.ads.zzacx r2 = r2.zzse()     // Catch: android.os.RemoteException -> Lbf
            r1.<init>(r2)     // Catch: android.os.RemoteException -> Lbf
            r6 = r1
            goto Lc3
        Lbf:
            r1 = move-exception
            com.google.android.gms.internal.ads.zzbbd.zzb(r0, r1)
        Lc3:
            r5.zzdef = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaez.<init>(com.google.android.gms.internal.ads.zzaew):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    /* renamed from: zzsc, reason: merged with bridge method [inline-methods] */
    public final IObjectWrapper zzhy() {
        try {
            return this.zzdeb.zzsc();
        } catch (RemoteException e2) {
            zzbbd.zzb("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void cancelUnconfirmedClick() {
        try {
            this.zzdeb.cancelUnconfirmedClick();
        } catch (RemoteException e2) {
            zzbbd.zzb("Failed to cancelUnconfirmedClick", e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void destroy() {
        try {
            this.zzdeb.destroy();
        } catch (RemoteException e2) {
            zzbbd.zzb("", e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void enableCustomClickGesture() {
        try {
            this.zzdeb.zzsi();
        } catch (RemoteException e2) {
            zzbbd.zzb("", e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final NativeAd.AdChoicesInfo getAdChoicesInfo() {
        return this.zzdef;
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String getAdvertiser() {
        try {
            return this.zzdeb.getAdvertiser();
        } catch (RemoteException e2) {
            zzbbd.zzb("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String getBody() {
        try {
            return this.zzdeb.getBody();
        } catch (RemoteException e2) {
            zzbbd.zzb("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String getCallToAction() {
        try {
            return this.zzdeb.getCallToAction();
        } catch (RemoteException e2) {
            zzbbd.zzb("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final Bundle getExtras() {
        try {
            Bundle extras = this.zzdeb.getExtras();
            if (extras != null) {
                return extras;
            }
        } catch (RemoteException e2) {
            zzbbd.zzb("", e2);
        }
        return new Bundle();
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String getHeadline() {
        try {
            return this.zzdeb.getHeadline();
        } catch (RemoteException e2) {
            zzbbd.zzb("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final NativeAd.Image getIcon() {
        return this.zzded;
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final List<NativeAd.Image> getImages() {
        return this.zzdec;
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String getMediationAdapterClassName() {
        try {
            return this.zzdeb.getMediationAdapterClassName();
        } catch (RemoteException e2) {
            zzbbd.zzb("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final List<MuteThisAdReason> getMuteThisAdReasons() {
        return this.zzdeg;
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String getPrice() {
        try {
            return this.zzdeb.getPrice();
        } catch (RemoteException e2) {
            zzbbd.zzb("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final Double getStarRating() {
        try {
            double starRating = this.zzdeb.getStarRating();
            if (starRating == -1.0d) {
                return null;
            }
            return Double.valueOf(starRating);
        } catch (RemoteException e2) {
            zzbbd.zzb("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String getStore() {
        try {
            return this.zzdeb.getStore();
        } catch (RemoteException e2) {
            zzbbd.zzb("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final VideoController getVideoController() {
        try {
            if (this.zzdeb.getVideoController() != null) {
                this.zzdee.a(this.zzdeb.getVideoController());
            }
        } catch (RemoteException e2) {
            zzbbd.zzb("Exception occurred while getting video controller", e2);
        }
        return this.zzdee;
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final boolean isCustomMuteThisAdEnabled() {
        try {
            return this.zzdeb.isCustomMuteThisAdEnabled();
        } catch (RemoteException e2) {
            zzbbd.zzb("", e2);
            return false;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void muteThisAd(MuteThisAdReason muteThisAdReason) {
        try {
            if (!isCustomMuteThisAdEnabled()) {
                zzbbd.e("Ad is not custom mute enabled");
                return;
            }
            if (muteThisAdReason == null) {
                this.zzdeb.zza((zzyl) null);
            } else if (muteThisAdReason instanceof zzyo) {
                this.zzdeb.zza(((zzyo) muteThisAdReason).zzqe());
            } else {
                zzbbd.e("Use mute reason from UnifiedNativeAd.getMuteThisAdReasons() or null");
            }
        } catch (RemoteException e2) {
            zzbbd.zzb("", e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void performClick(Bundle bundle) {
        try {
            this.zzdeb.performClick(bundle);
        } catch (RemoteException e2) {
            zzbbd.zzb("", e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void recordCustomClickGesture() {
        try {
            this.zzdeb.recordCustomClickGesture();
        } catch (RemoteException e2) {
            zzbbd.zzb("", e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final boolean recordImpression(Bundle bundle) {
        try {
            return this.zzdeb.recordImpression(bundle);
        } catch (RemoteException e2) {
            zzbbd.zzb("", e2);
            return false;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void reportTouchEvent(Bundle bundle) {
        try {
            this.zzdeb.reportTouchEvent(bundle);
        } catch (RemoteException e2) {
            zzbbd.zzb("", e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void setMuteThisAdListener(MuteThisAdListener muteThisAdListener) {
        try {
            this.zzdeb.zza(new zzyk(muteThisAdListener));
        } catch (RemoteException e2) {
            zzbbd.zzb("", e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void setUnconfirmedClickListener(UnifiedNativeAd.UnconfirmedClickListener unconfirmedClickListener) {
        try {
            this.zzdeb.zza(new zzafj(unconfirmedClickListener));
        } catch (RemoteException e2) {
            zzbbd.zzb("Failed to setUnconfirmedClickListener", e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final Object zzic() {
        try {
            IObjectWrapper zzsd = this.zzdeb.zzsd();
            if (zzsd != null) {
                return ObjectWrapper.a(zzsd);
            }
            return null;
        } catch (RemoteException e2) {
            zzbbd.zzb("", e2);
            return null;
        }
    }
}
