package com.htx.common.image.rest;

import com.htx.vo.ResVo;
import com.htx.vo.constants.StatusEnum;
import com.htx.permission.Permission;
import com.htx.permission.UserRole;
import com.htx.image.service.ImageService;
import com.htx.common.image.vo.ImageVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 微信搜索「二哈学习之路」
 * 图片服务，要求登录之后才允许操作
 * @author htx
 * @date 2024/8/24 23:21
 */
@Permission(role = UserRole.LOGIN)
@RequestMapping(path = {"image/", "admin/image/", "api/admin/image/",})
@RestController
@Slf4j
public class ImageRestController {

    @Autowired
    private ImageService imageService;

    /**
     * 图片上传
     *
     * @return
     */

    @RequestMapping(path = "upload")
    public ResVo<ImageVo> upload(HttpServletRequest request) {
        ImageVo imageVo = new ImageVo();
        try {
            String imagePath = imageService.saveImg(request);
            imageVo.setImagePath(imagePath);
        } catch (Exception e) {
            log.error("save upload file error!", e);
            return ResVo.fail(StatusEnum.UPLOAD_PIC_FAILED);
        }
        return ResVo.ok(imageVo);
    }

    /**
     * 转存图片
     *
     * @param imgUrl
     * @return
     */
    @RequestMapping(path = "save")
    public ResVo<ImageVo> save(@RequestParam(name = "img", defaultValue = "") String imgUrl) {
        ImageVo imageVo = new ImageVo();
        if (StringUtils.isBlank(imgUrl)) {
            return ResVo.ok(imageVo);
        }

        String url = imageService.saveImg(imgUrl);
        imageVo.setImagePath(url);
        return ResVo.ok(imageVo);
    }
}
