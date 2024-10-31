package com.google.firebase.auth.internal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.Status;

@KeepName
/* loaded from: classes2.dex */
public class FederatedSignInActivity extends FragmentActivity {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f16493a = false;

    /* renamed from: b, reason: collision with root package name */
    private static final zzz f16494b = zzz.a();

    /* renamed from: c, reason: collision with root package name */
    private boolean f16495c = false;

    private final void a(Status status) {
        f16493a = false;
        Intent intent = new Intent();
        zzai.a(intent, status);
        intent.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
        if (!LocalBroadcastManager.getInstance(this).sendBroadcast(intent)) {
            zzac.a(getApplicationContext(), status);
        } else {
            f16494b.a(this);
        }
        finish();
    }

    private final void s() {
        f16493a = false;
        this.f16495c = false;
        Intent intent = new Intent();
        intent.putExtra("com.google.firebase.auth.internal.EXTRA_CANCELED", true);
        intent.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
        if (!LocalBroadcastManager.getInstance(this).sendBroadcast(intent)) {
            zzac.a(this, zzq.a("WEB_CONTEXT_CANCELED"));
        } else {
            f16494b.a(this);
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String action = getIntent().getAction();
        if (!"com.google.firebase.auth.internal.SIGN_IN".equals(action) && !"com.google.firebase.auth.internal.LINK".equals(action) && !"com.google.firebase.auth.internal.REAUTHENTICATE".equals(action)) {
            String valueOf = String.valueOf(action);
            Log.e("IdpSignInActivity", valueOf.length() != 0 ? "Unknown action: ".concat(valueOf) : new String("Unknown action: "));
            s();
        } else {
            if (f16493a) {
                finish();
                return;
            }
            f16493a = true;
            if (bundle != null) {
                this.f16495c = bundle.getBoolean("com.google.firebase.auth.internal.KEY_STARTED_SIGN_IN");
            }
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:10:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x009b A[RETURN] */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onResume() {
        /*
            r9 = this;
            super.onResume()
            android.content.Intent r0 = r9.getIntent()
            java.lang.String r1 = r0.getAction()
            java.lang.String r2 = "com.google.firebase.auth.internal.WEB_SIGN_IN_FAILED"
            boolean r1 = r2.equals(r1)
            java.lang.String r2 = "IdpSignInActivity"
            r3 = 0
            r4 = 1
            java.lang.String r5 = "com.google.firebase.auth.internal.OPERATION"
            if (r1 == 0) goto L31
            java.lang.String r1 = "Web sign-in failed, finishing"
            android.util.Log.e(r2, r1)
            boolean r1 = com.google.firebase.auth.internal.zzai.a(r0)
            if (r1 == 0) goto L2c
            com.google.android.gms.common.api.Status r0 = com.google.firebase.auth.internal.zzai.b(r0)
            r9.a(r0)
            goto L2f
        L2c:
            r9.s()
        L2f:
            r3 = 1
            goto L99
        L31:
            boolean r1 = r0.hasExtra(r5)
            if (r1 == 0) goto L99
            java.lang.String r1 = "com.google.firebase.auth.internal.VERIFY_ASSERTION_REQUEST"
            boolean r6 = r0.hasExtra(r1)
            if (r6 == 0) goto L99
            java.lang.String r6 = r0.getStringExtra(r5)
            java.lang.String r7 = "com.google.firebase.auth.internal.SIGN_IN"
            boolean r7 = r7.equals(r6)
            if (r7 != 0) goto L5b
            java.lang.String r7 = "com.google.firebase.auth.internal.LINK"
            boolean r7 = r7.equals(r6)
            if (r7 != 0) goto L5b
            java.lang.String r7 = "com.google.firebase.auth.internal.REAUTHENTICATE"
            boolean r7 = r7.equals(r6)
            if (r7 == 0) goto L99
        L5b:
            android.os.Parcelable$Creator<com.google.android.gms.internal.firebase_auth.zzdr> r7 = com.google.android.gms.internal.firebase_auth.zzdr.CREATOR
            com.google.android.gms.common.internal.safeparcel.SafeParcelable r7 = com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer.a(r0, r1, r7)
            com.google.android.gms.internal.firebase_auth.zzdr r7 = (com.google.android.gms.internal.firebase_auth.zzdr) r7
            java.lang.String r8 = "com.google.firebase.auth.internal.EXTRA_TENANT_ID"
            java.lang.String r0 = r0.getStringExtra(r8)
            r7.zzcr(r0)
            com.google.firebase.auth.internal.FederatedSignInActivity.f16493a = r3
            android.content.Intent r3 = new android.content.Intent
            r3.<init>()
            com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer.a(r7, r3, r1)
            r3.putExtra(r5, r6)
            java.lang.String r1 = "com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT"
            r3.setAction(r1)
            android.support.v4.content.LocalBroadcastManager r1 = android.support.v4.content.LocalBroadcastManager.getInstance(r9)
            boolean r1 = r1.sendBroadcast(r3)
            if (r1 != 0) goto L90
            android.content.Context r1 = r9.getApplicationContext()
            com.google.firebase.auth.internal.zzac.a(r1, r7, r6, r0)
            goto L95
        L90:
            com.google.firebase.auth.internal.zzz r0 = com.google.firebase.auth.internal.FederatedSignInActivity.f16494b
            r0.a(r9)
        L95:
            r9.finish()
            goto L2f
        L99:
            if (r3 == 0) goto L9c
            return
        L9c:
            boolean r0 = r9.f16495c
            if (r0 != 0) goto Ldb
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r1 = "com.google.firebase.auth.api.gms.ui.START_WEB_SIGN_IN"
            r0.<init>(r1)
            java.lang.String r1 = "com.google.android.gms"
            r0.setPackage(r1)
            android.content.Intent r1 = r9.getIntent()
            android.os.Bundle r1 = r1.getExtras()
            r0.putExtras(r1)
            android.content.Intent r1 = r9.getIntent()
            java.lang.String r1 = r1.getAction()
            r0.putExtra(r5, r1)
            r1 = 40963(0xa003, float:5.7401E-41)
            r9.startActivityForResult(r0, r1)     // Catch: android.content.ActivityNotFoundException -> Lc9
            goto Ld8
        Lc9:
            java.lang.String r0 = "Could not launch web sign-in Intent. Google Play service is unavailable"
            android.util.Log.w(r2, r0)
            com.google.android.gms.common.api.Status r1 = new com.google.android.gms.common.api.Status
            r2 = 17499(0x445b, float:2.4521E-41)
            r1.<init>(r2, r0)
            r9.a(r1)
        Ld8:
            r9.f16495c = r4
            return
        Ldb:
            r9.s()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.auth.internal.FederatedSignInActivity.onResume():void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("com.google.firebase.auth.internal.KEY_STARTED_SIGN_IN", this.f16495c);
    }
}
