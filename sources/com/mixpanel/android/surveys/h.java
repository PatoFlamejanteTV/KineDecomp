package com.mixpanel.android.surveys;

import com.mixpanel.android.mpmetrics.Survey;
import com.mixpanel.android.surveys.CardCarouselLayout;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SurveyActivity.java */
/* loaded from: classes.dex */
public class h implements CardCarouselLayout.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SurveyActivity f3070a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(SurveyActivity surveyActivity) {
        this.f3070a = surveyActivity;
    }

    @Override // com.mixpanel.android.surveys.CardCarouselLayout.b
    public void a(Survey.a aVar, String str) {
        this.f3070a.a(aVar, str);
        this.f3070a.goToNextQuestion();
    }
}
