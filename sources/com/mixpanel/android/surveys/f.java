package com.mixpanel.android.surveys;

import android.view.MotionEvent;
import android.view.View;
import com.mixpanel.android.a;

/* compiled from: SurveyActivity.java */
/* loaded from: classes.dex */
class f implements View.OnTouchListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SurveyActivity f3068a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(SurveyActivity surveyActivity) {
        this.f3068a = surveyActivity;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            view.setBackgroundResource(a.b.com_mixpanel_android_cta_button_highlight);
            return false;
        }
        view.setBackgroundResource(a.b.com_mixpanel_android_cta_button);
        return false;
    }
}
