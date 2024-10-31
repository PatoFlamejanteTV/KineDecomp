package com.nexstreaming.kinemaster.mediainfo;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.kinemaster.mediainfo.MediaInfo;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaInfo.java */
/* loaded from: classes.dex */
public class z implements ResultTask.OnResultAvailableListener<MediaInfo.a> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MediaInfo f20765a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(MediaInfo mediaInfo) {
        this.f20765a = mediaInfo;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onResultAvailable(com.nexstreaming.app.general.task.ResultTask<com.nexstreaming.kinemaster.mediainfo.MediaInfo.a> r4, com.nexstreaming.app.general.task.Task.Event r5, com.nexstreaming.kinemaster.mediainfo.MediaInfo.a r6) {
        /*
            r3 = this;
            if (r6 == 0) goto L29
            android.graphics.Bitmap r4 = r6.f20682d
            if (r4 == 0) goto L29
            int r4 = r6.f20679a
            if (r4 <= 0) goto L29
            int r4 = r6.f20680b
            if (r4 <= 0) goto L29
            int[] r4 = r6.f20681c
            if (r4 == 0) goto L29
            com.nexstreaming.kinemaster.mediainfo.MediaInfo r4 = r3.f20765a
            com.nexstreaming.kinemaster.mediainfo.MediaInfo$c r4 = com.nexstreaming.kinemaster.mediainfo.MediaInfo.m(r4)
            com.nexstreaming.kinemaster.mediainfo.U r5 = new com.nexstreaming.kinemaster.mediainfo.U
            android.graphics.Bitmap r0 = r6.f20682d
            int r1 = r6.f20679a
            int r2 = r6.f20680b
            int[] r6 = r6.f20681c
            r5.<init>(r0, r1, r2, r6)
            r4.sendResult(r5)
            goto L4e
        L29:
            com.nextreaming.nexvideoeditor.NexEditor r4 = com.nexstreaming.kinemaster.mediainfo.MediaInfo.a()
            if (r4 == 0) goto L3b
            java.util.Deque r4 = com.nexstreaming.kinemaster.mediainfo.MediaInfo.j()
            boolean r4 = r4.isEmpty()
            if (r4 == 0) goto L3b
            r4 = 1
            goto L3c
        L3b:
            r4 = 0
        L3c:
            java.util.Deque r5 = com.nexstreaming.kinemaster.mediainfo.MediaInfo.j()
            com.nexstreaming.kinemaster.mediainfo.MediaInfo r6 = r3.f20765a
            com.nexstreaming.kinemaster.mediainfo.MediaInfo$c r6 = com.nexstreaming.kinemaster.mediainfo.MediaInfo.m(r6)
            r5.add(r6)
            if (r4 == 0) goto L4e
            com.nexstreaming.kinemaster.mediainfo.MediaInfo.g()
        L4e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.kinemaster.mediainfo.z.onResultAvailable(com.nexstreaming.app.general.task.ResultTask, com.nexstreaming.app.general.task.Task$Event, com.nexstreaming.kinemaster.mediainfo.MediaInfo$a):void");
    }
}
