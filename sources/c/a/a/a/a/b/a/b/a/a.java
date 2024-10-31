package c.a.a.a.a.b.a.b.a;

import c.a.a.a.a.b.a.c.g;
import com.adobe.creativesdk.foundation.adobeinternal.storage.aclibmanager.core.f;
import com.adobe.creativesdk.foundation.storage.C0614ub;
import com.adobe.creativesdk.foundation.storage.C0622wb;
import com.adobe.creativesdk.foundation.storage.C0630yb;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: ACLMDefaultAssetsListProvider.java */
/* loaded from: classes.dex */
public class a implements f {

    /* renamed from: a */
    private C0630yb f3436a;

    /* renamed from: b */
    private String[] f3437b;

    public void a(String[] strArr) {
        this.f3436a = new C0630yb();
        this.f3436a.a(true);
        this.f3436a.a(new ArrayList(Arrays.asList(strArr)));
    }

    public void b(String[] strArr) {
        this.f3437b = strArr;
    }

    public void a(String str) {
        C0630yb c0630yb = this.f3436a;
        if (c0630yb != null) {
            c0630yb.b(str);
        }
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.storage.aclibmanager.core.f
    public ArrayList<C0622wb> a(C0614ub c0614ub) {
        ArrayList<C0622wb> arrayList;
        if (c0614ub != null) {
            C0630yb c0630yb = this.f3436a;
            if (c0630yb != null) {
                arrayList = g.a(c0614ub, c0630yb);
            } else {
                arrayList = g.a(c0614ub, this.f3437b);
            }
        } else {
            arrayList = null;
        }
        return arrayList == null ? new ArrayList<>() : arrayList;
    }
}
