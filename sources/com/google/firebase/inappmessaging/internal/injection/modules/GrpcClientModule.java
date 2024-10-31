package com.google.firebase.inappmessaging.internal.injection.modules;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import com.google.common.io.BaseEncoding;
import com.google.firebase.FirebaseApp;
import com.google.firebase.inappmessaging.internal.injection.scopes.FirebaseAppScope;
import com.google.internal.firebase.inappmessaging.v1.sdkserving.InAppMessagingSdkServingGrpc;
import io.grpc.AbstractC2407f;
import io.grpc.C2512m;
import io.grpc.P;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public class GrpcClientModule {

    /* renamed from: a */
    private final FirebaseApp f17949a;

    public GrpcClientModule(FirebaseApp firebaseApp) {
        this.f17949a = firebaseApp;
    }

    public P a() {
        P.e a2 = P.e.a("X-Goog-Api-Key", P.f27117b);
        P.e a3 = P.e.a("X-Android-Package", P.f27117b);
        P.e a4 = P.e.a("X-Android-Cert", P.f27117b);
        P p = new P();
        String packageName = this.f17949a.b().getPackageName();
        p.a((P.e<P.e>) a2, (P.e) this.f17949a.e().a());
        p.a((P.e<P.e>) a3, (P.e) packageName);
        String a5 = a(this.f17949a.b().getPackageManager(), packageName);
        if (a5 != null) {
            p.a((P.e<P.e>) a4, (P.e) a5);
        }
        return p;
    }

    public static String a(PackageManager packageManager, String str) {
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 64);
            if (packageInfo != null && packageInfo.signatures != null && packageInfo.signatures.length != 0 && packageInfo.signatures[0] != null) {
                return a(packageInfo.signatures[0]);
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return null;
    }

    private static String a(Signature signature) {
        try {
            return BaseEncoding.a().e().a(MessageDigest.getInstance("SHA1").digest(signature.toByteArray()));
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    @FirebaseAppScope
    public InAppMessagingSdkServingGrpc.InAppMessagingSdkServingBlockingStub a(AbstractC2407f abstractC2407f, P p) {
        return InAppMessagingSdkServingGrpc.a(C2512m.a(abstractC2407f, io.grpc.b.c.a(p)));
    }
}
