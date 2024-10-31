package com.nexstreaming.kinemaster.mediainfo;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.kinemaster.mediainfo.MediaInfo;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaInfo.java */
/* loaded from: classes.dex */
public class x implements ResultTask.OnResultAvailableListener<MediaInfo.a> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MediaInfo f3517a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(MediaInfo mediaInfo) {
        this.f3517a = mediaInfo;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onResultAvailable(com.nexstreaming.app.general.task.ResultTask<com.nexstreaming.kinemaster.mediainfo.MediaInfo.a> r7, com.nexstreaming.app.general.task.Task.Event r8, com.nexstreaming.kinemaster.mediainfo.MediaInfo.a r9) {
        /*
            r6 = this;
            if (r9 == 0) goto L29
            android.graphics.Bitmap r0 = r9.d
            if (r0 == 0) goto L29
            int r0 = r9.f3483a
            if (r0 <= 0) goto L29
            int r0 = r9.b
            if (r0 <= 0) goto L29
            int[] r0 = r9.c
            if (r0 == 0) goto L29
            com.nexstreaming.kinemaster.mediainfo.MediaInfo r0 = r6.f3517a
            com.nexstreaming.kinemaster.mediainfo.MediaInfo$c r0 = com.nexstreaming.kinemaster.mediainfo.MediaInfo.b(r0)
            com.nexstreaming.kinemaster.mediainfo.ar r1 = new com.nexstreaming.kinemaster.mediainfo.ar
            android.graphics.Bitmap r2 = r9.d
            int r3 = r9.f3483a
            int r4 = r9.b
            int[] r5 = r9.c
            r1.<init>(r2, r3, r4, r5)
            r0.sendResult(r1)
        L28:
            return
        L29:
            com.nextreaming.nexvideoeditor.NexEditor r0 = com.nexstreaming.kinemaster.mediainfo.MediaInfo.P()
            if (r0 == 0) goto L4d
            java.util.Deque r0 = com.nexstreaming.kinemaster.mediainfo.MediaInfo.M()
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L4d
            r0 = 1
        L3a:
            java.util.Deque r1 = com.nexstreaming.kinemaster.mediainfo.MediaInfo.M()
            com.nexstreaming.kinemaster.mediainfo.MediaInfo r2 = r6.f3517a
            com.nexstreaming.kinemaster.mediainfo.MediaInfo$c r2 = com.nexstreaming.kinemaster.mediainfo.MediaInfo.b(r2)
            r1.add(r2)
            if (r0 == 0) goto L28
            com.nexstreaming.kinemaster.mediainfo.MediaInfo.N()
            goto L28
        L4d:
            r0 = 0
            goto L3a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.kinemaster.mediainfo.x.onResultAvailable(com.nexstreaming.app.general.task.ResultTask, com.nexstreaming.app.general.task.Task$Event, com.nexstreaming.kinemaster.mediainfo.MediaInfo$a):void");
    }
}
