package com.nexstreaming.kinemaster.ui.projectedit;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.AsyncTask;
import com.nextreaming.nexeditorui.NexVideoClipItem;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OptionCroppingFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.qc, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class AsyncTaskC1988qc extends AsyncTask<NexVideoClipItem, Void, Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ OptionCroppingFragment f22486a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AsyncTaskC1988qc(OptionCroppingFragment optionCroppingFragment) {
        this.f22486a = optionCroppingFragment;
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
            return mediaMetadataRetriever.getFrameAtTime(trimTimeStart * 1000, 3);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Bitmap bitmap) {
        int i;
        if (bitmap != null) {
            this.f22486a.s = bitmap;
            this.f22486a.Aa();
        } else if (this.f22486a.sa() != null) {
            NexVideoClipItem sa = this.f22486a.sa();
            i = this.f22486a.q;
            sa.getStartThumbnail(i).onResultAvailable(new C1979pc(this));
        }
        super.onPostExecute(bitmap);
    }
}
