package com.nextreaming.nexeditorui.fontbrowser;

import android.widget.ImageButton;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.widget.Toolbar;

/* compiled from: FontBrowserActivity.java */
/* loaded from: classes.dex */
class g implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ f f4631a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.f4631a = fVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        String str;
        Toolbar toolbar;
        ImageButton imageButton = (ImageButton) this.f4631a.c.findViewById(R.id.button_font_install);
        imageButton.setVisibility(0);
        imageButton.setEnabled(true);
        this.f4631a.f4630a.dismiss();
        String m = this.f4631a.b.m();
        str = this.f4631a.d.f4629a.h;
        if (m.equals(str)) {
            this.f4631a.d.f4629a.h = null;
            toolbar = this.f4631a.d.f4629a.d;
            toolbar.a(1);
        }
    }
}
