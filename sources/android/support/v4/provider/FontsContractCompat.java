package android.support.v4.provider;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;
import android.provider.BaseColumns;
import android.support.v4.content.res.FontResourcesParserCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.graphics.TypefaceCompat;
import android.support.v4.graphics.TypefaceCompatUtil;
import android.support.v4.provider.SelfDestructiveThread;
import android.support.v4.util.LruCache;
import android.support.v4.util.Preconditions;
import android.support.v4.util.SimpleArrayMap;
import io.fabric.sdk.android.services.common.a;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public class FontsContractCompat {
    public static final String PARCEL_FONT_RESULTS = "font_results";

    /* renamed from: a */
    private static final LruCache<String, Typeface> f1600a = new LruCache<>(16);

    /* renamed from: b */
    private static final SelfDestructiveThread f1601b = new SelfDestructiveThread("fonts", 10, a.DEFAULT_TIMEOUT);

    /* renamed from: c */
    private static final Object f1602c = new Object();

    /* renamed from: d */
    private static final SimpleArrayMap<String, ArrayList<SelfDestructiveThread.ReplyCallback<TypefaceResult>>> f1603d = new SimpleArrayMap<>();

    /* renamed from: e */
    private static final Comparator<byte[]> f1604e = new Comparator<byte[]>() { // from class: android.support.v4.provider.FontsContractCompat.5
        AnonymousClass5() {
        }

        @Override // java.util.Comparator
        public int compare(byte[] bArr, byte[] bArr2) {
            int i;
            int i2;
            if (bArr.length != bArr2.length) {
                i = bArr.length;
                i2 = bArr2.length;
            } else {
                for (int i3 = 0; i3 < bArr.length; i3++) {
                    if (bArr[i3] != bArr2[i3]) {
                        i = bArr[i3];
                        i2 = bArr2[i3];
                    }
                }
                return 0;
            }
            return i - i2;
        }
    };

    /* renamed from: android.support.v4.provider.FontsContractCompat$1 */
    /* loaded from: classes.dex */
    public static class AnonymousClass1 implements Callable<TypefaceResult> {

        /* renamed from: a */
        final /* synthetic */ Context f1605a;

        /* renamed from: b */
        final /* synthetic */ FontRequest f1606b;

        /* renamed from: c */
        final /* synthetic */ int f1607c;

        /* renamed from: d */
        final /* synthetic */ String f1608d;

        AnonymousClass1(Context context, FontRequest fontRequest, int i, String str) {
            context = context;
            fontRequest = fontRequest;
            i2 = i;
            str = str;
        }

        @Override // java.util.concurrent.Callable
        public TypefaceResult call() throws Exception {
            TypefaceResult b2 = FontsContractCompat.b(context, fontRequest, i2);
            if (b2.f1634a != null) {
                FontsContractCompat.f1600a.put(str, b2.f1634a);
            }
            return b2;
        }
    }

    /* renamed from: android.support.v4.provider.FontsContractCompat$2 */
    /* loaded from: classes.dex */
    public static class AnonymousClass2 implements SelfDestructiveThread.ReplyCallback<TypefaceResult> {

        /* renamed from: b */
        final /* synthetic */ Handler f1610b;

        AnonymousClass2(Handler handler) {
            handler = handler;
        }

        @Override // android.support.v4.provider.SelfDestructiveThread.ReplyCallback
        public void onReply(TypefaceResult typefaceResult) {
            if (typefaceResult == null) {
                ResourcesCompat.FontCallback.this.callbackFailAsync(1, handler);
                return;
            }
            int i = typefaceResult.f1635b;
            if (i == 0) {
                ResourcesCompat.FontCallback.this.callbackSuccessAsync(typefaceResult.f1634a, handler);
            } else {
                ResourcesCompat.FontCallback.this.callbackFailAsync(i, handler);
            }
        }
    }

    /* renamed from: android.support.v4.provider.FontsContractCompat$3 */
    /* loaded from: classes.dex */
    public static class AnonymousClass3 implements SelfDestructiveThread.ReplyCallback<TypefaceResult> {

        /* renamed from: a */
        final /* synthetic */ String f1611a;

        AnonymousClass3(String str) {
            str = str;
        }

        @Override // android.support.v4.provider.SelfDestructiveThread.ReplyCallback
        public void onReply(TypefaceResult typefaceResult) {
            synchronized (FontsContractCompat.f1602c) {
                ArrayList arrayList = (ArrayList) FontsContractCompat.f1603d.get(str);
                if (arrayList == null) {
                    return;
                }
                FontsContractCompat.f1603d.remove(str);
                for (int i = 0; i < arrayList.size(); i++) {
                    ((SelfDestructiveThread.ReplyCallback) arrayList.get(i)).onReply(typefaceResult);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: android.support.v4.provider.FontsContractCompat$4 */
    /* loaded from: classes.dex */
    public static class AnonymousClass4 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f1612a;

        /* renamed from: b */
        final /* synthetic */ FontRequest f1613b;

        /* renamed from: c */
        final /* synthetic */ Handler f1614c;

        /* renamed from: d */
        final /* synthetic */ FontRequestCallback f1615d;

        /* renamed from: android.support.v4.provider.FontsContractCompat$4$1 */
        /* loaded from: classes.dex */
        class AnonymousClass1 implements Runnable {
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                fontRequestCallback.onTypefaceRequestFailed(-1);
            }
        }

        /* renamed from: android.support.v4.provider.FontsContractCompat$4$2 */
        /* loaded from: classes.dex */
        class AnonymousClass2 implements Runnable {
            AnonymousClass2() {
            }

            @Override // java.lang.Runnable
            public void run() {
                fontRequestCallback.onTypefaceRequestFailed(-2);
            }
        }

        /* renamed from: android.support.v4.provider.FontsContractCompat$4$3 */
        /* loaded from: classes.dex */
        class AnonymousClass3 implements Runnable {
            AnonymousClass3() {
            }

            @Override // java.lang.Runnable
            public void run() {
                fontRequestCallback.onTypefaceRequestFailed(-3);
            }
        }

        /* renamed from: android.support.v4.provider.FontsContractCompat$4$4 */
        /* loaded from: classes.dex */
        class RunnableC00044 implements Runnable {
            RunnableC00044() {
            }

            @Override // java.lang.Runnable
            public void run() {
                fontRequestCallback.onTypefaceRequestFailed(-3);
            }
        }

        /* renamed from: android.support.v4.provider.FontsContractCompat$4$5 */
        /* loaded from: classes.dex */
        class AnonymousClass5 implements Runnable {
            AnonymousClass5() {
            }

            @Override // java.lang.Runnable
            public void run() {
                fontRequestCallback.onTypefaceRequestFailed(1);
            }
        }

        /* renamed from: android.support.v4.provider.FontsContractCompat$4$6 */
        /* loaded from: classes.dex */
        class AnonymousClass6 implements Runnable {
            AnonymousClass6() {
            }

            @Override // java.lang.Runnable
            public void run() {
                fontRequestCallback.onTypefaceRequestFailed(-3);
            }
        }

        /* renamed from: android.support.v4.provider.FontsContractCompat$4$7 */
        /* loaded from: classes.dex */
        class AnonymousClass7 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ int f1622a;

            AnonymousClass7(int i) {
                resultCode = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                fontRequestCallback.onTypefaceRequestFailed(resultCode);
            }
        }

        /* renamed from: android.support.v4.provider.FontsContractCompat$4$8 */
        /* loaded from: classes.dex */
        class AnonymousClass8 implements Runnable {
            AnonymousClass8() {
            }

            @Override // java.lang.Runnable
            public void run() {
                fontRequestCallback.onTypefaceRequestFailed(-3);
            }
        }

        /* renamed from: android.support.v4.provider.FontsContractCompat$4$9 */
        /* loaded from: classes.dex */
        class AnonymousClass9 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ Typeface f1625a;

            AnonymousClass9(Typeface typeface) {
                buildTypeface = typeface;
            }

            @Override // java.lang.Runnable
            public void run() {
                fontRequestCallback.onTypefaceRetrieved(buildTypeface);
            }
        }

        AnonymousClass4(Context context, FontRequest fontRequest, Handler handler, FontRequestCallback fontRequestCallback) {
            context = context;
            fontRequest = fontRequest;
            handler2 = handler;
            fontRequestCallback = fontRequestCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                FontFamilyResult fetchFonts = FontsContractCompat.fetchFonts(context, null, fontRequest);
                if (fetchFonts.getStatusCode() != 0) {
                    int statusCode = fetchFonts.getStatusCode();
                    if (statusCode == 1) {
                        handler2.post(new Runnable() { // from class: android.support.v4.provider.FontsContractCompat.4.2
                            AnonymousClass2() {
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                fontRequestCallback.onTypefaceRequestFailed(-2);
                            }
                        });
                        return;
                    } else if (statusCode != 2) {
                        handler2.post(new Runnable() { // from class: android.support.v4.provider.FontsContractCompat.4.4
                            RunnableC00044() {
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                fontRequestCallback.onTypefaceRequestFailed(-3);
                            }
                        });
                        return;
                    } else {
                        handler2.post(new Runnable() { // from class: android.support.v4.provider.FontsContractCompat.4.3
                            AnonymousClass3() {
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                fontRequestCallback.onTypefaceRequestFailed(-3);
                            }
                        });
                        return;
                    }
                }
                FontInfo[] fonts = fetchFonts.getFonts();
                if (fonts != null && fonts.length != 0) {
                    for (FontInfo fontInfo : fonts) {
                        if (fontInfo.getResultCode() != 0) {
                            int resultCode = fontInfo.getResultCode();
                            if (resultCode < 0) {
                                handler2.post(new Runnable() { // from class: android.support.v4.provider.FontsContractCompat.4.6
                                    AnonymousClass6() {
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        fontRequestCallback.onTypefaceRequestFailed(-3);
                                    }
                                });
                                return;
                            } else {
                                handler2.post(new Runnable() { // from class: android.support.v4.provider.FontsContractCompat.4.7

                                    /* renamed from: a */
                                    final /* synthetic */ int f1622a;

                                    AnonymousClass7(int resultCode2) {
                                        resultCode = resultCode2;
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        fontRequestCallback.onTypefaceRequestFailed(resultCode);
                                    }
                                });
                                return;
                            }
                        }
                    }
                    Typeface buildTypeface = FontsContractCompat.buildTypeface(context, null, fonts);
                    if (buildTypeface == null) {
                        handler2.post(new Runnable() { // from class: android.support.v4.provider.FontsContractCompat.4.8
                            AnonymousClass8() {
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                fontRequestCallback.onTypefaceRequestFailed(-3);
                            }
                        });
                        return;
                    } else {
                        handler2.post(new Runnable() { // from class: android.support.v4.provider.FontsContractCompat.4.9

                            /* renamed from: a */
                            final /* synthetic */ Typeface f1625a;

                            AnonymousClass9(Typeface buildTypeface2) {
                                buildTypeface = buildTypeface2;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                fontRequestCallback.onTypefaceRetrieved(buildTypeface);
                            }
                        });
                        return;
                    }
                }
                handler2.post(new Runnable() { // from class: android.support.v4.provider.FontsContractCompat.4.5
                    AnonymousClass5() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        fontRequestCallback.onTypefaceRequestFailed(1);
                    }
                });
            } catch (PackageManager.NameNotFoundException unused) {
                handler2.post(new Runnable() { // from class: android.support.v4.provider.FontsContractCompat.4.1
                    AnonymousClass1() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        fontRequestCallback.onTypefaceRequestFailed(-1);
                    }
                });
            }
        }
    }

    /* renamed from: android.support.v4.provider.FontsContractCompat$5 */
    /* loaded from: classes.dex */
    static class AnonymousClass5 implements Comparator<byte[]> {
        AnonymousClass5() {
        }

        @Override // java.util.Comparator
        public int compare(byte[] bArr, byte[] bArr2) {
            int i;
            int i2;
            if (bArr.length != bArr2.length) {
                i = bArr.length;
                i2 = bArr2.length;
            } else {
                for (int i3 = 0; i3 < bArr.length; i3++) {
                    if (bArr[i3] != bArr2[i3]) {
                        i = bArr[i3];
                        i2 = bArr2[i3];
                    }
                }
                return 0;
            }
            return i - i2;
        }
    }

    /* loaded from: classes.dex */
    public static final class Columns implements BaseColumns {
        public static final String FILE_ID = "file_id";
        public static final String ITALIC = "font_italic";
        public static final String RESULT_CODE = "result_code";
        public static final int RESULT_CODE_FONT_NOT_FOUND = 1;
        public static final int RESULT_CODE_FONT_UNAVAILABLE = 2;
        public static final int RESULT_CODE_MALFORMED_QUERY = 3;
        public static final int RESULT_CODE_OK = 0;
        public static final String TTC_INDEX = "font_ttc_index";
        public static final String VARIATION_SETTINGS = "font_variation_settings";
        public static final String WEIGHT = "font_weight";
    }

    /* loaded from: classes.dex */
    public static class FontFamilyResult {
        public static final int STATUS_OK = 0;
        public static final int STATUS_UNEXPECTED_DATA_PROVIDED = 2;
        public static final int STATUS_WRONG_CERTIFICATES = 1;

        /* renamed from: a */
        private final int f1627a;

        /* renamed from: b */
        private final FontInfo[] f1628b;

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes.dex */
        @interface FontResultStatus {
        }

        public FontFamilyResult(int i, FontInfo[] fontInfoArr) {
            this.f1627a = i;
            this.f1628b = fontInfoArr;
        }

        public FontInfo[] getFonts() {
            return this.f1628b;
        }

        public int getStatusCode() {
            return this.f1627a;
        }
    }

    /* loaded from: classes.dex */
    public static class FontInfo {

        /* renamed from: a */
        private final Uri f1629a;

        /* renamed from: b */
        private final int f1630b;

        /* renamed from: c */
        private final int f1631c;

        /* renamed from: d */
        private final boolean f1632d;

        /* renamed from: e */
        private final int f1633e;

        public FontInfo(Uri uri, int i, int i2, boolean z, int i3) {
            Preconditions.checkNotNull(uri);
            this.f1629a = uri;
            this.f1630b = i;
            this.f1631c = i2;
            this.f1632d = z;
            this.f1633e = i3;
        }

        public int getResultCode() {
            return this.f1633e;
        }

        public int getTtcIndex() {
            return this.f1630b;
        }

        public Uri getUri() {
            return this.f1629a;
        }

        public int getWeight() {
            return this.f1631c;
        }

        public boolean isItalic() {
            return this.f1632d;
        }
    }

    /* loaded from: classes.dex */
    public static class FontRequestCallback {
        public static final int FAIL_REASON_FONT_LOAD_ERROR = -3;
        public static final int FAIL_REASON_FONT_NOT_FOUND = 1;
        public static final int FAIL_REASON_FONT_UNAVAILABLE = 2;
        public static final int FAIL_REASON_MALFORMED_QUERY = 3;
        public static final int FAIL_REASON_PROVIDER_NOT_FOUND = -1;
        public static final int FAIL_REASON_SECURITY_VIOLATION = -4;
        public static final int FAIL_REASON_WRONG_CERTIFICATES = -2;
        public static final int RESULT_OK = 0;

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes.dex */
        public @interface FontRequestFailReason {
        }

        public void onTypefaceRequestFailed(int i) {
        }

        public void onTypefaceRetrieved(Typeface typeface) {
        }
    }

    /* loaded from: classes.dex */
    public static final class TypefaceResult {

        /* renamed from: a */
        final Typeface f1634a;

        /* renamed from: b */
        final int f1635b;

        TypefaceResult(Typeface typeface, int i) {
            this.f1634a = typeface;
            this.f1635b = i;
        }
    }

    private FontsContractCompat() {
    }

    public static Typeface buildTypeface(Context context, CancellationSignal cancellationSignal, FontInfo[] fontInfoArr) {
        return TypefaceCompat.createFromFontInfo(context, cancellationSignal, fontInfoArr, 0);
    }

    public static FontFamilyResult fetchFonts(Context context, CancellationSignal cancellationSignal, FontRequest fontRequest) throws PackageManager.NameNotFoundException {
        ProviderInfo provider = getProvider(context.getPackageManager(), fontRequest, context.getResources());
        if (provider == null) {
            return new FontFamilyResult(1, null);
        }
        return new FontFamilyResult(0, a(context, fontRequest, provider.authority, cancellationSignal));
    }

    public static Typeface getFontSync(Context context, FontRequest fontRequest, ResourcesCompat.FontCallback fontCallback, Handler handler, boolean z, int i, int i2) {
        String str = fontRequest.getIdentifier() + "-" + i2;
        Typeface typeface = f1600a.get(str);
        if (typeface != null) {
            if (fontCallback != null) {
                fontCallback.onFontRetrieved(typeface);
            }
            return typeface;
        }
        if (z && i == -1) {
            TypefaceResult b2 = b(context, fontRequest, i2);
            if (fontCallback != null) {
                int i3 = b2.f1635b;
                if (i3 == 0) {
                    fontCallback.callbackSuccessAsync(b2.f1634a, handler);
                } else {
                    fontCallback.callbackFailAsync(i3, handler);
                }
            }
            return b2.f1634a;
        }
        AnonymousClass1 anonymousClass1 = new Callable<TypefaceResult>() { // from class: android.support.v4.provider.FontsContractCompat.1

            /* renamed from: a */
            final /* synthetic */ Context f1605a;

            /* renamed from: b */
            final /* synthetic */ FontRequest f1606b;

            /* renamed from: c */
            final /* synthetic */ int f1607c;

            /* renamed from: d */
            final /* synthetic */ String f1608d;

            AnonymousClass1(Context context2, FontRequest fontRequest2, int i22, String str2) {
                context = context2;
                fontRequest = fontRequest2;
                i2 = i22;
                str = str2;
            }

            @Override // java.util.concurrent.Callable
            public TypefaceResult call() throws Exception {
                TypefaceResult b22 = FontsContractCompat.b(context, fontRequest, i2);
                if (b22.f1634a != null) {
                    FontsContractCompat.f1600a.put(str, b22.f1634a);
                }
                return b22;
            }
        };
        if (z) {
            try {
                return ((TypefaceResult) f1601b.postAndWait(anonymousClass1, i)).f1634a;
            } catch (InterruptedException unused) {
                return null;
            }
        }
        AnonymousClass2 anonymousClass2 = fontCallback == null ? null : new SelfDestructiveThread.ReplyCallback<TypefaceResult>() { // from class: android.support.v4.provider.FontsContractCompat.2

            /* renamed from: b */
            final /* synthetic */ Handler f1610b;

            AnonymousClass2(Handler handler2) {
                handler = handler2;
            }

            @Override // android.support.v4.provider.SelfDestructiveThread.ReplyCallback
            public void onReply(TypefaceResult typefaceResult) {
                if (typefaceResult == null) {
                    ResourcesCompat.FontCallback.this.callbackFailAsync(1, handler);
                    return;
                }
                int i4 = typefaceResult.f1635b;
                if (i4 == 0) {
                    ResourcesCompat.FontCallback.this.callbackSuccessAsync(typefaceResult.f1634a, handler);
                } else {
                    ResourcesCompat.FontCallback.this.callbackFailAsync(i4, handler);
                }
            }
        };
        synchronized (f1602c) {
            if (f1603d.containsKey(str2)) {
                if (anonymousClass2 != null) {
                    f1603d.get(str2).add(anonymousClass2);
                }
                return null;
            }
            if (anonymousClass2 != null) {
                ArrayList<SelfDestructiveThread.ReplyCallback<TypefaceResult>> arrayList = new ArrayList<>();
                arrayList.add(anonymousClass2);
                f1603d.put(str2, arrayList);
            }
            f1601b.postAndReply(anonymousClass1, new SelfDestructiveThread.ReplyCallback<TypefaceResult>() { // from class: android.support.v4.provider.FontsContractCompat.3

                /* renamed from: a */
                final /* synthetic */ String f1611a;

                AnonymousClass3(String str2) {
                    str = str2;
                }

                @Override // android.support.v4.provider.SelfDestructiveThread.ReplyCallback
                public void onReply(TypefaceResult typefaceResult) {
                    synchronized (FontsContractCompat.f1602c) {
                        ArrayList arrayList2 = (ArrayList) FontsContractCompat.f1603d.get(str);
                        if (arrayList2 == null) {
                            return;
                        }
                        FontsContractCompat.f1603d.remove(str);
                        for (int i4 = 0; i4 < arrayList2.size(); i4++) {
                            ((SelfDestructiveThread.ReplyCallback) arrayList2.get(i4)).onReply(typefaceResult);
                        }
                    }
                }
            });
            return null;
        }
    }

    public static ProviderInfo getProvider(PackageManager packageManager, FontRequest fontRequest, Resources resources) throws PackageManager.NameNotFoundException {
        String providerAuthority = fontRequest.getProviderAuthority();
        ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(providerAuthority, 0);
        if (resolveContentProvider != null) {
            if (resolveContentProvider.packageName.equals(fontRequest.getProviderPackage())) {
                List<byte[]> a2 = a(packageManager.getPackageInfo(resolveContentProvider.packageName, 64).signatures);
                Collections.sort(a2, f1604e);
                List<List<byte[]>> a3 = a(fontRequest, resources);
                for (int i = 0; i < a3.size(); i++) {
                    ArrayList arrayList = new ArrayList(a3.get(i));
                    Collections.sort(arrayList, f1604e);
                    if (a(a2, arrayList)) {
                        return resolveContentProvider;
                    }
                }
                return null;
            }
            throw new PackageManager.NameNotFoundException("Found content provider " + providerAuthority + ", but package was not " + fontRequest.getProviderPackage());
        }
        throw new PackageManager.NameNotFoundException("No package found for authority: " + providerAuthority);
    }

    public static Map<Uri, ByteBuffer> prepareFontData(Context context, FontInfo[] fontInfoArr, CancellationSignal cancellationSignal) {
        HashMap hashMap = new HashMap();
        for (FontInfo fontInfo : fontInfoArr) {
            if (fontInfo.getResultCode() == 0) {
                Uri uri = fontInfo.getUri();
                if (!hashMap.containsKey(uri)) {
                    hashMap.put(uri, TypefaceCompatUtil.mmap(context, cancellationSignal, uri));
                }
            }
        }
        return Collections.unmodifiableMap(hashMap);
    }

    public static void requestFont(Context context, FontRequest fontRequest, FontRequestCallback fontRequestCallback, Handler handler) {
        handler.post(new Runnable() { // from class: android.support.v4.provider.FontsContractCompat.4

            /* renamed from: a */
            final /* synthetic */ Context f1612a;

            /* renamed from: b */
            final /* synthetic */ FontRequest f1613b;

            /* renamed from: c */
            final /* synthetic */ Handler f1614c;

            /* renamed from: d */
            final /* synthetic */ FontRequestCallback f1615d;

            /* renamed from: android.support.v4.provider.FontsContractCompat$4$1 */
            /* loaded from: classes.dex */
            class AnonymousClass1 implements Runnable {
                AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    fontRequestCallback.onTypefaceRequestFailed(-1);
                }
            }

            /* renamed from: android.support.v4.provider.FontsContractCompat$4$2 */
            /* loaded from: classes.dex */
            class AnonymousClass2 implements Runnable {
                AnonymousClass2() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    fontRequestCallback.onTypefaceRequestFailed(-2);
                }
            }

            /* renamed from: android.support.v4.provider.FontsContractCompat$4$3 */
            /* loaded from: classes.dex */
            class AnonymousClass3 implements Runnable {
                AnonymousClass3() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    fontRequestCallback.onTypefaceRequestFailed(-3);
                }
            }

            /* renamed from: android.support.v4.provider.FontsContractCompat$4$4 */
            /* loaded from: classes.dex */
            class RunnableC00044 implements Runnable {
                RunnableC00044() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    fontRequestCallback.onTypefaceRequestFailed(-3);
                }
            }

            /* renamed from: android.support.v4.provider.FontsContractCompat$4$5 */
            /* loaded from: classes.dex */
            class AnonymousClass5 implements Runnable {
                AnonymousClass5() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    fontRequestCallback.onTypefaceRequestFailed(1);
                }
            }

            /* renamed from: android.support.v4.provider.FontsContractCompat$4$6 */
            /* loaded from: classes.dex */
            class AnonymousClass6 implements Runnable {
                AnonymousClass6() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    fontRequestCallback.onTypefaceRequestFailed(-3);
                }
            }

            /* renamed from: android.support.v4.provider.FontsContractCompat$4$7 */
            /* loaded from: classes.dex */
            class AnonymousClass7 implements Runnable {

                /* renamed from: a */
                final /* synthetic */ int f1622a;

                AnonymousClass7(int resultCode2) {
                    resultCode = resultCode2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    fontRequestCallback.onTypefaceRequestFailed(resultCode);
                }
            }

            /* renamed from: android.support.v4.provider.FontsContractCompat$4$8 */
            /* loaded from: classes.dex */
            class AnonymousClass8 implements Runnable {
                AnonymousClass8() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    fontRequestCallback.onTypefaceRequestFailed(-3);
                }
            }

            /* renamed from: android.support.v4.provider.FontsContractCompat$4$9 */
            /* loaded from: classes.dex */
            class AnonymousClass9 implements Runnable {

                /* renamed from: a */
                final /* synthetic */ Typeface f1625a;

                AnonymousClass9(Typeface buildTypeface2) {
                    buildTypeface = buildTypeface2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    fontRequestCallback.onTypefaceRetrieved(buildTypeface);
                }
            }

            AnonymousClass4(Context context2, FontRequest fontRequest2, Handler handler2, FontRequestCallback fontRequestCallback2) {
                context = context2;
                fontRequest = fontRequest2;
                handler2 = handler2;
                fontRequestCallback = fontRequestCallback2;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    FontFamilyResult fetchFonts = FontsContractCompat.fetchFonts(context, null, fontRequest);
                    if (fetchFonts.getStatusCode() != 0) {
                        int statusCode = fetchFonts.getStatusCode();
                        if (statusCode == 1) {
                            handler2.post(new Runnable() { // from class: android.support.v4.provider.FontsContractCompat.4.2
                                AnonymousClass2() {
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    fontRequestCallback.onTypefaceRequestFailed(-2);
                                }
                            });
                            return;
                        } else if (statusCode != 2) {
                            handler2.post(new Runnable() { // from class: android.support.v4.provider.FontsContractCompat.4.4
                                RunnableC00044() {
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    fontRequestCallback.onTypefaceRequestFailed(-3);
                                }
                            });
                            return;
                        } else {
                            handler2.post(new Runnable() { // from class: android.support.v4.provider.FontsContractCompat.4.3
                                AnonymousClass3() {
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    fontRequestCallback.onTypefaceRequestFailed(-3);
                                }
                            });
                            return;
                        }
                    }
                    FontInfo[] fonts = fetchFonts.getFonts();
                    if (fonts != null && fonts.length != 0) {
                        for (FontInfo fontInfo : fonts) {
                            if (fontInfo.getResultCode() != 0) {
                                int resultCode2 = fontInfo.getResultCode();
                                if (resultCode2 < 0) {
                                    handler2.post(new Runnable() { // from class: android.support.v4.provider.FontsContractCompat.4.6
                                        AnonymousClass6() {
                                        }

                                        @Override // java.lang.Runnable
                                        public void run() {
                                            fontRequestCallback.onTypefaceRequestFailed(-3);
                                        }
                                    });
                                    return;
                                } else {
                                    handler2.post(new Runnable() { // from class: android.support.v4.provider.FontsContractCompat.4.7

                                        /* renamed from: a */
                                        final /* synthetic */ int f1622a;

                                        AnonymousClass7(int resultCode22) {
                                            resultCode = resultCode22;
                                        }

                                        @Override // java.lang.Runnable
                                        public void run() {
                                            fontRequestCallback.onTypefaceRequestFailed(resultCode);
                                        }
                                    });
                                    return;
                                }
                            }
                        }
                        Typeface buildTypeface2 = FontsContractCompat.buildTypeface(context, null, fonts);
                        if (buildTypeface2 == null) {
                            handler2.post(new Runnable() { // from class: android.support.v4.provider.FontsContractCompat.4.8
                                AnonymousClass8() {
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    fontRequestCallback.onTypefaceRequestFailed(-3);
                                }
                            });
                            return;
                        } else {
                            handler2.post(new Runnable() { // from class: android.support.v4.provider.FontsContractCompat.4.9

                                /* renamed from: a */
                                final /* synthetic */ Typeface f1625a;

                                AnonymousClass9(Typeface buildTypeface22) {
                                    buildTypeface = buildTypeface22;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    fontRequestCallback.onTypefaceRetrieved(buildTypeface);
                                }
                            });
                            return;
                        }
                    }
                    handler2.post(new Runnable() { // from class: android.support.v4.provider.FontsContractCompat.4.5
                        AnonymousClass5() {
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            fontRequestCallback.onTypefaceRequestFailed(1);
                        }
                    });
                } catch (PackageManager.NameNotFoundException unused) {
                    handler2.post(new Runnable() { // from class: android.support.v4.provider.FontsContractCompat.4.1
                        AnonymousClass1() {
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            fontRequestCallback.onTypefaceRequestFailed(-1);
                        }
                    });
                }
            }
        });
    }

    public static void resetCache() {
        f1600a.evictAll();
    }

    public static TypefaceResult b(Context context, FontRequest fontRequest, int i) {
        try {
            FontFamilyResult fetchFonts = fetchFonts(context, null, fontRequest);
            if (fetchFonts.getStatusCode() == 0) {
                Typeface createFromFontInfo = TypefaceCompat.createFromFontInfo(context, null, fetchFonts.getFonts(), i);
                return new TypefaceResult(createFromFontInfo, createFromFontInfo != null ? 0 : -3);
            }
            return new TypefaceResult(null, fetchFonts.getStatusCode() == 1 ? -2 : -3);
        } catch (PackageManager.NameNotFoundException unused) {
            return new TypefaceResult(null, -1);
        }
    }

    private static List<List<byte[]>> a(FontRequest fontRequest, Resources resources) {
        if (fontRequest.getCertificates() != null) {
            return fontRequest.getCertificates();
        }
        return FontResourcesParserCompat.readCerts(resources, fontRequest.getCertificatesArrayResId());
    }

    private static boolean a(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!Arrays.equals(list.get(i), list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static List<byte[]> a(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        for (Signature signature : signatureArr) {
            arrayList.add(signature.toByteArray());
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x012b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static android.support.v4.provider.FontsContractCompat.FontInfo[] a(android.content.Context r19, android.support.v4.provider.FontRequest r20, java.lang.String r21, android.os.CancellationSignal r22) {
        /*
            Method dump skipped, instructions count: 321
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.provider.FontsContractCompat.a(android.content.Context, android.support.v4.provider.FontRequest, java.lang.String, android.os.CancellationSignal):android.support.v4.provider.FontsContractCompat$FontInfo[]");
    }
}
