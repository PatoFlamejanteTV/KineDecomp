package com.nexstreaming.sdk2.nexsns;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.sdk2.nexsns.SNS;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DropBox.java */
/* loaded from: classes.dex */
public class c implements ad {

    /* renamed from: a, reason: collision with root package name */
    String f4421a;
    final /* synthetic */ Uri b;
    final /* synthetic */ b c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, Uri uri) {
        this.c = bVar;
        this.b = uri;
    }

    @Override // com.nexstreaming.sdk2.nexsns.ad
    public Task a() {
        WeakReference weakReference;
        boolean z;
        Task task = new Task();
        weakReference = this.c.f4420a;
        Activity activity = (Activity) weakReference.get();
        if (activity == null) {
            task.sendFailure(Task.makeTaskError("no activity"));
            return task;
        }
        PackageManager packageManager = activity.getPackageManager();
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("video/*");
        intent.putExtra("android.intent.extra.STREAM", this.b);
        Iterator<ResolveInfo> it = packageManager.queryIntentActivities(intent, 0).iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            ResolveInfo next = it.next();
            if (next.activityInfo.packageName.equals("com.dropbox.android")) {
                intent.setClassName(next.activityInfo.packageName, next.activityInfo.name);
                z = true;
                break;
            }
        }
        if (z) {
            this.c.b = task;
            activity.startActivity(intent);
            return task;
        }
        task.sendFailure(SNS.SNSErrorCode.AppMissingOrNeedsUpdate);
        return task;
    }

    @Override // com.nexstreaming.sdk2.nexsns.ad
    public ad a(String str) {
        this.f4421a = str;
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
