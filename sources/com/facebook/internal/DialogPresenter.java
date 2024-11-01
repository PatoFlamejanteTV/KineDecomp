package com.facebook.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.FacebookActivity;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.Utility;

/* loaded from: classes.dex */
public class DialogPresenter {

    /* loaded from: classes.dex */
    public interface ParameterProvider {
        Bundle getLegacyParameters();

        Bundle getParameters();
    }

    public static void setupAppCallForCannotShowError(AppCall appCall) {
        setupAppCallForValidationError(appCall, new FacebookException("Unable to show the provided content via the web or the installed version of the Facebook app. Some dialogs are only supported starting API 14."));
    }

    public static void setupAppCallForValidationError(AppCall appCall, FacebookException facebookException) {
        setupAppCallForErrorResult(appCall, facebookException);
    }

    public static void present(AppCall appCall, Activity activity) {
        activity.startActivityForResult(appCall.getRequestIntent(), appCall.getRequestCode());
        appCall.setPending();
    }

    public static void present(AppCall appCall, Fragment fragment) {
        fragment.startActivityForResult(appCall.getRequestIntent(), appCall.getRequestCode());
        appCall.setPending();
    }

    public static boolean canPresentNativeDialogWithFeature(DialogFeature dialogFeature) {
        return getProtocolVersionForNativeDialog(dialogFeature) != -1;
    }

    public static boolean canPresentWebFallbackDialogWithFeature(DialogFeature dialogFeature) {
        return getDialogWebFallbackUri(dialogFeature) != null;
    }

    public static void setupAppCallForErrorResult(AppCall appCall, FacebookException facebookException) {
        if (facebookException != null) {
            Validate.hasFacebookActivity(FacebookSdk.getApplicationContext());
            Intent intent = new Intent();
            intent.setClass(FacebookSdk.getApplicationContext(), FacebookActivity.class);
            intent.setAction(FacebookActivity.PASS_THROUGH_CANCEL_ACTION);
            NativeProtocol.setupProtocolRequestIntent(intent, appCall.getCallId().toString(), null, NativeProtocol.getLatestKnownVersion(), NativeProtocol.createBundleForException(facebookException));
            appCall.setRequestIntent(intent);
        }
    }

    public static void setupAppCallForWebDialog(AppCall appCall, String str, Bundle bundle) {
        Validate.hasFacebookActivity(FacebookSdk.getApplicationContext());
        Validate.hasInternetPermissions(FacebookSdk.getApplicationContext());
        Bundle bundle2 = new Bundle();
        bundle2.putString(NativeProtocol.WEB_DIALOG_ACTION, str);
        bundle2.putBundle(NativeProtocol.WEB_DIALOG_PARAMS, bundle);
        Intent intent = new Intent();
        NativeProtocol.setupProtocolRequestIntent(intent, appCall.getCallId().toString(), str, NativeProtocol.getLatestKnownVersion(), bundle2);
        intent.setClass(FacebookSdk.getApplicationContext(), FacebookActivity.class);
        intent.setAction(FacebookDialogFragment.TAG);
        appCall.setRequestIntent(intent);
    }

    public static void setupAppCallForWebFallbackDialog(AppCall appCall, Bundle bundle, DialogFeature dialogFeature) {
        Uri buildUri;
        Validate.hasFacebookActivity(FacebookSdk.getApplicationContext());
        Validate.hasInternetPermissions(FacebookSdk.getApplicationContext());
        String name = dialogFeature.name();
        Uri dialogWebFallbackUri = getDialogWebFallbackUri(dialogFeature);
        if (dialogWebFallbackUri == null) {
            throw new FacebookException("Unable to fetch the Url for the DialogFeature : '" + name + "'");
        }
        Bundle queryParamsForPlatformActivityIntentWebFallback = ServerProtocol.getQueryParamsForPlatformActivityIntentWebFallback(appCall.getCallId().toString(), NativeProtocol.getLatestKnownVersion(), bundle);
        if (queryParamsForPlatformActivityIntentWebFallback == null) {
            throw new FacebookException("Unable to fetch the app's key-hash");
        }
        if (dialogWebFallbackUri.isRelative()) {
            buildUri = Utility.buildUri(ServerProtocol.getDialogAuthority(), dialogWebFallbackUri.toString(), queryParamsForPlatformActivityIntentWebFallback);
        } else {
            buildUri = Utility.buildUri(dialogWebFallbackUri.getAuthority(), dialogWebFallbackUri.getPath(), queryParamsForPlatformActivityIntentWebFallback);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("url", buildUri.toString());
        bundle2.putBoolean(NativeProtocol.WEB_DIALOG_IS_FALLBACK, true);
        Intent intent = new Intent();
        NativeProtocol.setupProtocolRequestIntent(intent, appCall.getCallId().toString(), dialogFeature.getAction(), NativeProtocol.getLatestKnownVersion(), bundle2);
        intent.setClass(FacebookSdk.getApplicationContext(), FacebookActivity.class);
        intent.setAction(FacebookDialogFragment.TAG);
        appCall.setRequestIntent(intent);
    }

    public static void setupAppCallForNativeDialog(AppCall appCall, ParameterProvider parameterProvider, DialogFeature dialogFeature) {
        Bundle legacyParameters;
        Context applicationContext = FacebookSdk.getApplicationContext();
        String action = dialogFeature.getAction();
        int protocolVersionForNativeDialog = getProtocolVersionForNativeDialog(dialogFeature);
        if (protocolVersionForNativeDialog == -1) {
            throw new FacebookException("Cannot present this dialog. This likely means that the Facebook app is not installed.");
        }
        if (NativeProtocol.isVersionCompatibleWithBucketedIntent(protocolVersionForNativeDialog)) {
            legacyParameters = parameterProvider.getParameters();
        } else {
            legacyParameters = parameterProvider.getLegacyParameters();
        }
        if (legacyParameters == null) {
            legacyParameters = new Bundle();
        }
        Intent createPlatformActivityIntent = NativeProtocol.createPlatformActivityIntent(applicationContext, appCall.getCallId().toString(), action, protocolVersionForNativeDialog, legacyParameters);
        if (createPlatformActivityIntent == null) {
            throw new FacebookException("Unable to create Intent; this likely means theFacebook app is not installed.");
        }
        appCall.setRequestIntent(createPlatformActivityIntent);
    }

    private static Uri getDialogWebFallbackUri(DialogFeature dialogFeature) {
        String name = dialogFeature.name();
        Utility.DialogFeatureConfig dialogFeatureConfig = Utility.getDialogFeatureConfig(FacebookSdk.getApplicationId(), dialogFeature.getAction(), name);
        if (dialogFeatureConfig == null) {
            return null;
        }
        return dialogFeatureConfig.getFallbackUrl();
    }

    public static int getProtocolVersionForNativeDialog(DialogFeature dialogFeature) {
        String applicationId = FacebookSdk.getApplicationId();
        String action = dialogFeature.getAction();
        return NativeProtocol.getLatestAvailableProtocolVersionForAction(action, getVersionSpecForFeature(applicationId, action, dialogFeature));
    }

    private static int[] getVersionSpecForFeature(String str, String str2, DialogFeature dialogFeature) {
        Utility.DialogFeatureConfig dialogFeatureConfig = Utility.getDialogFeatureConfig(str, str2, dialogFeature.name());
        return dialogFeatureConfig != null ? dialogFeatureConfig.getVersionSpec() : new int[]{dialogFeature.getMinVersion()};
    }

    public static void logDialogActivity(Context context, String str, String str2) {
        AppEventsLogger newLogger = AppEventsLogger.newLogger(context);
        Bundle bundle = new Bundle();
        bundle.putString(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME, str2);
        newLogger.logSdkEvent(str, null, bundle);
    }
}
