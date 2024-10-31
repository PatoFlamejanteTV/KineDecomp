package c.d.b.b;

import android.util.Log;
import c.d.b.b.d;
import com.google.android.gms.tasks.OnFailureListener;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Account.java */
/* loaded from: classes.dex */
public class e implements OnFailureListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ d.b f3605a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d.b bVar) {
        this.f3605a = bVar;
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public void onFailure(Exception exc) {
        c.d.b.b.a.e eVar;
        String str = d.f3598a;
        StringBuilder sb = new StringBuilder();
        sb.append("[updateUserInfo] id: ");
        eVar = this.f3605a.f3603b;
        sb.append(eVar.getId());
        sb.append(", error: ");
        sb.append(exc);
        Log.e(str, sb.toString(), exc);
    }
}
