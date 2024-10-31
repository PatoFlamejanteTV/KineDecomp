package com.google.android.gms.auth.api.signin.internal;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

@KeepName
/* loaded from: classes.dex */
public class SignInHubActivity extends FragmentActivity {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f10590a = false;

    /* renamed from: b, reason: collision with root package name */
    private boolean f10591b = false;

    /* renamed from: c, reason: collision with root package name */
    private SignInConfiguration f10592c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f10593d;

    /* renamed from: e, reason: collision with root package name */
    private int f10594e;

    /* renamed from: f, reason: collision with root package name */
    private Intent f10595f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements LoaderManager.LoaderCallbacks<Void> {
        private a() {
        }

        @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
        public final Loader<Void> onCreateLoader(int i, Bundle bundle) {
            return new zze(SignInHubActivity.this, GoogleApiClient.e());
        }

        @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
        public final /* synthetic */ void onLoadFinished(Loader<Void> loader, Void r3) {
            SignInHubActivity signInHubActivity = SignInHubActivity.this;
            signInHubActivity.setResult(signInHubActivity.f10594e, SignInHubActivity.this.f10595f);
            SignInHubActivity.this.finish();
        }

        @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
        public final void onLoaderReset(Loader<Void> loader) {
        }
    }

    private final void b(int i) {
        Status status = new Status(i);
        Intent intent = new Intent();
        intent.putExtra("googleSignInStatus", status);
        setResult(0, intent);
        finish();
        f10590a = false;
    }

    private final void s() {
        getSupportLoaderManager().initLoader(0, null, new a());
        f10590a = false;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.f10591b) {
            return;
        }
        setResult(0);
        if (i != 40962) {
            return;
        }
        if (intent != null) {
            SignInAccount signInAccount = (SignInAccount) intent.getParcelableExtra("signInAccount");
            if (signInAccount != null && signInAccount.a() != null) {
                GoogleSignInAccount a2 = signInAccount.a();
                zzp.a(this).a(this.f10592c.zzm(), a2);
                intent.removeExtra("signInAccount");
                intent.putExtra("googleSignInAccount", a2);
                this.f10593d = true;
                this.f10594e = i2;
                this.f10595f = intent;
                s();
                return;
            }
            if (intent.hasExtra("errorCode")) {
                int intExtra = intent.getIntExtra("errorCode", 8);
                if (intExtra == 13) {
                    intExtra = 12501;
                }
                b(intExtra);
                return;
            }
        }
        b(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        String action = intent.getAction();
        if ("com.google.android.gms.auth.NO_IMPL".equals(action)) {
            b(12500);
            return;
        }
        if (!action.equals("com.google.android.gms.auth.GOOGLE_SIGN_IN") && !action.equals("com.google.android.gms.auth.APPAUTH_SIGN_IN")) {
            String valueOf = String.valueOf(intent.getAction());
            Log.e("AuthSignInClient", valueOf.length() != 0 ? "Unknown action: ".concat(valueOf) : new String("Unknown action: "));
            finish();
            return;
        }
        this.f10592c = (SignInConfiguration) intent.getBundleExtra("config").getParcelable("config");
        if (this.f10592c == null) {
            Log.e("AuthSignInClient", "Activity started with invalid configuration.");
            setResult(0);
            finish();
            return;
        }
        if (bundle == null) {
            if (f10590a) {
                setResult(0);
                b(12502);
                return;
            }
            f10590a = true;
            Intent intent2 = new Intent(action);
            if (action.equals("com.google.android.gms.auth.GOOGLE_SIGN_IN")) {
                intent2.setPackage("com.google.android.gms");
            } else {
                intent2.setPackage(getPackageName());
            }
            intent2.putExtra("config", this.f10592c);
            try {
                startActivityForResult(intent2, 40962);
                return;
            } catch (ActivityNotFoundException unused) {
                this.f10591b = true;
                Log.w("AuthSignInClient", "Could not launch sign in Intent. Google Play Service is probably being updated...");
                b(17);
                return;
            }
        }
        this.f10593d = bundle.getBoolean("signingInGoogleApiClients");
        if (this.f10593d) {
            this.f10594e = bundle.getInt("signInResultCode");
            this.f10595f = (Intent) bundle.getParcelable("signInResultData");
            s();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("signingInGoogleApiClients", this.f10593d);
        if (this.f10593d) {
            bundle.putInt("signInResultCode", this.f10594e);
            bundle.putParcelable("signInResultData", this.f10595f);
        }
    }
}
