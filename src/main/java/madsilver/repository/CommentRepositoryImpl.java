package madsilver.repository;

import madsilver.base.repository.BaseRepositoryImpl;
import madsilver.model.Comment;
import org.hibernate.SessionFactory;

public class CommentRepositoryImpl extends BaseRepositoryImpl<Comment,Long> implements CommentRepository{
    public CommentRepositoryImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Class<Comment> getEntityClass() {
        return Comment.class;
    }
}
