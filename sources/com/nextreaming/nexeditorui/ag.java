package com.nextreaming.nexeditorui;

import android.app.Activity;
import android.content.SharedPreferences;
import com.facebook.appevents.AppEventsLogger;
import com.nexstreaming.app.general.iab.SKUDetails;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.tracelog.RegisterIAPResponse;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IABWrapper.java */
/* loaded from: classes.dex */
public class ag implements ResultTask.OnResultAvailableListener<RegisterIAPResponse> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f4515a;
    final /* synthetic */ Set b;
    final /* synthetic */ SharedPreferences c;
    final /* synthetic */ String d;
    final /* synthetic */ af e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(af afVar, String str, Set set, SharedPreferences sharedPreferences, String str2) {
        this.e = afVar;
        this.f4515a = str;
        this.b = set;
        this.c = sharedPreferences;
        this.d = str2;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<RegisterIAPResponse> resultTask, Task.Event event, RegisterIAPResponse registerIAPResponse) {
        Activity activity;
        SKUDetails sKUDetails;
        SKUDetails sKUDetails2;
        SKUDetails sKUDetails3;
        SKUDetails sKUDetails4;
        SKUDetails sKUDetails5;
        SKUDetails sKUDetails6;
        Activity activity2;
        switch (registerIAPResponse.getResponseCode()) {
            case SUCCESS:
                this.b.add(this.f4515a);
                this.c.edit().putStringSet("registered_iap_orders", this.b).apply();
                activity = this.e.w;
                if (activity != null) {
                    SKUDetails sKUDetails7 = null;
                    sKUDetails = this.e.i;
                    if (sKUDetails.a().equals(this.d)) {
                        sKUDetails7 = this.e.i;
                    } else {
                        sKUDetails2 = this.e.h;
                        if (sKUDetails2.a().equals(this.d)) {
                            sKUDetails7 = this.e.h;
                        } else {
                            sKUDetails3 = this.e.g;
                            if (sKUDetails3.a().equals(this.d)) {
                                sKUDetails7 = this.e.g;
                            } else {
                                sKUDetails4 = this.e.l;
                                if (sKUDetails4.a().equals(this.d)) {
                                    sKUDetails7 = this.e.l;
                                } else {
                                    sKUDetails5 = this.e.k;
                                    if (sKUDetails5.a().equals(this.d)) {
                                        sKUDetails7 = this.e.k;
                                    } else {
                                        sKUDetails6 = this.e.j;
                                        if (sKUDetails6.a().equals(this.d)) {
                                            sKUDetails7 = this.e.j;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (sKUDetails7 != null) {
                        activity2 = this.e.w;
                        AppEventsLogger.newLogger(activity2).logPurchase(BigDecimal.valueOf(sKUDetails7.e() / 1000000.0d), Currency.getInstance(sKUDetails7.f()));
                        return;
                    }
                    return;
                }
                return;
            case ALREADY_IAP_REGISTERED:
                this.b.add(this.f4515a);
                this.c.edit().putStringSet("registered_iap_orders", this.b).apply();
                return;
            default:
                return;
        }
    }
}
