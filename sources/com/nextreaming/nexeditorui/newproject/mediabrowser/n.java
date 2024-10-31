package com.nextreaming.nexeditorui.newproject.mediabrowser;

import android.content.DialogInterface;
import android.view.View;
import android.widget.VideoView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStore;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem;
import com.nexstreaming.kinemaster.ui.widget.Toolbar;
import java.util.List;
import java.util.Stack;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaBrowserFragment.java */
/* loaded from: classes.dex */
public class n implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MediaStoreItem f4736a;
    final /* synthetic */ MediaBrowserFragment b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(MediaBrowserFragment mediaBrowserFragment, MediaStoreItem mediaStoreItem) {
        this.b = mediaBrowserFragment;
        this.f4736a = mediaStoreItem;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        MediaStore mediaStore;
        List list;
        a aVar;
        List list2;
        View view;
        Toolbar toolbar;
        View view2;
        Stack stack;
        Stack stack2;
        Stack stack3;
        Toolbar toolbar2;
        com.nexstreaming.kinemaster.mediastore.v2.b bVar;
        int i2;
        List list3;
        int i3;
        List list4;
        mediaStore = this.b.s;
        mediaStore.c(this.f4736a);
        list = this.b.q;
        list.remove(this.f4736a);
        aVar = this.b.w;
        aVar.notifyDataSetChanged();
        list2 = this.b.q;
        if (list2.size() > 0) {
            i2 = this.b.d;
            list3 = this.b.q;
            if (i2 >= list3.size()) {
                MediaBrowserFragment mediaBrowserFragment = this.b;
                list4 = this.b.q;
                mediaBrowserFragment.d = list4.size() - 1;
            }
            MediaBrowserFragment mediaBrowserFragment2 = this.b;
            i3 = this.b.d;
            mediaBrowserFragment2.a(i3);
        } else {
            view = this.b.j;
            view.setVisibility(8);
            this.b.A = false;
            toolbar = this.b.m;
            if (toolbar != null) {
                toolbar2 = this.b.m;
                toolbar2.setHiddenMenuPopup(false);
            }
            view2 = this.b.j;
            VideoView videoView = (VideoView) view2.findViewById(R.id.videoView_content);
            if (videoView.isPlaying()) {
                videoView.stopPlayback();
                videoView.setVisibility(8);
            }
            stack = this.b.r;
            if (!stack.isEmpty() && this.b.isVisible()) {
                stack2 = this.b.r;
                stack2.pop();
                MediaBrowserFragment mediaBrowserFragment3 = this.b;
                stack3 = this.b.r;
                mediaBrowserFragment3.n = (MediaStoreItem) stack3.peek();
                this.b.c();
            }
        }
        bVar = this.b.u;
        bVar.c(this.f4736a.c());
        dialogInterface.dismiss();
    }
}
