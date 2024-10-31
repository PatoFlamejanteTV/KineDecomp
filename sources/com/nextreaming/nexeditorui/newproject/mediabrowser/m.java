package com.nextreaming.nexeditorui.newproject.mediabrowser;

import android.widget.TextView;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStore;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem;
import com.nextreaming.nexeditorui.EditorGlobal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaBrowserFragment.java */
/* loaded from: classes.dex */
public class m implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f4735a;
    final /* synthetic */ MediaStoreItem b;
    final /* synthetic */ TextView c;
    final /* synthetic */ MediaBrowserFragment d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(MediaBrowserFragment mediaBrowserFragment, int i, MediaStoreItem mediaStoreItem, TextView textView) {
        this.d = mediaBrowserFragment;
        this.f4735a = i;
        this.b = mediaStoreItem;
        this.c = textView;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        int i;
        i = this.d.H;
        if (i == this.f4735a && this.d.getActivity() != null) {
            try {
                int j = this.b.j();
                int k = this.b.k();
                long m = this.b.m();
                int s = this.b.s();
                this.c.setText(EditorGlobal.a((int) m) + ", " + EditorGlobal.a(this.d.getActivity(), this.b.i()) + ", " + j + "x" + k + ", " + s + "FPS");
            } catch (MediaStore.UnavailableDataException e) {
                if (this.d.isAdded()) {
                    this.c.setText(this.d.getResources().getString(R.string.media_browser_cloud_file_fail));
                }
            }
        }
    }
}
