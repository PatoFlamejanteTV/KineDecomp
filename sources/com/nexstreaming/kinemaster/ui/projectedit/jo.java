package com.nexstreaming.kinemaster.ui.projectedit;

import android.app.Fragment;
import com.nexstreaming.app.kinemasterfree.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectEditActivity.java */
/* loaded from: classes.dex */
public class jo implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectEditActivity f4012a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public jo(ProjectEditActivity projectEditActivity) {
        this.f4012a = projectEditActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        Fragment findFragmentById = this.f4012a.getFragmentManager().findFragmentById(R.id.expandedOptionPanelHolder);
        if (findFragmentById == null) {
            findFragmentById = this.f4012a.getFragmentManager().findFragmentById(R.id.optionPanelHolder);
        }
        if (findFragmentById != null) {
            if (findFragmentById instanceof OptionCroppingFragment) {
                this.f4012a.b(false);
                this.f4012a.d(true);
                this.f4012a.c(true);
            } else {
                this.f4012a.b(true);
                this.f4012a.d(true);
                this.f4012a.c(true);
            }
        }
    }
}
