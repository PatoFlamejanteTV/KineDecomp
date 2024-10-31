package com.google.android.gms.internal;

import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ShareConstants;
import org.json.JSONException;
import org.json.JSONObject;

@zzgr
/* loaded from: classes.dex */
public class zzfh {
    private final String zzAK;
    private final zziz zzoM;

    public zzfh(zziz zzizVar) {
        this(zzizVar, "");
    }

    public zzfh(zziz zzizVar, String str) {
        this.zzoM = zzizVar;
        this.zzAK = str;
    }

    public void zza(int i, int i2, int i3, int i4, float f, int i5) {
        try {
            this.zzoM.zzb("onScreenInfoChanged", new JSONObject().put("width", i).put("height", i2).put("maxSizeWidth", i3).put("maxSizeHeight", i4).put("density", f).put("rotation", i5));
        } catch (JSONException e) {
            com.google.android.gms.ads.internal.util.client.zzb.b("Error occured while obtaining screen information.", e);
        }
    }

    public void zzak(String str) {
        try {
            this.zzoM.zzb("onError", new JSONObject().put(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, str).put(NativeProtocol.WEB_DIALOG_ACTION, this.zzAK));
        } catch (JSONException e) {
            com.google.android.gms.ads.internal.util.client.zzb.b("Error occurred while dispatching error event.", e);
        }
    }

    public void zzal(String str) {
        try {
            this.zzoM.zzb("onReadyEventReceived", new JSONObject().put("js", str));
        } catch (JSONException e) {
            com.google.android.gms.ads.internal.util.client.zzb.b("Error occured while dispatching ready Event.", e);
        }
    }

    public void zzam(String str) {
        try {
            this.zzoM.zzb("onStateChanged", new JSONObject().put("state", str));
        } catch (JSONException e) {
            com.google.android.gms.ads.internal.util.client.zzb.b("Error occured while dispatching state change.", e);
        }
    }

    public void zzb(int i, int i2, int i3, int i4) {
        try {
            this.zzoM.zzb("onSizeChanged", new JSONObject().put("x", i).put("y", i2).put("width", i3).put("height", i4));
        } catch (JSONException e) {
            com.google.android.gms.ads.internal.util.client.zzb.b("Error occured while dispatching size change.", e);
        }
    }

    public void zzc(int i, int i2, int i3, int i4) {
        try {
            this.zzoM.zzb("onDefaultPositionReceived", new JSONObject().put("x", i).put("y", i2).put("width", i3).put("height", i4));
        } catch (JSONException e) {
            com.google.android.gms.ads.internal.util.client.zzb.b("Error occured while dispatching default position.", e);
        }
    }
}
