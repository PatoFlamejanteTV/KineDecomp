package com.nexstreaming.kinemaster.mediaprep;

import android.content.Context;
import android.os.Handler;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.codeccaps.CapabilityManager;
import com.nexstreaming.kinemaster.mediainfo.MediaInfo;
import com.nexstreaming.kinemaster.mediastore.MediaStore;
import com.nexstreaming.kinemaster.mediastore.MediaSupportType;
import com.nexstreaming.kinemaster.mediastore.item.MediaItemType;
import com.nexstreaming.kinemaster.mediastore.item.MediaStoreItemId;
import com.nexstreaming.kinemaster.ui.a.e;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.NexEditorDeviceProfile;
import com.nextreaming.nexeditorui.NexExportProfile;
import com.nextreaming.nexeditorui.NexTimeline;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class MediaPrepManager {

    /* renamed from: a, reason: collision with root package name */
    private static Map<MediaStoreItemId, WeakReference<c.d.b.k.j>> f20773a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private Context f20774b;

    /* renamed from: c, reason: collision with root package name */
    private MediaStore f20775c;

    /* renamed from: g, reason: collision with root package name */
    private List<a> f20779g;
    private boolean i;

    /* renamed from: d, reason: collision with root package name */
    private Map<MediaStoreItemId, C1803a> f20776d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    private Map<MediaStoreItemId, C1803a> f20777e = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    private Map<MediaStoreItemId, C1803a> f20778f = new HashMap();

    /* renamed from: h, reason: collision with root package name */
    private Set<MediaStoreItemId> f20780h = new HashSet();
    private Handler j = new Handler();

    /* loaded from: classes.dex */
    public enum FailType {
        Download,
        Transcoding,
        Other
    }

    /* loaded from: classes.dex */
    public interface a {
        void a(MediaStoreItemId mediaStoreItemId, C1803a c1803a);
    }

    public MediaPrepManager(Context context, MediaStore mediaStore, boolean z) {
        this.f20774b = context;
        this.f20775c = mediaStore;
        this.i = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(MediaStoreItemId mediaStoreItemId) {
        b(mediaStoreItemId);
        C1803a c1803a = this.f20776d.get(mediaStoreItemId);
        if (c1803a != null) {
            MediaPrepState mediaPrepState = c1803a.f20781a;
            MediaPrepState mediaPrepState2 = MediaPrepState.UserInterventionCancel;
            if (mediaPrepState != mediaPrepState2) {
                c1803a.a(mediaPrepState2);
                List<a> list = this.f20779g;
                if (list != null) {
                    for (int size = list.size() - 1; size >= 0; size--) {
                        this.f20779g.get(size).a(mediaStoreItemId, c1803a);
                    }
                }
            }
        }
        this.f20776d.remove(mediaStoreItemId);
    }

    private void f(MediaStoreItemId mediaStoreItemId) {
        if (this.f20776d.put(mediaStoreItemId, new C1803a()) == null) {
            com.nexstreaming.kinemaster.mediastore.item.c b2 = this.f20775c.b(mediaStoreItemId);
            if (b2 != null) {
                a(mediaStoreItemId, b2);
                return;
            } else {
                d(mediaStoreItemId);
                this.f20775c.c(mediaStoreItemId).onResultAvailable(new v(this, mediaStoreItemId)).onFailure((Task.OnFailListener) new u(this, mediaStoreItemId));
                return;
            }
        }
        throw new IllegalStateException("Task already active : " + ((Object) mediaStoreItemId));
    }

    private void c(Set<MediaStoreItemId> set) {
        HashSet hashSet = null;
        for (MediaStoreItemId mediaStoreItemId : this.f20777e.keySet()) {
            if (!set.contains(mediaStoreItemId)) {
                if (hashSet == null) {
                    hashSet = new HashSet();
                }
                hashSet.add(mediaStoreItemId);
            }
        }
        if (hashSet != null) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                this.f20777e.remove((MediaStoreItemId) it.next());
            }
            this.f20780h.removeAll(hashSet);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(MediaStoreItemId mediaStoreItemId) {
        C1803a c1803a = this.f20776d.get(mediaStoreItemId);
        if (c1803a != null) {
            MediaPrepState mediaPrepState = c1803a.f20781a;
            MediaPrepState mediaPrepState2 = MediaPrepState.Busy;
            if (mediaPrepState == mediaPrepState2) {
                return;
            }
            c1803a.a(mediaPrepState2);
            List<a> list = this.f20779g;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f20779g.get(size).a(mediaStoreItemId, c1803a);
                }
            }
        }
    }

    public void b(a aVar) {
        List<a> list = this.f20779g;
        if (list != null) {
            list.remove(aVar);
        }
    }

    private Set<MediaStoreItemId> b(NexTimeline nexTimeline) {
        HashSet hashSet = new HashSet();
        int primaryItemCount = nexTimeline.getPrimaryItemCount();
        for (int i = 0; i < primaryItemCount; i++) {
            MediaStoreItemId mediaMSID = nexTimeline.getPrimaryItem(i).getMediaMSID();
            if (mediaMSID != null) {
                hashSet.add(mediaMSID);
            }
        }
        int secondaryItemCount = nexTimeline.getSecondaryItemCount();
        for (int i2 = 0; i2 < secondaryItemCount; i2++) {
            MediaStoreItemId mediaMSID2 = nexTimeline.getSecondaryItem(i2).getMediaMSID();
            if (mediaMSID2 != null) {
                hashSet.add(mediaMSID2);
            }
        }
        return hashSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(MediaStoreItemId mediaStoreItemId) {
        b(mediaStoreItemId);
        C1803a c1803a = this.f20776d.get(mediaStoreItemId);
        if (c1803a != null) {
            MediaPrepState mediaPrepState = c1803a.f20781a;
            MediaPrepState mediaPrepState2 = MediaPrepState.CancelOnRemoval;
            if (mediaPrepState != mediaPrepState2) {
                c1803a.a(mediaPrepState2);
                List<a> list = this.f20779g;
                if (list != null) {
                    for (int size = list.size() - 1; size >= 0; size--) {
                        this.f20779g.get(size).a(mediaStoreItemId, c1803a);
                    }
                }
            }
        }
        this.f20776d.remove(mediaStoreItemId);
    }

    public void a(Collection<MediaStoreItemId> collection) {
        this.f20780h.clear();
        this.f20780h.addAll(collection);
    }

    public void a(a aVar) {
        if (this.f20779g == null) {
            this.f20779g = new ArrayList();
        }
        if (this.f20779g.contains(aVar)) {
            return;
        }
        this.f20779g.add(aVar);
    }

    private void b(Set<MediaStoreItemId> set) {
        HashMap hashMap = null;
        HashMap hashMap2 = null;
        for (Map.Entry<MediaStoreItemId, C1803a> entry : this.f20776d.entrySet()) {
            MediaStoreItemId key = entry.getKey();
            if (!set.contains(key)) {
                C1803a value = entry.getValue();
                if (value.f20781a == MediaPrepState.Completed) {
                    if (hashMap2 == null) {
                        hashMap2 = new HashMap();
                    }
                    hashMap2.put(key, value);
                } else {
                    if (hashMap == null) {
                        hashMap = new HashMap();
                    }
                    hashMap.put(key, value);
                }
            }
        }
        if (hashMap != null) {
            for (Map.Entry<MediaStoreItemId, C1803a> entry2 : hashMap.entrySet()) {
                a(entry2);
                this.f20777e.remove(entry2.getKey());
            }
        }
        if (hashMap2 != null) {
            for (Map.Entry entry3 : hashMap2.entrySet()) {
                this.f20776d.remove(entry3.getKey());
                this.f20777e.remove(entry3.getKey());
            }
        }
    }

    public void a(MediaStoreItemId mediaStoreItemId, C1803a c1803a) {
        C1803a c1803a2 = this.f20776d.get(mediaStoreItemId);
        if (c1803a2 != null) {
            c1803a.a(c1803a2);
        } else if (this.f20777e.containsKey(mediaStoreItemId)) {
            c1803a.a(MediaPrepState.Completed);
        } else {
            c1803a.a();
        }
    }

    public void a(NexTimeline nexTimeline) {
        a(b(nexTimeline));
    }

    public void a(Set<MediaStoreItemId> set) {
        c(set);
        b(set);
        set.removeAll(this.f20777e.keySet());
        for (Map.Entry<MediaStoreItemId, C1803a> entry : this.f20777e.entrySet()) {
            List<a> list = this.f20779g;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f20779g.get(size).a(entry.getKey(), entry.getValue());
                }
            }
        }
        set.removeAll(this.f20776d.keySet());
        for (MediaStoreItemId mediaStoreItemId : set) {
            if (this.f20778f.containsKey(mediaStoreItemId)) {
                this.f20776d.put(mediaStoreItemId, this.f20778f.get(mediaStoreItemId));
                this.f20778f.remove(mediaStoreItemId);
            } else {
                f(mediaStoreItemId);
            }
        }
    }

    public void b() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<MediaStoreItemId, C1803a> entry : this.f20776d.entrySet()) {
            if (entry.getValue() != null && entry.getValue().f20781a == MediaPrepState.FailDownload) {
                arrayList.add(entry.getKey());
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.f20776d.remove((MediaStoreItemId) it.next());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MediaStoreItemId mediaStoreItemId, Task.TaskError taskError, FailType failType) {
        C1803a c1803a = this.f20776d.get(mediaStoreItemId);
        if (c1803a != null) {
            if (c1803a.f20781a == MediaPrepState.FailedCanRetry && c1803a.f20784d == taskError) {
                return;
            }
            int i = t.f20831a[failType.ordinal()];
            if (i == 1) {
                c1803a.a(MediaPrepState.FailDownload, taskError);
            } else if (i != 2) {
                c1803a.a(MediaPrepState.FailedCanRetry, taskError);
            } else {
                c1803a.a(MediaPrepState.FailTranscoding, taskError);
            }
            List<a> list = this.f20779g;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f20779g.get(size).a(mediaStoreItemId, c1803a);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(MediaStoreItemId mediaStoreItemId, com.nexstreaming.kinemaster.mediastore.item.c cVar, MediaSupportType mediaSupportType) {
        if (mediaSupportType.needsTranscode()) {
            a(mediaStoreItemId, cVar, true);
        } else {
            a(mediaStoreItemId, cVar, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(MediaStoreItemId mediaStoreItemId) {
        if (!this.f20778f.containsKey(mediaStoreItemId)) {
            return false;
        }
        this.f20778f.remove(mediaStoreItemId);
        this.f20780h.remove(mediaStoreItemId);
        c(mediaStoreItemId);
        return true;
    }

    private void a(MediaStoreItemId mediaStoreItemId, MediaSupportType mediaSupportType) {
        C1803a c1803a = this.f20776d.get(mediaStoreItemId);
        if (c1803a == null || c1803a.f20781a == MediaPrepState.FailNotSupported) {
            return;
        }
        c1803a.a(mediaSupportType);
        List<a> list = this.f20779g;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f20779g.get(size).a(mediaStoreItemId, c1803a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(MediaStoreItemId mediaStoreItemId, com.nexstreaming.kinemaster.mediastore.item.c cVar, String str) {
        if (b(mediaStoreItemId)) {
            return;
        }
        if (str == null) {
            str = cVar.getPath();
        }
        a(mediaStoreItemId, str);
    }

    private void a(MediaStoreItemId mediaStoreItemId, String str) {
        C1803a c1803a = this.f20776d.get(mediaStoreItemId);
        if (c1803a == null || c1803a.f20781a == MediaPrepState.Completed) {
            return;
        }
        c1803a.a(str);
        List<a> list = this.f20779g;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f20779g.get(size).a(mediaStoreItemId, c1803a);
            }
        }
        this.f20776d.remove(mediaStoreItemId);
        this.f20777e.put(mediaStoreItemId, c1803a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MediaStoreItemId mediaStoreItemId, MediaPrepState mediaPrepState, int i, int i2) {
        C1803a c1803a = this.f20776d.get(mediaStoreItemId);
        if (c1803a != null) {
            if (c1803a.f20781a == mediaPrepState && c1803a.f20782b == i && c1803a.f20783c == i2) {
                return;
            }
            c1803a.a(mediaPrepState, i, i2);
            List<a> list = this.f20779g;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f20779g.get(size).a(mediaStoreItemId, c1803a);
                }
            }
        }
    }

    private Task a(MediaStoreItemId mediaStoreItemId, String str, String str2, String str3) {
        Task task = new Task();
        C1803a c1803a = this.f20776d.get(mediaStoreItemId);
        if (c1803a != null && c1803a.f20781a != MediaPrepState.UserInterventionRequired) {
            c1803a.a(new r(this, str, str2, str3, task));
            List<a> list = this.f20779g;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f20779g.get(size).a(mediaStoreItemId, c1803a);
                }
            }
            return task;
        }
        task.sendFailure(Task.makeTaskError("internal error"));
        return task;
    }

    public void a(MediaStoreItemId mediaStoreItemId) {
        C1803a c1803a = this.f20776d.get(mediaStoreItemId);
        if (c1803a != null) {
            MediaPrepState mediaPrepState = c1803a.f20781a;
            if (mediaPrepState == MediaPrepState.FailedCanRetry || mediaPrepState == MediaPrepState.FailTranscoding || mediaPrepState == MediaPrepState.FailDownload) {
                this.f20776d.remove(mediaStoreItemId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MediaStoreItemId mediaStoreItemId, com.nexstreaming.kinemaster.mediastore.item.c cVar) {
        MediaSupportType g2 = cVar.g();
        if (g2 != null && g2 != MediaSupportType.CheckAsync) {
            b(mediaStoreItemId, cVar, g2);
        } else {
            d(mediaStoreItemId);
            cVar.e().onResultAvailable(new x(this, mediaStoreItemId, cVar)).onFailure((Task.OnFailListener) new w(this, mediaStoreItemId, cVar));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0158  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.nexstreaming.app.general.task.Task a(com.nexstreaming.kinemaster.mediastore.item.MediaStoreItemId r11, com.nexstreaming.kinemaster.mediastore.item.c r12, com.nexstreaming.kinemaster.mediastore.MediaSupportType r13) {
        /*
            Method dump skipped, instructions count: 376
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.kinemaster.mediaprep.MediaPrepManager.a(com.nexstreaming.kinemaster.mediastore.item.MediaStoreItemId, com.nexstreaming.kinemaster.mediastore.item.c, com.nexstreaming.kinemaster.mediastore.MediaSupportType):com.nexstreaming.app.general.task.Task");
    }

    private void a(MediaStoreItemId mediaStoreItemId, com.nexstreaming.kinemaster.mediastore.item.c cVar, boolean z) {
        if (b(mediaStoreItemId)) {
            return;
        }
        if (cVar.h()) {
            d(mediaStoreItemId);
            this.f20775c.b(cVar).onProgress(new e(this, mediaStoreItemId)).onComplete(new B(this, mediaStoreItemId, cVar, z)).onFailure(new A(this, mediaStoreItemId)).onCancel(new z(this, mediaStoreItemId));
        } else {
            a(mediaStoreItemId, cVar, z, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MediaStoreItemId mediaStoreItemId, com.nexstreaming.kinemaster.mediastore.item.c cVar, boolean z, boolean z2) {
        NexExportProfile transcodeProfile;
        File a2;
        if (b(mediaStoreItemId)) {
            return;
        }
        MediaSupportType g2 = cVar.g();
        if (!g2.needsTranscode()) {
            if (g2 != MediaSupportType.Supported) {
                a(mediaStoreItemId, g2);
                return;
            }
            boolean b2 = MediaInfo.b(cVar.getPath());
            if (z2 && b2) {
                e.a aVar = new e.a(this.f20774b);
                aVar.e(R.string.video_editing_warning_title);
                aVar.c(R.string.video_editing_warning);
                aVar.b(this.f20774b.getResources().getString(R.string.video_editing_warning_sub));
                aVar.a(new p(this, mediaStoreItemId, cVar));
                aVar.c(R.string.button_ok, new o(this, mediaStoreItemId, cVar));
                aVar.a().show();
                return;
            }
            a(mediaStoreItemId, cVar, cVar.getPath());
            return;
        }
        if (z) {
            int i = t.f20832b[g2.ordinal()];
            if (i == 1 || i == 2) {
                transcodeProfile = NexEditorDeviceProfile.getDeviceProfile().getTranscodeProfile(EditorGlobal.i().b(), cVar.getWidth(), cVar.getHeight());
            } else if (i == 3) {
                if (CapabilityManager.f20040b.t()) {
                    transcodeProfile = NexEditorDeviceProfile.getDeviceProfile().getTranscodeProfile(EditorGlobal.i().b());
                } else {
                    transcodeProfile = NexEditorDeviceProfile.getDeviceProfile().getTranscodeProfile(cVar.getWidth(), cVar.getHeight());
                }
            } else {
                throw new IllegalStateException(String.valueOf(g2));
            }
            File file = new File(cVar.getPath());
            if (CapabilityManager.f20040b.t()) {
                a2 = c.d.b.k.b.a(this.f20774b, file, g2);
            } else {
                a2 = c.d.b.k.b.a(this.f20774b, file, g2, cVar.getHeight());
            }
            if (a2.exists()) {
                a(mediaStoreItemId, cVar, a2.getAbsolutePath());
                return;
            }
            d(mediaStoreItemId);
            c.d.b.k.j a3 = c.d.b.k.i.a(this.f20774b, file, a2, transcodeProfile);
            f20773a.put(mediaStoreItemId, new WeakReference<>(a3));
            a3.onProgress(new l(this, mediaStoreItemId)).onComplete(new k(this, mediaStoreItemId, a2, cVar)).onCancel(new g(this, mediaStoreItemId)).onFailure(new f(this, mediaStoreItemId));
            return;
        }
        a(mediaStoreItemId, cVar, g2).onSuccess(new n(this, mediaStoreItemId, cVar)).onCancel(new m(this, mediaStoreItemId));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MediaStoreItemId mediaStoreItemId, com.nexstreaming.kinemaster.mediastore.item.c cVar, String str) {
        if (this.i && cVar.getType() == MediaItemType.IMAGE && !mediaStoreItemId.getNamespace().equals("Backgrounds")) {
            d(mediaStoreItemId);
            com.nexstreaming.kinemaster.ui.c.b.b(str).onComplete((Task.OnTaskEventListener) new s(this, mediaStoreItemId, cVar, str)).onFailure((Task.OnFailListener) new q(this, mediaStoreItemId, cVar, str));
        } else {
            b(mediaStoreItemId, cVar, str);
        }
    }

    private void a(Map.Entry<MediaStoreItemId, C1803a> entry) {
        c.d.b.k.j jVar;
        if (entry.getValue().f20781a.isFailed()) {
            this.f20776d.remove(entry.getKey());
            return;
        }
        this.f20778f.put(entry.getKey(), entry.getValue());
        this.f20775c.a(entry.getKey());
        this.f20776d.remove(entry.getKey());
        WeakReference<c.d.b.k.j> weakReference = f20773a.get(entry.getKey());
        if (weakReference == null || (jVar = weakReference.get()) == null) {
            return;
        }
        jVar.cancel();
    }

    public void a() {
        a(Collections.emptySet());
        List<a> list = this.f20779g;
        if (list != null) {
            list.clear();
            this.f20779g = null;
        }
        this.f20774b = null;
        this.f20775c = null;
    }
}
