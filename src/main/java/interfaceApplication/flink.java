package interfaceApplication;

import org.bson.types.ObjectId;

import common.java.JGrapeSystem.rMsg;
import common.java.apps.appsProxy;
import common.java.check.checkHelper;
import common.java.database.dbFilter;
import common.java.interfaceModel.GrapeDBDescriptionModel;
import common.java.interfaceModel.GrapePermissionsModel;
import common.java.interfaceModel.GrapeTreeDBModel;
import common.java.nlogger.nlogger;
import common.java.security.codec;
import common.java.string.StringHelper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class flink {
    private GrapeTreeDBModel flink;
    private GrapeDBDescriptionModel gDbSpecField;
    private GrapePermissionsModel permissionsModel;
    private String pkString;
    public flink() {
        flink = new GrapeTreeDBModel();
        gDbSpecField = new GrapeDBDescriptionModel();
        gDbSpecField.importDescription(appsProxy.tableConfig("flink"));
        flink.descriptionModel(gDbSpecField);
        pkString =flink.getPk();
        permissionsModel = new GrapePermissionsModel();
        permissionsModel.importDescription(appsProxy.tableConfig("flink"));
        flink.permissionsModel(permissionsModel);
        flink.checkMode();
    }

    /**
     * 新增友情链接
     * 
     * @param info
     * @return
     */
    @SuppressWarnings("unchecked")
    public String flinkAdd(String info) {
    	JSONObject object =JSONObject.toJSON(codec.DecodeFastJSON(info));
    	int code =  flink.data(object).insertEx() instanceof Object ?0:100;
        return rMsg.netMSG(code,code>0?"友情链接新增失败":"友情链接新增成功");
    }

    /**
     * 修改友链
     * 
     * @param mid
     * @param msgInfo
     * @return
     */
    public String UpdateFlink(String mid, String msgInfo) {
    	JSONObject object =JSONObject.toJSON(codec.DecodeFastJSON(msgInfo));
        int code =0;
        if(!StringHelper.InvaildString(mid)){
        System.out.println(flink.eq(pkString,mid).data(object).updateEx());
          code =  flink.eq(pkString,mid).data(object).updateEx()?0:99;
        }
        return  rMsg.netMSG(code, code>0?"友情链接修改失败":"友情链接修改成功");
    }

    /**
     * 删除友链
     * 
     * @param mid
     * @return
     */
    public String DeleteFlink(String mid) {
        return DeleteBatchFlink(mid);
    }

    /**
     * 批量删除友链
     * 
     * @param mids
     * @return
     */
    public String DeleteBatchFlink(String mids) {
        long code = 100;
        String[] value = null;
        String result = rMsg.netMSG(100, "友情链接删除失败");
        if (!StringHelper.InvaildString(mids)) {
            value = mids.split(",");
            if (value != null && value.length>0) {
            	flink.or();
            	for (String id : value) {
            		 flink.eq(pkString, id);
            	}
            	code = flink.deleteAllEx();
            	System.out.println(code);
            }
        }
        return code==value.length ? rMsg.netMSG(0, "友情链接删除成功") : result;
    }

    /**
     * 搜索友链
     * 
     * @param msgInfo
     * @return
     */
    public String SearchFlink(String msgInfo) {
        JSONArray array = null;
        JSONArray condArray = buildCond(msgInfo);
        System.out.println(condArray);
        if (condArray != null && condArray.size() > 0) {
            array = flink.where(condArray).select();
        }
        return rMsg.netMSG(true, (array != null && array.size() > 0) ? array : new JSONArray());
    }

    /**
     * 分页
     * 
     * @param idx
     * @param pageSize
     * @return
     */
    public String PageFlink(int idx, int pageSize) {
        return PageByFlink(idx, pageSize, null);
    }

    /**
     * 条件分页
     * 
     * @param idx
     * @param pageSize
     * @param msgInfo
     * @return
     */
    public String PageByFlink(int idx, int pageSize, String msgInfo) {
        long total = 0;
        JSONArray array = null;
     //   if (StringHelper.InvaildString(msgInfo)) {
        if(null!=msgInfo && msgInfo.equals("")){
            JSONArray condArray = buildCond(msgInfo);
            if (condArray != null && condArray.size() > 0) {
                flink.where(condArray);
            } else {
                return rMsg.netMSG(1, "无效参数");
            }
        }
        array = flink.dirty().page(idx, pageSize);
        total = flink.count();
        return rMsg.netPAGE(idx, pageSize, total, (array != null && array.size() > 0) ? array : new JSONArray());
    }

    /**
     * 查询所属某个网站的flink
     * 
     * @param wbid
     * @return
     */
    public String findLink(String wbid) {
        JSONArray array = flink.eq("wbid", wbid).select();
        return rMsg.netMSG(true, (array != null && array.size() > 0) ? array : new JSONArray());

    }

    /**
     * 查询
     * 
     * @param linkid
     * @return
     */
    private JSONObject find(String linkid) {
        JSONObject object = null;
        try {
            object = flink.eq(pkString, linkid).find();
        } catch (Exception e) {
            nlogger.logout(e);
            object = null;
        }
        return (object != null && object.size() > 0) ? object : new JSONObject();
    }
    
    /**
     * 整合参数，将JSONObject类型的参数封装成JSONArray类型
     * 
     * @param object
     * @return
     */
    public JSONArray buildCond(String Info) {
    	JSONObject object =JSONObject.toJSON(Info);
        String key;
        Object value;
        JSONArray condArray = null;
        dbFilter filter = new dbFilter();
        if (object != null && object.size() > 0) {
            for (Object object2 : object.keySet()) {
                key = object2.toString();
                value = object.get(key);
                filter.eq(key, value);
            }
            condArray = filter.build();
        } else {
            condArray = JSONArray.toJSONArray(Info);
        }
        return condArray;
    }
}
