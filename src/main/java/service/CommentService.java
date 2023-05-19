package service;

import entity.Comment;
import general.BaseEntityService;
import repository.CommentRepository;

public class CommentService extends BaseEntityService<Comment, CommentRepository> {
    public CommentService(CommentRepository repository) {
        super(repository);
    }
}
