package android.support.v4.print;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.pdf.PdfDocument;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentInfo;
import android.print.PrintManager;
import android.print.pdf.PrintedPdfDocument;
import android.util.Log;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public final class PrintHelper {
    public static final int COLOR_MODE_COLOR = 2;
    public static final int COLOR_MODE_MONOCHROME = 1;
    public static final int ORIENTATION_LANDSCAPE = 1;
    public static final int ORIENTATION_PORTRAIT = 2;
    public static final int SCALE_MODE_FILL = 2;
    public static final int SCALE_MODE_FIT = 1;

    /* renamed from: a */
    private final PrintHelperVersionImpl f1553a;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    private @interface ColorMode {
    }

    /* loaded from: classes.dex */
    public interface OnPrintFinishCallback {
        void onFinish();
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    private @interface Orientation {
    }

    /* loaded from: classes.dex */
    public static class PrintHelperApi19 implements PrintHelperVersionImpl {

        /* renamed from: a */
        final Context f1554a;

        /* renamed from: h */
        int f1561h;

        /* renamed from: b */
        BitmapFactory.Options f1555b = null;

        /* renamed from: c */
        private final Object f1556c = new Object();

        /* renamed from: f */
        int f1559f = 2;

        /* renamed from: g */
        int f1560g = 2;

        /* renamed from: d */
        protected boolean f1557d = true;

        /* renamed from: e */
        protected boolean f1558e = true;

        /* renamed from: android.support.v4.print.PrintHelper$PrintHelperApi19$1 */
        /* loaded from: classes.dex */
        class AnonymousClass1 extends PrintDocumentAdapter {

            /* renamed from: a */
            private PrintAttributes f1562a;

            /* renamed from: b */
            final /* synthetic */ String f1563b;

            /* renamed from: c */
            final /* synthetic */ int f1564c;

            /* renamed from: d */
            final /* synthetic */ Bitmap f1565d;

            /* renamed from: e */
            final /* synthetic */ OnPrintFinishCallback f1566e;

            AnonymousClass1(String str, int i, Bitmap bitmap, OnPrintFinishCallback onPrintFinishCallback) {
                str = str;
                i = i;
                bitmap = bitmap;
                onPrintFinishCallback = onPrintFinishCallback;
            }

            @Override // android.print.PrintDocumentAdapter
            public void onFinish() {
                OnPrintFinishCallback onPrintFinishCallback = onPrintFinishCallback;
                if (onPrintFinishCallback != null) {
                    onPrintFinishCallback.onFinish();
                }
            }

            @Override // android.print.PrintDocumentAdapter
            public void onLayout(PrintAttributes printAttributes, PrintAttributes printAttributes2, CancellationSignal cancellationSignal, PrintDocumentAdapter.LayoutResultCallback layoutResultCallback, Bundle bundle) {
                this.f1562a = printAttributes2;
                layoutResultCallback.onLayoutFinished(new PrintDocumentInfo.Builder(str).setContentType(1).setPageCount(1).build(), !printAttributes2.equals(printAttributes));
            }

            @Override // android.print.PrintDocumentAdapter
            public void onWrite(PageRange[] pageRangeArr, ParcelFileDescriptor parcelFileDescriptor, CancellationSignal cancellationSignal, PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
                PrintHelperApi19.this.a(this.f1562a, i, bitmap, parcelFileDescriptor, cancellationSignal, writeResultCallback);
            }
        }

        /* renamed from: android.support.v4.print.PrintHelper$PrintHelperApi19$3 */
        /* loaded from: classes.dex */
        public class AnonymousClass3 extends PrintDocumentAdapter {

            /* renamed from: a */
            private PrintAttributes f1576a;

            /* renamed from: b */
            AsyncTask<Uri, Boolean, Bitmap> f1577b;

            /* renamed from: c */
            Bitmap f1578c = null;

            /* renamed from: d */
            final /* synthetic */ String f1579d;

            /* renamed from: e */
            final /* synthetic */ Uri f1580e;

            /* renamed from: f */
            final /* synthetic */ OnPrintFinishCallback f1581f;

            /* renamed from: g */
            final /* synthetic */ int f1582g;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* renamed from: android.support.v4.print.PrintHelper$PrintHelperApi19$3$1 */
            /* loaded from: classes.dex */
            public class AnonymousClass1 extends AsyncTask<Uri, Boolean, Bitmap> {

                /* renamed from: a */
                final /* synthetic */ CancellationSignal f1584a;

                /* renamed from: b */
                final /* synthetic */ PrintAttributes f1585b;

                /* renamed from: c */
                final /* synthetic */ PrintAttributes f1586c;

                /* renamed from: d */
                final /* synthetic */ PrintDocumentAdapter.LayoutResultCallback f1587d;

                /* renamed from: android.support.v4.print.PrintHelper$PrintHelperApi19$3$1$1 */
                /* loaded from: classes.dex */
                class C00031 implements CancellationSignal.OnCancelListener {
                    C00031() {
                    }

                    @Override // android.os.CancellationSignal.OnCancelListener
                    public void onCancel() {
                        AnonymousClass3.this.a();
                        AnonymousClass1.this.cancel(false);
                    }
                }

                AnonymousClass1(CancellationSignal cancellationSignal, PrintAttributes printAttributes, PrintAttributes printAttributes2, PrintDocumentAdapter.LayoutResultCallback layoutResultCallback) {
                    cancellationSignal = cancellationSignal;
                    printAttributes2 = printAttributes;
                    printAttributes = printAttributes2;
                    layoutResultCallback = layoutResultCallback;
                }

                @Override // android.os.AsyncTask
                /* renamed from: a */
                public Bitmap doInBackground(Uri... uriArr) {
                    try {
                        return PrintHelperApi19.this.a(AnonymousClass3.this.f1580e);
                    } catch (FileNotFoundException unused) {
                        return null;
                    }
                }

                @Override // android.os.AsyncTask
                /* renamed from: b */
                public void onPostExecute(Bitmap bitmap) {
                    PrintAttributes.MediaSize mediaSize;
                    super.onPostExecute(bitmap);
                    if (bitmap != null) {
                        PrintHelperApi19 printHelperApi19 = PrintHelperApi19.this;
                        if (!printHelperApi19.f1557d || printHelperApi19.f1561h == 0) {
                            synchronized (this) {
                                mediaSize = AnonymousClass3.this.f1576a.getMediaSize();
                            }
                            if (mediaSize != null && mediaSize.isPortrait() != PrintHelperApi19.b(bitmap)) {
                                Matrix matrix = new Matrix();
                                matrix.postRotate(90.0f);
                                bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                            }
                        }
                    }
                    AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                    anonymousClass3.f1578c = bitmap;
                    if (bitmap != null) {
                        layoutResultCallback.onLayoutFinished(new PrintDocumentInfo.Builder(anonymousClass3.f1579d).setContentType(1).setPageCount(1).build(), true ^ printAttributes2.equals(printAttributes));
                    } else {
                        layoutResultCallback.onLayoutFailed(null);
                    }
                    AnonymousClass3.this.f1577b = null;
                }

                @Override // android.os.AsyncTask
                protected void onPreExecute() {
                    cancellationSignal.setOnCancelListener(new CancellationSignal.OnCancelListener() { // from class: android.support.v4.print.PrintHelper.PrintHelperApi19.3.1.1
                        C00031() {
                        }

                        @Override // android.os.CancellationSignal.OnCancelListener
                        public void onCancel() {
                            AnonymousClass3.this.a();
                            AnonymousClass1.this.cancel(false);
                        }
                    });
                }

                @Override // android.os.AsyncTask
                /* renamed from: a */
                public void onCancelled(Bitmap bitmap) {
                    layoutResultCallback.onLayoutCancelled();
                    AnonymousClass3.this.f1577b = null;
                }
            }

            AnonymousClass3(String str, Uri uri, OnPrintFinishCallback onPrintFinishCallback, int i) {
                this.f1579d = str;
                this.f1580e = uri;
                this.f1581f = onPrintFinishCallback;
                this.f1582g = i;
            }

            @Override // android.print.PrintDocumentAdapter
            public void onFinish() {
                super.onFinish();
                a();
                AsyncTask<Uri, Boolean, Bitmap> asyncTask = this.f1577b;
                if (asyncTask != null) {
                    asyncTask.cancel(true);
                }
                OnPrintFinishCallback onPrintFinishCallback = this.f1581f;
                if (onPrintFinishCallback != null) {
                    onPrintFinishCallback.onFinish();
                }
                Bitmap bitmap = this.f1578c;
                if (bitmap != null) {
                    bitmap.recycle();
                    this.f1578c = null;
                }
            }

            @Override // android.print.PrintDocumentAdapter
            public void onLayout(PrintAttributes printAttributes, PrintAttributes printAttributes2, CancellationSignal cancellationSignal, PrintDocumentAdapter.LayoutResultCallback layoutResultCallback, Bundle bundle) {
                synchronized (this) {
                    this.f1576a = printAttributes2;
                }
                if (cancellationSignal.isCanceled()) {
                    layoutResultCallback.onLayoutCancelled();
                } else if (this.f1578c != null) {
                    layoutResultCallback.onLayoutFinished(new PrintDocumentInfo.Builder(this.f1579d).setContentType(1).setPageCount(1).build(), !printAttributes2.equals(printAttributes));
                } else {
                    this.f1577b = new AsyncTask<Uri, Boolean, Bitmap>() { // from class: android.support.v4.print.PrintHelper.PrintHelperApi19.3.1

                        /* renamed from: a */
                        final /* synthetic */ CancellationSignal f1584a;

                        /* renamed from: b */
                        final /* synthetic */ PrintAttributes f1585b;

                        /* renamed from: c */
                        final /* synthetic */ PrintAttributes f1586c;

                        /* renamed from: d */
                        final /* synthetic */ PrintDocumentAdapter.LayoutResultCallback f1587d;

                        /* renamed from: android.support.v4.print.PrintHelper$PrintHelperApi19$3$1$1 */
                        /* loaded from: classes.dex */
                        class C00031 implements CancellationSignal.OnCancelListener {
                            C00031() {
                            }

                            @Override // android.os.CancellationSignal.OnCancelListener
                            public void onCancel() {
                                AnonymousClass3.this.a();
                                AnonymousClass1.this.cancel(false);
                            }
                        }

                        AnonymousClass1(CancellationSignal cancellationSignal2, PrintAttributes printAttributes22, PrintAttributes printAttributes3, PrintDocumentAdapter.LayoutResultCallback layoutResultCallback2) {
                            cancellationSignal = cancellationSignal2;
                            printAttributes2 = printAttributes22;
                            printAttributes = printAttributes3;
                            layoutResultCallback = layoutResultCallback2;
                        }

                        @Override // android.os.AsyncTask
                        /* renamed from: a */
                        public Bitmap doInBackground(Uri... uriArr) {
                            try {
                                return PrintHelperApi19.this.a(AnonymousClass3.this.f1580e);
                            } catch (FileNotFoundException unused) {
                                return null;
                            }
                        }

                        @Override // android.os.AsyncTask
                        /* renamed from: b */
                        public void onPostExecute(Bitmap bitmap) {
                            PrintAttributes.MediaSize mediaSize;
                            super.onPostExecute(bitmap);
                            if (bitmap != null) {
                                PrintHelperApi19 printHelperApi19 = PrintHelperApi19.this;
                                if (!printHelperApi19.f1557d || printHelperApi19.f1561h == 0) {
                                    synchronized (this) {
                                        mediaSize = AnonymousClass3.this.f1576a.getMediaSize();
                                    }
                                    if (mediaSize != null && mediaSize.isPortrait() != PrintHelperApi19.b(bitmap)) {
                                        Matrix matrix = new Matrix();
                                        matrix.postRotate(90.0f);
                                        bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                                    }
                                }
                            }
                            AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                            anonymousClass3.f1578c = bitmap;
                            if (bitmap != null) {
                                layoutResultCallback.onLayoutFinished(new PrintDocumentInfo.Builder(anonymousClass3.f1579d).setContentType(1).setPageCount(1).build(), true ^ printAttributes2.equals(printAttributes));
                            } else {
                                layoutResultCallback.onLayoutFailed(null);
                            }
                            AnonymousClass3.this.f1577b = null;
                        }

                        @Override // android.os.AsyncTask
                        protected void onPreExecute() {
                            cancellationSignal.setOnCancelListener(new CancellationSignal.OnCancelListener() { // from class: android.support.v4.print.PrintHelper.PrintHelperApi19.3.1.1
                                C00031() {
                                }

                                @Override // android.os.CancellationSignal.OnCancelListener
                                public void onCancel() {
                                    AnonymousClass3.this.a();
                                    AnonymousClass1.this.cancel(false);
                                }
                            });
                        }

                        @Override // android.os.AsyncTask
                        /* renamed from: a */
                        public void onCancelled(Bitmap bitmap) {
                            layoutResultCallback.onLayoutCancelled();
                            AnonymousClass3.this.f1577b = null;
                        }
                    }.execute(new Uri[0]);
                }
            }

            @Override // android.print.PrintDocumentAdapter
            public void onWrite(PageRange[] pageRangeArr, ParcelFileDescriptor parcelFileDescriptor, CancellationSignal cancellationSignal, PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
                PrintHelperApi19.this.a(this.f1576a, this.f1582g, this.f1578c, parcelFileDescriptor, cancellationSignal, writeResultCallback);
            }

            public void a() {
                synchronized (PrintHelperApi19.this.f1556c) {
                    if (PrintHelperApi19.this.f1555b != null) {
                        PrintHelperApi19.this.f1555b.requestCancelDecode();
                        PrintHelperApi19.this.f1555b = null;
                    }
                }
            }
        }

        PrintHelperApi19(Context context) {
            this.f1554a = context;
        }

        public static boolean b(Bitmap bitmap) {
            return bitmap.getWidth() <= bitmap.getHeight();
        }

        @Override // android.support.v4.print.PrintHelper.PrintHelperVersionImpl
        public int getColorMode() {
            return this.f1560g;
        }

        @Override // android.support.v4.print.PrintHelper.PrintHelperVersionImpl
        public int getOrientation() {
            int i = this.f1561h;
            if (i == 0) {
                return 1;
            }
            return i;
        }

        @Override // android.support.v4.print.PrintHelper.PrintHelperVersionImpl
        public int getScaleMode() {
            return this.f1559f;
        }

        @Override // android.support.v4.print.PrintHelper.PrintHelperVersionImpl
        public void printBitmap(String str, Bitmap bitmap, OnPrintFinishCallback onPrintFinishCallback) {
            PrintAttributes.MediaSize mediaSize;
            if (bitmap == null) {
                return;
            }
            int i = this.f1559f;
            PrintManager printManager = (PrintManager) this.f1554a.getSystemService("print");
            if (b(bitmap)) {
                mediaSize = PrintAttributes.MediaSize.UNKNOWN_PORTRAIT;
            } else {
                mediaSize = PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE;
            }
            printManager.print(str, new PrintDocumentAdapter() { // from class: android.support.v4.print.PrintHelper.PrintHelperApi19.1

                /* renamed from: a */
                private PrintAttributes f1562a;

                /* renamed from: b */
                final /* synthetic */ String f1563b;

                /* renamed from: c */
                final /* synthetic */ int f1564c;

                /* renamed from: d */
                final /* synthetic */ Bitmap f1565d;

                /* renamed from: e */
                final /* synthetic */ OnPrintFinishCallback f1566e;

                AnonymousClass1(String str2, int i2, Bitmap bitmap2, OnPrintFinishCallback onPrintFinishCallback2) {
                    str = str2;
                    i = i2;
                    bitmap = bitmap2;
                    onPrintFinishCallback = onPrintFinishCallback2;
                }

                @Override // android.print.PrintDocumentAdapter
                public void onFinish() {
                    OnPrintFinishCallback onPrintFinishCallback2 = onPrintFinishCallback;
                    if (onPrintFinishCallback2 != null) {
                        onPrintFinishCallback2.onFinish();
                    }
                }

                @Override // android.print.PrintDocumentAdapter
                public void onLayout(PrintAttributes printAttributes, PrintAttributes printAttributes2, CancellationSignal cancellationSignal, PrintDocumentAdapter.LayoutResultCallback layoutResultCallback, Bundle bundle) {
                    this.f1562a = printAttributes2;
                    layoutResultCallback.onLayoutFinished(new PrintDocumentInfo.Builder(str).setContentType(1).setPageCount(1).build(), !printAttributes2.equals(printAttributes));
                }

                @Override // android.print.PrintDocumentAdapter
                public void onWrite(PageRange[] pageRangeArr, ParcelFileDescriptor parcelFileDescriptor, CancellationSignal cancellationSignal, PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
                    PrintHelperApi19.this.a(this.f1562a, i, bitmap, parcelFileDescriptor, cancellationSignal, writeResultCallback);
                }
            }, new PrintAttributes.Builder().setMediaSize(mediaSize).setColorMode(this.f1560g).build());
        }

        @Override // android.support.v4.print.PrintHelper.PrintHelperVersionImpl
        public void setColorMode(int i) {
            this.f1560g = i;
        }

        @Override // android.support.v4.print.PrintHelper.PrintHelperVersionImpl
        public void setOrientation(int i) {
            this.f1561h = i;
        }

        @Override // android.support.v4.print.PrintHelper.PrintHelperVersionImpl
        public void setScaleMode(int i) {
            this.f1559f = i;
        }

        protected PrintAttributes.Builder a(PrintAttributes printAttributes) {
            PrintAttributes.Builder minMargins = new PrintAttributes.Builder().setMediaSize(printAttributes.getMediaSize()).setResolution(printAttributes.getResolution()).setMinMargins(printAttributes.getMinMargins());
            if (printAttributes.getColorMode() != 0) {
                minMargins.setColorMode(printAttributes.getColorMode());
            }
            return minMargins;
        }

        @Override // android.support.v4.print.PrintHelper.PrintHelperVersionImpl
        public void printBitmap(String str, Uri uri, OnPrintFinishCallback onPrintFinishCallback) throws FileNotFoundException {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(str, uri, onPrintFinishCallback, this.f1559f);
            PrintManager printManager = (PrintManager) this.f1554a.getSystemService("print");
            PrintAttributes.Builder builder = new PrintAttributes.Builder();
            builder.setColorMode(this.f1560g);
            int i = this.f1561h;
            if (i == 1 || i == 0) {
                builder.setMediaSize(PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE);
            } else if (i == 2) {
                builder.setMediaSize(PrintAttributes.MediaSize.UNKNOWN_PORTRAIT);
            }
            printManager.print(str, anonymousClass3, builder.build());
        }

        public Matrix a(int i, int i2, RectF rectF, int i3) {
            float min;
            Matrix matrix = new Matrix();
            float f2 = i;
            float width = rectF.width() / f2;
            if (i3 == 2) {
                min = Math.max(width, rectF.height() / i2);
            } else {
                min = Math.min(width, rectF.height() / i2);
            }
            matrix.postScale(min, min);
            matrix.postTranslate((rectF.width() - (f2 * min)) / 2.0f, (rectF.height() - (i2 * min)) / 2.0f);
            return matrix;
        }

        public void a(PrintAttributes printAttributes, int i, Bitmap bitmap, ParcelFileDescriptor parcelFileDescriptor, CancellationSignal cancellationSignal, PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
            new AsyncTask<Void, Void, Throwable>() { // from class: android.support.v4.print.PrintHelper.PrintHelperApi19.2

                /* renamed from: a */
                final /* synthetic */ CancellationSignal f1568a;

                /* renamed from: b */
                final /* synthetic */ PrintAttributes f1569b;

                /* renamed from: c */
                final /* synthetic */ Bitmap f1570c;

                /* renamed from: d */
                final /* synthetic */ PrintAttributes f1571d;

                /* renamed from: e */
                final /* synthetic */ int f1572e;

                /* renamed from: f */
                final /* synthetic */ ParcelFileDescriptor f1573f;

                /* renamed from: g */
                final /* synthetic */ PrintDocumentAdapter.WriteResultCallback f1574g;

                AnonymousClass2(CancellationSignal cancellationSignal2, PrintAttributes printAttributes2, Bitmap bitmap2, PrintAttributes printAttributes3, int i2, ParcelFileDescriptor parcelFileDescriptor2, PrintDocumentAdapter.WriteResultCallback writeResultCallback2) {
                    cancellationSignal = cancellationSignal2;
                    build = printAttributes2;
                    bitmap = bitmap2;
                    printAttributes = printAttributes3;
                    i = i2;
                    parcelFileDescriptor = parcelFileDescriptor2;
                    writeResultCallback = writeResultCallback2;
                }

                @Override // android.os.AsyncTask
                /* renamed from: a */
                public Throwable doInBackground(Void... voidArr) {
                    RectF rectF;
                    try {
                        if (cancellationSignal.isCanceled()) {
                            return null;
                        }
                        PrintedPdfDocument printedPdfDocument = new PrintedPdfDocument(PrintHelperApi19.this.f1554a, build);
                        Bitmap a2 = PrintHelperApi19.this.a(bitmap, build.getColorMode());
                        if (cancellationSignal.isCanceled()) {
                            return null;
                        }
                        try {
                            PdfDocument.Page startPage = printedPdfDocument.startPage(1);
                            if (PrintHelperApi19.this.f1558e) {
                                rectF = new RectF(startPage.getInfo().getContentRect());
                            } else {
                                PrintedPdfDocument printedPdfDocument2 = new PrintedPdfDocument(PrintHelperApi19.this.f1554a, printAttributes);
                                PdfDocument.Page startPage2 = printedPdfDocument2.startPage(1);
                                RectF rectF2 = new RectF(startPage2.getInfo().getContentRect());
                                printedPdfDocument2.finishPage(startPage2);
                                printedPdfDocument2.close();
                                rectF = rectF2;
                            }
                            Matrix a3 = PrintHelperApi19.this.a(a2.getWidth(), a2.getHeight(), rectF, i);
                            if (!PrintHelperApi19.this.f1558e) {
                                a3.postTranslate(rectF.left, rectF.top);
                                startPage.getCanvas().clipRect(rectF);
                            }
                            startPage.getCanvas().drawBitmap(a2, a3, null);
                            printedPdfDocument.finishPage(startPage);
                            if (cancellationSignal.isCanceled()) {
                                printedPdfDocument.close();
                                if (parcelFileDescriptor != null) {
                                    try {
                                        parcelFileDescriptor.close();
                                    } catch (IOException unused) {
                                    }
                                }
                                if (a2 != bitmap) {
                                    a2.recycle();
                                }
                                return null;
                            }
                            printedPdfDocument.writeTo(new FileOutputStream(parcelFileDescriptor.getFileDescriptor()));
                            printedPdfDocument.close();
                            if (parcelFileDescriptor != null) {
                                try {
                                    parcelFileDescriptor.close();
                                } catch (IOException unused2) {
                                }
                            }
                            if (a2 != bitmap) {
                                a2.recycle();
                            }
                            return null;
                        } finally {
                        }
                    } catch (Throwable th) {
                        return th;
                    }
                }

                @Override // android.os.AsyncTask
                /* renamed from: a */
                public void onPostExecute(Throwable th) {
                    if (cancellationSignal.isCanceled()) {
                        writeResultCallback.onWriteCancelled();
                    } else if (th == null) {
                        writeResultCallback.onWriteFinished(new PageRange[]{PageRange.ALL_PAGES});
                    } else {
                        Log.e("PrintHelperApi19", "Error writing printed content", th);
                        writeResultCallback.onWriteFailed(null);
                    }
                }
            }.execute(new Void[0]);
        }

        public Bitmap a(Uri uri) throws FileNotFoundException {
            BitmapFactory.Options options;
            if (uri != null && this.f1554a != null) {
                BitmapFactory.Options options2 = new BitmapFactory.Options();
                options2.inJustDecodeBounds = true;
                a(uri, options2);
                int i = options2.outWidth;
                int i2 = options2.outHeight;
                if (i > 0 && i2 > 0) {
                    int max = Math.max(i, i2);
                    int i3 = 1;
                    while (max > 3500) {
                        max >>>= 1;
                        i3 <<= 1;
                    }
                    if (i3 > 0 && Math.min(i, i2) / i3 > 0) {
                        synchronized (this.f1556c) {
                            this.f1555b = new BitmapFactory.Options();
                            this.f1555b.inMutable = true;
                            this.f1555b.inSampleSize = i3;
                            options = this.f1555b;
                        }
                        try {
                            Bitmap a2 = a(uri, options);
                            synchronized (this.f1556c) {
                                this.f1555b = null;
                            }
                            return a2;
                        } catch (Throwable th) {
                            synchronized (this.f1556c) {
                                this.f1555b = null;
                                throw th;
                            }
                        }
                    }
                }
                return null;
            }
            throw new IllegalArgumentException("bad argument to getScaledBitmap");
        }

        /* renamed from: android.support.v4.print.PrintHelper$PrintHelperApi19$2 */
        /* loaded from: classes.dex */
        public class AnonymousClass2 extends AsyncTask<Void, Void, Throwable> {

            /* renamed from: a */
            final /* synthetic */ CancellationSignal f1568a;

            /* renamed from: b */
            final /* synthetic */ PrintAttributes f1569b;

            /* renamed from: c */
            final /* synthetic */ Bitmap f1570c;

            /* renamed from: d */
            final /* synthetic */ PrintAttributes f1571d;

            /* renamed from: e */
            final /* synthetic */ int f1572e;

            /* renamed from: f */
            final /* synthetic */ ParcelFileDescriptor f1573f;

            /* renamed from: g */
            final /* synthetic */ PrintDocumentAdapter.WriteResultCallback f1574g;

            AnonymousClass2(CancellationSignal cancellationSignal2, PrintAttributes printAttributes2, Bitmap bitmap2, PrintAttributes printAttributes3, int i2, ParcelFileDescriptor parcelFileDescriptor2, PrintDocumentAdapter.WriteResultCallback writeResultCallback2) {
                cancellationSignal = cancellationSignal2;
                build = printAttributes2;
                bitmap = bitmap2;
                printAttributes = printAttributes3;
                i = i2;
                parcelFileDescriptor = parcelFileDescriptor2;
                writeResultCallback = writeResultCallback2;
            }

            @Override // android.os.AsyncTask
            /* renamed from: a */
            public Throwable doInBackground(Void... voidArr) {
                RectF rectF;
                try {
                    if (cancellationSignal.isCanceled()) {
                        return null;
                    }
                    PrintedPdfDocument printedPdfDocument = new PrintedPdfDocument(PrintHelperApi19.this.f1554a, build);
                    Bitmap a2 = PrintHelperApi19.this.a(bitmap, build.getColorMode());
                    if (cancellationSignal.isCanceled()) {
                        return null;
                    }
                    try {
                        PdfDocument.Page startPage = printedPdfDocument.startPage(1);
                        if (PrintHelperApi19.this.f1558e) {
                            rectF = new RectF(startPage.getInfo().getContentRect());
                        } else {
                            PrintedPdfDocument printedPdfDocument2 = new PrintedPdfDocument(PrintHelperApi19.this.f1554a, printAttributes);
                            PdfDocument.Page startPage2 = printedPdfDocument2.startPage(1);
                            RectF rectF2 = new RectF(startPage2.getInfo().getContentRect());
                            printedPdfDocument2.finishPage(startPage2);
                            printedPdfDocument2.close();
                            rectF = rectF2;
                        }
                        Matrix a3 = PrintHelperApi19.this.a(a2.getWidth(), a2.getHeight(), rectF, i);
                        if (!PrintHelperApi19.this.f1558e) {
                            a3.postTranslate(rectF.left, rectF.top);
                            startPage.getCanvas().clipRect(rectF);
                        }
                        startPage.getCanvas().drawBitmap(a2, a3, null);
                        printedPdfDocument.finishPage(startPage);
                        if (cancellationSignal.isCanceled()) {
                            printedPdfDocument.close();
                            if (parcelFileDescriptor != null) {
                                try {
                                    parcelFileDescriptor.close();
                                } catch (IOException unused) {
                                }
                            }
                            if (a2 != bitmap) {
                                a2.recycle();
                            }
                            return null;
                        }
                        printedPdfDocument.writeTo(new FileOutputStream(parcelFileDescriptor.getFileDescriptor()));
                        printedPdfDocument.close();
                        if (parcelFileDescriptor != null) {
                            try {
                                parcelFileDescriptor.close();
                            } catch (IOException unused2) {
                            }
                        }
                        if (a2 != bitmap) {
                            a2.recycle();
                        }
                        return null;
                    } finally {
                    }
                } catch (Throwable th) {
                    return th;
                }
            }

            @Override // android.os.AsyncTask
            /* renamed from: a */
            public void onPostExecute(Throwable th) {
                if (cancellationSignal.isCanceled()) {
                    writeResultCallback.onWriteCancelled();
                } else if (th == null) {
                    writeResultCallback.onWriteFinished(new PageRange[]{PageRange.ALL_PAGES});
                } else {
                    Log.e("PrintHelperApi19", "Error writing printed content", th);
                    writeResultCallback.onWriteFailed(null);
                }
            }
        }

        private Bitmap a(Uri uri, BitmapFactory.Options options) throws FileNotFoundException {
            Context context;
            InputStream openInputStream;
            if (uri != null && (context = this.f1554a) != null) {
                InputStream inputStream = null;
                try {
                    openInputStream = context.getContentResolver().openInputStream(uri);
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    Bitmap decodeStream = BitmapFactory.decodeStream(openInputStream, null, options);
                    if (openInputStream != null) {
                        try {
                            openInputStream.close();
                        } catch (IOException e2) {
                            Log.w("PrintHelperApi19", "close fail ", e2);
                        }
                    }
                    return decodeStream;
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = openInputStream;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e3) {
                            Log.w("PrintHelperApi19", "close fail ", e3);
                        }
                    }
                    throw th;
                }
            }
            throw new IllegalArgumentException("bad argument to loadBitmap");
        }

        public Bitmap a(Bitmap bitmap, int i) {
            if (i != 1) {
                return bitmap;
            }
            Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            Paint paint = new Paint();
            ColorMatrix colorMatrix = new ColorMatrix();
            colorMatrix.setSaturation(0.0f);
            paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
            canvas.setBitmap(null);
            return createBitmap;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class PrintHelperApi20 extends PrintHelperApi19 {
        PrintHelperApi20(Context context) {
            super(context);
            this.f1557d = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class PrintHelperApi23 extends PrintHelperApi20 {
        PrintHelperApi23(Context context) {
            super(context);
            this.f1558e = false;
        }

        @Override // android.support.v4.print.PrintHelper.PrintHelperApi19
        protected PrintAttributes.Builder a(PrintAttributes printAttributes) {
            PrintAttributes.Builder a2 = super.a(printAttributes);
            if (printAttributes.getDuplexMode() != 0) {
                a2.setDuplexMode(printAttributes.getDuplexMode());
            }
            return a2;
        }
    }

    /* loaded from: classes.dex */
    private static class PrintHelperApi24 extends PrintHelperApi23 {
        PrintHelperApi24(Context context) {
            super(context);
            this.f1558e = true;
            this.f1557d = true;
        }
    }

    /* loaded from: classes.dex */
    interface PrintHelperVersionImpl {
        int getColorMode();

        int getOrientation();

        int getScaleMode();

        void printBitmap(String str, Bitmap bitmap, OnPrintFinishCallback onPrintFinishCallback);

        void printBitmap(String str, Uri uri, OnPrintFinishCallback onPrintFinishCallback) throws FileNotFoundException;

        void setColorMode(int i);

        void setOrientation(int i);

        void setScaleMode(int i);
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    private @interface ScaleMode {
    }

    public PrintHelper(Context context) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 24) {
            this.f1553a = new PrintHelperApi24(context);
            return;
        }
        if (i >= 23) {
            this.f1553a = new PrintHelperApi23(context);
            return;
        }
        if (i >= 20) {
            this.f1553a = new PrintHelperApi20(context);
        } else if (i >= 19) {
            this.f1553a = new PrintHelperApi19(context);
        } else {
            this.f1553a = new PrintHelperStub();
        }
    }

    public static boolean systemSupportsPrint() {
        return Build.VERSION.SDK_INT >= 19;
    }

    public int getColorMode() {
        return this.f1553a.getColorMode();
    }

    public int getOrientation() {
        return this.f1553a.getOrientation();
    }

    public int getScaleMode() {
        return this.f1553a.getScaleMode();
    }

    public void printBitmap(String str, Bitmap bitmap) {
        this.f1553a.printBitmap(str, bitmap, (OnPrintFinishCallback) null);
    }

    public void setColorMode(int i) {
        this.f1553a.setColorMode(i);
    }

    public void setOrientation(int i) {
        this.f1553a.setOrientation(i);
    }

    public void setScaleMode(int i) {
        this.f1553a.setScaleMode(i);
    }

    public void printBitmap(String str, Bitmap bitmap, OnPrintFinishCallback onPrintFinishCallback) {
        this.f1553a.printBitmap(str, bitmap, onPrintFinishCallback);
    }

    public void printBitmap(String str, Uri uri) throws FileNotFoundException {
        this.f1553a.printBitmap(str, uri, (OnPrintFinishCallback) null);
    }

    /* loaded from: classes.dex */
    private static final class PrintHelperStub implements PrintHelperVersionImpl {

        /* renamed from: a */
        int f1590a;

        /* renamed from: b */
        int f1591b;

        /* renamed from: c */
        int f1592c;

        private PrintHelperStub() {
            this.f1590a = 2;
            this.f1591b = 2;
            this.f1592c = 1;
        }

        @Override // android.support.v4.print.PrintHelper.PrintHelperVersionImpl
        public int getColorMode() {
            return this.f1591b;
        }

        @Override // android.support.v4.print.PrintHelper.PrintHelperVersionImpl
        public int getOrientation() {
            return this.f1592c;
        }

        @Override // android.support.v4.print.PrintHelper.PrintHelperVersionImpl
        public int getScaleMode() {
            return this.f1590a;
        }

        @Override // android.support.v4.print.PrintHelper.PrintHelperVersionImpl
        public void printBitmap(String str, Bitmap bitmap, OnPrintFinishCallback onPrintFinishCallback) {
        }

        @Override // android.support.v4.print.PrintHelper.PrintHelperVersionImpl
        public void printBitmap(String str, Uri uri, OnPrintFinishCallback onPrintFinishCallback) {
        }

        @Override // android.support.v4.print.PrintHelper.PrintHelperVersionImpl
        public void setColorMode(int i) {
            this.f1591b = i;
        }

        @Override // android.support.v4.print.PrintHelper.PrintHelperVersionImpl
        public void setOrientation(int i) {
            this.f1592c = i;
        }

        @Override // android.support.v4.print.PrintHelper.PrintHelperVersionImpl
        public void setScaleMode(int i) {
            this.f1590a = i;
        }

        /* synthetic */ PrintHelperStub(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public void printBitmap(String str, Uri uri, OnPrintFinishCallback onPrintFinishCallback) throws FileNotFoundException {
        this.f1553a.printBitmap(str, uri, onPrintFinishCallback);
    }
}
