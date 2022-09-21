package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    //Handles request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    //Handles request at path /hello/goodbye
    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    //create handler that handles requests of form /hello?name=LaunchCode
//
//    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
//    public String helloWithQueryParam(@RequestParam String name) {
//        return "Hello, " + name + "!";
//    }

    //use path parameters; handles requests of form /hello/LaunchCode
//    @GetMapping("{name}")
//    public String helloWithPathParam(@PathVariable String name){
//        return "Hello, " + name + "!";
//    }

    // /hello/form
    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                "<body>" +
                    "<form action='/hello' method='post'>" + //submit a request to /hello
                        "<input type ='text' name='name'>" +
                            "<select name='language' id='language-select'>" +
                            "<option value=''> Please choose a language</option>" +
                            "<option value='French'>French</option>" +
                            "<option value='English'>English</option>" +
                            "<option value='Spanish'>Spanish</option>" +
                            "<option value='Hindi'>Hindi</option>" +
                            "<option value='Mandarin'>Mandarin</option>" +
                            "</select>" +
                        "<input type ='submit' value='Greet me!'>" +
                    "</form>" +
                "</body>" +
                "</html>";
    }


    @RequestMapping(method = RequestMethod.POST)
    public static String createMessage(@RequestParam String name, @RequestParam String language) {
        String greeting = "";
        if (language.equals("French")) {
            greeting = "Bonjour " + name + "!";
        } else if (language.equals("English")) {
            greeting = "Hello " + name + "!";
        } else if (language.equals("Spanish")) {
            greeting = "Hola " + name + "!";
        } else if (language.equals("Hindi")) {
            greeting = "Namaste " + name + "!";
        } else if (language.equals("Mandarin")) {
            greeting = "Ni Hao " + name + "!";
        }
        return greeting;
    }


}
