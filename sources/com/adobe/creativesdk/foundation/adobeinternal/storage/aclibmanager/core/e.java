package com.adobe.creativesdk.foundation.adobeinternal.storage.aclibmanager.core;

import android.os.Handler;
import c.a.a.a.a.b.a.c.g;
import com.adobe.creativesdk.foundation.adobeinternal.net.AdobeNetworkReachability;
import com.adobe.creativesdk.foundation.storage.AdobeLibraryDownloadPolicyType;
import com.adobe.creativesdk.foundation.storage.Jb;
import java.util.ArrayList;
import java.util.EnumSet;

/* compiled from: ACLibraryManagerOptions.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public Jb f4091a;

    /* renamed from: b, reason: collision with root package name */
    public Handler f4092b;

    /* renamed from: c, reason: collision with root package name */
    public String f4093c;

    public static e a(ArrayList<String> arrayList) {
        Jb jb = new Jb();
        jb.f7024b = AdobeLibraryDownloadPolicyType.AdobeLibraryDownloadPolicyTypeManifestOnly;
        jb.f7028f = EnumSet.of(AdobeNetworkReachability.AdobeNetworkStatusCode.AdobeNetworkReachableMetered, AdobeNetworkReachability.AdobeNetworkStatusCode.AdobeNetworkReachableNonMetered);
        jb.f7027e = arrayList;
        e eVar = new e();
        eVar.f4091a = jb;
        eVar.f4092b = new Handler();
        eVar.f4093c = g.d();
        return eVar;
    }
}
