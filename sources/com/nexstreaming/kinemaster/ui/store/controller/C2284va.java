package com.nexstreaming.kinemaster.ui.store.controller;

import android.content.DialogInterface;
import android.preference.PreferenceManager;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.network.InterfaceC1821j;
import com.nexstreaming.kinemaster.ui.a.e;
import com.nexstreaming.kinemaster.usage.AssetDownloadResult;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AssetDetailFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.store.controller.va, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C2284va implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C2290ya f23626a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2284va(C2290ya c2290ya) {
        this.f23626a = c2290ya;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        ProgressBar progressBar;
        TextView textView;
        TextView textView2;
        InterfaceC1821j interfaceC1821j;
        InterfaceC1821j interfaceC1821j2;
        if (this.f23626a.getActivity() == null || this.f23626a.getActivity().isFinishing()) {
            return;
        }
        progressBar = this.f23626a.q;
        progressBar.setVisibility(4);
        textView = this.f23626a.n;
        textView.setVisibility(4);
        textView2 = this.f23626a.o;
        textView2.setVisibility(0);
        e.a aVar = new e.a(this.f23626a.getActivity());
        aVar.c(R.string.button_ok, new DialogInterface.OnClickListener() { // from class: com.nexstreaming.kinemaster.ui.store.controller.e
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        aVar.a(taskError.getLocalizedMessage(this.f23626a.getActivity()));
        if (PreferenceManager.getDefaultSharedPreferences(this.f23626a.getActivity()).getBoolean("asset_dev_mode", false) && taskError.getException() != null) {
            aVar.b(taskError.getException().getMessage());
        }
        aVar.a().show();
        C2290ya c2290ya = this.f23626a;
        interfaceC1821j = c2290ya.w;
        c2290ya.b(interfaceC1821j, false);
        interfaceC1821j2 = this.f23626a.w;
        com.nexstreaming.kinemaster.usage.analytics.j.a(interfaceC1821j2, AssetDownloadResult.DOWNLOAD_FAIL);
    }
}
