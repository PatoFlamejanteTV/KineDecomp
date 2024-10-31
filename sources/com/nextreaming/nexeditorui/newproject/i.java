package com.nextreaming.nexeditorui.newproject;

import android.util.Log;
import android.view.View;
import com.nexstreaming.app.kinemasterfree.R;
import com.nextreaming.nexeditorui.newproject.NewProjectActivity;

/* compiled from: NewProjectActivity.java */
/* loaded from: classes3.dex */
class i implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NewProjectActivity f24371a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(NewProjectActivity newProjectActivity) {
        this.f24371a = newProjectActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        NewProjectActivity.Step step;
        int id = view.getId();
        Log.i("NewProjectActivity", "Click view : " + id);
        switch (id) {
            case R.id.linear_step_media /* 2131362926 */:
            case R.id.linear_step_music /* 2131362927 */:
            case R.id.linear_step_text /* 2131362929 */:
            case R.id.linear_step_theme /* 2131362930 */:
                NewProjectActivity.Step findStepById = NewProjectActivity.Step.findStepById(id);
                step = this.f24371a.W;
                if (step != findStepById) {
                    this.f24371a.a(findStepById);
                    return;
                }
                return;
            case R.id.linear_step_next /* 2131362928 */:
                this.f24371a.K();
                return;
            default:
                return;
        }
    }
}
