package giulio_marra.s6_l3.services;

import giulio_marra.s6_l3.entities.Post;
import giulio_marra.s6_l3.repositories.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PostService {
    @Autowired
    private PostRepo postRepo;

    public Page<Post> getPosts(int pageNumber, int pageSize, String sortBy) {
        if (pageSize > 10) pageSize = 10;
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));
        return postRepo.findAll(pageable);
    }

    public Post savePost(Post post) {
        if (postRepo.existsByTitolo(post.getTitolo())) {
            throw new RuntimeException();
        }
        return postRepo.save(post);
    }

    public Page<Post> getPostByAutore(int pageNumber, int pageSize, UUID uuid) {
        if (pageSize > 10) pageSize = 10;
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return postRepo.findByAutoreUuid(pageable, uuid);
    }

    public Post getById(UUID uuid) {
        return postRepo.findById(uuid).orElseThrow();
    }

    public void findByIdAndDelete(UUID uuid) {
        Post found = getById(uuid);
        postRepo.delete(found);
    }
}
