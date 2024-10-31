package c.a.a.a.c.d;

import com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloudEndpoint;
import com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloudServiceType;
import com.adobe.creativesdk.foundation.adobeinternal.cloud.g;
import com.adobe.creativesdk.foundation.internal.auth.AdobeAuthIdentityManagementService;
import com.adobe.creativesdk.foundation.internal.notification.AdobeInternalNotificationID;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.adobe.creativesdk.foundation.internal.utils.logging.c;
import java.net.MalformedURLException;
import java.net.URL;

/* compiled from: AdobeNotificationSession.java */
/* loaded from: classes.dex */
public class b extends g {
    public b(AdobeCloudEndpoint adobeCloudEndpoint) {
        super(adobeCloudEndpoint);
        g();
        a(AdobeInternalNotificationID.AdobeNotificationServiceDisconnectedNotification);
        a(15L, false);
    }

    public static g b(AdobeCloudEndpoint adobeCloudEndpoint) {
        if (adobeCloudEndpoint == null) {
            adobeCloudEndpoint = k();
        }
        return new b(adobeCloudEndpoint);
    }

    protected static AdobeCloudEndpoint k() {
        String str;
        int i = a.f3457a[AdobeAuthIdentityManagementService.K().w().ordinal()];
        if (i == 1) {
            str = "https://ans.adobe.io/ans/v1/notifications";
        } else if (i == 2 || i == 3) {
            str = "https://stg-ans.adobe.io/ans/v1/notifications";
        } else {
            c.a(Level.ERROR, b.class.getSimpleName(), "An undefined authentication endpoint has been specified.");
            str = null;
        }
        try {
            return new AdobeCloudEndpoint(null, str != null ? new URL(str) : null, AdobeCloudServiceType.AdobeCloudServiceTypeNotification);
        } catch (MalformedURLException unused) {
            return null;
        }
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.cloud.g
    public void g() {
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.cloud.g
    public void i() {
        super.i();
    }
}
