package customviews.dialog;

import cn.kinder.bean.Kinder_DataSource;

/**
 * Created by guoyang on 16/10/20.
 */
public class CheckVersionModel extends Kinder_DataSource {


    private String downloadUrl;//下载url

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }
}
