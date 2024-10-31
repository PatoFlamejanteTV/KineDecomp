package com.mixpanel.android.mpmetrics;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import com.mixpanel.android.mpmetrics.UpdateDisplayState;
import com.mixpanel.android.mpmetrics.c;
import com.mixpanel.android.mpmetrics.n;
import com.mixpanel.android.surveys.SurveyActivity;

/* compiled from: MixpanelAPI.java */
/* loaded from: classes.dex */
public class s implements c.b {

    /* renamed from: a */
    final /* synthetic */ UpdateDisplayState.DisplayState.SurveyState f3046a;
    final /* synthetic */ Activity b;
    final /* synthetic */ int c;
    final /* synthetic */ n.d d;

    public s(n.d dVar, UpdateDisplayState.DisplayState.SurveyState surveyState, Activity activity, int i) {
        this.d = dVar;
        this.f3046a = surveyState;
        this.b = activity;
        this.c = i;
    }

    @Override // com.mixpanel.android.mpmetrics.c.b
    public void a(Bitmap bitmap, int i) {
        this.f3046a.a(bitmap);
        this.f3046a.a(i);
        Intent intent = new Intent(this.b.getApplicationContext(), (Class<?>) SurveyActivity.class);
        intent.addFlags(268435456);
        intent.addFlags(131072);
        intent.putExtra("com.mixpanel.android.surveys.SurveyActivity.INTENT_ID_KEY", this.c);
        this.b.startActivity(intent);
    }
}
