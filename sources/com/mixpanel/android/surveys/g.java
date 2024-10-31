package com.mixpanel.android.surveys;

import android.view.View;
import com.mixpanel.android.mpmetrics.UpdateDisplayState;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SurveyActivity.java */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SurveyActivity f3069a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(SurveyActivity surveyActivity) {
        this.f3069a = surveyActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        this.f3069a.finish();
        i = this.f3069a.j;
        UpdateDisplayState.a(i);
    }
}
