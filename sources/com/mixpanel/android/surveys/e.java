package com.mixpanel.android.surveys;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import com.mixpanel.android.mpmetrics.InAppNotification;
import com.mixpanel.android.mpmetrics.UpdateDisplayState;
import com.mixpanel.android.mpmetrics.n;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SurveyActivity.java */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ InAppNotification f3067a;
    final /* synthetic */ SurveyActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(SurveyActivity surveyActivity, InAppNotification inAppNotification) {
        this.b = surveyActivity;
        this.f3067a = inAppNotification;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        n nVar;
        String k = this.f3067a.k();
        if (k != null && k.length() > 0) {
            try {
                try {
                    this.b.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(k)));
                    nVar = this.b.c;
                    nVar.c().a("$campaign_open", this.f3067a);
                } catch (ActivityNotFoundException e) {
                    Log.i("MixpanelAPI.SrvyActvty", "User doesn't have an activity for notification URI");
                }
            } catch (IllegalArgumentException e2) {
                Log.i("MixpanelAPI.SrvyActvty", "Can't parse notification URI, will not take any action", e2);
                return;
            }
        }
        this.b.finish();
        i = this.b.j;
        UpdateDisplayState.a(i);
    }
}
