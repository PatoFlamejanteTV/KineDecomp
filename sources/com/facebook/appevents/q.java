package com.facebook.appevents;

import android.os.Bundle;
import com.facebook.internal.AnalyticsEvents;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AppEventsLogger.java */
/* loaded from: classes.dex */
public class q implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AppEventsLogger f9221a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(AppEventsLogger appEventsLogger) {
        this.f9221a = appEventsLogger;
    }

    @Override // java.lang.Runnable
    public void run() {
        Bundle bundle = new Bundle();
        try {
            Class.forName("com.facebook.core.Core");
            bundle.putInt("core_lib_included", 1);
        } catch (ClassNotFoundException unused) {
        }
        try {
            Class.forName("com.facebook.login.Login");
            bundle.putInt("login_lib_included", 1);
        } catch (ClassNotFoundException unused2) {
        }
        try {
            Class.forName("com.facebook.share.Share");
            bundle.putInt("share_lib_included", 1);
        } catch (ClassNotFoundException unused3) {
        }
        try {
            Class.forName("com.facebook.places.Places");
            bundle.putInt("places_lib_included", 1);
        } catch (ClassNotFoundException unused4) {
        }
        try {
            Class.forName("com.facebook.messenger.Messenger");
            bundle.putInt("messenger_lib_included", 1);
        } catch (ClassNotFoundException unused5) {
        }
        try {
            Class.forName("com.facebook.applinks.AppLinks");
            bundle.putInt("applinks_lib_included", 1);
        } catch (ClassNotFoundException unused6) {
        }
        try {
            Class.forName("com.facebook.marketing.Marketing");
            bundle.putInt("marketing_lib_included", 1);
        } catch (ClassNotFoundException unused7) {
        }
        try {
            Class.forName("com.facebook.all.All");
            bundle.putInt("all_lib_included", 1);
        } catch (ClassNotFoundException unused8) {
        }
        try {
            Class.forName("com.android.billingclient.api.g");
            bundle.putInt("billing_client_lib_included", 1);
        } catch (ClassNotFoundException unused9) {
        }
        try {
            Class.forName("com.android.vending.billing.IInAppBillingService");
            bundle.putInt("billing_service_lib_included", 1);
        } catch (ClassNotFoundException unused10) {
        }
        this.f9221a.logSdkEvent(AnalyticsEvents.EVENT_SDK_INITIALIZE, null, bundle);
    }
}
