package com.example.apaqtech.manage;

import com.example.apaqtech.manage.pojo.Sheet;
import com.example.apaqtech.manage.pojo.User;
import com.example.apaqtech.manage.service.SheetService;
import com.example.apaqtech.manage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bbook")
public class BookController {
    /**
     * 用于测试跨域配置，并不参与到实际业务逻辑中
     */

    @Autowired
    SheetService<Sheet> sheetService;
    //用泛型的话，我只需要在这里修改范型的类即可，
    // 即使代码量很多，也可以写不同的controller】，但sheetservice这里不需要更改

    @Autowired

    UserService userService;
    /**
     *
     * 下方两个PostMapping方法，通过Ajax都可以实现获取界面输入并插入数据库的功能
     * 但需注意，第二个方法  RequestParam中的参数应该和前端代码中的参数匹配,
     * 下一步应该测试如何把一个Sheet按照json对象的方式直接插入，而不是输入其各项参数
     *
     * 尽量表单各属性名和前端代码匹配，但遇到多种表单的情况可能会很麻烦
     * 因为表单有很多种，但后端代码应该只负责处理Sheet这个整体就好
     *
     * @Author 张同叔
     */
    @PostMapping("/123")
    //@CrossOrigin(value="http://localhost:8083", maxAge = 1800, allowedHeaders = "/")
    public String addBook(String sheet_name, String id, String time){
        //System.out.println(name);
        Sheet u = new Sheet();
        u.setSheet_name(sheet_name);
        u.setId(id);
        u.setTime(time);
        sheetService.insert(u);

        return " successfully inserted: " + sheet_name + " " + id+ " " + time;

    }
    @PostMapping("/sheet")
    //@ResponseBody //这句话不写好像也没事
    public String addSheet(@RequestParam("id") String id, @RequestParam("name") String name, @RequestParam("temps") String time){
        System.out.println(id + " " + name + " " + time);

        return "success";
    }

    @PostMapping("/total")
    public String total(Sheet sheet){

        /**
         *  这个可以插入，但有些属性不识别，可能是需要前端里的参数一致
         */
        sheetService.insert(sheet);
        return "success!!!";
    }

    @GetMapping("/{id}")
    //@CrossOrigin(value="http://lcoalhost:8083", maxAge = 1800, allowedHeaders = "/")
    public String deleteBookById(@PathVariable Long id){
        return String.valueOf(id);
    }

    @PostMapping("tt")
    public String tt(String name, String url){
        System.out.println(name + " " + url);
        return "receive: " + name + " " + url;
    }

    @PostMapping("/testPost")
    public String addUser(String name){
        /**
         * 这是测试视频中vue-resource的post方法的
         *
         */
        User u = new User();
        u.setName(name);
        userService.addUser(u);
        return "成功添加用户" + u.getName();

    }

    @GetMapping("/del/{id}")
    public String deleteUser(@PathVariable int id){
        /**
         * 这是测试 删除用户
         * 必须要加@PathVariable才能有效
         */

        userService.deleteUserById(id);
        return "successfully deleted id "+ id;
    }

    @PostMapping("/generic")
    public String genericTest(Sheet e){
        sheetService.insert(e);
        return "generic success!";
    }

    @GetMapping("/return")
    public List<Sheet> getAll(){
        /**
         * 该方法测试 数据库中检测到的是子类，要求的搜索类型和返回类型是父类，能否get
         * 不能get，还是需要使用T.class
         */
        return sheetService.findAllSheets();
    }





}
