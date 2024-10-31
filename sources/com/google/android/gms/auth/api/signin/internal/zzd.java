package com.google.android.gms.auth.api.signin.internal;

import com.facebook.stetho.server.http.HttpHeaders;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.StatusPendingResult;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* loaded from: classes.dex */
public final class zzd implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private static final Logger f10603a = new Logger("RevokeAccessOperation", new String[0]);

    /* renamed from: b, reason: collision with root package name */
    private final String f10604b;

    /* renamed from: c, reason: collision with root package name */
    private final StatusPendingResult f10605c;

    private zzd(String str) {
        Preconditions.b(str);
        this.f10604b = str;
        this.f10605c = new StatusPendingResult(null);
    }

    public static PendingResult<Status> a(String str) {
        if (str == null) {
            return PendingResults.a(new Status(4), (GoogleApiClient) null);
        }
        zzd zzdVar = new zzd(str);
        new Thread(zzdVar).start();
        return zzdVar.f10605c;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Status status = Status.f10706c;
        try {
            String valueOf = String.valueOf(this.f10604b);
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(valueOf.length() != 0 ? "https://accounts.google.com/o/oauth2/revoke?token=".concat(valueOf) : new String("https://accounts.google.com/o/oauth2/revoke?token=")).openConnection();
            httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded");
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                status = Status.f10704a;
            } else {
                f10603a.b("Unable to revoke access!", new Object[0]);
            }
            Logger logger = f10603a;
            StringBuilder sb = new StringBuilder(26);
            sb.append("Response Code: ");
            sb.append(responseCode);
            logger.a(sb.toString(), new Object[0]);
        } catch (IOException e2) {
            Logger logger2 = f10603a;
            String valueOf2 = String.valueOf(e2.toString());
            logger2.b(valueOf2.length() != 0 ? "IOException when revoking access: ".concat(valueOf2) : new String("IOException when revoking access: "), new Object[0]);
        } catch (Exception e3) {
            Logger logger3 = f10603a;
            String valueOf3 = String.valueOf(e3.toString());
            logger3.b(valueOf3.length() != 0 ? "Exception when revoking access: ".concat(valueOf3) : new String("Exception when revoking access: "), new Object[0]);
        }
        this.f10605c.a((StatusPendingResult) status);
    }
}
