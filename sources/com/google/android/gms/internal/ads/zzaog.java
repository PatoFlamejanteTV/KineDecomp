package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

@zzark
/* loaded from: classes2.dex */
public final class zzaog {
    private final boolean zzdpy;
    private final boolean zzdpz;
    private final boolean zzdqa;
    private final boolean zzdqb;
    private final boolean zzdqc;

    /* JADX INFO: Access modifiers changed from: private */
    public zzaog(zzaoi zzaoiVar) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        z = zzaoiVar.zzdpy;
        this.zzdpy = z;
        z2 = zzaoiVar.zzdpz;
        this.zzdpz = z2;
        z3 = zzaoiVar.zzdqa;
        this.zzdqa = z3;
        z4 = zzaoiVar.zzdqb;
        this.zzdqb = z4;
        z5 = zzaoiVar.zzdqc;
        this.zzdqc = z5;
    }

    public final JSONObject zzvn() {
        try {
            return new JSONObject().put("sms", this.zzdpy).put("tel", this.zzdpz).put("calendar", this.zzdqa).put("storePicture", this.zzdqb).put("inlineVideo", this.zzdqc);
        } catch (JSONException e2) {
            zzbbd.zzb("Error occured while obtaining the MRAID capabilities.", e2);
            return null;
        }
    }

    public /* synthetic */ zzaog(zzaoi zzaoiVar, Ob ob) {
        this(zzaoiVar);
    }
}
