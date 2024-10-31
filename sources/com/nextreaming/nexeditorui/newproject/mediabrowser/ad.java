package com.nextreaming.nexeditorui.newproject.mediabrowser;

import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.sdk2.nexsns.SNS;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaBrowserFragment.java */
/* loaded from: classes.dex */
public class ad implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MediaBrowserFragment f4700a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(MediaBrowserFragment mediaBrowserFragment) {
        this.f4700a = mediaBrowserFragment;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        ProgressBar progressBar;
        Runnable runnable;
        ProgressBar progressBar2;
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        TextView textView6;
        TextView textView7;
        progressBar = this.f4700a.p;
        runnable = this.f4700a.G;
        progressBar.removeCallbacks(runnable);
        progressBar2 = this.f4700a.p;
        progressBar2.setVisibility(8);
        textView = this.f4700a.l;
        textView.setVisibility(0);
        if (taskError == SNS.SNSErrorCode.NetworkError) {
            textView7 = this.f4700a.l;
            textView7.setText(R.string.theme_download_server_connection_error);
            return;
        }
        if (taskError == SNS.SNSErrorCode.NeedPermission) {
            textView6 = this.f4700a.l;
            textView6.setText(R.string.service_permission_required);
            return;
        }
        if (taskError == SNS.SNSErrorCode.SignInRequired) {
            textView5 = this.f4700a.l;
            textView5.setText(R.string.service_login_required);
            return;
        }
        Log.w("MediaBrowserFragment", "CloudConnectFail: " + taskError.getMessage());
        if (taskError instanceof SNS.a) {
            textView4 = this.f4700a.l;
            textView4.setText(this.f4700a.getResources().getString(R.string.cloud_connect_fail) + " (" + ((SNS.a) taskError).a() + ")");
        } else if (taskError == SNS.SNSErrorCode.ServiceErrorPopupShown) {
            textView3 = this.f4700a.l;
            textView3.setText(this.f4700a.getResources().getString(R.string.cloud_connect_fail) + " (FAIL_SEPS)");
        } else {
            textView2 = this.f4700a.l;
            textView2.setText(R.string.cloud_connect_fail);
        }
    }
}
