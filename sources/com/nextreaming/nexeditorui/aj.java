package com.nextreaming.nexeditorui;

import android.util.Log;
import com.nexstreaming.app.general.iab.IABHelper;
import com.nexstreaming.app.general.iab.SKUDetails;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IABWrapper.java */
/* loaded from: classes.dex */
public class aj implements IABHelper.d {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ af f4518a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(af afVar) {
        this.f4518a = afVar;
    }

    @Override // com.nexstreaming.app.general.iab.IABHelper.d
    public void b(Map<IABHelper.SKUType, Map<String, SKUDetails>> map) {
        IABHelper.d dVar;
        IABHelper.d dVar2;
        IABHelper iABHelper;
        IABHelper iABHelper2;
        IABHelper iABHelper3;
        IABHelper iABHelper4;
        IABHelper iABHelper5;
        IABHelper iABHelper6;
        this.f4518a.P();
        if (map != null) {
            Log.i("IABWrapper", "onLoadSku() called with: skus = [" + map.size() + "]");
            iABHelper = this.f4518a.f4513a;
            if (!(iABHelper instanceof com.nexstreaming.app.general.iab.a.a)) {
                iABHelper2 = this.f4518a.f4513a;
                if (iABHelper2 instanceof com.nexstreaming.app.general.iab.c.a) {
                    af afVar = this.f4518a;
                    iABHelper4 = this.f4518a.f4513a;
                    afVar.a(iABHelper4, (Map<String, SKUDetails>) map.get(IABHelper.SKUType.xiaomi));
                } else {
                    af afVar2 = this.f4518a;
                    iABHelper3 = this.f4518a.f4513a;
                    afVar2.a(iABHelper3, (Map<String, SKUDetails>) map.get(IABHelper.SKUType.wechat));
                }
            } else {
                af afVar3 = this.f4518a;
                iABHelper5 = this.f4518a.f4513a;
                afVar3.a(iABHelper5, (Map<String, SKUDetails>) map.get(IABHelper.SKUType.inapp));
                af afVar4 = this.f4518a;
                iABHelper6 = this.f4518a.f4513a;
                afVar4.a(iABHelper6, (Map<String, SKUDetails>) map.get(IABHelper.SKUType.subs));
            }
        }
        dVar = this.f4518a.c;
        if (dVar != null) {
            dVar2 = this.f4518a.c;
            dVar2.b(map);
        }
        this.f4518a.t();
    }
}
