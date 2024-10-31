package com.adobe.creativesdk.foundation.internal.auth;

import com.adobe.creativesdk.foundation.auth.AdobeAuthErrorCode;
import com.adobe.creativesdk.foundation.auth.AdobeAuthException;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.facebook.GraphResponse;
import com.facebook.internal.AnalyticsEvents;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeAuthManager.java */
/* loaded from: classes.dex */
public class C implements V {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.internal.analytics.f f4794a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ boolean f4795b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ AdobeAuthInteraction f4796c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ E f4797d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C(E e2, com.adobe.creativesdk.foundation.internal.analytics.f fVar, boolean z, AdobeAuthInteraction adobeAuthInteraction) {
        this.f4797d = e2;
        this.f4794a = fVar;
        this.f4795b = z;
        this.f4796c = adobeAuthInteraction;
    }

    @Override // com.adobe.creativesdk.foundation.internal.auth.V
    public void a(String str, String str2) {
        AdobeAuthIdentityManagementService o;
        com.adobe.creativesdk.foundation.internal.analytics.q.a("Valid Authentication Token", str);
        this.f4794a.b(GraphResponse.SUCCESS_KEY);
        this.f4794a.a();
        if (this.f4795b) {
            o = this.f4797d.o();
            o.r("ims");
        }
        this.f4797d.a(this.f4795b);
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "Authentication", "Successfully logged in");
    }

    @Override // com.adobe.creativesdk.foundation.internal.auth.V
    public void a(AdobeAuthException adobeAuthException) {
        if (adobeAuthException.getErrorCode() == AdobeAuthErrorCode.ADOBE_AUTH_ERROR_CODE_AGE_VERIFICATION || adobeAuthException.getErrorCode() == AdobeAuthErrorCode.ADOBE_AUTH_ERROR_CODE_EMAIL_VERIFICATION || adobeAuthException.getErrorCode() == AdobeAuthErrorCode.ADOBE_AUTH_ERROR_CODE_UPDATED_TOU) {
            this.f4797d.a(adobeAuthException);
            return;
        }
        if (adobeAuthException.getErrorCode() == AdobeAuthErrorCode.ADOBE_AUTH_ERROR_CODE_USER_CANCELLED) {
            this.f4794a.b(AnalyticsEvents.PARAMETER_SHARE_OUTCOME_CANCELLED);
        } else {
            this.f4794a.b("failure");
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "Authentication", "Login Error");
        }
        this.f4794a.a();
        this.f4797d.a(this.f4795b, adobeAuthException);
    }

    @Override // com.adobe.creativesdk.foundation.internal.auth.V
    public void a(AdobeAuthIMSInfoNeeded adobeAuthIMSInfoNeeded) {
        if (this.f4796c == AdobeAuthInteraction.AdobeAuthInteractionInteractive) {
            if (adobeAuthIMSInfoNeeded == AdobeAuthIMSInfoNeeded.AdobeAuthIMSInfoNeededUsernameAndPassword) {
                this.f4797d.a(C0297a.f4868a);
                return;
            } else {
                a(new AdobeAuthException(AdobeAuthErrorCode.ADOBE_AUTH_ERROR_CODE_USER_INTERACTION_REQUIRED));
                return;
            }
        }
        a(new AdobeAuthException(AdobeAuthErrorCode.ADOBE_AUTH_ERROR_CODE_USER_INTERACTION_REQUIRED));
    }
}
