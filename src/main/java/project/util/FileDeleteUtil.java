package project.util;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 杨乔瀚
 * @create 2020/11/30 - 21:33
 */
public class FileDeleteUtil {


    public static boolean deleteFile(String folder01,String fileName){
        //遍历存放照片磁盘下的所有文件，知道对应文件名删除
        File folder = new File(folder01);
        File[] files = folder.listFiles();
        Map<String, Object> result = new HashMap<>();
        for (File file : files) {
            String currentFileName = file.getName();
            if (currentFileName.equals(fileName)) {
                //成功删除照片
                file.delete();
                //在磁盘成功删除文件后，还需要在数据库更新照片网络和磁盘地址为空，不然文件上传报错后不能显示文件框
//                appInfo.setLogoWebPath("");
//                appInfo.setLogoLocPath("");
//                appInfoService.modifyAppInfoById(appInfo);
//                result.put("result", "success");
                return true;
            }
        }

        //删除照片失败
//        result.put("result", "failed");
        return false;
    }
}
