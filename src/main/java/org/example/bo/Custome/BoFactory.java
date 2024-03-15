package org.example.bo.Custome;

import org.example.bo.impl.*;

public class BoFactory {

        private static BoFactory boFactory;
        private BoFactory(){

        }
        public static BoFactory getBOFactory(){
            return (boFactory==null)?boFactory=new BoFactory():boFactory;
        }
        public enum BOTypes{
            BOOK,BOOKHANDOVER,BRANCH,HISTORY,TRANSACTION,USER

        }
        public SuperBo getBO(BOTypes boTypes){
            switch (boTypes){
                case BOOK:
                    return new BookBoimpl();
                case BOOKHANDOVER:
                    return new BookHandOverimpl();
                case BRANCH:
                    return new BranchBoimpl();
                case HISTORY:
                    return new HistoryBoimpl();
                case TRANSACTION:
                    return new TransactionBussiness();
                default:
                    return null;
            }
        }

    }

