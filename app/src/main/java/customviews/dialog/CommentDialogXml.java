package customviews.dialog;

import android.content.Context;
import android.graphics.Color;
import android.widget.Button;
import android.widget.TextView;

import com.myt360.app.customviews.MyRelativeLayout;

/**
 * Created by guoyang on 16/9/18.
 */
public class CommentDialogXml extends MyRelativeLayout {



    public Button sure_Button;
    public  Button cancel_Button;
    public CommentDialogXml(Context context, float pro, float screenW, float screenH) {
        super(context, pro, screenW, screenH);
    this.setBackgroundResource(R.getRCode("drawable", "coner"));

        TextView title_TextView=productTextView(context,pro,21,LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT,
                0,0,0,0,
                0,CENTER_HORIZONTAL,0,
                0,0,0,0,
                12,12,0,0,
                "温馨提示",13,"#2d2d2d",this);

        TextView refresh_TextView=productTextView(context,pro,22,LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT,
                0,0,0,title_TextView.getId(),
                0,CENTER_HORIZONTAL,0,
                0,0,0,0,
                0,12,0,0,
                "新版本更新。",12,"#2d2d2d",this);


        //question_btn_selector
        cancel_Button = productButton(context, pro, 23, 90, 30,
                0, 0, 0, refresh_TextView.getId(),
                0, 0, 0,
                0, 10, 0, 0, "取消", 14, "#ffffff", this);
        cancel_Button.setBackgroundColor(Color.parseColor("#f1f1f1"));


        sure_Button = productButton(context, pro, 24, 90, 30,
                0, cancel_Button.getId(), 0, refresh_TextView.getId(),
                0, 0, 0,
                0, 10, 0, 0, "确定", 14, "#ffffff", this);
        sure_Button.setBackgroundColor(Color.parseColor("#6ccfa9"));


//        productView(context, pro, 25,
//                1, 1,
//                0, 0, 0, sure_Button.getId(),
//                0, CENTER_HORIZONTAL, 0,
//                0, 0, 0, 0,
//                0, 10, 0, 0, this)
//                .setBackgroundColor(Color.parseColor("#f0f0f0"));


    }
}
