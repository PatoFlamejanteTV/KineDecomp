package com.nexstreaming.app.general.iab.assist;

import c.d.b.m.e;
import c.d.b.m.i;
import com.facebook.GraphResponse;
import com.google.gson.Gson;
import com.nexstreaming.app.general.iab.Presenter.C1695y;
import com.nexstreaming.app.general.iab.b.d;
import com.nexstreaming.kinemaster.network.SubscriptionInfo;
import com.nexstreaming.kinemaster.usage.analytics.KMEvents;
import com.nextreaming.nexeditorui.KineMasterApplication;
import io.reactivex.n;
import java.util.HashMap;
import kotlin.jvm.internal.h;
import kotlin.k;

/* compiled from: SubscriptionFirebaseAgent.kt */
/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private static a f19435a = new a();

    public static final void a(final C1695y c1695y, final n<d> nVar) {
        h.b(c1695y, "googlePresent");
        h.b(nVar, "observableEmitter");
        if (e.f3850a.a()) {
            return;
        }
        f19435a.a("Android", new kotlin.jvm.a.b<String, k>() { // from class: com.nexstreaming.app.general.iab.assist.SubscriptionFirebaseAgentKt$getSubscriptionInfoFromFirebase$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.a.b
            public /* bridge */ /* synthetic */ k invoke(String str) {
                invoke2(str);
                return k.f28545a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                DummySubscriptionList dummySubscriptionList;
                SubscriptionInfo skuList;
                if (str == null || (dummySubscriptionList = (DummySubscriptionList) new Gson().fromJson(str, DummySubscriptionList.class)) == null || (skuList = dummySubscriptionList.getSkuList()) == null) {
                    return;
                }
                C1695y.this.a(skuList, nVar);
                HashMap hashMap = new HashMap();
                hashMap.put("network", String.valueOf(i.f(KineMasterApplication.f24058f.c())));
                hashMap.put("edition", "Android");
                hashMap.put("result", GraphResponse.SUCCESS_KEY);
                KMEvents.SUBSCRIPTION_GET_FIREBASE.logEvent(hashMap);
            }
        });
    }
}
