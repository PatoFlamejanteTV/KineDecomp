package com.nextreaming.nexeditorui.newproject.mediabrowser;

import android.view.MenuItem;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.usage.KMUsage;
import com.nextreaming.nexeditorui.a.a.a;
import com.nextreaming.nexeditorui.newproject.mediabrowser.MediaBrowserFragment;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaBrowserFragment.java */
/* loaded from: classes.dex */
public class p implements a.InterfaceC0083a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MediaBrowserFragment f4738a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(MediaBrowserFragment mediaBrowserFragment) {
        this.f4738a = mediaBrowserFragment;
    }

    @Override // com.nextreaming.nexeditorui.a.a.a.InterfaceC0083a
    public boolean a(MenuItem menuItem, int i) {
        MediaBrowserFragment.MediaViewerMode mediaViewerMode;
        switch (menuItem.getItemId()) {
            case R.id.media_browser_menu_all /* 2131821605 */:
                this.f4738a.o = MediaBrowserFragment.MediaViewerMode.ALL;
                break;
            case R.id.media_browser_menu_images /* 2131821606 */:
                this.f4738a.o = MediaBrowserFragment.MediaViewerMode.IMAGES;
                break;
            case R.id.media_browser_menu_video /* 2131821607 */:
                this.f4738a.o = MediaBrowserFragment.MediaViewerMode.VIDEO;
                break;
        }
        KMUsage kMUsage = KMUsage.MediaBrowser_Filter;
        mediaViewerMode = this.f4738a.o;
        kMUsage.logEvent("filter", mediaViewerMode.name());
        this.f4738a.c();
        return false;
    }
}
