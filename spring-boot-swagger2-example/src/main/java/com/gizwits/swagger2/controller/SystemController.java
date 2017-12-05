package com.gizwits.swagger2.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 系统信息
 *
 * @author Feel
 * @date 2017/11/1
 * @email fye@gizwits.com
 * @since 1.0
 */
@RestController
@Api(value = "system", description = "系统信息", tags = {"system"})
@RequestMapping("/api/v1/sys")
public class SystemController {



    @GetMapping("/error/code")
    @ApiOperation(value = "错误码列表", notes = "错误码列表")
    public String getErrors() {
        return "errors codes ";
    }

    @PostMapping("/status/version")
    @ApiOperation(value = "版本号", notes = "版本号")
    public String getVersions() {
        return "version 1.0";
    }
}
