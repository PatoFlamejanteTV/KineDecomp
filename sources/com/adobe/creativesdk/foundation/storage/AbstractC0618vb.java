package com.adobe.creativesdk.foundation.storage;

import android.os.Handler;
import com.adobe.creativesdk.foundation.adobeinternal.net.AdobeNetworkReachability;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import java.util.ArrayList;

/* compiled from: AdobeLibraryDelegate.java */
/* renamed from: com.adobe.creativesdk.foundation.storage.vb, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0618vb {

    /* renamed from: a, reason: collision with root package name */
    public Handler f7450a = null;

    /* renamed from: b, reason: collision with root package name */
    public boolean f7451b = false;

    /* renamed from: c, reason: collision with root package name */
    public boolean f7452c = true;

    /* renamed from: d, reason: collision with root package name */
    public ArrayList<String> f7453d = null;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void a();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void a(AdobeNetworkReachability.AdobeNetworkStatusCode adobeNetworkStatusCode);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void a(C0614ub c0614ub);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void a(C0614ub c0614ub, AdobeCSDKException adobeCSDKException);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void a(C0614ub c0614ub, String str);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean a(String str);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract String b(String str);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void b();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void b(AdobeNetworkReachability.AdobeNetworkStatusCode adobeNetworkStatusCode);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void b(C0614ub c0614ub);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void b(C0614ub c0614ub, String str);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void c(C0614ub c0614ub, String str);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void c(String str);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void d(String str);
}
