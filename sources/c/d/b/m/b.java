package c.d.b.m;

import android.content.Context;
import com.nexstreaming.app.general.iab.PurchaseType;
import com.nexstreaming.kinemaster.network.InterfaceC1821j;
import com.nextreaming.nexeditorui.I;
import java.util.Iterator;

/* compiled from: BrowserUtil.java */
/* loaded from: classes2.dex */
public class b {
    public static boolean a(PurchaseType purchaseType, com.nexstreaming.app.general.nexasset.assetpackage.b bVar, Context context) {
        if (bVar.getPriceType() == null || bVar.getPriceType().equalsIgnoreCase("Free")) {
            return true;
        }
        if (bVar.getPriceType().equalsIgnoreCase("Premium")) {
            return purchaseType.isActivePurchaseOrPromocode();
        }
        if (bVar.getPriceType().equalsIgnoreCase("Paid")) {
            return a(bVar, context);
        }
        return false;
    }

    public static boolean a(com.nexstreaming.app.general.nexasset.assetpackage.b bVar, Context context) {
        Iterator<InterfaceC1821j> it = ((I) context).y().p().iterator();
        while (it.hasNext()) {
            if (bVar.getAssetId().equalsIgnoreCase(it.next().getAssetId())) {
                return true;
            }
        }
        return false;
    }
}
