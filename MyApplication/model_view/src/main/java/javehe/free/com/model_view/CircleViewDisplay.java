package javehe.free.com.model_view;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by zhangfengcheng on 2017/3/4.
 */

public class CircleViewDisplay extends View {

    private final String TAG = "CircleViewDisplay";
    private Context context;
    private Paint mPaint;
    private int paddingTop;
    private int paddingBottom;
    private int paddingLeft;
    private int paddingRight;
    private int width;
    private int height;
    private int radius;

    public CircleViewDisplay(Context context) {
        this(context , null);
    }

    public CircleViewDisplay(Context context, AttributeSet attrs) {
        this(context, attrs , 0);
    }

    public CircleViewDisplay(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init();
    }

    public CircleViewDisplay(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        width = getWidth();
        height = getHeight();

        if (radius <= 0){
            Log.e(TAG , "illegal parameters");
            return;
        }

        paddingTop = getPaddingTop();
        paddingBottom = getPaddingBottom();
        paddingLeft = getPaddingLeft();
        paddingRight = getPaddingRight();

        radius = Math.min((width - paddingLeft - paddingRight)/2 , (height - paddingBottom - paddingTop)/2);

         mPaint.setColor(Color.BLUE);
         canvas.drawRect(paddingLeft, paddingTop, width - paddingLeft - paddingRight, height - paddingBottom - paddingTop,mPaint);
         drawPadding(canvas);
         mPaint.setColor(Color.RED);
         canvas.drawCircle((width - paddingLeft - paddingRight)/2 , (height - paddingBottom - paddingTop)/2 , radius,mPaint);
    }

    private void drawPadding(Canvas canvas) {
        mPaint.setColor(Color.WHITE);
        canvas.drawRect(0 ,0 , paddingLeft ,height,mPaint);
        canvas.drawRect(paddingLeft ,0 ,width - paddingLeft - paddingRight ,paddingTop,mPaint);
    }
}
