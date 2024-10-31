package c.d.a.a.d.a;

import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import c.d.a.a.d.a.d;
import com.android.volley.VolleyError;
import com.android.volley.a.m;
import com.nexstreaming.app.general.nexasset.assetpackage.h;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.network.InterfaceC1821j;
import java.util.ArrayList;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AssetInstallHelper.java */
/* loaded from: classes2.dex */
public class a implements m.d {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f3544a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ b f3545b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar, String str) {
        this.f3545b = bVar;
        this.f3544a = str;
    }

    @Override // com.android.volley.a.m.d
    public void a(m.c cVar, boolean z) {
        Bitmap a2;
        Context context;
        NotificationManager notificationManager;
        h hVar;
        ArrayList arrayList;
        Executor executor;
        if (cVar == null || cVar.a() == null || cVar.a().isRecycled()) {
            return;
        }
        Bitmap a3 = cVar.a();
        a2 = this.f3545b.f3549d.a(a3);
        context = this.f3545b.f3549d.f3555e;
        b bVar = this.f3545b;
        InterfaceC1821j interfaceC1821j = bVar.f3546a;
        notificationManager = bVar.f3549d.f3554d;
        String str = this.f3544a;
        hVar = this.f3545b.f3549d.f3553c;
        b bVar2 = this.f3545b;
        d.c cVar2 = bVar2.f3547b;
        arrayList = bVar2.f3549d.f3556f;
        d.a aVar = new d.a(context, interfaceC1821j, a2, a3, notificationManager, str, hVar, cVar2, arrayList, this.f3545b.f3548c, null);
        executor = d.f3551a;
        aVar.executeOnExecutor(executor, null);
    }

    @Override // com.android.volley.m.a
    public void a(VolleyError volleyError) {
        Context context;
        Log.w("AssetInstallHelper", "Failed installation ", volleyError);
        b bVar = this.f3545b;
        Task task = bVar.f3548c;
        context = bVar.f3549d.f3555e;
        task.sendFailure(new d.b(context.getString(R.string.asset_install_failed), R.string.asset_install_failed, volleyError));
    }
}
