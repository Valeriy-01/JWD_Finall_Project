package by.tc.finalproject.service.impl;

import by.tc.finalproject.bean.State;
import by.tc.finalproject.bean.User;
import by.tc.finalproject.bean.UserAccess;
import by.tc.finalproject.dao.DAOProvider;
import by.tc.finalproject.dao.UserAccessDAO;
import by.tc.finalproject.dao.UserDAO;
import by.tc.finalproject.dao.exception.DAOException;
import by.tc.finalproject.service.UserService;
import by.tc.finalproject.service.exception.ServiceException;

public class UserServiceImpl implements UserService{

    @Override
    public boolean authorization(String email, String password) throws ServiceException {
        DAOProvider provider = DAOProvider.getInstance();
        UserAccessDAO userAccessDAO = provider.getUserAccessDAO();
        try {
            return userAccessDAO.isExistLoginUserAccess(email, password);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean registration(User user,UserAccess userAccess,State state,String facultyTitle) throws ServiceException {
        DAOProvider provider = DAOProvider.getInstance();
        UserDAO userDAO = provider.getUserDAO();
        boolean registered = false;
        try {
            registered = userDAO.addUser(user, userAccess, state, facultyTitle);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return registered;
    }

}
