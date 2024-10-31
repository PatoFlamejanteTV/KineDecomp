package com.nexstreaming.kinemaster.network;

import com.android.volley.m;
import com.nexstreaming.app.general.task.ResultTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VolleyNetworkService.java */
/* loaded from: classes.dex */
public class J implements m.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f21103a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Object f21104b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ ResultTask f21105c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public J(String str, Object obj, ResultTask resultTask) {
        this.f21103a = str;
        this.f21104b = obj;
        this.f21105c = resultTask;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x001e, code lost:            if (r0 > 0) goto L12;     */
    @Override // com.android.volley.m.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.android.volley.VolleyError r5) {
        /*
            r4 = this;
            com.android.volley.j r0 = r5.networkResponse
            if (r0 == 0) goto L29
            int r0 = com.nexstreaming.kinemaster.network.VolleyNetworkService.d.b(r0)
            com.android.volley.j r1 = r5.networkResponse
            int r1 = r1.f8070a
            com.nexstreaming.kinemaster.network.VolleyNetworkService.b(r1)
            r2 = 500(0x1f4, float:7.0E-43)
            if (r1 < r2) goto L21
            com.android.volley.j r1 = r5.networkResponse
            int r1 = r1.f8070a
            com.nexstreaming.kinemaster.network.VolleyNetworkService.b(r1)
            r2 = 600(0x258, float:8.41E-43)
            if (r1 >= r2) goto L21
            if (r0 <= 0) goto L21
            goto L2a
        L21:
            com.android.volley.j r0 = r5.networkResponse
            int r0 = r0.f8070a
            com.nexstreaming.kinemaster.network.VolleyNetworkService.b(r0)
            goto L2a
        L29:
            r0 = 0
        L2a:
            r1 = 503(0x1f7, float:7.05E-43)
            if (r0 == r1) goto La2
            r1 = 505(0x1f9, float:7.08E-43)
            if (r0 != r1) goto L34
            goto La2
        L34:
            r1 = 511(0x1ff, float:7.16E-43)
            if (r0 != r1) goto L40
            com.nexstreaming.app.general.task.ResultTask r5 = r4.f21105c
            com.nexstreaming.kinemaster.network.SessionError r0 = com.nexstreaming.kinemaster.network.SessionError.SERVER_MAINTENANCE
            r5.sendFailure(r0)
            goto La9
        L40:
            r1 = 512(0x200, float:7.17E-43)
            if (r0 != r1) goto L4c
            com.nexstreaming.app.general.task.ResultTask r5 = r4.f21105c
            com.nexstreaming.kinemaster.network.SessionError r0 = com.nexstreaming.kinemaster.network.SessionError.APP_UPDATE_REQUIRED_BY_SERVER
            r5.sendFailure(r0)
            goto La9
        L4c:
            java.lang.String r1 = r5.getMessage()
            if (r1 == 0) goto L5d
            java.lang.String r2 = r1.trim()
            int r2 = r2.length()
            r3 = 1
            if (r2 >= r3) goto L98
        L5d:
            com.android.volley.j r1 = r5.networkResponse
            if (r1 == 0) goto L90
            r1 = 200(0xc8, float:2.8E-43)
            if (r0 == r1) goto L87
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.Class r2 = r5.getClass()
            java.lang.String r2 = r2.getSimpleName()
            r1.append(r2)
            java.lang.String r2 = " ("
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = ")"
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            goto L98
        L87:
            java.lang.Class r0 = r5.getClass()
            java.lang.String r1 = r0.getSimpleName()
            goto L98
        L90:
            java.lang.Class r0 = r5.getClass()
            java.lang.String r1 = r0.getSimpleName()
        L98:
            com.nexstreaming.app.general.task.ResultTask r0 = r4.f21105c
            com.nexstreaming.app.general.task.Task$TaskError r5 = com.nexstreaming.app.general.task.Task.makeTaskError(r1, r5)
            r0.sendFailure(r5)
            goto La9
        La2:
            com.nexstreaming.app.general.task.ResultTask r5 = r4.f21105c
            com.nexstreaming.kinemaster.network.SessionError r0 = com.nexstreaming.kinemaster.network.SessionError.TOKEN_EXPIRED
            r5.sendFailure(r0)
        La9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.kinemaster.network.J.a(com.android.volley.VolleyError):void");
    }
}
