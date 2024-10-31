package c.d.b.b;

import android.util.Log;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RemoteConfig.java */
/* loaded from: classes.dex */
public class j implements OnCompleteListener<Void> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ OnCompleteListener f3618a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ k f3619b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(k kVar, OnCompleteListener onCompleteListener) {
        this.f3619b = kVar;
        this.f3618a = onCompleteListener;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public void onComplete(Task<Void> task) {
        String str;
        FirebaseRemoteConfig firebaseRemoteConfig;
        String str2;
        if (task.e()) {
            firebaseRemoteConfig = this.f3619b.f3622c;
            firebaseRemoteConfig.a();
            str2 = k.f3620a;
            Log.d(str2, "fetch onComplete success");
        } else {
            str = k.f3620a;
            Log.d(str, "fetch onComplete failure");
        }
        OnCompleteListener onCompleteListener = this.f3618a;
        if (onCompleteListener != null) {
            onCompleteListener.onComplete(task);
        }
    }
}
