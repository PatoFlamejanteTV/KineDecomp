package com.crashlytics.android.answers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import io.fabric.sdk.android.f;
import io.fabric.sdk.android.l;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.l;
import io.fabric.sdk.android.services.common.s;
import io.fabric.sdk.android.services.settings.u;
import java.io.File;

/* loaded from: classes.dex */
public class Answers extends l<Boolean> {
    static final String CRASHLYTICS_API_ENDPOINT = "com.crashlytics.ApiEndpoint";
    public static final String TAG = "Answers";
    SessionAnalyticsManager analyticsManager;
    boolean firebaseEnabled = false;

    public static Answers getInstance() {
        return (Answers) f.a(Answers.class);
    }

    private void logFirebaseModeEnabledWarning(String str) {
        f.f().b(TAG, "Method " + str + " is not supported when using Crashlytics through Firebase.");
    }

    @Override // io.fabric.sdk.android.l
    public String getIdentifier() {
        return "com.crashlytics.sdk.android:answers";
    }

    String getOverridenSpiEndpoint() {
        return CommonUtils.b(getContext(), CRASHLYTICS_API_ENDPOINT);
    }

    @Override // io.fabric.sdk.android.l
    public String getVersion() {
        return "1.4.1.19";
    }

    public void logAddToCart(AddToCartEvent addToCartEvent) {
        if (addToCartEvent != null) {
            if (this.firebaseEnabled) {
                logFirebaseModeEnabledWarning("logAddToCart");
                return;
            }
            SessionAnalyticsManager sessionAnalyticsManager = this.analyticsManager;
            if (sessionAnalyticsManager != null) {
                sessionAnalyticsManager.onPredefined(addToCartEvent);
                return;
            }
            return;
        }
        throw new NullPointerException("event must not be null");
    }

    public void logContentView(ContentViewEvent contentViewEvent) {
        if (contentViewEvent != null) {
            if (this.firebaseEnabled) {
                logFirebaseModeEnabledWarning("logContentView");
                return;
            }
            SessionAnalyticsManager sessionAnalyticsManager = this.analyticsManager;
            if (sessionAnalyticsManager != null) {
                sessionAnalyticsManager.onPredefined(contentViewEvent);
                return;
            }
            return;
        }
        throw new NullPointerException("event must not be null");
    }

    public void logCustom(CustomEvent customEvent) {
        if (customEvent != null) {
            if (this.firebaseEnabled) {
                logFirebaseModeEnabledWarning("logCustom");
                return;
            }
            SessionAnalyticsManager sessionAnalyticsManager = this.analyticsManager;
            if (sessionAnalyticsManager != null) {
                sessionAnalyticsManager.onCustom(customEvent);
                return;
            }
            return;
        }
        throw new NullPointerException("event must not be null");
    }

    public void logInvite(InviteEvent inviteEvent) {
        if (inviteEvent != null) {
            if (this.firebaseEnabled) {
                logFirebaseModeEnabledWarning("logInvite");
                return;
            }
            SessionAnalyticsManager sessionAnalyticsManager = this.analyticsManager;
            if (sessionAnalyticsManager != null) {
                sessionAnalyticsManager.onPredefined(inviteEvent);
                return;
            }
            return;
        }
        throw new NullPointerException("event must not be null");
    }

    public void logLevelEnd(LevelEndEvent levelEndEvent) {
        if (levelEndEvent != null) {
            if (this.firebaseEnabled) {
                logFirebaseModeEnabledWarning("logLevelEnd");
                return;
            }
            SessionAnalyticsManager sessionAnalyticsManager = this.analyticsManager;
            if (sessionAnalyticsManager != null) {
                sessionAnalyticsManager.onPredefined(levelEndEvent);
                return;
            }
            return;
        }
        throw new NullPointerException("event must not be null");
    }

    public void logLevelStart(LevelStartEvent levelStartEvent) {
        if (levelStartEvent != null) {
            if (this.firebaseEnabled) {
                logFirebaseModeEnabledWarning("logLevelStart");
                return;
            }
            SessionAnalyticsManager sessionAnalyticsManager = this.analyticsManager;
            if (sessionAnalyticsManager != null) {
                sessionAnalyticsManager.onPredefined(levelStartEvent);
                return;
            }
            return;
        }
        throw new NullPointerException("event must not be null");
    }

    public void logLogin(LoginEvent loginEvent) {
        if (loginEvent != null) {
            if (this.firebaseEnabled) {
                logFirebaseModeEnabledWarning("logLogin");
                return;
            }
            SessionAnalyticsManager sessionAnalyticsManager = this.analyticsManager;
            if (sessionAnalyticsManager != null) {
                sessionAnalyticsManager.onPredefined(loginEvent);
                return;
            }
            return;
        }
        throw new NullPointerException("event must not be null");
    }

    public void logPurchase(PurchaseEvent purchaseEvent) {
        if (purchaseEvent != null) {
            if (this.firebaseEnabled) {
                logFirebaseModeEnabledWarning("logPurchase");
                return;
            }
            SessionAnalyticsManager sessionAnalyticsManager = this.analyticsManager;
            if (sessionAnalyticsManager != null) {
                sessionAnalyticsManager.onPredefined(purchaseEvent);
                return;
            }
            return;
        }
        throw new NullPointerException("event must not be null");
    }

    public void logRating(RatingEvent ratingEvent) {
        if (ratingEvent != null) {
            if (this.firebaseEnabled) {
                logFirebaseModeEnabledWarning("logRating");
                return;
            }
            SessionAnalyticsManager sessionAnalyticsManager = this.analyticsManager;
            if (sessionAnalyticsManager != null) {
                sessionAnalyticsManager.onPredefined(ratingEvent);
                return;
            }
            return;
        }
        throw new NullPointerException("event must not be null");
    }

    public void logSearch(SearchEvent searchEvent) {
        if (searchEvent != null) {
            if (this.firebaseEnabled) {
                logFirebaseModeEnabledWarning("logSearch");
                return;
            }
            SessionAnalyticsManager sessionAnalyticsManager = this.analyticsManager;
            if (sessionAnalyticsManager != null) {
                sessionAnalyticsManager.onPredefined(searchEvent);
                return;
            }
            return;
        }
        throw new NullPointerException("event must not be null");
    }

    public void logShare(ShareEvent shareEvent) {
        if (shareEvent != null) {
            if (this.firebaseEnabled) {
                logFirebaseModeEnabledWarning("logShare");
                return;
            }
            SessionAnalyticsManager sessionAnalyticsManager = this.analyticsManager;
            if (sessionAnalyticsManager != null) {
                sessionAnalyticsManager.onPredefined(shareEvent);
                return;
            }
            return;
        }
        throw new NullPointerException("event must not be null");
    }

    public void logSignUp(SignUpEvent signUpEvent) {
        if (signUpEvent != null) {
            if (this.firebaseEnabled) {
                logFirebaseModeEnabledWarning("logSignUp");
                return;
            }
            SessionAnalyticsManager sessionAnalyticsManager = this.analyticsManager;
            if (sessionAnalyticsManager != null) {
                sessionAnalyticsManager.onPredefined(signUpEvent);
                return;
            }
            return;
        }
        throw new NullPointerException("event must not be null");
    }

    public void logStartCheckout(StartCheckoutEvent startCheckoutEvent) {
        if (startCheckoutEvent != null) {
            if (this.firebaseEnabled) {
                logFirebaseModeEnabledWarning("logStartCheckout");
                return;
            }
            SessionAnalyticsManager sessionAnalyticsManager = this.analyticsManager;
            if (sessionAnalyticsManager != null) {
                sessionAnalyticsManager.onPredefined(startCheckoutEvent);
                return;
            }
            return;
        }
        throw new NullPointerException("event must not be null");
    }

    public void onException(l.b bVar) {
        SessionAnalyticsManager sessionAnalyticsManager = this.analyticsManager;
        if (sessionAnalyticsManager != null) {
            sessionAnalyticsManager.onError(bVar.b());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.fabric.sdk.android.l
    @SuppressLint({"NewApi"})
    public boolean onPreExecute() {
        long lastModified;
        try {
            Context context = getContext();
            PackageManager packageManager = context.getPackageManager();
            String packageName = context.getPackageName();
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 0);
            String num = Integer.toString(packageInfo.versionCode);
            String str = packageInfo.versionName == null ? "0.0" : packageInfo.versionName;
            if (Build.VERSION.SDK_INT >= 9) {
                lastModified = packageInfo.firstInstallTime;
            } else {
                lastModified = new File(packageManager.getApplicationInfo(packageName, 0).sourceDir).lastModified();
            }
            this.analyticsManager = SessionAnalyticsManager.build(this, context, getIdManager(), num, str, lastModified);
            this.analyticsManager.enable();
            this.firebaseEnabled = new s().b(context);
            return true;
        } catch (Exception e2) {
            f.f().c(TAG, "Error retrieving app properties", e2);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.fabric.sdk.android.l
    public Boolean doInBackground() {
        try {
            u a2 = io.fabric.sdk.android.services.settings.s.b().a();
            if (a2 == null) {
                f.f().e(TAG, "Failed to retrieve settings");
                return false;
            }
            if (a2.f27058d.f27030d) {
                f.f().d(TAG, "Analytics collection enabled");
                this.analyticsManager.setAnalyticsSettingsData(a2.f27059e, getOverridenSpiEndpoint());
                return true;
            }
            f.f().d(TAG, "Analytics collection disabled");
            this.analyticsManager.disable();
            return false;
        } catch (Exception e2) {
            f.f().c(TAG, "Error dealing with settings", e2);
            return false;
        }
    }

    public void onException(l.a aVar) {
        SessionAnalyticsManager sessionAnalyticsManager = this.analyticsManager;
        if (sessionAnalyticsManager != null) {
            sessionAnalyticsManager.onCrash(aVar.b(), aVar.a());
        }
    }
}
