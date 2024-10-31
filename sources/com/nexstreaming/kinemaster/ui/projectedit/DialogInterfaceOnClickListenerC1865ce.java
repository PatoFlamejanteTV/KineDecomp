package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.tracelog.KMAppUsage;
import com.nextreaming.nexeditorui.EditorGlobal;

/* compiled from: OptionPanelDefaultFragment.kt */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.ce, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class DialogInterfaceOnClickListenerC1865ce implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Bd f22300a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ SharedPreferences f22301b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DialogInterfaceOnClickListenerC1865ce(Bd bd, SharedPreferences sharedPreferences) {
        this.f22300a = bd;
        this.f22301b = sharedPreferences;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f22301b.edit().putBoolean("native_camera_import_warning", true).commit();
        dialogInterface.dismiss();
        Intent intent = new Intent("android.media.action.VIDEO_CAPTURE");
        EditorGlobal.a(intent);
        VideoEditor da = this.f22300a.da();
        if (da != null) {
            da.j();
            KMAppUsage.a(this.f22300a.getActivity()).a(KMAppUsage.KMMetric.RecVideo);
            this.f22300a.startActivityForResult(intent, 2);
            return;
        }
        kotlin.jvm.internal.h.a();
        throw null;
    }
}
