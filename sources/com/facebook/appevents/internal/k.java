package com.facebook.appevents.internal;

import android.content.Context;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.Utility;
import java.math.BigDecimal;
import java.util.Currency;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InternalAppEventsLogger.java */
/* loaded from: classes.dex */
public class k extends AppEventsLogger {
    /* JADX INFO: Access modifiers changed from: package-private */
    public k(Context context) {
        this(Utility.getActivityName(context), null, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.appevents.AppEventsLogger
    public void logEventImplicitly(String str, BigDecimal bigDecimal, Currency currency, Bundle bundle) {
        super.logEventImplicitly(str, bigDecimal, currency, bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.appevents.AppEventsLogger
    public void logPurchaseImplicitlyInternal(BigDecimal bigDecimal, Currency currency, Bundle bundle) {
        super.logPurchaseImplicitlyInternal(bigDecimal, currency, bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(String str, String str2, AccessToken accessToken) {
        super(str, str2, accessToken);
    }
}
