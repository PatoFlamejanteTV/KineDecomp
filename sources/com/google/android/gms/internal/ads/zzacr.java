package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.nexstreaming.kinemaster.ui.settings.FragmentC2201x;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@zzark
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zzacr extends zzadg implements View.OnClickListener, View.OnTouchListener, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, zzacw {

    @VisibleForTesting
    private static final String[] zzdcy = {NativeAppInstallAd.ASSET_MEDIA_VIDEO, NativeContentAd.ASSET_MEDIA_VIDEO, "3010"};

    @VisibleForTesting
    private FrameLayout zzbld;

    @VisibleForTesting
    private zzacd zzdbj;
    private final FrameLayout zzdcz;
    private View zzdda;

    @VisibleForTesting
    private View zzddc;
    private final Object mLock = new Object();

    @VisibleForTesting
    private Map<String, WeakReference<View>> zzddb = Collections.synchronizedMap(new HashMap());

    @VisibleForTesting
    private boolean zzddd = false;

    @VisibleForTesting
    private Point zzdde = new Point();

    @VisibleForTesting
    private Point zzddf = new Point();

    @VisibleForTesting
    private WeakReference<zzsc> zzddg = new WeakReference<>(null);

    @TargetApi(21)
    public zzacr(FrameLayout frameLayout, FrameLayout frameLayout2) {
        this.zzdcz = frameLayout;
        this.zzbld = frameLayout2;
        com.google.android.gms.ads.internal.zzbv.D();
        zzbct.zza((View) this.zzdcz, (ViewTreeObserver.OnGlobalLayoutListener) this);
        com.google.android.gms.ads.internal.zzbv.D();
        zzbct.zza((View) this.zzdcz, (ViewTreeObserver.OnScrollChangedListener) this);
        this.zzdcz.setOnTouchListener(this);
        this.zzdcz.setOnClickListener(this);
        if (frameLayout2 != null && PlatformVersion.h()) {
            frameLayout2.setElevation(Float.MAX_VALUE);
        }
        zzaan.initialize(this.zzdcz.getContext());
    }

    @VisibleForTesting
    private final int zzck(int i) {
        zzwu.zzpv();
        return zzbat.zzb(this.zzdbj.getContext(), i);
    }

    private final void zzm(View view) {
        zzacd zzacdVar = this.zzdbj;
        if (zzacdVar != null) {
            if (zzacdVar instanceof zzacc) {
                zzacdVar = ((zzacc) zzacdVar).zzso();
            }
            if (zzacdVar != null) {
                zzacdVar.zzm(view);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzadf
    public final void destroy() {
        synchronized (this.mLock) {
            if (this.zzbld != null) {
                this.zzbld.removeAllViews();
            }
            this.zzbld = null;
            this.zzddb = null;
            this.zzddc = null;
            this.zzdbj = null;
            this.zzdde = null;
            this.zzddf = null;
            this.zzddg = null;
            this.zzdda = null;
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        synchronized (this.mLock) {
            if (this.zzdbj == null) {
                return;
            }
            this.zzdbj.cancelUnconfirmedClick();
            Bundle bundle = new Bundle();
            bundle.putFloat(FragmentC2201x.f23219a, zzck(this.zzdde.x));
            bundle.putFloat("y", zzck(this.zzdde.y));
            bundle.putFloat("start_x", zzck(this.zzddf.x));
            bundle.putFloat("start_y", zzck(this.zzddf.y));
            if (this.zzddc != null && this.zzddc.equals(view)) {
                if (this.zzdbj instanceof zzacc) {
                    if (((zzacc) this.zzdbj).zzso() != null) {
                        ((zzacc) this.zzdbj).zzso().zza(view, NativeContentAd.ASSET_ATTRIBUTION_ICON_IMAGE, bundle, this.zzddb, this.zzdcz, false);
                    }
                } else {
                    this.zzdbj.zza(view, NativeContentAd.ASSET_ATTRIBUTION_ICON_IMAGE, bundle, this.zzddb, this.zzdcz, false);
                }
            } else {
                this.zzdbj.zza(view, this.zzddb, bundle, this.zzdcz);
            }
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        synchronized (this.mLock) {
            if (this.zzdbj != null) {
                this.zzdbj.zzc(this.zzdcz, this.zzddb);
            }
        }
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        synchronized (this.mLock) {
            if (this.zzdbj != null) {
                this.zzdbj.zzc(this.zzdcz, this.zzddb);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        synchronized (this.mLock) {
            if (this.zzdbj == null) {
                return false;
            }
            this.zzdcz.getLocationOnScreen(new int[2]);
            Point point = new Point((int) (motionEvent.getRawX() - r0[0]), (int) (motionEvent.getRawY() - r0[1]));
            this.zzdde = point;
            if (motionEvent.getAction() == 0) {
                this.zzddf = point;
            }
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            obtain.setLocation(point.x, point.y);
            this.zzdbj.zzd(obtain);
            obtain.recycle();
            return false;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(16:38|(5:40|(3:42|(2:44|(2:47|48)(1:46))|124)|125|49|(17:51|(1:123)(1:54)|55|(3:57|(1:59)|(1:61)(2:62|(1:64)))|65|(1:67)|68|(1:70)|71|72|(1:76)|77|17e|94|(3:102|(1:104)|105)|106|107))|126|(0)|123|55|(0)|65|(0)|68|(0)|71|72|(2:74|76)|77|17e) */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0157, code lost:            r2 = move-exception;     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0158, code lost:            com.google.android.gms.ads.internal.zzbv.g();     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x015f, code lost:            if (com.google.android.gms.internal.ads.zzayp.zzaaa() != false) goto L80;     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x0161, code lost:            com.google.android.gms.internal.ads.zzbbd.zzeo("Privileged processes cannot create HTML overlays.");     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x016c, code lost:            r2 = null;     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0167, code lost:            com.google.android.gms.internal.ads.zzbbd.zzb("Error obtaining overlay.", r2);     */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00df A[Catch: all -> 0x021a, TryCatch #2 {, blocks: (B:5:0x0004, B:7:0x000f, B:8:0x0014, B:11:0x0016, B:13:0x001f, B:14:0x0028, B:16:0x002f, B:18:0x0035, B:20:0x003b, B:22:0x004b, B:24:0x0051, B:25:0x0054, B:28:0x0060, B:29:0x0063, B:31:0x0069, B:33:0x0073, B:34:0x0087, B:36:0x008b, B:38:0x008d, B:40:0x009d, B:42:0x00a1, B:44:0x00af, B:48:0x00bb, B:49:0x00c6, B:51:0x00ca, B:55:0x00d4, B:57:0x00df, B:59:0x00e3, B:61:0x00f3, B:62:0x00fc, B:64:0x0116, B:65:0x011b, B:67:0x012a, B:68:0x0141, B:70:0x014b, B:72:0x0152, B:118:0x0158, B:120:0x0161, B:122:0x0167, B:74:0x016f, B:76:0x0173, B:77:0x017c, B:78:0x017e, B:94:0x01ba, B:96:0x01d4, B:98:0x01da, B:100:0x01e0, B:102:0x01f0, B:104:0x01fa, B:105:0x020e, B:106:0x0215, B:115:0x0219, B:46:0x00c2, B:127:0x007b, B:129:0x0081, B:80:0x017f, B:82:0x0188, B:84:0x018d, B:88:0x0199, B:86:0x01a0, B:90:0x01a3, B:92:0x01a7, B:108:0x01a9, B:110:0x01b2, B:111:0x01b9, B:112:0x01b6), top: B:4:0x0004, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x012a A[Catch: all -> 0x021a, TryCatch #2 {, blocks: (B:5:0x0004, B:7:0x000f, B:8:0x0014, B:11:0x0016, B:13:0x001f, B:14:0x0028, B:16:0x002f, B:18:0x0035, B:20:0x003b, B:22:0x004b, B:24:0x0051, B:25:0x0054, B:28:0x0060, B:29:0x0063, B:31:0x0069, B:33:0x0073, B:34:0x0087, B:36:0x008b, B:38:0x008d, B:40:0x009d, B:42:0x00a1, B:44:0x00af, B:48:0x00bb, B:49:0x00c6, B:51:0x00ca, B:55:0x00d4, B:57:0x00df, B:59:0x00e3, B:61:0x00f3, B:62:0x00fc, B:64:0x0116, B:65:0x011b, B:67:0x012a, B:68:0x0141, B:70:0x014b, B:72:0x0152, B:118:0x0158, B:120:0x0161, B:122:0x0167, B:74:0x016f, B:76:0x0173, B:77:0x017c, B:78:0x017e, B:94:0x01ba, B:96:0x01d4, B:98:0x01da, B:100:0x01e0, B:102:0x01f0, B:104:0x01fa, B:105:0x020e, B:106:0x0215, B:115:0x0219, B:46:0x00c2, B:127:0x007b, B:129:0x0081, B:80:0x017f, B:82:0x0188, B:84:0x018d, B:88:0x0199, B:86:0x01a0, B:90:0x01a3, B:92:0x01a7, B:108:0x01a9, B:110:0x01b2, B:111:0x01b9, B:112:0x01b6), top: B:4:0x0004, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x014b A[Catch: all -> 0x021a, TRY_LEAVE, TryCatch #2 {, blocks: (B:5:0x0004, B:7:0x000f, B:8:0x0014, B:11:0x0016, B:13:0x001f, B:14:0x0028, B:16:0x002f, B:18:0x0035, B:20:0x003b, B:22:0x004b, B:24:0x0051, B:25:0x0054, B:28:0x0060, B:29:0x0063, B:31:0x0069, B:33:0x0073, B:34:0x0087, B:36:0x008b, B:38:0x008d, B:40:0x009d, B:42:0x00a1, B:44:0x00af, B:48:0x00bb, B:49:0x00c6, B:51:0x00ca, B:55:0x00d4, B:57:0x00df, B:59:0x00e3, B:61:0x00f3, B:62:0x00fc, B:64:0x0116, B:65:0x011b, B:67:0x012a, B:68:0x0141, B:70:0x014b, B:72:0x0152, B:118:0x0158, B:120:0x0161, B:122:0x0167, B:74:0x016f, B:76:0x0173, B:77:0x017c, B:78:0x017e, B:94:0x01ba, B:96:0x01d4, B:98:0x01da, B:100:0x01e0, B:102:0x01f0, B:104:0x01fa, B:105:0x020e, B:106:0x0215, B:115:0x0219, B:46:0x00c2, B:127:0x007b, B:129:0x0081, B:80:0x017f, B:82:0x0188, B:84:0x018d, B:88:0x0199, B:86:0x01a0, B:90:0x01a3, B:92:0x01a7, B:108:0x01a9, B:110:0x01b2, B:111:0x01b9, B:112:0x01b6), top: B:4:0x0004, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x017f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzadf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zza(com.google.android.gms.dynamic.IObjectWrapper r12) {
        /*
            Method dump skipped, instructions count: 543
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzacr.zza(com.google.android.gms.dynamic.IObjectWrapper):void");
    }

    @Override // com.google.android.gms.internal.ads.zzadf
    public final void zzb(String str, IObjectWrapper iObjectWrapper) {
        View view = (View) ObjectWrapper.a(iObjectWrapper);
        synchronized (this.mLock) {
            if (this.zzddb == null) {
                return;
            }
            if (view == null) {
                this.zzddb.remove(str);
            } else {
                this.zzddb.put(str, new WeakReference<>(view));
                if (!NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW.equals(str) && !"3011".equals(str)) {
                    view.setOnTouchListener(this);
                    view.setClickable(true);
                    view.setOnClickListener(this);
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzadf
    public final IObjectWrapper zzbm(String str) {
        synchronized (this.mLock) {
            View view = null;
            if (this.zzddb == null) {
                return null;
            }
            WeakReference<View> weakReference = this.zzddb.get(str);
            if (weakReference != null) {
                view = weakReference.get();
            }
            return ObjectWrapper.a(view);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzadf
    public final void zzc(IObjectWrapper iObjectWrapper) {
        this.zzdbj.setClickConfirmingView((View) ObjectWrapper.a(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzacw
    public final synchronized Map<String, WeakReference<View>> zzsv() {
        return this.zzddb;
    }

    @Override // com.google.android.gms.internal.ads.zzacw
    public final View zzsw() {
        return this.zzdcz;
    }

    @Override // com.google.android.gms.internal.ads.zzadf
    public final void zzb(IObjectWrapper iObjectWrapper, int i) {
        WeakReference<zzsc> weakReference;
        zzsc zzscVar;
        if (!com.google.android.gms.ads.internal.zzbv.E().zzv(this.zzdcz.getContext()) || (weakReference = this.zzddg) == null || (zzscVar = weakReference.get()) == null) {
            return;
        }
        zzscVar.zznh();
    }
}
