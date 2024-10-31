package com.nexstreaming.kinemaster.kmpackage;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EffectPreviewPlayer.java */
/* loaded from: classes.dex */
public class t implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ EffectPreviewPlayer f3464a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(EffectPreviewPlayer effectPreviewPlayer) {
        this.f3464a = effectPreviewPlayer;
    }

    /* JADX WARN: Incorrect condition in loop: B:3:0x0032 */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            r5 = this;
            r4 = 0
            r1 = 0
            com.nexstreaming.kinemaster.kmpackage.EffectPreviewPlayer r0 = r5.f3464a
            java.lang.Thread r2 = java.lang.Thread.currentThread()
            long r2 = r2.getId()
            com.nexstreaming.kinemaster.kmpackage.EffectPreviewPlayer.a(r0, r2)
            com.nexstreaming.kinemaster.kmpackage.EffectPreviewPlayer r0 = r5.f3464a
            com.nextreaming.nexvideoeditor.NexThemeRenderer r2 = new com.nextreaming.nexvideoeditor.NexThemeRenderer
            r2.<init>()
            com.nexstreaming.kinemaster.kmpackage.EffectPreviewPlayer.a(r0, r2)
            com.nexstreaming.kinemaster.kmpackage.EffectPreviewPlayer r0 = r5.f3464a
            com.nextreaming.nexvideoeditor.NexThemeRenderer r0 = com.nexstreaming.kinemaster.kmpackage.EffectPreviewPlayer.b(r0)
            com.nexstreaming.kinemaster.kmpackage.EffectPreviewPlayer r2 = r5.f3464a
            com.nextreaming.nexvideoeditor.NexImageLoader r2 = com.nexstreaming.kinemaster.kmpackage.EffectPreviewPlayer.a(r2)
            r0.init(r2)
        L28:
            com.nexstreaming.kinemaster.kmpackage.EffectPreviewPlayer r0 = r5.f3464a
            java.util.concurrent.atomic.AtomicBoolean r0 = com.nexstreaming.kinemaster.kmpackage.EffectPreviewPlayer.c(r0)
            boolean r0 = r0.get()
            if (r0 != 0) goto L82
            com.nexstreaming.kinemaster.kmpackage.EffectPreviewPlayer r0 = r5.f3464a
            boolean r0 = com.nexstreaming.kinemaster.kmpackage.EffectPreviewPlayer.d(r0)
            if (r0 == 0) goto L75
            com.nexstreaming.kinemaster.kmpackage.EffectPreviewPlayer r0 = r5.f3464a
            boolean r0 = com.nexstreaming.kinemaster.kmpackage.EffectPreviewPlayer.e(r0)
            if (r0 == 0) goto L4e
            com.nexstreaming.kinemaster.kmpackage.EffectPreviewPlayer r0 = r5.f3464a
            com.nextreaming.nexvideoeditor.NexThemeRenderer r0 = com.nexstreaming.kinemaster.kmpackage.EffectPreviewPlayer.b(r0)
            r2 = 2
            r0.clearSurface(r2)
        L4e:
            com.nexstreaming.kinemaster.kmpackage.EffectPreviewPlayer r0 = r5.f3464a
            com.nextreaming.nexvideoeditor.NexThemeRenderer r0 = com.nexstreaming.kinemaster.kmpackage.EffectPreviewPlayer.b(r0)
            com.nexstreaming.kinemaster.kmpackage.EffectPreviewPlayer r2 = r5.f3464a
            android.view.Surface r2 = com.nexstreaming.kinemaster.kmpackage.EffectPreviewPlayer.f(r2)
            r0.prepareSurface(r2)
            com.nexstreaming.kinemaster.kmpackage.EffectPreviewPlayer r2 = r5.f3464a
            com.nexstreaming.kinemaster.kmpackage.EffectPreviewPlayer r0 = r5.f3464a
            android.view.Surface r0 = com.nexstreaming.kinemaster.kmpackage.EffectPreviewPlayer.f(r0)
            if (r0 == 0) goto L80
            r0 = 1
        L68:
            com.nexstreaming.kinemaster.kmpackage.EffectPreviewPlayer.a(r2, r0)
            com.nexstreaming.kinemaster.kmpackage.EffectPreviewPlayer r0 = r5.f3464a
            com.nexstreaming.kinemaster.kmpackage.EffectPreviewPlayer.a(r0, r4)
            com.nexstreaming.kinemaster.kmpackage.EffectPreviewPlayer r0 = r5.f3464a
            com.nexstreaming.kinemaster.kmpackage.EffectPreviewPlayer.b(r0, r1)
        L75:
            r2 = 15
            java.lang.Thread.sleep(r2)     // Catch: java.lang.InterruptedException -> Lb6
            com.nexstreaming.kinemaster.kmpackage.EffectPreviewPlayer r0 = r5.f3464a
            r0.a()
            goto L28
        L80:
            r0 = r1
            goto L68
        L82:
            com.nexstreaming.kinemaster.kmpackage.EffectPreviewPlayer r2 = r5.f3464a
            monitor-enter(r2)
            com.nexstreaming.kinemaster.kmpackage.EffectPreviewPlayer r0 = r5.f3464a     // Catch: java.lang.Throwable -> Lb3
            com.nextreaming.nexvideoeditor.NexThemeRenderer r0 = com.nexstreaming.kinemaster.kmpackage.EffectPreviewPlayer.b(r0)     // Catch: java.lang.Throwable -> Lb3
            r3 = 0
            r0.prepareSurface(r3)     // Catch: java.lang.Throwable -> Lb3
            com.nexstreaming.kinemaster.kmpackage.EffectPreviewPlayer r0 = r5.f3464a     // Catch: java.lang.Throwable -> Lb3
            com.nextreaming.nexvideoeditor.NexThemeRenderer r0 = com.nexstreaming.kinemaster.kmpackage.EffectPreviewPlayer.b(r0)     // Catch: java.lang.Throwable -> Lb3
            r0.recycleRenderer()     // Catch: java.lang.Throwable -> Lb3
            com.nexstreaming.kinemaster.kmpackage.EffectPreviewPlayer r0 = r5.f3464a     // Catch: java.lang.Throwable -> Lb3
            com.nextreaming.nexvideoeditor.NexThemeRenderer r0 = com.nexstreaming.kinemaster.kmpackage.EffectPreviewPlayer.b(r0)     // Catch: java.lang.Throwable -> Lb3
            r3 = 0
            r0.deinit(r3)     // Catch: java.lang.Throwable -> Lb3
            com.nexstreaming.kinemaster.kmpackage.EffectPreviewPlayer r0 = r5.f3464a     // Catch: java.lang.Throwable -> Lb3
            r3 = 0
            com.nexstreaming.kinemaster.kmpackage.EffectPreviewPlayer.a(r0, r3)     // Catch: java.lang.Throwable -> Lb3
            monitor-exit(r2)     // Catch: java.lang.Throwable -> Lb3
            com.nexstreaming.kinemaster.kmpackage.EffectPreviewPlayer r0 = r5.f3464a
            java.util.concurrent.atomic.AtomicBoolean r0 = com.nexstreaming.kinemaster.kmpackage.EffectPreviewPlayer.g(r0)
            r0.set(r1)
            return
        Lb3:
            r0 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> Lb3
            throw r0
        Lb6:
            r0 = move-exception
            goto L28
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.kinemaster.kmpackage.t.run():void");
    }
}
