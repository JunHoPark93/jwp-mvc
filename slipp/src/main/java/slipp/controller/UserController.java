package slipp.controller;

import nextstep.mvc.tobe.JsonView;
import nextstep.mvc.tobe.JspView;
import nextstep.mvc.tobe.ModelAndView;
import nextstep.web.annotation.Controller;
import nextstep.web.annotation.RequestMapping;
import nextstep.web.annotation.RequestMethod;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import slipp.domain.User;
import slipp.support.db.DataBase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

@Controller
public class UserController {

    @RequestMapping(value = "/users/create", method = RequestMethod.POST)
    public ModelAndView create(HttpServletRequest req, HttpServletResponse resp) {
        User user = new User(req.getParameter("userId"), req.getParameter("password"), req.getParameter("name"),
                req.getParameter("email"));

        DataBase.addUser(user);

        return new ModelAndView(new JspView("redirect:/"));
    }

    @RequestMapping(value = "/api/users", method = RequestMethod.POST)
    public void create2(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        User user = new User(req.getParameter("userId"), req.getParameter("password"), req.getParameter("name"),
                req.getParameter("email"));

        DataBase.addUser(user);

        resp.setStatus(201);

        new JsonView().render(new HashMap<>(), req, resp);
    }

    @RequestMapping(value = "/api/users", method = RequestMethod.GET)
    public void create3(HttpServletRequest req, HttpServletResponse resp) throws Exception {
//        User user = new User(req.getParameter("userId"), req.getParameter("password"), req.getParameter("name"),
//                req.getParameter("email"));
//
//        DataBase.addUser(user);

        resp.setStatus(404);

        new JsonView().render(new HashMap<>(), req, resp);
    }
}