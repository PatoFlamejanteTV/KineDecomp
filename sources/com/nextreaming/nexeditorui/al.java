package com.nextreaming.nexeditorui;

import android.util.Log;
import com.nexstreaming.app.general.iab.IABError;
import com.nexstreaming.app.general.iab.IABHelper;
import com.nexstreaming.app.general.iab.Purchase;
import com.nexstreaming.app.general.iab.SKUDetails;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IABWrapper.java */
/* loaded from: classes.dex */
public class al implements IABHelper.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ af f4520a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(af afVar) {
        this.f4520a = afVar;
    }

    @Override // com.nexstreaming.app.general.iab.IABHelper.b
    public void a(SKUDetails sKUDetails, Purchase purchase) {
        Map map;
        IABHelper.b bVar;
        IABHelper.b bVar2;
        Map map2;
        Log.i("IABWrapper", "consume complete : " + sKUDetails.a());
        map = this.f4520a.v;
        if (map != null && purchase != null) {
            map2 = this.f4520a.v;
            map2.remove(purchase.a());
        }
        bVar = this.f4520a.e;
        if (bVar != null) {
            bVar2 = this.f4520a.e;
            bVar2.a(sKUDetails, purchase);
        }
    }

    @Override // com.nexstreaming.app.general.iab.IABHelper.b
    public void a(IABError iABError, String str) {
        IABHelper.b bVar;
        IABHelper.b bVar2;
        Log.e("IABWrapper", "onConsumeError() called with: error = [" + iABError + "], message = [" + str + "]");
        bVar = this.f4520a.e;
        if (bVar != null) {
            bVar2 = this.f4520a.e;
            bVar2.a(iABError, str);
        }
    }
}
