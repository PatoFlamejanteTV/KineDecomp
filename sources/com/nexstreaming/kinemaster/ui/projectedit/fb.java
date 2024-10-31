package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import com.nexstreaming.kinemaster.tracelog.KMAppUsage;
import com.nextreaming.nexeditorui.EditorGlobal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OptionPanelDefaultFragment.java */
/* loaded from: classes.dex */
public class fb implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SharedPreferences f3892a;
    final /* synthetic */ ez b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fb(ez ezVar, SharedPreferences sharedPreferences) {
        this.b = ezVar;
        this.f3892a = sharedPreferences;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f3892a.edit().putBoolean("native_camera_import_warning", true).commit();
        dialogInterface.dismiss();
        Intent intent = new Intent("android.media.action.VIDEO_CAPTURE");
        EditorGlobal.a(intent);
        this.b.o().B();
        KMAppUsage.a(this.b.getActivity()).a(KMAppUsage.KMMetric.RecVideo);
        this.b.startActivityForResult(intent, 2);
    }
}
