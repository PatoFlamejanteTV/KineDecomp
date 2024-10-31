package com.google.android.gms.internal.ads;

import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.facebook.share.internal.ShareConstants;
import com.nexstreaming.kinemaster.ui.settings.FragmentC2201x;
import org.json.JSONException;
import org.json.JSONObject;

@zzark
/* loaded from: classes2.dex */
public class zzaok {
    private final zzbgg zzdin;
    private final String zzdqm;

    public zzaok(zzbgg zzbggVar) {
        this(zzbggVar, "");
    }

    public final void zza(int i, int i2, int i3, int i4, float f2, int i5) {
        try {
            this.zzdin.zza("onScreenInfoChanged", new JSONObject().put("width", i).put("height", i2).put("maxSizeWidth", i3).put("maxSizeHeight", i4).put("density", f2).put("rotation", i5));
        } catch (JSONException e2) {
            zzbbd.zzb("Error occured while obtaining screen information.", e2);
        }
    }

    public final void zzb(int i, int i2, int i3, int i4) {
        try {
            this.zzdin.zza("onSizeChanged", new JSONObject().put(FragmentC2201x.f23219a, i).put("y", i2).put("width", i3).put("height", i4));
        } catch (JSONException e2) {
            zzbbd.zzb("Error occured while dispatching size change.", e2);
        }
    }

    public final void zzc(int i, int i2, int i3, int i4) {
        try {
            this.zzdin.zza("onDefaultPositionReceived", new JSONObject().put(FragmentC2201x.f23219a, i).put("y", i2).put("width", i3).put("height", i4));
        } catch (JSONException e2) {
            zzbbd.zzb("Error occured while dispatching default position.", e2);
        }
    }

    public final void zzda(String str) {
        try {
            this.zzdin.zza("onError", new JSONObject().put(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, str).put(NativeProtocol.WEB_DIALOG_ACTION, this.zzdqm));
        } catch (JSONException e2) {
            zzbbd.zzb("Error occurred while dispatching error event.", e2);
        }
    }

    public final void zzdb(String str) {
        try {
            this.zzdin.zza("onReadyEventReceived", new JSONObject().put("js", str));
        } catch (JSONException e2) {
            zzbbd.zzb("Error occured while dispatching ready Event.", e2);
        }
    }

    public final void zzdc(String str) {
        try {
            this.zzdin.zza("onStateChanged", new JSONObject().put(ServerProtocol.DIALOG_PARAM_STATE, str));
        } catch (JSONException e2) {
            zzbbd.zzb("Error occured while dispatching state change.", e2);
        }
    }

    public zzaok(zzbgg zzbggVar, String str) {
        this.zzdin = zzbggVar;
        this.zzdqm = str;
    }
}
