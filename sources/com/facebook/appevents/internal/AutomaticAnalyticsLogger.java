package com.facebook.appevents.internal;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Validate;
import java.math.BigDecimal;
import java.util.Currency;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class AutomaticAnalyticsLogger {
    private static final String TAG = "com.facebook.appevents.internal.AutomaticAnalyticsLogger";
    private static final k internalAppEventsLogger = new k(FacebookSdk.getApplicationContext());

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        BigDecimal f9175a;

        /* renamed from: b, reason: collision with root package name */
        Currency f9176b;

        /* renamed from: c, reason: collision with root package name */
        Bundle f9177c;

        a(BigDecimal bigDecimal, Currency currency, Bundle bundle) {
            this.f9175a = bigDecimal;
            this.f9176b = currency;
            this.f9177c = bundle;
        }
    }

    private static a getPurchaseLoggingParameters(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = new JSONObject(str2);
            Bundle bundle = new Bundle(1);
            bundle.putCharSequence(Constants.IAP_PRODUCT_ID, jSONObject.getString("productId"));
            bundle.putCharSequence(Constants.IAP_PURCHASE_TIME, jSONObject.getString("purchaseTime"));
            bundle.putCharSequence(Constants.IAP_PURCHASE_TOKEN, jSONObject.getString("purchaseToken"));
            bundle.putCharSequence(Constants.IAP_PACKAGE_NAME, jSONObject.optString("packageName"));
            bundle.putCharSequence(Constants.IAP_PRODUCT_TITLE, jSONObject2.optString("title"));
            bundle.putCharSequence(Constants.IAP_PRODUCT_DESCRIPTION, jSONObject2.optString("description"));
            String optString = jSONObject2.optString("type");
            bundle.putCharSequence(Constants.IAP_PRODUCT_TYPE, optString);
            if (optString.equals("subs")) {
                bundle.putCharSequence(Constants.IAP_SUBSCRIPTION_AUTORENEWING, Boolean.toString(jSONObject.optBoolean("autoRenewing", false)));
                bundle.putCharSequence(Constants.IAP_SUBSCRIPTION_PERIOD, jSONObject2.optString("subscriptionPeriod"));
                bundle.putCharSequence(Constants.IAP_FREE_TRIAL_PERIOD, jSONObject2.optString("freeTrialPeriod"));
                String optString2 = jSONObject2.optString("introductoryPriceCycles");
                if (!optString2.isEmpty()) {
                    bundle.putCharSequence(Constants.IAP_INTRO_PRICE_AMOUNT_MICROS, jSONObject2.optString("introductoryPriceAmountMicros"));
                    bundle.putCharSequence(Constants.IAP_INTRO_PRICE_CYCLES, optString2);
                }
            }
            double d2 = jSONObject2.getLong("price_amount_micros");
            Double.isNaN(d2);
            return new a(new BigDecimal(d2 / 1000000.0d), Currency.getInstance(jSONObject2.getString("price_currency_code")), bundle);
        } catch (JSONException e2) {
            Log.e(TAG, "Error parsing in-app subscription data.", e2);
            return null;
        }
    }

    public static boolean isImplicitPurchaseLoggingEnabled() {
        FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
        return appSettingsWithoutQuery != null && FacebookSdk.getAutoLogAppEventsEnabled() && appSettingsWithoutQuery.getIAPAutomaticLoggingEnabled();
    }

    public static void logActivateAppEvent() {
        Context applicationContext = FacebookSdk.getApplicationContext();
        String applicationId = FacebookSdk.getApplicationId();
        boolean autoLogAppEventsEnabled = FacebookSdk.getAutoLogAppEventsEnabled();
        Validate.notNull(applicationContext, com.umeng.analytics.pro.b.Q);
        if (autoLogAppEventsEnabled) {
            if (applicationContext instanceof Application) {
                AppEventsLogger.activateApp((Application) applicationContext, applicationId);
            } else {
                Log.w(TAG, "Automatic logging of basic events will not happen, because FacebookSdk.getApplicationContext() returns object that is not instance of android.app.Application. Make sure you call FacebookSdk.sdkInitialize() from Application class and pass application context.");
            }
        }
    }

    public static void logActivityTimeSpentEvent(String str, long j) {
        Context applicationContext = FacebookSdk.getApplicationContext();
        String applicationId = FacebookSdk.getApplicationId();
        Validate.notNull(applicationContext, com.umeng.analytics.pro.b.Q);
        FetchedAppSettings queryAppSettings = FetchedAppSettingsManager.queryAppSettings(applicationId, false);
        if (queryAppSettings == null || !queryAppSettings.getAutomaticLoggingEnabled() || j <= 0) {
            return;
        }
        AppEventsLogger newLogger = AppEventsLogger.newLogger(applicationContext);
        Bundle bundle = new Bundle(1);
        bundle.putCharSequence(Constants.AA_TIME_SPENT_SCREEN_PARAMETER_NAME, str);
        newLogger.logEvent(Constants.AA_TIME_SPENT_EVENT_NAME, j, bundle);
    }

    public static void logPurchaseInapp(String str, String str2) {
        a purchaseLoggingParameters;
        if (isImplicitPurchaseLoggingEnabled() && (purchaseLoggingParameters = getPurchaseLoggingParameters(str, str2)) != null) {
            internalAppEventsLogger.logPurchaseImplicitlyInternal(purchaseLoggingParameters.f9175a, purchaseLoggingParameters.f9176b, purchaseLoggingParameters.f9177c);
        }
    }

    public static void logPurchaseSubs(SubscriptionType subscriptionType, String str, String str2) {
        String str3;
        if (isImplicitPurchaseLoggingEnabled()) {
            int i = f.f9191a[subscriptionType.ordinal()];
            if (i == 1) {
                str3 = "SubscriptionRestore";
            } else if (i == 2) {
                str3 = "SubscriptionCancel";
            } else if (i == 3) {
                str3 = "SubscriptionHeartbeat";
            } else {
                if (i != 4) {
                    if (i != 5) {
                        return;
                    }
                    logPurchaseInapp(str, str2);
                    return;
                }
                str3 = "SubscriptionExpire";
            }
            a purchaseLoggingParameters = getPurchaseLoggingParameters(str, str2);
            if (purchaseLoggingParameters != null) {
                internalAppEventsLogger.logEventImplicitly(str3, purchaseLoggingParameters.f9175a, purchaseLoggingParameters.f9176b, purchaseLoggingParameters.f9177c);
            }
        }
    }
}
