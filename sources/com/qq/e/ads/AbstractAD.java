package com.qq.e.ads;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.qq.e.ads.cfg.BrowserType;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.comm.a;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.ADI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.AdError;
import com.qq.e.comm.util.GDTLogger;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* loaded from: classes3.dex */
public abstract class AbstractAD<T extends ADI> {

    /* renamed from: a */
    private volatile boolean f24756a = false;

    /* renamed from: b */
    private volatile boolean f24757b = false;

    /* renamed from: c */
    private T f24758c;

    /* renamed from: d */
    private BrowserType f24759d;

    /* renamed from: e */
    private DownAPPConfirmPolicy f24760e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.qq.e.ads.AbstractAD$1 */
    /* loaded from: classes3.dex */
    public class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f24761a;

        /* renamed from: b */
        final /* synthetic */ String f24762b;

        /* renamed from: c */
        final /* synthetic */ String f24763c;

        /* renamed from: d */
        final /* synthetic */ BasicADListener f24764d;

        /* renamed from: com.qq.e.ads.AbstractAD$1$1 */
        /* loaded from: classes3.dex */
        class RunnableC01191 implements Runnable {

            /* renamed from: a */
            private /* synthetic */ POFactory f24766a;

            RunnableC01191(POFactory pOFactory) {
                pOFactory = pOFactory;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (pOFactory == null) {
                        AbstractAD.a(AbstractAD.this, true);
                        AbstractAD.this.a(basicADListener, 200102);
                        return;
                    }
                    AbstractAD.this.f24758c = AbstractAD.this.a(context, pOFactory, str, str2);
                    AbstractAD.a(AbstractAD.this, true);
                    if (AbstractAD.this.f24759d != null) {
                        AbstractAD.this.setBrowserType(AbstractAD.this.f24759d);
                    }
                    if (AbstractAD.this.f24760e != null) {
                        AbstractAD.this.setDownAPPConfirmPolicy(AbstractAD.this.f24760e);
                    }
                    AbstractAD.this.a((AbstractAD) AbstractAD.this.f24758c);
                } catch (Throwable th) {
                    GDTLogger.e("Exception while init Core", th);
                    AbstractAD.a(AbstractAD.this, true);
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    AbstractAD.this.a(basicADListener, 2001);
                }
            }
        }

        AnonymousClass1(Context context, String str, String str2, BasicADListener basicADListener) {
            context = context;
            str = str;
            str2 = str2;
            basicADListener = basicADListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractAD abstractAD;
            BasicADListener basicADListener;
            int i;
            if (GDTADManager.getInstance().initWith(context, str)) {
                try {
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qq.e.ads.AbstractAD.1.1

                        /* renamed from: a */
                        private /* synthetic */ POFactory f24766a;

                        RunnableC01191(POFactory pOFactory) {
                            pOFactory = pOFactory;
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                if (pOFactory == null) {
                                    AbstractAD.a(AbstractAD.this, true);
                                    AbstractAD.this.a(basicADListener, 200102);
                                    return;
                                }
                                AbstractAD.this.f24758c = AbstractAD.this.a(context, pOFactory, str, str2);
                                AbstractAD.a(AbstractAD.this, true);
                                if (AbstractAD.this.f24759d != null) {
                                    AbstractAD.this.setBrowserType(AbstractAD.this.f24759d);
                                }
                                if (AbstractAD.this.f24760e != null) {
                                    AbstractAD.this.setDownAPPConfirmPolicy(AbstractAD.this.f24760e);
                                }
                                AbstractAD.this.a((AbstractAD) AbstractAD.this.f24758c);
                            } catch (Throwable th) {
                                GDTLogger.e("Exception while init Core", th);
                                AbstractAD.a(AbstractAD.this, true);
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                AbstractAD.this.a(basicADListener, 2001);
                            }
                        }
                    });
                    return;
                } catch (Throwable th) {
                    GDTLogger.e("Exception while init plugin", th);
                    abstractAD = AbstractAD.this;
                    basicADListener = basicADListener;
                    i = 200102;
                }
            } else {
                GDTLogger.e("Fail to init ADManager");
                abstractAD = AbstractAD.this;
                basicADListener = basicADListener;
                i = 200101;
            }
            abstractAD.a(basicADListener, i);
        }
    }

    /* loaded from: classes3.dex */
    public interface BasicADListener {
        void onNoAD(AdError adError);
    }

    static /* synthetic */ boolean a(AbstractAD abstractAD, boolean z) {
        abstractAD.f24756a = true;
        return true;
    }

    public final T a() {
        return this.f24758c;
    }

    protected abstract T a(Context context, POFactory pOFactory, String str, String str2);

    public final void a(Context context, String str, String str2, BasicADListener basicADListener) {
        if (a.a(context)) {
            this.f24757b = true;
            GDTADManager.INIT_EXECUTOR.execute(new Runnable() { // from class: com.qq.e.ads.AbstractAD.1

                /* renamed from: a */
                final /* synthetic */ Context f24761a;

                /* renamed from: b */
                final /* synthetic */ String f24762b;

                /* renamed from: c */
                final /* synthetic */ String f24763c;

                /* renamed from: d */
                final /* synthetic */ BasicADListener f24764d;

                /* renamed from: com.qq.e.ads.AbstractAD$1$1 */
                /* loaded from: classes3.dex */
                class RunnableC01191 implements Runnable {

                    /* renamed from: a */
                    private /* synthetic */ POFactory f24766a;

                    RunnableC01191(POFactory pOFactory) {
                        pOFactory = pOFactory;
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (pOFactory == null) {
                                AbstractAD.a(AbstractAD.this, true);
                                AbstractAD.this.a(basicADListener, 200102);
                                return;
                            }
                            AbstractAD.this.f24758c = AbstractAD.this.a(context, pOFactory, str, str2);
                            AbstractAD.a(AbstractAD.this, true);
                            if (AbstractAD.this.f24759d != null) {
                                AbstractAD.this.setBrowserType(AbstractAD.this.f24759d);
                            }
                            if (AbstractAD.this.f24760e != null) {
                                AbstractAD.this.setDownAPPConfirmPolicy(AbstractAD.this.f24760e);
                            }
                            AbstractAD.this.a((AbstractAD) AbstractAD.this.f24758c);
                        } catch (Throwable th) {
                            GDTLogger.e("Exception while init Core", th);
                            AbstractAD.a(AbstractAD.this, true);
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            AbstractAD.this.a(basicADListener, 2001);
                        }
                    }
                }

                AnonymousClass1(Context context2, String str3, String str22, BasicADListener basicADListener2) {
                    context = context2;
                    str = str3;
                    str2 = str22;
                    basicADListener = basicADListener2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    AbstractAD abstractAD;
                    BasicADListener basicADListener2;
                    int i;
                    if (GDTADManager.getInstance().initWith(context, str)) {
                        try {
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.qq.e.ads.AbstractAD.1.1

                                /* renamed from: a */
                                private /* synthetic */ POFactory f24766a;

                                RunnableC01191(POFactory pOFactory) {
                                    pOFactory = pOFactory;
                                }

                                /* JADX WARN: Multi-variable type inference failed */
                                @Override // java.lang.Runnable
                                public void run() {
                                    try {
                                        if (pOFactory == null) {
                                            AbstractAD.a(AbstractAD.this, true);
                                            AbstractAD.this.a(basicADListener, 200102);
                                            return;
                                        }
                                        AbstractAD.this.f24758c = AbstractAD.this.a(context, pOFactory, str, str2);
                                        AbstractAD.a(AbstractAD.this, true);
                                        if (AbstractAD.this.f24759d != null) {
                                            AbstractAD.this.setBrowserType(AbstractAD.this.f24759d);
                                        }
                                        if (AbstractAD.this.f24760e != null) {
                                            AbstractAD.this.setDownAPPConfirmPolicy(AbstractAD.this.f24760e);
                                        }
                                        AbstractAD.this.a((AbstractAD) AbstractAD.this.f24758c);
                                    } catch (Throwable th) {
                                        GDTLogger.e("Exception while init Core", th);
                                        AbstractAD.a(AbstractAD.this, true);
                                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                        AbstractAD.this.a(basicADListener, 2001);
                                    }
                                }
                            });
                            return;
                        } catch (Throwable th) {
                            GDTLogger.e("Exception while init plugin", th);
                            abstractAD = AbstractAD.this;
                            basicADListener2 = basicADListener;
                            i = 200102;
                        }
                    } else {
                        GDTLogger.e("Fail to init ADManager");
                        abstractAD = AbstractAD.this;
                        basicADListener2 = basicADListener;
                        i = 200101;
                    }
                    abstractAD.a(basicADListener2, i);
                }
            });
        } else {
            GDTLogger.e("Required Activity/Service/Permission not declared in AndroidManifest.xml");
            a(basicADListener2, LicenseErrCode.ERROR_NETWORK_ERROR);
        }
    }

    public void a(BasicADListener basicADListener, int i) {
        if (basicADListener != null) {
            basicADListener.onNoAD(a.a(i));
        }
    }

    protected abstract void a(T t);

    public final boolean b() {
        return this.f24756a;
    }

    public final boolean c() {
        return this.f24757b;
    }

    public void setBrowserType(BrowserType browserType) {
        this.f24759d = browserType;
        T t = this.f24758c;
        if (t == null || browserType == null) {
            return;
        }
        t.setBrowserType(browserType.value());
    }

    public void setDownAPPConfirmPolicy(DownAPPConfirmPolicy downAPPConfirmPolicy) {
        this.f24760e = downAPPConfirmPolicy;
        T t = this.f24758c;
        if (t == null || downAPPConfirmPolicy == null) {
            return;
        }
        t.setDownAPPConfirmPolicy(downAPPConfirmPolicy);
    }
}
