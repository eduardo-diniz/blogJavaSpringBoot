package com.spring.codeblog.service.serviceimpl;

import com.spring.codeblog.model.Post;
import com.spring.codeblog.repository.CodeblogRepository;
import com.spring.codeblog.service.Codeblogservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//Anotação para o spring ler a classe como um bean, e assim criar pontos de injenção.
@Service
public class CodeblogServiceImpl implements Codeblogservice {

    //ponto de injenção do repositorio
    @Autowired
    CodeblogRepository codeblogRepository;

    //SObrescreve o metodo da classe implementada
    @Override
    public List<Post> findAll(){

        return codeblogRepository.findAll();
    }

    @Override
    public Post findById(long id) {
        //metodo findById retorna um optional, logo é necessario o .get para retorno o tipo especificado no metodo
        return codeblogRepository.findById(id).get();

    }

    @Override
    public Post save(Post post) {

        return codeblogRepository.save(post);

    }

}
