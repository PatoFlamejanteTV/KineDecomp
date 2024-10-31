package com.google.firebase.iid;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.qq.e.comm.pi.ACTD;
import java.io.IOException;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class I implements MessagingChannel {

    /* renamed from: a */
    private final FirebaseApp f17330a;

    /* renamed from: b */
    private final zzan f17331b;

    /* renamed from: c */
    private final C1619p f17332c;

    /* renamed from: d */
    private final Executor f17333d;

    public I(FirebaseApp firebaseApp, zzan zzanVar, Executor executor) {
        this(firebaseApp, zzanVar, executor, new C1619p(firebaseApp.b(), zzanVar));
    }

    @Override // com.google.firebase.iid.MessagingChannel
    public final Task<Void> a(String str, String str2) {
        return Tasks.a((Object) null);
    }

    @Override // com.google.firebase.iid.MessagingChannel
    public final boolean a() {
        return true;
    }

    @Override // com.google.firebase.iid.MessagingChannel
    public final boolean b() {
        return this.f17331b.a() != 0;
    }

    private I(FirebaseApp firebaseApp, zzan zzanVar, Executor executor, C1619p c1619p) {
        this.f17330a = firebaseApp;
        this.f17331b = zzanVar;
        this.f17332c = c1619p;
        this.f17333d = executor;
    }

    @Override // com.google.firebase.iid.MessagingChannel
    public final Task<String> a(String str, String str2, String str3, String str4) {
        return b(a(str, str3, str4, new Bundle()));
    }

    @Override // com.google.firebase.iid.MessagingChannel
    public final Task<Void> b(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        String valueOf = String.valueOf(str3);
        bundle.putString("gcm.topic", valueOf.length() != 0 ? "/topics/".concat(valueOf) : new String("/topics/"));
        String valueOf2 = String.valueOf(str3);
        return a(b(a(str, str2, valueOf2.length() != 0 ? "/topics/".concat(valueOf2) : new String("/topics/"), bundle)));
    }

    @Override // com.google.firebase.iid.MessagingChannel
    public final Task<Void> a(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        String valueOf = String.valueOf(str3);
        bundle.putString("gcm.topic", valueOf.length() != 0 ? "/topics/".concat(valueOf) : new String("/topics/"));
        bundle.putString("delete", "1");
        String valueOf2 = String.valueOf(str3);
        return a(b(a(str, str2, valueOf2.length() != 0 ? "/topics/".concat(valueOf2) : new String("/topics/"), bundle)));
    }

    private final Task<String> b(Task<Bundle> task) {
        return task.a(this.f17333d, new L(this));
    }

    private final Task<Bundle> a(String str, String str2, String str3, Bundle bundle) {
        bundle.putString("scope", str3);
        bundle.putString("sender", str2);
        bundle.putString("subtype", str2);
        bundle.putString(ACTD.APPID_KEY, str);
        bundle.putString("gmp_app_id", this.f17330a.e().b());
        bundle.putString("gmsv", Integer.toString(this.f17331b.d()));
        bundle.putString("osv", Integer.toString(Build.VERSION.SDK_INT));
        bundle.putString("app_ver", this.f17331b.b());
        bundle.putString("app_ver_name", this.f17331b.c());
        bundle.putString("cliv", "fiid-12451000");
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f17333d.execute(new Runnable(this, bundle, taskCompletionSource) { // from class: com.google.firebase.iid.J

            /* renamed from: a, reason: collision with root package name */
            private final I f17334a;

            /* renamed from: b, reason: collision with root package name */
            private final Bundle f17335b;

            /* renamed from: c, reason: collision with root package name */
            private final TaskCompletionSource f17336c;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f17334a = this;
                this.f17335b = bundle;
                this.f17336c = taskCompletionSource;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f17334a.a(this.f17335b, this.f17336c);
            }
        });
        return taskCompletionSource.a();
    }

    public static String a(Bundle bundle) throws IOException {
        if (bundle != null) {
            String string = bundle.getString("registration_id");
            if (string != null) {
                return string;
            }
            String string2 = bundle.getString("unregistered");
            if (string2 != null) {
                return string2;
            }
            String string3 = bundle.getString("error");
            if ("RST".equals(string3)) {
                throw new IOException("INSTANCE_ID_RESET");
            }
            if (string3 != null) {
                throw new IOException(string3);
            }
            String valueOf = String.valueOf(bundle);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 21);
            sb.append("Unexpected response: ");
            sb.append(valueOf);
            Log.w("FirebaseInstanceId", sb.toString(), new Throwable());
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
        throw new IOException("SERVICE_NOT_AVAILABLE");
    }

    private final <T> Task<Void> a(Task<T> task) {
        return task.a(A.a(), new K(this));
    }

    public final /* synthetic */ void a(Bundle bundle, TaskCompletionSource taskCompletionSource) {
        try {
            taskCompletionSource.a((TaskCompletionSource) this.f17332c.a(bundle));
        } catch (IOException e2) {
            taskCompletionSource.a((Exception) e2);
        }
    }
}
