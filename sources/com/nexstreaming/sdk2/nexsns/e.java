package com.nexstreaming.sdk2.nexsns;

import android.content.Context;
import android.net.Uri;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareVideo;
import com.facebook.share.model.ShareVideoContent;
import com.facebook.share.widget.ShareDialog;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.sdk2.nexsns.SNS;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Facebook.java */
/* loaded from: classes.dex */
public class e implements ad {

    /* renamed from: a, reason: collision with root package name */
    String f4423a;
    final /* synthetic */ Uri b;
    final /* synthetic */ d c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, Uri uri) {
        this.c = dVar;
        this.b = uri;
    }

    @Override // com.nexstreaming.sdk2.nexsns.ad
    public Task a() {
        Context p;
        ShareDialog shareDialog;
        Task task = new Task();
        if (ShareDialog.canShow((Class<? extends ShareContent>) ShareVideoContent.class)) {
            p = this.c.p();
            p.grantUriPermission("com.facebook.katana", this.b, 1);
            ShareVideoContent build = new ShareVideoContent.Builder().setContentTitle(this.f4423a).setVideo(new ShareVideo.Builder().setLocalUrl(this.b).build()).build();
            this.c.d = task;
            shareDialog = this.c.b;
            shareDialog.show(build);
        } else {
            task.sendFailure(SNS.SNSErrorCode.AppMissingOrNeedsUpdate);
        }
        return task;
    }

    @Override // com.nexstreaming.sdk2.nexsns.ad
    public ad a(String str) {
        this.f4423a = str;
        return this;
    }

    @Override // com.nexstreaming.sdk2.nexsns.ad
    public ad b(String str) {
        return this;
    }

    @Override // com.nexstreaming.sdk2.nexsns.ad
    public ad a(Privacy privacy) {
        return this;
    }

    @Override // com.nexstreaming.sdk2.nexsns.ad
    public ad a(List<String> list) {
        return this;
    }

    @Override // com.nexstreaming.sdk2.nexsns.ad
    public ad a(ac acVar) {
        return this;
    }
}
