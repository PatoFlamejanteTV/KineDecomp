package com.nextreaming.nexeditorui;

import android.util.Log;
import com.nexstreaming.app.general.iab.IABError;
import com.nexstreaming.app.general.iab.IABHelper;
import com.nexstreaming.app.general.iab.Purchase;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IABWrapper.java */
/* loaded from: classes.dex */
public class ak implements IABHelper.c {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ af f4519a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(af afVar) {
        this.f4519a = afVar;
    }

    @Override // com.nexstreaming.app.general.iab.IABHelper.c
    public void a(Map<IABHelper.SKUType, List<Purchase>> map) {
        IABHelper.c cVar;
        IABHelper.c cVar2;
        this.f4519a.P();
        if (map != null) {
            Log.d("IABWrapper", "onLoadPurchases() called with: inventory = [" + map.size() + "]");
            this.f4519a.a((Map<IABHelper.SKUType, List<Purchase>>) map);
        }
        cVar = this.f4519a.d;
        if (cVar != null) {
            cVar2 = this.f4519a.d;
            cVar2.a(map);
        }
    }

    @Override // com.nexstreaming.app.general.iab.IABHelper.c
    public void b(IABError iABError, String str) {
        IABHelper.c cVar;
        IABHelper.c cVar2;
        this.f4519a.P();
        Log.d("IABWrapper", "LoadPurchase onError() called with: error = [" + iABError + "], message = [" + str + "]");
        cVar = this.f4519a.d;
        if (cVar != null) {
            cVar2 = this.f4519a.d;
            cVar2.b(iABError, str);
        }
    }
}
