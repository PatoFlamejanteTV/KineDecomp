package com.nexstreaming.kinemaster.mediaprep;

import android.content.Context;
import android.os.Handler;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.mediastore.v2.MSID;
import com.nexstreaming.kinemaster.mediastore.v2.MediaItemType;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStore;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem;
import com.nexstreaming.kinemaster.ui.a.a;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.NexEditorDeviceProfile;
import com.nextreaming.nexeditorui.NexExportProfile;
import com.nextreaming.nexeditorui.NexTimeline;
import com.nextreaming.nexeditorui.newproject.mediabrowser.bb;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class MediaPrepManager {
    private static Map<MSID, WeakReference<com.nexstreaming.kinemaster.g.i>> g = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    private Context f3520a;
    private MediaStore b;
    private a f;
    private boolean i;
    private Map<MSID, com.nexstreaming.kinemaster.mediaprep.a> c = new HashMap();
    private Map<MSID, com.nexstreaming.kinemaster.mediaprep.a> d = new HashMap();
    private Map<MSID, com.nexstreaming.kinemaster.mediaprep.a> e = new HashMap();
    private Set<MSID> h = new HashSet();
    private Handler j = new Handler();

    /* loaded from: classes.dex */
    public enum FailType {
        Download,
        Transcoding,
        Other
    }

    /* loaded from: classes.dex */
    public interface a {
        void a(MSID msid, com.nexstreaming.kinemaster.mediaprep.a aVar);
    }

    public void a(Collection<MSID> collection) {
        this.h.clear();
        this.h.addAll(collection);
    }

    public MediaPrepManager(Context context, MediaStore mediaStore, boolean z) {
        this.f3520a = context;
        this.b = mediaStore;
        this.i = z;
    }

    public void a(a aVar) {
        this.f = aVar;
    }

    public void a(MSID msid, com.nexstreaming.kinemaster.mediaprep.a aVar) {
        com.nexstreaming.kinemaster.mediaprep.a aVar2 = this.c.get(msid);
        if (aVar2 != null) {
            aVar.a(aVar2);
        } else if (this.d.containsKey(msid)) {
            aVar.a(MediaPrepState.Completed);
        } else {
            aVar.a();
        }
    }

    private Set<MSID> b(NexTimeline nexTimeline) {
        HashSet hashSet = new HashSet();
        int primaryItemCount = nexTimeline.getPrimaryItemCount();
        for (int i = 0; i < primaryItemCount; i++) {
            MSID mediaMSID = nexTimeline.getPrimaryItem(i).getMediaMSID();
            if (mediaMSID != null) {
                hashSet.add(mediaMSID);
            }
        }
        int secondaryItemCount = nexTimeline.getSecondaryItemCount();
        for (int i2 = 0; i2 < secondaryItemCount; i2++) {
            MSID mediaMSID2 = nexTimeline.getSecondaryItem(i2).getMediaMSID();
            if (mediaMSID2 != null) {
                hashSet.add(mediaMSID2);
            }
        }
        return hashSet;
    }

    private void b(Set<MSID> set) {
        HashSet hashSet = null;
        for (MSID msid : this.d.keySet()) {
            if (!set.contains(msid)) {
                if (hashSet == null) {
                    hashSet = new HashSet();
                }
                hashSet.add(msid);
            }
        }
        if (hashSet != null) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                this.d.remove((MSID) it.next());
            }
            this.h.removeAll(hashSet);
        }
    }

    private void c(Set<MSID> set) {
        HashMap hashMap = null;
        HashMap hashMap2 = null;
        for (Map.Entry<MSID, com.nexstreaming.kinemaster.mediaprep.a> entry : this.c.entrySet()) {
            MSID key = entry.getKey();
            if (!set.contains(key)) {
                com.nexstreaming.kinemaster.mediaprep.a value = entry.getValue();
                if (value.f3523a == MediaPrepState.Completed) {
                    if (hashMap == null) {
                        hashMap = new HashMap();
                    }
                    hashMap.put(key, value);
                } else {
                    if (hashMap2 == null) {
                        hashMap2 = new HashMap();
                    }
                    hashMap2.put(key, value);
                }
            }
            hashMap = hashMap;
            hashMap2 = hashMap2;
        }
        if (hashMap2 != null) {
            for (Map.Entry<MSID, com.nexstreaming.kinemaster.mediaprep.a> entry2 : hashMap2.entrySet()) {
                a(entry2);
                this.d.remove(entry2.getKey());
            }
        }
        if (hashMap != null) {
            for (Map.Entry entry3 : hashMap.entrySet()) {
                this.c.remove(entry3.getKey());
                this.d.remove(entry3.getKey());
            }
        }
    }

    public void a(NexTimeline nexTimeline) {
        a(b(nexTimeline));
    }

    public void a(Set<MSID> set) {
        b(set);
        c(set);
        set.removeAll(this.d.keySet());
        for (Map.Entry<MSID, com.nexstreaming.kinemaster.mediaprep.a> entry : this.d.entrySet()) {
            if (this.f != null) {
                this.f.a(entry.getKey(), entry.getValue());
            }
        }
        set.removeAll(this.c.keySet());
        for (MSID msid : set) {
            if (this.e.containsKey(msid)) {
                this.c.put(msid, this.e.get(msid));
                this.e.remove(msid);
            } else {
                e(msid);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MSID msid, Task.TaskError taskError, FailType failType) {
        com.nexstreaming.kinemaster.mediaprep.a aVar = this.c.get(msid);
        if (aVar != null) {
            if (aVar.f3523a != MediaPrepState.FailedCanRetry || aVar.d != taskError) {
                switch (failType) {
                    case Download:
                        aVar.a(MediaPrepState.FailDownload, taskError);
                        break;
                    case Transcoding:
                        aVar.a(MediaPrepState.FailTranscoding, taskError);
                        break;
                    default:
                        aVar.a(MediaPrepState.FailedCanRetry, taskError);
                        break;
                }
                if (this.f != null) {
                    this.f.a(msid, aVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(MSID msid) {
        f(msid);
        com.nexstreaming.kinemaster.mediaprep.a aVar = this.c.get(msid);
        if (aVar != null && aVar.f3523a != MediaPrepState.UserInterventionCancel) {
            aVar.a(MediaPrepState.UserInterventionCancel);
            if (this.f != null) {
                this.f.a(msid, aVar);
            }
        }
        this.c.remove(msid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(MSID msid) {
        f(msid);
        com.nexstreaming.kinemaster.mediaprep.a aVar = this.c.get(msid);
        if (aVar != null && aVar.f3523a != MediaPrepState.CancelOnRemoval) {
            aVar.a(MediaPrepState.CancelOnRemoval);
            if (this.f != null) {
                this.f.a(msid, aVar);
            }
        }
        this.c.remove(msid);
    }

    private void a(MSID msid, MediaStoreItem.MediaSupportType mediaSupportType) {
        com.nexstreaming.kinemaster.mediaprep.a aVar = this.c.get(msid);
        if (aVar != null && aVar.f3523a != MediaPrepState.FailNotSupported) {
            aVar.a(mediaSupportType);
            if (this.f != null) {
                this.f.a(msid, aVar);
            }
        }
    }

    private void a(MSID msid, String str) {
        com.nexstreaming.kinemaster.mediaprep.a aVar = this.c.get(msid);
        if (aVar != null && aVar.f3523a != MediaPrepState.Completed) {
            aVar.a(str);
            if (this.f != null) {
                this.f.a(msid, aVar);
            }
            this.c.remove(msid);
            this.d.put(msid, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MSID msid, MediaPrepState mediaPrepState, int i, int i2) {
        com.nexstreaming.kinemaster.mediaprep.a aVar = this.c.get(msid);
        if (aVar != null) {
            if (aVar.f3523a != mediaPrepState || aVar.b != i || aVar.c != i2) {
                aVar.a(mediaPrepState, i, i2);
                if (this.f != null) {
                    this.f.a(msid, aVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(MSID msid) {
        com.nexstreaming.kinemaster.mediaprep.a aVar = this.c.get(msid);
        if (aVar != null && aVar.f3523a != MediaPrepState.Busy) {
            aVar.a(MediaPrepState.Busy);
            if (this.f != null) {
                this.f.a(msid, aVar);
            }
        }
    }

    private Task a(MSID msid, String str, String str2, String str3) {
        Task task = new Task();
        com.nexstreaming.kinemaster.mediaprep.a aVar = this.c.get(msid);
        if (aVar == null || aVar.f3523a == MediaPrepState.UserInterventionRequired) {
            task.sendFailure(Task.makeTaskError("internal error"));
        } else {
            aVar.a(new b(this, str, str2, str3, task));
            if (this.f != null) {
                this.f.a(msid, aVar);
            }
        }
        return task;
    }

    public void a(MSID msid) {
        com.nexstreaming.kinemaster.mediaprep.a aVar = this.c.get(msid);
        if (aVar != null) {
            if (aVar.f3523a == MediaPrepState.FailedCanRetry || aVar.f3523a == MediaPrepState.FailTranscoding || aVar.f3523a == MediaPrepState.FailDownload) {
                this.c.remove(msid);
            }
        }
    }

    public void a() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<MSID, com.nexstreaming.kinemaster.mediaprep.a> entry : this.c.entrySet()) {
            if (entry.getValue() != null && entry.getValue().f3523a == MediaPrepState.FailDownload) {
                arrayList.add(entry.getKey());
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.c.remove((MSID) it.next());
        }
    }

    private void e(MSID msid) {
        if (this.c.put(msid, new com.nexstreaming.kinemaster.mediaprep.a()) != null) {
            throw new IllegalStateException("Task already active : " + ((Object) msid));
        }
        MediaStoreItem a2 = this.b.a(msid);
        if (a2 != null) {
            a(msid, a2);
        } else {
            d(msid);
            this.b.b(msid).onResultAvailable(new u(this, msid)).onFailure((Task.OnFailListener) new s(this, msid));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MSID msid, MediaStoreItem mediaStoreItem) {
        MediaStoreItem.MediaSupportType p = mediaStoreItem.p();
        if (p == null || p == MediaStoreItem.MediaSupportType.CheckAsync) {
            d(msid);
            mediaStoreItem.q().onResultAvailable(new w(this, msid, mediaStoreItem)).onFailure((Task.OnFailListener) new v(this, msid, mediaStoreItem));
        } else {
            a(msid, mediaStoreItem, p);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MSID msid, MediaStoreItem mediaStoreItem, MediaStoreItem.MediaSupportType mediaSupportType) {
        if (mediaSupportType.needsTranscode()) {
            a(msid, mediaStoreItem, true);
        } else {
            a(msid, mediaStoreItem, true);
        }
    }

    private Task b(MSID msid, MediaStoreItem mediaStoreItem, MediaStoreItem.MediaSupportType mediaSupportType) {
        String string;
        String str;
        boolean z = (mediaStoreItem.n() || mediaStoreItem.h() == null || !com.nexstreaming.kinemaster.g.a.a(this.f3520a, new File(mediaStoreItem.h()), mediaSupportType).exists()) ? false : true;
        String string2 = this.f3520a.getString(R.string.button_cancel);
        switch (mediaSupportType) {
            case NeedTranscodeFPS:
                if (z) {
                    str = this.f3520a.getString(R.string.mediabrowser_dialog_exist_coverted_file_by_fps);
                    string = this.f3520a.getString(R.string.mediabrowser_dialog_button_use_fps);
                    break;
                } else {
                    str = this.f3520a.getString(R.string.mediabrowser_dialog_transcoder_by_fps);
                    string = this.f3520a.getString(R.string.mediabrowser_dialog_button_convert_fps);
                    break;
                }
            case NeedTranscodeRes:
                NexExportProfile transcodeProfile = NexEditorDeviceProfile.getDeviceProfile().getTranscodeProfile(EditorGlobal.a().i());
                if (z) {
                    String string3 = this.f3520a.getString(R.string.mediabrowser_dialog_exist_coverted_file_by_resolution, Integer.valueOf(mediaStoreItem.j()), Integer.valueOf(mediaStoreItem.k()), Integer.valueOf(transcodeProfile.width()), Integer.valueOf(transcodeProfile.displayHeight()), Integer.valueOf(transcodeProfile.displayHeight()));
                    string = this.f3520a.getString(R.string.mediabrowser_dialog_button_use_resolution, Integer.valueOf(transcodeProfile.displayHeight()));
                    str = string3;
                    break;
                } else {
                    String string4 = this.f3520a.getString(R.string.mediabrowser_dialog_transcoder_by_resolution, Integer.valueOf(mediaStoreItem.j()), Integer.valueOf(mediaStoreItem.k()), Integer.valueOf(transcodeProfile.width()), Integer.valueOf(transcodeProfile.displayHeight()), Integer.valueOf(transcodeProfile.displayHeight()));
                    string = this.f3520a.getString(R.string.mediabrowser_dialog_button_convert_resolution, Integer.valueOf(transcodeProfile.displayHeight()));
                    str = string4;
                    break;
                }
            default:
                throw new IllegalStateException(String.valueOf(mediaSupportType));
        }
        return a(msid, str, string, string2).onFailure(new x(this, msid));
    }

    private void a(MSID msid, MediaStoreItem mediaStoreItem, boolean z) {
        if (!f(msid)) {
            if (mediaStoreItem.n()) {
                d(msid);
                this.b.g(mediaStoreItem).onProgress(new f(this, msid)).onComplete(new aa(this, msid, mediaStoreItem, z)).onFailure(new z(this, msid)).onCancel(new y(this, msid));
            } else {
                a(msid, mediaStoreItem, z, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MSID msid, MediaStoreItem mediaStoreItem, boolean z, boolean z2) {
        NexExportProfile transcodeProfile;
        if (!f(msid)) {
            MediaStoreItem.MediaSupportType p = mediaStoreItem.p();
            if (p.needsTranscode()) {
                if (z) {
                    switch (p) {
                        case NeedTranscodeFPS:
                            transcodeProfile = NexEditorDeviceProfile.getDeviceProfile().getTranscodeProfile(EditorGlobal.a().i(), mediaStoreItem.j(), mediaStoreItem.k());
                            break;
                        case NeedTranscodeRes:
                            transcodeProfile = NexEditorDeviceProfile.getDeviceProfile().getTranscodeProfile(EditorGlobal.a().i());
                            break;
                        default:
                            throw new IllegalStateException(String.valueOf(p));
                    }
                    File file = new File(mediaStoreItem.h());
                    File a2 = com.nexstreaming.kinemaster.g.a.a(this.f3520a, file, p);
                    if (a2.exists()) {
                        a(msid, mediaStoreItem, a2.getAbsolutePath());
                        return;
                    }
                    d(msid);
                    com.nexstreaming.kinemaster.g.i a3 = com.nexstreaming.kinemaster.g.b.a(this.f3520a, file, a2, transcodeProfile);
                    g.put(msid, new WeakReference<>(a3));
                    a3.onProgress(new m(this, msid)).onComplete(new i(this, msid, a2, mediaStoreItem)).onCancel(new h(this, msid)).onFailure(new g(this, msid));
                    return;
                }
                b(msid, mediaStoreItem, p).onSuccess(new o(this, msid, mediaStoreItem)).onCancel(new n(this, msid));
                return;
            }
            if (p != MediaStoreItem.MediaSupportType.Supported) {
                a(msid, p);
                return;
            }
            boolean a4 = bb.a(mediaStoreItem.h());
            if (z2 && a4) {
                new a.C0074a(this.f3520a).f(R.string.video_editing_warning_title).a(R.string.video_editing_warning).b(this.f3520a.getResources().getString(R.string.video_editing_warning_sub)).a(new q(this, msid, mediaStoreItem)).a(R.string.button_ok, new p(this, msid, mediaStoreItem)).a().show();
            } else {
                a(msid, mediaStoreItem, mediaStoreItem.h());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f(MSID msid) {
        if (!this.e.containsKey(msid)) {
            return false;
        }
        this.e.remove(msid);
        this.h.remove(msid);
        c(msid);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MSID msid, MediaStoreItem mediaStoreItem, String str) {
        if (this.i && mediaStoreItem.b() == MediaItemType.IMAGE && !msid.getNamespace().equals(com.nexstreaming.kinemaster.mediastore.v2.providers.j.e())) {
            d(msid);
            com.nexstreaming.kinemaster.ui.c.a.b(str).onComplete((Task.OnTaskEventListener) new t(this, msid, mediaStoreItem, str)).onFailure((Task.OnFailListener) new r(this, msid, mediaStoreItem, str));
        } else {
            b(msid, mediaStoreItem, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(MSID msid, MediaStoreItem mediaStoreItem, String str) {
        if (!f(msid)) {
            if (str == null) {
                str = mediaStoreItem.h();
            }
            a(msid, str);
        }
    }

    private void a(Map.Entry<MSID, com.nexstreaming.kinemaster.mediaprep.a> entry) {
        com.nexstreaming.kinemaster.g.i iVar;
        if (entry.getValue().f3523a.isFailed()) {
            this.c.remove(entry.getKey());
            return;
        }
        this.e.put(entry.getKey(), entry.getValue());
        this.b.c(entry.getKey());
        this.c.remove(entry.getKey());
        WeakReference<com.nexstreaming.kinemaster.g.i> weakReference = g.get(entry.getKey());
        if (weakReference != null && (iVar = weakReference.get()) != null) {
            iVar.cancel();
        }
    }

    public void b() {
        a(Collections.emptySet());
        this.f3520a = null;
        this.b = null;
    }
}
