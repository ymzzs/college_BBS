package muzhou.com.service.serviceImpl;
import muzhou.com.dao.*;

import muzhou.com.dao.daoImpl.*;


public class BaseService {

    protected UserDao userDao = new UserDaoImpl();

    protected QuestionDao questionDao = new QuestionDaoImpl();

    protected AnswerDao answerDao = new AnswerDaoImpl();

    protected CommentDao commentDao = new CommentDaoImpl();

    protected CollectionDao collectionDao = new CollectionDaoImpl();

    protected FollowDao followDao = new FollowDaoImpl();

    protected MessageDao messageDao = new MessageDaoImpl();




}
