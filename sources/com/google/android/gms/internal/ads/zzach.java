package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.nexstreaming.kinemaster.ui.settings.FragmentC2201x;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

@zzark
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public class zzach implements zzacd {
    private final Context mContext;
    private final zzbbi zzbob;
    private zzawv zzbor;
    private final zzaqp zzbqa;
    private String zzbqb;
    private final zzace zzdby;
    private final zzabn zzdcc;
    private final JSONObject zzdcd;
    private final zzacf zzdce;
    private final zzcu zzdcf;

    @VisibleForTesting
    boolean zzdcg;

    @VisibleForTesting
    boolean zzdch;
    private zzacw zzdci;
    private final Object mLock = new Object();
    private boolean zzdcb = false;
    private long zzdcj = 0;
    private long zzdck = 0;
    private WeakReference<View> zzdcl = null;

    public zzach(Context context, zzace zzaceVar, zzaqp zzaqpVar, zzcu zzcuVar, JSONObject jSONObject, zzacf zzacfVar, zzbbi zzbbiVar, String str) {
        this.mContext = context;
        this.zzdby = zzaceVar;
        this.zzbqa = zzaqpVar;
        this.zzdcf = zzcuVar;
        this.zzdcd = jSONObject;
        this.zzdce = zzacfVar;
        this.zzbob = zzbbiVar;
        this.zzbqb = str;
        this.zzdcc = new zzabn(this.zzbqa);
    }

    private final boolean zzbs(String str) {
        JSONObject jSONObject = this.zzdcd;
        JSONObject optJSONObject = jSONObject == null ? null : jSONObject.optJSONObject("allow_pub_event_reporting");
        if (optJSONObject == null) {
            return false;
        }
        return optJSONObject.optBoolean(str, false);
    }

    @VisibleForTesting
    private final int zzck(int i) {
        zzwu.zzpv();
        return zzbat.zzb(this.mContext, i);
    }

    private static boolean zzn(View view) {
        return view.isShown() && view.getGlobalVisibleRect(new Rect(), null);
    }

    @VisibleForTesting
    private static int[] zzo(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr;
    }

    private final JSONObject zzp(View view) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        if (view == null) {
            return jSONObject2;
        }
        try {
            int[] zzo = zzo(view);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("width", zzck(view.getMeasuredWidth()));
            jSONObject3.put("height", zzck(view.getMeasuredHeight()));
            jSONObject3.put(FragmentC2201x.f23219a, zzck(zzo[0]));
            jSONObject3.put("y", zzck(zzo[1]));
            jSONObject3.put("relative_to", "window");
            jSONObject2.put("frame", jSONObject3);
            Rect rect = new Rect();
            if (view.getGlobalVisibleRect(rect)) {
                jSONObject = zzb(rect);
            } else {
                jSONObject = new JSONObject();
                jSONObject.put("width", 0);
                jSONObject.put("height", 0);
                jSONObject.put(FragmentC2201x.f23219a, zzck(zzo[0]));
                jSONObject.put("y", zzck(zzo[1]));
                jSONObject.put("relative_to", "window");
            }
            jSONObject2.put("visible_bounds", jSONObject);
        } catch (Exception unused) {
            zzbbd.zzeo("Unable to get native ad view bounding box");
        }
        return jSONObject2;
    }

    private static JSONObject zzq(View view) {
        JSONObject jSONObject = new JSONObject();
        if (view == null) {
            return jSONObject;
        }
        try {
            com.google.android.gms.ads.internal.zzbv.e();
            jSONObject.put("contained_in_scroll_view", zzayh.zzy(view) != -1);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private final JSONObject zzr(View view) {
        JSONObject jSONObject = new JSONObject();
        if (view == null) {
            return jSONObject;
        }
        try {
            com.google.android.gms.ads.internal.zzbv.e();
            jSONObject.put("can_show_on_lock_screen", zzayh.zzx(view));
            com.google.android.gms.ads.internal.zzbv.e();
            jSONObject.put("is_keyguard_locked", zzayh.zzau(this.mContext));
        } catch (JSONException unused) {
            zzbbd.zzeo("Unable to get lock screen information");
        }
        return jSONObject;
    }

    @Override // com.google.android.gms.internal.ads.zzacd
    public void cancelUnconfirmedClick() {
        if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcuo)).booleanValue() && this.zzdcd.optBoolean("custom_one_point_five_click_enabled", false)) {
            this.zzdcc.cancelUnconfirmedClick();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzacd
    public final Context getContext() {
        return this.mContext;
    }

    @Override // com.google.android.gms.internal.ads.zzacd
    public final void performClick(Bundle bundle) {
        if (bundle == null) {
            zzbbd.zzdn("Click data is null. No click is reported.");
        } else if (!zzbs("click_reporting")) {
            zzbbd.e("The ad slot cannot handle external click events. You must be whitelisted to be able to report your click events.");
        } else {
            zza(null, null, null, null, null, bundle.getBundle("click_signal").getString("asset_id"), null, com.google.android.gms.ads.internal.zzbv.e().zza(bundle, (JSONObject) null), false);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzacd
    public void recordCustomClickGesture() {
        if (this.zzdci == null) {
            zzbbd.zzdn("Ad should be associated with an ad view before calling recordCustomClickGesture()");
            return;
        }
        if (!this.zzdcb) {
            zzbbd.zzdn("Custom click reporting failed. enableCustomClickGesture is not set.");
        } else if (!zzsk()) {
            zzbbd.zzdn("Custom click reporting failed. Ad unit id not whitelisted.");
        } else {
            zza(this.zzdci.zzsw(), "3099", null, this.zzdci.zzsv(), this.zzdci.zzsw(), true);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzacd
    public final boolean recordImpression(Bundle bundle) {
        if (!zzbs("impression_reporting")) {
            zzbbd.e("The ad slot cannot handle external impression events. You must be whitelisted to whitelisted to be able to report your impression events.");
            return false;
        }
        return zza((JSONObject) null, (JSONObject) null, (JSONObject) null, (JSONObject) null, com.google.android.gms.ads.internal.zzbv.e().zza(bundle, (JSONObject) null));
    }

    @Override // com.google.android.gms.internal.ads.zzacd
    public final void reportTouchEvent(Bundle bundle) {
        if (bundle == null) {
            zzbbd.zzdn("Touch event data is null. No touch event is reported.");
            return;
        }
        if (!zzbs("touch_reporting")) {
            zzbbd.e("The ad slot cannot handle external touch events. You must be whitelisted to be able to report your touch events.");
            return;
        }
        this.zzdcf.zzab().zza((int) bundle.getFloat(FragmentC2201x.f23219a), (int) bundle.getFloat("y"), bundle.getInt("duration_ms"));
    }

    @Override // com.google.android.gms.internal.ads.zzacd
    public void setClickConfirmingView(View view) {
        if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcuo)).booleanValue()) {
            if (!this.zzdcd.optBoolean("custom_one_point_five_click_enabled", false)) {
                zzbbd.zzeo("setClickConfirmingView: Your account need to be whitelisted to use this feature.\nContact your account manager for more information.");
                return;
            }
            zzabn zzabnVar = this.zzdcc;
            if (view != null) {
                view.setOnClickListener(zzabnVar);
                view.setClickable(true);
                zzabnVar.zzdam = new WeakReference<>(view);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzacd
    public View zza(View.OnClickListener onClickListener, boolean z) {
        zzabm zzrw = this.zzdce.zzrw();
        if (zzrw == null) {
            return null;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (!z) {
            int zzrr = zzrw.zzrr();
            if (zzrr == 0) {
                layoutParams.addRule(10);
                layoutParams.addRule(9);
            } else if (zzrr == 2) {
                layoutParams.addRule(12);
                layoutParams.addRule(11);
            } else if (zzrr != 3) {
                layoutParams.addRule(10);
                layoutParams.addRule(11);
            } else {
                layoutParams.addRule(12);
                layoutParams.addRule(9);
            }
        }
        zzabp zzabpVar = new zzabp(this.mContext, zzrw, layoutParams);
        zzabpVar.setOnClickListener(onClickListener);
        zzabpVar.setContentDescription((CharSequence) zzwu.zzpz().zzd(zzaan.zzcuj));
        return zzabpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzacd
    public void zzb(View view, Map<String, WeakReference<View>> map) {
    }

    public final boolean zzb(View view, zzacb zzacbVar) {
        FrameLayout.LayoutParams layoutParams;
        if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcum)).booleanValue()) {
            layoutParams = new FrameLayout.LayoutParams(-1, -1, 17);
        } else {
            layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        }
        View zzrx = this.zzdce.zzrx();
        if (zzrx == null) {
            return false;
        }
        ViewParent parent = zzrx.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(zzrx);
        }
        FrameLayout frameLayout = (FrameLayout) view;
        frameLayout.removeAllViews();
        frameLayout.addView(zzrx, layoutParams);
        this.zzdby.zza(zzacbVar);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzacd
    public final void zzc(View view, Map<String, WeakReference<View>> map) {
        synchronized (this.mLock) {
            if (this.zzdcg) {
                return;
            }
            if (zzn(view)) {
                zza(view, map);
                return;
            }
            if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcun)).booleanValue() && map != null) {
                synchronized (map) {
                    Iterator<Map.Entry<String, WeakReference<View>>> it = map.entrySet().iterator();
                    while (it.hasNext()) {
                        View view2 = it.next().getValue().get();
                        if (view2 != null && zzn(view2)) {
                            zza(view, map);
                            return;
                        }
                    }
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzacd
    public void zzd(MotionEvent motionEvent) {
        this.zzdcj = com.google.android.gms.ads.internal.zzbv.l().a();
        if (motionEvent.getAction() == 0) {
            this.zzdck = com.google.android.gms.ads.internal.zzbv.l().a();
        }
        this.zzdcf.zza(motionEvent);
    }

    public final void zzf(Map<String, WeakReference<View>> map) {
        if (this.zzdce.zzrx() != null) {
            boolean z = true;
            if ("2".equals(this.zzdce.zzrv())) {
                zzayb zzyq = com.google.android.gms.ads.internal.zzbv.i().zzyq();
                String adUnitId = this.zzdby.getAdUnitId();
                String zzrv = this.zzdce.zzrv();
                if (map == null || (!map.containsKey(NativeAppInstallAd.ASSET_MEDIA_VIDEO) && !map.containsKey("3010"))) {
                    z = false;
                }
                zzyq.zzb(adUnitId, zzrv, z);
                return;
            }
            if ("1".equals(this.zzdce.zzrv())) {
                zzayb zzyq2 = com.google.android.gms.ads.internal.zzbv.i().zzyq();
                String adUnitId2 = this.zzdby.getAdUnitId();
                String zzrv2 = this.zzdce.zzrv();
                if (map == null || (!map.containsKey(NativeContentAd.ASSET_MEDIA_VIDEO) && !map.containsKey("3010"))) {
                    z = false;
                }
                zzyq2.zzb(adUnitId2, zzrv2, z);
            }
        }
    }

    public final void zzi(View view) {
        this.zzdby.zzi(view);
    }

    @Override // com.google.android.gms.internal.ads.zzacd
    public final void zzj(View view) {
        zzcu zzcuVar;
        zzcq zzab;
        if (!((Boolean) zzwu.zzpz().zzd(zzaan.zzctk)).booleanValue() || (zzcuVar = this.zzdcf) == null || (zzab = zzcuVar.zzab()) == null) {
            return;
        }
        zzab.zzb(view);
    }

    @Override // com.google.android.gms.internal.ads.zzacd
    public void zzjl() {
        this.zzdby.zzjl();
    }

    @Override // com.google.android.gms.internal.ads.zzacd
    public void zzjm() {
        this.zzdby.zzjm();
    }

    @Override // com.google.android.gms.internal.ads.zzacd
    public final void zzm(View view) {
        this.zzdcl = new WeakReference<>(view);
    }

    @Override // com.google.android.gms.internal.ads.zzacd
    public void zzsi() {
        this.zzdcb = true;
    }

    @Override // com.google.android.gms.internal.ads.zzacd
    public boolean zzsj() {
        zzabm zzrw = this.zzdce.zzrw();
        return zzrw != null && zzrw.zzrs();
    }

    @Override // com.google.android.gms.internal.ads.zzacd
    public boolean zzsk() {
        JSONObject jSONObject = this.zzdcd;
        return jSONObject != null && jSONObject.optBoolean("allow_custom_click_gesture", false);
    }

    @Override // com.google.android.gms.internal.ads.zzacd
    public boolean zzsl() {
        JSONObject jSONObject = this.zzdcd;
        return jSONObject != null && jSONObject.optBoolean("allow_pub_owned_ad_view", false);
    }

    @Override // com.google.android.gms.internal.ads.zzacd
    public void zzsm() {
        Preconditions.a("Invalid call from a non-UI thread.");
        if (this.zzdch) {
            return;
        }
        this.zzdch = true;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(com.umeng.commonsdk.proguard.e.an, this.zzdcd);
            jSONObject.put("ads_id", this.zzbqb);
            zzbbo.zza(this.zzbqa.zzk(jSONObject), "NativeAdEngineImpl.recordDownloadedImpression");
        } catch (JSONException e2) {
            zzbbd.zzb("", e2);
        }
    }

    public zzbgg zzsp() throws zzbgq {
        JSONObject jSONObject = this.zzdcd;
        if (jSONObject == null || jSONObject.optJSONObject("overlay") == null) {
            return null;
        }
        com.google.android.gms.ads.internal.zzbv.f();
        Context context = this.mContext;
        zzwf zzg = zzwf.zzg(context);
        zzbgg zza = zzbgm.zza(context, zzbht.zzb(zzg), zzg.zzckk, false, false, this.zzdcf, this.zzbob, null, null, null, zzum.zzoi());
        if (zza != null) {
            zza.getView().setVisibility(8);
            new C1075s(zza).a(this.zzbqa);
        }
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzacd
    public void zzsq() {
        this.zzbqa.zzug();
    }

    @Override // com.google.android.gms.internal.ads.zzacd
    public void zzsr() {
        this.zzdby.zzjn();
    }

    @Override // com.google.android.gms.internal.ads.zzacd
    public final View zzss() {
        WeakReference<View> weakReference = this.zzdcl;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public final zzacw zzst() {
        return this.zzdci;
    }

    public final zzawv zzsu() {
        if (!com.google.android.gms.ads.internal.zzbv.E().zzv(this.mContext)) {
            return null;
        }
        if (this.zzbor == null) {
            this.zzbor = new zzawv(this.mContext, this.zzdby.getAdUnitId());
        }
        return this.zzbor;
    }

    private final JSONObject zzb(Rect rect) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("width", zzck(rect.right - rect.left));
        jSONObject.put("height", zzck(rect.bottom - rect.top));
        jSONObject.put(FragmentC2201x.f23219a, zzck(rect.left));
        jSONObject.put("y", zzck(rect.top));
        jSONObject.put("relative_to", "self");
        return jSONObject;
    }

    @Override // com.google.android.gms.internal.ads.zzacd
    public final void zza(View view, String str, Bundle bundle, Map<String, WeakReference<View>> map, View view2, boolean z) {
        JSONObject jSONObject;
        JSONObject zza = zza(map, view2);
        JSONObject zzp = zzp(view2);
        JSONObject zzq = zzq(view2);
        JSONObject zzr = zzr(view2);
        JSONObject jSONObject2 = null;
        try {
            JSONObject zza2 = com.google.android.gms.ads.internal.zzbv.e().zza(bundle, (JSONObject) null);
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("click_point", zza2);
                try {
                    jSONObject3.put("asset_id", str);
                    jSONObject = jSONObject3;
                } catch (Exception e2) {
                    e = e2;
                    jSONObject2 = jSONObject3;
                    zzbbd.zzb("Error occurred while grabbing click signals.", e);
                    jSONObject = jSONObject2;
                    zza(view, zzp, zza, zzq, zzr, str, jSONObject, null, z);
                }
            } catch (Exception e3) {
                e = e3;
            }
        } catch (Exception e4) {
            e = e4;
        }
        zza(view, zzp, zza, zzq, zzr, str, jSONObject, null, z);
    }

    @Override // com.google.android.gms.internal.ads.zzacd
    public void zza(View view, Map<String, WeakReference<View>> map, Bundle bundle, View view2) {
        Preconditions.a("Invalid call from a non-UI thread.");
        if (map != null) {
            synchronized (map) {
                for (Map.Entry<String, WeakReference<View>> entry : map.entrySet()) {
                    if (view.equals(entry.getValue().get())) {
                        zza(view, entry.getKey(), bundle, map, view2, false);
                        return;
                    }
                }
            }
        }
        if ("6".equals(this.zzdce.zzrv())) {
            zza(view, "3099", bundle, map, view2, false);
        } else if ("2".equals(this.zzdce.zzrv())) {
            zza(view, "2099", bundle, map, view2, false);
        } else if ("1".equals(this.zzdce.zzrv())) {
            zza(view, "1099", bundle, map, view2, false);
        }
    }

    private final void zza(View view, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, String str, JSONObject jSONObject5, JSONObject jSONObject6, boolean z) {
        Preconditions.a("Invalid call from a non-UI thread.");
        try {
            JSONObject jSONObject7 = new JSONObject();
            jSONObject7.put(com.umeng.commonsdk.proguard.e.an, this.zzdcd);
            if (jSONObject2 != null) {
                jSONObject7.put("asset_view_signal", jSONObject2);
            }
            if (jSONObject != null) {
                jSONObject7.put("ad_view_signal", jSONObject);
            }
            if (jSONObject5 != null) {
                jSONObject7.put("click_signal", jSONObject5);
            }
            if (jSONObject3 != null) {
                jSONObject7.put("scroll_view_signal", jSONObject3);
            }
            if (jSONObject4 != null) {
                jSONObject7.put("lock_screen_signal", jSONObject4);
            }
            JSONObject jSONObject8 = new JSONObject();
            long a2 = com.google.android.gms.ads.internal.zzbv.l().a();
            jSONObject8.put("time_from_last_touch_down", a2 - this.zzdck);
            jSONObject8.put("time_from_last_touch", a2 - this.zzdcj);
            jSONObject7.put("touch_signal", jSONObject8);
            JSONObject jSONObject9 = new JSONObject();
            jSONObject9.put("asset_id", str);
            jSONObject9.put(MessengerShareContentUtility.ATTACHMENT_TEMPLATE_TYPE, this.zzdce.zzrv());
            com.google.android.gms.ads.internal.zzbv.g();
            jSONObject9.put("is_privileged_process", zzayp.zzaaa());
            if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcuo)).booleanValue() && this.zzdcc.zzrt() != null && this.zzdcd.optBoolean("custom_one_point_five_click_enabled", false)) {
                jSONObject9.put("custom_one_point_five_click_eligible", true);
            }
            jSONObject9.put("timestamp", a2);
            jSONObject9.put("has_custom_click_handler", this.zzdby.zzar(this.zzdce.getCustomTemplateId()) != null);
            if (this.zzdcb && zzsk()) {
                jSONObject9.put("custom_click_gesture_eligible", true);
            }
            if (z) {
                jSONObject9.put("is_custom_click_gesture", true);
            }
            jSONObject7.put("has_custom_click_handler", this.zzdby.zzar(this.zzdce.getCustomTemplateId()) != null);
            try {
                JSONObject optJSONObject = this.zzdcd.optJSONObject("tracking_urls_and_actions");
                if (optJSONObject == null) {
                    optJSONObject = new JSONObject();
                }
                jSONObject9.put("click_signals", this.zzdcf.zzab().zza(this.mContext, optJSONObject.optString("click_string"), view));
            } catch (Exception e2) {
                zzbbd.zzb("Exception obtaining click signals", e2);
            }
            jSONObject7.put("click", jSONObject9);
            if (jSONObject6 != null) {
                jSONObject7.put("provided_signals", jSONObject6);
            }
            jSONObject7.put("ads_id", this.zzbqb);
            zzbbo.zza(this.zzbqa.zzi(jSONObject7), "NativeAdEngineImpl.performClick");
        } catch (JSONException e3) {
            zzbbd.zzb("Unable to create click JSON.", e3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzacd
    public void zza(View view, Map<String, WeakReference<View>> map) {
        zza(zzp(view), zza(map, view), zzq(view), zzr(view), (JSONObject) null);
    }

    private final boolean zza(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, JSONObject jSONObject5) {
        Preconditions.a("Invalid call from a non-UI thread.");
        if (this.zzdcg) {
            return true;
        }
        this.zzdcg = true;
        try {
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put(com.umeng.commonsdk.proguard.e.an, this.zzdcd);
            jSONObject6.put("ads_id", this.zzbqb);
            if (jSONObject2 != null) {
                jSONObject6.put("asset_view_signal", jSONObject2);
            }
            if (jSONObject != null) {
                jSONObject6.put("ad_view_signal", jSONObject);
            }
            if (jSONObject3 != null) {
                jSONObject6.put("scroll_view_signal", jSONObject3);
            }
            if (jSONObject4 != null) {
                jSONObject6.put("lock_screen_signal", jSONObject4);
            }
            if (jSONObject5 != null) {
                jSONObject6.put("provided_signals", jSONObject5);
            }
            zzbbo.zza(this.zzbqa.zzj(jSONObject6), "NativeAdEngineImpl.recordImpression");
            this.zzdby.zza(this);
            this.zzdby.zziq();
            zzjl();
            return true;
        } catch (JSONException e2) {
            zzbbd.zzb("Unable to create impression JSON.", e2);
            return false;
        }
    }

    public void zza(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, View.OnTouchListener onTouchListener, View.OnClickListener onClickListener) {
        view.setOnTouchListener(onTouchListener);
        view.setClickable(true);
        view.setOnClickListener(onClickListener);
        if (map != null) {
            synchronized (map) {
                Iterator<Map.Entry<String, WeakReference<View>>> it = map.entrySet().iterator();
                while (it.hasNext()) {
                    View view2 = it.next().getValue().get();
                    if (view2 != null) {
                        view2.setOnTouchListener(onTouchListener);
                        view2.setClickable(true);
                        view2.setOnClickListener(onClickListener);
                    }
                }
            }
        }
        if (map2 != null) {
            synchronized (map2) {
                Iterator<Map.Entry<String, WeakReference<View>>> it2 = map2.entrySet().iterator();
                while (it2.hasNext()) {
                    View view3 = it2.next().getValue().get();
                    if (view3 != null) {
                        view3.setOnTouchListener(onTouchListener);
                    }
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzacd
    public final void zza(View view, zzacb zzacbVar) {
        if (zzb(view, zzacbVar)) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        ((FrameLayout) view).removeAllViews();
        zzacf zzacfVar = this.zzdce;
        if (zzacfVar instanceof zzacg) {
            zzacg zzacgVar = (zzacg) zzacfVar;
            if (zzacgVar.getImages() == null || zzacgVar.getImages().size() <= 0) {
                return;
            }
            Object obj = zzacgVar.getImages().get(0);
            zzadb zzj = obj instanceof IBinder ? zzadc.zzj((IBinder) obj) : null;
            if (zzj != null) {
                try {
                    IObjectWrapper zzsa = zzj.zzsa();
                    if (zzsa != null) {
                        Drawable drawable = (Drawable) ObjectWrapper.a(zzsa);
                        ImageView imageView = new ImageView(this.mContext);
                        imageView.setImageDrawable(drawable);
                        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                        ((FrameLayout) view).addView(imageView, layoutParams);
                    }
                } catch (RemoteException unused) {
                    zzbbd.zzeo("Could not get drawable from image");
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzacd
    public void zza(zzaet zzaetVar) {
        if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcuo)).booleanValue()) {
            if (!this.zzdcd.optBoolean("custom_one_point_five_click_enabled", false)) {
                zzbbd.zzeo("setUnconfirmedClickListener: Your account need to be whitelisted to use this feature.\nContact your account manager for more information.");
            } else {
                this.zzdcc.zza(zzaetVar);
            }
        }
    }

    public final void zza(zzacw zzacwVar) {
        this.zzdci = zzacwVar;
    }

    private final JSONObject zza(Map<String, WeakReference<View>> map, View view) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        if (map == null || view == null) {
            return jSONObject2;
        }
        int[] zzo = zzo(view);
        synchronized (map) {
            for (Map.Entry<String, WeakReference<View>> entry : map.entrySet()) {
                View view2 = entry.getValue().get();
                if (view2 != null) {
                    int[] zzo2 = zzo(view2);
                    JSONObject jSONObject3 = new JSONObject();
                    JSONObject jSONObject4 = new JSONObject();
                    try {
                        jSONObject4.put("width", zzck(view2.getMeasuredWidth()));
                        jSONObject4.put("height", zzck(view2.getMeasuredHeight()));
                        jSONObject4.put(FragmentC2201x.f23219a, zzck(zzo2[0] - zzo[0]));
                        jSONObject4.put("y", zzck(zzo2[1] - zzo[1]));
                        jSONObject4.put("relative_to", "ad_view");
                        jSONObject3.put("frame", jSONObject4);
                        Rect rect = new Rect();
                        if (view2.getLocalVisibleRect(rect)) {
                            jSONObject = zzb(rect);
                        } else {
                            JSONObject jSONObject5 = new JSONObject();
                            jSONObject5.put("width", 0);
                            jSONObject5.put("height", 0);
                            jSONObject5.put(FragmentC2201x.f23219a, zzck(zzo2[0] - zzo[0]));
                            jSONObject5.put("y", zzck(zzo2[1] - zzo[1]));
                            jSONObject5.put("relative_to", "ad_view");
                            jSONObject = jSONObject5;
                        }
                        jSONObject3.put("visible_bounds", jSONObject);
                        if (view2 instanceof TextView) {
                            TextView textView = (TextView) view2;
                            jSONObject3.put("text_color", textView.getCurrentTextColor());
                            jSONObject3.put("font_size", textView.getTextSize());
                            jSONObject3.put("text", textView.getText());
                        }
                        jSONObject2.put(entry.getKey(), jSONObject3);
                    } catch (JSONException unused) {
                        zzbbd.zzeo("Unable to get asset views information");
                    }
                }
            }
        }
        return jSONObject2;
    }
}
