package io.fabric.sdk.android.services.settings;

import android.content.res.Resources;
import com.nexstreaming.kinemaster.ui.settings.FragmentC2201x;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.network.HttpMethod;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.Closeable;
import java.io.InputStream;
import java.util.Collection;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AbstractAppSpiCall.java */
/* loaded from: classes3.dex */
public abstract class a extends io.fabric.sdk.android.services.common.a implements f {
    public a(io.fabric.sdk.android.l lVar, String str, String str2, io.fabric.sdk.android.services.network.f fVar, HttpMethod httpMethod) {
        super(lVar, str, str2, fVar, httpMethod);
    }

    private HttpRequest b(HttpRequest httpRequest, d dVar) {
        httpRequest.e("app[identifier]", dVar.f27003b);
        httpRequest.e("app[name]", dVar.f27007f);
        httpRequest.e("app[display_version]", dVar.f27004c);
        httpRequest.e("app[build_version]", dVar.f27005d);
        httpRequest.a("app[source]", Integer.valueOf(dVar.f27008g));
        httpRequest.e("app[minimum_sdk_version]", dVar.f27009h);
        httpRequest.e("app[built_sdk_version]", dVar.i);
        if (!CommonUtils.b(dVar.f27006e)) {
            httpRequest.e("app[instance_identifier]", dVar.f27006e);
        }
        if (dVar.j != null) {
            InputStream inputStream = null;
            try {
                try {
                    inputStream = this.kit.getContext().getResources().openRawResource(dVar.j.f27033b);
                    httpRequest.e("app[icon][hash]", dVar.j.f27032a);
                    httpRequest.a("app[icon][data]", "icon.png", "application/octet-stream", inputStream);
                    httpRequest.a("app[icon][width]", Integer.valueOf(dVar.j.f27034c));
                    httpRequest.a("app[icon][height]", Integer.valueOf(dVar.j.f27035d));
                } catch (Resources.NotFoundException e2) {
                    io.fabric.sdk.android.f.f().c("Fabric", "Failed to find app icon with resource ID: " + dVar.j.f27033b, e2);
                }
            } finally {
                CommonUtils.a((Closeable) inputStream, "Failed to close app icon InputStream.");
            }
        }
        Collection<io.fabric.sdk.android.n> collection = dVar.k;
        if (collection != null) {
            for (io.fabric.sdk.android.n nVar : collection) {
                httpRequest.e(b(nVar), nVar.c());
                httpRequest.e(a(nVar), nVar.a());
            }
        }
        return httpRequest;
    }

    public boolean a(d dVar) {
        HttpRequest httpRequest = getHttpRequest();
        a(httpRequest, dVar);
        b(httpRequest, dVar);
        io.fabric.sdk.android.f.f().d("Fabric", "Sending app info to " + getUrl());
        if (dVar.j != null) {
            io.fabric.sdk.android.f.f().d("Fabric", "App icon hash is " + dVar.j.f27032a);
            io.fabric.sdk.android.f.f().d("Fabric", "App icon size is " + dVar.j.f27034c + FragmentC2201x.f23219a + dVar.j.f27035d);
        }
        int g2 = httpRequest.g();
        String str = "POST".equals(httpRequest.k()) ? "Create" : "Update";
        io.fabric.sdk.android.f.f().d("Fabric", str + " app request ID: " + httpRequest.d(io.fabric.sdk.android.services.common.a.HEADER_REQUEST_ID));
        io.fabric.sdk.android.f.f().d("Fabric", "Result was " + g2);
        return io.fabric.sdk.android.services.common.x.a(g2) == 0;
    }

    private HttpRequest a(HttpRequest httpRequest, d dVar) {
        httpRequest.c(io.fabric.sdk.android.services.common.a.HEADER_API_KEY, dVar.f27002a);
        httpRequest.c(io.fabric.sdk.android.services.common.a.HEADER_CLIENT_TYPE, "android");
        httpRequest.c(io.fabric.sdk.android.services.common.a.HEADER_CLIENT_VERSION, this.kit.getVersion());
        return httpRequest;
    }

    String a(io.fabric.sdk.android.n nVar) {
        return String.format(Locale.US, "app[build][libraries][%s][type]", nVar.b());
    }

    String b(io.fabric.sdk.android.n nVar) {
        return String.format(Locale.US, "app[build][libraries][%s][version]", nVar.b());
    }
}
