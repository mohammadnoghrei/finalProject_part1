package madsilver.service;

import madsilver.base.service.BaseServiceImpl;

import madsilver.model.Comment;

import madsilver.repository.CommentRepository;
import org.hibernate.SessionFactory;

public class CommentServicesImpl extends BaseServiceImpl<Comment,Long, CommentRepository> implements CommentService{
    public CommentServicesImpl(CommentRepository repository, SessionFactory sessionFactory) {
        super(repository, sessionFactory);
    }
}
