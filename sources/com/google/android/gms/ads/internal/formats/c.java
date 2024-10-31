package com.google.android.gms.ads.internal.formats;

import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzbb;
import com.google.android.gms.internal.zziz;
import com.google.android.gms.internal.zzja;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
class c implements zzja.zza {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Map f566a;
    final /* synthetic */ b b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, Map map) {
        this.b = bVar;
        this.f566a = map;
    }

    @Override // com.google.android.gms.internal.zzja.zza
    public void zza(zziz zzizVar, boolean z) {
        String str;
        zzbb zzbbVar;
        this.b.f565a.k = (String) this.f566a.get(ShareConstants.WEB_DIALOG_PARAM_ID);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("messageType", "htmlLoaded");
            str = this.b.f565a.k;
            jSONObject.put(ShareConstants.WEB_DIALOG_PARAM_ID, str);
            zzbbVar = this.b.f565a.e;
            zzbbVar.zzb("sendMessageToNativeJs", jSONObject);
        } catch (JSONException e) {
            zzb.b("Unable to dispatch sendMessageToNativeJsevent", e);
        }
    }
}
