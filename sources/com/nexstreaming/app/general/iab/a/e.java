package com.nexstreaming.app.general.iab.a;

import android.util.Log;
import com.nexstreaming.app.general.iab.IABError;
import com.nexstreaming.app.general.iab.IABHelper;
import com.nexstreaming.app.general.iab.Purchase;
import com.nexstreaming.app.general.iab.SKUDetails;

/* compiled from: GoogleIABHelper.java */
/* loaded from: classes.dex */
class e implements IABHelper.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f3147a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar) {
        this.f3147a = aVar;
    }

    @Override // com.nexstreaming.app.general.iab.IABHelper.b
    public void a(SKUDetails sKUDetails, Purchase purchase) {
        Log.i("GoogleIABHelper", "onConsumeComplete() called with: sku = [" + sKUDetails + "], purchase = [" + purchase + "]");
    }

    @Override // com.nexstreaming.app.general.iab.IABHelper.b
    public void a(IABError iABError, String str) {
        Log.e("GoogleIABHelper", "onConsumeError() called with: error = [" + iABError + "], message = [" + str + "]");
    }
}
