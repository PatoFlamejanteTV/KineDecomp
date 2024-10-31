package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;

/* compiled from: AdobeUXAssetOneUpViewerActivity.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.aa */
/* loaded from: classes.dex */
public class RunnableC0359aa implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Activity f5938a;

    /* renamed from: b */
    final /* synthetic */ View f5939b;

    /* renamed from: c */
    final /* synthetic */ AdobeUXAssetOneUpViewerActivity f5940c;

    public RunnableC0359aa(AdobeUXAssetOneUpViewerActivity adobeUXAssetOneUpViewerActivity, Activity activity, View view) {
        this.f5940c = adobeUXAssetOneUpViewerActivity;
        this.f5938a = activity;
        this.f5939b = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i = (int) (Resources.getSystem().getDisplayMetrics().density * 5.0f);
        this.f5940c.J = true;
        com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.j a2 = this.f5940c.F.a();
        Activity activity = this.f5938a;
        a2.a(activity, activity.getString(c.a.a.a.b.i.adobe_csdk_coach_mark_add_comments_title), this.f5938a.getString(c.a.a.a.b.i.adobe_csdk_coach_mark_add_comments_body), this.f5938a.getString(c.a.a.a.b.i.adobe_csdk_coach_mark_common_footer), this.f5939b, false, i, new Z(this));
    }
}
