package com.atdecap.springbootbackstage.controller;
import com.atdecap.springbootbackstage.common.Constants;
import com.atdecap.springbootbackstage.common.Result;
import com.atdecap.springbootbackstage.entity.Dict;
import com.atdecap.springbootbackstage.mapper.DictMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.atdecap.springbootbackstage.service.IMenuService;
import com.atdecap.springbootbackstage.entity.Menu;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Decap
 * @since 2022-05-26
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

        @Resource
        private IMenuService menuService;

        @Resource
        private DictMapper dictMapper;

        // 新增或者更新
        @PostMapping
        public Result save(@RequestBody Menu menu) {
                menuService.saveOrUpdate(menu);
                return Result.success();
        }

        @DeleteMapping("/{id}")
        public Result delete(@PathVariable Integer id) {
                menuService.removeById(id);
                return Result.success();
        }

        @PostMapping("/del/batch")
        public Result deleteBatch(@RequestBody List<Integer> ids) {
                menuService.removeByIds(ids);
                return Result.success();
        }

        @GetMapping("/ids")
        public Result findAllIds() {
                return Result.success(menuService.list().stream().map(Menu::getId));
        }

        @GetMapping
        public Result findAll(@RequestParam(defaultValue = "") String name) {
                return Result.success(menuService.findMenus(name));
        }

        @GetMapping("/{id}")
        public Result findOne(@PathVariable Integer id) {
                return Result.success(menuService.getById(id));
        }

        @GetMapping("/page")
        public Result findPage(@RequestParam String name,
                               @RequestParam Integer pageNum,
                               @RequestParam Integer pageSize) {
                QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
                queryWrapper.like("name", name);
                queryWrapper.orderByDesc("id");
                return Result.success(menuService.page(new Page<>(pageNum, pageSize), queryWrapper));
        }

        @GetMapping("/icons")
        public Result getIcons() {
                QueryWrapper<Dict> queryWrapper = new QueryWrapper<>();
                queryWrapper.eq("type", Constants.DICT_TYPE_ICON);
                return Result.success(dictMapper.selectList(queryWrapper));
        }

}

