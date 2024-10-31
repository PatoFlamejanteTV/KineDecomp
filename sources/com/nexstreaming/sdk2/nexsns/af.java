package com.nexstreaming.sdk2.nexsns;

import android.app.Activity;
import android.graphics.Bitmap;
import android.util.Log;
import com.facebook.internal.AnalyticsEvents;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.mediastore.v2.MSID;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem;
import com.nexstreaming.kinemaster.mediastore.v2.providers.AndroidMediaStoreProvider;
import com.nexstreaming.kinemaster.usage.KMUsage;
import com.tencent.mm.sdk.modelmsg.SendMessageToWX;
import com.tencent.mm.sdk.modelmsg.WXFileObject;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.openapi.IWXAPI;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.List;

/* compiled from: Wechat.java */
/* loaded from: classes.dex */
class af implements ad {

    /* renamed from: a, reason: collision with root package name */
    String f4417a;
    final /* synthetic */ File b;
    final /* synthetic */ ae c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ae aeVar, File file) {
        this.c = aeVar;
        this.b = file;
    }

    @Override // com.nexstreaming.sdk2.nexsns.ad
    public Task a() {
        WeakReference weakReference;
        MSID a2;
        String d;
        Task task = new Task();
        weakReference = this.c.f4416a;
        Activity activity = (Activity) weakReference.get();
        IWXAPI wXAPIInstance = KMUsage.getWXAPIInstance(activity);
        if (activity == null) {
            task.sendFailure(Task.makeTaskError("no activity"));
            return task;
        }
        if (!wXAPIInstance.isWXAppInstalled()) {
            task.sendFailure(Task.makeTaskError("Wechat is not installed"));
            return task;
        }
        if (!wXAPIInstance.isWXAppSupportAPI()) {
            task.sendFailure(Task.makeTaskError("Wechat Api not support"));
            return task;
        }
        AndroidMediaStoreProvider androidMediaStoreProvider = new AndroidMediaStoreProvider(activity);
        if (androidMediaStoreProvider != null && this.b != null && (a2 = AndroidMediaStoreProvider.a(this.b)) != null) {
            MediaStoreItem a3 = androidMediaStoreProvider.a(a2);
            Bitmap bitmap = null;
            try {
                bitmap = androidMediaStoreProvider.a(a3, false);
            } catch (NullPointerException e) {
                e.printStackTrace();
                Log.i("WechatSNS", "MediaStoreItem is null");
            }
            WXFileObject wXFileObject = new WXFileObject();
            wXFileObject.filePath = this.b.getAbsolutePath();
            if (wXFileObject.checkArgs()) {
                WXMediaMessage wXMediaMessage = new WXMediaMessage(wXFileObject);
                wXMediaMessage.title = this.b.getName();
                wXMediaMessage.description = activity.getString(R.string.app_name);
                if (bitmap != null && !bitmap.isRecycled()) {
                    wXMediaMessage.setThumbImage(bitmap);
                    bitmap.recycle();
                }
                SendMessageToWX.Req req = new SendMessageToWX.Req();
                d = this.c.d(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_VIDEO);
                req.transaction = d;
                req.message = wXMediaMessage;
                req.scene = 0;
                wXAPIInstance.sendReq(req);
            } else {
                task.sendFailure(Task.makeTaskError("Video file size too large (Limit size : 10 Mb)"));
            }
            return task;
        }
        task.signalEvent(Task.Event.SUCCESS, Task.Event.FAIL);
        return task;
    }

    @Override // com.nexstreaming.sdk2.nexsns.ad
    public ad a(String str) {
        this.f4417a = str;
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
