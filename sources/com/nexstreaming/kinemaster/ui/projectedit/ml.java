package com.nexstreaming.kinemaster.ui.projectedit;

import android.widget.Button;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;

/* compiled from: VoiceRecorderFragment.java */
/* loaded from: classes.dex */
class ml implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ mj f4093a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ml(mj mjVar) {
        this.f4093a = mjVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        Button button;
        Button button2;
        Button button3;
        if (this.f4093a.c.f4089a.isAdded()) {
            this.f4093a.f4091a.a(this.f4093a.c.f4089a);
            button = this.f4093a.c.f4089a.e;
            if (button != null) {
                button2 = this.f4093a.c.f4089a.e;
                button2.setText(this.f4093a.c.f4089a.getResources().getText(R.string.voicerec_btn_stop));
                button3 = this.f4093a.c.f4089a.e;
                button3.setEnabled(true);
            }
            this.f4093a.c.f4089a.f(R.string.voicerec_desc_title_inprogress);
            this.f4093a.b.a();
        }
    }
}
