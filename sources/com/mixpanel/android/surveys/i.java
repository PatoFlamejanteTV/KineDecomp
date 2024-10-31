package com.mixpanel.android.surveys;

import android.content.DialogInterface;
import com.mixpanel.android.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SurveyActivity.java */
/* loaded from: classes.dex */
public class i implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SurveyActivity f3071a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(SurveyActivity surveyActivity) {
        this.f3071a = surveyActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        int i2;
        this.f3071a.findViewById(a.c.com_mixpanel_android_activity_survey_id).setVisibility(0);
        this.f3071a.h = true;
        SurveyActivity surveyActivity = this.f3071a;
        i2 = this.f3071a.i;
        surveyActivity.a(i2);
    }
}
