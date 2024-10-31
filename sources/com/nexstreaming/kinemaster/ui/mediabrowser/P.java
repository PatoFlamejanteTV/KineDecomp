package com.nexstreaming.kinemaster.ui.mediabrowser;

import com.google.android.gms.tasks.OnFailureListener;

/* compiled from: MediaBrowserPresenter.kt */
/* loaded from: classes.dex */
final class P implements OnFailureListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ S f21664a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public P(S s) {
        this.f21664a = s;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0013, code lost:            r0 = r4.f21664a.f21668c;     */
    @Override // com.google.android.gms.tasks.OnFailureListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onFailure(java.lang.Exception r5) {
        /*
            r4 = this;
            java.lang.String r0 = "exception"
            kotlin.jvm.internal.h.b(r5, r0)
            boolean r0 = r5 instanceof com.google.android.gms.common.api.ApiException
            if (r0 == 0) goto L4b
            com.google.android.gms.common.api.ApiException r5 = (com.google.android.gms.common.api.ApiException) r5
            int r0 = r5.getStatusCode()
            r1 = 12501(0x30d5, float:1.7518E-41)
            if (r0 == r1) goto L4b
            com.nexstreaming.kinemaster.ui.mediabrowser.S r0 = r4.f21664a
            com.nexstreaming.kinemaster.ui.mediabrowser.f r0 = com.nexstreaming.kinemaster.ui.mediabrowser.S.f(r0)
            if (r0 == 0) goto L4b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            com.nextreaming.nexeditorui.KineMasterApplication$a r2 = com.nextreaming.nexeditorui.KineMasterApplication.f24058f
            com.nextreaming.nexeditorui.KineMasterApplication r2 = r2.c()
            android.content.res.Resources r2 = r2.getResources()
            r3 = 2131821305(0x7f1102f9, float:1.927535E38)
            java.lang.String r2 = r2.getString(r3)
            r1.append(r2)
            java.lang.String r2 = " : "
            r1.append(r2)
            int r5 = r5.getStatusCode()
            java.lang.String r5 = com.google.android.gms.auth.api.signin.GoogleSignInStatusCodes.a(r5)
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            r0.d(r5)
        L4b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.kinemaster.ui.mediabrowser.P.onFailure(java.lang.Exception):void");
    }
}
