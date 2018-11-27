package componetdemo.xiangyao.com.coordintorlayoutdemo.widght;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

public class MediciTextView extends android.support.v7.widget.AppCompatTextView {
    public MediciTextView(Context context) {
        super(context);
        initTypeFace(context);
    }

    public MediciTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initTypeFace(context);
    }

    public MediciTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initTypeFace(context);
    }

    void initTypeFace(Context context) {
        Typeface typeface1 = Typeface.createFromAsset(context.getAssets(), "Medici_Text.ttf");
        setTypeface(typeface1);
    }
}
