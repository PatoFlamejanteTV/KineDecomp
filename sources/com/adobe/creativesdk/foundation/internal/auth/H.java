package com.adobe.creativesdk.foundation.internal.auth;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import com.adobe.creativesdk.foundation.internal.auth.I;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import java.io.IOException;

/* compiled from: AdobeCSDKAdobeIdAuthenticatorHelper.java */
/* loaded from: classes.dex */
public class H extends AsyncTask<Void, Void, I.b> {

    /* renamed from: a */
    final /* synthetic */ Activity f4814a;

    /* renamed from: b */
    final /* synthetic */ Bundle f4815b;

    /* renamed from: c */
    final /* synthetic */ I.a f4816c;

    /* renamed from: d */
    final /* synthetic */ I f4817d;

    public H(I i, Activity activity, Bundle bundle, I.a aVar) {
        this.f4817d = i;
        this.f4814a = activity;
        this.f4815b = bundle;
        this.f4816c = aVar;
    }

    I.b a() {
        AccountManager accountManager = AccountManager.get(this.f4814a);
        Account[] accountsByType = accountManager.getAccountsByType("com.adobe.creativesdk.foundation.auth.adobeID");
        boolean z = false;
        I.c cVar = null;
        if (accountsByType != null && accountsByType.length > 0 && this.f4817d.a(this.f4814a)) {
            try {
                Bundle result = accountManager.getAuthToken(accountsByType[0], "AdobeID access", this.f4815b, this.f4814a, (AccountManagerCallback<Bundle>) null, (Handler) null).getResult();
                cVar = this.f4817d.c(result.getString("authtoken"));
                a(this.f4814a, result);
            } catch (AuthenticatorException e2) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "AdobeCSDKAdobeIdAuthenticatorHelper", e2.getMessage(), e2);
            } catch (OperationCanceledException e3) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "AdobeCSDKAdobeIdAuthenticatorHelper", e3.getMessage(), e3);
                z = true;
            } catch (IOException e4) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "AdobeCSDKAdobeIdAuthenticatorHelper", e4.getMessage(), e4);
            } catch (Exception e5) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "AdobeCSDKAdobeIdAuthenticatorHelper", e5.getMessage(), e5);
            }
        }
        I.b bVar = new I.b();
        bVar.f4820a = cVar;
        bVar.f4821b = z;
        return bVar;
    }

    private void a(Context context, Bundle bundle) {
        int i;
        String string = bundle.getString("adbAuth_device_token_aes_key", null);
        if (string == null || (i = bundle.getInt("adbAuth_authenticator_uid", -1)) == -1 || i == context.getApplicationInfo().uid) {
            return;
        }
        K.a().a(context, string);
    }

    @Override // android.os.AsyncTask
    /* renamed from: a */
    public I.b doInBackground(Void... voidArr) {
        try {
            return a();
        } catch (Exception e2) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "AdobeCSDKAdobeIdAuthenticatorHelper", e2.getMessage(), e2);
            return null;
        }
    }

    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(I.b bVar) {
        this.f4816c.a(bVar);
    }
}
