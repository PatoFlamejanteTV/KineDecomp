package com.nexstreaming.app.general.iab.a;

import com.nexstreaming.app.general.iab.IABError;
import com.nexstreaming.app.general.iab.Purchase;
import com.nexstreaming.app.general.iab.SKUDetails;
import com.nexstreaming.app.general.iab.Utils.IABConstant;
import java.util.LinkedHashMap;
import java.util.List;

/* compiled from: CallbackObserver.kt */
/* loaded from: classes2.dex */
public interface a {
    void a(LinkedHashMap<IABConstant.SKUType, LinkedHashMap<String, SKUDetails>> linkedHashMap);

    void a(LinkedHashMap<IABConstant.SKUType, List<Purchase>> linkedHashMap, IABError iABError, String str);

    void a(boolean z, int i, boolean z2);

    void a(boolean z, Purchase purchase, String str);
}
