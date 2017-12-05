package com.gizwits.swagger2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kevinchen on 2016/12/14.
 */
@Data
@NoArgsConstructor
@ConfigurationProperties(prefix = "swagger2")
public class ApiInfoProperties {
    /**是否开启swagger**/
    private Boolean enabled;
    /**版本**/
    private String version = "";
    /**标题**/
    private String title = "";
    /**描述**/
    private String description = "";
    /**服务条款URL**/
    private String termsOfServiceUrl = "";
    /**许可证**/
    private String license = "";
    /**许可证URL**/
    private String licenseUrl = "";
    /**联系方式**/
    private Contact contact;
    /**swagger会解析的包路径**/
    private String basepackage = "";
    /**权限验证、消息头前置名称*/
    private String keyname;
    /**swagger会解析的url规则**/
    private List<String> basePath = new ArrayList<>();
    /**在basePath基础上需要排除的url规则**/
    private List<String> excludePath = new ArrayList<>();
    /**分组文档**/
    private Map<String, DocketInfo> groupDocket = new LinkedHashMap<>();
    /**host信息**/
    private String host = "";



    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DocketInfo {
        /**标题**/
        private String title = "";
        /**描述**/
        private String description = "";
        /**版本**/
        private String version = "";
        /**许可证**/
        private String license = "";
        /**许可证URL**/
        private String licenseUrl = "";
        /**服务条款URL**/
        private String termsOfServiceUrl = "";
        /**联系方式**/
        private Contact contact = new Contact();
        /**swagger会解析的包路径**/
        private String basePackage = "";
        /**权限验证、消息头前置名称*/
        private String keyname;
        /**swagger会解析的url规则**/
        private List<String> basePath = new ArrayList<>();
        /**在basePath基础上需要排除的url规则**/
        private List<String> excludePath = new ArrayList<>();

        public springfox.documentation.service.Contact getServiceContact(){
            return new springfox.documentation.service.Contact(
                    this.contact.name,this.contact.url,this.contact.email);
        }

    }

    @Data
    @NoArgsConstructor
    public static class Contact {
        private String name = "";
        private String url = "";
        private String email = "";
    }


    /**
     * 是否有分组？ ture:没有 false:有
     * @return
     */
    public boolean isEmptyGroup(){
        return groupDocket.size()==0;
    }

    /**
     * 在没有文组文档的情况下 构造默认分组文档
     * 指定默认的分组名称 groupName = "defaultDocket"
     */
    public void constructGroupDocket(){
        if (groupDocket.size()>0)
            return;
        DocketInfo docketInfo = new DocketInfo(title,description,version,
                license,licenseUrl,termsOfServiceUrl,contact,basepackage,keyname,
                basePath,excludePath);
        groupDocket.put("defaultDocket",docketInfo);
    }



}
