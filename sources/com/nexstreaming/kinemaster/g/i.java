package com.nexstreaming.kinemaster.g;

import android.os.SystemClock;
import android.util.Log;
import com.nexstreaming.app.general.task.Task;
import com.nextreaming.nexeditorui.NexExportProfile;
import java.io.File;

/* compiled from: TranscodingTask.java */
/* loaded from: classes.dex */
public class i extends Task {

    /* renamed from: a, reason: collision with root package name */
    long f3391a;
    long b;
    boolean c = true;
    boolean d = false;
    private final File e;
    private final File f;
    private final File g;
    private final NexExportProfile h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(File file, File file2, File file3, NexExportProfile nexExportProfile) {
        this.e = file;
        this.f = file3;
        this.h = nexExportProfile;
        this.g = file2;
    }

    public File a() {
        return this.e;
    }

    public File b() {
        return this.f;
    }

    public File c() {
        return this.g;
    }

    public NexExportProfile d() {
        return this.h;
    }

    @Override // com.nexstreaming.app.general.task.Task
    public void cancel() {
        b.a(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        if (!this.c) {
            throw new IllegalStateException();
        }
        this.c = false;
        this.f3391a = SystemClock.uptimeMillis();
        this.d = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        this.c = true;
        this.f3391a = 0L;
        this.d = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g() {
        if (!this.d) {
            Log.w("TranscodingTask", "signalTranscodingDone called, but not transcoding");
        } else {
            this.b = SystemClock.uptimeMillis();
            this.d = false;
        }
    }

    public long h() {
        if (this.d) {
            return SystemClock.uptimeMillis() - this.f3391a;
        }
        return this.b - this.f3391a;
    }

    public long i() {
        long h = h();
        int progress = getProgress();
        if (this.c || !isProgressAvailable() || progress < 1 || (h < 12000 && progress < getMaxProgress() / 2)) {
            return -1L;
        }
        if (!this.d) {
            return 0L;
        }
        return (h * (getMaxProgress() - progress)) / progress;
    }
}
