package com.yanghaoyi.mywidget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import android.widget.Toast;

/**
 * @author : YangHaoYi on 2018/6/26.
 *         Email  :  yang.haoyi@qq.com
 *         Description :
 *         Change : YangHaoYi on 2018/6/26.
 *         Version : V 1.0
 */
public class WidgetProviderClass extends AppWidgetProvider{

    public static final String BUTTON_ACTION = "com.yanghaoyi.action.TYPE_TOAST";

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        RemoteViews  remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget_layout);
        Intent intent = new Intent(BUTTON_ACTION);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        remoteViews.setOnClickPendingIntent(R.id.tvShowToast, pendingIntent);
        appWidgetManager.updateAppWidget(appWidgetIds[0], remoteViews);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        switch (intent.getAction()) {
            case BUTTON_ACTION:
                Toast.makeText(context, "窗口部件点击", Toast.LENGTH_SHORT).show();
                break;
        }
        super.onReceive(context, intent);

    }
}
