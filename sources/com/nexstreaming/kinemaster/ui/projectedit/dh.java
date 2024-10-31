package com.nexstreaming.kinemaster.ui.projectedit;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.AsyncTask;
import com.nextreaming.nexeditorui.NexVideoClipItem;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OptionCroppingFragment.java */
/* loaded from: classes.dex */
public class dh extends AsyncTask<NexVideoClipItem, Void, Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ OptionCroppingFragment f3842a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dh(OptionCroppingFragment optionCroppingFragment) {
        this.f3842a = optionCroppingFragment;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Bitmap doInBackground(NexVideoClipItem... nexVideoClipItemArr) {
        NexVideoClipItem nexVideoClipItem = nexVideoClipItemArr[0];
        if (nexVideoClipItem == null) {
            return null;
        }
        int trimTimeStart = nexVideoClipItem.getTrimTimeStart() + nexVideoClipItem.getStartOverlap();
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(nexVideoClipItem.getMediaPath());
            return mediaMetadataRetriever.getFrameAtTime(trimTimeStart * LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, 3);
        } catch (Exception e) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Bitmap bitmap) {
        int i;
        if (bitmap != null) {
            this.f3842a.h = bitmap;
            this.f3842a.c();
        } else if (this.f3842a.a() != null) {
            NexVideoClipItem a2 = this.f3842a.a();
            i = this.f3842a.f;
            a2.getStartThumbnail(i).onResultAvailable(new di(this));
        }
        super.onPostExecute(bitmap);
    }
}
