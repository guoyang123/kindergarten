package com.tour.app.sign;

import com.kinder.notice.model.JoinModel;

public interface SignDialogListener {

	int SURE_BUTTON=1;//点击确定
	int CANCEL_BUTTON=2;//点击取消
	void onClickBtn(JoinModel model);
}
