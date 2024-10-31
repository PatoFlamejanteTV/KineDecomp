package c.d.b.k;

import android.os.SystemClock;
import android.util.Log;
import com.nexstreaming.app.general.task.Task;
import com.nextreaming.nexeditorui.NexExportProfile;
import java.io.File;

/* compiled from: TranscodingTask.java */
/* loaded from: classes.dex */
public class j extends Task {

    /* renamed from: a */
    private final File f3838a;

    /* renamed from: b */
    private final File f3839b;

    /* renamed from: c */
    private final File f3840c;

    /* renamed from: d */
    private final NexExportProfile f3841d;

    /* renamed from: e */
    long f3842e;

    /* renamed from: f */
    long f3843f;

    /* renamed from: g */
    boolean f3844g = true;

    /* renamed from: h */
    boolean f3845h = false;

    public j(File file, File file2, File file3, NexExportProfile nexExportProfile) {
        this.f3838a = file;
        this.f3839b = file3;
        this.f3841d = nexExportProfile;
        this.f3840c = file2;
    }

    public File a() {
        return this.f3839b;
    }

    public long b() {
        long j;
        long j2;
        if (this.f3845h) {
            j = SystemClock.uptimeMillis();
            j2 = this.f3842e;
        } else {
            j = this.f3843f;
            j2 = this.f3842e;
        }
        return j - j2;
    }

    public NexExportProfile c() {
        return this.f3841d;
    }

    @Override // com.nexstreaming.app.general.task.Task
    public void cancel() {
        i.b(this);
    }

    public long d() {
        long b2 = b();
        int progress = getProgress();
        if (this.f3844g || !isProgressAvailable() || progress < 1) {
            return -1L;
        }
        if (b2 < 12000 && progress < getMaxProgress() / 2) {
            return -1L;
        }
        if (this.f3845h) {
            return (b2 * (getMaxProgress() - progress)) / progress;
        }
        return 0L;
    }

    public File e() {
        return this.f3838a;
    }

    public File f() {
        return this.f3840c;
    }

    public void g() {
        if (!this.f3845h) {
            Log.w("TranscodingTask", "signalTranscodingDone called, but not transcoding");
        } else {
            this.f3843f = SystemClock.uptimeMillis();
            this.f3845h = false;
        }
    }

    public void h() {
        this.f3844g = true;
        this.f3842e = 0L;
        this.f3845h = false;
    }

    public void i() {
        if (this.f3844g) {
            this.f3844g = false;
            this.f3842e = SystemClock.uptimeMillis();
            this.f3845h = true;
            return;
        }
        throw new IllegalStateException();
    }
}
