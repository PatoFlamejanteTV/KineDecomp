package com.tencent.mm.sdk.a.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.constants.ConstantsAPI;

/* loaded from: classes3.dex */
public final class a {

    /* renamed from: com.tencent.mm.sdk.a.a.a$a */
    /* loaded from: classes3.dex */
    public static class C0134a {
        public String j;
        public Bundle k;
        public String l;
        public String m;
    }

    public static boolean a(Context context, C0134a c0134a) {
        String str;
        if (context == null || c0134a == null) {
            str = "send fail, invalid argument";
        } else {
            if (!c.a(c0134a.m)) {
                String str2 = null;
                if (!c.a(c0134a.l)) {
                    str2 = c0134a.l + ".permission.MM_MESSAGE";
                }
                Intent intent = new Intent(c0134a.m);
                Bundle bundle = c0134a.k;
                if (bundle != null) {
                    intent.putExtras(bundle);
                }
                String packageName = context.getPackageName();
                intent.putExtra(ConstantsAPI.SDK_VERSION, 570425345);
                intent.putExtra(ConstantsAPI.APP_PACKAGE, packageName);
                intent.putExtra(ConstantsAPI.CONTENT, c0134a.j);
                intent.putExtra(ConstantsAPI.CHECK_SUM, b.a(c0134a.j, 570425345, packageName));
                context.sendBroadcast(intent, str2);
                com.tencent.mm.sdk.b.a.c("MicroMsg.SDK.MMessage", "send mm message, intent=" + intent + ", perm=" + str2);
                return true;
            }
            str = "send fail, action is null";
        }
        com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.MMessage", str);
        return false;
    }
}
