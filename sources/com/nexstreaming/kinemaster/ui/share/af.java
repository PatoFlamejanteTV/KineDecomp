package com.nexstreaming.kinemaster.ui.share;

import android.util.Log;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.a.a;
import com.nexstreaming.sdk2.nexsns.SNS;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareBaseActivity.java */
/* loaded from: classes.dex */
public class af implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ad f4290a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ad adVar) {
        this.f4290a = adVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        String string;
        Log.i("ShareBaseActivity", "uploadTask:onFailure : " + taskError.getMessage());
        int i = this.f4290a.i() ? R.string.sns_sharing_title : R.string.sns_upload_title;
        String string2 = this.f4290a.getResources().getString(this.f4290a.h());
        String string3 = this.f4290a.getResources().getString(i, string2);
        if (taskError == SNS.SNSErrorCode.AppMissingOrNeedsUpdate) {
            string = this.f4290a.getResources().getString(R.string.sns_app_need_install_or_update, string2);
        } else {
            string = this.f4290a.getResources().getString(R.string.sns_error_message_detail, string2, taskError.getMessage());
        }
        new a.C0074a(this.f4290a).a(string).d(string3).a(R.string.button_ok, new ah(this)).a(new ag(this)).a().show();
    }
}
