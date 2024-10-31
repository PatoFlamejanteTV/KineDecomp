package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Handler;
import android.view.View;

/* compiled from: AdobeUXAssetOneUpViewerActivity.java */
/* loaded from: classes.dex */
public class Y implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Handler f5888a;

    /* renamed from: b */
    final /* synthetic */ Activity f5889b;

    /* renamed from: c */
    final /* synthetic */ View f5890c;

    /* renamed from: d */
    final /* synthetic */ View f5891d;

    /* renamed from: e */
    final /* synthetic */ AdobeUXAssetOneUpViewerActivity f5892e;

    public Y(AdobeUXAssetOneUpViewerActivity adobeUXAssetOneUpViewerActivity, Handler handler, Activity activity, View view, View view2) {
        this.f5892e = adobeUXAssetOneUpViewerActivity;
        this.f5888a = handler;
        this.f5889b = activity;
        this.f5890c = view;
        this.f5891d = view2;
    }

    @Override // java.lang.Runnable
    public void run() {
        X x = new X(this);
        int i = (int) (Resources.getSystem().getDisplayMetrics().density * 5.0f);
        this.f5892e.J = true;
        com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.j a2 = this.f5892e.F.a();
        Activity activity = this.f5889b;
        a2.a(activity, activity.getString(c.a.a.a.b.i.adobe_csdk_coach_mark_screenshot_add_annotations_title), this.f5889b.getString(c.a.a.a.b.i.adobe_csdk_coach_mark_screenshot_add_annotations_body), this.f5889b.getString(c.a.a.a.b.i.adobe_csdk_coach_mark_common_footer), this.f5891d, false, i, x);
    }
}
