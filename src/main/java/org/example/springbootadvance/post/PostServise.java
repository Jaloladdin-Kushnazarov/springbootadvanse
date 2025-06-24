package org.example.springbootadvance.post;

import lombok.NonNull;

public interface PostServise {

    Post getPost(@NonNull Integer id) throws Exception;

}
