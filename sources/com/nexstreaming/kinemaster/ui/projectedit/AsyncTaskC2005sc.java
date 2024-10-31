package com.nexstreaming.kinemaster.ui.projectedit;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.AsyncTask;
import com.nextreaming.nexeditorui.NexVideoClipItem;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OptionCroppingFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.sc, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class AsyncTaskC2005sc extends AsyncTask<NexVideoClipItem, Void, Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ OptionCroppingFragment f22520a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AsyncTaskC2005sc(OptionCroppingFragment optionCroppingFragment) {
        this.f22520a = optionCroppingFragment;
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
            this.f22520a.t = bitmap;
            this.f22520a.Aa();
        } else if (this.f22520a.sa() != null) {
            NexVideoClipItem sa = this.f22520a.sa();
            i = this.f22520a.q;
            sa.getStartThumbnail(i).onResultAvailable(new C1996rc(this));
        }
        super.onPostExecute(bitmap);
    }
}
