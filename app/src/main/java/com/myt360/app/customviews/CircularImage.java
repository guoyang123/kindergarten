package com.myt360.app.customviews;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import cn.com.iucd.iucdframe.utils.DensityUtil;

public class CircularImage extends MaskedImage{

	Context context;
	private float pro;
	float f3;
	public CircularImage(Context paramContext,float pro) {
		super(paramContext);
		this.context=paramContext;
		this.pro=pro;
		f3=(DensityUtil.dip2px(context,2)*pro);
	}

	public CircularImage(Context paramContext, AttributeSet paramAttributeSet) {
		super(paramContext, paramAttributeSet);
		this.context=paramContext;
		
	}

	public CircularImage(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
		super(paramContext, paramAttributeSet, paramInt);
		this.context=paramContext;
	}
	

	public Bitmap createMask() {
		int i = getWidth();
		int j = getHeight();
		Bitmap.Config localConfig = Bitmap.Config.ARGB_8888;
		Bitmap localBitmap = Bitmap.createBitmap(i, j, localConfig);
		Canvas localCanvas = new Canvas(localBitmap);
		Paint localPaint = new Paint(1);
		localPaint.setColor(-16777216);
		float f1 = getWidth();
		float f2 = getHeight();
		
		RectF localRectF = new RectF(f3, f3, f1-f3, f2-f3);
		localCanvas.drawOval(localRectF, localPaint);
		return localBitmap;
	}
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		 Rect rec=canvas.getClipBounds();
	      Paint paint=new Paint();
	      paint.setColor(Color.WHITE);
	      paint.setStyle(Paint.Style.STROKE);
	      paint.setAntiAlias(true);
	      paint.setStrokeWidth((int)(DensityUtil.dip2px(context,2)*pro));
	      canvas.drawCircle(rec.right/2, rec.right/2, (rec.right-f3)/2, paint);
	}
}
