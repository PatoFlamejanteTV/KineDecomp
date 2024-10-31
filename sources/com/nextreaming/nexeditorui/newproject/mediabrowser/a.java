package com.nextreaming.nexeditorui.newproject.mediabrowser;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.widget.BaseAdapter;
import com.nexstreaming.kinemaster.mediastore.v2.MSID;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStore;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem;
import java.util.List;

/* compiled from: MediaBrowserAdater.java */
/* loaded from: classes.dex */
public class a extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    private Activity f4695a;
    private List<MediaStoreItem> b;
    private MediaStore c;
    private com.nexstreaming.kinemaster.mediastore.v2.b d;
    private MSID e;
    private Paint f = new Paint();
    private Bitmap g = null;
    private Paint h = null;
    private MediaStore.a i;

    public a(Activity activity, List<MediaStoreItem> list, MediaStore mediaStore, MSID msid, MediaStore.a aVar) {
        this.f4695a = activity;
        this.b = list;
        this.c = mediaStore;
        this.e = msid;
        this.i = aVar;
    }

    public void a(List<MediaStoreItem> list) {
        this.b = list;
        notifyDataSetChanged();
    }

    public MSID a() {
        return this.e;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.b.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.b.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x003f, code lost:            return r13;     */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View getView(int r12, android.view.View r13, android.view.ViewGroup r14) {
        /*
            Method dump skipped, instructions count: 540
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nextreaming.nexeditorui.newproject.mediabrowser.a.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    private boolean a(MediaStoreItem mediaStoreItem) {
        if (this.d == null) {
            this.d = new com.nexstreaming.kinemaster.mediastore.v2.b(this.f4695a);
        }
        if (mediaStoreItem instanceof MediaStoreItem) {
            return this.d.a(mediaStoreItem.c());
        }
        return false;
    }
}
