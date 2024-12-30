package com.fit.nlu.DHHCeramic.services;



import com.fit.nlu.DHHCeramic.model.Comment;

import java.util.List;

public interface CommentService {
    void insert(Comment comment);

    void edit(Comment comment);

    void delete(int id);

    Comment get(int id);

    List<Comment> getAll();

    double getAverageRating(int productId);

    public int countComment(int productId);
}
