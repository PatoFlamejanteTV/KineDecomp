package com.nexstreaming.kinemaster.mediastore.v2;

import android.content.Context;
import android.os.AsyncTask;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nextreaming.nexeditorui.NexEditorDeviceProfile;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public class RemoteMediaInfo {
    private static final Executor i = Executors.newCachedThreadPool();

    /* renamed from: a, reason: collision with root package name */
    private int f3556a = 0;
    private int b = 0;
    private int c = 0;
    private int d = 0;
    private int e = 0;
    private long f = 0;
    private String g;
    private String h;

    /* loaded from: classes.dex */
    public enum ErrorCode implements Task.TaskError {
        NO_TRACKS,
        BAD_MIME_TYPE,
        NOT_AVAILABLE_MEDIAEXTRACTOR;

        @Override // com.nexstreaming.app.general.task.Task.TaskError
        public Exception getException() {
            return null;
        }

        @Override // com.nexstreaming.app.general.task.Task.TaskError
        public String getMessage() {
            return name();
        }

        @Override // com.nexstreaming.app.general.task.Task.TaskError
        public String getLocalizedMessage(Context context) {
            return getMessage();
        }
    }

    public int a() {
        return this.f3556a;
    }

    public int b() {
        return this.b;
    }

    public int c() {
        return this.c;
    }

    public long d() {
        return this.f;
    }

    public boolean e() {
        return this.g != null && this.g.equals("video/avc");
    }

    public boolean f() {
        return this.h != null && g();
    }

    public boolean g() {
        return this.h == null || this.h.equals("audio/mp4a-latm");
    }

    public int h() {
        return this.d;
    }

    public int i() {
        return this.e;
    }

    public static ResultTask<RemoteMediaInfo> a(String str, Map<String, String> map) {
        ResultTask<RemoteMediaInfo> resultTask = new ResultTask<>();
        if (!NexEditorDeviceProfile.getDeviceProfile().getUseMediaExtractor()) {
            resultTask.sendFailure(ErrorCode.NOT_AVAILABLE_MEDIAEXTRACTOR);
        } else {
            AsyncTask<Void, Void, Task.TaskError> executeOnExecutor = new n(str, map, resultTask).executeOnExecutor(i, new Void[0]);
            resultTask.setTimeout(20000L);
            resultTask.onFailure((Task.OnFailListener) new o(executeOnExecutor));
        }
        return resultTask;
    }
}
