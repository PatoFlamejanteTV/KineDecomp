package com.mixpanel.android.surveys;

import android.content.DialogInterface;

/* compiled from: SurveyActivity.java */
/* loaded from: classes.dex */
class j implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SurveyActivity f3072a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(SurveyActivity surveyActivity) {
        this.f3072a = surveyActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f3072a.finish();
    }
}
