

import common.java.security.codec;
import org.apache.kafka.common.protocol.types.Field;
import org.json.simple.JSONObject;

public class test1Ad {
    public static void main(String[] args) {
   /*     String  str ="{\n" +
                "    \"_id\" : ObjectId(\"592eaa451a4769cbf5ae25f3\"),\n" +
                "    \"adtype\" : NumberLong(2),\n" +
                "    \"imgURL\" : \"\\\\File\\\\upload\\\\2017-05-05\\\\zttp01.jpg\",\n" +
                "    \"uPlv\" : NumberLong(2000),\n" +
                "    \"adname\" : \"test\",\n" +
                "    \"dPlv\" : NumberLong(3000),\n" +
                "    \"rPlv\" : NumberLong(1000),\n" +
                "    \"linkURL\" : \"\",\n" +
                "    \"addesp\" : \"123\",\n" +
                "    \"width\" : \"123\",\n" +
                "    \"height\" : \"123\",\n" +
                "    \"wbid\" : \"59301f571a4769cbf5b0a0dd\",\n" +
                "    \"data\" : \"[{\\\"img\\\":\\\"http://www.jq22.com/demo/slide20160105/img/bleck.jpg\\\",\\\"text\\\":\\\"321\\\",\\\"url\\\":\\\"321\\\"},{\\\"img\\\":\\\"http://www.jq22.com/demo/slide20160105/img/white.jpg\\\",\\\"text\\\":\\\"123\\\",\\\"url\\\":\\\"123\\\"}]\"\n" +
                "}";*/
//        String str ="{\"_id\":\"59ad5dedc6c2040278e70a141\",\"adtype\":\"0\",\"d\":3000,\"data\":\"\",\"adsid\":\"0\",\"imgURL\":\"\",\"wbid\":\"59301f571a4769cbf5b0a0dd\",\"r\":1000,\"adheight\":\"100\",\"adname\":\"头部广告\",\"u\":2000,\"addesp\":\"123\",\"width\":\"123\",\"linkURL\":\"\",\"adwidth\":\"100\",\"height\":\"123\"}";
     // String str ="{\"d\":3000,\"data\":\"\",\"adsid\":\"0\",\"imgURL\":\"\",\"wbid\":\"59301f571a4769cbf5b0a0dd\",\"r\":1000,\"adheight\":\"100\",\"adname\":\"头部广告\",\"u\":2000,\"addesp\":\"123\",\"width\":\"123\",\"linkURL\":\"\",\"adwidth\":\"100\",\"height\":\"123\"}";
    	String str ="{\"_id\":\"5a2d43c93342d90e04081c51\",\"pptImage\":\"\",\"filetype\":3,\"userid\":\"\",\"fileoldname\":\"2016年度全国会计专业技术中级资格无纸化考试系统数学公式操作建议及公式和符号输入方法介绍.doc\",\"wbid\":\"59301f571a4769cbf5b0a0dd\",\"filenewname\":\"2016年度全国会计专业技术中级资格无纸化考试系统数学公式操作建议及公式和符号输入方法介绍.doc\",\"size\":109056,\"filepath\":\"/Filebase/File/2016090714450756382016年度全国会计专业技术中级资格无纸化考试系统数学公式操作建议及公式和符号输入方法介绍.doc\",\"fileextname\":\"doc\",\"ThumbnailImage\":\"\",\"fatherid\":\"\",\"isdelete\":0,\"time\":1512915913001,\"MD5\":\"\"}";
    	String encodeFastJSON = codec.encodeFastJSON(str);
    	String t = null;
    	if(t == null){
    		System.out.println("ok");
    	}
    	int i =0;
    	Long d =0L;
    	System.out.println(i==d);
        System.out.println(encodeFastJSON);
    }
}