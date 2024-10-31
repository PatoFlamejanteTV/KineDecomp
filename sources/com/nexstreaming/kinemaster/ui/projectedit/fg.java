package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.ui.store.controller.StoreActivity;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectEditingFragmentBase.kt */
/* loaded from: classes2.dex */
public final class Fg implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Bg f21851a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fg(Bg bg) {
        this.f21851a = bg;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        FragmentManager fragmentManager = this.f21851a.getFragmentManager();
        if (fragmentManager != null) {
            Fragment findFragmentById = fragmentManager.findFragmentById(R.id.expandedOptionPanelHolder);
            if (findFragmentById == null || !(findFragmentById instanceof com.nexstreaming.kinemaster.ui.assetbrowser.i)) {
                return;
            }
            Intent intent = new Intent(this.f21851a.getActivity(), (Class<?>) StoreActivity.class);
            if (this.f21851a.da() != null) {
                VideoEditor da = this.f21851a.da();
                if (da == null) {
                    kotlin.jvm.internal.h.a();
                    throw null;
                }
                if (da.t() != null) {
                    VideoEditor da2 = this.f21851a.da();
                    if (da2 == null) {
                        kotlin.jvm.internal.h.a();
                        throw null;
                    }
                    File t = da2.t();
                    kotlin.jvm.internal.h.a((Object) t, "getVideoEditor()!!.projectFile");
                    intent.putExtra("SELECTED_PROJECT", t.getAbsolutePath());
                }
            }
            intent.putExtra("SPECIFIC_URL", ((com.nexstreaming.kinemaster.ui.assetbrowser.i) findFragmentById).xa().name());
            this.f21851a.startActivity(intent);
            return;
        }
        kotlin.jvm.internal.h.a();
        throw null;
    }
}
