package componetdemo.xiangyao.com.coordintorlayoutdemo.widght;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

public class PingFangSCRegularTextView extends android.support.v7.widget.AppCompatTextView {
    public PingFangSCRegularTextView(Context context) {
        super(context);
        initTypeFace(context);
    }

    public PingFangSCRegularTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initTypeFace(context);
    }

    public PingFangSCRegularTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initTypeFace(context);
    }

    void initTypeFace(Context context) {
        Typeface typeface1 = Typeface.createFromAsset(context.getAssets(), "PingFangSC_Regular.otf");
        setTypeface(typeface1);
    }
}
