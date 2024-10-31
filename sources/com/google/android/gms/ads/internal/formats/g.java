package com.google.android.gms.ads.internal.formats;

import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzbb;
import com.google.android.gms.internal.zzdk;
import com.google.android.gms.internal.zziz;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements zzdk {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzh f570a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(zzh zzhVar) {
        this.f570a = zzhVar;
    }

    @Override // com.google.android.gms.internal.zzdk
    public void zza(zziz zzizVar, Map<String, String> map) {
        String str;
        zzbb zzbbVar;
        JSONObject jSONObject = new JSONObject();
        try {
            for (String str2 : map.keySet()) {
                jSONObject.put(str2, map.get(str2));
            }
            str = this.f570a.k;
            jSONObject.put(ShareConstants.WEB_DIALOG_PARAM_ID, str);
            zzbbVar = this.f570a.e;
            zzbbVar.zzb("sendMessageToNativeJs", jSONObject);
        } catch (JSONException e) {
            zzb.b("Unable to dispatch sendMessageToNativeJs event", e);
        }
    }
}
