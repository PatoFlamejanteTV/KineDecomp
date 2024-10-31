package com.nexstreaming.kinemaster.ui.settings;

import android.util.Log;
import com.nexstreaming.app.general.iab.IABError;
import com.nexstreaming.app.general.iab.IABHelper;
import com.nexstreaming.app.general.iab.Purchase;
import java.util.List;
import java.util.Map;

/* compiled from: SettingsActivity.java */
/* loaded from: classes.dex */
class av implements IABHelper.c {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SettingsActivity f4248a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(SettingsActivity settingsActivity) {
        this.f4248a = settingsActivity;
    }

    @Override // com.nexstreaming.app.general.iab.IABHelper.c
    public void a(Map<IABHelper.SKUType, List<Purchase>> map) {
        this.f4248a.c();
    }

    @Override // com.nexstreaming.app.general.iab.IABHelper.c
    public void b(IABError iABError, String str) {
        Log.e("SettingsActivity", "onLoadPurchaseError() called with: error = [" + iABError + "], message = [" + str + "]");
        this.f4248a.c();
    }
}
