package android.support.v4.app;

import android.app.Notification;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class NotificationCompatBuilder implements NotificationBuilderWithBuilderAccessor {

    /* renamed from: a */
    private final Notification.Builder f977a;

    /* renamed from: b */
    private final NotificationCompat.Builder f978b;

    /* renamed from: c */
    private RemoteViews f979c;

    /* renamed from: d */
    private RemoteViews f980d;

    /* renamed from: e */
    private final List<Bundle> f981e = new ArrayList();

    /* renamed from: f */
    private final Bundle f982f = new Bundle();

    /* renamed from: g */
    private int f983g;

    /* renamed from: h */
    private RemoteViews f984h;

    public NotificationCompatBuilder(NotificationCompat.Builder builder) {
        ArrayList<String> arrayList;
        this.f978b = builder;
        if (Build.VERSION.SDK_INT >= 26) {
            this.f977a = new Notification.Builder(builder.mContext, builder.F);
        } else {
            this.f977a = new Notification.Builder(builder.mContext);
        }
        Notification notification = builder.K;
        this.f977a.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, builder.f936e).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(builder.f932a).setContentText(builder.f933b).setContentInfo(builder.f938g).setContentIntent(builder.f934c).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(builder.f935d, (notification.flags & 128) != 0).setLargeIcon(builder.f937f).setNumber(builder.f939h).setProgress(builder.o, builder.p, builder.q);
        if (Build.VERSION.SDK_INT < 21) {
            this.f977a.setSound(notification.sound, notification.audioStreamType);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            this.f977a.setSubText(builder.m).setUsesChronometer(builder.k).setPriority(builder.i);
            Iterator<NotificationCompat.Action> it = builder.mActions.iterator();
            while (it.hasNext()) {
                a(it.next());
            }
            Bundle bundle = builder.y;
            if (bundle != null) {
                this.f982f.putAll(bundle);
            }
            if (Build.VERSION.SDK_INT < 20) {
                if (builder.u) {
                    this.f982f.putBoolean(NotificationCompatExtras.EXTRA_LOCAL_ONLY, true);
                }
                String str = builder.r;
                if (str != null) {
                    this.f982f.putString(NotificationCompatExtras.EXTRA_GROUP_KEY, str);
                    if (builder.s) {
                        this.f982f.putBoolean(NotificationCompatExtras.EXTRA_GROUP_SUMMARY, true);
                    } else {
                        this.f982f.putBoolean(NotificationManagerCompat.EXTRA_USE_SIDE_CHANNEL, true);
                    }
                }
                String str2 = builder.t;
                if (str2 != null) {
                    this.f982f.putString(NotificationCompatExtras.EXTRA_SORT_KEY, str2);
                }
            }
            this.f979c = builder.C;
            this.f980d = builder.D;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            this.f977a.setShowWhen(builder.j);
            if (Build.VERSION.SDK_INT < 21 && (arrayList = builder.mPeople) != null && !arrayList.isEmpty()) {
                Bundle bundle2 = this.f982f;
                ArrayList<String> arrayList2 = builder.mPeople;
                bundle2.putStringArray(NotificationCompat.EXTRA_PEOPLE, (String[]) arrayList2.toArray(new String[arrayList2.size()]));
            }
        }
        if (Build.VERSION.SDK_INT >= 20) {
            this.f977a.setLocalOnly(builder.u).setGroup(builder.r).setGroupSummary(builder.s).setSortKey(builder.t);
            this.f983g = builder.J;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            this.f977a.setCategory(builder.x).setColor(builder.z).setVisibility(builder.A).setPublicVersion(builder.B).setSound(notification.sound, notification.audioAttributes);
            Iterator<String> it2 = builder.mPeople.iterator();
            while (it2.hasNext()) {
                this.f977a.addPerson(it2.next());
            }
            this.f984h = builder.E;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            this.f977a.setExtras(builder.y).setRemoteInputHistory(builder.n);
            RemoteViews remoteViews = builder.C;
            if (remoteViews != null) {
                this.f977a.setCustomContentView(remoteViews);
            }
            RemoteViews remoteViews2 = builder.D;
            if (remoteViews2 != null) {
                this.f977a.setCustomBigContentView(remoteViews2);
            }
            RemoteViews remoteViews3 = builder.E;
            if (remoteViews3 != null) {
                this.f977a.setCustomHeadsUpContentView(remoteViews3);
            }
        }
        if (Build.VERSION.SDK_INT >= 26) {
            this.f977a.setBadgeIconType(builder.G).setShortcutId(builder.H).setTimeoutAfter(builder.I).setGroupAlertBehavior(builder.J);
            if (builder.w) {
                this.f977a.setColorized(builder.v);
            }
            if (TextUtils.isEmpty(builder.F)) {
                return;
            }
            this.f977a.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
        }
    }

    private void a(NotificationCompat.Action action) {
        Bundle bundle;
        int i = Build.VERSION.SDK_INT;
        if (i < 20) {
            if (i >= 16) {
                this.f981e.add(NotificationCompatJellybean.writeActionAndGetExtras(this.f977a, action));
                return;
            }
            return;
        }
        Notification.Action.Builder builder = new Notification.Action.Builder(action.getIcon(), action.getTitle(), action.getActionIntent());
        if (action.getRemoteInputs() != null) {
            for (android.app.RemoteInput remoteInput : RemoteInput.a(action.getRemoteInputs())) {
                builder.addRemoteInput(remoteInput);
            }
        }
        if (action.getExtras() != null) {
            bundle = new Bundle(action.getExtras());
        } else {
            bundle = new Bundle();
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", action.getAllowGeneratedReplies());
        if (Build.VERSION.SDK_INT >= 24) {
            builder.setAllowGeneratedReplies(action.getAllowGeneratedReplies());
        }
        builder.addExtras(bundle);
        this.f977a.addAction(builder.build());
    }

    public Notification build() {
        Bundle extras;
        RemoteViews makeHeadsUpContentView;
        RemoteViews makeBigContentView;
        NotificationCompat.Style style = this.f978b.l;
        if (style != null) {
            style.apply(this);
        }
        RemoteViews makeContentView = style != null ? style.makeContentView(this) : null;
        Notification a2 = a();
        if (makeContentView != null) {
            a2.contentView = makeContentView;
        } else {
            RemoteViews remoteViews = this.f978b.C;
            if (remoteViews != null) {
                a2.contentView = remoteViews;
            }
        }
        if (Build.VERSION.SDK_INT >= 16 && style != null && (makeBigContentView = style.makeBigContentView(this)) != null) {
            a2.bigContentView = makeBigContentView;
        }
        if (Build.VERSION.SDK_INT >= 21 && style != null && (makeHeadsUpContentView = this.f978b.l.makeHeadsUpContentView(this)) != null) {
            a2.headsUpContentView = makeHeadsUpContentView;
        }
        if (Build.VERSION.SDK_INT >= 16 && style != null && (extras = NotificationCompat.getExtras(a2)) != null) {
            style.addCompatExtras(extras);
        }
        return a2;
    }

    @Override // android.support.v4.app.NotificationBuilderWithBuilderAccessor
    public Notification.Builder getBuilder() {
        return this.f977a;
    }

    protected Notification a() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            return this.f977a.build();
        }
        if (i >= 24) {
            Notification build = this.f977a.build();
            if (this.f983g != 0) {
                if (build.getGroup() != null && (build.flags & 512) != 0 && this.f983g == 2) {
                    a(build);
                }
                if (build.getGroup() != null && (build.flags & 512) == 0 && this.f983g == 1) {
                    a(build);
                }
            }
            return build;
        }
        if (i >= 21) {
            this.f977a.setExtras(this.f982f);
            Notification build2 = this.f977a.build();
            RemoteViews remoteViews = this.f979c;
            if (remoteViews != null) {
                build2.contentView = remoteViews;
            }
            RemoteViews remoteViews2 = this.f980d;
            if (remoteViews2 != null) {
                build2.bigContentView = remoteViews2;
            }
            RemoteViews remoteViews3 = this.f984h;
            if (remoteViews3 != null) {
                build2.headsUpContentView = remoteViews3;
            }
            if (this.f983g != 0) {
                if (build2.getGroup() != null && (build2.flags & 512) != 0 && this.f983g == 2) {
                    a(build2);
                }
                if (build2.getGroup() != null && (build2.flags & 512) == 0 && this.f983g == 1) {
                    a(build2);
                }
            }
            return build2;
        }
        if (i >= 20) {
            this.f977a.setExtras(this.f982f);
            Notification build3 = this.f977a.build();
            RemoteViews remoteViews4 = this.f979c;
            if (remoteViews4 != null) {
                build3.contentView = remoteViews4;
            }
            RemoteViews remoteViews5 = this.f980d;
            if (remoteViews5 != null) {
                build3.bigContentView = remoteViews5;
            }
            if (this.f983g != 0) {
                if (build3.getGroup() != null && (build3.flags & 512) != 0 && this.f983g == 2) {
                    a(build3);
                }
                if (build3.getGroup() != null && (build3.flags & 512) == 0 && this.f983g == 1) {
                    a(build3);
                }
            }
            return build3;
        }
        if (i >= 19) {
            SparseArray<Bundle> buildActionExtrasMap = NotificationCompatJellybean.buildActionExtrasMap(this.f981e);
            if (buildActionExtrasMap != null) {
                this.f982f.putSparseParcelableArray(NotificationCompatExtras.EXTRA_ACTION_EXTRAS, buildActionExtrasMap);
            }
            this.f977a.setExtras(this.f982f);
            Notification build4 = this.f977a.build();
            RemoteViews remoteViews6 = this.f979c;
            if (remoteViews6 != null) {
                build4.contentView = remoteViews6;
            }
            RemoteViews remoteViews7 = this.f980d;
            if (remoteViews7 != null) {
                build4.bigContentView = remoteViews7;
            }
            return build4;
        }
        if (i >= 16) {
            Notification build5 = this.f977a.build();
            Bundle extras = NotificationCompat.getExtras(build5);
            Bundle bundle = new Bundle(this.f982f);
            for (String str : this.f982f.keySet()) {
                if (extras.containsKey(str)) {
                    bundle.remove(str);
                }
            }
            extras.putAll(bundle);
            SparseArray<Bundle> buildActionExtrasMap2 = NotificationCompatJellybean.buildActionExtrasMap(this.f981e);
            if (buildActionExtrasMap2 != null) {
                NotificationCompat.getExtras(build5).putSparseParcelableArray(NotificationCompatExtras.EXTRA_ACTION_EXTRAS, buildActionExtrasMap2);
            }
            RemoteViews remoteViews8 = this.f979c;
            if (remoteViews8 != null) {
                build5.contentView = remoteViews8;
            }
            RemoteViews remoteViews9 = this.f980d;
            if (remoteViews9 != null) {
                build5.bigContentView = remoteViews9;
            }
            return build5;
        }
        return this.f977a.getNotification();
    }

    private void a(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        notification.defaults &= -2;
        notification.defaults &= -3;
    }
}
