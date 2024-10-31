package com.nexstreaming.kinemaster.ui.settings;

import android.view.View;
import android.widget.ProgressBar;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.tracelog.DeviceSupportResponse;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.a.a;
import com.nextreaming.nexeditorui.NexEditorDeviceProfile;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeviceCapabilityInfoFragment.java */
/* loaded from: classes.dex */
public class o implements ResultTask.OnResultAvailableListener<DeviceSupportResponse> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ j f4265a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(j jVar) {
        this.f4265a = jVar;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<DeviceSupportResponse> resultTask, Task.Event event, DeviceSupportResponse deviceSupportResponse) {
        ProgressBar progressBar;
        View view;
        if (this.f4265a.getActivity() != null) {
            DeviceSupportResponse dsr = NexEditorDeviceProfile.getDeviceProfile().getDSR();
            if (dsr == null || !deviceSupportResponse.device_info.equals(dsr.device_info)) {
                new a.C0074a(this.f4265a.getActivity()).a(R.string.capability_db_update_success_new).a(R.string.button_ok, new p(this)).a().show();
            } else {
                new a.C0074a(this.f4265a.getActivity()).a(R.string.capability_db_update_success).a(R.string.button_ok, new q(this)).a().show();
            }
            this.f4265a.b();
            progressBar = this.f4265a.i;
            progressBar.setVisibility(8);
            view = this.f4265a.j;
            view.setVisibility(8);
        }
    }
}
