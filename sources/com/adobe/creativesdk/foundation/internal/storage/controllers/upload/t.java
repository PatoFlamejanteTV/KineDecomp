package com.adobe.creativesdk.foundation.internal.storage.controllers.upload;

import com.adobe.creativesdk.foundation.internal.storage.controllers.upload.A;
import com.adobe.creativesdk.foundation.internal.storage.controllers.upload.AdobeUploadAssetData;
import java.util.ArrayList;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

/* compiled from: AdobeUploadSession.java */
/* loaded from: classes.dex */
public class t<EndPointType extends A<EndPointType>> {

    /* renamed from: a */
    private EndPointType f6463a;

    /* renamed from: b */
    private ArrayList<AdobeUploadAssetData> f6464b;

    /* renamed from: c */
    private ArrayList<t<EndPointType>.a> f6465c;

    /* renamed from: d */
    private c f6466d;

    /* renamed from: e */
    private Map<String, t<EndPointType>.b> f6467e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AdobeUploadSession.java */
    /* loaded from: classes.dex */
    public class a {

        /* renamed from: a */
        private final AdobeUploadAssetData f6468a;

        /* renamed from: b */
        private final B<EndPointType> f6469b;

        public void a() {
            this.f6469b.a();
        }

        public AdobeUploadAssetData b() {
            return this.f6468a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AdobeUploadSession.java */
    /* loaded from: classes.dex */
    public class b extends Observable {
        private b() {
        }

        /* synthetic */ b(t tVar, s sVar) {
            this();
        }
    }

    /* compiled from: AdobeUploadSession.java */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a */
        public ArrayList<AdobeUploadAssetData> f6471a = new ArrayList<>();

        /* renamed from: c */
        public ArrayList<AdobeUploadAssetData> f6473c = new ArrayList<>();

        /* renamed from: d */
        public ArrayList<AdobeUploadAssetData> f6474d = new ArrayList<>();

        /* renamed from: b */
        public ArrayList<AdobeUploadAssetData> f6472b = new ArrayList<>();

        public int a() {
            return this.f6471a.size();
        }

        public int b() {
            return this.f6473c.size();
        }

        public boolean c() {
            return this.f6472b.size() > 0;
        }
    }

    public ArrayList<AdobeUploadAssetData> a() {
        return this.f6464b;
    }

    public EndPointType b() {
        return this.f6463a;
    }

    public c c() {
        return this.f6466d;
    }

    public void a(AdobeUploadAssetData adobeUploadAssetData, Observer observer) {
        t<EndPointType>.b bVar = this.f6467e.get(adobeUploadAssetData.f5272a);
        if (bVar == null) {
            bVar = new b();
            this.f6467e.put(adobeUploadAssetData.f5272a, bVar);
        }
        bVar.addObserver(observer);
    }

    public void b(AdobeUploadAssetData adobeUploadAssetData, Observer observer) {
        t<EndPointType>.b bVar = this.f6467e.get(adobeUploadAssetData.f5272a);
        if (bVar == null) {
            return;
        }
        bVar.deleteObserver(observer);
    }

    public static boolean a(AdobeUploadAssetData adobeUploadAssetData, AdobeUploadAssetData adobeUploadAssetData2) {
        return adobeUploadAssetData.f5272a.equalsIgnoreCase(adobeUploadAssetData2.f5272a);
    }

    public void a(AdobeUploadAssetData adobeUploadAssetData) {
        for (int i = 0; i < this.f6465c.size(); i++) {
            if (a(this.f6465c.get(i).b(), adobeUploadAssetData)) {
                if (this.f6465c.get(i).b().d() == AdobeUploadAssetData.UploadStatus.Started) {
                    return;
                }
                this.f6465c.get(i).a();
                this.f6465c.remove(i);
                return;
            }
        }
    }
}
