package com.nextreaming.nexeditorui.fontbrowser;

import android.view.View;
import android.widget.ImageButton;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;

/* compiled from: FontListAdapter.java */
/* loaded from: classes.dex */
class w implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ v f4647a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar) {
        this.f4647a = vVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        View.OnClickListener onClickListener;
        ImageButton imageButton = (ImageButton) this.f4647a.c.findViewById(R.id.button_font_install);
        imageButton.setVisibility(0);
        imageButton.setEnabled(true);
        onClickListener = this.f4647a.d.f4645a.d;
        imageButton.setOnClickListener(onClickListener);
        this.f4647a.f4646a.dismiss();
    }
}
