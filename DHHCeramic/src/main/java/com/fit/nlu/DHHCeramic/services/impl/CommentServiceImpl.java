package com.fit.nlu.DHHCeramic.services.impl;


import com.fit.nlu.DHHCeramic.dao.CommentDao;
import com.fit.nlu.DHHCeramic.dao.impl.CommentDaoImpl;
import com.fit.nlu.DHHCeramic.model.Comment;
import com.fit.nlu.DHHCeramic.services.CommentService;

import java.util.List;

public class CommentServiceImpl implements CommentService {
    CommentDao commentDao = (CommentDao) new CommentDaoImpl();

    @Override
    public void insert(Comment comment) {
        commentDao.insert(comment);
    }

    @Override
    public void edit(Comment comment) {
        Comment oldComment = commentDao.get(comment.getId());
        oldComment.setContent(comment.getContent());
        oldComment.setRating(comment.getRating());
        oldComment.setTime(comment.getTime());


        commentDao.edit(oldComment);
    }

    @Override
    public void delete(int id) {
        commentDao.delete(id);
    }

    @Override
    public Comment get(int id) {
        return commentDao.get(id);
    }

    @Override
    public List<Comment> getAll() {
        return commentDao.getAll();
    }
    @Override
    public double getAverageRating(int productId){
        return commentDao.getAverageRating(productId);
    }
    @Override
    public int countComment(int productId){
        return commentDao.countComment(productId);
    }

}
