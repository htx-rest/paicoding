package com.htx.admin.rest;

import com.htx.vo.ResVo;
import com.htx.vo.statistics.dto.StatisticsCountDTO;
import com.htx.vo.statistics.dto.StatisticsDayDTO;
import com.htx.permission.Permission;
import com.htx.permission.UserRole;
import com.htx.statistics.service.StatisticsSettingService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 微信搜索「二哈学习之路」
 * 数据统计后台
 * @author htx
 * @date 2024/8/24 22:22
 */
@RestController
@Permission(role = UserRole.LOGIN)
@Api(value = "全栈统计分析控制器", tags = "统计分析")
@RequestMapping(path = {"api/admin/statistics/", "admin/statistics/"})
public class StatisticsSettingRestController {

    @Autowired
    private StatisticsSettingService statisticsSettingService;

    static final Integer DEFAULT_DAY = 7;

    @GetMapping(path = "queryTotal")
    public ResVo<StatisticsCountDTO> queryTotal() {
        StatisticsCountDTO statisticsCountDTO = statisticsSettingService.getStatisticsCount();
        return ResVo.ok(statisticsCountDTO);
    }

    @ResponseBody
    @GetMapping(path = "pvUvDayList")
    public ResVo<List<StatisticsDayDTO>> pvUvDayList(@RequestParam(name = "day", required = false) Integer day) {
        day = (day == null || day == 0) ? DEFAULT_DAY : day;
        List<StatisticsDayDTO> pvDayList = statisticsSettingService.getPvUvDayList(day);
        return ResVo.ok(pvDayList);
    }

}

