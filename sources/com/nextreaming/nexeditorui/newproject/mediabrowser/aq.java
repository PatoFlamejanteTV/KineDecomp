package com.nextreaming.nexeditorui.newproject.mediabrowser;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.mediastore.v2.MSID;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStore;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem;
import com.nexstreaming.kinemaster.ui.widget.Toolbar;
import com.nextreaming.nexeditorui.newproject.mediabrowser.MediaBrowserFragment;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaBrowserFragment.java */
/* loaded from: classes.dex */
public class aq implements ResultTask.OnResultAvailableListener<List<MediaStoreItem>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MediaBrowserFragment f4713a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(MediaBrowserFragment mediaBrowserFragment) {
        this.f4713a = mediaBrowserFragment;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<List<MediaStoreItem>> resultTask, Task.Event event, List<MediaStoreItem> list) {
        ProgressBar progressBar;
        Runnable runnable;
        ResultTask<List<MediaStoreItem>> resultTask2;
        ProgressBar progressBar2;
        a aVar;
        MediaStore mediaStore;
        MediaStoreItem mediaStoreItem;
        MediaStore.a aVar2;
        GridView gridView;
        a aVar3;
        GridView gridView2;
        View.OnLayoutChangeListener onLayoutChangeListener;
        GridView gridView3;
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;
        GridView gridView4;
        GridView gridView5;
        AdapterView.OnItemClickListener onItemClickListener;
        GridView gridView6;
        AdapterView.OnItemLongClickListener onItemLongClickListener;
        AbsListView.OnScrollListener onScrollListener;
        GridView gridView7;
        a aVar4;
        MediaStoreItem mediaStoreItem2;
        a aVar5;
        MediaStoreItem mediaStoreItem3;
        View view;
        View view2;
        com.nexstreaming.kinemaster.mediastore.v2.b bVar;
        View view3;
        Toolbar toolbar;
        Toolbar toolbar2;
        com.nexstreaming.kinemaster.mediastore.v2.b bVar2;
        List list2;
        com.nexstreaming.kinemaster.mediastore.v2.b bVar3;
        List list3;
        List list4;
        int size;
        int i;
        int i2;
        com.nexstreaming.kinemaster.mediastore.v2.b bVar4;
        GridView gridView8;
        TextView textView;
        MediaBrowserFragment.MediaViewerMode mediaViewerMode;
        MediaBrowserFragment.MediaViewerMode mediaViewerMode2;
        TextView textView2;
        this.f4713a.F = false;
        progressBar = this.f4713a.p;
        runnable = this.f4713a.G;
        progressBar.removeCallbacks(runnable);
        resultTask2 = this.f4713a.v;
        if (resultTask == resultTask2) {
            progressBar2 = this.f4713a.p;
            progressBar2.setVisibility(8);
            if (list.size() == 0) {
                gridView8 = this.f4713a.k;
                gridView8.setVisibility(8);
                textView = this.f4713a.l;
                textView.setVisibility(0);
                int i3 = R.string.empty_folder;
                mediaViewerMode = this.f4713a.o;
                if (mediaViewerMode != MediaBrowserFragment.MediaViewerMode.IMAGES) {
                    mediaViewerMode2 = this.f4713a.o;
                    if (mediaViewerMode2 == MediaBrowserFragment.MediaViewerMode.VIDEO) {
                        i3 = R.string.empty_video_folder;
                    }
                } else {
                    i3 = R.string.empty_image_folder;
                }
                textView2 = this.f4713a.l;
                textView2.setText(i3);
            } else {
                aVar = this.f4713a.w;
                if (aVar != null) {
                    aVar4 = this.f4713a.w;
                    MSID a2 = aVar4.a();
                    mediaStoreItem2 = this.f4713a.n;
                    if (a2.equals(mediaStoreItem2.c())) {
                        aVar5 = this.f4713a.w;
                        aVar5.a(list);
                        gridView2 = this.f4713a.k;
                        onLayoutChangeListener = this.f4713a.S;
                        gridView2.addOnLayoutChangeListener(onLayoutChangeListener);
                        gridView3 = this.f4713a.k;
                        ViewTreeObserver viewTreeObserver = gridView3.getViewTreeObserver();
                        onGlobalLayoutListener = this.f4713a.T;
                        viewTreeObserver.addOnGlobalLayoutListener(onGlobalLayoutListener);
                        gridView4 = this.f4713a.k;
                        gridView4.setVisibility(0);
                        gridView5 = this.f4713a.k;
                        onItemClickListener = this.f4713a.L;
                        gridView5.setOnItemClickListener(onItemClickListener);
                        gridView6 = this.f4713a.k;
                        onItemLongClickListener = this.f4713a.M;
                        gridView6.setOnItemLongClickListener(onItemLongClickListener);
                        onScrollListener = this.f4713a.O;
                        gridView7 = this.f4713a.k;
                        onScrollListener.onScroll(gridView7, 0, 0, list.size());
                        this.f4713a.f4692a = -1;
                    }
                }
                MediaBrowserFragment mediaBrowserFragment = this.f4713a;
                Activity activity = this.f4713a.getActivity();
                mediaStore = this.f4713a.s;
                mediaStoreItem = this.f4713a.n;
                MSID c = mediaStoreItem.c();
                aVar2 = this.f4713a.R;
                mediaBrowserFragment.w = new a(activity, list, mediaStore, c, aVar2);
                gridView = this.f4713a.k;
                aVar3 = this.f4713a.w;
                gridView.setAdapter((ListAdapter) aVar3);
                gridView2 = this.f4713a.k;
                onLayoutChangeListener = this.f4713a.S;
                gridView2.addOnLayoutChangeListener(onLayoutChangeListener);
                gridView3 = this.f4713a.k;
                ViewTreeObserver viewTreeObserver2 = gridView3.getViewTreeObserver();
                onGlobalLayoutListener = this.f4713a.T;
                viewTreeObserver2.addOnGlobalLayoutListener(onGlobalLayoutListener);
                gridView4 = this.f4713a.k;
                gridView4.setVisibility(0);
                gridView5 = this.f4713a.k;
                onItemClickListener = this.f4713a.L;
                gridView5.setOnItemClickListener(onItemClickListener);
                gridView6 = this.f4713a.k;
                onItemLongClickListener = this.f4713a.M;
                gridView6.setOnItemLongClickListener(onItemLongClickListener);
                onScrollListener = this.f4713a.O;
                gridView7 = this.f4713a.k;
                onScrollListener.onScroll(gridView7, 0, 0, list.size());
                this.f4713a.f4692a = -1;
            }
            this.f4713a.q = list;
            mediaStoreItem3 = this.f4713a.n;
            if (mediaStoreItem3.c().getNamespace().equals("Favorites")) {
                view = this.f4713a.j;
                if (view != null) {
                    view2 = this.f4713a.j;
                    if (view2.getVisibility() == 0) {
                        bVar = this.f4713a.u;
                        if (bVar.a() != null) {
                            bVar2 = this.f4713a.u;
                            if (bVar2.a().size() > 0) {
                                list2 = this.f4713a.q;
                                if (list2.size() > 0) {
                                    bVar3 = this.f4713a.u;
                                    int size2 = bVar3.a().size();
                                    list3 = this.f4713a.q;
                                    if (size2 < list3.size()) {
                                        bVar4 = this.f4713a.u;
                                        size = bVar4.a().size();
                                    } else {
                                        list4 = this.f4713a.q;
                                        size = list4.size();
                                    }
                                    i = this.f4713a.d;
                                    if (i >= size) {
                                        this.f4713a.d = size - 1;
                                    }
                                    MediaBrowserFragment mediaBrowserFragment2 = this.f4713a;
                                    i2 = this.f4713a.d;
                                    mediaBrowserFragment2.a(i2);
                                }
                            }
                        }
                        view3 = this.f4713a.j;
                        view3.setVisibility(8);
                        this.f4713a.A = false;
                        toolbar = this.f4713a.m;
                        if (toolbar != null) {
                            toolbar2 = this.f4713a.m;
                            toolbar2.setHiddenMenuPopup(false);
                        }
                    }
                }
            }
            this.f4713a.d();
        }
    }
}
