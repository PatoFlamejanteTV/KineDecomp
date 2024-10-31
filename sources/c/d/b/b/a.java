package c.d.b.b;

import android.util.Log;
import com.google.android.gms.tasks.OnFailureListener;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Account.java */
/* loaded from: classes.dex */
public class a implements OnFailureListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f3593a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ d f3594b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(d dVar, String str) {
        this.f3594b = dVar;
        this.f3593a = str;
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public void onFailure(Exception exc) {
        Log.e(d.f3598a, "[updateAccessTime] uid: " + this.f3593a + ", error: " + exc, exc);
    }
}
