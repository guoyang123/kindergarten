package customviews.dialog;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.kinder.app.tools.KinderEventMessage;
import com.myt360.kindergarten.KinderApplication;
import com.myt360.kindergarten.R;

import cn.com.iucd.iucdframe.eventmvc.EventMessage;
import cn.com.iucd.iucdframe.utils.DensityUtil;

/**
 * Created by guoyang on 16/9/18.
 */
public class CheckVersionDialog extends DialogFragment implements View.OnClickListener{

    private EventMessage eventMessage;
    private  Object obj;
    public CheckVersionDialog(){}
    @SuppressLint("ValidFragment")
    public CheckVersionDialog(EventMessage eventMessage){
        this.eventMessage=eventMessage;

    }

   public  CommentDialogXmlView mainView;
    private KinderApplication zdApplication;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        zdApplication=(KinderApplication)getActivity().getApplication();
        setStyle(DialogFragment.STYLE_NO_FRAME, R.style.Dialog_FS);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        mainView=new CommentDialogXmlView(getActivity(),zdApplication.pro,zdApplication.screenW,zdApplication.screenH);
        mainView.sure_Button.setOnClickListener(this);
        mainView.cancel_Button.setOnClickListener(this);

        return mainView;
    }

    @Override
    public void onStart() {
        super.onStart();
        Window win = getDialog().getWindow();
        // 一定要设置Background，如果不设置，window属性设置无效

        DisplayMetrics dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics( dm );

        WindowManager.LayoutParams params = win.getAttributes();
        params.gravity = Gravity.CENTER;
        // 使用ViewGroup.LayoutParams，以便Dialog 宽度充满整个屏幕
        params.width =  (int)(DensityUtil.dip2px(getActivity(), 180) * zdApplication.getPro());
        params.height = (int)(DensityUtil.dip2px(getActivity(), 100) * zdApplication.getPro());
        win.setAttributes(params);
    }

    @Override
    public void onClick(View v) {
        if(eventMessage==null){
           return;
        }
        if(v==mainView.sure_Button){
            eventMessage.post(new KinderEventMessage(KinderEventMessage.MSG_SURE_BUTTON,null));
        }else if(v==mainView.cancel_Button){
            eventMessage.post(new KinderEventMessage(KinderEventMessage.MSG_CANCEL_BUTTON,null));
        }
    }

    public void setDatas(Object obj) {
        this.obj=obj;
    }


}
