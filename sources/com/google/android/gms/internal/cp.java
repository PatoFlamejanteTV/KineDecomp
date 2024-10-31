package com.google.android.gms.internal;

import android.text.TextUtils;
import com.facebook.GraphResponse;
import com.google.android.gms.internal.zzgm;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cp implements zzdk {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzbb f1482a;
    final /* synthetic */ zzgm.a b;
    final /* synthetic */ zzin c;
    final /* synthetic */ zzgm d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cp(zzgm zzgmVar, zzbb zzbbVar, zzgm.a aVar, zzin zzinVar) {
        this.d = zzgmVar;
        this.f1482a = zzbbVar;
        this.b = aVar;
        this.c = zzinVar;
    }

    @Override // com.google.android.gms.internal.zzdk
    public void zza(zziz zzizVar, Map<String, String> map) {
        this.f1482a.zzb("/nativeAdPreProcess", this.b.f1721a);
        try {
            String str = map.get(GraphResponse.SUCCESS_KEY);
            if (!TextUtils.isEmpty(str)) {
                this.c.zzf(new JSONObject(str).getJSONArray("ads").getJSONObject(0));
                return;
            }
        } catch (JSONException e) {
            com.google.android.gms.ads.internal.util.client.zzb.b("Malformed native JSON response.", e);
        }
        this.d.zzC(0);
        com.google.android.gms.common.internal.zzx.a(this.d.zzfD(), "Unable to set the ad state error!");
        this.c.zzf(null);
    }
}
