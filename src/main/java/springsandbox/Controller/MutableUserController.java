package springsandbox.Controller;

import org.springframework.web.bind.annotation.*;
import springsandbox.Entity.MutableUser;
import springsandbox.Services.MutableUserService;

import java.util.Collection;

@RestController
@RequestMapping("/mutable/")
public class MutableUserController {

    private final MutableUserService userService;

    public MutableUserController(MutableUserService userService) {
        this.userService = userService;
    }

    @GetMapping("find")
    public MutableUser find(@RequestParam String name) {
        return userService.find(name);
    }

    @GetMapping("findAll")
    public Collection<MutableUser> findAll() {
        return userService.findAll();
    }

    @GetMapping("rename")
    public MutableUser rename(@RequestParam String oldName, @RequestParam String newName) {
        return userService.rename(oldName, newName);
    }

    @GetMapping("create")
    public MutableUser create(@RequestParam String name) {
        return userService.create(name);
    }

    @GetMapping("delete")
    public String delete(@RequestParam String name) {
        userService.delete(name);
        return "user deleted: " + name;
    }

    @GetMapping("count")
    public String count() {
        return "mutable users count: " + userService.count();
    }

    @GetMapping("first")
    public MutableUser first() {
        return userService.first();
    }

    @GetMapping("last")
    public MutableUser last() {
        return userService.last();
    }
}
