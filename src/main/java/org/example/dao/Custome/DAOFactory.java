package org.example.dao.Custome;

import org.example.Entity.Book;
import org.example.dao.impl.*;

public class DAOFactory {

        private static DAOFactory daoFactory;
        private DAOFactory(){
        }
        public static DAOFactory getDaoFactory(){
            return (daoFactory==null)?daoFactory=new DAOFactory():daoFactory;
        }
        public enum DAOTypes{

           BOOK,BOOKHANDOVER,BRANCH,HISTORY,TRANSACTION,USER
        }
        public SuperDao getDAO(DAOTypes daoTypes){
            switch (daoTypes){
                case BOOK:
                    return new BookDaoimpl();
                case BOOKHANDOVER:
                    return new BookHandOverDaoimpl();
                case BRANCH:
                    return new BranchDaoimpl();
                case HISTORY:
                    return new HistoryDaoimpl();
                case USER:
                    return new UserDaoimpl();
                default:
                    return null;
            }
        }
    }

