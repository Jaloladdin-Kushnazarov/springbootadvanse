package org.example.springbootadvance.resources;

import io.micrometer.common.lang.NonNull;

import lombok.extern.slf4j.Slf4j;
import org.example.springbootadvance.post.Post;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.client.Traverson;
import org.springframework.stereotype.Service;
import org.springframework.hateoas.MediaTypes;

import java.net.URI;
@Slf4j
@Service
public class CommentResource {

    @Value("${hateoas.url.base}")
    private String baseURL;

    public Post getPost(@NonNull Integer id) throws Exception {
        Traverson traverson = new Traverson(new URI(baseURL + id), MediaTypes.HAL_JSON);
        EntityModel<Post> entityModel = traverson
                .follow("self")
                .toObject(new ParameterizedTypeReference<>() {
                });
        if (entityModel == null)
            return null;
        for (Link link : entityModel.getLinks())
            log.info("Links From Hateoas API : " + link.getHref());
        return entityModel.getContent();
    }

}
