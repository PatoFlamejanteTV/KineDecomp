package com.tencent.mm.sdk.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.sdk.a.a.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.constants.ConstantsAPI;

/* loaded from: classes3.dex */
public final class a {

    /* renamed from: com.tencent.mm.sdk.a.a$a */
    /* loaded from: classes3.dex */
    public static class C0133a {
        public int flags = -1;

        /* renamed from: h */
        public String f25760h;
        public String i;
        public String j;
        public Bundle k;
    }

    public static boolean a(Context context, C0133a c0133a) {
        if (context == null || c0133a == null) {
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.MMessageAct", "send fail, invalid argument");
            return false;
        }
        if (c.a(c0133a.f25760h)) {
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.MMessageAct", "send fail, invalid targetPkgName, targetPkgName = " + c0133a.f25760h);
            return false;
        }
        if (c.a(c0133a.i)) {
            c0133a.i = c0133a.f25760h + ".wxapi.WXEntryActivity";
        }
        com.tencent.mm.sdk.b.a.c("MicroMsg.SDK.MMessageAct", "send, targetPkgName = " + c0133a.f25760h + ", targetClassName = " + c0133a.i);
        Intent intent = new Intent();
        intent.setClassName(c0133a.f25760h, c0133a.i);
        Bundle bundle = c0133a.k;
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        String packageName = context.getPackageName();
        intent.putExtra(ConstantsAPI.SDK_VERSION, 570425345);
        intent.putExtra(ConstantsAPI.APP_PACKAGE, packageName);
        intent.putExtra(ConstantsAPI.CONTENT, c0133a.j);
        intent.putExtra(ConstantsAPI.CHECK_SUM, b.a(c0133a.j, 570425345, packageName));
        int i = c0133a.flags;
        if (i == -1) {
            intent.addFlags(268435456).addFlags(134217728);
        } else {
            intent.setFlags(i);
        }
        try {
            context.startActivity(intent);
            com.tencent.mm.sdk.b.a.c("MicroMsg.SDK.MMessageAct", "send mm message, intent=" + intent);
            return true;
        } catch (Exception e2) {
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.MMessageAct", "send fail, ex = %s", e2.getMessage());
            return false;
        }
    }
}
