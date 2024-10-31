package com.nexstreaming.kinemaster.ui.projectedit;

import android.widget.Button;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;

/* compiled from: VoiceRecorderFragment.kt */
/* loaded from: classes2.dex */
final class Eh implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Gh f21834a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Eh(Gh gh) {
        this.f21834a = gh;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public final void onTaskEvent(Task task, Task.Event event) {
        Button button;
        Button button2;
        Button button3;
        if (this.f21834a.f21881a.f21906a.isAdded()) {
            Gh gh = this.f21834a;
            gh.f21882b.a(gh.f21881a.f21906a);
            button = this.f21834a.f21881a.f21906a.o;
            if (button != null) {
                button2 = this.f21834a.f21881a.f21906a.o;
                if (button2 != null) {
                    button2.setText(this.f21834a.f21881a.f21906a.getResources().getText(R.string.voicerec_btn_stop));
                    button3 = this.f21834a.f21881a.f21906a.o;
                    if (button3 == null) {
                        kotlin.jvm.internal.h.a();
                        throw null;
                    }
                    button3.setEnabled(true);
                } else {
                    kotlin.jvm.internal.h.a();
                    throw null;
                }
            }
            this.f21834a.f21881a.f21906a.n(R.string.voicerec_desc_title_inprogress);
            this.f21834a.f21883c.b();
        }
    }
}
