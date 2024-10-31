package com.nexstreaming.kinemaster.network;

import com.nexstreaming.app.general.task.ResultTask;
import java.util.List;

/* compiled from: NetworkService.kt */
/* renamed from: com.nexstreaming.kinemaster.network.i */
/* loaded from: classes.dex */
public interface InterfaceC1820i {
    ResultTask<l> a(int i);

    ResultTask<InterfaceC1821j> a(int i, boolean z);

    ResultTask<List<InterfaceC1821j>> a(InterfaceC1822k interfaceC1822k);

    ResultTask<List<InterfaceC1821j>> a(m mVar);

    ResultTask<List<AssetStoreAPIData$AssetVersionInfo>> a(String str);

    String a();

    boolean a(InterfaceC1821j interfaceC1821j);

    AssetEnv b();

    void c();

    ResultTask<List<InterfaceC1821j>> d();

    ResultTask<SubscriptionInfo> e();

    void f();

    ResultTask<List<InterfaceC1822k>> g();

    int h();
}
