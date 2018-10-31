package com.chen.ellen.recyclerviewitem.myview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class MyView extends View {
    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //生成一个画笔对象
        Paint paint = new Paint();
        //设置画笔的颜色为红色
        paint.setColor(Color.RED);
        //设置画笔的样式为填充
        paint.setStyle(Paint.Style.STROKE);
        //设置画笔的宽度
        paint.setStrokeWidth(50);

        //使用canvas对象画一个圆
        canvas.drawCircle(190,200,150,paint);

    }
}
