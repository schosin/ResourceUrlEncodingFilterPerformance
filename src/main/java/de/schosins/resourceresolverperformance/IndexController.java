package de.schosins.resourceresolverperformance;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class IndexController {

    @GetMapping
    String index(@RequestParam(defaultValue = "1") int links, Model model) {
        model.addAttribute("links", links);
        return "index";
    }

    @GetMapping("/{id}")
    String details(@PathVariable long id, Model model) {
        model.addAttribute("id", id);
        return "details";
    }

}
