package com.mixpanel.android.mpmetrics;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Build;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.mixpanel.android.mpmetrics.InAppNotification;
import com.mixpanel.android.util.ImageStore;
import com.mixpanel.android.util.RemoteService;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.keyczar.Keyczar;

/* loaded from: classes.dex */
class DecideChecker {
    private static final JSONArray e = new JSONArray();

    /* renamed from: a, reason: collision with root package name */
    private final m f3000a;
    private final Context b;
    private final List<f> c = new LinkedList();
    private final ImageStore d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final List<Survey> f3001a = new ArrayList();
        public final List<InAppNotification> b = new ArrayList();
        public JSONArray c = DecideChecker.e;
        public JSONArray d = DecideChecker.e;
    }

    public DecideChecker(Context context, m mVar) {
        this.b = context;
        this.f3000a = mVar;
        this.d = a(context);
    }

    protected ImageStore a(Context context) {
        return new ImageStore(context, "DecideChecker");
    }

    public void a(f fVar) {
        this.c.add(fVar);
    }

    public void a(RemoteService remoteService) throws RemoteService.ServiceUnavailableException {
        for (f fVar : this.c) {
            try {
                a a2 = a(fVar.a(), fVar.b(), remoteService);
                fVar.a(a2.f3001a, a2.b, a2.c, a2.d);
            } catch (UnintelligibleMessageException e2) {
                Log.e("MixpanelAPI.DChecker", e2.getMessage(), e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class UnintelligibleMessageException extends Exception {
        private static final long serialVersionUID = -6501269367559104957L;

        public UnintelligibleMessageException(String str, JSONException jSONException) {
            super(str, jSONException);
        }
    }

    private a a(String str, String str2, RemoteService remoteService) throws RemoteService.ServiceUnavailableException, UnintelligibleMessageException {
        String b = b(str, str2, remoteService);
        if (m.f3036a) {
            Log.v("MixpanelAPI.DChecker", "Mixpanel decide server response was:\n" + b);
        }
        a a2 = b != null ? a(b) : new a();
        Iterator<InAppNotification> it = a2.b.iterator();
        while (it.hasNext()) {
            InAppNotification next = it.next();
            Bitmap a3 = a(next, this.b, remoteService);
            if (a3 == null) {
                Log.i("MixpanelAPI.DChecker", "Could not retrieve image for notification " + next.b() + ", will not show the notification.");
                it.remove();
            } else {
                next.a(a3);
            }
        }
        return a2;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x015f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x014f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ae A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static com.mixpanel.android.mpmetrics.DecideChecker.a a(java.lang.String r9) throws com.mixpanel.android.mpmetrics.DecideChecker.UnintelligibleMessageException {
        /*
            Method dump skipped, instructions count: 412
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.mpmetrics.DecideChecker.a(java.lang.String):com.mixpanel.android.mpmetrics.DecideChecker$a");
    }

    private String b(String str, String str2, RemoteService remoteService) throws RemoteService.ServiceUnavailableException {
        String[] strArr;
        try {
            String encode = URLEncoder.encode(str, "utf-8");
            String encode2 = str2 != null ? URLEncoder.encode(str2, "utf-8") : null;
            StringBuilder append = new StringBuilder().append("?version=1&lib=android&token=").append(encode);
            if (encode2 != null) {
                append.append("&distinct_id=").append(encode2);
            }
            String sb = append.toString();
            if (this.f3000a.e()) {
                strArr = new String[]{this.f3000a.m() + sb};
            } else {
                strArr = new String[]{this.f3000a.m() + sb, this.f3000a.p() + sb};
            }
            if (m.f3036a) {
                Log.v("MixpanelAPI.DChecker", "Querying decide server, urls:");
                for (String str3 : strArr) {
                    Log.v("MixpanelAPI.DChecker", "    >> " + str3);
                }
            }
            byte[] a2 = a(remoteService, this.b, strArr);
            if (a2 == null) {
                return null;
            }
            try {
                return new String(a2, Keyczar.DEFAULT_ENCODING);
            } catch (UnsupportedEncodingException e2) {
                throw new RuntimeException("UTF not supported on this platform?", e2);
            }
        } catch (UnsupportedEncodingException e3) {
            throw new RuntimeException("Mixpanel library requires utf-8 string encoding to be available", e3);
        }
    }

    private Bitmap a(InAppNotification inAppNotification, Context context, RemoteService remoteService) throws RemoteService.ServiceUnavailableException {
        String[] strArr = (inAppNotification.d() != InAppNotification.Type.TAKEOVER || a(((WindowManager) context.getSystemService("window")).getDefaultDisplay()) < 720) ? new String[]{inAppNotification.h(), inAppNotification.g()} : new String[]{inAppNotification.i(), inAppNotification.h(), inAppNotification.g()};
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            String str = strArr[i];
            try {
                return this.d.a(str);
            } catch (ImageStore.CantGetImageException e2) {
                Log.v("MixpanelAPI.DChecker", "Can't load image " + str + " for a notification", e2);
            }
        }
        return null;
    }

    @SuppressLint({"NewApi"})
    private static int a(Display display) {
        if (Build.VERSION.SDK_INT < 13) {
            return display.getWidth();
        }
        Point point = new Point();
        display.getSize(point);
        return point.x;
    }

    private static byte[] a(RemoteService remoteService, Context context, String[] strArr) throws RemoteService.ServiceUnavailableException {
        byte[] bArr = null;
        if (remoteService.a(context)) {
            for (String str : strArr) {
                try {
                    bArr = remoteService.a(str, null, m.a(context).u());
                    break;
                } catch (FileNotFoundException e2) {
                    if (m.f3036a) {
                        Log.v("MixpanelAPI.DChecker", "Cannot get " + str + ", file not found.", e2);
                    }
                } catch (IOException e3) {
                    if (m.f3036a) {
                        Log.v("MixpanelAPI.DChecker", "Cannot get " + str + ".", e3);
                    }
                } catch (OutOfMemoryError e4) {
                    Log.e("MixpanelAPI.DChecker", "Out of memory when getting to " + str + ".", e4);
                } catch (MalformedURLException e5) {
                    Log.e("MixpanelAPI.DChecker", "Cannot interpret " + str + " as a URL.", e5);
                }
            }
        }
        return bArr;
    }
}
