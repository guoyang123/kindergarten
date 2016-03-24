package com.tour.app.safecode;

public interface SafeCodeDialogListener {

	int CAMERA_BUTTON=1;//点击拍照
	int SURE_BUTTON=2;//点击确定
	void onClickBtn(int position, String[] codes);
}
