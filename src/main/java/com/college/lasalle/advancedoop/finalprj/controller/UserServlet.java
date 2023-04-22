package com.college.lasalle.advancedoop.finalprj.controller;

import com.college.lasalle.advancedoop.finalprj.dao.UserDao;
import com.college.lasalle.advancedoop.finalprj.model.Address;
import com.college.lasalle.advancedoop.finalprj.model.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "userServlet", value = "/user")
public class UserServlet extends HttpServlet {

    private UserDao userDao;

    public void init() {
        userDao = new UserDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        resp.setContentType("text/html");
//        // Hello
//        PrintWriter out = resp.getWriter();
//        out.println("<html><body>");
//        out.println("<h1>Test</h1>");
//        out.println("</body></html>");
        //doPost(req, resp);
        String servletParam = req.getParameter("servletParam");
        if(servletParam != null){
            switch (servletParam) {
                case "register":
                    resp.sendRedirect("user-register.jsp");
                    break;
                case "list":
                    resp.sendRedirect("display-users.jsp");
                    break;
                case "update":
                case "searchUpdate":
                    resp.sendRedirect("user-update.jsp");
                    break;
                case "delete":
                case "searchDelete":
                    resp.sendRedirect("user-delete.jsp");
                    break;
            }
        } else {
            resp.sendRedirect("index.jsp");
        }
//        if(servletParam.equals("register"))
//        {
//            resp.sendRedirect("user-register.jsp");
//        }
//        if(servletParam.equals("list"))
//        {
//            resp.sendRedirect("display-users.jsp");
//        }
//        if(servletParam.equals("update"))
//        {
//            //resp.sendRedirect("user-update.jsp");
//        }
//        if(servletParam.equals("delete"))
//        {
//            //resp.sendRedirect("user-delete.jsp");
//        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        //super.doPost(req, resp);
        resp.setContentType("text/html");
        String servletParam = req.getParameter("servletParam");

        try {
            switch (servletParam) {
                case "register":
                    insert(req,resp);
                    break;
                case "list":
                    list(req,resp);
                    break;
                case "update":
                    update(req,resp);
                    break;
                case "delete":
                    delete(req,resp);
                    break;
                case "searchUpdate":
                case "searchDelete":
                    search(req,resp);
                    break;
            }
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


//        if(servletParam.equals("register"))
//        {
//            // add code here
//        }
//        if(servletParam.equals("list"))
//        {
//            // edit code here
//        }
//        if(servletParam.equals("update"))
//        {
//            //resp.sendRedirect("user-update.jsp");
//        }
//        if(servletParam.equals("delete"))
//        {
//            //resp.sendRedirect("user-delete.jsp");
//        }

//        User user = new User();
//        Address address = new Address();
//
//        List<User> userList;
//
//        String firstName = req.getParameter("firstName");
//        String lastName = req.getParameter("lastName");
//        String username = req.getParameter("username");
//        String email = req.getParameter("email");
//        int age = Integer.parseInt(req.getParameter("age"));
//        String phoneNumber = req.getParameter("phoneNumber");
//        int streetNumber = Integer.parseInt(req.getParameter("streetNumber"));
//        String streetName = req.getParameter("streetName");
//        String city = req.getParameter("city");
//        String stateProvince = req.getParameter("stateProvince");
//        String country = req.getParameter("country");
//        String postalCode = req.getParameter("postalCode");
//
//        user.setUserId(User.getIdGenerator());
//        user.setFirstName(firstName);
//        user.setLastName(lastName);
//        user.setUsername(username);
//        user.setEmail(email);
//        user.setAge(age);
//        user.setPhoneNumber(phoneNumber);
//
//        address.setStreetNumber(streetNumber);
//        address.setStreetName(streetName);
//        address.setCity(city);
//        address.setStateProvince(stateProvince);
//        address.setCountry(country);
//        address.setPostalCode(postalCode);
//
//        user.setAddress(address);
//        RequestDispatcher dispatcher;
//
//        try {
//            String message = "";
//
//            if(userDao.insert(user)) {
//                message = "Username registered!";
//                //userList = getUserList();
//                //req.setAttribute("userList", userList);
//                //dispatcher = req.getRequestDispatcher("display-users.jsp");
//            }else{
////                req.setAttribute("errorMessage", "Username already exists!");
////                dispatcher = req.getRequestDispatcher("user-register.jsp");
//                message = "Username already exists!";
//            }
//
//            req.setAttribute("message", message);
//            dispatcher = req.getRequestDispatcher("user-register.jsp");
//            dispatcher.forward(req, resp);
//
//
////            RequestDispatcher dispatcher = req.getRequestDispatcher("display-users.jsp");
////
////            dispatcher.forward(req, resp);
////
////            req.setAttribute();
////
////            resp.sendRedirect("display-users.jsp");
//
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            req.setAttribute("message", e.getMessage());
//            dispatcher = req.getRequestDispatcher("user-register.jsp");
//            dispatcher.forward(req, resp);
//        }
//
////        RequestDispatcher dispatcher = req.getRequestDispatcher("display-users.jsp");
////
////        dispatcher.forward(req, resp);
////
////        resp.sendRedirect("display-users.jsp");
    }

//    private List<User> getUserList(HttpServletRequest req, HttpServletResponse resp){
//        List<User> userList = new ArrayList<>();
//        try {
//            userList = userDao.selectAll();
//            req.setAttribute("userList", userList);
//
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        return userList;
//    }

    private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> userList = new ArrayList<>();
        RequestDispatcher dispatcher;
        try {
            String message = "";
            userList = userDao.selectAll();
            req.setAttribute("userList", userList);
            if(userList.isEmpty()){
                message = "There are no users registered!";
            }
            req.setAttribute("message", message);
            dispatcher = req.getRequestDispatcher("display-users.jsp");
            dispatcher.forward(req, resp);
            resp.sendRedirect("display-users.jsp");

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            req.setAttribute("message", e.getMessage());
            dispatcher = req.getRequestDispatcher("display-users.jsp");
            dispatcher.forward(req, resp);
            resp.sendRedirect("display-users.jsp");
        }
    }

    private void insert(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        Address address = new Address();

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        int age = Integer.parseInt(req.getParameter("age"));
        String phoneNumber = req.getParameter("phoneNumber");
        int streetNumber = Integer.parseInt(req.getParameter("streetNumber"));
        String streetName = req.getParameter("streetName");
        String city = req.getParameter("city");
        String stateProvince = req.getParameter("stateProvince");
        String country = req.getParameter("country");
        String postalCode = req.getParameter("postalCode");

        //user.setUserId(User.getIdGenerator());
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setUsername(username);
        user.setEmail(email);
        user.setAge(age);
        user.setPhoneNumber(phoneNumber);

        address.setStreetNumber(streetNumber);
        address.setStreetName(streetName);
        address.setCity(city);
        address.setStateProvince(stateProvince);
        address.setCountry(country);
        address.setPostalCode(postalCode);

        user.setAddress(address);
        RequestDispatcher dispatcher;

        try {
            String message = "";

            if(userDao.insert(user)) {
                message = "Username registered!";
            }else{
                message = "Username already exists!";
            }

            req.setAttribute("message", message);
            dispatcher = req.getRequestDispatcher("user-register.jsp");
            dispatcher.forward(req, resp);
            resp.sendRedirect("user-register.jsp");

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            req.setAttribute("message", e.getMessage());
            dispatcher = req.getRequestDispatcher("user-register.jsp");
            dispatcher.forward(req, resp);
            resp.sendRedirect("user-register.jsp");
        }
    }

    public void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user;

        String username;
        if(req.getParameter("servletParam").equals("searchUpdate")){
            username = req.getParameter("usernameUpdateSearch");
        }else if(req.getParameter("servletParam").equals("searchDelete")){
            username = req.getParameter("usernameDeleteSearch");
        }else{
            username = req.getParameter("username");
        }
        //RequestDispatcher dispatcher;
        try {
            String message = "";
            user = userDao.searchUserByUsername(username);
            req.setAttribute("user", user);
            if(user == null){
                message = "User not found!";
            }
            req.setAttribute("message", message);

            dispatcherUpdateDelete(req, resp);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            req.setAttribute("message", e.getMessage());
            dispatcherUpdateDelete(req, resp);

        }
    }

    private void dispatcherUpdateDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        if(req.getParameter("servletParam").equals("searchUpdate")){
            dispatcher = req.getRequestDispatcher("user-update.jsp");
            dispatcher.forward(req, resp);
            resp.sendRedirect("user-update.jsp");
        }else if (req.getParameter("servletParam").equals("searchDelete")){
            dispatcher = req.getRequestDispatcher("user-delete.jsp");
            dispatcher.forward(req, resp);
            resp.sendRedirect("user-delete.jsp");
        }else {
//            dispatcher = req.getRequestDispatcher("index.jsp");
//            dispatcher.forward(req, resp);
            resp.sendRedirect("index.jsp");
        }
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        User userSearched;
        Address address = new Address();

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        int age = Integer.parseInt(req.getParameter("age"));
        String phoneNumber = req.getParameter("phoneNumber");
        int streetNumber = Integer.parseInt(req.getParameter("streetNumber"));
        String streetName = req.getParameter("streetName");
        String city = req.getParameter("city");
        String stateProvince = req.getParameter("stateProvince");
        String country = req.getParameter("country");
        String postalCode = req.getParameter("postalCode");

        //user.setUserId(User.getIdGenerator());
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setUsername(username);
        user.setEmail(email);
        user.setAge(age);
        user.setPhoneNumber(phoneNumber);

        address.setStreetNumber(streetNumber);
        address.setStreetName(streetName);
        address.setCity(city);
        address.setStateProvince(stateProvince);
        address.setCountry(country);
        address.setPostalCode(postalCode);

        user.setAddress(address);
        RequestDispatcher dispatcher;

        try {
            String message = "";
            userSearched = userDao.searchUserByUsername(username);
            if(userSearched != null){
                user.setUserId(userSearched.getUserId());
                if(userDao.update(user)) {
                    message = "Username updated!";
                }else{
                    message = "Error updating user!";
                }
            } else{
                message = "Username not found!";
            }

            req.setAttribute("message", message);
            dispatcher = req.getRequestDispatcher("user-update.jsp");
            dispatcher.forward(req, resp);
            resp.sendRedirect("user-update.jsp");

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            req.setAttribute("message", e.getMessage());
            dispatcher = req.getRequestDispatcher("user-update.jsp");
            dispatcher.forward(req, resp);
            resp.sendRedirect("user-update.jsp");
        }
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        User userSearched;
        Address address = new Address();

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        int age = Integer.parseInt(req.getParameter("age"));
        String phoneNumber = req.getParameter("phoneNumber");
        int streetNumber = Integer.parseInt(req.getParameter("streetNumber"));
        String streetName = req.getParameter("streetName");
        String city = req.getParameter("city");
        String stateProvince = req.getParameter("stateProvince");
        String country = req.getParameter("country");
        String postalCode = req.getParameter("postalCode");

        //user.setUserId(User.getIdGenerator());
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setUsername(username);
        user.setEmail(email);
        user.setAge(age);
        user.setPhoneNumber(phoneNumber);

        address.setStreetNumber(streetNumber);
        address.setStreetName(streetName);
        address.setCity(city);
        address.setStateProvince(stateProvince);
        address.setCountry(country);
        address.setPostalCode(postalCode);

        user.setAddress(address);
        RequestDispatcher dispatcher;

        try {
            String message = "";
            userSearched = userDao.searchUserByUsername(username);
            if(userSearched != null){
                user.setUserId(userSearched.getUserId());
                if(userDao.delete(user)) {
                    message = "Username deleted!";
                }else{
                    message = "Error deleting the user!";
                }
            } else{
                message = "Username not found!";
            }

            req.setAttribute("message", message);
            dispatcher = req.getRequestDispatcher("user-delete.jsp");
            dispatcher.forward(req, resp);
            resp.sendRedirect("user-delete.jsp");

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            req.setAttribute("message", e.getMessage());
            dispatcher = req.getRequestDispatcher("user-delete.jsp");
            dispatcher.forward(req, resp);
            resp.sendRedirect("user-delete.jsp");
        }
    }

    @Override
    public void destroy() {
        //super.destroy();
    }
}
