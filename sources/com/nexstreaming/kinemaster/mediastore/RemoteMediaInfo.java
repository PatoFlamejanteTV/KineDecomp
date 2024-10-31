package com.nexstreaming.kinemaster.mediastore;

import android.content.Context;
import android.os.AsyncTask;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public class RemoteMediaInfo {

    /* renamed from: a, reason: collision with root package name */
    private static final Executor f20876a = Executors.newCachedThreadPool();

    /* renamed from: h, reason: collision with root package name */
    private String f20883h;
    private String i;

    /* renamed from: b, reason: collision with root package name */
    private int f20877b = 0;

    /* renamed from: c, reason: collision with root package name */
    private int f20878c = 0;

    /* renamed from: d, reason: collision with root package name */
    private int f20879d = 0;

    /* renamed from: e, reason: collision with root package name */
    private int f20880e = 0;

    /* renamed from: f, reason: collision with root package name */
    private int f20881f = 0;

    /* renamed from: g, reason: collision with root package name */
    private long f20882g = 0;
    private int j = 1;

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
        public String getLocalizedMessage(Context context) {
            return getMessage();
        }

        @Override // com.nexstreaming.app.general.task.Task.TaskError
        public String getMessage() {
            return name();
        }
    }

    public String g() {
        return this.f20883h;
    }

    public int h() {
        return this.f20878c;
    }

    public boolean i() {
        return this.i != null && j();
    }

    public boolean j() {
        String str = this.i;
        return str == null || str.equals("audio/mp4a-latm");
    }

    public boolean k() {
        String str = this.f20883h;
        return str != null && (str.equals("video/avc") || this.f20883h.equals("video/hevc"));
    }

    public int c() {
        return this.j;
    }

    public int d() {
        return this.f20879d;
    }

    public int e() {
        return this.f20881f;
    }

    public int f() {
        return this.f20880e;
    }

    public int b() {
        return this.f20877b;
    }

    public long a() {
        return this.f20882g;
    }

    public static ResultTask<RemoteMediaInfo> a(String str, Map<String, String> map) {
        ResultTask<RemoteMediaInfo> resultTask = new ResultTask<>();
        AsyncTask<Void, Void, Task.TaskError> executeOnExecutor = new i(str, map, resultTask).executeOnExecutor(f20876a, new Void[0]);
        resultTask.setTimeout(20000L);
        resultTask.onFailure((Task.OnFailListener) new j(executeOnExecutor));
        return resultTask;
    }
}
