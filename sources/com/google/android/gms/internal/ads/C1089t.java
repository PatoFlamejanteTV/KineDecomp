package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.ads.t, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1089t implements com.google.android.gms.ads.internal.gmsg.zzu<Object> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzaqp f12541a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C1075s f12542b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1089t(C1075s c1075s, zzaqp zzaqpVar) {
        this.f12542b = c1075s;
        this.f12541a = zzaqpVar;
    }

    @Override // com.google.android.gms.ads.internal.gmsg.zzu
    public final void zza(Object obj, final Map<String, String> map) {
        WeakReference weakReference;
        weakReference = this.f12542b.f12506a;
        zzbgg zzbggVar = (zzbgg) weakReference.get();
        if (zzbggVar == null) {
            this.f12541a.zzb("/loadHtml", this);
            return;
        }
        zzbhn zzadl = zzbggVar.zzadl();
        final zzaqp zzaqpVar = this.f12541a;
        zzadl.zza(new zzbho(this, map, zzaqpVar) { // from class: com.google.android.gms.internal.ads.u

            /* renamed from: a, reason: collision with root package name */
            private final C1089t f12571a;

            /* renamed from: b, reason: collision with root package name */
            private final Map f12572b;

            /* renamed from: c, reason: collision with root package name */
            private final zzaqp f12573c;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f12571a = this;
                this.f12572b = map;
                this.f12573c = zzaqpVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbho
            public final void zzp(boolean z) {
                String str;
                C1089t c1089t = this.f12571a;
                Map map2 = this.f12572b;
                zzaqp zzaqpVar2 = this.f12573c;
                c1089t.f12542b.f12507b = (String) map2.get("id");
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("messageType", "htmlLoaded");
                    str = c1089t.f12542b.f12507b;
                    jSONObject.put("id", str);
                    zzaqpVar2.zza("sendMessageToNativeJs", jSONObject);
                } catch (JSONException e2) {
                    zzbbd.zzb("Unable to dispatch sendMessageToNativeJs event", e2);
                }
            }
        });
        String str = map.get("overlayHtml");
        String str2 = map.get("baseUrl");
        if (TextUtils.isEmpty(str2)) {
            zzbggVar.loadData(str, "text/html", "UTF-8");
        } else {
            zzbggVar.loadDataWithBaseURL(str2, str, "text/html", "UTF-8", null);
        }
    }
}
