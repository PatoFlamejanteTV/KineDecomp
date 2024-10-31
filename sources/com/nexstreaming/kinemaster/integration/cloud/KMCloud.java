package com.nexstreaming.kinemaster.integration.cloud;

import android.app.Activity;
import android.content.Context;
import com.nexstreaming.app.general.task.Task;
import java.util.Date;
import java.util.List;

/* loaded from: classes.dex */
public abstract class KMCloud implements com.nexstreaming.kinemaster.integration.cloud.a {

    /* renamed from: a */
    private final String f20417a;

    /* renamed from: c */
    protected b f20419c;

    /* renamed from: d */
    Activity f20420d;

    /* renamed from: e */
    public String f20421e;

    /* renamed from: f */
    protected List<String> f20422f;

    /* renamed from: g */
    protected int f20423g;

    /* renamed from: b */
    public KMCloudState f20418b = KMCloudState.KM_CLOUD_STATE_LOGGED_OUT;

    /* renamed from: h */
    private int f20424h = 0;

    /* loaded from: classes.dex */
    enum CloudError implements Task.TaskError {
        REQUEST_ERROR,
        UPLOADING_ERROR,
        CREATION_ERROR;

        @Override // com.nexstreaming.app.general.task.Task.TaskError
        public Exception getException() {
            return null;
        }

        @Override // com.nexstreaming.app.general.task.Task.TaskError
        public String getLocalizedMessage(Context context) {
            return name();
        }

        @Override // com.nexstreaming.app.general.task.Task.TaskError
        public String getMessage() {
            return name();
        }
    }

    /* loaded from: classes.dex */
    public enum KMCloudReturnValue {
        KM_CLOUD_RETURN_SUCCESS,
        KM_CLOUD_RETURN_LOGIN_FAILED,
        KM_CLOUD_RETURN_LOGOUT_FAILED,
        KM_CLOUD_RETURN_CREATEFOLDER_FAILED,
        KM_CLOUD_RETURN_CREATEFILE_FAILED,
        KM_CLOUD_RETURN_UPLOAD_DONE
    }

    /* loaded from: classes.dex */
    public enum KMCloudState {
        KM_CLOUD_STATE_LOG_IN_TRY,
        KM_CLOUD_STATE_LOGGED_IN,
        KM_CLOUD_STATE_LOGGED_OUT,
        KM_CLOUD_STATE_CREATED_FOLDER,
        KM_CLOUD_STATE_CREATED_FILE
    }

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a */
        public String f20425a;

        /* renamed from: b */
        public String f20426b;

        /* renamed from: c */
        public String f20427c;

        /* renamed from: d */
        public Date f20428d;

        /* renamed from: e */
        public long f20429e;

        public a(String str, String str2, String str3, Date date, long j) {
            this.f20425a = str;
            this.f20426b = str2;
            this.f20427c = str3;
            this.f20428d = date;
            this.f20429e = j;
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(String str, KMCloudReturnValue kMCloudReturnValue, KMCloudState kMCloudState);

        void a(String str, KMCloudState kMCloudState);

        void a(String str, KMCloudState kMCloudState, int i, int i2);

        void a(String str, KMCloudState kMCloudState, String str2);

        void b(String str, KMCloudReturnValue kMCloudReturnValue, KMCloudState kMCloudState);
    }

    public KMCloud(Activity activity, String str, b bVar) {
        this.f20420d = activity;
        this.f20417a = str;
        this.f20419c = bVar;
    }

    public abstract int a(String str, List<String> list);

    public abstract Task a(String str);

    public abstract String a();

    public KMCloudState b() {
        return this.f20418b;
    }

    public abstract int c();

    public abstract int d();

    public abstract void e();

    public void b(String str) {
        if (this.f20424h < this.f20422f.size()) {
            this.f20419c.a(a(), KMCloudState.KM_CLOUD_STATE_CREATED_FILE, this.f20422f.get(this.f20424h));
            List<String> list = this.f20422f;
            int i = this.f20424h;
            this.f20424h = i + 1;
            a(list.get(i)).onComplete(new f(this)).onFailure(new e(this)).onProgress(new d(this));
            return;
        }
        this.f20424h = 0;
        this.f20418b = KMCloudState.KM_CLOUD_STATE_LOGGED_IN;
        this.f20419c.a(a(), KMCloudReturnValue.KM_CLOUD_RETURN_UPLOAD_DONE, KMCloudState.KM_CLOUD_STATE_CREATED_FILE);
    }
}
