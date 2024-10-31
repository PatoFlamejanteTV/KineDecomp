package com.tencent.mm.sdk.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.sdk.a.a.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.constants.ConstantsAPI;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: com.tencent.mm.sdk.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0086a {
        public int flags = -1;
        public String h;
        public String i;
        public String j;
        public Bundle k;
    }

    public static boolean a(Context context, C0086a c0086a) {
        if (context == null || c0086a == null) {
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.MMessageAct", "send fail, invalid argument");
            return false;
        }
        if (c.a(c0086a.h)) {
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.MMessageAct", "send fail, invalid targetPkgName, targetPkgName = " + c0086a.h);
            return false;
        }
        if (c.a(c0086a.i)) {
            c0086a.i = c0086a.h + ".wxapi.WXEntryActivity";
        }
        com.tencent.mm.sdk.b.a.c("MicroMsg.SDK.MMessageAct", "send, targetPkgName = " + c0086a.h + ", targetClassName = " + c0086a.i);
        Intent intent = new Intent();
        intent.setClassName(c0086a.h, c0086a.i);
        if (c0086a.k != null) {
            intent.putExtras(c0086a.k);
        }
        String packageName = context.getPackageName();
        intent.putExtra(ConstantsAPI.SDK_VERSION, 570425345);
        intent.putExtra(ConstantsAPI.APP_PACKAGE, packageName);
        intent.putExtra(ConstantsAPI.CONTENT, c0086a.j);
        intent.putExtra(ConstantsAPI.CHECK_SUM, b.a(c0086a.j, 570425345, packageName));
        if (c0086a.flags == -1) {
            intent.addFlags(268435456).addFlags(134217728);
        } else {
            intent.setFlags(c0086a.flags);
        }
        try {
            context.startActivity(intent);
            com.tencent.mm.sdk.b.a.c("MicroMsg.SDK.MMessageAct", "send mm message, intent=" + intent);
            return true;
        } catch (Exception e) {
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.MMessageAct", "send fail, ex = %s", e.getMessage());
            return false;
        }
    }
}
