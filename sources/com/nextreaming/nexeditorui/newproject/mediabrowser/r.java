package com.nextreaming.nexeditorui.newproject.mediabrowser;

import android.view.View;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.VideoView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.mediastore.v2.MSID;
import com.nexstreaming.kinemaster.mediastore.v2.MediaItemType;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem;
import com.nexstreaming.kinemaster.ui.widget.Toolbar;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaBrowserFragment.java */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MediaBrowserFragment f4740a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(MediaBrowserFragment mediaBrowserFragment) {
        this.f4740a = mediaBrowserFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        List list;
        int i;
        List list2;
        int i2;
        View view2;
        View view3;
        View view4;
        View view5;
        View view6;
        View view7;
        View view8;
        View view9;
        List list3;
        int i3;
        MSID msid;
        com.nexstreaming.kinemaster.mediastore.v2.b bVar;
        GridView gridView;
        com.nexstreaming.kinemaster.mediastore.v2.b bVar2;
        com.nexstreaming.kinemaster.mediastore.v2.b bVar3;
        GridView gridView2;
        MediaStoreItem mediaStoreItem;
        View view10;
        int i4;
        List list4;
        int i5;
        List list5;
        List list6;
        int i6;
        int i7;
        List list7;
        View view11;
        View view12;
        View view13;
        View view14;
        Toolbar toolbar;
        Toolbar toolbar2;
        switch (view.getId()) {
            case R.id.imageButton_media_detail_close /* 2131821087 */:
                this.f4740a.d = 0;
                view11 = this.f4740a.j;
                ImageView imageView = (ImageView) view11.findViewById(R.id.imageView_content);
                view12 = this.f4740a.j;
                VideoView videoView = (VideoView) view12.findViewById(R.id.videoView_content);
                view13 = this.f4740a.j;
                ImageView imageView2 = (ImageView) view13.findViewById(R.id.imageButton_media_detail_play);
                videoView.stopPlayback();
                imageView.setVisibility(0);
                videoView.setVisibility(8);
                imageView2.setVisibility(0);
                view14 = this.f4740a.j;
                view14.setVisibility(8);
                this.f4740a.A = false;
                toolbar = this.f4740a.m;
                if (toolbar != null) {
                    toolbar2 = this.f4740a.m;
                    toolbar2.setHiddenMenuPopup(false);
                    return;
                }
                return;
            case R.id.imageButton_media_detail_favorite /* 2131821097 */:
                view9 = this.f4740a.j;
                ImageButton imageButton = (ImageButton) view9.findViewById(R.id.imageButton_media_detail_favorite);
                list3 = this.f4740a.q;
                i3 = this.f4740a.d;
                MediaStoreItem mediaStoreItem2 = (MediaStoreItem) list3.get(i3);
                if (mediaStoreItem2 == null || mediaStoreItem2.b() != MediaItemType.FOLDER) {
                    if (mediaStoreItem2 == null) {
                        msid = null;
                    } else {
                        msid = mediaStoreItem2.c();
                    }
                    if (msid != null) {
                        bVar2 = this.f4740a.u;
                        if (bVar2.a(msid)) {
                            bVar3 = this.f4740a.u;
                            bVar3.c(msid);
                            imageButton.setActivated(false);
                            gridView2 = this.f4740a.k;
                            gridView2.invalidateViews();
                            mediaStoreItem = this.f4740a.n;
                            if (mediaStoreItem.c().getNamespace().equals("Favorites")) {
                                view10 = this.f4740a.j;
                                VideoView videoView2 = (VideoView) view10.findViewById(R.id.videoView_content);
                                if (videoView2.isPlaying()) {
                                    videoView2.stopPlayback();
                                    videoView2.setVisibility(8);
                                }
                                this.f4740a.c();
                                return;
                            }
                            return;
                        }
                    }
                    if (msid != null) {
                        bVar = this.f4740a.u;
                        bVar.b(msid);
                        imageButton.setActivated(true);
                        gridView = this.f4740a.k;
                        gridView.invalidateViews();
                        return;
                    }
                    return;
                }
                return;
            case R.id.imageButton_media_detail_add /* 2131821098 */:
                list2 = this.f4740a.q;
                i2 = this.f4740a.d;
                MediaStoreItem mediaStoreItem3 = (MediaStoreItem) list2.get(i2);
                if (mediaStoreItem3 == null || mediaStoreItem3.b() != MediaItemType.FOLDER) {
                    if (mediaStoreItem3.o().equals("Backgrounds") || mediaStoreItem3.i() > 0) {
                        this.f4740a.d(mediaStoreItem3);
                        view2 = this.f4740a.j;
                        if (view2 != null) {
                            boolean a2 = this.f4740a.a(mediaStoreItem3);
                            view3 = this.f4740a.j;
                            ImageButton imageButton2 = (ImageButton) view3.findViewById(R.id.imageButton_media_detail_delete);
                            if (a2) {
                                imageButton2.setEnabled(false);
                                imageButton2.setAlpha(0.5f);
                            } else {
                                imageButton2.setEnabled(true);
                                imageButton2.setAlpha(1.0f);
                            }
                            view4 = this.f4740a.j;
                            if (view4 != null) {
                                view5 = this.f4740a.j;
                                if (view5.getVisibility() == 0) {
                                    view6 = this.f4740a.j;
                                    VideoView videoView3 = (VideoView) view6.findViewById(R.id.videoView_content);
                                    if (videoView3.isPlaying()) {
                                        videoView3.stopPlayback();
                                        view7 = this.f4740a.j;
                                        view7.findViewById(R.id.imageView_content).setVisibility(0);
                                        videoView3.setVisibility(8);
                                        view8 = this.f4740a.j;
                                        view8.findViewById(R.id.imageButton_media_detail_play).setVisibility(0);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    this.f4740a.a(R.string.engine_error_filereader_fail_size_zero, R.string.mediabrowser_ok);
                    return;
                }
                return;
            case R.id.imageButton_media_detail_delete /* 2131821099 */:
                list = this.f4740a.q;
                i = this.f4740a.d;
                MediaStoreItem mediaStoreItem4 = (MediaStoreItem) list.get(i);
                if (mediaStoreItem4 == null || mediaStoreItem4.b() != MediaItemType.FOLDER) {
                    this.f4740a.f();
                    return;
                }
                return;
            case R.id.imageButton_media_detail_previous /* 2131821100 */:
                i6 = this.f4740a.d;
                if (i6 - 1 >= 0) {
                    i7 = this.f4740a.d;
                    for (int i8 = i7 - 1; i8 >= 0; i8--) {
                        list7 = this.f4740a.q;
                        if (((MediaStoreItem) list7.get(i8)).b() != MediaItemType.FOLDER) {
                            this.f4740a.a(i8);
                            return;
                        }
                    }
                    return;
                }
                return;
            case R.id.imageButton_media_detail_next /* 2131821101 */:
                i4 = this.f4740a.d;
                int i9 = i4 + 1;
                list4 = this.f4740a.q;
                if (i9 < list4.size()) {
                    i5 = this.f4740a.d;
                    int i10 = i5 + 1;
                    while (true) {
                        int i11 = i10;
                        list5 = this.f4740a.q;
                        if (i11 <= list5.size() - 1) {
                            list6 = this.f4740a.q;
                            if (((MediaStoreItem) list6.get(i11)).b() != MediaItemType.FOLDER) {
                                this.f4740a.a(i11);
                                return;
                            }
                            i10 = i11 + 1;
                        } else {
                            return;
                        }
                    }
                } else {
                    return;
                }
            case R.id.button_toolbar_accept /* 2131821121 */:
                this.f4740a.getFragmentManager().popBackStack();
                return;
            default:
                return;
        }
    }
}
