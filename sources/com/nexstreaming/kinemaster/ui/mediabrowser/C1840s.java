package com.nexstreaming.kinemaster.ui.mediabrowser;

import com.nexstreaming.app.general.task.Task;

/* compiled from: MediaBrowserFragment.kt */
/* renamed from: com.nexstreaming.kinemaster.ui.mediabrowser.s, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C1840s implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C1829g f21703a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.nexstreaming.kinemaster.mediastore.item.c f21704b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1840s(C1829g c1829g, com.nexstreaming.kinemaster.mediastore.item.c cVar) {
        this.f21703a = c1829g;
        this.f21704b = cVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0076, code lost:            r4 = r3.f21703a.m;     */
    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onTaskEvent(com.nexstreaming.app.general.task.Task r4, com.nexstreaming.app.general.task.Task.Event r5) {
        /*
            r3 = this;
            java.lang.String r4 = ", "
            com.nexstreaming.kinemaster.mediastore.item.c r5 = r3.f21704b     // Catch: com.nexstreaming.kinemaster.mediastore.MediaStore.UnavailableDataException -> L6d
            int r5 = r5.getDuration()     // Catch: com.nexstreaming.kinemaster.mediastore.MediaStore.UnavailableDataException -> L6d
            long r0 = (long) r5     // Catch: com.nexstreaming.kinemaster.mediastore.MediaStore.UnavailableDataException -> L6d
            int r5 = (int) r0     // Catch: com.nexstreaming.kinemaster.mediastore.MediaStore.UnavailableDataException -> L6d
            long r0 = (long) r5     // Catch: com.nexstreaming.kinemaster.mediastore.MediaStore.UnavailableDataException -> L6d
            java.lang.String r5 = com.nextreaming.nexeditorui.EditorGlobal.a(r0)     // Catch: com.nexstreaming.kinemaster.mediastore.MediaStore.UnavailableDataException -> L6d
            com.nextreaming.nexeditorui.KineMasterApplication$a r0 = com.nextreaming.nexeditorui.KineMasterApplication.f24058f     // Catch: com.nexstreaming.kinemaster.mediastore.MediaStore.UnavailableDataException -> L6d
            com.nextreaming.nexeditorui.KineMasterApplication r0 = r0.c()     // Catch: com.nexstreaming.kinemaster.mediastore.MediaStore.UnavailableDataException -> L6d
            com.nexstreaming.kinemaster.mediastore.item.c r1 = r3.f21704b     // Catch: com.nexstreaming.kinemaster.mediastore.MediaStore.UnavailableDataException -> L6d
            long r1 = r1.a()     // Catch: com.nexstreaming.kinemaster.mediastore.MediaStore.UnavailableDataException -> L6d
            java.lang.String r0 = com.nextreaming.nexeditorui.EditorGlobal.a(r0, r1)     // Catch: com.nexstreaming.kinemaster.mediastore.MediaStore.UnavailableDataException -> L6d
            java.lang.String r1 = "EditorGlobal.formatFileS…instance, item.getSize())"
            kotlin.jvm.internal.h.a(r0, r1)     // Catch: com.nexstreaming.kinemaster.mediastore.MediaStore.UnavailableDataException -> L6d
            com.nexstreaming.kinemaster.ui.mediabrowser.g r1 = r3.f21703a     // Catch: com.nexstreaming.kinemaster.mediastore.MediaStore.UnavailableDataException -> L6d
            android.widget.TextView r1 = com.nexstreaming.kinemaster.ui.mediabrowser.C1829g.b(r1)     // Catch: com.nexstreaming.kinemaster.mediastore.MediaStore.UnavailableDataException -> L6d
            if (r1 == 0) goto L8e
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: com.nexstreaming.kinemaster.mediastore.MediaStore.UnavailableDataException -> L6d
            r2.<init>()     // Catch: com.nexstreaming.kinemaster.mediastore.MediaStore.UnavailableDataException -> L6d
            r2.append(r5)     // Catch: com.nexstreaming.kinemaster.mediastore.MediaStore.UnavailableDataException -> L6d
            r2.append(r4)     // Catch: com.nexstreaming.kinemaster.mediastore.MediaStore.UnavailableDataException -> L6d
            r2.append(r0)     // Catch: com.nexstreaming.kinemaster.mediastore.MediaStore.UnavailableDataException -> L6d
            r2.append(r4)     // Catch: com.nexstreaming.kinemaster.mediastore.MediaStore.UnavailableDataException -> L6d
            com.nexstreaming.kinemaster.mediastore.item.c r5 = r3.f21704b     // Catch: com.nexstreaming.kinemaster.mediastore.MediaStore.UnavailableDataException -> L6d
            int r5 = r5.getWidth()     // Catch: com.nexstreaming.kinemaster.mediastore.MediaStore.UnavailableDataException -> L6d
            r2.append(r5)     // Catch: com.nexstreaming.kinemaster.mediastore.MediaStore.UnavailableDataException -> L6d
            java.lang.String r5 = "x"
            r2.append(r5)     // Catch: com.nexstreaming.kinemaster.mediastore.MediaStore.UnavailableDataException -> L6d
            com.nexstreaming.kinemaster.mediastore.item.c r5 = r3.f21704b     // Catch: com.nexstreaming.kinemaster.mediastore.MediaStore.UnavailableDataException -> L6d
            int r5 = r5.getHeight()     // Catch: com.nexstreaming.kinemaster.mediastore.MediaStore.UnavailableDataException -> L6d
            r2.append(r5)     // Catch: com.nexstreaming.kinemaster.mediastore.MediaStore.UnavailableDataException -> L6d
            r2.append(r4)     // Catch: com.nexstreaming.kinemaster.mediastore.MediaStore.UnavailableDataException -> L6d
            com.nexstreaming.kinemaster.mediastore.item.c r4 = r3.f21704b     // Catch: com.nexstreaming.kinemaster.mediastore.MediaStore.UnavailableDataException -> L6d
            int r4 = r4.b()     // Catch: com.nexstreaming.kinemaster.mediastore.MediaStore.UnavailableDataException -> L6d
            r2.append(r4)     // Catch: com.nexstreaming.kinemaster.mediastore.MediaStore.UnavailableDataException -> L6d
            java.lang.String r4 = "FPS"
            r2.append(r4)     // Catch: com.nexstreaming.kinemaster.mediastore.MediaStore.UnavailableDataException -> L6d
            java.lang.String r4 = r2.toString()     // Catch: com.nexstreaming.kinemaster.mediastore.MediaStore.UnavailableDataException -> L6d
            r1.setText(r4)     // Catch: com.nexstreaming.kinemaster.mediastore.MediaStore.UnavailableDataException -> L6d
            goto L8e
        L6d:
            com.nexstreaming.kinemaster.ui.mediabrowser.g r4 = r3.f21703a
            boolean r4 = r4.isAdded()
            if (r4 == 0) goto L8e
            com.nexstreaming.kinemaster.ui.mediabrowser.g r4 = r3.f21703a
            android.widget.TextView r4 = com.nexstreaming.kinemaster.ui.mediabrowser.C1829g.b(r4)
            if (r4 == 0) goto L8e
            com.nextreaming.nexeditorui.KineMasterApplication$a r5 = com.nextreaming.nexeditorui.KineMasterApplication.f24058f
            com.nextreaming.nexeditorui.KineMasterApplication r5 = r5.c()
            r0 = 2131821932(0x7f11056c, float:1.9276621E38)
            java.lang.String r5 = r5.getString(r0)
            r4.setText(r5)
        L8e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.kinemaster.ui.mediabrowser.C1840s.onTaskEvent(com.nexstreaming.app.general.task.Task, com.nexstreaming.app.general.task.Task$Event):void");
    }
}
