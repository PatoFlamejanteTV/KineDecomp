package com.nexstreaming.app.general.iab.assist;

import android.util.Log;
import c.d.b.m.i;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageException;
import com.google.firebase.storage.StorageReference;
import com.nexstreaming.kinemaster.usage.analytics.KMEvents;
import com.nextreaming.nexeditorui.KineMasterApplication;
import java.util.HashMap;
import kotlin.jvm.internal.h;
import kotlin.k;

/* compiled from: FirebaseAssistant.kt */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final String f19430a = "FirebaseAssistant";

    /* renamed from: b, reason: collision with root package name */
    private final String f19431b = "prod";

    /* compiled from: FirebaseAssistant.kt */
    /* renamed from: com.nexstreaming.app.general.iab.assist.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public final class C0095a implements OnFailureListener {
        public C0095a() {
        }

        @Override // com.google.android.gms.tasks.OnFailureListener
        public void onFailure(Exception exc) {
            h.b(exc, "exception");
            int errorCode = ((StorageException) exc).getErrorCode();
            String message = exc.getMessage();
            Log.e(a.this.a(), "OnFailureListener: code:" + errorCode + ", message:" + message);
            HashMap hashMap = new HashMap();
            hashMap.put("network", String.valueOf(i.f(KineMasterApplication.f24058f.c())));
            hashMap.put("edition", "Android");
            hashMap.put("result", errorCode + ':' + message);
            KMEvents.SUBSCRIPTION_GET_FIREBASE.logEvent(hashMap);
        }
    }

    public final String a() {
        return this.f19430a;
    }

    public final void a(String str, kotlin.jvm.a.b<? super String, k> bVar) {
        h.b(str, "edition");
        FirebaseStorage b2 = FirebaseStorage.b();
        h.a((Object) b2, "FirebaseStorage.getInstance()");
        StorageReference e2 = b2.e();
        h.a((Object) e2, "storage.reference");
        StorageReference a2 = e2.a("products/" + this.f19431b + '/' + str + ".json");
        h.a((Object) a2, "storageRef.child(path)");
        a2.a(Long.MAX_VALUE).a(new b(this, bVar)).a(new C0095a());
    }
}
