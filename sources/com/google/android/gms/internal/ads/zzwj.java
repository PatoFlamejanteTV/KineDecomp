package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import com.facebook.internal.NativeProtocol;
import java.util.HashMap;

@zzark
/* loaded from: classes2.dex */
public class zzwj {
    private final zzvz zzckr;
    private final zzvy zzcks;
    private final zzzg zzckt;
    private final zzafa zzcku;
    private final zzavf zzckv;
    private final zzawf zzckw;
    private final zzaoo zzckx;
    private final zzafb zzcky;

    public zzwj(zzvz zzvzVar, zzvy zzvyVar, zzzg zzzgVar, zzafa zzafaVar, zzavf zzavfVar, zzawf zzawfVar, zzaoo zzaooVar, zzafb zzafbVar) {
        this.zzckr = zzvzVar;
        this.zzcks = zzvyVar;
        this.zzckt = zzzgVar;
        this.zzcku = zzafaVar;
        this.zzckv = zzavfVar;
        this.zzckw = zzawfVar;
        this.zzckx = zzaooVar;
        this.zzcky = zzafbVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zza(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString(NativeProtocol.WEB_DIALOG_ACTION, "no_ads_fallback");
        bundle.putString("flow", str);
        zzwu.zzpv().zza(context, zzwu.zzqb().zzdp, "gmob-apps", bundle, true);
    }

    public final zzxg zzb(Context context, String str, zzalg zzalgVar) {
        return new pn(this, context, str, zzalgVar).a(context, false);
    }

    public final zzaop zzb(Activity activity) {
        mn mnVar = new mn(this, activity);
        Intent intent = activity.getIntent();
        boolean z = false;
        if (!intent.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar")) {
            zzbbd.e("useClientJar flag not found in activity intent extras.");
        } else {
            z = intent.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false);
        }
        return mnVar.a(activity, z);
    }

    public final zzadf zza(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        return new rn(this, frameLayout, frameLayout2, context).a(context, false);
    }

    public final zzadk zza(View view, HashMap<String, View> hashMap, HashMap<String, View> hashMap2) {
        return new sn(this, view, hashMap, hashMap2).a(view.getContext(), false);
    }
}
