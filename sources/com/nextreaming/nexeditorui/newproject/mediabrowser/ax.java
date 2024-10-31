package com.nextreaming.nexeditorui.newproject.mediabrowser;

import android.widget.AbsListView;
import com.nexstreaming.kinemaster.mediastore.v2.MediaItemType;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStore;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaBrowserFragment.java */
/* loaded from: classes.dex */
public class ax implements AbsListView.OnScrollListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MediaBrowserFragment f4720a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(MediaBrowserFragment mediaBrowserFragment) {
        this.f4720a = mediaBrowserFragment;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        List list;
        MediaStore mediaStore;
        int i4;
        int i5;
        List list2;
        int i6;
        MediaStore mediaStore2;
        List list3;
        MediaStore mediaStore3;
        MediaStore mediaStore4;
        MediaStore.a aVar;
        List list4;
        if (i2 > 0) {
            list = this.f4720a.q;
            if (list != null && this.f4720a.f4692a != i) {
                mediaStore = this.f4720a.s;
                if (mediaStore != null) {
                    if (i > this.f4720a.f4692a) {
                        i5 = i + (i2 / 2);
                        i4 = i5 + 36;
                    } else {
                        i4 = i - 1;
                        i5 = i4 - 12;
                    }
                    this.f4720a.f4692a = i;
                    if (i5 < 0) {
                        i5 = 0;
                    }
                    if (i4 > i3 - 1) {
                        i4 = i3 - 1;
                    }
                    list2 = this.f4720a.q;
                    if (i4 > list2.size() - 1) {
                        list4 = this.f4720a.q;
                        i6 = list4.size() - 1;
                    } else {
                        i6 = i4;
                    }
                    if (i6 > i5) {
                        mediaStore2 = this.f4720a.s;
                        mediaStore2.c();
                        while (i5 <= i6) {
                            list3 = this.f4720a.q;
                            MediaStoreItem mediaStoreItem = (MediaStoreItem) list3.get(i5);
                            if (mediaStoreItem == null || mediaStoreItem.b() != MediaItemType.FOLDER) {
                                mediaStore3 = this.f4720a.s;
                                mediaStore3.a(mediaStoreItem, (MediaStore.a) null);
                            } else {
                                mediaStore4 = this.f4720a.s;
                                aVar = this.f4720a.R;
                                mediaStore4.a(mediaStoreItem, aVar);
                            }
                            i5++;
                        }
                    }
                }
            }
        }
    }
}
