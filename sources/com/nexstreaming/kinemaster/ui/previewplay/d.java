package com.nexstreaming.kinemaster.ui.previewplay;

import android.widget.SeekBar;
import android.widget.TextView;
import com.nexstreaming.app.general.task.Task;

/* compiled from: PreviewPlayActivity.java */
/* loaded from: classes.dex */
class d implements Task.OnTaskEventListener {

    /* renamed from: a */
    final /* synthetic */ b f3723a;

    public d(b bVar) {
        this.f3723a = bVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        TextView textView;
        int i;
        String a2;
        SeekBar seekBar;
        int i2;
        boolean z;
        this.f3723a.f3721a.m = this.f3723a.f3721a.b().f().a().getTotalTime();
        textView = this.f3723a.f3721a.j;
        PreviewPlayActivity previewPlayActivity = this.f3723a.f3721a;
        i = this.f3723a.f3721a.m;
        a2 = previewPlayActivity.a(i);
        textView.setText(a2);
        seekBar = this.f3723a.f3721a.g;
        i2 = this.f3723a.f3721a.m;
        seekBar.setMax(i2);
        z = this.f3723a.f3721a.f;
        if (z) {
            this.f3723a.f3721a.b().r();
        }
        this.f3723a.f3721a.c();
    }
}
