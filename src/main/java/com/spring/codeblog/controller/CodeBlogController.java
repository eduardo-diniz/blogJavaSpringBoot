package com.spring.codeblog.controller;

import com.spring.codeblog.model.Post;
import com.spring.codeblog.service.Codeblogservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
public class CodeBlogController {

    @Autowired
    Codeblogservice codeblogservice;

    //ModelAndView = recebe requisições do cliente

    @RequestMapping(value = "/", method=RequestMethod.GET)
    public ModelAndView getPostse(){
        ModelAndView mv = new ModelAndView("posts");
        List<Post> posts = codeblogservice.findAll();
        mv.addObject("posts", posts);
        System.out.println(codeblogservice.findAll());
        return mv;

    }
    @RequestMapping(value = "/posts", method=RequestMethod.GET)
    public ModelAndView getPosts(){
        ModelAndView mv = new ModelAndView("posts");
        List<Post> posts = codeblogservice.findAll();
        mv.addObject("posts", posts);
        System.out.println(codeblogservice.findAll());
        return mv;

    }
    //@ResponseBody informa a um controlador que o objeto retornado é serializado automaticamente
    // em JSON e passado de volta para o objeto HttpResponse .

    @ResponseBody
    @RequestMapping(value = "/postsJson", method=RequestMethod.GET)
    public List<Post> getPost(){

        return codeblogservice.findAll();

    }

    @RequestMapping(value = "/posts/{id}",method=RequestMethod.GET)
    public ModelAndView getPostSpecific (@PathVariable("id") long id){
        ModelAndView mv = new ModelAndView("postSpecific");
        Post post = codeblogservice.findById(id);
        mv.addObject("post", post);
        return mv;
    }

@RequestMapping(value= "/newpost", method = RequestMethod.GET)
    public String getPostForm(){
        return "postForm";
}


@RequestMapping(value= "/newpost", method = RequestMethod.POST)
//@Valid Verifica se os atributos anotados com validaçãos estão sendo cumpridos.
//BindigResult nos da acesso aos erros de validação e conversão de uma requisição.
//RedirectAttributes  os valores dos atributos podem ser formatados como Strings para serem usados para uma URL de redirecionamento;
    public String savePost(@Valid Post post ,BindingResult result, RedirectAttributes atributes) {

    System.out.println(result.hasErrors());

    if (result.hasErrors()) {

        System.out.println(result.hasErrors());
        atributes.addFlashAttribute("message", "Verifique se os campos obrigatórios foram preenchidos");
        return "redirect:/newpost";
    } else {

          post.setData(LocalDate.now());
          codeblogservice.save(post);
          return "redirect:/posts";

    }

}

}

