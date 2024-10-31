package com.nexstreaming.kinemaster.ui.share;

import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.ui.widget.TransparentTextButton;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareSNSActivity.java */
/* loaded from: classes.dex */
public class bs implements ResultTask.OnResultAvailableListener<List<com.nexstreaming.sdk2.nexsns.ac>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ShareSNSActivity f4330a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(ShareSNSActivity shareSNSActivity) {
        this.f4330a = shareSNSActivity;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<List<com.nexstreaming.sdk2.nexsns.ac>> resultTask, Task.Event event, List<com.nexstreaming.sdk2.nexsns.ac> list) {
        Spinner spinner;
        List list2;
        List list3;
        Spinner spinner2;
        Spinner spinner3;
        TransparentTextButton transparentTextButton;
        spinner = this.f4330a.c;
        if (spinner.getVisibility() == 0) {
            this.f4330a.o = new ArrayList();
            list2 = this.f4330a.o;
            list2.addAll(list);
            list3 = this.f4330a.o;
            bt btVar = new bt(this, list3);
            spinner2 = this.f4330a.c;
            spinner2.setAdapter((SpinnerAdapter) btVar);
            spinner3 = this.f4330a.c;
            spinner3.setEnabled(true);
            transparentTextButton = this.f4330a.g;
            transparentTextButton.setEnabled(true);
        }
    }
}
