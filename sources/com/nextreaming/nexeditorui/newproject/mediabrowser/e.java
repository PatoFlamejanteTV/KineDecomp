package com.nextreaming.nexeditorui.newproject.mediabrowser;

import android.widget.TextView;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStore;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaBrowserFragment.java */
/* loaded from: classes.dex */
public class e implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f4727a;
    final /* synthetic */ MediaStoreItem b;
    final /* synthetic */ TextView c;
    final /* synthetic */ String d;
    final /* synthetic */ MediaBrowserFragment e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(MediaBrowserFragment mediaBrowserFragment, int i, MediaStoreItem mediaStoreItem, TextView textView, String str) {
        this.e = mediaBrowserFragment;
        this.f4727a = i;
        this.b = mediaStoreItem;
        this.c = textView;
        this.d = str;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        int i;
        i = this.e.H;
        if (i == this.f4727a) {
            try {
                this.c.setText(this.d + ", " + this.b.j() + "x" + this.b.k());
            } catch (MediaStore.UnavailableDataException e) {
                this.c.setText(this.e.getResources().getString(R.string.media_browser_cloud_file_fail));
            }
        }
    }
}
