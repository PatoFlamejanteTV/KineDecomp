package com.crashlytics.android.core;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.ScrollView;
import android.widget.TextView;
import io.fabric.sdk.android.services.settings.p;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes.dex */
class CrashPromptDialog {
    private final AlertDialog.Builder dialog;
    private final OptInLatch latch;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.crashlytics.android.core.CrashPromptDialog$1 */
    /* loaded from: classes.dex */
    public static class AnonymousClass1 implements DialogInterface.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            OptInLatch.this.setOptIn(true);
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.crashlytics.android.core.CrashPromptDialog$2 */
    /* loaded from: classes.dex */
    public static class AnonymousClass2 implements DialogInterface.OnClickListener {
        AnonymousClass2() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            OptInLatch.this.setOptIn(false);
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.crashlytics.android.core.CrashPromptDialog$3 */
    /* loaded from: classes.dex */
    public static class AnonymousClass3 implements DialogInterface.OnClickListener {
        final /* synthetic */ OptInLatch val$latch;

        AnonymousClass3(OptInLatch optInLatch) {
            optInLatch = optInLatch;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            AlwaysSendCallback.this.sendUserReportsWithoutPrompting(true);
            optInLatch.setOptIn(true);
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface AlwaysSendCallback {
        void sendUserReportsWithoutPrompting(boolean z);
    }

    private CrashPromptDialog(AlertDialog.Builder builder, OptInLatch optInLatch) {
        this.latch = optInLatch;
        this.dialog = builder;
    }

    public static CrashPromptDialog create(Activity activity, p pVar, AlwaysSendCallback alwaysSendCallback) {
        OptInLatch optInLatch = new OptInLatch();
        DialogStringResolver dialogStringResolver = new DialogStringResolver(activity, pVar);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        ScrollView createDialogView = createDialogView(activity, dialogStringResolver.getMessage());
        builder.setView(createDialogView).setTitle(dialogStringResolver.getTitle()).setCancelable(false).setNeutralButton(dialogStringResolver.getSendButtonTitle(), new DialogInterface.OnClickListener() { // from class: com.crashlytics.android.core.CrashPromptDialog.1
            AnonymousClass1() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                OptInLatch.this.setOptIn(true);
                dialogInterface.dismiss();
            }
        });
        if (pVar.f27039d) {
            builder.setNegativeButton(dialogStringResolver.getCancelButtonTitle(), new DialogInterface.OnClickListener() { // from class: com.crashlytics.android.core.CrashPromptDialog.2
                AnonymousClass2() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    OptInLatch.this.setOptIn(false);
                    dialogInterface.dismiss();
                }
            });
        }
        if (pVar.f27041f) {
            builder.setPositiveButton(dialogStringResolver.getAlwaysSendButtonTitle(), new DialogInterface.OnClickListener() { // from class: com.crashlytics.android.core.CrashPromptDialog.3
                final /* synthetic */ OptInLatch val$latch;

                AnonymousClass3(OptInLatch optInLatch2) {
                    optInLatch = optInLatch2;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    AlwaysSendCallback.this.sendUserReportsWithoutPrompting(true);
                    optInLatch.setOptIn(true);
                    dialogInterface.dismiss();
                }
            });
        }
        return new CrashPromptDialog(builder, optInLatch2);
    }

    private static ScrollView createDialogView(Activity activity, String str) {
        float f2 = activity.getResources().getDisplayMetrics().density;
        int dipsToPixels = dipsToPixels(f2, 5);
        TextView textView = new TextView(activity);
        textView.setAutoLinkMask(15);
        textView.setText(str);
        textView.setTextAppearance(activity, android.R.style.TextAppearance.Medium);
        textView.setPadding(dipsToPixels, dipsToPixels, dipsToPixels, dipsToPixels);
        textView.setFocusable(false);
        ScrollView scrollView = new ScrollView(activity);
        scrollView.setPadding(dipsToPixels(f2, 14), dipsToPixels(f2, 2), dipsToPixels(f2, 10), dipsToPixels(f2, 12));
        scrollView.addView(textView);
        return scrollView;
    }

    private static int dipsToPixels(float f2, int i) {
        return (int) (f2 * i);
    }

    public void await() {
        this.latch.await();
    }

    public boolean getOptIn() {
        return this.latch.getOptIn();
    }

    public void show() {
        this.dialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class OptInLatch {
        private final CountDownLatch latch;
        private boolean send;

        private OptInLatch() {
            this.send = false;
            this.latch = new CountDownLatch(1);
        }

        void await() {
            try {
                this.latch.await();
            } catch (InterruptedException unused) {
            }
        }

        boolean getOptIn() {
            return this.send;
        }

        void setOptIn(boolean z) {
            this.send = z;
            this.latch.countDown();
        }

        /* synthetic */ OptInLatch(AnonymousClass1 anonymousClass1) {
            this();
        }
    }
}
