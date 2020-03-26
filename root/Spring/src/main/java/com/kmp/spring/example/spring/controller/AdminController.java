package com.kmp.spring.example.spring.controller;

import com.kmp.spring.example.spring.model.Ss_Admin;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @RequestMapping(value = "/updateAdmin", method = RequestMethod.POST, consumes = "application/json", headers = "Accept=application/json")
    public ResponseEntity<Ss_Admin> updateAdmin(@RequestBody Ss_Admin admin) {
        try {
//            ss_admin_dao.updateAdmin(admin);
            System.out.println("Save admin object.");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<>(admin, HttpStatus.OK);
    }

   /* @RequestMapping(value = "/test")
    @ResponseBody
    public String handleRequest () {
        Map<String, HandlerAdapter> matchingBeans = BeanFactoryUtils.beansOfTypeIncludingAncestors(
                (ListableBeanFactory) context, HandlerAdapter.class, true, false);

        matchingBeans.forEach((k, v) -> System.out.printf("%s=%s%n",
                k,
                v.getClass().getSimpleName()));
        return "response from /test";
    }*/
}
