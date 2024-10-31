package com.nexstreaming.app.general.iab.a;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.RemoteException;
import android.preference.PreferenceManager;
import android.util.Log;
import com.nexstreaming.app.general.iab.BillingResponse;
import com.nexstreaming.app.general.iab.BuyResult;
import com.nexstreaming.app.general.iab.IABError;
import com.nexstreaming.app.general.iab.IABHelper;
import com.nexstreaming.app.general.iab.InAppPurchaseData;
import com.nexstreaming.app.general.iab.Purchase;
import com.nexstreaming.app.general.iab.SKUDetails;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.util.DiagnosticLogger;
import com.nexstreaming.app.general.util.SupportLogger;
import java.util.ArrayList;

/* compiled from: GoogleIABHelper.java */
/* loaded from: classes.dex */
public class a extends IABHelper {
    private com.a.a.a.a g;
    private ServiceConnection h;
    private Object i;
    private String j;
    private String k;
    private String l;
    private String[] m;
    private String[] n;
    private String[] o;
    private boolean p;

    public a(Context context, String str) {
        super(context, str);
        this.g = null;
        this.h = null;
        this.i = new Object();
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = new String[2];
        this.n = new String[2];
        this.o = new String[2];
        this.p = false;
    }

    @Override // com.nexstreaming.app.general.iab.IABHelper
    public String q() {
        return "Google Play";
    }

    @Override // com.nexstreaming.app.general.iab.IABHelper
    public String r() {
        return "Google";
    }

    @Override // com.nexstreaming.app.general.iab.IABHelper
    public void a(IABHelper.e eVar) {
        if (this.h == null) {
            this.h = new b(this, eVar);
        } else if (this.g != null) {
            eVar.a(true, 0);
        }
        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        intent.setPackage("com.android.vending");
        if (!k().bindService(intent, this.h, 1)) {
            DiagnosticLogger.a().a(DiagnosticLogger.Tag.IH_BIND_FAIL);
            eVar.a(false, -1);
        }
    }

    @Override // com.nexstreaming.app.general.iab.IABHelper
    public void b(IABHelper.e eVar) {
        k().startActivity(new Intent("android.settings.SYNC_SETTINGS"));
    }

    @Override // com.nexstreaming.app.general.iab.IABHelper
    public boolean b() {
        boolean z;
        synchronized (this.i) {
            z = com.nexstreaming.kinemaster.h.a.c(k()) && n() != null && ((n().get(IABHelper.SKUType.inapp) != null && n().get(IABHelper.SKUType.inapp).size() > 0) || (n().get(IABHelper.SKUType.subs) != null && n().get(IABHelper.SKUType.subs).size() > 0));
        }
        return z;
    }

    @Override // com.nexstreaming.app.general.iab.IABHelper
    public void a(IABHelper.d dVar) {
        com.nexstreaming.kinemaster.tracelog.d.c(k()).onResultAvailable(new g(this, dVar)).onFailure((Task.OnFailListener) new f(this, dVar));
    }

    /* compiled from: GoogleIABHelper.java */
    /* renamed from: com.nexstreaming.app.general.iab.a.a$1 */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a */
        static final /* synthetic */ int[] f3143a = new int[IABHelper.SKUType.values().length];

        static {
            try {
                f3143a[IABHelper.SKUType.subs.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f3143a[IABHelper.SKUType.inapp.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.nexstreaming.app.general.iab.IABHelper
    public void a(IABHelper.c cVar) {
        com.a.a.a.a aVar;
        Context k;
        synchronized (this.i) {
            aVar = this.g;
            k = k();
        }
        if (aVar == null || k == null) {
            SupportLogger.Event.IH_Service_Disconnected.log(1);
            DiagnosticLogger.a().a(DiagnosticLogger.Tag.IH_SCONN_DIS);
            cVar.b(IABError.StartupError, "Google Play service disconnected");
            return;
        }
        int i = f * 5 * 255;
        for (IABHelper.SKUType sKUType : new IABHelper.SKUType[]{IABHelper.SKUType.inapp, IABHelper.SKUType.subs}) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new ArrayList());
            arrayList.add(new ArrayList());
            arrayList.add(new ArrayList());
            arrayList.add(new ArrayList());
            arrayList.add(new ArrayList());
            arrayList.add(new ArrayList());
            arrayList.add(new ArrayList());
            arrayList.add(new ArrayList());
            IABHelper.f[] fVarArr = {new h(this, arrayList, i), new i(this, arrayList, i), new j(this, arrayList, i), new k(this, arrayList, i), new l(this, arrayList, i), new m(this, arrayList, i), new c(this, arrayList, i), new d(this, arrayList, i)};
            String str = null;
            do {
                try {
                    Bundle a2 = aVar.a(3, k.getPackageName(), sKUType.name(), str);
                    BillingResponse fromCode = BillingResponse.fromCode(a2.getInt("RESPONSE_CODE"));
                    if (fromCode != BillingResponse.OK) {
                        SupportLogger.Event.IH_ResponseCode.log(fromCode.getIntErrorCode());
                        cVar.b(IABError.PurchaseError, "error reponse code = " + fromCode + fromCode.name());
                        return;
                    }
                    ArrayList<String> stringArrayList = a2.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                    ArrayList<String> stringArrayList2 = a2.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                    ArrayList<String> stringArrayList3 = a2.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                    DiagnosticLogger.a().a(DiagnosticLogger.ParamTag.IH_LIST_SIZES, (Math.min(stringArrayList.size(), 9) * 1) + (Math.min(stringArrayList2.size(), 9) * 10) + (Math.min(stringArrayList3.size(), 9) * 100));
                    int size = stringArrayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        Purchase purchase = new Purchase();
                        String str2 = stringArrayList2.get(i2);
                        String str3 = stringArrayList3.get(i2);
                        f *= 6163;
                        int i3 = f & 7;
                        int a3 = a(str2, str3);
                        if (((f3141a ^ a3) & (-65536)) != -491454464) {
                            DiagnosticLogger.a().a(DiagnosticLogger.Tag.IH_VFY_SKIP);
                        } else {
                            purchase.a(stringArrayList.get(i2));
                            purchase.b(str3);
                            purchase.a(p());
                            purchase.a(a3);
                            purchase.a((InAppPurchaseData) l().fromJson(str2, InAppPurchaseData.class));
                            DiagnosticLogger.a().a(DiagnosticLogger.ParamTag.IH_VFY_CONT, i3);
                            fVarArr[i3].a(purchase, (a3 >> (i3 * 4)) & 15);
                        }
                    }
                    if (a2.containsKey("INAPP_CONTINUATION_TOKEN")) {
                        str = a2.getString("INAPP_CONTINUATION_TOKEN", null);
                    } else {
                        str = null;
                    }
                } catch (RemoteException e) {
                    SupportLogger.Event.IH_RemoteException.log(1);
                    cVar.b(IABError.RemoteServiceError, e.toString());
                    return;
                }
            } while (str != null);
            o().put(sKUType, arrayList.get(i & 7));
        }
        DiagnosticLogger.a().a(DiagnosticLogger.ParamTag.IH_GETP_SIZE, o().size());
        cVar.a(o());
        PreferenceManager.getDefaultSharedPreferences(k()).edit().putBoolean("giab_check_p", true).apply();
    }

    @Override // com.nexstreaming.app.general.iab.IABHelper
    public void a(SKUDetails sKUDetails, IABHelper.DeveloperPayLoad developerPayLoad, int i, IABHelper.a aVar) {
        com.a.a.a.a aVar2;
        Context k;
        if (!this.p) {
            this.p = true;
            synchronized (this.i) {
                aVar2 = this.g;
                k = k();
            }
            if (aVar2 == null || k == null) {
                SupportLogger.Event.IH_Service_Disconnected.log(2);
                aVar.a(false, null, IABError.StartupError + "service disconnected");
                return;
            }
            String a2 = sKUDetails.a();
            String b = sKUDetails.b();
            if (b.equals(IABHelper.SKUType.inapp.name()) && developerPayLoad.preSku != null && developerPayLoad.preSku.equals(sKUDetails.a())) {
                if (a2.equals(this.n[0])) {
                    a2 = this.n[1];
                } else if (a2.equals(this.m[0])) {
                    a2 = this.m[1];
                } else if (a2.equals(this.o[0])) {
                    a2 = this.o[1];
                } else if (a2.equals(this.n[1])) {
                    a2 = this.n[0];
                } else if (a2.equals(this.m[1])) {
                    a2 = this.m[0];
                } else if (a2.equals(this.o[1])) {
                    a2 = this.o[0];
                }
            }
            try {
                Bundle a3 = aVar2.a(3, k.getPackageName(), a2, b, l().toJson(developerPayLoad));
                BuyResult buyResult = new BuyResult();
                buyResult.a((PendingIntent) a3.getParcelable("BUY_INTENT"));
                buyResult.b(i);
                Log.i("GoogleIABHelper", "start buy info sku = " + sKUDetails.a());
                Log.i("GoogleIABHelper", "start buy info payload = " + developerPayLoad.toString());
                aVar.a(buyResult);
            } catch (RemoteException e) {
                SupportLogger.Event.IH_RemoteException.log(3);
                aVar.a(false, null, IABError.RemoteServiceError + e.toString());
            }
        }
    }

    public void g(SKUDetails sKUDetails) {
        switch (sKUDetails.j()) {
            case 1:
                this.l = sKUDetails.a();
                return;
            case 2:
                this.j = sKUDetails.a();
                return;
            case 3:
                this.k = sKUDetails.a();
                return;
            default:
                return;
        }
    }

    public void h(SKUDetails sKUDetails) {
        boolean c = c(sKUDetails);
        switch (sKUDetails.j()) {
            case 1:
                if (c) {
                    if (this.m[0] == null) {
                        this.m[0] = sKUDetails.a();
                        return;
                    } else {
                        this.m[1] = sKUDetails.a();
                        return;
                    }
                }
                this.l = sKUDetails.a();
                return;
            case 2:
                if (c) {
                    if (this.n[0] == null) {
                        this.n[0] = sKUDetails.a();
                        return;
                    } else {
                        this.n[1] = sKUDetails.a();
                        return;
                    }
                }
                this.j = sKUDetails.a();
                return;
            case 3:
                if (c) {
                    if (this.o[0] == null) {
                        this.o[0] = sKUDetails.a();
                        return;
                    } else {
                        this.o[1] = sKUDetails.a();
                        return;
                    }
                }
                this.k = sKUDetails.a();
                return;
            default:
                return;
        }
    }

    @Override // com.nexstreaming.app.general.iab.IABHelper
    public void a(SKUDetails sKUDetails, Purchase purchase, IABHelper.b bVar) {
        com.a.a.a.a aVar;
        Context k;
        synchronized (this.i) {
            aVar = this.g;
            k = k();
        }
        if (aVar == null || k == null) {
            SupportLogger.Event.IH_Service_Disconnected.log(3);
            bVar.a(IABError.StartupError, "service disconnected");
            return;
        }
        try {
            BillingResponse fromCode = BillingResponse.fromCode(aVar.b(3, purchase.b(), purchase.d()));
            if (fromCode != BillingResponse.OK) {
                bVar.a(IABError.ConsumeError, "consume error code " + fromCode + fromCode.name());
            } else {
                bVar.a(sKUDetails, purchase);
            }
        } catch (RemoteException e) {
            SupportLogger.Event.IH_RemoteException.log(2);
            bVar.a(IABError.ConsumeError, e.toString());
        }
    }

    @Override // com.nexstreaming.app.general.iab.IABHelper
    public void a() {
        synchronized (this.i) {
            if (this.h != null && k() != null) {
                k().unbindService(this.h);
            }
        }
    }

    @Override // com.nexstreaming.app.general.iab.IABHelper
    public String c() {
        return this.l;
    }

    @Override // com.nexstreaming.app.general.iab.IABHelper
    public String d() {
        return this.j;
    }

    @Override // com.nexstreaming.app.general.iab.IABHelper
    public String e() {
        return this.k;
    }

    @Override // com.nexstreaming.app.general.iab.IABHelper
    public String f() {
        return this.m[0];
    }

    @Override // com.nexstreaming.app.general.iab.IABHelper
    public String g() {
        return this.n[0];
    }

    @Override // com.nexstreaming.app.general.iab.IABHelper
    public String h() {
        return this.o[0];
    }

    @Override // com.nexstreaming.app.general.iab.IABHelper
    protected void a(Purchase purchase, IABHelper.DeveloperPayLoad developerPayLoad) {
        String str;
        if (purchase != null && developerPayLoad != null && (str = developerPayLoad.preSku) != null) {
            for (Purchase purchase2 : o().get(IABHelper.SKUType.inapp)) {
                if (purchase2.a().equals(str)) {
                    a((SKUDetails) null, purchase2, new e(this));
                }
            }
        }
    }

    @Override // com.nexstreaming.app.general.iab.IABHelper
    public Purchase a(int i, int i2, Intent intent, Task.TaskError[] taskErrorArr) {
        Purchase a2 = super.a(i, i2, intent, taskErrorArr);
        this.p = false;
        return a2;
    }

    @Override // com.nexstreaming.app.general.iab.IABHelper
    public boolean u() {
        return PreferenceManager.getDefaultSharedPreferences(k()).getBoolean("giab_check_p", false);
    }
}
