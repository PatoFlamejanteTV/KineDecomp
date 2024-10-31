package com.nexstreaming.kinemaster.editorwrapper;

import android.content.DialogInterface;
import android.os.SystemClock;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VideoEditor.java */
/* loaded from: classes.dex */
public class tb implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ VideoEditor f20365a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public tb(VideoEditor videoEditor) {
        this.f20365a = videoEditor;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        long unused = VideoEditor.f20264e = SystemClock.uptimeMillis();
        dialogInterface.dismiss();
    }
}
