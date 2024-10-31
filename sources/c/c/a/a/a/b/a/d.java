package c.c.a.a.a.b.a;

import android.text.TextUtils;
import android.util.Log;
import com.kinemaster.module.network.kinemaster.error.ServiceError;
import com.kinemaster.module.network.kinemaster.service.auth.error.AuthServiceException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.B;
import okhttp3.F;
import okhttp3.I;
import okhttp3.L;
import okhttp3.M;
import okhttp3.x;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AuthInterceptor.java */
/* loaded from: classes2.dex */
public class d implements B {

    /* renamed from: a, reason: collision with root package name */
    private e f3515a;

    d(e eVar) {
        this.f3515a = eVar;
    }

    public static F b(e eVar) {
        F.a aVar = new F.a();
        aVar.b(5L, TimeUnit.SECONDS);
        aVar.a(5L, TimeUnit.SECONDS);
        aVar.a(new d(eVar));
        return aVar.a();
    }

    @Override // okhttp3.B
    public M a(B.a aVar) throws IOException {
        if (!TextUtils.isEmpty(this.f3515a.a())) {
            return aVar.a(a(aVar.a(), "access_token", this.f3515a.a()));
        }
        throw new AuthServiceException(ServiceError.EMPTY_TOKEN_ERROR, null);
    }

    private L b(L l, String str, String str2) {
        x.a aVar = new x.a();
        aVar.a(str, str2);
        x a2 = aVar.a();
        String a3 = a(l);
        StringBuilder sb = new StringBuilder();
        sb.append(a3);
        sb.append(a3.length() > 0 ? "&" : "");
        sb.append(a(a2));
        return L.a(l.b(), sb.toString());
    }

    public static F a(e eVar) {
        F.a aVar = new F.a();
        aVar.a(new d(eVar));
        return aVar.a();
    }

    private I a(I i, String str, String str2) {
        L a2 = i.a();
        String b2 = a2.b().b();
        if (b2.contains("json")) {
            a2 = a(a2, str, str2);
        } else if (b2.contains("form")) {
            a2 = b(a2, str, str2);
        }
        if (a2 != null) {
            I.a f2 = i.f();
            f2.a(a2);
            i = f2.a();
        }
        Log.d("jason", "requestBody: " + a(i.a()));
        return i;
    }

    private String a(L l) {
        try {
            okio.g gVar = new okio.g();
            if (l == null) {
                return "";
            }
            l.a(gVar);
            return gVar.s();
        } catch (IOException unused) {
            return "did not work";
        }
    }

    private L a(L l, String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(a(l));
            jSONObject.put(str, str2);
            return L.a(l.b(), jSONObject.toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
