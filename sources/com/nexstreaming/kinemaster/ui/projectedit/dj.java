package com.nexstreaming.kinemaster.ui.projectedit;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.AsyncTask;
import com.nextreaming.nexeditorui.NexVideoClipItem;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OptionCroppingFragment.java */
/* loaded from: classes.dex */
public class dj extends AsyncTask<NexVideoClipItem, Void, Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ OptionCroppingFragment f3844a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dj(OptionCroppingFragment optionCroppingFragment) {
        this.f3844a = optionCroppingFragment;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Bitmap doInBackground(NexVideoClipItem... nexVideoClipItemArr) {
        NexVideoClipItem nexVideoClipItem = nexVideoClipItemArr[0];
        if (nexVideoClipItem == null) {
            return null;
        }
        try {
            long duration = (nexVideoClipItem.getDuration() - nexVideoClipItem.getTrimTimeEnd()) - nexVideoClipItem.getEndOverlap();
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(nexVideoClipItem.getMediaPath());
            long parseLong = Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
            if (duration >= parseLong) {
                duration = parseLong - 1;
            }
            return mediaMetadataRetriever.getFrameAtTime(duration * 1000, 3);
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
            this.f3844a.i = bitmap;
            this.f3844a.c();
        } else if (this.f3844a.a() != null) {
            NexVideoClipItem a2 = this.f3844a.a();
            i = this.f3844a.f;
            a2.getStartThumbnail(i).onResultAvailable(new dk(this));
        }
        super.onPostExecute(bitmap);
    }
}
