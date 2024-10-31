package com.nexstreaming.kinemaster.ui.settings;

import android.view.View;
import android.widget.ProgressBar;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.a.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeviceCapabilityInfoFragment.java */
/* loaded from: classes.dex */
public class m implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ j f4263a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(j jVar) {
        this.f4263a = jVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        ProgressBar progressBar;
        View view;
        new a.C0074a(this.f4263a.getActivity()).a(R.string.capability_db_update_fail).a(R.string.button_ok, new n(this)).a().show();
        progressBar = this.f4263a.i;
        progressBar.setVisibility(8);
        view = this.f4263a.j;
        view.setVisibility(8);
    }
}
