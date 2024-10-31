package com.nexstreaming.kinemaster.ui.projectedit;

import android.media.MediaScannerConnection;
import android.net.Uri;
import android.view.View;
import com.facebook.share.internal.ShareConstants;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;

/* compiled from: OptionPanelDefaultFragment.kt */
/* loaded from: classes2.dex */
public final class Kd implements MediaScannerConnection.MediaScannerConnectionClient {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Bd f21920a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ VideoEditor f21921b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Kd(Bd bd, VideoEditor videoEditor) {
        this.f21920a = bd;
        this.f21921b = videoEditor;
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        kotlin.jvm.internal.h.b(str, "path");
        kotlin.jvm.internal.h.b(uri, ShareConstants.MEDIA_URI);
        View view = this.f21920a.getView();
        if (view != null) {
            view.post(new Jd(this, str));
        }
    }
}
